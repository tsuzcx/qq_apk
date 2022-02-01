package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SpmcArrayQueue<E>
  extends SpmcArrayQueueL3Pad<E>
{
  public SpmcArrayQueue(int paramInt)
  {
    super(paramInt);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(90157);
    if (lvConsumerIndex() == lvProducerIndex())
    {
      AppMethodBeat.o(90157);
      return true;
    }
    AppMethodBeat.o(90157);
    return false;
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(90153);
    if (paramE == null)
    {
      paramE = new NullPointerException("Null is not a valid element");
      AppMethodBeat.o(90153);
      throw paramE;
    }
    Object[] arrayOfObject = this.buffer;
    long l1 = this.mask;
    long l2 = lvProducerIndex();
    long l3 = calcElementOffset(l2);
    if (lvElement(arrayOfObject, l3) != null)
    {
      if (l2 - lvConsumerIndex() > l1)
      {
        AppMethodBeat.o(90153);
        return false;
      }
      while (lvElement(arrayOfObject, l3) != null) {}
    }
    spElement(arrayOfObject, l3, paramE);
    soTail(1L + l2);
    AppMethodBeat.o(90153);
    return true;
  }
  
  public final E peek()
  {
    AppMethodBeat.i(90155);
    long l1 = lvProducerIndexCache();
    Object localObject;
    do
    {
      long l2 = lvConsumerIndex();
      if (l2 >= l1)
      {
        long l3 = lvProducerIndex();
        if (l2 >= l3)
        {
          AppMethodBeat.o(90155);
          return null;
        }
        svProducerIndexCache(l3);
      }
      localObject = lvElement(calcElementOffset(l2));
    } while (localObject == null);
    AppMethodBeat.o(90155);
    return localObject;
  }
  
  public final E poll()
  {
    AppMethodBeat.i(90154);
    long l1 = lvProducerIndexCache();
    long l2;
    do
    {
      l2 = lvConsumerIndex();
      if (l2 >= l1)
      {
        long l3 = lvProducerIndex();
        if (l2 >= l3)
        {
          AppMethodBeat.o(90154);
          return null;
        }
        svProducerIndexCache(l3);
      }
    } while (!casHead(l2, 1L + l2));
    l1 = calcElementOffset(l2);
    Object[] arrayOfObject = this.buffer;
    Object localObject = lpElement(arrayOfObject, l1);
    soElement(arrayOfObject, l1, null);
    AppMethodBeat.o(90154);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(90156);
    long l2;
    for (long l1 = lvConsumerIndex();; l1 = l2)
    {
      long l3 = lvProducerIndex();
      l2 = lvConsumerIndex();
      if (l1 == l2)
      {
        int i = (int)(l3 - l2);
        AppMethodBeat.o(90156);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.unsafe.SpmcArrayQueue
 * JD-Core Version:    0.7.0.1
 */