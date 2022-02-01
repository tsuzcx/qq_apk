package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.f.c;

final class SayHiWithSnsPermissionUI$10
  implements f.c
{
  SayHiWithSnsPermissionUI$10(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(27404);
    this.Biw.hideVKB();
    if (!paramBoolean)
    {
      paramString = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(this.Biw);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      c.b(this.Biw.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(27404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.10
 * JD-Core Version:    0.7.0.1
 */