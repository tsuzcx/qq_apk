package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.ae;
import kotlinx.a.b.ag;
import kotlinx.a.b.e;
import kotlinx.a.h;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"list", "Lkotlinx/serialization/KSerializer;", "", "T", "getList", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "set", "", "getSet", "ListSerializer", "elementSerializer", "MapSerializer", "", "K", "V", "keySerializer", "valueSerializer", "SetSerializer", "kotlinx-serialization-runtime"})
public final class d
{
  public static final <K, V> h<Map<K, V>> a(h<K> paramh, h<V> paramh1)
  {
    AppMethodBeat.i(225620);
    p.h(paramh, "keySerializer");
    p.h(paramh1, "valueSerializer");
    paramh = (h)new ae(paramh, paramh1);
    AppMethodBeat.o(225620);
    return paramh;
  }
  
  public static final <T> h<List<T>> b(h<T> paramh)
  {
    AppMethodBeat.i(225618);
    p.h(paramh, "elementSerializer");
    paramh = (h)new e(paramh);
    AppMethodBeat.o(225618);
    return paramh;
  }
  
  public static final <T> h<Set<T>> c(h<T> paramh)
  {
    AppMethodBeat.i(225619);
    p.h(paramh, "elementSerializer");
    paramh = (h)new ag(paramh);
    AppMethodBeat.o(225619);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.a.d
 * JD-Core Version:    0.7.0.1
 */