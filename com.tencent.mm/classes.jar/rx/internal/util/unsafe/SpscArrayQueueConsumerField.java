package rx.internal.util.unsafe;

abstract class SpscArrayQueueConsumerField<E>
  extends SpscArrayQueueL2Pad<E>
{
  protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueConsumerField.class, "consumerIndex");
  protected long consumerIndex;
  
  public SpscArrayQueueConsumerField(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscArrayQueueConsumerField
 * JD-Core Version:    0.7.0.1
 */