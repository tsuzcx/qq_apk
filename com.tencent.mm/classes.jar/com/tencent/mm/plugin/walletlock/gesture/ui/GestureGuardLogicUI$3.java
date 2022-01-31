package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import java.util.List;

final class GestureGuardLogicUI$3
  implements w.a
{
  GestureGuardLogicUI$3(GestureGuardLogicUI paramGestureGuardLogicUI, List paramList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if (paramInt2 == 0)
    {
      GestureGuardLogicUI.i(this.qPX);
      GestureGuardLogicUI.j(this.qPX);
      d.bYl();
      d.bYf();
      d.bYh();
      GestureGuardLogicUI.a(this.qPX, this.qPZ);
      GestureGuardLogicUI.a(this.qPX, 1);
      GestureGuardLogicUI.h(this.qPX);
      return 0;
    }
    if (paramInt2 == -3)
    {
      GestureGuardLogicUI.k(this.qPX);
      GestureGuardLogicUI.a(this.qPX, 2);
      GestureGuardLogicUI.h(this.qPX);
      return 0;
    }
    Toast.makeText(this.qPX, this.qPX.getString(a.g.gesture_pwd_err_srv_comm_failed), 0).show();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.3
 * JD-Core Version:    0.7.0.1
 */