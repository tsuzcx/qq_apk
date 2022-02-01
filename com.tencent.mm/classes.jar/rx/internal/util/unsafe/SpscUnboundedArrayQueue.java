package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Iterator;
import sun.misc.Unsafe;

public class SpscUnboundedArrayQueue<E>
  extends SpscUnboundedArrayQueueConsumerField<E>
  implements QueueProgressIndicators
{
  private static final long C_INDEX_OFFSET;
  private static final Object HAS_NEXT;
  static final int MAX_LOOK_AHEAD_STEP;
  private static final long P_INDEX_OFFSET;
  private static final long REF_ARRAY_BASE;
  private static final int REF_ELEMENT_SHIFT;
  
  static
  {
    AppMethodBeat.i(90184);
    MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    HAS_NEXT = new Object();
    int i = UnsafeAccess.UNSAFE.arrayIndexScale([Ljava.lang.Object.class);
    if (4 == i) {}
    for (REF_ELEMENT_SHIFT = 2;; REF_ELEMENT_SHIFT = 3)
    {
      REF_ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset([Ljava.lang.Object.class);
      try
      {
        localObject = SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex");
        P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset((Field)localObject);
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Object localObject;
        localInternalError = new InternalError();
        localInternalError.initCause(localNoSuchFieldException1);
        AppMethodBeat.o(90184);
        throw localInternalError;
      }
      try
      {
        localObject = SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex");
        C_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset((Field)localObject);
        AppMethodBeat.o(90184);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localInternalError = new InternalError();
        localInternalError.initCause(localNoSuchFieldException2);
        AppMethodBeat.o(90184);
        throw localInternalError;
      }
      if (8 != i) {
        break;
      }
    }
    localObject = new IllegalStateException("Unknown pointer size");
    AppMethodBeat.o(90184);
    throw ((Throwable)localObject);
  }
  
  public SpscUnboundedArrayQueue(int paramInt)
  {
    AppMethodBeat.i(90162);
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    long l = paramInt - 1;
    Object[] arrayOfObject = (Object[])new Object[paramInt + 1];
    this.producerBuffer = arrayOfObject;
    this.producerMask = l;
    adjustLookAheadStep(paramInt);
    this.consumerBuffer = arrayOfObject;
    this.consumerMask = l;
    this.producerLookAhead = (l - 1L);
    soProducerIndex(0L);
    AppMethodBeat.o(90162);
  }
  
  private void adjustLookAheadStep(int paramInt)
  {
    AppMethodBeat.i(90174);
    this.producerLookAheadStep = Math.min(paramInt / 4, MAX_LOOK_AHEAD_STEP);
    AppMethodBeat.o(90174);
  }
  
  private static long calcDirectOffset(long paramLong)
  {
    return REF_ARRAY_BASE + (paramLong << REF_ELEMENT_SHIFT);
  }
  
  private static long calcWrappedOffset(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(90179);
    paramLong1 = calcDirectOffset(paramLong1 & paramLong2);
    AppMethodBeat.o(90179);
    return paramLong1;
  }
  
  private long lvConsumerIndex()
  {
    AppMethodBeat.i(90176);
    long l = UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    AppMethodBeat.o(90176);
    return l;
  }
  
  private static <E> Object lvElement(E[] paramArrayOfE, long paramLong)
  {
    AppMethodBeat.i(90181);
    paramArrayOfE = UnsafeAccess.UNSAFE.getObjectVolatile(paramArrayOfE, paramLong);
    AppMethodBeat.o(90181);
    return paramArrayOfE;
  }
  
  private E[] lvNext(E[] paramArrayOfE)
  {
    AppMethodBeat.i(90168);
    paramArrayOfE = (Object[])lvElement(paramArrayOfE, calcDirectOffset(paramArrayOfE.length - 1));
    AppMethodBeat.o(90168);
    return paramArrayOfE;
  }
  
  private long lvProducerIndex()
  {
    AppMethodBeat.i(90175);
    long l = UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    AppMethodBeat.o(90175);
    return l;
  }
  
  private E newBufferPeek(E[] paramArrayOfE, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(90172);
    this.consumerBuffer = paramArrayOfE;
    paramArrayOfE = lvElement(paramArrayOfE, calcWrappedOffset(paramLong1, paramLong2));
    AppMethodBeat.o(90172);
    return paramArrayOfE;
  }
  
  private E newBufferPoll(E[] paramArrayOfE, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(90170);
    this.consumerBuffer = paramArrayOfE;
    paramLong2 = calcWrappedOffset(paramLong1, paramLong2);
    Object localObject = lvElement(paramArrayOfE, paramLong2);
    if (localObject == null)
    {
      AppMethodBeat.o(90170);
      return null;
    }
    soElement(paramArrayOfE, paramLong2, null);
    soConsumerIndex(1L + paramLong1);
    AppMethodBeat.o(90170);
    return localObject;
  }
  
  private void resize(E[] paramArrayOfE, long paramLong1, long paramLong2, E paramE, long paramLong3)
  {
    AppMethodBeat.i(90166);
    Object[] arrayOfObject = (Object[])new Object[paramArrayOfE.length];
    this.producerBuffer = arrayOfObject;
    this.producerLookAhead = (paramLong1 + paramLong3 - 1L);
    soElement(arrayOfObject, paramLong2, paramE);
    soNext(paramArrayOfE, arrayOfObject);
    soElement(paramArrayOfE, paramLong2, HAS_NEXT);
    soProducerIndex(1L + paramLong1);
    AppMethodBeat.o(90166);
  }
  
  private void soConsumerIndex(long paramLong)
  {
    AppMethodBeat.i(90178);
    UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, paramLong);
    AppMethodBeat.o(90178);
  }
  
  private static void soElement(Object[] paramArrayOfObject, long paramLong, Object paramObject)
  {
    AppMethodBeat.i(90180);
    UnsafeAccess.UNSAFE.putOrderedObject(paramArrayOfObject, paramLong, paramObject);
    AppMethodBeat.o(90180);
  }
  
  private void soNext(E[] paramArrayOfE1, E[] paramArrayOfE2)
  {
    AppMethodBeat.i(90167);
    soElement(paramArrayOfE1, calcDirectOffset(paramArrayOfE1.length - 1), paramArrayOfE2);
    AppMethodBeat.o(90167);
  }
  
  private void soProducerIndex(long paramLong)
  {
    AppMethodBeat.i(90177);
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, paramLong);
    AppMethodBeat.o(90177);
  }
  
  private boolean writeToQueue(E[] paramArrayOfE, E paramE, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(90165);
    soElement(paramArrayOfE, paramLong2, paramE);
    soProducerIndex(1L + paramLong1);
    AppMethodBeat.o(90165);
    return true;
  }
  
  public long currentConsumerIndex()
  {
    AppMethodBeat.i(90183);
    long l = lvConsumerIndex();
    AppMethodBeat.o(90183);
    return l;
  }
  
  public long currentProducerIndex()
  {
    AppMethodBeat.i(90182);
    long l = lvProducerIndex();
    AppMethodBeat.o(90182);
    return l;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(90163);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(90163);
    throw localUnsupportedOperationException;
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(90164);
    if (paramE == null)
    {
      paramE = new NullPointerException("Null is not a valid element");
      AppMethodBeat.o(90164);
      throw paramE;
    }
    Object[] arrayOfObject = this.producerBuffer;
    long l1 = this.producerIndex;
    long l2 = this.producerMask;
    long l3 = calcWrappedOffset(l1, l2);
    boolean bool;
    if (l1 < this.producerLookAhead)
    {
      bool = writeToQueue(arrayOfObject, paramE, l1, l3);
      AppMethodBeat.o(90164);
      return bool;
    }
    int i = this.producerLookAheadStep;
    if (lvElement(arrayOfObject, calcWrappedOffset(i + l1, l2)) == null)
    {
      this.producerLookAhead = (i + l1 - 1L);
      bool = writeToQueue(arrayOfObject, paramE, l1, l3);
      AppMethodBeat.o(90164);
      return bool;
    }
    if (lvElement(arrayOfObject, calcWrappedOffset(1L + l1, l2)) != null)
    {
      bool = writeToQueue(arrayOfObject, paramE, l1, l3);
      AppMethodBeat.o(90164);
      return bool;
    }
    resize(arrayOfObject, l1, l3, paramE, l2);
    AppMethodBeat.o(90164);
    return true;
  }
  
  public final E peek()
  {
    AppMethodBeat.i(90171);
    Object localObject1 = this.consumerBuffer;
    long l1 = this.consumerIndex;
    long l2 = this.consumerMask;
    Object localObject2 = lvElement((Object[])localObject1, calcWrappedOffset(l1, l2));
    if (localObject2 == HAS_NEXT)
    {
      localObject1 = newBufferPeek(lvNext((Object[])localObject1), l1, l2);
      AppMethodBeat.o(90171);
      return localObject1;
    }
    AppMethodBeat.o(90171);
    return localObject2;
  }
  
  public final E poll()
  {
    AppMethodBeat.i(90169);
    Object localObject1 = this.consumerBuffer;
    long l1 = this.consumerIndex;
    long l2 = this.consumerMask;
    long l3 = calcWrappedOffset(l1, l2);
    Object localObject2 = lvElement((Object[])localObject1, l3);
    if (localObject2 == HAS_NEXT) {}
    for (int i = 1; (localObject2 != null) && (i == 0); i = 0)
    {
      soElement((Object[])localObject1, l3, null);
      soConsumerIndex(l1 + 1L);
      AppMethodBeat.o(90169);
      return localObject2;
    }
    if (i != 0)
    {
      localObject1 = newBufferPoll(lvNext((Object[])localObject1), l1, l2);
      AppMethodBeat.o(90169);
      return localObject1;
    }
    AppMethodBeat.o(90169);
    return null;
  }
  
  public final int size()
  {
    AppMethodBeat.i(90173);
    long l2;
    for (long l1 = lvConsumerIndex();; l1 = l2)
    {
      long l3 = lvProducerIndex();
      l2 = lvConsumerIndex();
      if (l1 == l2)
      {
        int i = (int)(l3 - l2);
        AppMethodBeat.o(90173);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscUnboundedArrayQueue
 * JD-Core Version:    0.7.0.1
 */