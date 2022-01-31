package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class e
  extends com.tencent.luggage.e.n
{
  private static final Pattern rbX = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
  private static final Pattern rbY = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
  private boolean gGf = true;
  public int gTL;
  public String gTN = "";
  private n.a iRy = new e.19(this);
  public String kMT;
  public ah mHandler;
  public h rbA;
  public l rbB;
  public FrameLayout rbC;
  protected LinearLayout rbD;
  public m rbE;
  private WebViewKeyboardLinearLayout rbF;
  public WebViewInputFooter rbG;
  public WebViewSearchContentInputFooter rbH;
  private FrameLayout rbI;
  private MMFalseProgressBar rbJ;
  public MovingImageButton rbK;
  public FrameLayout rbL;
  private i rbM;
  protected com.tencent.mm.plugin.webview.ui.tools.bag.h rbN;
  private WebChromeClient.CustomViewCallback rbO;
  private FrameLayout rbP;
  private ProgressBar rbQ;
  protected LuggageGetA8Key rbR;
  public r rbS;
  protected com.tencent.mm.plugin.webview.luggage.permission.c rbT;
  protected boolean rbU = false;
  public boolean rbV;
  protected boolean rbW;
  private LuggageGetA8Key.a rbZ = new e.18(this);
  
  public e(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    if (paramk != null)
    {
      this.rbW = true;
      this.rbR = com.tencent.mm.plugin.webview.luggage.permission.b.BZ(paramk.hashCode());
    }
    if (this.rbR == null) {}
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.rbR == null) {
        this.rbR = new LuggageGetA8Key();
      }
      this.mHandler = new ah();
      this.rbS = new r(this);
      this.rbT = new com.tencent.mm.plugin.webview.luggage.permission.c(this, this.rbR);
      this.biT.biJ = this.rbT;
      this.rbM = new i(this);
      this.rbN = com.tencent.mm.plugin.webview.ui.tools.bag.o.a(new n(this), caZ());
      j.h(this);
      paramg = this.biT;
      if (this.rbA != null)
      {
        this.rbA.setWebViewClient(new e.13(this));
        this.rbA.setWebChromeClient(new e.14(this));
      }
      paramg.biK.a(new LuggageMMLocalResourceProvider());
      paramg.biK.a(new c());
      a(this.iRy);
      paramg = this.bik;
      paramk = new e.1(this);
      paramg.biD.put(paramk, Boolean.valueOf(false));
      this.biT.a(new e.11(this));
      return;
      bool = false;
    }
  }
  
  protected static boolean caU()
  {
    return false;
  }
  
  protected static void caY() {}
  
  private void zU(String paramString)
  {
    this.biT.a(new e.23(this, paramString));
  }
  
  public final void BV(int paramInt)
  {
    this.biV.putInt("screen_orientation", paramInt);
    ((Activity)this.mContext).setRequestedOrientation(paramInt);
  }
  
  public final void BW(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.rbG.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.rbG.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public final boolean BX(int paramInt)
  {
    return this.rbR.cO(getUrl(), paramInt);
  }
  
  public boolean EB(String paramString)
  {
    return false;
  }
  
  public void EC(String paramString) {}
  
  public void EJ(String paramString)
  {
    if (this.rbA.getX5WebViewExtension() != null)
    {
      this.rbB.setPullDownEnabled(true);
      this.rbB.setCurrentUrl(paramString);
    }
  }
  
  public void Ex(String paramString)
  {
    this.rbU = true;
    this.rbR.a(paramString, this.rbZ);
  }
  
  public void aYA()
  {
    if (!this.rbV)
    {
      this.gTL = this.biV.getInt("customize_status_bar_color");
      if (this.gTL == 0) {
        break label47;
      }
      this.gTN = this.biV.getString("status_bar_style");
    }
    for (;;)
    {
      aYB();
      return;
      label47:
      this.gTL = android.support.v4.content.b.i(this.mContext, R.e.action_bar_color);
    }
  }
  
  public void aYB()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new e.24(this));
      return;
    }
    if (com.tencent.mm.plugin.webview.luggage.d.a.b(this.mContext, this.gTL, this.gTN))
    {
      caR();
      return;
    }
    this.gTL = this.mContext.getResources().getColor(R.e.dark_actionbar_color);
    this.gTN = "";
    caR();
  }
  
  public void aYC()
  {
    this.rbJ.setVisibility(0);
    this.rbJ.start();
  }
  
  public void aYD()
  {
    this.rbJ.finish();
    this.rbJ.setVisibility(8);
  }
  
  public boolean aYK()
  {
    if (!this.biV.getBoolean("disable_minimize", false)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public void aYv()
  {
    this.rbE.aYv();
  }
  
  public View aYz()
  {
    this.rbE = new m(this);
    return this.rbE;
  }
  
  public void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    this.rbU = false;
    if (bk.bl(this.kMT)) {
      this.kMT = paramString2;
    }
    if ((!EB(paramString1)) && (!this.rbW))
    {
      this.biT.biH.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0)) {
        this.biT.biH.loadUrl(paramString2, paramMap);
      }
    }
    else
    {
      return;
    }
    this.biT.loadUrl(paramString2);
  }
  
  public void bc(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = " + paramString);
    this.rbN.TD(paramString);
    this.rbE.setOptionBtnEnable(false);
    aYC();
    Ex(paramString);
    EJ(paramString);
  }
  
  public void bd(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = " + paramString);
    this.rbE.setOptionBtnEnable(true);
    aYD();
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    this.rbN.TD(paramString);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.rbW) });
    if (this.rbW)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.rbE.setOptionBtnEnable(true);
      if (!bk.bl(this.biV.getString("title"))) {
        this.rbE.setTitleText(this.biV.getString("title"));
      }
      this.gGf = false;
      if (this.rbR == null) {
        this.rbR = new LuggageGetA8Key();
      }
      Ex(paramString);
      return;
    }
    aYC();
    if (EB(paramString))
    {
      paramBundle = new HashMap(2);
      paramBundle.put("Pragma", "no-cache");
      paramBundle.put("Cache-Control", "no-cache");
      this.rbA.loadUrl(paramString, paramBundle);
    }
    while (this.gGf)
    {
      Ex(paramString);
      this.gGf = false;
      return;
    }
    c(paramString, null);
  }
  
  public final void cN(String paramString, int paramInt)
  {
    this.mHandler.post(new e.26(this, paramString, paramInt));
  }
  
  public final void caQ()
  {
    this.rbN.a(new u());
  }
  
  public final void caR()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new e.25(this));
      return;
    }
    this.rbE.aW(this.gTL, this.gTN);
  }
  
  public final boolean caS()
  {
    if (this.rbE != null) {
      return this.rbE.caS();
    }
    return false;
  }
  
  public final boolean caT()
  {
    return this.rbU;
  }
  
  public final String caV()
  {
    return this.biV.getString("rawUrl");
  }
  
  public final LuggageGetA8Key caW()
  {
    return this.rbR;
  }
  
  public final com.tencent.mm.plugin.webview.luggage.permission.c caX()
  {
    return this.rbT;
  }
  
  public final boolean caZ()
  {
    boolean bool1 = this.biV.getBoolean("forceHideShare", false);
    boolean bool2 = this.biV.getBoolean("showShare", true);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(aYK()) });
    return (!bool1) && (bool2) && (aYK());
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.bag.h cba()
  {
    return this.rbN;
  }
  
  protected final void eE(int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "onError, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.rbU = false;
    this.rbI.setVisibility(0);
  }
  
  public final String getUrl()
  {
    if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
      return this.biT.mUrl;
    }
    return (String)new e.12(this, "").b(this.mHandler);
  }
  
  public void gv(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rbE.setVisibility(8);
      this.rbK.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.d.a.c(((Activity)this.mContext).getWindow(), true);
      return;
    }
    this.rbE.setVisibility(0);
    this.rbK.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.d.a.c(((Activity)this.mContext).getWindow(), false);
  }
  
  public final boolean isFullScreen()
  {
    return this.biV.getBoolean("show_full_screen", false);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "onDestroy");
    zU("onDestroy");
    this.rbN.ceY();
    this.rbM.rcp = null;
    this.rbM = null;
    j.i(this);
    if (this.rbN.ceZ())
    {
      k localk = this.biT;
      LuggageGetA8Key localLuggageGetA8Key = this.rbR;
      o.remove(t.rdb);
      t.rdb = o.a(localk, localLuggageGetA8Key);
    }
  }
  
  public View pW()
  {
    this.rbA = ((h)this.biT.qp());
    this.rbB = new l(this.mContext, super.pW());
    this.rbA.setCompetitorView(this.rbB);
    this.rbC = new FrameLayout(this.mContext);
    this.rbD = new LinearLayout(this.mContext);
    this.rbC.addView(this.rbD, new FrameLayout.LayoutParams(-1, -1));
    this.rbD.setOrientation(1);
    this.rbD.addView(aYz());
    View localView = com.tencent.mm.ui.y.gt(this.mContext).inflate(R.i.luggage_mm_page, this.rbD, false);
    this.rbD.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.rbL = ((FrameLayout)localView.findViewById(R.h.container));
    this.rbJ = ((MMFalseProgressBar)localView.findViewById(R.h.web_falseprogress));
    this.rbK = ((MovingImageButton)localView.findViewById(R.h.full_screen_menu));
    this.rbK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        e.this.aYv();
      }
    });
    this.rbF = ((WebViewKeyboardLinearLayout)localView.findViewById(R.h.game_webview_keyboard_ll));
    ((FrameLayout)localView.findViewById(R.h.web_container)).addView(this.rbB, new ViewGroup.LayoutParams(-1, -1));
    this.rbG = ((WebViewInputFooter)localView.findViewById(R.h.webview_input_footer));
    this.rbG.hide();
    this.rbG.setOnTextSendListener(new e.2(this));
    this.rbG.setOnSmileyChosenListener(new e.3(this));
    this.rbG.setOnSmileyPanelVisibilityChangedListener(new e.4(this));
    this.rbH = ((WebViewSearchContentInputFooter)localView.findViewById(R.h.search_content_input_footer));
    this.rbH.setActionDelegate(new e.5(this));
    this.rbA.setFindListener(new e.6(this));
    this.rbI = ((FrameLayout)localView.findViewById(R.h.refresh_mask));
    if (this.rbI != null) {
      this.rbI.setOnClickListener(new e.21(this));
    }
    this.rbF.setOnkbdStateListener(new e.7(this));
    this.rbA.setOnTouchListener(new e.22(this));
    return this.rbC;
  }
  
  public void pY()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "onForeground");
    BV(this.biV.getInt("screen_orientation", -1));
    gv(isFullScreen());
    aYA();
    zU("onResume");
    this.rbA.onResume();
  }
  
  public void qa()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuggageMMWebPage", "onBackground");
    zU("onPause");
    this.rbE.aYw();
    this.rbA.onPause();
  }
  
  public String qq()
  {
    return com.tencent.luggage.j.h.k(this.mContext, "luggage_game_adapter.js");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e
 * JD-Core Version:    0.7.0.1
 */