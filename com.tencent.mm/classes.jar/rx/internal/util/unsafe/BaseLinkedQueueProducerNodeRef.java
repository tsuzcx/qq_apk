package rx.internal.util.unsafe;

import rx.internal.util.a.b;
import sun.misc.Unsafe;

abstract class BaseLinkedQueueProducerNodeRef<E>
  extends BaseLinkedQueuePad0<E>
{
  protected static final long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");
  protected b<E> producerNode;
  
  protected final b<E> lpProducerNode()
  {
    return this.producerNode;
  }
  
  protected final b<E> lvProducerNode()
  {
    return (b)UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
  }
  
  protected final void spProducerNode(b<E> paramb)
  {
    this.producerNode = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef
 * JD-Core Version:    0.7.0.1
 */