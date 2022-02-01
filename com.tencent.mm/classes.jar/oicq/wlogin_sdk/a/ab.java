package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int LXe = 0;
  
  public ab()
  {
    this.LVT = 306;
  }
  
  public final Boolean gfy()
  {
    AppMethodBeat.i(88110);
    if (this.LWD < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    this.LXe = util.ah(this.LVN, this.LWC);
    if (this.LXe + 2 > this.LWD)
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