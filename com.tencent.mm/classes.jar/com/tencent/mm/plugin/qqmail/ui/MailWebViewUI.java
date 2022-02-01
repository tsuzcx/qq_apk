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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.c.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.util.Map;

public class MailWebViewUI
  extends MMActivity
{
  private c.a BwD;
  private String djt;
  private d gVN;
  private MMHandler handler;
  private MMWebView pGj;
  private long ulj;
  
  public MailWebViewUI()
  {
    AppMethodBeat.i(123129);
    this.BwD = new c.a()
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
    this.gVN = new d(this);
    AppMethodBeat.o(123129);
  }
  
  public int getLayoutId()
  {
    return 2131496002;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123135);
    boolean bool = getIntent().getBooleanExtra("singleColumn", false);
    this.pGj = MMWebView.a.kL(getContext());
    this.pGj.setBackgroundDrawable(a.l(this, 2131100888));
    ((FrameLayout)findViewById(2131299174)).addView(this.pGj);
    this.pGj.getSettings().setJavaScriptEnabled(true);
    if (Boolean.valueOf(bool).booleanValue())
    {
      MMWebView localMMWebView = this.pGj;
      if (Build.VERSION.SDK_INT >= 8) {
        localMMWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      }
    }
    this.pGj.getSettings().hsO();
    this.pGj.getSettings().setSupportZoom(true);
    this.pGj.getSettings().setBuiltInZoomControls(true);
    this.pGj.setWebViewClient(new ac()
    {
      public final void a(WebView paramAnonymousWebView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(123123);
        MailWebViewUI.c(MailWebViewUI.this).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
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
        com.tencent.mm.pluginsdk.ui.tools.z.a(paramAnonymousWebView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
        AppMethodBeat.o(123125);
      }
    });
    this.pGj.setWebChromeClient(new x()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(123126);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = com.tencent.mm.pluginsdk.ui.tools.z.bfJ(str);
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
    this.pGj.gYW();
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
    this.gVN.connect(new Runnable()
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
    this.pGj.setVisibility(8);
    this.pGj.destroy();
    this.pGj = null;
    this.gVN.release();
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
    this.pGj.stopLoading();
    super.onStop();
    AppMethodBeat.o(123133);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI
 * JD-Core Version:    0.7.0.1
 */