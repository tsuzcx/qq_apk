package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.y;

final class OfflineAlertView$7
  implements Runnable
{
  OfflineAlertView$7(OfflineAlertView paramOfflineAlertView, View paramView) {}
  
  public final void run()
  {
    y.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[] { Integer.valueOf(this.mLW.getHeight()), Integer.valueOf(this.mLW.getMeasuredHeight()) });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)OfflineAlertView.a(this.mLZ).getLayoutParams();
    if (this.mLW.getHeight() > 0)
    {
      localLayoutParams.height = this.mLW.getHeight();
      OfflineAlertView.a(this.mLZ).setLayoutParams(localLayoutParams);
      OfflineAlertView.a(this.mLZ).invalidate();
    }
    if (OfflineAlertView.b(this.mLZ) != null) {
      OfflineAlertView.b(this.mLZ).onShow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.7
 * JD-Core Version:    0.7.0.1
 */