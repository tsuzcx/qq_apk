package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import java.util.Map;

public class MailWebViewUI
  extends MMActivity
{
  private String bvy;
  private d eMh = new d(this);
  private ah handler;
  private long nfq;
  private MMWebView niQ;
  private v.a niR = new v.a()
  {
    public final void onError(int paramAnonymousInt, String paramAnonymousString)
    {
      MailWebViewUI.a(MailWebViewUI.this).post(new MailWebViewUI.1.2(this, paramAnonymousString));
    }
    
    public final void onSuccess(String paramAnonymousString, Map paramAnonymousMap)
    {
      MailWebViewUI.a(MailWebViewUI.this).post(new MailWebViewUI.1.1(this, paramAnonymousString));
    }
  };
  
  protected final int getLayoutId()
  {
    return b.g.qqmail_webview;
  }
  
  protected final void initView()
  {
    boolean bool = getIntent().getBooleanExtra("singleColumn", false);
    this.niQ = MMWebView.a.cO(this.mController.uMN);
    this.niQ.setBackgroundDrawable(a.g(this, b.c.navpage));
    ((FrameLayout)findViewById(b.f.container)).addView(this.niQ);
    this.niQ.getSettings().setJavaScriptEnabled(true);
    if (Boolean.valueOf(bool).booleanValue())
    {
      MMWebView localMMWebView = this.niQ;
      if (Build.VERSION.SDK_INT >= 8) {
        localMMWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      }
    }
    this.niQ.getSettings().cSo();
    this.niQ.getSettings().setSupportZoom(true);
    this.niQ.getSettings().setBuiltInZoomControls(true);
    this.niQ.setWebViewClient(new MailWebViewUI.3(this));
    this.niQ.setWebChromeClient(new MailWebViewUI.4(this));
    this.niQ.cJS();
    setBackBtn(new MailWebViewUI.5(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.handler = new ah();
    initView();
    paramBundle = getIntent().getStringExtra("title");
    if (paramBundle != null) {
      setMMTitle(paramBundle);
    }
    this.eMh.connect(new Runnable()
    {
      public final void run()
      {
        MailWebViewUI.b(MailWebViewUI.this);
      }
    });
  }
  
  protected void onDestroy()
  {
    this.niQ.setVisibility(8);
    this.niQ.destroy();
    this.niQ = null;
    this.eMh.release();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    WebView.disablePlatformNotifications();
  }
  
  protected void onResume()
  {
    super.onResume();
    WebView.enablePlatformNotifications();
  }
  
  protected void onStop()
  {
    this.niQ.stopLoading();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI
 * JD-Core Version:    0.7.0.1
 */