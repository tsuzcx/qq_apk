package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int LWN = 0;
  public int LWO = 0;
  public int LWP = 0;
  public int LWQ = 0;
  
  public g()
  {
    this.LVT = 261;
  }
  
  public final Boolean gfy()
  {
    AppMethodBeat.i(88108);
    if (this.LWD < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.LWO = util.ah(this.LVN, this.LWC);
    if (this.LWD < this.LWO + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.LWN = util.ah(this.LVN, this.LWC + 2 + this.LWO);
    if (this.LWD < this.LWO + 2 + 2 + this.LWN)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.LWQ = (this.LWC + 2);
    this.LWP = (this.LWO + 2 + 2 + this.LWC);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */