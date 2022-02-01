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
  public final as[] LLg;
  public final av[] LLh;
  private final boolean LLi;
  
  public z(List<? extends as> paramList, List<? extends av> paramList1)
  {
    this(paramList, (av[])paramList1);
    AppMethodBeat.o(60753);
  }
  
  public z(as[] paramArrayOfas, av[] paramArrayOfav, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.LLg = paramArrayOfas;
    this.LLh = paramArrayOfav;
    this.LLi = paramBoolean;
    if (this.LLg.length <= this.LLh.length) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramArrayOfas = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.LLg.length + ", args=" + this.LLh.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfas;
    }
    AppMethodBeat.o(60752);
  }
  
  public final av O(ab paramab)
  {
    AppMethodBeat.i(60751);
    k.h(paramab, "key");
    h localh = paramab.gbz().fQq();
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
    if ((i < this.LLg.length) && (k.g(this.LLg[i].fPW(), paramab.fPW())))
    {
      paramab = this.LLh[i];
      AppMethodBeat.o(60751);
      return paramab;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean gbB()
  {
    return this.LLi;
  }
  
  public final boolean isEmpty()
  {
    return this.LLh.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */