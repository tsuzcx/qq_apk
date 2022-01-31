package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.ui.base.h;

final class SettingsSearchAuthUI$a$1
  implements View.OnClickListener
{
  SettingsSearchAuthUI$a$1(SettingsSearchAuthUI.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (this.nVP.xd(this.kX) != null)
    {
      paramView = new c(this.nVP.xd(this.kX).bOL, 2);
      if (SettingsSearchAuthUI.j(this.nVP.nVN) != null) {
        SettingsSearchAuthUI.j(this.nVP.nVN).dismiss();
      }
      g.Dk().a(paramView, 0);
      SettingsSearchAuthUI.a(this.nVP.nVN, h.b(this.nVP.nVN, this.nVP.nVN.getString(a.i.app_sending), true, new SettingsSearchAuthUI.a.1.1(this, paramView)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */