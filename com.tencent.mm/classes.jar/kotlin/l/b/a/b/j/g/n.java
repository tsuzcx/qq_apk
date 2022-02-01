package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.o.e;
import kotlin.r;

public final class n
  extends a
{
  public static final a ajlt;
  private final h ajlf;
  private final String roK;
  
  static
  {
    AppMethodBeat.i(60247);
    ajlt = new a((byte)0);
    AppMethodBeat.o(60247);
  }
  
  private n(String paramString, h paramh)
  {
    this.roK = paramString;
    this.ajlf = paramh;
  }
  
  public static final h c(String paramString, Collection<? extends ad> paramCollection)
  {
    AppMethodBeat.i(60248);
    paramString = a.c(paramString, paramCollection);
    AppMethodBeat.o(60248);
    return paramString;
  }
  
  public final Collection<ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60245);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = kotlin.l.b.a.b.j.l.b(super.a(paramf, paramb), (kotlin.g.a.b)d.ajlw);
    AppMethodBeat.o(60245);
    return paramf;
  }
  
  public final Collection<kotlin.l.b.a.b.b.l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60246);
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    Object localObject1 = (Iterable)super.a(paramd, paramb);
    paramd = new ArrayList();
    paramb = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((kotlin.l.b.a.b.b.l)localObject2 instanceof kotlin.l.b.a.b.b.a)) {
        paramd.add(localObject2);
      } else {
        paramb.add(localObject2);
      }
    }
    paramb = new r(paramd, paramb);
    paramd = (List)paramb.bsC;
    paramb = (List)paramb.bsD;
    paramd = (Collection)p.b(kotlin.l.b.a.b.j.l.b((Collection)paramd, (kotlin.g.a.b)b.ajlu), (Iterable)paramb);
    AppMethodBeat.o(60246);
    return paramd;
  }
  
  public final Collection<au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60244);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramf = kotlin.l.b.a.b.j.l.b(super.b(paramf, paramb), (kotlin.g.a.b)c.ajlv);
    AppMethodBeat.o(60244);
    return paramf;
  }
  
  protected final h kzw()
  {
    return this.ajlf;
  }
  
  public static final class a
  {
    public static h c(String paramString, Collection<? extends ad> paramCollection)
    {
      AppMethodBeat.i(60237);
      s.u(paramString, "message");
      s.u(paramCollection, "types");
      Object localObject = (Iterable)paramCollection;
      paramCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramCollection.add(((ad)((Iterator)localObject).next()).knP());
      }
      paramCollection = kotlin.l.b.a.b.n.b.a.I((Iterable)paramCollection);
      localObject = b.ajkx;
      localObject = b.a.Z(paramString, (List)paramCollection);
      if (paramCollection.size() <= 1)
      {
        AppMethodBeat.o(60237);
        return localObject;
      }
      paramString = (h)new n(paramString, (h)localObject, (byte)0);
      AppMethodBeat.o(60237);
      return paramString;
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.a>
  {
    public static final b ajlu;
    
    static
    {
      AppMethodBeat.i(60239);
      ajlu = new b();
      AppMethodBeat.o(60239);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<au, kotlin.l.b.a.b.b.a>
  {
    public static final c ajlv;
    
    static
    {
      AppMethodBeat.i(60241);
      ajlv = new c();
      AppMethodBeat.o(60241);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements kotlin.g.a.b<ap, kotlin.l.b.a.b.b.a>
  {
    public static final d ajlw;
    
    static
    {
      AppMethodBeat.i(60243);
      ajlw = new d();
      AppMethodBeat.o(60243);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.n
 * JD-Core Version:    0.7.0.1
 */