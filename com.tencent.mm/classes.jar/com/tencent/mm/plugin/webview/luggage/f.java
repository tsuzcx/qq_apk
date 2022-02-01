package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.i.a;
import com.tencent.luggage.d.n;
import com.tencent.luggage.d.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.e.c.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends n
{
  private static final Pattern ATA;
  private static final Pattern ATB;
  protected com.tencent.mm.plugin.webview.luggage.d.a ASU;
  protected k ASV;
  protected LinearLayout ASW;
  protected l ASX;
  private WebViewKeyboardLinearLayout ASY;
  public WebViewInputFooter ASZ;
  private com.tencent.mm.plugin.webview.e.a<aoj> ATC;
  public WebViewSearchContentInputFooter ATa;
  private FrameLayout ATb;
  private MMFalseProgressBar ATc;
  protected MovingImageButton ATd;
  protected FrameLayout ATe;
  public FrameLayout ATf;
  protected r ATg;
  protected p ATh;
  protected HandOffURL ATi;
  private WebChromeClient.CustomViewCallback ATj;
  private FrameLayout ATk;
  private ProgressBar ATl;
  protected com.tencent.mm.plugin.webview.e.c ATm;
  public t ATn;
  protected p.a ATo;
  protected Map<String, String> ATp;
  protected boolean ATq;
  protected boolean ATr;
  protected int ATs;
  protected boolean ATt;
  private boolean ATu;
  protected boolean ATv;
  public boolean ATw;
  private boolean ATx;
  private boolean ATy;
  public v ATz;
  private boolean kwQ;
  private com.tencent.mm.plugin.webview.ui.tools.c kxG;
  public ap mHandler;
  public FrameLayout mRootView;
  public int mUE;
  public int mUF;
  private n.a ogX;
  protected String rOQ;
  
  static
  {
    AppMethodBeat.i(78330);
    ATA = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    ATB = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public f(com.tencent.luggage.d.g paramg, com.tencent.luggage.d.k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(78282);
    this.kwQ = true;
    this.ATq = false;
    this.ATv = false;
    this.ATw = false;
    this.ATx = false;
    this.ATy = false;
    this.mUE = 0;
    this.mUF = 0;
    this.ATz = new v();
    this.ATC = new com.tencent.mm.plugin.webview.e.a()
    {
      public final void A(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(187861);
        f.this.ATq = false;
        f.this.at(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78263);
            f localf = f.this;
            String str = paramAnonymousString2;
            localf.caI.cav.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(78263);
          }
        });
        AppMethodBeat.o(187861);
      }
      
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(78268);
        f.this.ATq = false;
        f.this.at(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78264);
            f.this.b(paramAnonymousInt1, paramAnonymousString1, paramAnonymousInt2, paramAnonymousInt3);
            AppMethodBeat.o(78264);
          }
        });
        AppMethodBeat.o(78268);
      }
      
      public final void be(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void bf(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(187860);
        f.this.ack(paramAnonymousString);
        AppMethodBeat.o(187860);
      }
    };
    this.ogX = new n.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(78271);
        if (com.tencent.mm.cr.d.kr(f.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            ad.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            f.this.awf(paramAnonymousWebResourceRequest.getUrl().toString());
          }
        }
        catch (Exception paramAnonymousWebResourceRequest)
        {
          for (;;)
          {
            ad.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", new Object[] { paramAnonymousWebResourceRequest.getMessage() });
          }
        }
        catch (Throwable paramAnonymousWebResourceRequest)
        {
          for (;;)
          {
            ad.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", new Object[] { paramAnonymousWebResourceRequest.getMessage() });
          }
        }
        AppMethodBeat.o(78271);
        return null;
      }
      
      public final void a(n paramAnonymousn, String paramAnonymousString)
      {
        AppMethodBeat.i(78269);
        f.this.bU(paramAnonymousString);
        AppMethodBeat.o(78269);
      }
      
      public final void b(n paramAnonymousn, String paramAnonymousString)
      {
        AppMethodBeat.i(78270);
        f.this.bV(paramAnonymousString);
        AppMethodBeat.o(78270);
      }
    };
    if (paramk != null)
    {
      this.ATt = true;
      this.ATm = com.tencent.mm.plugin.webview.e.e.ST(paramk.hashCode());
    }
    if (this.ATm == null) {}
    for (;;)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.ATm == null) {
        this.ATm = new com.tencent.mm.plugin.webview.e.c();
      }
      this.mHandler = new ap();
      this.ATn = new t(this);
      this.ATo = new p.a(this, this.ATm);
      this.caI.cax = this.ATo;
      this.ATg = new r(this);
      this.ATh = new p(new c(this), this);
      i.b(this);
      if (this.ASU != null)
      {
        this.ASU.setPage(this);
        this.ASU.setWebViewClient(new ab()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78251);
            ad.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            f.this.B(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(78251);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.q paramAnonymousq, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(78252);
            if (f.f(f.this) == null) {
              f.a(f.this, new com.tencent.mm.plugin.webview.ui.tools.c(f.this.mContext, paramAnonymousWebView));
            }
            f.f(f.this).a(f.this.getUrl(), paramAnonymousq, paramAnonymousSslError);
            AppMethodBeat.o(78252);
          }
        });
        this.ASU.setWebChromeClient(new w()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            AppMethodBeat.i(78253);
            ad.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.b.Ng(paramAnonymousString)) {
              f.this.dn(paramAnonymousString, 0);
            }
            f.this.caI.Bl();
            AppMethodBeat.o(78253);
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(78256);
            ad.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (f.i(f.this) == null)
            {
              f.a(f.this, new ProgressBar(f.this.mContext));
              f.i(f.this).setIndeterminate(true);
            }
            ProgressBar localProgressBar = f.i(f.this);
            AppMethodBeat.o(78256);
            return localProgressBar;
          }
          
          public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            return false;
          }
          
          public final void onHideCustomView()
          {
            AppMethodBeat.i(78255);
            ad.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (f.g(f.this) == null)
            {
              AppMethodBeat.o(78255);
              return;
            }
            try
            {
              f.this.ASV.setVisibility(0);
              if (f.h(f.this) != null) {
                f.h(f.this).onCustomViewHidden();
              }
              f.this.ASX.setVisibility(0);
              if (f.g(f.this) != null) {
                f.this.mRootView.removeView(f.g(f.this));
              }
              f.g(f.this).removeAllViews();
              f.a(f.this, null);
              AppMethodBeat.o(78255);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(78255);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(78254);
            ad.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
            try
            {
              if (f.g(f.this) != null)
              {
                paramAnonymousCustomViewCallback.onCustomViewHidden();
                AppMethodBeat.o(78254);
                return;
              }
              f.a(f.this, new FrameLayout(f.this.mContext));
              f.g(f.this).setBackgroundResource(2131101165);
              f.g(f.this).addView(paramAnonymousView);
              f.a(f.this, paramAnonymousCustomViewCallback);
              f.this.ASV.setVisibility(8);
              f.this.ASX.setVisibility(8);
              f.this.mRootView.addView(f.g(f.this));
              AppMethodBeat.o(78254);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(78254);
            }
          }
        });
      }
      a(this.ogX);
      paramg = this.bZY;
      paramk = new i.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (f.this.ekR())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((f.this.ATh != null) && (f.this.ATh.rg(2)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          AppMethodBeat.o(78236);
          return false;
        }
      };
      paramg.car.put(paramk, Boolean.FALSE);
      AppMethodBeat.o(78282);
      return;
      bool = false;
    }
  }
  
  private void SJ(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ATa.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.ATa.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.ATa.isShown()) {
      i = paramInt + this.ATa.getHeight();
    }
    this.ASV.setPadding(this.ASV.getPaddingLeft(), this.ASV.getPaddingTop(), this.ASV.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  public View AN()
  {
    AppMethodBeat.i(78283);
    this.ASU = ((com.tencent.mm.plugin.webview.luggage.d.a)this.caI.Bj());
    this.ASV = new k(this.mContext, super.AN());
    this.ASU.setCompetitorView(this.ASV);
    this.ASU.setSource(this.mParams.getString("KPublisherId"));
    this.mRootView = new FrameLayout(this.mContext);
    this.ASW = new LinearLayout(this.mContext);
    this.ASW.setBackgroundColor(android.support.v4.content.b.n(this.mContext, 2131101179));
    this.mRootView.addView(this.ASW, new FrameLayout.LayoutParams(-1, -1));
    this.ASW.setOrientation(1);
    this.ASW.addView(cBF(), -1, -2);
    Object localObject = com.tencent.mm.ui.y.js(this.mContext).inflate(2131494673, this.ASW, false);
    this.ASW.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    this.ATe = ((FrameLayout)((View)localObject).findViewById(2131298736));
    this.ATc = ((MMFalseProgressBar)((View)localObject).findViewById(2131306899));
    this.ATd = ((MovingImageButton)((View)localObject).findViewById(2131300327));
    this.ATd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78257);
        f.this.cBB();
        AppMethodBeat.o(78257);
      }
    });
    this.ASY = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(2131300570));
    this.ATf = ((FrameLayout)((View)localObject).findViewById(2131306898));
    this.ATf.addView(this.ASV, new ViewGroup.LayoutParams(-1, -1));
    this.ASZ = ((WebViewInputFooter)((View)localObject).findViewById(2131306916));
    this.ASZ.hide();
    this.ASZ.setOnTextSendListener(new WebViewInputFooter.c()
    {
      public final void awg(String paramAnonymousString)
      {
        AppMethodBeat.i(78279);
        f.elc();
        if (f.b(f.this) != null) {
          f.b(f.this).hide();
        }
        AppMethodBeat.o(78279);
      }
    });
    this.ASZ.setOnSmileyChosenListener(new WebViewInputFooter.a()
    {
      public final boolean NL(final String paramAnonymousString)
      {
        AppMethodBeat.i(78281);
        f.this.caI.a(new com.tencent.luggage.d.c()
        {
          public final JSONObject AM()
          {
            AppMethodBeat.i(78280);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("smiley", paramAnonymousString);
              label24:
              AppMethodBeat.o(78280);
              return localJSONObject;
            }
            catch (JSONException localJSONException)
            {
              break label24;
            }
          }
          
          public final String name()
          {
            return "onGetSmiley";
          }
        });
        AppMethodBeat.o(78281);
        return true;
      }
    });
    this.ASZ.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
    {
      public final void elf()
      {
        AppMethodBeat.i(78237);
        f.this.SI(0);
        AppMethodBeat.o(78237);
      }
      
      public final void elg()
      {
        AppMethodBeat.i(78238);
        if ((f.c(f.this) != null) && (f.c(f.this).getKeyBoardHeight() > 0)) {
          f.this.SI(f.c(f.this).getKeyBoardHeight());
        }
        AppMethodBeat.o(78238);
      }
    });
    this.ATa = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(2131304407));
    this.ATa.setActionDelegate(new WebViewSearchContentInputFooter.a()
    {
      public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
      {
        AppMethodBeat.i(78240);
        if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
          b(paramAnonymousWebViewSearchContentInputFooter);
        }
        AppMethodBeat.o(78240);
      }
      
      public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
      {
        AppMethodBeat.i(78243);
        f.this.ASU.clearMatches();
        paramAnonymousWebViewSearchContentInputFooter.reset();
        f.d(f.this).D(0, 0, true);
        f.this.ASU.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
        AppMethodBeat.o(78243);
      }
      
      public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
      
      public final void elh()
      {
        AppMethodBeat.i(78239);
        f.a(f.this, 0);
        f.this.ASU.clearMatches();
        f.d(f.this).erq();
        AppMethodBeat.o(78239);
      }
      
      public final void eli()
      {
        AppMethodBeat.i(78241);
        f.this.ASU.findNext(false);
        AppMethodBeat.o(78241);
      }
      
      public final void elj()
      {
        AppMethodBeat.i(78242);
        f.this.ASU.findNext(true);
        AppMethodBeat.o(78242);
      }
    });
    this.ASU.setFindListener(new WebView.FindListener()
    {
      public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78244);
        f.d(f.this).D(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
        AppMethodBeat.o(78244);
      }
    });
    this.ATb = ((FrameLayout)((View)localObject).findViewById(2131303929));
    if (this.ATb != null) {
      this.ATb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78274);
          f.this.caI.loadUrl(f.this.getUrl());
          f.a(f.this).setVisibility(8);
          AppMethodBeat.o(78274);
        }
      });
    }
    this.ASY.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void DK(int paramAnonymousInt)
      {
        AppMethodBeat.i(78245);
        ad.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
        if (!f.e(f.this))
        {
          ad.i("MicroMsg.LuggageMMWebPage", "background ignored");
          AppMethodBeat.o(78245);
          return;
        }
        f.a(f.this, f.c(f.this), paramAnonymousInt);
        if (paramAnonymousInt == -3)
        {
          if ((f.b(f.this) != null) && (f.b(f.this).getVisibility() == 0)) {
            f.b(f.this).ert();
          }
          f.a(f.this, f.c(f.this).getKeyBoardHeight());
          AppMethodBeat.o(78245);
          return;
        }
        f.a(f.this, 0);
        AppMethodBeat.o(78245);
      }
    });
    this.ASU.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78275);
        if (f.b(f.this).isShown()) {
          f.b(f.this).hide();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          f.this.mUE = ((int)paramAnonymousMotionEvent.getRawX());
          f.this.mUF = ((int)paramAnonymousMotionEvent.getRawY());
        }
        AppMethodBeat.o(78275);
        return false;
      }
    });
    localObject = this.mRootView;
    AppMethodBeat.o(78283);
    return localObject;
  }
  
  protected void B(int paramInt, String paramString1, String paramString2) {}
  
  public String Bm()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.aa.d.Ne("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public boolean Em(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.ATm.ff(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  public final void SH(int paramInt)
  {
    AppMethodBeat.i(78291);
    this.mParams.putInt("screen_orientation", paramInt);
    ((Activity)this.mContext).setRequestedOrientation(paramInt);
    AppMethodBeat.o(78291);
  }
  
  public final void SI(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ASZ.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.ASZ.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  public final void SK(int paramInt)
  {
    AppMethodBeat.i(187864);
    ad.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.ASU.getSettings().setTextZoom(100);
      AppMethodBeat.o(187864);
      return;
    case 1: 
      this.ASU.getSettings().setTextZoom(80);
      AppMethodBeat.o(187864);
      return;
    case 2: 
      this.ASU.getSettings().setTextZoom(100);
      AppMethodBeat.o(187864);
      return;
    case 3: 
      this.ASU.getSettings().setTextZoom(110);
      AppMethodBeat.o(187864);
      return;
    case 4: 
      this.ASU.getSettings().setTextZoom(112);
      AppMethodBeat.o(187864);
      return;
    case 5: 
      this.ASU.getSettings().setTextZoom(112);
      AppMethodBeat.o(187864);
      return;
    case 6: 
      this.ASU.getSettings().setTextZoom(140);
      AppMethodBeat.o(187864);
      return;
    case 7: 
      this.ASU.getSettings().setTextZoom(155);
      AppMethodBeat.o(187864);
      return;
    }
    this.ASU.getSettings().setTextZoom(165);
    AppMethodBeat.o(187864);
  }
  
  protected final void Sz(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.caI.a(new com.tencent.luggage.d.c()
    {
      public final JSONObject AM()
      {
        AppMethodBeat.i(78276);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("state", paramString);
          label24:
          AppMethodBeat.o(78276);
          return localJSONObject;
        }
        catch (Exception localException)
        {
          break label24;
        }
      }
      
      public final String name()
      {
        return "activity:state_change";
      }
    });
    AppMethodBeat.o(78293);
  }
  
  public final void aWP()
  {
    AppMethodBeat.i(78297);
    this.ATs = android.support.v4.content.b.n(this.mContext, 2131099873);
    ekQ();
    AppMethodBeat.o(78297);
  }
  
  protected void acf(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.ASU.getX5WebViewExtension() != null)
    {
      this.ASV.setPullDownEnabled(true);
      this.ASV.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean ach(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.ATm.axo(paramString))
    {
      this.ATq = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.ATm.a(paramString, this.ATC) == c.a.Bbb) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.ATq = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected boolean aci(String paramString)
  {
    return false;
  }
  
  protected void acj(String paramString)
  {
    AppMethodBeat.i(78314);
    ad.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.ASU.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  protected void ack(String paramString) {}
  
  public final void at(Runnable paramRunnable)
  {
    AppMethodBeat.i(78323);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(78323);
      return;
    }
    this.mHandler.post(paramRunnable);
    AppMethodBeat.o(78323);
  }
  
  protected final boolean awf(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.ATm.a(paramString, 5, this.ATC) == c.a.Bbb)
    {
      AppMethodBeat.o(78320);
      return true;
    }
    AppMethodBeat.o(78320);
    return false;
  }
  
  protected final void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78322);
    ad.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78322);
      return;
      if (!aci(paramString)) {
        this.ATb.setVisibility(0);
      }
    }
  }
  
  protected boolean bEZ()
  {
    AppMethodBeat.i(78325);
    if (!this.mParams.getBoolean("disable_minimize", false)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(78325);
      return bool;
    }
  }
  
  public final String bEx()
  {
    AppMethodBeat.i(78318);
    String str = this.mParams.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  protected void bU(String paramString)
  {
    AppMethodBeat.i(78315);
    ad.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    if (ach(paramString))
    {
      int i = this.ATm.axn(paramString);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.caI.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.e(this.ASU);
    if (this.ATh != null)
    {
      this.ATh.ef("rawUrl", paramString);
      this.ATh.awh(paramString);
    }
    if (this.ATi != null)
    {
      this.ATi.setUrl(bt.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ATi);
    }
    this.ASX.setOptionEnable(false);
    cBz();
    acf(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void bV(String paramString)
  {
    AppMethodBeat.i(78316);
    ad.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.e(this.ASU);
    this.ASX.setOptionEnable(true);
    cBH();
    if (this.ATh != null)
    {
      this.ATh.ef("rawUrl", paramString);
      this.ATh.awh(paramString);
    }
    if (this.ATi != null)
    {
      this.ATi.setUrl(bt.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ATi);
    }
    AppMethodBeat.o(78316);
  }
  
  protected void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    ad.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (bt.isNullOrNil(this.rOQ)) {
      this.rOQ = paramString2;
    }
    this.ATp = paramMap;
    if ((!aci(paramString1)) && (!this.ATt))
    {
      this.caI.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        this.caI.cav.loadUrl(paramString2, paramMap);
        AppMethodBeat.o(78321);
        return;
      }
      this.caI.loadUrl(paramString2);
    }
    AppMethodBeat.o(78321);
  }
  
  protected void cBB()
  {
    AppMethodBeat.i(78285);
    this.ASX.cBB();
    AppMethodBeat.o(78285);
  }
  
  protected View cBF()
  {
    AppMethodBeat.i(78284);
    this.ASX = new l(this);
    l locall = this.ASX;
    AppMethodBeat.o(78284);
    return locall;
  }
  
  protected void cBG()
  {
    AppMethodBeat.i(78294);
    if (!this.ATr)
    {
      this.ATs = this.mParams.getInt("customize_status_bar_color");
      if (this.ATs == 0) {
        this.ATs = android.support.v4.content.b.n(this.mContext, 2131099873);
      }
    }
    ekQ();
    AppMethodBeat.o(78294);
  }
  
  protected void cBH()
  {
    AppMethodBeat.i(78311);
    this.ATc.finish();
    this.ATc.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  protected void cBz()
  {
    AppMethodBeat.i(78310);
    this.ATc.setVisibility(0);
    this.ATc.start();
    AppMethodBeat.o(78310);
  }
  
  public final void cMm()
  {
    AppMethodBeat.i(78306);
    this.ASX.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  public void dn(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.ATy) {
      this.ATh.OE(paramString);
    }
    if (this.ATi != null)
    {
      this.ATi.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ATi);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78278);
        if (f.this.ASX != null)
        {
          if (!bt.isNullOrNil(paramString)) {
            f.this.ASX.setTitleText(paramString);
          }
          if (paramInt != 0) {
            f.this.ASX.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(78278);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  public final void ekP()
  {
    AppMethodBeat.i(78286);
    ad.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.mParams.getString("float_ball_key");
    if (!bt.isNullOrNil(str)) {
      this.ATh.Z(5, str);
    }
    for (;;)
    {
      this.ATh.ef("rawUrl", bEx());
      this.ATh.awh(bEx());
      if (bt.isNullOrNil(this.ASX.getTitle())) {
        this.ATh.OE(bEx());
      }
      this.ATy = true;
      if (this.ATx) {
        this.ATh.aVZ();
      }
      this.ATi = new HandOffURL(bt.nullAsNil(bEx()), bt.nullAsNil(bEx()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.ATi);
      AppMethodBeat.o(78286);
      return;
      this.ATh.Z(5, com.tencent.mm.plugin.ball.f.b.OI(bEx()));
    }
  }
  
  protected final void ekQ()
  {
    AppMethodBeat.i(78295);
    ad.d("MicroMsg.LuggageMMWebPage", "setActionBarColor");
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78277);
          f.this.ekQ();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.ASX.setActionBarColor(this.ATs);
    AppMethodBeat.o(78295);
  }
  
  public final boolean ekR()
  {
    AppMethodBeat.i(78304);
    if (this.ASX != null)
    {
      boolean bool = this.ASX.ekR();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final l ekS()
  {
    return this.ASX;
  }
  
  public final void ekT()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78261);
        f.this.ASV.setPullDownEnabled(false);
        AppMethodBeat.o(78261);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean ekU()
  {
    return this.ATq;
  }
  
  public final String ekV()
  {
    return this.rOQ;
  }
  
  public final com.tencent.mm.plugin.webview.e.c ekW()
  {
    return this.ATm;
  }
  
  public final p.a ekX()
  {
    return this.ATo;
  }
  
  public final boolean ekY()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.mParams.getBoolean("forceHideShare", false);
    boolean bool2 = this.mParams.getBoolean("showShare", true);
    ad.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bEZ()) });
    if ((!bool1) && (bool2) && (bEZ()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final p ekZ()
  {
    return this.ATh;
  }
  
  public final HandOffURL ela()
  {
    return this.ATi;
  }
  
  public final void elb()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.bZZ.Ba().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.bZZ.Bb().remove(i)) {
        ((Activity)this.mContext).finish();
      }
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.p.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78272);
        f.this.elb();
        AppMethodBeat.o(78272);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public final void fF(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if ((this.ATh != null) && (this.ATh.rg(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.bZZ.Bb().bp(paramBoolean))
      {
        ((Activity)this.mContext).finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.p.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          f.this.fF(paramBoolean);
          AppMethodBeat.o(78273);
        }
      });
    }
    AppMethodBeat.o(78327);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    ad.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.ATt) });
    if (this.ATt)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.ASX.setOptionEnable(true);
      if (!bt.isNullOrNil(this.mParams.getString("title"))) {
        dn(this.mParams.getString("title"), 0);
      }
      this.kwQ = false;
      if (this.ATm == null) {
        this.ATm = new com.tencent.mm.plugin.webview.e.c();
      }
      ach(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    cBz();
    if (aci(paramString)) {
      acj(paramString);
    }
    while (this.kwQ)
    {
      ach(paramString);
      this.kwQ = false;
      AppMethodBeat.o(78313);
      return;
    }
    g(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(197141);
    String str = this.ASX.getTitle();
    AppMethodBeat.o(197141);
    return str;
  }
  
  public final String getUrl()
  {
    if (this.caI != null) {
      return this.caI.mUrl;
    }
    return null;
  }
  
  public final MMWebView getWebView()
  {
    return this.ASU;
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(78303);
    boolean bool = this.mParams.getBoolean("show_full_screen", false);
    AppMethodBeat.o(78303);
    return bool;
  }
  
  protected void lN(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.ASX.setVisibility(8);
      this.ATd.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.ASX.setVisibility(0);
    this.ATd.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    ad.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.ATx = false;
    Sz("onPause");
    this.ASX.cBC();
    this.ASU.onPause();
    this.ATu = false;
    if (this.ATh != null) {
      this.ATh.aWa();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.ATv)
    {
      this.ATv = true;
      ad.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.ATg.ASM = null;
      i.c(this);
      this.mRootView.removeAllViews();
      this.caI.setContext(aj.getContext());
      if (this.ATh != null)
      {
        this.ATh.onDestroy();
        if (!this.ATh.bzs()) {
          break label144;
        }
        q.a(this.ATh.AUn, this.caI, this.ATm);
      }
    }
    for (;;)
    {
      if (this.ATi != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.ATi);
      }
      this.ATm.AKM = true;
      this.ASX.onDestroy();
      AppMethodBeat.o(78289);
      return;
      label144:
      Sz("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.ATx)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.ATx = true;
    ad.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.ATw)
    {
      fF(false);
      AppMethodBeat.o(78287);
      return;
    }
    SH(this.mParams.getInt("screen_orientation", -1));
    lN(isFullScreen());
    cBG();
    Sz("onResume");
    this.ASU.onResume();
    this.ATu = true;
    SJ(0);
    if (this.ATy) {
      this.ATh.aVZ();
    }
    this.ASX.onForeground();
    AppMethodBeat.o(78287);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.ASU.reload();
    AppMethodBeat.o(78290);
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(78296);
    this.ATr = true;
    this.ATs = paramInt;
    ekQ();
    AppMethodBeat.o(78296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.f
 * JD-Core Version:    0.7.0.1
 */