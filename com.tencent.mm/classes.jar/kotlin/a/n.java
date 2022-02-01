package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, iBN=1)
public class n
  extends m
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    implements Iterator<T>, a
  {
    public a(Enumeration<T> paramEnumeration) {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129229);
      boolean bool = this.aazZ.hasMoreElements();
      AppMethodBeat.o(129229);
      return bool;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129230);
      Object localObject = this.aazZ.nextElement();
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
 * Qualified Name:     kotlin.a.n
 * JD-Core Version:    0.7.0.1
 */