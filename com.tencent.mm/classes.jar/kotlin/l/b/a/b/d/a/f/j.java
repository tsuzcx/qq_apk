package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.l.b.a.b.d.b.v;

public final class j
{
  private static final e aiVc;
  private static final e aiVd;
  private static final e aiVe;
  private static final Map<String, k> aiVf;
  
  static
  {
    AppMethodBeat.i(58074);
    aiVc = new e(h.aiUW, null, false);
    aiVd = new e(h.aiUX, null, false);
    aiVe = new e(h.aiUX, null, true);
    Object localObject2 = v.aiXe;
    String str1 = v.bIX("Object");
    String str2 = v.bIZ("Predicate");
    final String str3 = v.bIZ("Function");
    String str4 = v.bIZ("Consumer");
    final String str5 = v.bIZ("BiFunction");
    String str6 = v.bIZ("BiConsumer");
    Object localObject1 = v.bIZ("UnaryOperator");
    String str8 = v.bIY("stream/Stream");
    final String str7 = v.bIY("Optional");
    m localm = new m();
    new m.a(localm, v.bIY("Iterator")).x("forEachRemaining", (b)new a(str4));
    new m.a(localm, v.bIX("Iterable")).x("spliterator", (b)new g((v)localObject2));
    localObject2 = new m.a(localm, v.bIY("Collection"));
    ((m.a)localObject2).x("removeIf", (b)new h(str2));
    ((m.a)localObject2).x("stream", (b)new i(str8));
    ((m.a)localObject2).x("parallelStream", (b)new j(str8));
    new m.a(localm, v.bIY("List")).x("replaceAll", (b)new k((String)localObject1));
    localObject1 = new m.a(localm, v.bIY("Map"));
    ((m.a)localObject1).x("forEach", (b)new l(str6));
    ((m.a)localObject1).x("putIfAbsent", (b)new m(str1));
    ((m.a)localObject1).x("replace", (b)new n(str1));
    ((m.a)localObject1).x("replace", (b)new o(str1));
    ((m.a)localObject1).x("replaceAll", (b)new p(str5));
    ((m.a)localObject1).x("compute", (b)new q(str1, str5));
    ((m.a)localObject1).x("computeIfAbsent", (b)new r(str1, str3));
    ((m.a)localObject1).x("computeIfPresent", (b)new s(str1, str5));
    ((m.a)localObject1).x("merge", (b)new t(str1, str5));
    localObject1 = new m.a(localm, str7);
    ((m.a)localObject1).x("empty", (b)new u(str7));
    ((m.a)localObject1).x("of", (b)new v(str1, str7));
    ((m.a)localObject1).x("ofNullable", (b)new w(str1, str7));
    ((m.a)localObject1).x("get", (b)new x(str1));
    ((m.a)localObject1).x("ifPresent", (b)new y(str4));
    new m.a(localm, v.bIX("ref/Reference")).x("get", (b)new z(str1));
    new m.a(localm, str2).x("test", (b)new aa(str1));
    new m.a(localm, v.bIZ("BiPredicate")).x("test", (b)new ab(str1));
    new m.a(localm, str4).x("accept", (b)new b(str1));
    new m.a(localm, str6).x("accept", (b)new c(str1));
    new m.a(localm, str3).x("apply", (b)new d(str1));
    new m.a(localm, str5).x("apply", (b)new e(str1));
    new m.a(localm, v.bIZ("Supplier")).x("get", (b)new f(str1));
    aiVf = localm.aiVN;
    AppMethodBeat.o(58074);
  }
  
  public static final Map<String, k> ksC()
  {
    return aiVf;
  }
  
  static final class a
    extends u
    implements b<m.a.a, ah>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  static final class aa
    extends u
    implements b<m.a.a, ah>
  {
    aa(String paramString)
    {
      super();
    }
  }
  
  static final class ab
    extends u
    implements b<m.a.a, ah>
  {
    ab(String paramString)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements b<m.a.a, ah>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements b<m.a.a, ah>
  {
    c(String paramString)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements b<m.a.a, ah>
  {
    d(String paramString)
    {
      super();
    }
  }
  
  static final class e
    extends u
    implements b<m.a.a, ah>
  {
    e(String paramString)
    {
      super();
    }
  }
  
  static final class f
    extends u
    implements b<m.a.a, ah>
  {
    f(String paramString)
    {
      super();
    }
  }
  
  static final class g
    extends u
    implements b<m.a.a, ah>
  {
    g(v paramv)
    {
      super();
    }
  }
  
  static final class h
    extends u
    implements b<m.a.a, ah>
  {
    h(String paramString)
    {
      super();
    }
  }
  
  static final class i
    extends u
    implements b<m.a.a, ah>
  {
    i(String paramString)
    {
      super();
    }
  }
  
  static final class j
    extends u
    implements b<m.a.a, ah>
  {
    j(String paramString)
    {
      super();
    }
  }
  
  static final class k
    extends u
    implements b<m.a.a, ah>
  {
    k(String paramString)
    {
      super();
    }
  }
  
  static final class l
    extends u
    implements b<m.a.a, ah>
  {
    l(String paramString)
    {
      super();
    }
  }
  
  static final class m
    extends u
    implements b<m.a.a, ah>
  {
    m(String paramString)
    {
      super();
    }
  }
  
  static final class n
    extends u
    implements b<m.a.a, ah>
  {
    n(String paramString)
    {
      super();
    }
  }
  
  static final class o
    extends u
    implements b<m.a.a, ah>
  {
    o(String paramString)
    {
      super();
    }
  }
  
  static final class p
    extends u
    implements b<m.a.a, ah>
  {
    p(String paramString)
    {
      super();
    }
  }
  
  static final class q
    extends u
    implements b<m.a.a, ah>
  {
    q(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  static final class r
    extends u
    implements b<m.a.a, ah>
  {
    r(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  static final class s
    extends u
    implements b<m.a.a, ah>
  {
    s(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  static final class t
    extends u
    implements b<m.a.a, ah>
  {
    t(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  static final class u
    extends u
    implements b<m.a.a, ah>
  {
    u(String paramString)
    {
      super();
    }
  }
  
  static final class v
    extends u
    implements b<m.a.a, ah>
  {
    v(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  static final class w
    extends u
    implements b<m.a.a, ah>
  {
    w(String paramString1, String paramString2)
    {
      super();
    }
  }
  
  static final class x
    extends u
    implements b<m.a.a, ah>
  {
    x(String paramString)
    {
      super();
    }
  }
  
  static final class y
    extends u
    implements b<m.a.a, ah>
  {
    y(String paramString)
    {
      super();
    }
  }
  
  static final class z
    extends u
    implements b<m.a.a, ah>
  {
    z(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.j
 * JD-Core Version:    0.7.0.1
 */