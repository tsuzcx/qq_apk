package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int ajHW = 0;
  
  public t()
  {
    this.ajGQ = 282;
  }
  
  public final Boolean kGl()
  {
    AppMethodBeat.i(88142);
    if (this.ajHA < 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    int i = util.ap(this.ajGK, this.ajHz + 2 + 1 + 1);
    if (this.ajHA < i + 5)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88142);
      return localBoolean;
    }
    this.ajHW = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88142);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */