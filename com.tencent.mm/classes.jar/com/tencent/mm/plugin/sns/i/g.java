package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import java.util.List;

public final class g
  implements com.tencent.mm.al.g
{
  h wNM;
  
  public final boolean duM()
  {
    AppMethodBeat.i(96138);
    if ((this.wNM == null) || (this.wNM.wNB.size() == 0))
    {
      AppMethodBeat.o(96138);
      return false;
    }
    AppMethodBeat.o(96138);
    return true;
  }
  
  public final h duN()
  {
    AppMethodBeat.i(96139);
    if ((this.wNM == null) || (this.wNM.wNB.size() == 0))
    {
      AppMethodBeat.o(96139);
      return null;
    }
    h localh = this.wNM;
    AppMethodBeat.o(96139);
    return localh;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.g
 * JD-Core Version:    0.7.0.1
 */