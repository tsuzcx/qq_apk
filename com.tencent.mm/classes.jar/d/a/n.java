package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.l;
import java.util.Enumeration;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, fvw=1)
public class n
  extends m
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    public a(Enumeration<T> paramEnumeration) {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129229);
      boolean bool = this.Jgh.hasMoreElements();
      AppMethodBeat.o(129229);
      return bool;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129230);
      Object localObject = this.Jgh.nextElement();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.n
 * JD-Core Version:    0.7.0.1
 */