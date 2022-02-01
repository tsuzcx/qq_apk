package com.tencent.mm.ui.contact.privacy;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.g.c;

final class ContactMgrOnlyChatUI$3
  implements g.c
{
  ContactMgrOnlyChatUI$3(ContactMgrOnlyChatUI paramContactMgrOnlyChatUI) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(253431);
    this.afkI.hideVKB();
    if (!paramBoolean)
    {
      paramString = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(this.afkI.getContext());
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      c.b(this.afkI.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(253431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.ContactMgrOnlyChatUI.3
 * JD-Core Version:    0.7.0.1
 */