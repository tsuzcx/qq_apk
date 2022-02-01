package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ad;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.f.f;

public final class j
  extends i
{
  private final kotlin.l.b.a.b.f.c aiEI;
  private final ah ajoh;
  private final String roK;
  
  public j(ah paramah, a.k paramk, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.a parama, g paramg, kotlin.l.b.a.b.k.a.j paramj, String paramString, kotlin.g.a.a<? extends Collection<f>> parama1)
  {
    super(paramc, parama, paramg, paramk, parama1);
    AppMethodBeat.i(192356);
    this.ajoh = paramah;
    this.roK = paramString;
    this.aiEI = this.ajoh.koY();
    AppMethodBeat.o(192356);
  }
  
  protected final kotlin.l.b.a.b.f.b A(f paramf)
  {
    AppMethodBeat.i(60469);
    s.u(paramf, "name");
    paramf = new kotlin.l.b.a.b.f.b(this.aiEI, paramf);
    AppMethodBeat.o(60469);
    return paramf;
  }
  
  protected final boolean D(f paramf)
  {
    AppMethodBeat.i(60468);
    s.u(paramf, "name");
    if (!super.D(paramf))
    {
      Object localObject = this.ajmz.aiWx.ajmd;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label100;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((kotlin.l.b.a.b.b.b.b)((Iterator)localObject).next()).a(this.aiEI, paramf));
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
  
  public final h c(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60470);
    s.u(paramf, "name");
    s.u(paramb, "location");
    d(paramf, paramb);
    paramf = super.c(paramf, paramb);
    AppMethodBeat.o(60470);
    return paramf;
  }
  
  protected final void c(Collection<kotlin.l.b.a.b.b.l> paramCollection, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60472);
    s.u(paramCollection, "result");
    s.u(paramb, "nameFilter");
    AppMethodBeat.o(60472);
  }
  
  public final void d(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60471);
    s.u(paramf, "name");
    s.u(paramb, "location");
    kotlin.l.b.a.b.c.a.a(this.ajmz.aiWx.aiRV, paramb, this.ajoh, paramf);
    AppMethodBeat.o(60471);
  }
  
  protected final Set<f> kAj()
  {
    return (Set)ad.aivA;
  }
  
  protected final Set<f> kAk()
  {
    return (Set)ad.aivA;
  }
  
  protected final Set<f> kAl()
  {
    return (Set)ad.aivA;
  }
  
  public final String toString()
  {
    return this.roK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.j
 * JD-Core Version:    0.7.0.1
 */