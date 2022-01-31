package com.tencent.mm.ui.chatting;

import com.tencent.mm.modelvideo.h.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;

final class k$4$1
  implements h.a
{
  k$4$1(k.4 param4, String paramString) {}
  
  public final void bw(int paramInt1, int paramInt2)
  {
    s locals = u.oe(this.vjj);
    locals.status = 111;
    locals.bcw = 256;
    o.Sr().c(locals);
    y.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.4.1
 * JD-Core Version:    0.7.0.1
 */