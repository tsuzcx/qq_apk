package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int abGG = 0;
  public int abGH = 0;
  public int abGI = 0;
  public int abGJ = 0;
  
  public g()
  {
    this.abFM = 261;
  }
  
  public final Boolean iUK()
  {
    AppMethodBeat.i(88108);
    if (this.abGw < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.abGH = util.ap(this.abFG, this.abGv);
    if (this.abGw < this.abGH + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.abGG = util.ap(this.abFG, this.abGv + 2 + this.abGH);
    if (this.abGw < this.abGH + 2 + 2 + this.abGG)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88108);
      return localBoolean;
    }
    this.abGJ = (this.abGv + 2);
    this.abGI = (this.abGH + 2 + 2 + this.abGv);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88108);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */