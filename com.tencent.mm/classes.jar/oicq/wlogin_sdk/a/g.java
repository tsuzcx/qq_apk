package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int Oos = 0;
  public int Oot = 0;
  public int Oou = 0;
  public int Oov = 0;
  
  public g()
  {
    this.Ony = 261;
  }
  
  public final Boolean gCy()
  {
    AppMethodBeat.i(88108);
    if (this.Ooi < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Oot = util.am(this.Ons, this.Ooh);
    if (this.Ooi < this.Oot + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Oos = util.am(this.Ons, this.Ooh + 2 + this.Oot);
    if (this.Ooi < this.Oot + 2 + 2 + this.Oos)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.Oov = (this.Ooh + 2);
    this.Oou = (this.Oot + 2 + 2 + this.Ooh);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */