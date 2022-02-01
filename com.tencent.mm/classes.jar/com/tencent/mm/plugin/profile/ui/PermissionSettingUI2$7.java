package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.f.c;

final class PermissionSettingUI2$7
  implements f.c
{
  PermissionSettingUI2$7(PermissionSettingUI2 paramPermissionSettingUI2) {}
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(179660);
    this.Bib.hideVKB();
    if (!paramBoolean)
    {
      paramString = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(this.Bib);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      c.b(this.Bib.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(179660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.7
 * JD-Core Version:    0.7.0.1
 */