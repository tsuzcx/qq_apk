package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"kotlin/collections/AbstractMap$keys$1$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class c$b$a
  implements Iterator<K>, a
{
  c$b$a(Iterator paramIterator) {}
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(191126);
    boolean bool = this.aivi.hasNext();
    AppMethodBeat.o(191126);
    return bool;
  }
  
  public final K next()
  {
    AppMethodBeat.i(191132);
    Object localObject = ((Map.Entry)this.aivi.next()).getKey();
    AppMethodBeat.o(191132);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(191135);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191135);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */