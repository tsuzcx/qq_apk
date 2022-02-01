package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int abGY = 0;
  
  public ad()
  {
    this.abFM = 312;
  }
  
  public final Boolean iUK()
  {
    AppMethodBeat.i(88116);
    if (this.abGw < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.abGY = util.aq(this.abFG, this.abGv);
    if (this.abGw < this.abGY * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
  
  public final int iUM()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.abGY)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.ap(this.abFG, this.abGv + 4 + i * 10) == 266)
      {
        i = util.aq(this.abFG, i * 10 + (this.abGv + 4) + 2);
        AppMethodBeat.o(88117);
        return i;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */