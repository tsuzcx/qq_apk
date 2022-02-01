package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int UdD = 0;
  
  public t()
  {
    this.Ucx = 282;
  }
  
  public final Boolean hPC()
  {
    AppMethodBeat.i(88142);
    if (this.Udh < 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    int i = util.am(this.Ucr, this.Udg + 2 + 1 + 1);
    if (this.Udh < i + 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    this.UdD = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88142);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */