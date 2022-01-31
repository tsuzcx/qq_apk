package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import java.util.List;

public final class g
  implements f
{
  h rlG;
  
  public final boolean cqa()
  {
    AppMethodBeat.i(36810);
    if ((this.rlG == null) || (this.rlG.rlv.size() == 0))
    {
      AppMethodBeat.o(36810);
      return false;
    }
    AppMethodBeat.o(36810);
    return true;
  }
  
  public final h cqb()
  {
    AppMethodBeat.i(36811);
    if ((this.rlG == null) || (this.rlG.rlv.size() == 0))
    {
      AppMethodBeat.o(36811);
      return null;
    }
    h localh = this.rlG;
    AppMethodBeat.o(36811);
    return localh;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.g
 * JD-Core Version:    0.7.0.1
 */