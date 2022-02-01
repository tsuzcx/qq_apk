package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int ajIc = 0;
  
  public ad()
  {
    this.ajGQ = 312;
  }
  
  public final Boolean kGl()
  {
    AppMethodBeat.i(88116);
    if (this.ajHA < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.ajIc = util.ar(this.ajGK, this.ajHz);
    if (this.ajHA < this.ajIc * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
  
  public final int kGn()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.ajIc)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.aq(this.ajGK, this.ajHz + 4 + i * 10) == 266)
      {
        i = util.ar(this.ajGK, i * 10 + (this.ajHz + 4) + 2);
        AppMethodBeat.o(88117);
        return i;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */