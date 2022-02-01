package rx.internal.util.unsafe;

import java.util.AbstractQueue;

abstract class SpscUnboundedArrayQueueProducerFields<E>
  extends AbstractQueue<E>
{
  protected long producerIndex;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscUnboundedArrayQueueProducerFields
 * JD-Core Version:    0.7.0.1
 */