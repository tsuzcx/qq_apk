package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class BaseScanUI$9
  extends ak
{
  BaseScanUI$9(BaseScanUI paramBaseScanUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(138463);
    if ((paramMessage != null) && (paramMessage.what == 1))
    {
      if ((BaseScanUI.q(this.qwI) == null) || (BaseScanUI.r(this.qwI) == null) || ((BaseScanUI.b(this.qwI)) && (!BaseScanUI.c(this.qwI)) && (!BaseScanUI.s(this.qwI))))
      {
        AppMethodBeat.o(138463);
        return;
      }
      if ((BaseScanUI.i(this.qwI) == null) || (BaseScanUI.i(this.qwI).cio() <= 0))
      {
        ab.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
        this.qwI.cix();
        AppMethodBeat.o(138463);
        return;
      }
      BaseScanUI.q(this.qwI).setVisibility(0);
      BaseScanUI.r(this.qwI).setRepeatCount(-1);
      BaseScanUI.r(this.qwI).setDuration(2600L);
      BaseScanUI.q(this.qwI).startAnimation(BaseScanUI.r(this.qwI));
    }
    AppMethodBeat.o(138463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.9
 * JD-Core Version:    0.7.0.1
 */