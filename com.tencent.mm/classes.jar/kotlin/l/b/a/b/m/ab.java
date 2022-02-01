package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;

public final class ab
  extends bc
{
  public final ba[] ajpK;
  public final az[] ajpL;
  private final boolean ajpM;
  
  public ab(List<? extends ba> paramList, List<? extends az> paramList1)
  {
    this(paramList, (az[])paramList1);
    AppMethodBeat.i(60753);
    AppMethodBeat.o(60753);
  }
  
  public ab(ba[] paramArrayOfba, az[] paramArrayOfaz, boolean paramBoolean)
  {
    AppMethodBeat.i(60752);
    this.ajpK = paramArrayOfba;
    this.ajpL = paramArrayOfaz;
    this.ajpM = paramBoolean;
    if (this.ajpK.length <= this.ajpL.length) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramArrayOfba = (Throwable)new AssertionError("Number of arguments should not be less than number of parameters, but: parameters=" + this.ajpK.length + ", args=" + this.ajpL.length);
      AppMethodBeat.o(60752);
      throw paramArrayOfba;
    }
    AppMethodBeat.o(60752);
  }
  
  public final az G(ad paramad)
  {
    AppMethodBeat.i(60751);
    s.u(paramad, "key");
    paramad = paramad.kzm().knA();
    if ((paramad instanceof ba)) {}
    for (paramad = (ba)paramad; paramad == null; paramad = null)
    {
      AppMethodBeat.o(60751);
      return null;
    }
    int i = paramad.getIndex();
    if ((i < this.ajpK.length) && (s.p(this.ajpK[i].kmZ(), paramad.kmZ())))
    {
      paramad = this.ajpL[i];
      AppMethodBeat.o(60751);
      return paramad;
    }
    AppMethodBeat.o(60751);
    return null;
  }
  
  public final boolean isEmpty()
  {
    return this.ajpL.length == 0;
  }
  
  public final boolean kzo()
  {
    return this.ajpM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ab
 * JD-Core Version:    0.7.0.1
 */