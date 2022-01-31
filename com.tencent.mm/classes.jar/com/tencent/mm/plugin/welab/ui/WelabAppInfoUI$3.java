package com.tencent.mm.plugin.welab.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class WelabAppInfoUI$3
  implements View.OnClickListener
{
  WelabAppInfoUI$3(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(this.rEL));
    paramView = com.tencent.mm.plugin.welab.b.chc();
    WelabAppInfoUI localWelabAppInfoUI = this.rEL;
    String str = WelabAppInfoUI.b(this.rEL);
    com.tencent.mm.plugin.welab.a.a.b localb = (com.tencent.mm.plugin.welab.a.a.b)paramView.rEs.get(str);
    if (localb != null)
    {
      y.i("WelabMgr", "use custome opener to open " + str);
      localb.f(localWelabAppInfoUI, str);
    }
    for (;;)
    {
      e.q(WelabAppInfoUI.b(this.rEL), 7, WelabAppInfoUI.c(this.rEL));
      return;
      y.i("WelabMgr", "use default opener open " + str);
      if (paramView.Uf(str).field_Type == 2)
      {
        if (paramView.rEt != null) {
          paramView.rEt.f(localWelabAppInfoUI, str);
        } else {
          y.e("WelabMgr", "defaultWeAppOpener is null!");
        }
      }
      else {
        y.e("WelabMgr", "can not find opener for " + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.3
 * JD-Core Version:    0.7.0.1
 */