package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import java.util.List;

public final class g
  implements f
{
  h zHF;
  
  public final boolean dZa()
  {
    AppMethodBeat.i(96138);
    if ((this.zHF == null) || (this.zHF.zHu.size() == 0))
    {
      AppMethodBeat.o(96138);
      return false;
    }
    AppMethodBeat.o(96138);
    return true;
  }
  
  public final h dZb()
  {
    AppMethodBeat.i(96139);
    if ((this.zHF == null) || (this.zHF.zHu.size() == 0))
    {
      AppMethodBeat.o(96139);
      return null;
    }
    h localh = this.zHF;
    AppMethodBeat.o(96139);
    return localh;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.g
 * JD-Core Version:    0.7.0.1
 */