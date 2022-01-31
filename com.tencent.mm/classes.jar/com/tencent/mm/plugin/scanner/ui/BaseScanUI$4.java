package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class BaseScanUI$4
  extends ah
{
  BaseScanUI$4(BaseScanUI paramBaseScanUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1) || (BaseScanUI.p(this.nJg) == null) || (BaseScanUI.q(this.nJg) == null) || ((BaseScanUI.a(this.nJg)) && (!BaseScanUI.b(this.nJg)))) {
      return;
    }
    if ((BaseScanUI.i(this.nJg) == null) || (BaseScanUI.i(this.nJg).bxr() <= 0))
    {
      y.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
      this.nJg.bxx();
      return;
    }
    BaseScanUI.p(this.nJg).setVisibility(0);
    BaseScanUI.q(this.nJg).setRepeatCount(-1);
    BaseScanUI.q(this.nJg).setDuration(2600L);
    BaseScanUI.p(this.nJg).startAnimation(BaseScanUI.q(this.nJg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.4
 * JD-Core Version:    0.7.0.1
 */