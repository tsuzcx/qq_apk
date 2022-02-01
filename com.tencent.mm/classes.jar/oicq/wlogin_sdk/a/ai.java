package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int OoQ = 0;
  public int OoR = 0;
  public int OoS = 0;
  
  public ai()
  {
    this.Ony = 326;
  }
  
  public final Boolean gCy()
  {
    AppMethodBeat.i(88111);
    if (this.Ooi < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.am(this.Ons, this.Ooh + 4);
    if (this.Ooi < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.OoQ = i;
    i = util.am(this.Ons, this.Ooh + 6 + this.OoQ);
    if (this.Ooi < this.OoQ + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.OoR = i;
    i = util.am(this.Ons, this.Ooh + 10 + this.OoQ + this.OoR);
    if (this.Ooi < this.OoQ + 12 + this.OoR + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.OoS = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */