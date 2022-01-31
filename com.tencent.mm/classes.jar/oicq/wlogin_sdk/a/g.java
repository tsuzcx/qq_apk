package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int CNA = 0;
  public int CNx = 0;
  public int CNy = 0;
  public int CNz = 0;
  
  public g()
  {
    this.CMD = 261;
  }
  
  public final Boolean erf()
  {
    AppMethodBeat.i(96469);
    if (this.CNn < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96469);
      return localBoolean;
    }
    this.CNy = util.ae(this.CMx, this.CNm);
    if (this.CNn < this.CNy + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96469);
      return localBoolean;
    }
    this.CNx = util.ae(this.CMx, this.CNm + 2 + this.CNy);
    if (this.CNn < this.CNy + 2 + 2 + this.CNx)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96469);
      return localBoolean;
    }
    this.CNA = (this.CNm + 2);
    this.CNz = (this.CNy + 2 + 2 + this.CNm);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(96469);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */