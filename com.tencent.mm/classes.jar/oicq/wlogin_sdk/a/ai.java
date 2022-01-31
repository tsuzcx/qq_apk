package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int CNU = 0;
  public int CNV = 0;
  public int CNW = 0;
  
  public ai()
  {
    this.CMD = 326;
  }
  
  public final Boolean erf()
  {
    AppMethodBeat.i(96472);
    if (this.CNn < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96472);
      return localBoolean;
    }
    int i = util.ae(this.CMx, this.CNm + 4);
    if (this.CNn < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96472);
      return localBoolean;
    }
    this.CNU = i;
    i = util.ae(this.CMx, this.CNm + 6 + this.CNU);
    if (this.CNn < this.CNU + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96472);
      return localBoolean;
    }
    this.CNV = i;
    i = util.ae(this.CMx, this.CNm + 10 + this.CNU + this.CNV);
    if (this.CNn < this.CNU + 12 + this.CNV + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96472);
      return localBoolean;
    }
    this.CNW = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(96472);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */