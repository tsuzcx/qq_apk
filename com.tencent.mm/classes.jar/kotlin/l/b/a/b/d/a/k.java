package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.f.c;

public final class k
{
  public static final k aiOH;
  private static final HashMap<c, c> aiOI;
  
  static
  {
    AppMethodBeat.i(57579);
    aiOH = new k();
    aiOI = new HashMap();
    a(k.a.aiDv, ak(new String[] { "java.util.ArrayList", "java.util.LinkedList" }));
    a(k.a.aiDx, ak(new String[] { "java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet" }));
    a(k.a.aiDy, ak(new String[] { "java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap" }));
    a(new c("java.util.function.Function"), ak(new String[] { "java.util.function.UnaryOperator" }));
    a(new c("java.util.function.BiFunction"), ak(new String[] { "java.util.function.BinaryOperator" }));
    AppMethodBeat.o(57579);
  }
  
  private static void a(c paramc, List<c> paramList)
  {
    AppMethodBeat.i(57577);
    Object localObject = (Iterable)paramList;
    paramList = (Map)aiOI;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.put(((Iterator)localObject).next(), paramc);
    }
    AppMethodBeat.o(57577);
  }
  
  private static List<c> ak(String... paramVarArgs)
  {
    AppMethodBeat.i(57578);
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new c(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = (List)localCollection;
    AppMethodBeat.o(57578);
    return paramVarArgs;
  }
  
  public static c n(c paramc)
  {
    AppMethodBeat.i(57576);
    s.u(paramc, "classFqName");
    paramc = (c)aiOI.get(paramc);
    AppMethodBeat.o(57576);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.k
 * JD-Core Version:    0.7.0.1
 */