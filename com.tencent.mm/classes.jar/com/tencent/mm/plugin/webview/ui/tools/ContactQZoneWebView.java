package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public class ContactQZoneWebView
  extends WebViewUI
{
  private boolean DYB = false;
  private String DYC = "";
  private String lox = "";
  
  final void aIB(String paramString)
  {
    AppMethodBeat.i(79547);
    if (this.DYB)
    {
      AppMethodBeat.o(79547);
      return;
    }
    this.DYB = true;
    Object localObject = paramString.substring(19);
    ad.d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(localObject)));
    paramString = new Intent();
    paramString.putExtra("nowUrl", (String)localObject);
    paramString.putExtra("tweetid", bt.nullAsNil(getIntent().getStringExtra("tweetid")));
    paramString.putExtra("htmlData", this.DYC);
    paramString.putExtra("type", getIntent().getIntExtra("type", 0));
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 4);
    ((Bundle)localObject).putString("stat_url", eNy());
    paramString.putExtra("_stat_obj", (Bundle)localObject);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.webview.a.a.iRG.q(paramString, this);
    AppMethodBeat.o(79547);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79545);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131766262));
    this.omW.setWebViewClient(new ac()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(79543);
        if (paramAnonymousString.startsWith("weixin://viewimage/"))
        {
          ContactQZoneWebView.this.aIB(paramAnonymousString);
          paramAnonymousWebView.stopLoading();
        }
        for (;;)
        {
          AppMethodBeat.o(79543);
          return true;
          if ((paramAnonymousString.startsWith("weixinping://iframe")) || (paramAnonymousString.startsWith("weixinpreinject://iframe")))
          {
            AppMethodBeat.o(79543);
            return true;
          }
          paramAnonymousWebView.loadUrl(paramAnonymousString);
        }
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(79544);
        if (paramAnonymousString.startsWith("weixin://viewimage/"))
        {
          ContactQZoneWebView.this.aIB(paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          AppMethodBeat.o(79544);
          return;
        }
        if (paramAnonymousString.equals(ContactQZoneWebView.a(ContactQZoneWebView.this)))
        {
          bt.cd(ContactQZoneWebView.this, paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          AppMethodBeat.o(79544);
          return;
        }
        super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(79544);
      }
    });
    this.omW.loadUrl(bQm());
    ad.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + bQm());
    AppMethodBeat.o(79545);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79546);
    super.onResume();
    this.DYB = false;
    AppMethodBeat.o(79546);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView
 * JD-Core Version:    0.7.0.1
 */