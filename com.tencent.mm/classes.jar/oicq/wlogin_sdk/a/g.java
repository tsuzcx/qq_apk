package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int Udr = 0;
  public int Uds = 0;
  public int Udt = 0;
  public int Udu = 0;
  
  public g()
  {
    this.Ucx = 261;
  }
  
  public final Boolean hPC()
  {
    AppMethodBeat.i(88108);
    if (this.Udh < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Uds = util.an(this.Ucr, this.Udg);
    if (this.Udh < this.Uds + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Udr = util.an(this.Ucr, this.Udg + 2 + this.Uds);
    if (this.Udh < this.Uds + 2 + 2 + this.Udr)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Udu = (this.Udg + 2);
    this.Udt = (this.Uds + 2 + 2 + this.Udg);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */