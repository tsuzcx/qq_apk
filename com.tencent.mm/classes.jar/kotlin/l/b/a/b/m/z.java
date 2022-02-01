package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;

public final class z
  extends ay
{
  public final as[] TOb;
  public final av[] TOc;
  private final boolean TOd;
  
  public z(List<? extends as> paramList, List<? extends av> paramList1)
  {
    this(paramList, (av[])paramList1);
    AppMethodBeat.o(60753);
  }
  
  public z(as[] paramArrayOfas, av[] paramArrayOfav, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.TOb = paramArrayOfas;
    this.TOc = paramArrayOfav;
    this.TOd = paramBoolean;
    if (this.TOb.length <= this.TOc.length) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramArrayOfas = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.TOb.length + ", args=" + this.TOc.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfas;
    }
    AppMethodBeat.o(60752);
  }
  
  public final av N(ab paramab)
  {
    AppMethodBeat.i(60751);
    p.h(paramab, "key");
    h localh = paramab.hKE().hzS();
    paramab = localh;
    if (!(localh instanceof as)) {
      paramab = null;
    }
    paramab = (as)paramab;
    if (paramab == null)
    {
      AppMethodBeat.o(60751);
      return null;
    }
    int i = paramab.getIndex();
    if ((i < this.TOb.length) && (p.j(this.TOb[i].hzz(), paramab.hzz())))
    {
      paramab = this.TOc[i];
      AppMethodBeat.o(60751);
      return paramab;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean hKG()
  {
    return this.TOd;
  }
  
  public final boolean isEmpty()
  {
    return this.TOc.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */