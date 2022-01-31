package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;

final class GestureGuardLogicUI$12
  implements w.a
{
  GestureGuardLogicUI$12(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(51597);
    if (paramInt2 == 0)
    {
      d.cXT();
      d.cXN();
      d.cXP();
      Toast.makeText(this.uFf, this.uFf.getString(2131300522), 0).show();
    }
    for (;;)
    {
      GestureGuardLogicUI.b(this.uFf);
      GestureGuardLogicUI.c(this.uFf);
      this.uFf.finish();
      AppMethodBeat.o(51597);
      return 0;
      Toast.makeText(this.uFf, this.uFf.getString(2131300504), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.12
 * JD-Core Version:    0.7.0.1
 */