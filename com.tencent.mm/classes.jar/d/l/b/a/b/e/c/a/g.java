package d.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.a.x;
import d.a.y;
import d.g.b.k;
import d.k.h;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.c.a.d;
import d.l.b.a.b.e.c.a.d.b;
import d.l.b.a.b.e.c.a.d.b.b;
import d.l.b.a.b.h.d;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  implements c
{
  private static final List<String> JLJ;
  private static final Map<String, Integer> JLK;
  public static final a JLL;
  private final Set<Integer> JLH;
  private final a.d JLI;
  private final List<a.d.b> nUd;
  private final String[] strings;
  
  static
  {
    AppMethodBeat.i(59250);
    JLL = new a((byte)0);
    Object localObject1 = j.listOf(new String[] { "kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator" });
    JLJ = (List)localObject1;
    Object localObject2 = j.p((Iterable)localObject1);
    localObject1 = (Map)new LinkedHashMap(h.kK(ae.adL(j.a((Iterable)localObject2, 10)), 16));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put((String)((y)localObject3).value, Integer.valueOf(((y)localObject3).index));
    }
    JLK = (Map)localObject1;
    AppMethodBeat.o(59250);
  }
  
  public g(a.d paramd, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59249);
    this.JLI = paramd;
    this.strings = paramArrayOfString;
    paramd = this.JLI.JLg;
    if (paramd.isEmpty()) {}
    for (paramd = (Set)x.Jgn;; paramd = j.o((Iterable)paramd))
    {
      this.JLH = paramd;
      paramd = new ArrayList();
      paramArrayOfString = this.JLI.JLf;
      paramd.ensureCapacity(paramArrayOfString.size());
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        a.d.b localb = (a.d.b)paramArrayOfString.next();
        k.g(localb, "record");
        int j = localb.JLj;
        int i = 0;
        while (i < j)
        {
          paramd.add(localb);
          i += 1;
        }
      }
    }
    paramd.trimToSize();
    this.nUd = ((List)paramd);
    AppMethodBeat.o(59249);
  }
  
  public final String afo(int paramInt)
  {
    AppMethodBeat.i(59247);
    String str = getString(paramInt);
    AppMethodBeat.o(59247);
    return str;
  }
  
  public final boolean afp(int paramInt)
  {
    AppMethodBeat.i(59248);
    boolean bool = this.JLH.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(59248);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59246);
    Object localObject3 = (a.d.b)this.nUd.get(paramInt);
    if (((a.d.b)localObject3).fGM())
    {
      localObject1 = ((a.d.b)localObject3).JLl;
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    Object localObject4;
    int i;
    for (;;)
    {
      localObject2 = localObject1;
      if (((a.d.b)localObject3).JLn.size() < 2) {
        break label338;
      }
      localObject2 = ((a.d.b)localObject3).JLn;
      localObject4 = (Integer)((List)localObject2).get(0);
      Integer localInteger = (Integer)((List)localObject2).get(1);
      k.g(localObject4, "begin");
      localObject2 = localObject1;
      if (k.compare(0, ((Integer)localObject4).intValue()) > 0) {
        break label338;
      }
      paramInt = ((Integer)localObject4).intValue();
      k.g(localInteger, "end");
      localObject2 = localObject1;
      if (k.compare(paramInt, localInteger.intValue()) > 0) {
        break label338;
      }
      localObject2 = localObject1;
      if (k.compare(localInteger.intValue(), ((String)localObject1).length()) > 0) {
        break label338;
      }
      k.g(localObject1, "string");
      paramInt = ((Integer)localObject4).intValue();
      i = localInteger.intValue();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(59246);
      throw ((Throwable)localObject1);
      localObject2 = (d)localObject1;
      localObject1 = ((d)localObject2).eBA();
      if (((d)localObject2).fHn()) {
        ((a.d.b)localObject3).JLl = localObject1;
      }
      continue;
      int j;
      if (((a.d.b)localObject3).fGL())
      {
        i = ((Collection)JLJ).size();
        j = ((a.d.b)localObject3).JLk;
        if (j >= 0) {
          break label295;
        }
      }
      label295:
      while (i <= j)
      {
        localObject1 = this.strings[paramInt];
        break;
      }
      localObject1 = (String)JLJ.get(((a.d.b)localObject3).JLk);
    }
    Object localObject2 = ((String)localObject1).substring(paramInt, i);
    k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label338:
    Object localObject1 = localObject2;
    if (((a.d.b)localObject3).JLp.size() >= 2)
    {
      localObject4 = ((a.d.b)localObject3).JLp;
      localObject1 = (Integer)((List)localObject4).get(0);
      localObject4 = (Integer)((List)localObject4).get(1);
      k.g(localObject2, "string");
      localObject1 = n.a((String)localObject2, (char)((Integer)localObject1).intValue(), (char)((Integer)localObject4).intValue());
    }
    localObject2 = ((a.d.b)localObject3).JLm;
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = a.d.b.b.JLr;
    }
    localObject2 = localObject1;
    switch (h.ciE[localObject3.ordinal()])
    {
    default: 
      localObject2 = localObject1;
    }
    for (;;)
    {
      k.g(localObject2, "string");
      AppMethodBeat.o(59246);
      return localObject2;
      k.g(localObject1, "string");
      localObject2 = n.a((String)localObject1, '$', '.');
      continue;
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 2)
      {
        k.g(localObject1, "string");
        paramInt = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(59246);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(1, paramInt - 1);
        k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      k.g(localObject2, "string");
      localObject2 = n.a((String)localObject2, '$', '.');
    }
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.g
 * JD-Core Version:    0.7.0.1
 */