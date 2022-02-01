package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.f.b;

public final class i
{
  private static final HashMap<b, b> aaRS;
  public static final i aaRT;
  
  static
  {
    AppMethodBeat.i(57579);
    aaRT = new i();
    aaRS = new HashMap();
    b localb = g.aaFI.aaGI;
    p.j(localb, "FQ_NAMES.mutableList");
    a(localb, ai(new String[] { "java.util.ArrayList", "java.util.LinkedList" }));
    localb = g.aaFI.aaGK;
    p.j(localb, "FQ_NAMES.mutableSet");
    a(localb, ai(new String[] { "java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet" }));
    localb = g.aaFI.aaGL;
    p.j(localb, "FQ_NAMES.mutableMap");
    a(localb, ai(new String[] { "java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap" }));
    a(new b("java.util.function.Function"), ai(new String[] { "java.util.function.UnaryOperator" }));
    a(new b("java.util.function.BiFunction"), ai(new String[] { "java.util.function.BinaryOperator" }));
    AppMethodBeat.o(57579);
  }
  
  private static void a(b paramb, List<b> paramList)
  {
    AppMethodBeat.i(57577);
    Object localObject = (Iterable)paramList;
    paramList = (Map)aaRS;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.put(((Iterator)localObject).next(), paramb);
    }
    AppMethodBeat.o(57577);
  }
  
  private static List<b> ai(String... paramVarArgs)
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
    p.k(paramb, "classFqName");
    paramb = (b)aaRS.get(paramb);
    AppMethodBeat.o(57576);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.i
 * JD-Core Version:    0.7.0.1
 */