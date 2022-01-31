package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int CNO = 0;
  
  public ab()
  {
    this.CMD = 306;
  }
  
  public final Boolean erf()
  {
    AppMethodBeat.i(96471);
    if (this.CNn < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96471);
      return localBoolean;
    }
    this.CNO = util.ae(this.CMx, this.CNm);
    if (this.CNO + 2 > this.CNn)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(96471);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(96471);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ab
 * JD-Core Version:    0.7.0.1
 */