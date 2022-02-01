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
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
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
  private static final Pattern ClN;
  private static final Pattern ClO;
  public t ClA;
  protected p.a ClB;
  protected Map<String, String> ClC;
  protected boolean ClD;
  protected boolean ClE;
  protected int ClF;
  protected boolean ClG;
  private boolean ClH;
  protected boolean ClI;
  public boolean ClJ;
  private boolean ClK;
  private boolean ClL;
  public v ClM;
  private com.tencent.mm.plugin.webview.e.a<arn> ClP;
  protected com.tencent.mm.plugin.webview.luggage.d.a Clh;
  protected k Cli;
  protected LinearLayout Clj;
  protected l Clk;
  private WebViewKeyboardLinearLayout Cll;
  public WebViewInputFooter Clm;
  public WebViewSearchContentInputFooter Cln;
  private FrameLayout Clo;
  private MMFalseProgressBar Clp;
  protected MovingImageButton Clq;
  protected FrameLayout Clr;
  public FrameLayout Cls;
  protected r Clt;
  protected p Clu;
  protected HandOffURL Clv;
  private WebChromeClient.CustomViewCallback Clw;
  private FrameLayout Clx;
  private ProgressBar Cly;
  protected com.tencent.mm.plugin.webview.e.c Clz;
  private com.tencent.mm.plugin.webview.ui.tools.c kYU;
  private boolean kYe;
  public ao mHandler;
  public FrameLayout mRootView;
  public int nwY;
  public int nwZ;
  private n.a oKx;
  protected String sWG;
  
  static
  {
    AppMethodBeat.i(78330);
    ClN = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    ClO = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public f(com.tencent.luggage.d.g paramg, com.tencent.luggage.d.k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(78282);
    this.kYe = true;
    this.ClD = false;
    this.ClI = false;
    this.ClJ = false;
    this.ClK = false;
    this.ClL = false;
    this.nwY = 0;
    this.nwZ = 0;
    this.ClM = new v();
    this.ClP = new com.tencent.mm.plugin.webview.e.a()
    {
      public final void A(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(188287);
        f.this.ClD = false;
        f.this.av(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(78263);
            f localf = f.this;
            String str = paramAnonymousString2;
            localf.bXF.bXs.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(78263);
          }
        });
        AppMethodBeat.o(188287);
      }
      
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(78268);
        f.this.ClD = false;
        f.this.av(new Runnable()
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
      
      public final void bj(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void bk(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(188286);
        f.this.ahc(paramAnonymousString);
        AppMethodBeat.o(188286);
      }
    };
    this.oKx = new n.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(78271);
        if (com.tencent.mm.cq.d.kD(f.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            f.this.aBx(paramAnonymousWebResourceRequest.getUrl().toString());
          }
        }
        catch (Exception paramAnonymousWebResourceRequest)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", new Object[] { paramAnonymousWebResourceRequest.getMessage() });
          }
        }
        catch (Throwable paramAnonymousWebResourceRequest)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", new Object[] { paramAnonymousWebResourceRequest.getMessage() });
          }
        }
        AppMethodBeat.o(78271);
        return null;
      }
      
      public final void a(n paramAnonymousn, String paramAnonymousString)
      {
        AppMethodBeat.i(78269);
        f.this.bK(paramAnonymousString);
        AppMethodBeat.o(78269);
      }
      
      public final void b(n paramAnonymousn, String paramAnonymousString)
      {
        AppMethodBeat.i(78270);
        f.this.bL(paramAnonymousString);
        AppMethodBeat.o(78270);
      }
    };
    if (paramk != null)
    {
      this.ClG = true;
      this.Clz = com.tencent.mm.plugin.webview.e.e.Vb(paramk.hashCode());
    }
    if (this.Clz == null) {}
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.Clz == null) {
        this.Clz = new com.tencent.mm.plugin.webview.e.c();
      }
      this.mHandler = new ao();
      this.ClA = new t(this);
      this.ClB = new p.a(this, this.Clz);
      this.bXF.bXu = this.ClB;
      this.Clt = new r(this);
      this.Clu = new p(new c(this), this);
      i.b(this);
      if (this.Clh != null)
      {
        this.Clh.setPage(this);
        this.Clh.setWebViewClient(new com.tencent.xweb.ac()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(78251);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            f.this.B(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(78251);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.r paramAnonymousr, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(78252);
            if (f.f(f.this) == null) {
              f.a(f.this, new com.tencent.mm.plugin.webview.ui.tools.c(f.this.mContext, paramAnonymousWebView));
            }
            f.f(f.this).a(f.this.getUrl(), paramAnonymousr, paramAnonymousSslError);
            AppMethodBeat.o(78252);
          }
        });
        this.Clh.setWebChromeClient(new x()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            AppMethodBeat.i(78253);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.b.Rp(paramAnonymousString)) {
              f.this.dt(paramAnonymousString, 0);
            }
            f.this.bXF.AP();
            AppMethodBeat.o(78253);
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(78256);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
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
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (f.g(f.this) == null)
            {
              AppMethodBeat.o(78255);
              return;
            }
            try
            {
              f.this.Cli.setVisibility(0);
              if (f.h(f.this) != null) {
                f.h(f.this).onCustomViewHidden();
              }
              f.this.Clk.setVisibility(0);
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
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(78255);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(78254);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
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
              f.this.Cli.setVisibility(8);
              f.this.Clk.setVisibility(8);
              f.this.mRootView.addView(f.g(f.this));
              AppMethodBeat.o(78254);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(78254);
            }
          }
        });
      }
      a(this.oKx);
      paramg = this.bWV;
      paramk = new i.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (f.this.eAn())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((f.this.Clu != null) && (f.this.Clu.rT(2)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          AppMethodBeat.o(78236);
          return false;
        }
      };
      paramg.bXo.put(paramk, Boolean.FALSE);
      AppMethodBeat.o(78282);
      return;
      bool = false;
    }
  }
  
  private void UR(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Cln.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.Cln.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.Cln.isShown()) {
      i = paramInt + this.Cln.getHeight();
    }
    this.Cli.setPadding(this.Cli.getPaddingLeft(), this.Cli.getPaddingTop(), this.Cli.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  public String AQ()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.z.d.Rn("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public View Ar()
  {
    AppMethodBeat.i(78283);
    this.Clh = ((com.tencent.mm.plugin.webview.luggage.d.a)this.bXF.AN());
    this.Cli = new k(this.mContext, super.Ar());
    this.Clh.setCompetitorView(this.Cli);
    this.Clh.setSource(this.mParams.getString("KPublisherId"));
    this.mRootView = new FrameLayout(this.mContext);
    this.Clj = new LinearLayout(this.mContext);
    this.Clj.setBackgroundColor(android.support.v4.content.b.n(this.mContext, 2131101179));
    this.mRootView.addView(this.Clj, new FrameLayout.LayoutParams(-1, -1));
    this.Clj.setOrientation(1);
    this.Clj.addView(cOQ(), -1, -2);
    Object localObject = com.tencent.mm.ui.z.jD(this.mContext).inflate(2131494673, this.Clj, false);
    this.Clj.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    this.Clr = ((FrameLayout)((View)localObject).findViewById(2131298736));
    this.Clp = ((MMFalseProgressBar)((View)localObject).findViewById(2131306899));
    this.Clq = ((MovingImageButton)((View)localObject).findViewById(2131300327));
    this.Clq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78257);
        f.this.cOM();
        AppMethodBeat.o(78257);
      }
    });
    this.Cll = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(2131300570));
    this.Cls = ((FrameLayout)((View)localObject).findViewById(2131306898));
    this.Cls.addView(this.Cli, new ViewGroup.LayoutParams(-1, -1));
    this.Clm = ((WebViewInputFooter)((View)localObject).findViewById(2131306916));
    this.Clm.hide();
    this.Clm.setOnTextSendListener(new WebViewInputFooter.c()
    {
      public final void aBy(String paramAnonymousString)
      {
        AppMethodBeat.i(78279);
        f.eAy();
        if (f.b(f.this) != null) {
          f.b(f.this).hide();
        }
        AppMethodBeat.o(78279);
      }
    });
    this.Clm.setOnSmileyChosenListener(new WebViewInputFooter.a()
    {
      public final boolean RU(final String paramAnonymousString)
      {
        AppMethodBeat.i(78281);
        f.this.bXF.a(new com.tencent.luggage.d.c()
        {
          public final JSONObject Aq()
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
    this.Clm.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
    {
      public final void eAB()
      {
        AppMethodBeat.i(78237);
        f.this.UQ(0);
        AppMethodBeat.o(78237);
      }
      
      public final void eAC()
      {
        AppMethodBeat.i(78238);
        if ((f.c(f.this) != null) && (f.c(f.this).getKeyBoardHeight() > 0)) {
          f.this.UQ(f.c(f.this).getKeyBoardHeight());
        }
        AppMethodBeat.o(78238);
      }
    });
    this.Cln = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(2131304407));
    this.Cln.setActionDelegate(new WebViewSearchContentInputFooter.a()
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
        f.this.Clh.clearMatches();
        paramAnonymousWebViewSearchContentInputFooter.reset();
        f.d(f.this).C(0, 0, true);
        f.this.Clh.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
        AppMethodBeat.o(78243);
      }
      
      public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
      
      public final void eAD()
      {
        AppMethodBeat.i(78239);
        f.a(f.this, 0);
        f.this.Clh.clearMatches();
        f.d(f.this).eGK();
        AppMethodBeat.o(78239);
      }
      
      public final void eAE()
      {
        AppMethodBeat.i(78241);
        f.this.Clh.findNext(false);
        AppMethodBeat.o(78241);
      }
      
      public final void eAF()
      {
        AppMethodBeat.i(78242);
        f.this.Clh.findNext(true);
        AppMethodBeat.o(78242);
      }
    });
    this.Clh.setFindListener(new WebView.FindListener()
    {
      public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78244);
        f.d(f.this).C(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
        AppMethodBeat.o(78244);
      }
    });
    this.Clo = ((FrameLayout)((View)localObject).findViewById(2131303929));
    if (this.Clo != null) {
      this.Clo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78274);
          f.this.bXF.loadUrl(f.this.getUrl());
          f.a(f.this).setVisibility(8);
          AppMethodBeat.o(78274);
        }
      });
    }
    this.Cll.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void FG(int paramAnonymousInt)
      {
        AppMethodBeat.i(78245);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
        if (!f.e(f.this))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "background ignored");
          AppMethodBeat.o(78245);
          return;
        }
        f.a(f.this, f.c(f.this), paramAnonymousInt);
        if (paramAnonymousInt == -3)
        {
          if ((f.b(f.this) != null) && (f.b(f.this).getVisibility() == 0)) {
            f.b(f.this).eGN();
          }
          f.a(f.this, f.c(f.this).getKeyBoardHeight());
          AppMethodBeat.o(78245);
          return;
        }
        f.a(f.this, 0);
        AppMethodBeat.o(78245);
      }
    });
    this.Clh.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78275);
        if (f.b(f.this).isShown()) {
          f.b(f.this).hide();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          f.this.nwY = ((int)paramAnonymousMotionEvent.getRawX());
          f.this.nwZ = ((int)paramAnonymousMotionEvent.getRawY());
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
  
  public boolean Gi(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.Clz.fn(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  public final void UP(int paramInt)
  {
    AppMethodBeat.i(78291);
    this.mParams.putInt("screen_orientation", paramInt);
    ((Activity)this.mContext).setRequestedOrientation(paramInt);
    AppMethodBeat.o(78291);
  }
  
  public final void UQ(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Clm.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.Clm.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  public final void US(int paramInt)
  {
    AppMethodBeat.i(188290);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.Clh.getSettings().setTextZoom(100);
      AppMethodBeat.o(188290);
      return;
    case 1: 
      this.Clh.getSettings().setTextZoom(80);
      AppMethodBeat.o(188290);
      return;
    case 2: 
      this.Clh.getSettings().setTextZoom(100);
      AppMethodBeat.o(188290);
      return;
    case 3: 
      this.Clh.getSettings().setTextZoom(110);
      AppMethodBeat.o(188290);
      return;
    case 4: 
      this.Clh.getSettings().setTextZoom(112);
      AppMethodBeat.o(188290);
      return;
    case 5: 
      this.Clh.getSettings().setTextZoom(112);
      AppMethodBeat.o(188290);
      return;
    case 6: 
      this.Clh.getSettings().setTextZoom(140);
      AppMethodBeat.o(188290);
      return;
    case 7: 
      this.Clh.getSettings().setTextZoom(155);
      AppMethodBeat.o(188290);
      return;
    }
    this.Clh.getSettings().setTextZoom(165);
    AppMethodBeat.o(188290);
  }
  
  protected final void WL(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.bXF.a(new com.tencent.luggage.d.c()
    {
      public final JSONObject Aq()
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
  
  protected final boolean aBx(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.Clz.a(paramString, 5, this.ClP) == c.a.Ctn)
    {
      AppMethodBeat.o(78320);
      return true;
    }
    AppMethodBeat.o(78320);
    return false;
  }
  
  protected void agX(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.Clh.getX5WebViewExtension() != null)
    {
      this.Cli.setPullDownEnabled(true);
      this.Cli.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean agZ(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.Clz.aCG(paramString))
    {
      this.ClD = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.Clz.a(paramString, this.ClP) == c.a.Ctn) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.ClD = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected boolean aha(String paramString)
  {
    return false;
  }
  
  protected void ahb(String paramString)
  {
    AppMethodBeat.i(78314);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.Clh.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  protected void ahc(String paramString) {}
  
  public final void av(Runnable paramRunnable)
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
  
  protected final void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78322);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78322);
      return;
      if (!aha(paramString)) {
        this.Clo.setVisibility(0);
      }
    }
  }
  
  protected void bK(String paramString)
  {
    AppMethodBeat.i(78315);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    if (agZ(paramString))
    {
      int i = this.Clz.aCF(paramString);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.bXF.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.d(this.Clh);
    if (this.Clu != null)
    {
      this.Clu.er("rawUrl", paramString);
      this.Clu.aBz(paramString);
    }
    if (this.Clv != null)
    {
      this.Clv.setUrl(bs.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Clv);
    }
    this.Clk.setOptionEnable(false);
    cOK();
    agX(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void bL(String paramString)
  {
    AppMethodBeat.i(78316);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.d(this.Clh);
    this.Clk.setOptionEnable(true);
    cOS();
    if (this.Clu != null)
    {
      this.Clu.er("rawUrl", paramString);
      this.Clu.aBz(paramString);
    }
    if (this.Clv != null)
    {
      this.Clv.setUrl(bs.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Clv);
    }
    AppMethodBeat.o(78316);
  }
  
  public final String bLL()
  {
    AppMethodBeat.i(78318);
    String str = this.mParams.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  protected boolean bMn()
  {
    AppMethodBeat.i(78325);
    if (!this.mParams.getBoolean("disable_minimize", false)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(78325);
      return bool;
    }
  }
  
  public final void bdN()
  {
    AppMethodBeat.i(78297);
    this.ClF = android.support.v4.content.b.n(this.mContext, 2131099873);
    eAm();
    AppMethodBeat.o(78297);
  }
  
  protected void cOK()
  {
    AppMethodBeat.i(78310);
    this.Clp.setVisibility(0);
    this.Clp.start();
    AppMethodBeat.o(78310);
  }
  
  protected void cOM()
  {
    AppMethodBeat.i(78285);
    this.Clk.cOM();
    AppMethodBeat.o(78285);
  }
  
  protected View cOQ()
  {
    AppMethodBeat.i(78284);
    this.Clk = new l(this);
    l locall = this.Clk;
    AppMethodBeat.o(78284);
    return locall;
  }
  
  protected void cOR()
  {
    AppMethodBeat.i(78294);
    if (!this.ClE)
    {
      this.ClF = this.mParams.getInt("customize_status_bar_color");
      if (this.ClF == 0) {
        this.ClF = android.support.v4.content.b.n(this.mContext, 2131099873);
      }
    }
    eAm();
    AppMethodBeat.o(78294);
  }
  
  protected void cOS()
  {
    AppMethodBeat.i(78311);
    this.Clp.finish();
    this.Clp.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  public final void cZS()
  {
    AppMethodBeat.i(78306);
    this.Clk.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  public void dt(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.ClL) {
      this.Clu.SO(paramString);
    }
    if (this.Clv != null)
    {
      this.Clv.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.Clv);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78278);
        if (f.this.Clk != null)
        {
          if (!bs.isNullOrNil(paramString)) {
            f.this.Clk.setTitleText(paramString);
          }
          if (paramInt != 0) {
            f.this.Clk.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(78278);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  protected void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (bs.isNullOrNil(this.sWG)) {
      this.sWG = paramString2;
    }
    this.ClC = paramMap;
    if ((!aha(paramString1)) && (!this.ClG))
    {
      this.bXF.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        this.bXF.bXs.loadUrl(paramString2, paramMap);
        AppMethodBeat.o(78321);
        return;
      }
      this.bXF.loadUrl(paramString2);
    }
    AppMethodBeat.o(78321);
  }
  
  public final void eAl()
  {
    AppMethodBeat.i(78286);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.mParams.getString("float_ball_key");
    if (!bs.isNullOrNil(str)) {
      this.Clu.aa(5, str);
    }
    for (;;)
    {
      this.Clu.er("rawUrl", bLL());
      this.Clu.aBz(bLL());
      if (bs.isNullOrNil(this.Clk.getTitle())) {
        this.Clu.SO(bLL());
      }
      this.ClL = true;
      if (this.ClK) {
        this.Clu.bcX();
      }
      this.Clv = new HandOffURL(bs.nullAsNil(bLL()), bs.nullAsNil(bLL()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.Clv);
      AppMethodBeat.o(78286);
      return;
      this.Clu.aa(5, com.tencent.mm.plugin.ball.f.b.SS(bLL()));
    }
  }
  
  protected final void eAm()
  {
    AppMethodBeat.i(78295);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.LuggageMMWebPage", "setActionBarColor");
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78277);
          f.this.eAm();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.Clk.setActionBarColor(this.ClF);
    AppMethodBeat.o(78295);
  }
  
  public final boolean eAn()
  {
    AppMethodBeat.i(78304);
    if (this.Clk != null)
    {
      boolean bool = this.Clk.eAn();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final l eAo()
  {
    return this.Clk;
  }
  
  public final void eAp()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78261);
        f.this.Cli.setPullDownEnabled(false);
        AppMethodBeat.o(78261);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean eAq()
  {
    return this.ClD;
  }
  
  public final String eAr()
  {
    return this.sWG;
  }
  
  public final com.tencent.mm.plugin.webview.e.c eAs()
  {
    return this.Clz;
  }
  
  public final p.a eAt()
  {
    return this.ClB;
  }
  
  public final boolean eAu()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.mParams.getBoolean("forceHideShare", false);
    boolean bool2 = this.mParams.getBoolean("showShare", true);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bMn()) });
    if ((!bool1) && (bool2) && (bMn()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final p eAv()
  {
    return this.Clu;
  }
  
  public final HandOffURL eAw()
  {
    return this.Clv;
  }
  
  public final void eAx()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.bWW.AE().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.bWW.AF().remove(i)) {
        ((Activity)this.mContext).finish();
      }
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.p.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78272);
        f.this.eAx();
        AppMethodBeat.o(78272);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.ClG) });
    if (this.ClG)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.Clk.setOptionEnable(true);
      if (!bs.isNullOrNil(this.mParams.getString("title"))) {
        dt(this.mParams.getString("title"), 0);
      }
      this.kYe = false;
      if (this.Clz == null) {
        this.Clz = new com.tencent.mm.plugin.webview.e.c();
      }
      agZ(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    cOK();
    if (aha(paramString)) {
      ahb(paramString);
    }
    while (this.kYe)
    {
      agZ(paramString);
      this.kYe = false;
      AppMethodBeat.o(78313);
      return;
    }
    g(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  public final void gb(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if ((this.Clu != null) && (this.Clu.rT(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.bWW.AF().bo(paramBoolean))
      {
        ((Activity)this.mContext).finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.p.z(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          f.this.gb(paramBoolean);
          AppMethodBeat.o(78273);
        }
      });
    }
    AppMethodBeat.o(78327);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(210023);
    String str = this.Clk.getTitle();
    AppMethodBeat.o(210023);
    return str;
  }
  
  public final String getUrl()
  {
    if (this.bXF != null) {
      return this.bXF.mUrl;
    }
    return null;
  }
  
  public final MMWebView getWebView()
  {
    return this.Clh;
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(78303);
    boolean bool = this.mParams.getBoolean("show_full_screen", false);
    AppMethodBeat.o(78303);
    return bool;
  }
  
  protected void mG(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.Clk.setVisibility(8);
      this.Clq.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.Clk.setVisibility(0);
    this.Clq.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.ClK = false;
    WL("onPause");
    this.Clk.cON();
    this.Clh.onPause();
    this.ClH = false;
    if (this.Clu != null) {
      this.Clu.bcY();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.ClI)
    {
      this.ClI = true;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.Clt.CkZ = null;
      i.c(this);
      this.mRootView.removeAllViews();
      this.bXF.setContext(ai.getContext());
      if (this.Clu != null)
      {
        this.Clu.onDestroy();
        if (!this.Clu.bGo()) {
          break label144;
        }
        q.a(this.Clu.CmA, this.bXF, this.Clz);
      }
    }
    for (;;)
    {
      if (this.Clv != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.Clv);
      }
      this.Clz.Cdd = true;
      this.Clk.onDestroy();
      AppMethodBeat.o(78289);
      return;
      label144:
      WL("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.ClK)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.ClK = true;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.ClJ)
    {
      gb(false);
      AppMethodBeat.o(78287);
      return;
    }
    UP(this.mParams.getInt("screen_orientation", -1));
    mG(isFullScreen());
    cOR();
    WL("onResume");
    this.Clh.onResume();
    this.ClH = true;
    UR(0);
    if (this.ClL) {
      this.Clu.bcX();
    }
    this.Clk.onForeground();
    AppMethodBeat.o(78287);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.Clh.reload();
    AppMethodBeat.o(78290);
  }
  
  public final void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(78296);
    this.ClE = true;
    this.ClF = paramInt;
    eAm();
    AppMethodBeat.o(78296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.f
 * JD-Core Version:    0.7.0.1
 */