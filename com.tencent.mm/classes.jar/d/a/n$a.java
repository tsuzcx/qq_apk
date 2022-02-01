package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.l;
import java.util.Enumeration;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class n$a
  implements a, Iterator<T>
{
  public n$a(Enumeration<T> paramEnumeration) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(129229);
    boolean bool = this.NhD.hasMoreElements();
    AppMethodBeat.o(129229);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(129230);
    Object localObject = this.NhD.nextElement();
    AppMethodBeat.o(129230);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(129231);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129231);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.a.n.a
 * JD-Core Version:    0.7.0.1
 */