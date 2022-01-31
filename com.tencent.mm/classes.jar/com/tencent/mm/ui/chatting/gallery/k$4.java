package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class k$4
  implements e.a
{
  k$4(k paramk) {}
  
  public final void Es()
  {
    AppMethodBeat.i(32389);
    al.d(new k.4.1(this));
    AppMethodBeat.o(32389);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32390);
    ab.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.zNL.rxA), Integer.valueOf(paramInt2), Integer.valueOf(this.zNL.zNJ), Integer.valueOf(this.zNL.zNK), this.zNL.czp });
    aw.RO().ac(new k.4.2(this, paramInt2, paramInt1));
    AppMethodBeat.o(32390);
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(32387);
    if (this.zNL.zKg != null) {
      this.zNL.zKg.zJQ.dKH();
    }
    AppMethodBeat.o(32387);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32388);
    ab.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramInt1 + " extra: " + paramInt2);
    if (this.zNL.zKg != null) {
      this.zNL.zKg.zJQ.hG(paramInt1, paramInt2);
    }
    h.qsU.e(12084, new Object[] { Integer.valueOf(this.zNL.zNJ), Integer.valueOf(this.zNL.rxA * 1000), Integer.valueOf(0), Integer.valueOf(4), this.zNL.czp, Integer.valueOf(this.zNL.zNK), this.zNL.fileId, Long.valueOf(this.zNL.createTime) });
    AppMethodBeat.o(32388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.4
 * JD-Core Version:    0.7.0.1
 */