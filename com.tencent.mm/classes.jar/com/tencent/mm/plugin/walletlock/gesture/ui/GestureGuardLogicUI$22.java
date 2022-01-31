package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.walletlock.a.g;

final class GestureGuardLogicUI$22
  implements w.a
{
  GestureGuardLogicUI$22(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if (paramInt2 == 0) {
      Toast.makeText(this.qPX, this.qPX.getString(a.g.gesture_pwd_toast_modified), 0).show();
    }
    for (;;)
    {
      GestureGuardLogicUI.a(this.qPX, null);
      GestureGuardLogicUI.d(this.qPX);
      this.qPX.finish();
      return 0;
      Toast.makeText(this.qPX, this.qPX.getString(a.g.gesture_pwd_err_runtime), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.22
 * JD-Core Version:    0.7.0.1
 */