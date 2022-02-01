package d.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.e;
import d.l.b.a.b.c.a.a;
import d.l.b.a.b.c.a.c;
import d.l.b.a.b.d.a.e.aa;

public final class b
{
  public final d.l.b.a.b.d.a.c.g LFU;
  private final d.l.b.a.b.d.a.a.g Lnl;
  
  public b(d.l.b.a.b.d.a.c.g paramg, d.l.b.a.b.d.a.a.g paramg1)
  {
    AppMethodBeat.i(60164);
    this.LFU = paramg;
    this.Lnl = paramg1;
    AppMethodBeat.o(60164);
  }
  
  public final e c(d.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(60163);
    k.h(paramg, "javaClass");
    Object localObject1 = paramg.fRH();
    if ((localObject1 != null) && (aa.LpU == null))
    {
      paramg = this.Lnl.n((d.l.b.a.b.f.b)localObject1);
      AppMethodBeat.o(60163);
      return paramg;
    }
    Object localObject2 = paramg.fTi();
    if (localObject2 != null)
    {
      localObject1 = c((d.l.b.a.b.d.a.e.g)localObject2);
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).fRk();
        if (localObject1 == null) {
          break label125;
        }
      }
      label125:
      for (paramg = ((d.l.b.a.b.j.f.h)localObject1).c(paramg.fRf(), (a)c.Lkk);; paramg = null)
      {
        localObject1 = paramg;
        if (!(paramg instanceof e)) {
          localObject1 = null;
        }
        paramg = (e)localObject1;
        AppMethodBeat.o(60163);
        return paramg;
        localObject1 = null;
        break;
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(60163);
      return null;
    }
    localObject2 = this.LFU;
    localObject1 = ((d.l.b.a.b.f.b)localObject1).fZH();
    k.g(localObject1, "fqName.parent()");
    localObject1 = (d.l.b.a.b.d.a.c.a.h)j.iP(((d.l.b.a.b.d.a.c.g)localObject2).f((d.l.b.a.b.f.b)localObject1));
    if (localObject1 != null)
    {
      paramg = ((d.l.b.a.b.d.a.c.a.h)localObject1).d(paramg);
      AppMethodBeat.o(60163);
      return paramg;
    }
    AppMethodBeat.o(60163);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.e.b
 * JD-Core Version:    0.7.0.1
 */