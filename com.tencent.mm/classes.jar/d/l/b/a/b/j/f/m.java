package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class m
  extends a
{
  public static final a NVm;
  private final b NVl;
  
  static
  {
    AppMethodBeat.i(60247);
    NVm = new a((byte)0);
    AppMethodBeat.o(60247);
  }
  
  private m(b paramb)
  {
    this.NVl = paramb;
  }
  
  public static final h c(String paramString, Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60248);
    paramString = a.c(paramString, paramCollection);
    AppMethodBeat.o(60248);
    return paramString;
  }
  
  public final Collection<ah> a(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60245);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = d.l.b.a.b.j.j.b(super.a(paramf, parama), (d.g.a.b)d.NVp);
    AppMethodBeat.o(60245);
    return paramf;
  }
  
  public final Collection<l> a(d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60246);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    Object localObject1 = (Iterable)super.a(paramd, paramb);
    paramd = new ArrayList();
    paramb = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((l)localObject2 instanceof d.l.b.a.b.b.a)) {
        paramd.add(localObject2);
      } else {
        paramb.add(localObject2);
      }
    }
    paramb = new o(paramd, paramb);
    paramd = (List)paramb.first;
    paramb = (List)paramb.second;
    if (paramd == null)
    {
      paramd = new v("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
      AppMethodBeat.o(60246);
      throw paramd;
    }
    paramd = (Collection)d.a.j.b(d.l.b.a.b.j.j.b((Collection)paramd, (d.g.a.b)b.NVn), (Iterable)paramb);
    AppMethodBeat.o(60246);
    return paramd;
  }
  
  public final Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60244);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = d.l.b.a.b.j.j.b(super.b(paramf, parama), (d.g.a.b)c.NVo);
    AppMethodBeat.o(60244);
    return paramf;
  }
  
  public static final class a
  {
    public static h c(String paramString, Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60237);
      p.h(paramString, "message");
      p.h(paramCollection, "types");
      Object localObject = (Iterable)paramCollection;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localCollection.add(((ab)((Iterator)localObject).next()).gmN());
      }
      paramString = new b(paramString, (List)localCollection);
      if (paramCollection.size() <= 1)
      {
        paramString = (h)paramString;
        AppMethodBeat.o(60237);
        return paramString;
      }
      paramString = (h)new m(paramString, (byte)0);
      AppMethodBeat.o(60237);
      return paramString;
    }
  }
  
  static final class b
    extends q
    implements d.g.a.b<d.l.b.a.b.b.a, d.l.b.a.b.b.a>
  {
    public static final b NVn;
    
    static
    {
      AppMethodBeat.i(60239);
      NVn = new b();
      AppMethodBeat.o(60239);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements d.g.a.b<am, am>
  {
    public static final c NVo;
    
    static
    {
      AppMethodBeat.i(60241);
      NVo = new c();
      AppMethodBeat.o(60241);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements d.g.a.b<ah, ah>
  {
    public static final d NVp;
    
    static
    {
      AppMethodBeat.i(60243);
      NVp = new d();
      AppMethodBeat.o(60243);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.m
 * JD-Core Version:    0.7.0.1
 */