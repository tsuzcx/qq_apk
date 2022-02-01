package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;

public class ContactQZoneWebView
  extends WebViewUI
{
  private boolean BcI = false;
  private String BcJ = "";
  private String kqB = "";
  
  final void axI(String paramString)
  {
    AppMethodBeat.i(79547);
    if (this.BcI)
    {
      AppMethodBeat.o(79547);
      return;
    }
    this.BcI = true;
    Object localObject = paramString.substring(19);
    ad.d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(localObject)));
    paramString = new Intent();
    paramString.putExtra("nowUrl", (String)localObject);
    paramString.putExtra("tweetid", bt.nullAsNil(getIntent().getStringExtra("tweetid")));
    paramString.putExtra("htmlData", this.BcJ);
    paramString.putExtra("type", getIntent().getIntExtra("type", 0));
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 4);
    ((Bundle)localObject).putString("stat_url", ejo());
    paramString.putExtra("_stat_obj", (Bundle)localObject);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.webview.a.a.hYt.q(paramString, this);
    AppMethodBeat.o(79547);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79545);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131766262));
    this.nhy.setWebViewClient(new ab()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(79543);
        if (paramAnonymousString.startsWith("weixin://viewimage/"))
        {
          ContactQZoneWebView.this.axI(paramAnonymousString);
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
          ContactQZoneWebView.this.axI(paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          AppMethodBeat.o(79544);
          return;
        }
        if (paramAnonymousString.equals(ContactQZoneWebView.a(ContactQZoneWebView.this)))
        {
          bt.bX(ContactQZoneWebView.this, paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          AppMethodBeat.o(79544);
          return;
        }
        super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(79544);
      }
    });
    this.nhy.loadUrl(bEx());
    ad.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + bEx());
    AppMethodBeat.o(79545);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79546);
    super.onResume();
    this.BcI = false;
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