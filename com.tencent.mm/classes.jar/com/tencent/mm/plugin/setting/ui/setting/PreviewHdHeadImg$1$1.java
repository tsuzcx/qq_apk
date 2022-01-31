package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vfs.e;

final class PreviewHdHeadImg$1$1
  implements n.c
{
  PreviewHdHeadImg$1$1(PreviewHdHeadImg.1 param1) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(126987);
    paraml.hx(1, 2131303216);
    Bitmap localBitmap = b.b(PreviewHdHeadImg.a(this.qGp.qGo), true, -1);
    o.acQ();
    if (e.cN(d.E(r.Zn() + ".last", true))) {
      paraml.hx(3, 2131303413);
    }
    if (localBitmap != null) {
      paraml.hx(2, 2131300526);
    }
    AppMethodBeat.o(126987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1.1
 * JD-Core Version:    0.7.0.1
 */