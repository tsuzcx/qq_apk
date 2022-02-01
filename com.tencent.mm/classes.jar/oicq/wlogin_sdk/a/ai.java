package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int LXl = 0;
  public int LXm = 0;
  public int LXn = 0;
  
  public ai()
  {
    this.LVT = 326;
  }
  
  public final Boolean gfy()
  {
    AppMethodBeat.i(88111);
    if (this.LWD < 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    int i = util.ah(this.LVN, this.LWC + 4);
    if (this.LWD < i + 12)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.LXl = i;
    i = util.ah(this.LVN, this.LWC + 6 + this.LXl);
    if (this.LWD < this.LXl + 12 + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.LXm = i;
    i = util.ah(this.LVN, this.LWC + 10 + this.LXl + this.LXm);
    if (this.LWD < this.LXl + 12 + this.LXm + i)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88111);
      return localBoolean;
    }
    this.LXn = i;
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88111);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */