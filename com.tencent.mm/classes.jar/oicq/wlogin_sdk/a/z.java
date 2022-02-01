package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int ajHY = 0;
  public int ajHZ = 0;
  
  public z()
  {
    this.ajGQ = 293;
  }
  
  public final Boolean kGl()
  {
    AppMethodBeat.i(88115);
    if (this.ajHA < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.ajHY = util.aq(this.ajGK, this.ajHz);
    if (this.ajHA < this.ajHY + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.ajHZ = util.aq(this.ajGK, this.ajHz + 2 + this.ajHY);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */