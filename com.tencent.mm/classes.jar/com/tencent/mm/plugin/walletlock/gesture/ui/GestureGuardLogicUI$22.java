package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;

final class GestureGuardLogicUI$22
  implements w.a
{
  GestureGuardLogicUI$22(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(51607);
    if (paramInt2 == 0) {
      Toast.makeText(this.uFf, this.uFf.getString(2131300524), 0).show();
    }
    for (;;)
    {
      GestureGuardLogicUI.a(this.uFf, null);
      GestureGuardLogicUI.d(this.uFf);
      this.uFf.finish();
      AppMethodBeat.o(51607);
      return 0;
      Toast.makeText(this.uFf, this.uFf.getString(2131300504), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.22
 * JD-Core Version:    0.7.0.1
 */