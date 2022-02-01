package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int ajIb = 0;
  
  public ab()
  {
    this.ajGQ = 306;
  }
  
  public final Boolean kGl()
  {
    AppMethodBeat.i(88110);
    if (this.ajHA < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    this.ajIb = util.aq(this.ajGK, this.ajHz);
    if (this.ajIb + 2 > this.ajHA)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88110);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ab
 * JD-Core Version:    0.7.0.1
 */