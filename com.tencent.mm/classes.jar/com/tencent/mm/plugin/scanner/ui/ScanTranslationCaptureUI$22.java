package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.widget.snackbar.b;
import java.io.IOException;

final class ScanTranslationCaptureUI$22
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$22(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81279);
    if (ScanTranslationCaptureUI.e(this.qAW) == 2) {
      try
      {
        ScanTranslationCaptureUI.j(this.qAW).cSS = 1L;
        q.a(ScanTranslationCaptureUI.o(this.qAW), this.qAW, false, -1);
        b.l(this.qAW, this.qAW.getString(2131302947));
        AppMethodBeat.o(81279);
        return;
      }
      catch (Exception paramView)
      {
        ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramView, "copy to gallery error", new Object[0]);
        AppMethodBeat.o(81279);
        return;
      }
    }
    if (ScanTranslationCaptureUI.e(this.qAW) == 3) {
      try
      {
        ScanTranslationCaptureUI.j(this.qAW).cSR = 1L;
        int i = ScanTranslationCaptureUI.p(this.qAW);
        if (i == 0) {}
        try
        {
          paramView = this.qAW;
          e.chX();
          ScanTranslationCaptureUI.a(paramView, e.Yu("jpg"));
          d.a(ScanTranslationCaptureUI.n(this.qAW), 80, Bitmap.CompressFormat.JPEG, ScanTranslationCaptureUI.q(this.qAW), false);
          q.a(ScanTranslationCaptureUI.q(this.qAW), this.qAW, false, -1);
          b.l(this.qAW, this.qAW.getString(2131302947));
          AppMethodBeat.o(81279);
          return;
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramView, "save translate result file error", new Object[0]);
          }
        }
        AppMethodBeat.o(81279);
      }
      catch (Exception paramView)
      {
        ab.printErrStackTrace("MicroMsg.ScanTranslationCaptureUI", paramView, "save to gallery error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.22
 * JD-Core Version:    0.7.0.1
 */