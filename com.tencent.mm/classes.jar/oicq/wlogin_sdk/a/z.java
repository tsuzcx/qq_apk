package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int LXb = 0;
  public int LXc = 0;
  
  public z()
  {
    this.LVT = 293;
  }
  
  public final Boolean gfy()
  {
    AppMethodBeat.i(88115);
    if (this.LWD < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.LXb = util.ah(this.LVN, this.LWC);
    if (this.LWD < this.LXb + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.LXc = util.ah(this.LVN, this.LWC + 2 + this.LXb);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */