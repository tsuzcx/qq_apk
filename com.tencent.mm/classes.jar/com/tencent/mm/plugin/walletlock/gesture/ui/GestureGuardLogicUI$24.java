package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;

final class GestureGuardLogicUI$24
  implements w.a
{
  GestureGuardLogicUI$24(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(51609);
    if (paramInt2 == 0)
    {
      d.ni(SystemClock.elapsedRealtime());
      Toast.makeText(this.uFf, this.uFf.getString(2131300524), 0).show();
      GestureGuardLogicUI.e(this.uFf);
    }
    for (;;)
    {
      GestureGuardLogicUI.b(this.uFf);
      GestureGuardLogicUI.d(this.uFf);
      AppMethodBeat.o(51609);
      return 0;
      Toast.makeText(this.uFf, this.uFf.getString(2131300504), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.24
 * JD-Core Version:    0.7.0.1
 */