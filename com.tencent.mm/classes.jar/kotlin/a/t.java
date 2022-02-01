package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class t
  extends s
{
  public static final <T> Iterator<T> a(Enumeration<T> paramEnumeration)
  {
    AppMethodBeat.i(191005);
    kotlin.g.b.s.u(paramEnumeration, "$this$iterator");
    paramEnumeration = (Iterator)new a(paramEnumeration);
    AppMethodBeat.o(191005);
    return paramEnumeration;
  }
  
  @Metadata(d1={""}, d2={"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<T>, a
  {
    a(Enumeration<T> paramEnumeration) {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129229);
      boolean bool = this.aivu.hasMoreElements();
      AppMethodBeat.o(129229);
      return bool;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129230);
      Object localObject = this.aivu.nextElement();
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
 * Qualified Name:     kotlin.a.t
 * JD-Core Version:    0.7.0.1
 */