package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;

final class d$1
  implements f
{
  d$1(d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(80270);
    if ((paramm instanceof com.tencent.mm.roomsdk.a.a)) {
      ((com.tencent.mm.roomsdk.a.a)paramm).a(this.yjT.yjK);
    }
    if (this.yjT.yjK != null) {
      this.yjT.yjK.a(paramInt1, paramInt2, paramString, this.yjT.yjK);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.yjT.yjI != null)
      {
        this.yjT.yjI.a(paramInt1, paramInt2, paramString, this.yjT.yjI);
        AppMethodBeat.o(80270);
      }
    }
    else if (this.yjT.yjJ != null) {
      this.yjT.yjJ.a(paramInt1, paramInt2, paramString, this.yjT.yjJ);
    }
    AppMethodBeat.o(80270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d.1
 * JD-Core Version:    0.7.0.1
 */