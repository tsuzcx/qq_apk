package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.q;
import d.l.b.a.b.d.b.v;
import d.z;
import java.util.Map;

public final class i
{
  private static final d Nhn;
  private static final d Nho;
  private static final d Nhp;
  private static final Map<String, j> Nhq;
  
  static
  {
    AppMethodBeat.i(58074);
    Nhn = new d(g.Nhh, null, false);
    Nho = new d(g.Nhi, null, false);
    Nhp = new d(g.Nhi, null, true);
    v localv = v.Njg;
    final String str1 = v.bcx("Object");
    final String str2 = v.bcz("Predicate");
    final String str3 = v.bcz("Function");
    final String str4 = v.bcz("Consumer");
    final String str5 = v.bcz("BiFunction");
    final String str6 = v.bcz("BiConsumer");
    final String str7 = v.bcz("UnaryOperator");
    final String str8 = v.bcy("stream/Stream");
    final String str9 = v.bcy("Optional");
    m localm = new m();
    new m.a(localm, v.bcy("Iterator")).i("forEachRemaining", (b)new a(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bcx("Iterable")).i("spliterator", (b)new l(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    m.a locala = new m.a(localm, v.bcy("Collection"));
    locala.i("removeIf", (b)new v(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("stream", (b)new w(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.i("parallelStream", (b)new x(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bcy("List")).i("replaceAll", (b)new y(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, v.bcy("Map"));
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
    new m.a(localm, v.bcx("ref/Reference")).i("get", (b)new n(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str2).i("test", (b)new o(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bcz("BiPredicate")).i("test", (b)new p(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str4).i("accept", (b)new q(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str6).i("accept", (b)new r(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str3).i("apply", (b)new s(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str5).i("apply", (b)new t(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.bcz("Supplier")).i("get", (b)new u(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    Nhq = localm.NhX;
    AppMethodBeat.o(58074);
  }
  
  public static final Map<String, j> glX()
  {
    return Nhq;
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