package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.f.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
{
  private static final HashMap<b, b> Nzq;
  public static final i Nzr;
  
  static
  {
    AppMethodBeat.i(57579);
    Nzr = new i();
    Nzq = new HashMap();
    b localb = g.Nng.Nog;
    p.g(localb, "FQ_NAMES.mutableList");
    a(localb, am(new String[] { "java.util.ArrayList", "java.util.LinkedList" }));
    localb = g.Nng.Noi;
    p.g(localb, "FQ_NAMES.mutableSet");
    a(localb, am(new String[] { "java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet" }));
    localb = g.Nng.Noj;
    p.g(localb, "FQ_NAMES.mutableMap");
    a(localb, am(new String[] { "java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap" }));
    a(new b("java.util.function.Function"), am(new String[] { "java.util.function.UnaryOperator" }));
    a(new b("java.util.function.BiFunction"), am(new String[] { "java.util.function.BinaryOperator" }));
    AppMethodBeat.o(57579);
  }
  
  private static void a(b paramb, List<b> paramList)
  {
    AppMethodBeat.i(57577);
    Object localObject = (Iterable)paramList;
    paramList = (Map)Nzq;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.put(((Iterator)localObject).next(), paramb);
    }
    AppMethodBeat.o(57577);
  }
  
  private static List<b> am(String... paramVarArgs)
  {
    AppMethodBeat.i(57578);
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new b(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = (List)localCollection;
    AppMethodBeat.o(57578);
    return paramVarArgs;
  }
  
  public static b m(b paramb)
  {
    AppMethodBeat.i(57576);
    p.h(paramb, "classFqName");
    paramb = (b)Nzq.get(paramb);
    AppMethodBeat.o(57576);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.i
 * JD-Core Version:    0.7.0.1
 */