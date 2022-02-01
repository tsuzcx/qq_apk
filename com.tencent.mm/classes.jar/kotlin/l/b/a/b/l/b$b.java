package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentMap;
import kotlin.g.a.a;

class b$b<K, V>
  extends b.i<b.d<K, V>, V>
{
  private b$b(b paramb, ConcurrentMap<b.d<K, V>, Object> paramConcurrentMap)
  {
    super(paramb, paramConcurrentMap, new kotlin.g.a.b() {});
    AppMethodBeat.i(60504);
    AppMethodBeat.o(60504);
  }
  
  public V b(K paramK, a<? extends V> parama)
  {
    AppMethodBeat.i(60505);
    if (parama == null) {
      aDG(2);
    }
    paramK = invoke(new b.d(paramK, parama));
    AppMethodBeat.o(60505);
    return paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.l.b.b
 * JD-Core Version:    0.7.0.1
 */