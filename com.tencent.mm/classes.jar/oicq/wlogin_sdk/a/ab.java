package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int UdI = 0;
  
  public ab()
  {
    this.Ucx = 306;
  }
  
  public final Boolean hPC()
  {
    AppMethodBeat.i(88110);
    if (this.Udh < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    this.UdI = util.an(this.Ucr, this.Udg);
    if (this.UdI + 2 > this.Udh)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ab
 * JD-Core Version:    0.7.0.1
 */