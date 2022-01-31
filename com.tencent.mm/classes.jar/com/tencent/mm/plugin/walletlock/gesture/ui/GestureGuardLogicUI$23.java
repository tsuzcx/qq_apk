package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;

final class GestureGuardLogicUI$23
  implements w.a
{
  GestureGuardLogicUI$23(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(51608);
    GestureGuardLogicUI.b(this.uFf);
    GestureGuardLogicUI.d(this.uFf);
    if (paramInt2 == 0)
    {
      Toast.makeText(this.uFf, this.uFf.getString(2131300523), 0).show();
      GestureGuardLogicUI.a(this.uFf, -1, 0, "open gesture ok");
    }
    for (;;)
    {
      AppMethodBeat.o(51608);
      return 0;
      Toast.makeText(this.uFf, this.uFf.getString(2131300504), 0).show();
      GestureGuardLogicUI.a(this.uFf, -1, -1, "open gesture failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.23
 * JD-Core Version:    0.7.0.1
 */