package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int Kjs = 0;
  public int Kjt = 0;
  
  public z()
  {
    this.Kik = 293;
  }
  
  public final Boolean fMI()
  {
    AppMethodBeat.i(88115);
    if (this.KiU < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.Kjs = util.ai(this.Kie, this.KiT);
    if (this.KiU < this.Kjs + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.Kjt = util.ai(this.Kie, this.KiT + 2 + this.Kjs);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */