package com.tencent.mm.plugin.qqmail.ui;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.p;

final class MailWebViewUI$4
  extends p
{
  MailWebViewUI$4(MailWebViewUI paramMailWebViewUI) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(68398);
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message();; str = null)
    {
      str = u.amW(str);
      if (!str.startsWith("weixin://private/getcontentwidth/")) {
        break;
      }
      ab.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = ".concat(String.valueOf(str)));
      MailWebViewUI.b(this.pOf, str);
      AppMethodBeat.o(68398);
      return true;
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(68398);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */