package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.walletlock.a.g;

final class GestureGuardLogicUI$23
  implements w.a
{
  GestureGuardLogicUI$23(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    GestureGuardLogicUI.b(this.qPX);
    GestureGuardLogicUI.d(this.qPX);
    if (paramInt2 == 0)
    {
      Toast.makeText(this.qPX, this.qPX.getString(a.g.gesture_pwd_toast_enabled), 0).show();
      GestureGuardLogicUI.a(this.qPX, -1, 0, "open gesture ok");
      return 0;
    }
    Toast.makeText(this.qPX, this.qPX.getString(a.g.gesture_pwd_err_runtime), 0).show();
    GestureGuardLogicUI.a(this.qPX, -1, -1, "open gesture failed");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.23
 * JD-Core Version:    0.7.0.1
 */