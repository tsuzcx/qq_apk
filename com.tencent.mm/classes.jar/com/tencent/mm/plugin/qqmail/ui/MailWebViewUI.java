package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;
import com.tencent.xweb.x;
import java.util.Map;

public class MailWebViewUI
  extends MMActivity
{
  private c.a HqY;
  private String fba;
  private MMHandler handler;
  private d jGJ;
  private MMWebView pHS;
  private long yjR;
  
  public MailWebViewUI()
  {
    AppMethodBeat.i(123129);
    this.HqY = new c.a()
    {
      public final void onError(int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(123121);
        MailWebViewUI.a(MailWebViewUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123119);
            Toast.makeText(MailWebViewUI.this, paramAnonymousString, 0).show();
            AppMethodBeat.o(123119);
          }
        });
        AppMethodBeat.o(123121);
      }
      
      public final void onSuccess(final String paramAnonymousString, Map paramAnonymousMap)
      {
        AppMethodBeat.i(123120);
        MailWebViewUI.a(MailWebViewUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123118);
            MailWebViewUI.a(MailWebViewUI.this, paramAnonymousString);
            AppMethodBeat.o(123118);
          }
        });
        AppMethodBeat.o(123120);
      }
    };
    this.jGJ = new d(this);
    AppMethodBeat.o(123129);
  }
  
  public int getLayoutId()
  {
    return e.f.qqmail_webview;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123135);
    boolean bool = getIntent().getBooleanExtra("singleColumn", false);
    this.pHS = MMWebView.a.lH(getContext());
    this.pHS.setBackgroundDrawable(a.m(this, e.c.navpage));
    ((FrameLayout)findViewById(e.e.container)).addView(this.pHS);
    this.pHS.getSettings().setJavaScriptEnabled(true);
    if (Boolean.valueOf(bool).booleanValue())
    {
      MMWebView localMMWebView = this.pHS;
      if (Build.VERSION.SDK_INT >= 8) {
        localMMWebView.getSettings().a(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      }
    }
    this.pHS.getSettings().iwy();
    this.pHS.getSettings().setSupportZoom(true);
    this.pHS.getSettings().setBuiltInZoomControls(true);
    this.pHS.setWebViewClient(new ad()
    {
      public final void a(WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(123123);
        MailWebViewUI.c(MailWebViewUI.this).getSettings().a(WebSettings.LayoutAlgorithm.NORMAL);
        AppMethodBeat.o(123123);
      }
      
      public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(123124);
        if (paramAnonymousString.startsWith("weixin://private/getcontentwidth/"))
        {
          Log.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = ".concat(String.valueOf(paramAnonymousString)));
          MailWebViewUI.b(MailWebViewUI.this, paramAnonymousString);
          AppMethodBeat.o(123124);
          return true;
        }
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        AppMethodBeat.o(123124);
        return true;
      }
      
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(123125);
        super.b(paramAnonymousWebView, paramAnonymousString);
        ab.b(paramAnonymousWebView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
        AppMethodBeat.o(123125);
      }
    });
    this.pHS.setWebChromeClient(new x()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(123126);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = ab.bsd(str);
          if (!str.startsWith("weixin://private/getcontentwidth/")) {
            break;
          }
          Log.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = ".concat(String.valueOf(str)));
          MailWebViewUI.b(MailWebViewUI.this, str);
          AppMethodBeat.o(123126);
          return true;
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(123126);
        return bool;
      }
    });
    this.pHS.hZN();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123127);
        MailWebViewUI.this.finish();
        AppMethodBeat.o(123127);
        return true;
      }
    });
    AppMethodBeat.o(123135);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123132);
    super.onCreate(paramBundle);
    this.handler = new MMHandler();
    initView();
    paramBundle = getIntent().getStringExtra("title");
    if (paramBundle != null) {
      setMMTitle(paramBundle);
    }
    this.jGJ.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123122);
        MailWebViewUI.b(MailWebViewUI.this);
        AppMethodBeat.o(123122);
      }
    });
    AppMethodBeat.o(123132);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123134);
    this.pHS.setVisibility(8);
    this.pHS.destroy();
    this.pHS = null;
    this.jGJ.release();
    super.onDestroy();
    AppMethodBeat.o(123134);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123131);
    super.onPause();
    WebView.disablePlatformNotifications();
    AppMethodBeat.o(123131);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123130);
    super.onResume();
    WebView.enablePlatformNotifications();
    AppMethodBeat.o(123130);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(123133);
    this.pHS.stopLoading();
    super.onStop();
    AppMethodBeat.o(123133);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI
 * JD-Core Version:    0.7.0.1
 */