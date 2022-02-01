package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.d.a.e.aa;

public final class b
{
  public final kotlin.l.b.a.b.d.a.c.g TIV;
  private final kotlin.l.b.a.b.d.a.a.g TqV;
  
  public b(kotlin.l.b.a.b.d.a.c.g paramg, kotlin.l.b.a.b.d.a.a.g paramg1)
  {
    AppMethodBeat.i(60164);
    this.TIV = paramg;
    this.TqV = paramg1;
    AppMethodBeat.o(60164);
  }
  
  public final e c(kotlin.l.b.a.b.d.a.e.g paramg)
  {
    AppMethodBeat.i(60163);
    p.h(paramg, "javaClass");
    Object localObject1 = paramg.hBk();
    if ((localObject1 != null) && (aa.TtD == null))
    {
      paramg = this.TqV.n((kotlin.l.b.a.b.f.b)localObject1);
      AppMethodBeat.o(60163);
      return paramg;
    }
    Object localObject2 = paramg.hCL();
    if (localObject2 != null)
    {
      localObject1 = c((kotlin.l.b.a.b.d.a.e.g)localObject2);
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).hAN();
        if (localObject1 == null) {
          break label125;
        }
      }
      label125:
      for (paramg = ((kotlin.l.b.a.b.j.f.h)localObject1).c(paramg.hAH(), (a)c.TnU);; paramg = null)
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
    localObject2 = this.TIV;
    localObject1 = ((kotlin.l.b.a.b.f.b)localObject1).hJf();
    p.g(localObject1, "fqName.parent()");
    localObject1 = (kotlin.l.b.a.b.d.a.c.a.h)j.kt(((kotlin.l.b.a.b.d.a.c.g)localObject2).f((kotlin.l.b.a.b.f.b)localObject1));
    if (localObject1 != null)
    {
      paramg = ((kotlin.l.b.a.b.d.a.c.a.h)localObject1).d(paramg);
      AppMethodBeat.o(60163);
      return paramg;
    }
    AppMethodBeat.o(60163);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.b
 * JD-Core Version:    0.7.0.1
 */