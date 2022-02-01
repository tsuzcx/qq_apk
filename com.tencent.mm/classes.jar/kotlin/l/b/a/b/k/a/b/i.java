package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.k.a.n;

public final class i
  extends h
{
  private final ab TMD;
  private final kotlin.l.b.a.b.f.b TfF;
  
  public i(ab paramab, a.k paramk, c paramc, kotlin.l.b.a.b.e.b.a parama, f paramf, kotlin.l.b.a.b.k.a.l paraml, kotlin.g.a.a<? extends Collection<kotlin.l.b.a.b.f.f>> parama1)
  {
    super(paramc, parama, paramf, (Collection)paramk, parama1);
    AppMethodBeat.i(60473);
    this.TMD = paramab;
    this.TfF = this.TMD.hBk();
    AppMethodBeat.o(60473);
  }
  
  protected final boolean C(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(60468);
    p.h(paramf, "name");
    if (!super.C(paramf))
    {
      Object localObject = this.TLm.Tvt.TKS;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label100;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((kotlin.l.b.a.b.b.b.b)((Iterator)localObject).next()).a(this.TfF, paramf));
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
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60470);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    paramf = super.c(paramf, parama);
    AppMethodBeat.o(60470);
    return paramf;
  }
  
  protected final void c(Collection<kotlin.l.b.a.b.b.l> paramCollection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(60472);
    p.h(paramCollection, "result");
    p.h(paramb, "nameFilter");
    AppMethodBeat.o(60472);
  }
  
  public final void d(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60471);
    p.h(paramf, "name");
    p.h(parama, "location");
    kotlin.l.b.a.b.c.a.a(this.TLm.Tvt.Trb, parama, this.TMD, paramf);
    AppMethodBeat.o(60471);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> hLm()
  {
    return (Set)x.SXt;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> hLn()
  {
    return (Set)x.SXt;
  }
  
  protected final kotlin.l.b.a.b.f.a z(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(60469);
    p.h(paramf, "name");
    paramf = new kotlin.l.b.a.b.f.a(this.TfF, paramf);
    AppMethodBeat.o(60469);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.i
 * JD-Core Version:    0.7.0.1
 */