package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int ajHK = 0;
  public int ajHL = 0;
  public int ajHM = 0;
  public int ajHN = 0;
  
  public g()
  {
    this.ajGQ = 261;
  }
  
  public final Boolean kGl()
  {
    AppMethodBeat.i(88108);
    if (this.ajHA < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.ajHL = util.aq(this.ajGK, this.ajHz);
    if (this.ajHA < this.ajHL + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.ajHK = util.aq(this.ajGK, this.ajHz + 2 + this.ajHL);
    if (this.ajHA < this.ajHL + 2 + 2 + this.ajHK)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.ajHN = (this.ajHz + 2);
    this.ajHM = (this.ajHL + 2 + 2 + this.ajHz);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */