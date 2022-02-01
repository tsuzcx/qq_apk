package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.c.a.d;
import kotlin.l.b.a.b.d.a.e.ac;

public final class c
{
  private final kotlin.l.b.a.b.d.a.a.g aiRP;
  public final kotlin.l.b.a.b.d.a.c.g ajkc;
  
  public c(kotlin.l.b.a.b.d.a.c.g paramg, kotlin.l.b.a.b.d.a.a.g paramg1)
  {
    AppMethodBeat.i(60164);
    this.ajkc = paramg;
    this.aiRP = paramg1;
    AppMethodBeat.o(60164);
  }
  
  public final e c(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(60163);
    s.u(paramg, "javaClass");
    Object localObject1 = paramg.koY();
    if ((localObject1 != null) && (paramg.kqF() == ac.aiUC))
    {
      paramg = this.aiRP.q((kotlin.l.b.a.b.f.c)localObject1);
      AppMethodBeat.o(60163);
      return paramg;
    }
    Object localObject2 = paramg.kqQ();
    if (localObject2 != null)
    {
      localObject1 = c((kotlin.l.b.a.b.d.a.e.g)localObject2);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label110;
        }
      }
      label110:
      for (paramg = null;; paramg = ((kotlin.l.b.a.b.j.g.h)localObject1).c(paramg.kok(), (b)d.aiNN))
      {
        if (!(paramg instanceof e)) {
          break label132;
        }
        paramg = (e)paramg;
        AppMethodBeat.o(60163);
        return paramg;
        localObject1 = ((e)localObject1).kou();
        break;
      }
      label132:
      AppMethodBeat.o(60163);
      return null;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(60163);
      return null;
    }
    localObject2 = this.ajkc;
    localObject1 = ((kotlin.l.b.a.b.f.c)localObject1).kxS();
    s.s(localObject1, "fqName.parent()");
    localObject1 = (kotlin.l.b.a.b.d.a.c.a.h)p.oL(((kotlin.l.b.a.b.d.a.c.g)localObject2).f((kotlin.l.b.a.b.f.c)localObject1));
    if (localObject1 == null)
    {
      AppMethodBeat.o(60163);
      return null;
    }
    paramg = ((kotlin.l.b.a.b.d.a.c.a.h)localObject1).d(paramg);
    AppMethodBeat.o(60163);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.c
 * JD-Core Version:    0.7.0.1
 */