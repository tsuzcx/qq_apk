package rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueConsumerColdField<E>
  extends SpscUnboundedArrayQueueL2Pad<E>
{
  protected E[] consumerBuffer;
  protected long consumerMask;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscUnboundedArrayQueueConsumerColdField
 * JD-Core Version:    0.7.0.1
 */