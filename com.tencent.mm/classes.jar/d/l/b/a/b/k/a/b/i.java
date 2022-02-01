package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.g.b.p;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.k.a.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class i
  extends h
{
  private final d.l.b.a.b.f.b MSS;
  private final ab NAD;
  
  public i(ab paramab, a.k paramk, c paramc, d.l.b.a.b.e.b.a parama, f paramf, d.l.b.a.b.k.a.l paraml, d.g.a.a<? extends Collection<d.l.b.a.b.f.f>> parama1)
  {
    super(paramc, parama, paramf, (Collection)paramk, parama1);
    AppMethodBeat.i(60473);
    this.NAD = paramab;
    this.MSS = this.NAD.gjg();
    AppMethodBeat.o(60473);
  }
  
  protected final boolean C(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(60468);
    p.h(paramf, "name");
    if (!super.C(paramf))
    {
      Object localObject = this.Nzj.NiH.NyP;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label100;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((d.l.b.a.b.b.b.b)((Iterator)localObject).next()).a(this.MSS, paramf));
    }
    label100:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(60468);
      return true;
    }
    AppMethodBeat.o(60468);
    return false;
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60470);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    paramf = super.c(paramf, parama);
    AppMethodBeat.o(60470);
    return paramf;
  }
  
  protected final void c(Collection<d.l.b.a.b.b.l> paramCollection, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(60472);
    p.h(paramCollection, "result");
    p.h(paramb, "nameFilter");
    AppMethodBeat.o(60472);
  }
  
  public final void d(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60471);
    p.h(paramf, "name");
    p.h(parama, "location");
    d.l.b.a.b.c.a.a(this.Nzj.NiH.Neo, parama, this.NAD, paramf);
    AppMethodBeat.o(60471);
  }
  
  protected final Set<d.l.b.a.b.f.f> gtH()
  {
    return (Set)x.MKG;
  }
  
  protected final Set<d.l.b.a.b.f.f> gtI()
  {
    return (Set)x.MKG;
  }
  
  protected final d.l.b.a.b.f.a z(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(60469);
    p.h(paramf, "name");
    paramf = new d.l.b.a.b.f.a(this.MSS, paramf);
    AppMethodBeat.o(60469);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.i
 * JD-Core Version:    0.7.0.1
 */