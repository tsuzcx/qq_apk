package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int NRm = 0;
  public int NRn = 0;
  public int NRo = 0;
  public int NRp = 0;
  
  public g()
  {
    this.NQs = 261;
  }
  
  public final Boolean gxW()
  {
    AppMethodBeat.i(88108);
    if (this.NRc < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.NRn = util.ai(this.NQm, this.NRb);
    if (this.NRc < this.NRn + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.NRm = util.ai(this.NQm, this.NRb + 2 + this.NRn);
    if (this.NRc < this.NRn + 2 + 2 + this.NRm)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.NRp = (this.NRb + 2);
    this.NRo = (this.NRn + 2 + 2 + this.NRb);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */