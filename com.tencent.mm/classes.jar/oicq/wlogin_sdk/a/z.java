package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int UdF = 0;
  public int UdG = 0;
  
  public z()
  {
    this.Ucx = 293;
  }
  
  public final Boolean hPC()
  {
    AppMethodBeat.i(88115);
    if (this.Udh < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.UdF = util.an(this.Ucr, this.Udg);
    if (this.Udh < this.UdF + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.UdG = util.an(this.Ucr, this.Udg + 2 + this.UdF);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */