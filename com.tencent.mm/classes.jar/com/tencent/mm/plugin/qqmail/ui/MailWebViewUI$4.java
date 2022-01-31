package com.tencent.mm.plugin.qqmail.ui;

import android.webkit.ConsoleMessage;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.j;

final class MailWebViewUI$4
  extends j
{
  MailWebViewUI$4(MailWebViewUI paramMailWebViewUI) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message();; str = null)
    {
      str = s.Xd(str);
      if (!str.startsWith("weixin://private/getcontentwidth/")) {
        break;
      }
      y.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = " + str);
      MailWebViewUI.b(this.niS, str);
      return true;
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */