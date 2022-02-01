package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.q;
import d.l.b.a.b.d.b.v;
import d.z;
import java.util.Map;

public final class i
{
  private static final d NEs;
  private static final d NEt;
  private static final d NEu;
  private static final Map<String, j> NEv;
  
  static
  {
    AppMethodBeat.i(58074);
    NEs = new d(g.NEm, null, false);
    NEt = new d(g.NEn, null, false);
    NEu = new d(g.NEn, null, true);
    v localv = v.NGm;
    final String str1 = v.beb("Object");
    final String str2 = v.bed("Predicate");
    final String str3 = v.bed("Function");
    final String str4 = v.bed("Consumer");
    final String str5 = v.bed("BiFunction");
    final String str6 = v.bed("BiConsumer");
    final String str7 = v.bed("UnaryOperator");
    final String str8 = v.bec("stream/Stream");
    final String str9 = v.bec("Optional");
    m localm = new m();
    new m.a(localm, v.bec("Iterator")).j("forEachRemaining", (b)new a(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.beb("Iterable")).j("spliterator", (b)new l(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    m.a locala = new m.a(localm, v.bec("Collection"));
    locala.j("removeIf", (b)new v(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("stream", (b)new w(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("parallelStream", (b)new x(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bec("List")).j("replaceAll", (b)new y(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, v.bec("Map"));
    locala.j("forEach", (b)new z(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("putIfAbsent", (b)new aa(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("replace", (b)new ab(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("replace", (b)new b(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("replaceAll", (b)new c(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("compute", (b)new d(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("computeIfAbsent", (b)new e(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("computeIfPresent", (b)new f(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("merge", (b)new g(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, str9);
    locala.j("empty", (b)new h(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("of", (b)new i(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("ofNullable", (b)new j(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("get", (b)new k(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.j("ifPresent", (b)new m(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.beb("ref/Reference")).j("get", (b)new n(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str2).j("test", (b)new o(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bed("BiPredicate")).j("test", (b)new p(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str4).j("accept", (b)new q(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str6).j("accept", (b)new r(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str3).j("apply", (b)new s(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str5).j("apply", (b)new t(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bed("Supplier")).j("get", (b)new u(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    NEv = localm.NFd;
    AppMethodBeat.o(58074);
  }
  
  public static final Map<String, j> gqz()
  {
    return NEv;
  }
  
  static final class a
    extends q
    implements b<m.a.a, z>
  {
    a(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class aa
    extends q
    implements b<m.a.a, z>
  {
    aa(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class ab
    extends q
    implements b<m.a.a, z>
  {
    ab(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements b<m.a.a, z>
  {
    b(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements b<m.a.a, z>
  {
    c(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements b<m.a.a, z>
  {
    d(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements b<m.a.a, z>
  {
    e(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class f
    extends q
    implements b<m.a.a, z>
  {
    f(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class g
    extends q
    implements b<m.a.a, z>
  {
    g(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class h
    extends q
    implements b<m.a.a, z>
  {
    h(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class i
    extends q
    implements b<m.a.a, z>
  {
    i(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class j
    extends q
    implements b<m.a.a, z>
  {
    j(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class k
    extends q
    implements b<m.a.a, z>
  {
    k(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class l
    extends q
    implements b<m.a.a, z>
  {
    l(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class m
    extends q
    implements b<m.a.a, z>
  {
    m(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class n
    extends q
    implements b<m.a.a, z>
  {
    n(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class o
    extends q
    implements b<m.a.a, z>
  {
    o(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class p
    extends q
    implements b<m.a.a, z>
  {
    p(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class q
    extends q
    implements b<m.a.a, z>
  {
    q(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class r
    extends q
    implements b<m.a.a, z>
  {
    r(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class s
    extends q
    implements b<m.a.a, z>
  {
    s(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class t
    extends q
    implements b<m.a.a, z>
  {
    t(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class u
    extends q
    implements b<m.a.a, z>
  {
    u(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class v
    extends q
    implements b<m.a.a, z>
  {
    v(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class w
    extends q
    implements b<m.a.a, z>
  {
    w(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class x
    extends q
    implements b<m.a.a, z>
  {
    x(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class y
    extends q
    implements b<m.a.a, z>
  {
    y(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class z
    extends q
    implements b<m.a.a, z>
  {
    z(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.i
 * JD-Core Version:    0.7.0.1
 */