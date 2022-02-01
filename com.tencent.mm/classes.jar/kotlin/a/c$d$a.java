package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"kotlin/collections/AbstractMap$values$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class c$d$a
  implements Iterator<V>, a
{
  c$d$a(Iterator paramIterator) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(191131);
    boolean bool = this.aivi.hasNext();
    AppMethodBeat.o(191131);
    return bool;
  }
  
  public final V next()
  {
    AppMethodBeat.i(191134);
    Object localObject = ((Map.Entry)this.aivi.next()).getValue();
    AppMethodBeat.o(191134);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(191139);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191139);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.c.d.a
 * JD-Core Version:    0.7.0.1
 */