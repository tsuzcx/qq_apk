package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.util.a.b;

public final class SpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public SpscLinkedQueue()
  {
    AppMethodBeat.i(90158);
    spProducerNode(new b());
    spConsumerNode(this.producerNode);
    this.consumerNode.lazySet(null);
    AppMethodBeat.o(90158);
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(90159);
    if (paramE == null)
    {
      paramE = new NullPointerException("null elements not allowed");
      AppMethodBeat.o(90159);
      throw paramE;
    }
    paramE = new b(paramE);
    this.producerNode.lazySet(paramE);
    this.producerNode = paramE;
    AppMethodBeat.o(90159);
    return true;
  }
  
  public final E peek()
  {
    AppMethodBeat.i(90161);
    Object localObject = (b)this.consumerNode.get();
    if (localObject != null)
    {
      localObject = ((b)localObject).value;
      AppMethodBeat.o(90161);
      return localObject;
    }
    AppMethodBeat.o(90161);
    return null;
  }
  
  public final E poll()
  {
    AppMethodBeat.i(90160);
    b localb = (b)this.consumerNode.get();
    if (localb != null)
    {
      Object localObject = localb.iWd();
      this.consumerNode = localb;
      AppMethodBeat.o(90160);
      return localObject;
    }
    AppMethodBeat.o(90160);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscLinkedQueue
 * JD-Core Version:    0.7.0.1
 */