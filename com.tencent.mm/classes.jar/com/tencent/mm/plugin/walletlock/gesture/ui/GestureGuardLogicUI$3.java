package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import java.util.List;

final class GestureGuardLogicUI$3
  implements w.a
{
  GestureGuardLogicUI$3(GestureGuardLogicUI paramGestureGuardLogicUI, List paramList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(51588);
    if (paramInt2 == 0)
    {
      GestureGuardLogicUI.i(this.uFf);
      GestureGuardLogicUI.j(this.uFf);
      d.cXT();
      d.cXN();
      d.cXP();
      GestureGuardLogicUI.a(this.uFf, this.uFh);
      GestureGuardLogicUI.a(this.uFf, 1);
      GestureGuardLogicUI.h(this.uFf);
    }
    for (;;)
    {
      AppMethodBeat.o(51588);
      return 0;
      if (paramInt2 == -3)
      {
        GestureGuardLogicUI.k(this.uFf);
        GestureGuardLogicUI.a(this.uFf, 2);
        GestureGuardLogicUI.h(this.uFf);
      }
      else
      {
        Toast.makeText(this.uFf, this.uFf.getString(2131300505), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.3
 * JD-Core Version:    0.7.0.1
 */