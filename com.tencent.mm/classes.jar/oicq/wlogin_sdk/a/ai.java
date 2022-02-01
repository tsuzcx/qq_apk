package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int ajIi = 0;
  public int ajIj = 0;
  public int ajIk = 0;
  
  public ai()
  {
    this.ajGQ = 326;
  }
  
  public final Boolean kGl()
  {
    AppMethodBeat.i(88111);
    if (this.ajHA < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.aq(this.ajGK, this.ajHz + 4);
    if (this.ajHA < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.ajIi = i;
    i = util.aq(this.ajGK, this.ajHz + 6 + this.ajIi);
    if (this.ajHA < this.ajIi + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.ajIj = i;
    i = util.aq(this.ajGK, this.ajHz + 10 + this.ajIi + this.ajIj);
    if (this.ajHA < this.ajIi + 12 + this.ajIj + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.ajIk = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */