package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int OoJ = 0;
  
  public ab()
  {
    this.Ony = 306;
  }
  
  public final Boolean gCy()
  {
    AppMethodBeat.i(88110);
    if (this.Ooi < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    this.OoJ = util.am(this.Ons, this.Ooh);
    if (this.OoJ + 2 > this.Ooi)
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