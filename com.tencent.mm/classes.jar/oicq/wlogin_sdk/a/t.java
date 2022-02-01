package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int NRy = 0;
  
  public t()
  {
    this.NQs = 282;
  }
  
  public final Boolean gxW()
  {
    AppMethodBeat.i(88142);
    if (this.NRc < 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    int i = util.ah(this.NQm, this.NRb + 2 + 1 + 1);
    if (this.NRc < i + 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    this.NRy = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88142);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */