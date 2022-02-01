package rx.internal.util.unsafe;

import rx.internal.util.a.b;
import sun.misc.Unsafe;

abstract class BaseLinkedQueueConsumerNodeRef<E>
  extends BaseLinkedQueuePad1<E>
{
  protected static final long C_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
  protected b<E> consumerNode;
  
  protected final b<E> lpConsumerNode()
  {
    return this.consumerNode;
  }
  
  protected final b<E> lvConsumerNode()
  {
    return (b)UnsafeAccess.UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
  }
  
  protected final void spConsumerNode(b<E> paramb)
  {
    this.consumerNode = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef
 * JD-Core Version:    0.7.0.1
 */