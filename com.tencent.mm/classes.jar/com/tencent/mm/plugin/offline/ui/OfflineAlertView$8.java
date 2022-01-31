package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class OfflineAlertView$8
  implements Runnable
{
  OfflineAlertView$8(OfflineAlertView paramOfflineAlertView, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(43450);
    ab.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(this.pmm.getHeight()), Integer.valueOf(this.pmm.getMeasuredHeight()) });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(this.pmp).getLayoutParams();
    if (this.pmm.getHeight() > 0)
    {
      localLayoutParams.height = this.pmm.getHeight();
      OfflineAlertView.a(this.pmp).setLayoutParams(localLayoutParams);
      OfflineAlertView.a(this.pmp).invalidate();
    }
    if (OfflineAlertView.b(this.pmp) != null) {
      OfflineAlertView.b(this.pmp).onShow();
    }
    AppMethodBeat.o(43450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.8
 * JD-Core Version:    0.7.0.1
 */