package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class k$4$2
  implements Runnable
{
  k$4$2(k.4 param4, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(32386);
    h localh = h.qsU;
    int j = this.zNO.zNL.zNJ;
    if (this.qUL <= 0) {}
    for (int i = this.zNO.zNL.rxA * 1000;; i = this.qUL)
    {
      localh.e(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.ieP), Integer.valueOf(1), this.zNO.zNL.czp, Integer.valueOf(this.zNO.zNL.zNK), this.zNO.zNL.fileId, Long.valueOf(this.zNO.zNL.createTime) });
      AppMethodBeat.o(32386);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.4.2
 * JD-Core Version:    0.7.0.1
 */