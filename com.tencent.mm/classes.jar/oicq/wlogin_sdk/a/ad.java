package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int LXf = 0;
  
  public ad()
  {
    this.LVT = 312;
  }
  
  public final int gfA()
  {
    AppMethodBeat.i(88117);
    int i = 0;
    for (;;)
    {
      if (i >= this.LXf)
      {
        AppMethodBeat.o(88117);
        return 0;
      }
      if (util.ah(this.LVN, this.LWC + 4 + i * 10) == 266)
      {
        i = util.ai(this.LVN, i * 10 + (this.LWC + 4) + 2);
        AppMethodBeat.o(88117);
        return i;
      }
      i += 1;
    }
  }
  
  public final Boolean gfy()
  {
    AppMethodBeat.i(88116);
    if (this.LWD < 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    this.LXf = util.ai(this.LVN, this.LWC);
    if (this.LWD < this.LXf * 10 + 4)
    {
      localBoolean = Boolean.FALSE;
      AppMethodBeat.o(88116);
      return localBoolean;
    }
    Boolean localBoolean = Boolean.TRUE;
    AppMethodBeat.o(88116);
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */