package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;
import kotlin.t;

public final class m
  extends a
{
  public static final a TKi;
  private final b TKh;
  
  static
  {
    AppMethodBeat.i(60247);
    TKi = new a((byte)0);
    AppMethodBeat.o(60247);
  }
  
  private m(b paramb)
  {
    this.TKh = paramb;
  }
  
  public static final h c(String paramString, Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60248);
    paramString = a.c(paramString, paramCollection);
    AppMethodBeat.o(60248);
    return paramString;
  }
  
  public final Collection<ah> a(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60245);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = kotlin.l.b.a.b.j.j.b(super.a(paramf, parama), (kotlin.g.a.b)m.d.TKl);
    AppMethodBeat.o(60245);
    return paramf;
  }
  
  public final Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
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
      if (((l)localObject2 instanceof kotlin.l.b.a.b.b.a)) {
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
      paramd = new t("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
      AppMethodBeat.o(60246);
      throw paramd;
    }
    paramd = (Collection)kotlin.a.j.b(kotlin.l.b.a.b.j.j.b((Collection)paramd, (kotlin.g.a.b)m.b.TKj), (Iterable)paramb);
    AppMethodBeat.o(60246);
    return paramd;
  }
  
  public final Collection<am> b(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60244);
    p.h(paramf, "name");
    p.h(parama, "location");
    paramf = kotlin.l.b.a.b.j.j.b(super.b(paramf, parama), (kotlin.g.a.b)m.c.TKk);
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
      Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localCollection.add(((ab)((Iterator)localObject).next()).hAp());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.m
 * JD-Core Version:    0.7.0.1
 */