package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b;
import com.tencent.xweb.n;
import java.io.File;

public final class a
{
  ViewGroup MY;
  MMWebView dYF;
  c kMB = new a.1(this);
  String kMs;
  Context mContext;
  com.tencent.mm.plugin.webview.stub.d rsT;
  GameWebViewUI rvX;
  private d rvY;
  com.tencent.mm.plugin.webview.ui.tools.jsapi.d rvZ;
  com.tencent.mm.plugin.wepkg.c rwa;
  a.a rwb;
  f rwc;
  m rwd = new a.4(this);
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup)
  {
    this.mContext = paramGameWebViewUI;
    this.rvX = paramGameWebViewUI;
    this.MY = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.eC(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.rwb = new a.a(this, paramViewGroup);
    paramViewGroup.setWebViewClient(this.rwb);
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new a.b(this, (byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().cSs();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().cSn();
    paramViewGroup.getSettings().cSm();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().cSu();
    paramViewGroup.getSettings().cSq();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().cSp();
    paramViewGroup.getSettings().cSr();
    paramViewGroup.getSettings().setDatabasePath(e.dOO + "databases/");
    b.cSe().cSf();
    b.cSe().c(paramViewGroup);
    this.dYF = paramViewGroup;
    this.rvY = new d(paramGameWebViewUI.getIntent());
    this.rwa = new a.2(this);
  }
  
  final int cT(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label123;
      }
      if (this.rsT != null) {
        break label46;
      }
      i = 1;
    }
    for (;;)
    {
      y.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      return i;
      try
      {
        label46:
        if (this.rsT.hU(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.rsT.hl(paramString);
        if (bool)
        {
          i = 7;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + paramString.getMessage());
        i = 1;
      }
      continue;
      label123:
      i = 0;
    }
  }
  
  public final void onDestroy()
  {
    c.a(this.kMB.rwj.rwk);
    this.rwa.lL(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a
 * JD-Core Version:    0.7.0.1
 */