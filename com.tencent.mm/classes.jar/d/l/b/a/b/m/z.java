package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import java.util.List;

public final class z
  extends ay
{
  public final as[] JXN;
  public final av[] JXO;
  private final boolean JXP;
  
  public z(List<? extends as> paramList, List<? extends av> paramList1)
  {
    this(paramList, (av[])paramList1);
    AppMethodBeat.o(60753);
  }
  
  public z(as[] paramArrayOfas, av[] paramArrayOfav, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.JXN = paramArrayOfas;
    this.JXO = paramArrayOfav;
    this.JXP = paramBoolean;
    if (this.JXN.length <= this.JXO.length) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramArrayOfas = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.JXN.length + ", args=" + this.JXO.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfas;
    }
    AppMethodBeat.o(60752);
  }
  
  public final av O(ab paramab)
  {
    AppMethodBeat.i(60751);
    k.h(paramab, "key");
    h localh = paramab.fIW().fxM();
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
    if ((i < this.JXN.length) && (k.g(this.JXN[i].fxs(), paramab.fxs())))
    {
      paramab = this.JXO[i];
      AppMethodBeat.o(60751);
      return paramab;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean fIY()
  {
    return this.JXP;
  }
  
  public final boolean isEmpty()
  {
    return this.JXO.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */