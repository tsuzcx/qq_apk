package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int CNL = 0;
  public int CNM = 0;
  
  public z()
  {
    this.CMD = 293;
  }
  
  public final Boolean erf()
  {
    AppMethodBeat.i(96476);
    if (this.CNn < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96476);
      return localBoolean;
    }
    this.CNL = util.ae(this.CMx, this.CNm);
    if (this.CNn < this.CNL + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96476);
      return localBoolean;
    }
    this.CNM = util.ae(this.CMx, this.CNm + 2 + this.CNL);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(96476);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */