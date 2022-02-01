package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int OoE = 0;
  
  public t()
  {
    this.Ony = 282;
  }
  
  public final Boolean gCy()
  {
    AppMethodBeat.i(88142);
    if (this.Ooi < 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    int i = util.al(this.Ons, this.Ooh + 2 + 1 + 1);
    if (this.Ooi < i + 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    this.OoE = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88142);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */