package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int NRA = 0;
  public int NRB = 0;
  
  public z()
  {
    this.NQs = 293;
  }
  
  public final Boolean gxW()
  {
    AppMethodBeat.i(88115);
    if (this.NRc < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.NRA = util.ai(this.NQm, this.NRb);
    if (this.NRc < this.NRA + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.NRB = util.ai(this.NQm, this.NRb + 2 + this.NRA);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */