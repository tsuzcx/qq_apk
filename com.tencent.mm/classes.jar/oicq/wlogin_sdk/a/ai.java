package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int UdP = 0;
  public int UdQ = 0;
  public int UdR = 0;
  
  public ai()
  {
    this.Ucx = 326;
  }
  
  public final Boolean hPC()
  {
    AppMethodBeat.i(88111);
    if (this.Udh < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.an(this.Ucr, this.Udg + 4);
    if (this.Udh < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.UdP = i;
    i = util.an(this.Ucr, this.Udg + 6 + this.UdP);
    if (this.Udh < this.UdP + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.UdQ = i;
    i = util.an(this.Ucr, this.Udg + 10 + this.UdP + this.UdQ);
    if (this.Udh < this.UdP + 12 + this.UdQ + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.UdR = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */