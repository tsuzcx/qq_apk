package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.snackbar.b;

final class ScanTranslationCaptureUI$21
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$21(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    if (ScanTranslationCaptureUI.i(this.nNm) == 2) {}
    while (ScanTranslationCaptureUI.i(this.nNm) != 3) {
      try
      {
        ScanTranslationCaptureUI.g(this.nNm)[8] = 1;
        q.a(ScanTranslationCaptureUI.o(this.nNm), this.nNm);
        b.h(this.nNm, this.nNm.getString(R.l.scan_translation_save_to_gallery_success));
        return;
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramView, "copy to gallery error", new Object[0]);
        return;
      }
    }
    for (;;)
    {
      try
      {
        ScanTranslationCaptureUI.g(this.nNm)[7] = 1;
        ScanTranslationCaptureUI.a(this.nNm, r.Mm("jpg"));
        com.tencent.mm.vfs.e.aeW(r.byD());
        if (!com.tencent.mm.a.e.bK(ScanTranslationCaptureUI.p(this.nNm)))
        {
          c.a(ScanTranslationCaptureUI.n(this.nNm), 80, Bitmap.CompressFormat.JPEG, ScanTranslationCaptureUI.p(this.nNm), false);
          q.a(ScanTranslationCaptureUI.p(this.nNm), this.nNm);
          b.h(this.nNm, this.nNm.getString(R.l.scan_translation_save_to_gallery_success));
          return;
        }
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramView, "save to gallery error", new Object[0]);
        return;
      }
      y.i("MicroMsg.ScanTranslationCaptureUI", "translate result file is already exists.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.21
 * JD-Core Version:    0.7.0.1
 */