package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentMap;

final class b$a<K, V>
  extends b.b<K, V>
  implements a<K, V>
{
  static
  {
    AppMethodBeat.i(60501);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(60501);
      return;
    }
  }
  
  private b$a(b paramb, ConcurrentMap<b.d<K, V>, Object> paramConcurrentMap)
  {
    super(paramb, paramConcurrentMap, (byte)0);
    AppMethodBeat.i(60499);
    AppMethodBeat.o(60499);
  }
  
  public final V b(K paramK, kotlin.g.a.a<? extends V> parama)
  {
    AppMethodBeat.i(60500);
    if (parama == null) {
      aDG(2);
    }
    paramK = super.b(paramK, parama);
    if ((!$assertionsDisabled) && (paramK == null))
    {
      paramK = new AssertionError("computeIfAbsent() returned null under " + iPM());
      AppMethodBeat.o(60500);
      throw paramK;
    }
    if (paramK == null) {
      aDG(3);
    }
    AppMethodBeat.o(60500);
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.l.b.a
 * JD-Core Version:    0.7.0.1
 */