package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int LWZ = 0;
  
  public t()
  {
    this.LVT = 282;
  }
  
  public final Boolean gfy()
  {
    AppMethodBeat.i(88142);
    if (this.LWD < 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    int i = util.ag(this.LVN, this.LWC + 2 + 1 + 1);
    if (this.LWD < i + 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    this.LWZ = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88142);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */