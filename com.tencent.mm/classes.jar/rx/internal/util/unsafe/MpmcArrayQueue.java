package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MpmcArrayQueue<E>
  extends MpmcArrayQueueConsumerField<E>
{
  long p30;
  long p31;
  long p32;
  long p33;
  long p34;
  long p35;
  long p36;
  long p37;
  long p40;
  long p41;
  long p42;
  long p43;
  long p44;
  long p45;
  long p46;
  
  public MpmcArrayQueue(int paramInt)
  {
    super(Math.max(2, paramInt));
    AppMethodBeat.i(90140);
    AppMethodBeat.o(90140);
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(90145);
    if (lvConsumerIndex() == lvProducerIndex())
    {
      AppMethodBeat.o(90145);
      return true;
    }
    AppMethodBeat.o(90145);
    return false;
  }
  
  public boolean offer(E paramE)
  {
    AppMethodBeat.i(90141);
    if (paramE == null)
    {
      paramE = new NullPointerException("Null is not a valid element");
      AppMethodBeat.o(90141);
      throw paramE;
    }
    long l3 = this.mask + 1L;
    long[] arrayOfLong = this.sequenceBuffer;
    long l1;
    for (long l2 = 9223372036854775807L;; l2 = l1)
    {
      long l4 = lvProducerIndex();
      long l5 = calcSequenceOffset(l4);
      long l6 = lvSequence(arrayOfLong, l5) - l4;
      if (l6 == 0L)
      {
        l1 = l2;
        if (casProducerIndex(l4, 1L + l4))
        {
          spElement(calcElementOffset(l4), paramE);
          soSequence(arrayOfLong, l5, 1L + l4);
          AppMethodBeat.o(90141);
          return true;
        }
      }
      else
      {
        l1 = l2;
        if (l6 < 0L)
        {
          l1 = l2;
          if (l4 - l3 <= l2)
          {
            l2 = lvConsumerIndex();
            l1 = l2;
            if (l4 - l3 <= l2)
            {
              AppMethodBeat.o(90141);
              return false;
            }
          }
        }
      }
    }
  }
  
  public E peek()
  {
    AppMethodBeat.i(90143);
    long l;
    Object localObject;
    do
    {
      l = lvConsumerIndex();
      localObject = lpElement(calcElementOffset(l));
    } while ((localObject == null) && (l != lvProducerIndex()));
    AppMethodBeat.o(90143);
    return localObject;
  }
  
  public E poll()
  {
    AppMethodBeat.i(90142);
    long[] arrayOfLong = this.sequenceBuffer;
    long l1;
    for (long l2 = -1L;; l2 = l1)
    {
      long l3 = lvConsumerIndex();
      long l4 = calcSequenceOffset(l3);
      long l5 = lvSequence(arrayOfLong, l4) - (1L + l3);
      if (l5 == 0L)
      {
        l1 = l2;
        if (casConsumerIndex(l3, 1L + l3))
        {
          l1 = calcElementOffset(l3);
          Object localObject = lpElement(l1);
          spElement(l1, null);
          soSequence(arrayOfLong, l4, this.mask + l3 + 1L);
          AppMethodBeat.o(90142);
          return localObject;
        }
      }
      else
      {
        l1 = l2;
        if (l5 < 0L)
        {
          l1 = l2;
          if (l3 >= l2)
          {
            l2 = lvProducerIndex();
            l1 = l2;
            if (l3 == l2)
            {
              AppMethodBeat.o(90142);
              return null;
            }
          }
        }
      }
    }
  }
  
  public int size()
  {
    AppMethodBeat.i(90144);
    long l2;
    for (long l1 = lvConsumerIndex();; l1 = l2)
    {
      long l3 = lvProducerIndex();
      l2 = lvConsumerIndex();
      if (l1 == l2)
      {
        int i = (int)(l3 - l2);
        AppMethodBeat.o(90144);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.unsafe.MpmcArrayQueue
 * JD-Core Version:    0.7.0.1
 */