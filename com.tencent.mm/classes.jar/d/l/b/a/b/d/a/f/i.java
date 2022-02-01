package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.l;
import d.l.b.a.b.d.b.v;
import d.y;
import java.util.Map;

public final class i
{
  private static final d JCX;
  private static final d JCY;
  private static final d JCZ;
  private static final Map<String, j> JDa;
  
  static
  {
    AppMethodBeat.i(58074);
    JCX = new d(g.JCR, null, false);
    JCY = new d(g.JCS, null, false);
    JCZ = new d(g.JCS, null, true);
    v localv = v.JEQ;
    final String str1 = v.aQv("Object");
    final String str2 = v.aQx("Predicate");
    final String str3 = v.aQx("Function");
    final String str4 = v.aQx("Consumer");
    final String str5 = v.aQx("BiFunction");
    final String str6 = v.aQx("BiConsumer");
    final String str7 = v.aQx("UnaryOperator");
    final String str8 = v.aQw("stream/Stream");
    final String str9 = v.aQw("Optional");
    m localm = new m();
    new m.a(localm, v.aQw("Iterator")).h("forEachRemaining", (b)new a(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aQv("Iterable")).h("spliterator", (b)new l(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    m.a locala = new m.a(localm, v.aQw("Collection"));
    locala.h("removeIf", (b)new v(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("stream", (b)new w(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("parallelStream", (b)new x(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aQw("List")).h("replaceAll", (b)new y(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, v.aQw("Map"));
    locala.h("forEach", (b)new z(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("putIfAbsent", (b)new aa(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("replace", (b)new ab(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("replace", (b)new b(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("replaceAll", (b)new c(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("compute", (b)new d(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("computeIfAbsent", (b)new e(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("computeIfPresent", (b)new f(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("merge", (b)new g(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, str9);
    locala.h("empty", (b)new h(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("of", (b)new i(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("ofNullable", (b)new j(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("get", (b)new k(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.h("ifPresent", (b)new m(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aQv("ref/Reference")).h("get", (b)new n(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str2).h("test", (b)new o(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aQx("BiPredicate")).h("test", (b)new p(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str4).h("accept", (b)new q(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str6).h("accept", (b)new r(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str3).h("apply", (b)new s(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str5).h("apply", (b)new t(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, v.aQx("Supplier")).h("get", (b)new u(localv, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    JDa = localm.JDH;
    AppMethodBeat.o(58074);
  }
  
  public static final Map<String, j> fBU()
  {
    return JDa;
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