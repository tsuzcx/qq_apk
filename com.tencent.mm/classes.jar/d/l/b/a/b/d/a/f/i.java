package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.l;
import d.l.b.a.b.d.b.v;
import d.y;
import java.util.Map;

public final class i
{
  private static final d Lqq;
  private static final d Lqr;
  private static final d Lqs;
  private static final Map<String, j> Lqt;
  
  static
  {
    AppMethodBeat.i(58074);
    Lqq = new d(g.Lqk, null, false);
    Lqr = new d(g.Lql, null, false);
    Lqs = new d(g.Lql, null, true);
    v localv = v.Lsj;
    final String str1 = v.aWu("Object");
    final String str2 = v.aWw("Predicate");
    final String str3 = v.aWw("Function");
    final String str4 = v.aWw("Consumer");
    final String str5 = v.aWw("BiFunction");
    final String str6 = v.aWw("BiConsumer");
    final String str7 = v.aWw("UnaryOperator");
    final String str8 = v.aWv("stream/Stream");
    final String str9 = v.aWv("Optional");
    m localm = new m();
    new m.a(localm, v.aWv("Iterator")).i("forEachRemaining", (b)new a(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aWu("Iterable")).i("spliterator", (b)new l(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    m.a locala = new m.a(localm, v.aWv("Collection"));
    locala.i("removeIf", (b)new v(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("stream", (b)new w(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("parallelStream", (b)new x(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aWv("List")).i("replaceAll", (b)new y(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, v.aWv("Map"));
    locala.i("forEach", (b)new z(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("putIfAbsent", (b)new aa(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("replace", (b)new ab(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("replace", (b)new b(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("replaceAll", (b)new c(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("compute", (b)new d(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("computeIfAbsent", (b)new e(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("computeIfPresent", (b)new f(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("merge", (b)new g(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, str9);
    locala.i("empty", (b)new h(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("of", (b)new i(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("ofNullable", (b)new j(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("get", (b)new k(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("ifPresent", (b)new m(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aWu("ref/Reference")).i("get", (b)new n(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str2).i("test", (b)new o(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aWw("BiPredicate")).i("test", (b)new p(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str4).i("accept", (b)new q(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str6).i("accept", (b)new r(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str3).i("apply", (b)new s(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str5).i("apply", (b)new t(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aWw("Supplier")).i("get", (b)new u(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    Lqt = localm.Lra;
    AppMethodBeat.o(58074);
  }
  
  public static final Map<String, j> fUy()
  {
    return Lqt;
  }
  
  static final class a
    extends l
    implements b<m.a.a, y>
  {
    a(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class aa
    extends l
    implements b<m.a.a, y>
  {
    aa(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class ab
    extends l
    implements b<m.a.a, y>
  {
    ab(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class b
    extends l
    implements b<m.a.a, y>
  {
    b(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class c
    extends l
    implements b<m.a.a, y>
  {
    c(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class d
    extends l
    implements b<m.a.a, y>
  {
    d(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class e
    extends l
    implements b<m.a.a, y>
  {
    e(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class f
    extends l
    implements b<m.a.a, y>
  {
    f(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class g
    extends l
    implements b<m.a.a, y>
  {
    g(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class h
    extends l
    implements b<m.a.a, y>
  {
    h(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class i
    extends l
    implements b<m.a.a, y>
  {
    i(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class j
    extends l
    implements b<m.a.a, y>
  {
    j(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class k
    extends l
    implements b<m.a.a, y>
  {
    k(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class l
    extends l
    implements b<m.a.a, y>
  {
    l(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class m
    extends l
    implements b<m.a.a, y>
  {
    m(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class n
    extends l
    implements b<m.a.a, y>
  {
    n(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class o
    extends l
    implements b<m.a.a, y>
  {
    o(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class p
    extends l
    implements b<m.a.a, y>
  {
    p(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class q
    extends l
    implements b<m.a.a, y>
  {
    q(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class r
    extends l
    implements b<m.a.a, y>
  {
    r(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class s
    extends l
    implements b<m.a.a, y>
  {
    s(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class t
    extends l
    implements b<m.a.a, y>
  {
    t(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class u
    extends l
    implements b<m.a.a, y>
  {
    u(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class v
    extends l
    implements b<m.a.a, y>
  {
    v(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class w
    extends l
    implements b<m.a.a, y>
  {
    w(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class x
    extends l
    implements b<m.a.a, y>
  {
    x(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class y
    extends l
    implements b<m.a.a, y>
  {
    y(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
  
  static final class z
    extends l
    implements b<m.a.a, y>
  {
    z(v paramv, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.i
 * JD-Core Version:    0.7.0.1
 */