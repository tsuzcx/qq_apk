package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;

public class MailWebViewUI
  extends MMActivity
{
  private String bWJ;
  private d evl;
  private ak handler;
  private long pKF;
  private MMWebView pOd;
  private v.a pOe;
  
  public MailWebViewUI()
  {
    AppMethodBeat.i(68401);
    this.pOe = new MailWebViewUI.1(this);
    this.evl = new d(this);
    AppMethodBeat.o(68401);
  }
  
  public int getLayoutId()
  {
    return 2130970486;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68407);
    boolean bool = getIntent().getBooleanExtra("singleColumn", false);
    this.pOd = MMWebView.a.iI(getContext());
    this.pOd.setBackgroundDrawable(a.k(this, 2131690310));
    ((FrameLayout)findViewById(2131821084)).addView(this.pOd);
    this.pOd.getSettings().setJavaScriptEnabled(true);
    if (Boolean.valueOf(bool).booleanValue())
    {
      MMWebView localMMWebView = this.pOd;
      if (Build.VERSION.SDK_INT >= 8) {
        localMMWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      }
    }
    this.pOd.getSettings().dYt();
    this.pOd.getSettings().setSupportZoom(true);
    this.pOd.getSettings().setBuiltInZoomControls(true);
    this.pOd.setWebViewClient(new MailWebViewUI.3(this));
    this.pOd.setWebChromeClient(new MailWebViewUI.4(this));
    this.pOd.dOL();
    setBackBtn(new MailWebViewUI.5(this));
    AppMethodBeat.o(68407);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68404);
    super.onCreate(paramBundle);
    this.handler = new ak();
    initView();
    paramBundle = getIntent().getStringExtra("title");
    if (paramBundle != null) {
      setMMTitle(paramBundle);
    }
    this.evl.connect(new MailWebViewUI.2(this));
    AppMethodBeat.o(68404);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68406);
    this.pOd.setVisibility(8);
    this.pOd.destroy();
    this.pOd = null;
    this.evl.release();
    super.onDestroy();
    AppMethodBeat.o(68406);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(68403);
    super.onPause();
    WebView.disablePlatformNotifications();
    AppMethodBeat.o(68403);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(68402);
    super.onResume();
    WebView.enablePlatformNotifications();
    AppMethodBeat.o(68402);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(68405);
    this.pOd.stopLoading();
    super.onStop();
    AppMethodBeat.o(68405);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI
 * JD-Core Version:    0.7.0.1
 */