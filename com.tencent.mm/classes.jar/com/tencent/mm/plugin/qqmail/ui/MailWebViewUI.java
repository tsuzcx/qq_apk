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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.w;
import com.tencent.xweb.y;
import java.util.Map;

public class MailWebViewUI
  extends MMActivity
{
  private String bob;
  private d fLo;
  private ap handler;
  private MMWebView nhy;
  private long uMU;
  private w.a uQp;
  
  public MailWebViewUI()
  {
    AppMethodBeat.i(123129);
    this.uQp = new w.a()
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
    this.fLo = new d(this);
    AppMethodBeat.o(123129);
  }
  
  public int getLayoutId()
  {
    return 2131495159;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123135);
    boolean bool = getIntent().getBooleanExtra("singleColumn", false);
    this.nhy = MMWebView.a.kk(getContext());
    this.nhy.setBackgroundDrawable(a.l(this, 2131100695));
    ((FrameLayout)findViewById(2131298736)).addView(this.nhy);
    this.nhy.getSettings().setJavaScriptEnabled(true);
    if (Boolean.valueOf(bool).booleanValue())
    {
      MMWebView localMMWebView = this.nhy;
      if (Build.VERSION.SDK_INT >= 8) {
        localMMWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      }
    }
    this.nhy.getSettings().fra();
    this.nhy.getSettings().setSupportZoom(true);
    this.nhy.getSettings().setBuiltInZoomControls(true);
    this.nhy.setWebViewClient(new ab()
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
          ad.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = ".concat(String.valueOf(paramAnonymousString)));
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
        x.a(paramAnonymousWebView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
        AppMethodBeat.o(123125);
      }
    });
    this.nhy.setWebChromeClient(new w()
    {
      public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        AppMethodBeat.i(123126);
        if (paramAnonymousConsoleMessage != null) {}
        for (String str = paramAnonymousConsoleMessage.message();; str = null)
        {
          str = x.aCO(str);
          if (!str.startsWith("weixin://private/getcontentwidth/")) {
            break;
          }
          ad.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = ".concat(String.valueOf(str)));
          MailWebViewUI.b(MailWebViewUI.this, str);
          AppMethodBeat.o(123126);
          return true;
        }
        boolean bool = super.onConsoleMessage(paramAnonymousConsoleMessage);
        AppMethodBeat.o(123126);
        return bool;
      }
    });
    this.nhy.feR();
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
    this.handler = new ap();
    initView();
    paramBundle = getIntent().getStringExtra("title");
    if (paramBundle != null) {
      setMMTitle(paramBundle);
    }
    this.fLo.connect(new Runnable()
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
    this.nhy.setVisibility(8);
    this.nhy.destroy();
    this.nhy = null;
    this.fLo.release();
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
    this.nhy.stopLoading();
    super.onStop();
    AppMethodBeat.o(123133);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI
 * JD-Core Version:    0.7.0.1
 */