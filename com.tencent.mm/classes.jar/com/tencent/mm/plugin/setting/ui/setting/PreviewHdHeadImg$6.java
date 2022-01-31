package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;

final class PreviewHdHeadImg$6
  implements Runnable
{
  PreviewHdHeadImg$6(PreviewHdHeadImg paramPreviewHdHeadImg, Bitmap paramBitmap) {}
  
  public final void run()
  {
    y.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(g.DK()), q.Gj() });
    if (g.DK())
    {
      if (this.ara != null)
      {
        o.JQ();
        str = d.A(q.Gj() + ".last", true);
        PreviewHdHeadImg.e(this.ara, str);
      }
      String str = b.jZ(q.Gj());
      at.dVC.iF(str);
    }
    PreviewHdHeadImg.d(this.nSq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.6
 * JD-Core Version:    0.7.0.1
 */