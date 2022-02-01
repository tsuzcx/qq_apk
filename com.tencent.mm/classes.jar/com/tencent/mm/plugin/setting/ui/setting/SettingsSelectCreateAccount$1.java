package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class SettingsSelectCreateAccount$1
  implements View.OnClickListener
{
  SettingsSelectCreateAccount$1(SettingsSelectCreateAccount paramSettingsSelectCreateAccount) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(299261);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSelectCreateAccount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=signup/secondaryid_faq");
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    paramView.putExtra("needRedirect", false);
    paramView.putExtra("neverGetA8Key", true);
    paramView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    paramView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    c.b(this.Pwj.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    h.OAn.b(23530, new Object[] { SettingsSelectCreateAccount.a(this.Pwj), q.aPg(), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(1001), Integer.valueOf(10103) });
    a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSelectCreateAccount$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectCreateAccount.1
 * JD-Core Version:    0.7.0.1
 */