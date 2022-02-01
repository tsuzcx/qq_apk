package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.util.a.b;
import sun.misc.Unsafe;

public final class MpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public MpscLinkedQueue()
  {
    AppMethodBeat.i(90146);
    this.consumerNode = new b();
    xchgProducerNode(this.consumerNode);
    AppMethodBeat.o(90146);
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(90148);
    if (paramE == null)
    {
      paramE = new NullPointerException("null elements not allowed");
      AppMethodBeat.o(90148);
      throw paramE;
    }
    paramE = new b(paramE);
    xchgProducerNode(paramE).lazySet(paramE);
    AppMethodBeat.o(90148);
    return true;
  }
  
  public final E peek()
  {
    AppMethodBeat.i(90150);
    Object localObject = this.consumerNode;
    b localb = (b)((b)localObject).get();
    if (localb != null)
    {
      localObject = localb.value;
      AppMethodBeat.o(90150);
      return localObject;
    }
    if (localObject != lvProducerNode())
    {
      do
      {
        localb = (b)((b)localObject).get();
      } while (localb == null);
      localObject = localb.value;
      AppMethodBeat.o(90150);
      return localObject;
    }
    AppMethodBeat.o(90150);
    return null;
  }
  
  public final E poll()
  {
    AppMethodBeat.i(90149);
    Object localObject = lpConsumerNode();
    b localb = (b)((b)localObject).get();
    if (localb != null)
    {
      localObject = localb.gzj();
      spConsumerNode(localb);
      AppMethodBeat.o(90149);
      return localObject;
    }
    if (localObject != lvProducerNode())
    {
      do
      {
        localb = (b)((b)localObject).get();
      } while (localb == null);
      localObject = localb.gzj();
      this.consumerNode = localb;
      AppMethodBeat.o(90149);
      return localObject;
    }
    AppMethodBeat.o(90149);
    return null;
  }
  
  protected final b<E> xchgProducerNode(b<E> paramb)
  {
    AppMethodBeat.i(90147);
    b localb;
    do
    {
      localb = this.producerNode;
    } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, localb, paramb));
    paramb = (b)localb;
    AppMethodBeat.o(90147);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.unsafe.MpscLinkedQueue
 * JD-Core Version:    0.7.0.1
 */