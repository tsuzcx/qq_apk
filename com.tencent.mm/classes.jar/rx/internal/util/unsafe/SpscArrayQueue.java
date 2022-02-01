package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import sun.misc.Unsafe;

public final class SpscArrayQueue<E>
  extends SpscArrayQueueL3Pad<E>
{
  public SpscArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  private long lvConsumerIndex()
  {
    AppMethodBeat.i(90139);
    long l = UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    AppMethodBeat.o(90139);
    return l;
  }
  
  private long lvProducerIndex()
  {
    AppMethodBeat.i(90138);
    long l = UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    AppMethodBeat.o(90138);
    return l;
  }
  
  private void soConsumerIndex(long paramLong)
  {
    AppMethodBeat.i(90137);
    UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, paramLong);
    AppMethodBeat.o(90137);
  }
  
  private void soProducerIndex(long paramLong)
  {
    AppMethodBeat.i(90136);
    UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, paramLong);
    AppMethodBeat.o(90136);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(90135);
    if (lvProducerIndex() == lvConsumerIndex())
    {
      AppMethodBeat.o(90135);
      return true;
    }
    AppMethodBeat.o(90135);
    return false;
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(90131);
    if (paramE == null)
    {
      paramE = new NullPointerException("null elements not allowed");
      AppMethodBeat.o(90131);
      throw paramE;
    }
    Object[] arrayOfObject = this.buffer;
    long l1 = this.producerIndex;
    long l2 = calcElementOffset(l1);
    if (lvElement(arrayOfObject, l2) != null)
    {
      AppMethodBeat.o(90131);
      return false;
    }
    soElement(arrayOfObject, l2, paramE);
    soProducerIndex(1L + l1);
    AppMethodBeat.o(90131);
    return true;
  }
  
  public final E peek()
  {
    AppMethodBeat.i(90133);
    Object localObject = lvElement(calcElementOffset(this.consumerIndex));
    AppMethodBeat.o(90133);
    return localObject;
  }
  
  public final E poll()
  {
    AppMethodBeat.i(90132);
    long l1 = this.consumerIndex;
    long l2 = calcElementOffset(l1);
    Object[] arrayOfObject = this.buffer;
    Object localObject = lvElement(arrayOfObject, l2);
    if (localObject == null)
    {
      AppMethodBeat.o(90132);
      return null;
    }
    soElement(arrayOfObject, l2, null);
    soConsumerIndex(l1 + 1L);
    AppMethodBeat.o(90132);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(90134);
    long l2;
    for (long l1 = lvConsumerIndex();; l1 = l2)
    {
      long l3 = lvProducerIndex();
      l2 = lvConsumerIndex();
      if (l1 == l2)
      {
        int i = (int)(l3 - l2);
        AppMethodBeat.o(90134);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscArrayQueue
 * JD-Core Version:    0.7.0.1
 */