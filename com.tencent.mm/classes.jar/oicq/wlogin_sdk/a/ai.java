package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int KjC = 0;
  public int KjD = 0;
  public int KjE = 0;
  
  public ai()
  {
    this.Kik = 326;
  }
  
  public final Boolean fMI()
  {
    AppMethodBeat.i(88111);
    if (this.KiU < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.ai(this.Kie, this.KiT + 4);
    if (this.KiU < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.KjC = i;
    i = util.ai(this.Kie, this.KiT + 6 + this.KjC);
    if (this.KiU < this.KjC + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.KjD = i;
    i = util.ai(this.Kie, this.KiT + 10 + this.KjC + this.KjD);
    if (this.KiU < this.KjC + 12 + this.KjD + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.KjE = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */