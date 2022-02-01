package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.g.c;

final class SayHiWithSnsPermissionUI$4
  implements g.c
{
  SayHiWithSnsPermissionUI$4(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(305676);
    this.NaS.hideVKB();
    if (!paramBoolean)
    {
      paramString = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(this.NaS);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      c.b(this.NaS.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(305676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.4
 * JD-Core Version:    0.7.0.1
 */