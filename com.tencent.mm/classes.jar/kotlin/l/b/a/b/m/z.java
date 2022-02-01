package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;

public final class z
  extends ay
{
  public final as[] abqB;
  public final av[] abqC;
  private final boolean abqD;
  
  public z(List<? extends as> paramList, List<? extends av> paramList1)
  {
    this(paramList, (av[])paramList1);
    AppMethodBeat.o(60753);
  }
  
  public z(as[] paramArrayOfas, av[] paramArrayOfav, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.abqB = paramArrayOfas;
    this.abqC = paramArrayOfav;
    this.abqD = paramBoolean;
    if (this.abqB.length <= this.abqC.length) {}
    for (int i = 1; (kotlin.z.aazO) && (i == 0); i = 0)
    {
      paramArrayOfas = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.abqB.length + ", args=" + this.abqC.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfas;
    }
    AppMethodBeat.o(60752);
  }
  
  public final av N(ab paramab)
  {
    AppMethodBeat.i(60751);
    p.k(paramab, "key");
    h localh = paramab.iOU().iEf();
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
    if ((i < this.abqB.length) && (p.h(this.abqB[i].iDL(), paramab.iDL())))
    {
      paramab = this.abqC[i];
      AppMethodBeat.o(60751);
      return paramab;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean iOW()
  {
    return this.abqD;
  }
  
  public final boolean isEmpty()
  {
    return this.abqC.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.z
 * JD-Core Version:    0.7.0.1
 */