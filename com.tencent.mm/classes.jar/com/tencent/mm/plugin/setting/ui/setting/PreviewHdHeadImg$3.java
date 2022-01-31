package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.e.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.y;

final class PreviewHdHeadImg$3
  implements e.b
{
  PreviewHdHeadImg$3(PreviewHdHeadImg paramPreviewHdHeadImg, Bitmap paramBitmap) {}
  
  public final int bl(int paramInt1, int paramInt2)
  {
    PreviewHdHeadImg.c(this.nSq).JU();
    y.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.JQ();
      Bitmap localBitmap = d.kh(PreviewHdHeadImg.a(this.nSq));
      if (localBitmap != null)
      {
        PreviewHdHeadImg localPreviewHdHeadImg = this.nSq;
        o.JQ();
        PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, d.z(PreviewHdHeadImg.a(this.nSq), true));
        return 0;
      }
      PreviewHdHeadImg.a(this.nSq, this.nSs, null);
      return 0;
    }
    PreviewHdHeadImg.a(this.nSq, this.nSs, null);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.3
 * JD-Core Version:    0.7.0.1
 */