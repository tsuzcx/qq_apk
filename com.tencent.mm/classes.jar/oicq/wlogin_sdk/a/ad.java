package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int OoK = 0;
  
  public ad()
  {
    this.Ony = 312;
  }
  
  public final int gCA()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.OoK)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.am(this.Ons, this.Ooh + 4 + i * 10) == 266)
      {
        i = util.an(this.Ons, i * 10 + (this.Ooh + 4) + 2);
        AppMethodBeat.o(88117);
        return i;
      }
      i += 1;
    }
  }
  
  public final Boolean gCy()
  {
    AppMethodBeat.i(88116);
    if (this.Ooi < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.OoK = util.an(this.Ons, this.Ooh);
    if (this.Ooi < this.OoK * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */