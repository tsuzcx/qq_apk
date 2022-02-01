package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.t;
import d.l.b.a.b.j.g;
import d.l.b.a.b.l.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class e
  extends i
{
  private final d.l.b.a.b.l.f JTx;
  protected final d.l.b.a.b.b.e JTy;
  
  public e(d.l.b.a.b.l.i parami, d.l.b.a.b.b.e parame)
  {
    this.JTy = parame;
    this.JTx = parami.H((d.g.a.a)new a(this));
  }
  
  private final List<d.l.b.a.b.b.l> fJr()
  {
    return (List)h.a(this.JTx, $$delegatedProperties[0]);
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    Object localObject1 = (Iterable)fJr();
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
      if (k.g(((ah)localObject2).fyB(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  public final Collection<d.l.b.a.b.b.l> a(d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    if (!paramd.afP(d.JTl.JSX)) {
      return (Collection)v.Jgl;
    }
    return (Collection)fJr();
  }
  
  public final Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    k.h(paramf, "name");
    k.h(parama, "location");
    Object localObject1 = (Iterable)fJr();
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
      if (k.g(((am)localObject2).fyB(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  protected abstract List<t> fxQ();
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends d.l.b.a.b.b.l>>
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
      k.h(paramb1, "fromSuper");
      k.h(paramb2, "fromCurrent");
      paramb1 = (Throwable)new IllegalStateException(("Conflict in scope of " + this.JTz.JTy + ": " + paramb1 + " vs " + paramb2).toString());
      AppMethodBeat.o(60204);
      throw paramb1;
    }
    
    public final void e(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(60203);
      k.h(paramb, "fakeOverride");
      d.l.b.a.b.j.i.a(paramb, null);
      this.Joy.add(paramb);
      AppMethodBeat.o(60203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.e
 * JD-Core Version:    0.7.0.1
 */