package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;

final class PreviewHdHeadImg$6
  implements Runnable
{
  PreviewHdHeadImg$6(PreviewHdHeadImg paramPreviewHdHeadImg, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(126994);
    ab.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(g.RG()), r.Zn() });
    if (g.RG())
    {
      if (this.val$bitmap != null)
      {
        o.acQ();
        str = d.E(r.Zn() + ".last", true);
        PreviewHdHeadImg.e(this.val$bitmap, str);
      }
      String str = b.qS(r.Zn());
      av.flM.po(str);
    }
    PreviewHdHeadImg.d(this.qGo);
    AppMethodBeat.o(126994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.6
 * JD-Core Version:    0.7.0.1
 */