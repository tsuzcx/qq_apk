package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import java.util.List;

public final class g
  implements i
{
  h KeM;
  
  public final boolean fQh()
  {
    AppMethodBeat.i(96138);
    if ((this.KeM == null) || (this.KeM.KeB.size() == 0))
    {
      AppMethodBeat.o(96138);
      return false;
    }
    AppMethodBeat.o(96138);
    return true;
  }
  
  public final h fQi()
  {
    AppMethodBeat.i(96139);
    if ((this.KeM == null) || (this.KeM.KeB.size() == 0))
    {
      AppMethodBeat.o(96139);
      return null;
    }
    h localh = this.KeM;
    AppMethodBeat.o(96139);
    return localh;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.g
 * JD-Core Version:    0.7.0.1
 */