package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class WebViewUI$u$1
  implements h.c
{
  WebViewUI$u$1(WebViewUI.u paramu) {}
  
  public final void gl(int paramInt)
  {
    WebViewUI.u localu;
    if (paramInt == 0) {
      localu = this.rqS;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("shortUrl", localu.rpH.getIntent().getStringExtra("shortUrl"));
      localBundle.putInt("type", localu.rpH.getIntent().getIntExtra("type", 0));
      localu.rpH.gGn.a(4, localBundle, localu.hashCode());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewUI", "share fail, ex = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.u.1
 * JD-Core Version:    0.7.0.1
 */