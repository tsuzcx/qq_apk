package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentMap;

final class b$j<K, V>
  extends b.i<K, V>
  implements c<K, V>
{
  static
  {
    AppMethodBeat.i(60524);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(60524);
      return;
    }
  }
  
  public b$j(b paramb, ConcurrentMap<K, Object> paramConcurrentMap, kotlin.g.a.b<? super K, ? extends V> paramb1)
  {
    super(paramb, paramConcurrentMap, paramb1);
    AppMethodBeat.i(60522);
    AppMethodBeat.o(60522);
  }
  
  public final V invoke(K paramK)
  {
    AppMethodBeat.i(60523);
    paramK = super.invoke(paramK);
    if ((!$assertionsDisabled) && (paramK == null))
    {
      paramK = new AssertionError("compute() returned null under " + iPM());
      AppMethodBeat.o(60523);
      throw paramK;
    }
    if (paramK == null) {
      aDG(3);
    }
    AppMethodBeat.o(60523);
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.l.b.j
 * JD-Core Version:    0.7.0.1
 */