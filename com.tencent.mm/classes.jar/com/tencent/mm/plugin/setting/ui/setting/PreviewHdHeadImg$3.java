package com.tencent.mm.plugin.setting.ui.setting;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;

final class PreviewHdHeadImg$3
  implements e.c
{
  PreviewHdHeadImg$3(PreviewHdHeadImg paramPreviewHdHeadImg, Bitmap paramBitmap) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126991);
    PreviewHdHeadImg.c(this.qGo).acU();
    ab.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.acQ();
      Bitmap localBitmap = d.rb(PreviewHdHeadImg.a(this.qGo));
      if (localBitmap != null)
      {
        PreviewHdHeadImg localPreviewHdHeadImg = this.qGo;
        o.acQ();
        PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, d.D(PreviewHdHeadImg.a(this.qGo), true));
      }
      for (;;)
      {
        AppMethodBeat.o(126991);
        return 0;
        PreviewHdHeadImg.a(this.qGo, this.qGq, null);
      }
    }
    PreviewHdHeadImg.a(this.qGo, this.qGq, null);
    AppMethodBeat.o(126991);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.3
 * JD-Core Version:    0.7.0.1
 */