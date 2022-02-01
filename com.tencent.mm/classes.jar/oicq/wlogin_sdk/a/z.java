package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int abGU = 0;
  public int abGV = 0;
  
  public z()
  {
    this.abFM = 293;
  }
  
  public final Boolean iUK()
  {
    AppMethodBeat.i(88115);
    if (this.abGw < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.abGU = util.ap(this.abFG, this.abGv);
    if (this.abGw < this.abGU + 2 + 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88115);
      return localBoolean;
    }
    this.abGV = util.ap(this.abFG, this.abGv + 2 + this.abGU);
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88115);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */