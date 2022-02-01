package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.j.g;
import d.l.b.a.b.l.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class e
  extends i
{
  private final d.l.b.a.b.l.f NUV;
  protected final d.l.b.a.b.b.e NUW;
  
  public e(j paramj, d.l.b.a.b.b.e parame)
  {
    this.NUW = parame;
    this.NUV = paramj.S((d.g.a.a)new a(this));
  }
  
  private final List<l> gxV()
  {
    return (List)d.l.b.a.b.l.i.a(this.NUV, cxA[0]);
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    Object localObject1 = (Iterable)gxV();
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof ah)) {
        parama.add(localObject2);
      }
    }
    localObject1 = (Iterable)parama;
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (p.i(((ah)localObject2).gnf(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  public final Collection<l> a(d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    if (!paramd.alW(d.NUI.NUu)) {
      return (Collection)v.NhH;
    }
    return (Collection)gxV();
  }
  
  public final Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    p.h(paramf, "name");
    p.h(parama, "location");
    Object localObject1 = (Iterable)gxV();
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof am)) {
        parama.add(localObject2);
      }
    }
    localObject1 = (Iterable)parama;
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (p.i(((am)localObject2).gnf(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  protected abstract List<t> gmu();
  
  static final class a
    extends q
    implements d.g.a.a<List<? extends l>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  public static final class b
    extends g
  {
    b(ArrayList paramArrayList) {}
    
    public final void a(d.l.b.a.b.b.b paramb1, d.l.b.a.b.b.b paramb2)
    {
      AppMethodBeat.i(60204);
      p.h(paramb1, "fromSuper");
      p.h(paramb2, "fromCurrent");
      paramb1 = (Throwable)new IllegalStateException(("Conflict in scope of " + this.NUX.NUW + ": " + paramb1 + " vs " + paramb2).toString());
      AppMethodBeat.o(60204);
      throw paramb1;
    }
    
    public final void e(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(60203);
      p.h(paramb, "fakeOverride");
      d.l.b.a.b.j.i.a(paramb, null);
      this.haP.add(paramb);
      AppMethodBeat.o(60203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.e
 * JD-Core Version:    0.7.0.1
 */