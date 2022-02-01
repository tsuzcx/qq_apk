package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;

public class ContactQZoneWebView
  extends WebViewUI
{
  private boolean WRW = false;
  private String WRX = "";
  private String ibx = "";
  
  final void blx(String paramString)
  {
    AppMethodBeat.i(79547);
    if (this.WRW)
    {
      AppMethodBeat.o(79547);
      return;
    }
    this.WRW = true;
    Object localObject = paramString.substring(19);
    Log.d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(localObject)));
    paramString = new Intent();
    paramString.putExtra("nowUrl", (String)localObject);
    paramString.putExtra("tweetid", Util.nullAsNil(getIntent().getStringExtra("tweetid")));
    paramString.putExtra("htmlData", this.WRX);
    paramString.putExtra("type", getIntent().getIntExtra("type", 0));
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 4);
    ((Bundle)localObject).putString("stat_url", fqa());
    paramString.putExtra("_stat_obj", (Bundle)localObject);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.webview.a.a.pFn.o(paramString, this);
    AppMethodBeat.o(79547);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79545);
    super.onCreate(paramBundle);
    setMMTitle(getString(c.i.wv_contact_info_qq_view_qzone));
    this.sMP.setWebViewClient(new ag()
    {
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(79543);
        if (paramAnonymousString.startsWith("weixin://viewimage/"))
        {
          ContactQZoneWebView.this.blx(paramAnonymousString);
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
          ContactQZoneWebView.this.blx(paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          AppMethodBeat.o(79544);
          return;
        }
        if (paramAnonymousString.equals(ContactQZoneWebView.a(ContactQZoneWebView.this)))
        {
          Util.jump(ContactQZoneWebView.this, paramAnonymousString);
          paramAnonymousWebView.stopLoading();
          AppMethodBeat.o(79544);
          return;
        }
        super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(79544);
      }
    });
    this.sMP.loadUrl(dgY());
    Log.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + dgY());
    AppMethodBeat.o(79545);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79546);
    super.onResume();
    this.WRW = false;
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