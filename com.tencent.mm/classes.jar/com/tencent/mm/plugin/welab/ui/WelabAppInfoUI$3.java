package com.tencent.mm.plugin.welab.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class WelabAppInfoUI$3
  implements View.OnClickListener
{
  WelabAppInfoUI$3(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80601);
    ab.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(this.vvu));
    paramView = com.tencent.mm.plugin.welab.a.dhl();
    WelabAppInfoUI localWelabAppInfoUI = this.vvu;
    String str = WelabAppInfoUI.b(this.vvu);
    b localb = (b)paramView.vuU.get(str);
    if (localb != null)
    {
      ab.i("WelabMgr", "use custome opener to open ".concat(String.valueOf(str)));
      localb.h(localWelabAppInfoUI, str);
    }
    for (;;)
    {
      d.t(WelabAppInfoUI.b(this.vvu), 7, WelabAppInfoUI.c(this.vvu));
      AppMethodBeat.o(80601);
      return;
      ab.i("WelabMgr", "use default opener open ".concat(String.valueOf(str)));
      if (paramView.ajs(str).field_Type == 2)
      {
        if (paramView.vuV != null) {
          paramView.vuV.h(localWelabAppInfoUI, str);
        } else {
          ab.e("WelabMgr", "defaultWeAppOpener is null!");
        }
      }
      else {
        ab.e("WelabMgr", "can not find opener for ".concat(String.valueOf(str)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.3
 * JD-Core Version:    0.7.0.1
 */