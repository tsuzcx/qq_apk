package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.MMWebView;

final class ReadMailUI$10
  implements e
{
  ReadMailUI$10(ReadMailUI paramReadMailUI) {}
  
  public final void a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(68433);
    paramMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
    paramMMWebView.evaluateJavascript("javascript:" + ReadMailUI.ceE(), null);
    paramMMWebView.evaluateJavascript("javascript:" + ReadMailUI.ceF(), null);
    paramMMWebView.evaluateJavascript("javascript:" + ReadMailUI.ceG(), null);
    if (ReadMailUI.l(this.pOX).isConnected())
    {
      if (!ReadMailUI.t(this.pOX)) {
        ReadMailUI.u(this.pOX);
      }
      ReadMailUI.a(this.pOX, new ReadMailProxy(ReadMailUI.l(this.pOX), null, new ReadMailUI.b(this.pOX), new ReadMailUI.c(this.pOX)));
      ReadMailUI.v(this.pOX).REMOTE_CALL("addDownloadCallback", new Object[0]);
    }
    new ak(this.pOX.getMainLooper()).postDelayed(new ReadMailUI.10.1(this), 200L);
    new ak(this.pOX.getMainLooper()).postDelayed(new ReadMailUI.10.2(this), 400L);
    AppMethodBeat.o(68433);
  }
  
  public final boolean abM()
  {
    return false;
  }
  
  public final void abN() {}
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean pV(String paramString)
  {
    AppMethodBeat.i(68432);
    ab.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramString });
    Intent localIntent;
    if ((paramString != null) && (paramString.startsWith("mailto:")))
    {
      paramString = paramString.trim().replace("mailto:", "");
      localIntent = new Intent(this.pOX, ComposeUI.class);
      localIntent.putExtra("composeType", 4);
      localIntent.putExtra("toList", new String[] { paramString + " " + paramString });
      this.pOX.startActivity(localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(68432);
      return true;
      if ((paramString != null) && (paramString.startsWith("tel:")))
      {
        paramString = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
        paramString.addFlags(268435456);
        this.pOX.startActivity(paramString);
      }
      else
      {
        if ((paramString == null) || (paramString.startsWith("data:"))) {
          break label264;
        }
        if (((h)ReadMailUI.g(this.pOX)).dgS())
        {
          ((h)ReadMailUI.g(this.pOX)).dgT();
          AppMethodBeat.o(68432);
          return true;
        }
        if (!paramString.startsWith("http")) {
          break;
        }
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramString);
        com.tencent.mm.bq.d.b(this.pOX, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
    AppMethodBeat.o(68432);
    return false;
    label264:
    AppMethodBeat.o(68432);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10
 * JD-Core Version:    0.7.0.1
 */