package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int NRE = 0;
  
  public ad()
  {
    this.NQs = 312;
  }
  
  public final Boolean gxW()
  {
    AppMethodBeat.i(88116);
    if (this.NRc < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.NRE = util.aj(this.NQm, this.NRb);
    if (this.NRc < this.NRE * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
  
  public final int gxY()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.NRE)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.ai(this.NQm, this.NRb + 4 + i * 10) == 266)
      {
        i = util.aj(this.NQm, i * 10 + (this.NRb + 4) + 2);
        AppMethodBeat.o(88117);
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