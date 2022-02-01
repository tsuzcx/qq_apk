package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int abGX = 0;
  
  public ab()
  {
    this.abFM = 306;
  }
  
  public final Boolean iUK()
  {
    AppMethodBeat.i(88110);
    if (this.abGw < 2)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    this.abGX = util.ap(this.abFG, this.abGv);
    if (this.abGX + 2 > this.abGw)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88110);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88110);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ab
 * JD-Core Version:    0.7.0.1
 */