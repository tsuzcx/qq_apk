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

final class SettingsManageAuthUI$a$1
  implements View.OnClickListener
{
  SettingsManageAuthUI$a$1(SettingsManageAuthUI.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (this.nUC.xd(this.kX) != null)
    {
      paramView = new c(this.nUC.xd(this.kX).bOL, 1);
      if (SettingsManageAuthUI.f(this.nUC.nUA) != null) {
        SettingsManageAuthUI.f(this.nUC.nUA).dismiss();
      }
      g.Dk().a(paramView, 0);
      SettingsManageAuthUI.a(this.nUC.nUA, h.b(this.nUC.nUA, this.nUC.nUA.getString(a.i.app_sending), true, new SettingsManageAuthUI.a.1.1(this, paramView)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */