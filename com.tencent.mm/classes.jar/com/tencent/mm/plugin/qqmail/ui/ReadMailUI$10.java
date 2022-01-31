package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class ReadMailUI$10
  implements e
{
  ReadMailUI$10(ReadMailUI paramReadMailUI) {}
  
  public final boolean IP()
  {
    return false;
  }
  
  public final void IQ() {}
  
  public final void a(MMWebView paramMMWebView)
  {
    paramMMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
    paramMMWebView.evaluateJavascript("javascript:" + ReadMailUI.bus(), null);
    paramMMWebView.evaluateJavascript("javascript:" + ReadMailUI.but(), null);
    paramMMWebView.evaluateJavascript("javascript:" + ReadMailUI.buu(), null);
    if (ReadMailUI.l(this.njK).isConnected())
    {
      if (!ReadMailUI.t(this.njK)) {
        ReadMailUI.u(this.njK);
      }
      ReadMailUI.a(this.njK, new ReadMailProxy(ReadMailUI.l(this.njK), null, new ReadMailUI.b(this.njK), new ReadMailUI.c(this.njK)));
      ReadMailUI.v(this.njK).REMOTE_CALL("addDownloadCallback", new Object[0]);
    }
    new ah(this.njK.getMainLooper()).postDelayed(new ReadMailUI.10.1(this), 200L);
    new ah(this.njK.getMainLooper()).postDelayed(new ReadMailUI.10.2(this), 400L);
  }
  
  public final boolean b(int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean jh(String paramString)
  {
    y.d("MicroMsg.ReadMailUI", "url:%s", new Object[] { paramString });
    Intent localIntent;
    if ((paramString != null) && (paramString.startsWith("mailto:")))
    {
      paramString = paramString.trim().replace("mailto:", "");
      localIntent = new Intent(this.njK, ComposeUI.class);
      localIntent.putExtra("composeType", 4);
      localIntent.putExtra("toList", new String[] { paramString + " " + paramString });
      this.njK.startActivity(localIntent);
    }
    for (;;)
    {
      return true;
      if ((paramString != null) && (paramString.startsWith("tel:")))
      {
        paramString = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
        paramString.addFlags(268435456);
        this.njK.startActivity(paramString);
      }
      else
      {
        if ((paramString == null) || (paramString.startsWith("data:"))) {
          break label244;
        }
        if (((h)ReadMailUI.g(this.njK)).cgL())
        {
          ((h)ReadMailUI.g(this.njK)).cgM();
          return true;
        }
        if (!paramString.startsWith("http")) {
          break;
        }
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramString);
        com.tencent.mm.br.d.b(this.njK, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
    return false;
    label244:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10
 * JD-Core Version:    0.7.0.1
 */