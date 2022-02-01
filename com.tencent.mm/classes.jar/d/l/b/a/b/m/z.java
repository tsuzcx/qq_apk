package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.b.p;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import java.util.List;

public final class z
  extends ay
{
  public final as[] NZi;
  public final av[] NZj;
  private final boolean NZk;
  
  public z(List<? extends as> paramList, List<? extends av> paramList1)
  {
    this(paramList, (av[])paramList1);
    AppMethodBeat.o(60753);
  }
  
  public z(as[] paramArrayOfas, av[] paramArrayOfav, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.NZi = paramArrayOfas;
    this.NZj = paramArrayOfav;
    this.NZk = paramBoolean;
    if (this.NZi.length <= this.NZj.length) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramArrayOfas = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.NZi.length + ", args=" + this.NZj.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfas;
    }
    AppMethodBeat.o(60752);
  }
  
  public final av O(ab paramab)
  {
    AppMethodBeat.i(60751);
    p.h(paramab, "key");
    h localh = paramab.gxB().gmq();
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
    if ((i < this.NZi.length) && (p.i(this.NZi[i].glW(), paramab.glW())))
    {
      paramab = this.NZj[i];
      AppMethodBeat.o(60751);
      return paramab;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean gxD()
  {
    return this.NZk;
  }
  
  public final boolean isEmpty()
  {
    return this.NZj.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */