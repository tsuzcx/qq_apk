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
  public final as[] NCb;
  public final av[] NCc;
  private final boolean NCd;
  
  public z(List<? extends as> paramList, List<? extends av> paramList1)
  {
    this(paramList, (av[])paramList1);
    AppMethodBeat.o(60753);
  }
  
  public z(as[] paramArrayOfas, av[] paramArrayOfav, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.NCb = paramArrayOfas;
    this.NCc = paramArrayOfav;
    this.NCd = paramBoolean;
    if (this.NCb.length <= this.NCc.length) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      paramArrayOfas = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.NCb.length + ", args=" + this.NCc.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfas;
    }
    AppMethodBeat.o(60752);
  }
  
  public final av O(ab paramab)
  {
    AppMethodBeat.i(60751);
    p.h(paramab, "key");
    h localh = paramab.gsZ().ghO();
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
    if ((i < this.NCb.length) && (p.i(this.NCb[i].ghu(), paramab.ghu())))
    {
      paramab = this.NCc[i];
      AppMethodBeat.o(60751);
      return paramab;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean gtb()
  {
    return this.NCd;
  }
  
  public final boolean isEmpty()
  {
    return this.NCc.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */