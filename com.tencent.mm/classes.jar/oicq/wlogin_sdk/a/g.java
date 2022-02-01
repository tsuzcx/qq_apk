package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int Kje = 0;
  public int Kjf = 0;
  public int Kjg = 0;
  public int Kjh = 0;
  
  public g()
  {
    this.Kik = 261;
  }
  
  public final Boolean fMI()
  {
    AppMethodBeat.i(88108);
    if (this.KiU < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Kjf = util.ai(this.Kie, this.KiT);
    if (this.KiU < this.Kjf + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Kje = util.ai(this.Kie, this.KiT + 2 + this.Kjf);
    if (this.KiU < this.Kjf + 2 + 2 + this.Kje)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Kjh = (this.KiT + 2);
    this.Kjg = (this.Kjf + 2 + 2 + this.KiT);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */