package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int UdJ = 0;
  
  public ad()
  {
    this.Ucx = 312;
  }
  
  public final Boolean hPC()
  {
    AppMethodBeat.i(88116);
    if (this.Udh < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.UdJ = util.ao(this.Ucr, this.Udg);
    if (this.Udh < this.UdJ * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
  
  public final int hPE()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.UdJ)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.an(this.Ucr, this.Udg + 4 + i * 10) == 266)
      {
        i = util.ao(this.Ucr, i * 10 + (this.Udg + 4) + 2);
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