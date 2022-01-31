package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.t;

final class ScanTranslationCaptureUI$21
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$21(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81278);
    if (ScanTranslationCaptureUI.e(this.qAW) == 3)
    {
      if (ScanTranslationCaptureUI.k(this.qAW) != null) {
        ScanTranslationCaptureUI.a(this.qAW, ScanTranslationCaptureUI.k(this.qAW));
      }
      if (ScanTranslationCaptureUI.l(this.qAW).equalsIgnoreCase("zh_CN")) {
        ScanTranslationCaptureUI.m(this.qAW).setImageResource(2131232134);
      }
      for (;;)
      {
        ScanTranslationCaptureUI.a(this.qAW, 2);
        ScanTranslationCaptureUI.j(this.qAW).cSQ += 1L;
        AppMethodBeat.o(81278);
        return;
        ScanTranslationCaptureUI.m(this.qAW).setImageResource(2131232137);
      }
    }
    if (ScanTranslationCaptureUI.e(this.qAW) == 2)
    {
      if (ScanTranslationCaptureUI.n(this.qAW) != null) {
        ScanTranslationCaptureUI.a(this.qAW, ScanTranslationCaptureUI.n(this.qAW));
      }
      if (!ScanTranslationCaptureUI.l(this.qAW).equalsIgnoreCase("zh_CN")) {
        break label196;
      }
      ScanTranslationCaptureUI.m(this.qAW).setImageResource(2130840623);
    }
    for (;;)
    {
      ScanTranslationCaptureUI.a(this.qAW, 3);
      AppMethodBeat.o(81278);
      return;
      label196:
      ScanTranslationCaptureUI.m(this.qAW).setImageResource(2130840625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.21
 * JD-Core Version:    0.7.0.1
 */