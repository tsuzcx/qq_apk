package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int abHe = 0;
  public int abHf = 0;
  public int abHg = 0;
  
  public ai()
  {
    this.abFM = 326;
  }
  
  public final Boolean iUK()
  {
    AppMethodBeat.i(88111);
    if (this.abGw < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.ap(this.abFG, this.abGv + 4);
    if (this.abGw < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.abHe = i;
    i = util.ap(this.abFG, this.abGv + 6 + this.abHe);
    if (this.abGw < this.abHe + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.abHf = i;
    i = util.ap(this.abFG, this.abGv + 10 + this.abHe + this.abHf);
    if (this.abGw < this.abHe + 12 + this.abHf + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.abHg = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */