package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import java.util.List;

public final class g
  implements i
{
  h DRF;
  
  public final boolean fco()
  {
    AppMethodBeat.i(96138);
    if ((this.DRF == null) || (this.DRF.DRu.size() == 0))
    {
      AppMethodBeat.o(96138);
      return false;
    }
    AppMethodBeat.o(96138);
    return true;
  }
  
  public final h fcp()
  {
    AppMethodBeat.i(96139);
    if ((this.DRF == null) || (this.DRF.DRu.size() == 0))
    {
      AppMethodBeat.o(96139);
      return null;
    }
    h localh = this.DRF;
    AppMethodBeat.o(96139);
    return localh;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.g
 * JD-Core Version:    0.7.0.1
 */