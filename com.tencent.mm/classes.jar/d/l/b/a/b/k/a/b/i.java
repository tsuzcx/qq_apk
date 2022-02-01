package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.g.b.k;
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
  private final ab JWm;
  private final d.l.b.a.b.f.b JoE;
  
  public i(ab paramab, a.k paramk, c paramc, d.l.b.a.b.e.b.a parama, f paramf, d.l.b.a.b.k.a.l paraml, d.g.a.a<? extends Collection<d.l.b.a.b.f.f>> parama1)
  {
    super(paramc, parama, paramf, (Collection)paramk, parama1);
    AppMethodBeat.i(60473);
    this.JWm = paramab;
    this.JoE = this.JWm.fzd();
    AppMethodBeat.o(60473);
  }
  
  protected final boolean C(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(60468);
    k.h(paramf, "name");
    if (!super.C(paramf))
    {
      Object localObject = this.JUS.JEr.JUy;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label100;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((d.l.b.a.b.b.b.b)((Iterator)localObject).next()).a(this.JoE, paramf));
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
    k.h(paramf, "name");
    k.h(parama, "location");
    d(paramf, parama);
    paramf = super.c(paramf, parama);
    AppMethodBeat.o(60470);
    return paramf;
  }
  
  protected final void c(Collection<d.l.b.a.b.b.l> paramCollection, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(60472);
    k.h(paramCollection, "result");
    k.h(paramb, "nameFilter");
    AppMethodBeat.o(60472);
  }
  
  public final void d(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60471);
    k.h(paramf, "name");
    k.h(parama, "location");
    d.l.b.a.b.c.a.a(this.JUS.JEr.JzY, parama, this.JWm, paramf);
    AppMethodBeat.o(60471);
  }
  
  protected final Set<d.l.b.a.b.f.f> fJF()
  {
    return (Set)x.Jgn;
  }
  
  protected final Set<d.l.b.a.b.f.f> fJG()
  {
    return (Set)x.Jgn;
  }
  
  protected final d.l.b.a.b.f.a z(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(60469);
    k.h(paramf, "name");
    paramf = new d.l.b.a.b.f.a(this.JoE, paramf);
    AppMethodBeat.o(60469);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.i
 * JD-Core Version:    0.7.0.1
 */