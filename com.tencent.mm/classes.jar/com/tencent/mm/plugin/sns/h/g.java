package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import java.util.List;

public final class g
  implements f
{
  h zqq;
  
  public final h dVA()
  {
    AppMethodBeat.i(96139);
    if ((this.zqq == null) || (this.zqq.zqf.size() == 0))
    {
      AppMethodBeat.o(96139);
      return null;
    }
    h localh = this.zqq;
    AppMethodBeat.o(96139);
    return localh;
  }
  
  public final boolean dVz()
  {
    AppMethodBeat.i(96138);
    if ((this.zqq == null) || (this.zqq.zqf.size() == 0))
    {
      AppMethodBeat.o(96138);
      return false;
    }
    AppMethodBeat.o(96138);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.g
 * JD-Core Version:    0.7.0.1
 */