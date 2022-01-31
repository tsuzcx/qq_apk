package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.websearch.a.a;

final class WebSearchVoiceUI$1
  implements a.a
{
  WebSearchVoiceUI$1(WebSearchVoiceUI paramWebSearchVoiceUI) {}
  
  public final void TG(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.length() > 2) {
        str = paramString.substring(0, paramString.length() - 1);
      }
    }
    paramString = new Intent();
    paramString.putExtra("text", str);
    this.rvP.setResult(0, paramString);
    h.nFQ.f(15178, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.a(this.rvP), WebSearchVoiceUI.b(this.rvP), Integer.valueOf(WebSearchVoiceUI.c(this.rvP)), Integer.valueOf(WebSearchVoiceUI.d(this.rvP)) });
    this.rvP.finish();
  }
  
  public final void cfM()
  {
    this.rvP.setResult(0);
    h.nFQ.f(15178, new Object[] { Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(this.rvP), WebSearchVoiceUI.b(this.rvP), Integer.valueOf(WebSearchVoiceUI.c(this.rvP)), Integer.valueOf(WebSearchVoiceUI.d(this.rvP)) });
    this.rvP.finish();
  }
  
  public final void lr(boolean paramBoolean)
  {
    if (paramBoolean) {
      h.nFQ.f(15178, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(this.rvP), WebSearchVoiceUI.b(this.rvP), Integer.valueOf(WebSearchVoiceUI.c(this.rvP)), Integer.valueOf(WebSearchVoiceUI.d(this.rvP)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WebSearchVoiceUI.1
 * JD-Core Version:    0.7.0.1
 */