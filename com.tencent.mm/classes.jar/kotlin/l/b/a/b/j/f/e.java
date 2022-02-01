package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.g;
import kotlin.l.b.a.b.l.j;

public abstract class e
  extends i
{
  private final kotlin.l.b.a.b.l.f abmt;
  protected final kotlin.l.b.a.b.b.e abmu;
  
  public e(j paramj, kotlin.l.b.a.b.b.e parame)
  {
    this.abmu = parame;
    this.abmt = paramj.av((kotlin.g.a.a)new a(this));
  }
  
  private final List<l> iPo()
  {
    return (List)kotlin.l.b.a.b.l.i.a(this.abmt, cMt[0]);
  }
  
  public final Collection<ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    Object localObject1 = (Iterable)iPo();
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
      if (p.h(((ah)localObject2).iEU(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  public final Collection<l> a(d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    p.k(paramd, "kindFilter");
    p.k(paramb, "nameFilter");
    if (!paramd.aFz(d.abmh.ablT)) {
      return (Collection)v.aaAd;
    }
    return (Collection)iPo();
  }
  
  public final Collection<am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    p.k(paramf, "name");
    p.k(parama, "location");
    Object localObject1 = (Iterable)iPo();
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
      if (p.h(((am)localObject2).iEU(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  protected abstract List<t> iEj();
  
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends l>>
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
    
    public final void a(kotlin.l.b.a.b.b.b paramb1, kotlin.l.b.a.b.b.b paramb2)
    {
      AppMethodBeat.i(60204);
      p.k(paramb1, "fromSuper");
      p.k(paramb2, "fromCurrent");
      paramb1 = (Throwable)new IllegalStateException(("Conflict in scope of " + this.abmv.abmu + ": " + paramb1 + " vs " + paramb2).toString());
      AppMethodBeat.o(60204);
      throw paramb1;
    }
    
    public final void e(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(60203);
      p.k(paramb, "fakeOverride");
      kotlin.l.b.a.b.j.i.a(paramb, null);
      this.kIf.add(paramb);
      AppMethodBeat.o(60203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.e
 * JD-Core Version:    0.7.0.1
 */