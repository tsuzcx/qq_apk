package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.ui.base.h;

final class SettingsManageAuthUI$a$1
  implements View.OnClickListener
{
  SettingsManageAuthUI$a$1(SettingsManageAuthUI.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127253);
    if (this.qIH.Db(this.lU) != null)
    {
      paramView = new c(this.qIH.Db(this.lU).cwc, 1);
      if (SettingsManageAuthUI.f(this.qIH.qIF) != null) {
        SettingsManageAuthUI.f(this.qIH.qIF).dismiss();
      }
      g.Rc().a(paramView, 0);
      SettingsManageAuthUI.a(this.qIH.qIF, h.b(this.qIH.qIF, this.qIH.qIF.getString(2131297069), true, new SettingsManageAuthUI.a.1.1(this, paramView)));
    }
    AppMethodBeat.o(127253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */