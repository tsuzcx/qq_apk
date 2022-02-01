package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
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
  public static final a JTO;
  private final b JTN;
  
  static
  {
    AppMethodBeat.i(60247);
    JTO = new a((byte)0);
    AppMethodBeat.o(60247);
  }
  
  private m(b paramb)
  {
    this.JTN = paramb;
  }
  
  public static final h b(String paramString, Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60248);
    paramString = a.b(paramString, paramCollection);
    AppMethodBeat.o(60248);
    return paramString;
  }
  
  public final Collection<ah> a(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60245);
    k.h(paramf, "name");
    k.h(parama, "location");
    paramf = d.l.b.a.b.j.j.b(super.a(paramf, parama), (d.g.a.b)d.JTR);
    AppMethodBeat.o(60245);
    return paramf;
  }
  
  public final Collection<d.l.b.a.b.b.l> a(d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60246);
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    Object localObject1 = (Iterable)super.a(paramd, paramb);
    paramd = new ArrayList();
    paramb = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((d.l.b.a.b.b.l)localObject2 instanceof d.l.b.a.b.b.a)) {
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
    paramd = (Collection)d.a.j.b(d.l.b.a.b.j.j.b((Collection)paramd, (d.g.a.b)b.JTP), (Iterable)paramb);
    AppMethodBeat.o(60246);
    return paramd;
  }
  
  public final Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60244);
    k.h(paramf, "name");
    k.h(parama, "location");
    paramf = d.l.b.a.b.j.j.b(super.b(paramf, parama), (d.g.a.b)c.JTQ);
    AppMethodBeat.o(60244);
    return paramf;
  }
  
  public static final class a
  {
    public static h b(String paramString, Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60237);
      k.h(paramString, "message");
      k.h(paramCollection, "types");
      Object localObject = (Iterable)paramCollection;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localCollection.add(((ab)((Iterator)localObject).next()).fyj());
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
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.b.a, d.l.b.a.b.b.a>
  {
    public static final b JTP;
    
    static
    {
      AppMethodBeat.i(60239);
      JTP = new b();
      AppMethodBeat.o(60239);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.b<am, am>
  {
    public static final c JTQ;
    
    static
    {
      AppMethodBeat.i(60241);
      JTQ = new c();
      AppMethodBeat.o(60241);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<ah, ah>
  {
    public static final d JTR;
    
    static
    {
      AppMethodBeat.i(60243);
      JTR = new d();
      AppMethodBeat.o(60243);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.j.f.m
 * JD-Core Version:    0.7.0.1
 */