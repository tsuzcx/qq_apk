package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l.b.a.b.d.b.v;
import kotlin.x;

public final class i
{
  private static final d TtZ;
  private static final d Tua;
  private static final d Tub;
  private static final Map<String, j> Tuc;
  
  static
  {
    AppMethodBeat.i(58074);
    TtZ = new d(g.TtT, null, false);
    Tua = new d(g.TtU, null, false);
    Tub = new d(g.TtU, null, true);
    v localv = v.TvS;
    final String str1 = v.btR("Object");
    final String str2 = v.btT("Predicate");
    final String str3 = v.btT("Function");
    final String str4 = v.btT("Consumer");
    final String str5 = v.btT("BiFunction");
    final String str6 = v.btT("BiConsumer");
    final String str7 = v.btT("UnaryOperator");
    final String str8 = v.btS("stream/Stream");
    final String str9 = v.btS("Optional");
    m localm = new m();
    new m.a(localm, v.btS("Iterator")).p("forEachRemaining", (b)new a(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.btR("Iterable")).p("spliterator", (b)new l(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    m.a locala = new m.a(localm, v.btS("Collection"));
    locala.p("removeIf", (b)new v(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("stream", (b)new w(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("parallelStream", (b)new x(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.btS("List")).p("replaceAll", (b)new y(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, v.btS("Map"));
    locala.p("forEach", (b)new z(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("putIfAbsent", (b)new aa(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("replace", (b)new ab(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("replace", (b)new b(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("replaceAll", (b)new c(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("compute", (b)new d(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("computeIfAbsent", (b)new e(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("computeIfPresent", (b)new f(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("merge", (b)new g(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, str9);
    locala.p("empty", (b)new h(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("of", (b)new i(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("ofNullable", (b)new j(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("get", (b)new k(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.p("ifPresent", (b)new m(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.btR("ref/Reference")).p("get", (b)new n(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str2).p("test", (b)new o(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.btT("BiPredicate")).p("test", (b)new p(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str4).p("accept", (b)new q(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str6).p("accept", (b)new r(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str3).p("apply", (b)new s(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str5).p("apply", (b)new t(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.btT("Supplier")).p("get", (b)new u(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    Tuc = localm.TuJ;
    AppMethodBeat.o(58074);
  }
  
  public static final Map<String, j> hEb()
  {
    return Tuc;
  }
  
  static final class a
    extends q
    implements b<m.a.a, x>
  {
    a(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class aa
    extends q
    implements b<m.a.a, x>
  {
    aa(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class ab
    extends q
    implements b<m.a.a, x>
  {
    ab(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements b<m.a.a, x>
  {
    b(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements b<m.a.a, x>
  {
    c(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements b<m.a.a, x>
  {
    d(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements b<m.a.a, x>
  {
    e(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class f
    extends q
    implements b<m.a.a, x>
  {
    f(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class g
    extends q
    implements b<m.a.a, x>
  {
    g(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class h
    extends q
    implements b<m.a.a, x>
  {
    h(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class i
    extends q
    implements b<m.a.a, x>
  {
    i(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class j
    extends q
    implements b<m.a.a, x>
  {
    j(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class k
    extends q
    implements b<m.a.a, x>
  {
    k(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class l
    extends q
    implements b<m.a.a, x>
  {
    l(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class m
    extends q
    implements b<m.a.a, x>
  {
    m(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class n
    extends q
    implements b<m.a.a, x>
  {
    n(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class o
    extends q
    implements b<m.a.a, x>
  {
    o(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class p
    extends q
    implements b<m.a.a, x>
  {
    p(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class q
    extends q
    implements b<m.a.a, x>
  {
    q(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class r
    extends q
    implements b<m.a.a, x>
  {
    r(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class s
    extends q
    implements b<m.a.a, x>
  {
    s(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class t
    extends q
    implements b<m.a.a, x>
  {
    t(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class u
    extends q
    implements b<m.a.a, x>
  {
    u(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class v
    extends q
    implements b<m.a.a, x>
  {
    v(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class w
    extends q
    implements b<m.a.a, x>
  {
    w(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class x
    extends q
    implements b<m.a.a, x>
  {
    x(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class y
    extends q
    implements b<m.a.a, x>
  {
    y(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class z
    extends q
    implements b<m.a.a, x>
  {
    z(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.i
 * JD-Core Version:    0.7.0.1
 */