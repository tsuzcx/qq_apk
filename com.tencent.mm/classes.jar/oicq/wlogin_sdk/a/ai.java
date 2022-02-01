package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int NRK = 0;
  public int NRL = 0;
  public int NRM = 0;
  
  public ai()
  {
    this.NQs = 326;
  }
  
  public final Boolean gxW()
  {
    AppMethodBeat.i(88111);
    if (this.NRc < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.ai(this.NQm, this.NRb + 4);
    if (this.NRc < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.NRK = i;
    i = util.ai(this.NQm, this.NRb + 6 + this.NRK);
    if (this.NRc < this.NRK + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.NRL = i;
    i = util.ai(this.NQm, this.NRb + 10 + this.NRK + this.NRL);
    if (this.NRc < this.NRK + 12 + this.NRL + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.NRM = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */