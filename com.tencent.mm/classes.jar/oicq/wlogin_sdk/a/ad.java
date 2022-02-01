package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int Kjw = 0;
  
  public ad()
  {
    this.Kik = 312;
  }
  
  public final Boolean fMI()
  {
    AppMethodBeat.i(88116);
    if (this.KiU < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.Kjw = util.aj(this.Kie, this.KiT);
    if (this.KiU < this.Kjw * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
  
  public final int fMK()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.Kjw)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.ai(this.Kie, this.KiT + 4 + i * 10) == 266)
      {
        i = util.aj(this.Kie, i * 10 + (this.KiT + 4) + 2);
        AppMethodBeat.o(88117);
        return i;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */