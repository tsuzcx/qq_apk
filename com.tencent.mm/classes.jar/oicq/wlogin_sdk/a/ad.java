package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int CNP = 0;
  
  public ad()
  {
    this.CMD = 312;
  }
  
  public final Boolean erf()
  {
    AppMethodBeat.i(96477);
    if (this.CNn < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96477);
      return localBoolean;
    }
    this.CNP = util.af(this.CMx, this.CNm);
    if (this.CNn < this.CNP * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96477);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(96477);
    return localBoolean;
  }
  
  public final int erh()
  {
    AppMethodBeat.i(96478);
    int i = 0;
    for (;;)
    {
      if (i >= this.CNP)
      {
        AppMethodBeat.o(96478);
        return 0;
      }
      if (util.ae(this.CMx, this.CNm + 4 + i * 10) == 266)
      {
        i = util.af(this.CMx, i * 10 + (this.CNm + 4) + 2);
        AppMethodBeat.o(96478);
        return i;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */