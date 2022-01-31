package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int CNJ = 0;
  
  public t()
  {
    this.CMD = 282;
  }
  
  public final Boolean erf()
  {
    AppMethodBeat.i(96503);
    if (this.CNn < 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96503);
      return localBoolean;
    }
    int i = util.ad(this.CMx, this.CNm + 2 + 1 + 1);
    if (this.CNn < i + 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96503);
      return localBoolean;
    }
    this.CNJ = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(96503);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */