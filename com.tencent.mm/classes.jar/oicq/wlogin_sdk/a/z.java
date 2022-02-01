package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int OoG = 0;
  public int OoH = 0;
  
  public z()
  {
    this.Ony = 293;
  }
  
  public final Boolean gCy()
  {
    AppMethodBeat.i(88115);
    if (this.Ooi < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.OoG = util.am(this.Ons, this.Ooh);
    if (this.Ooi < this.OoG + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.OoH = util.am(this.Ons, this.Ooh + 2 + this.OoG);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */