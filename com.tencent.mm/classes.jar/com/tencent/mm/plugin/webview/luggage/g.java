package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.l;
import com.tencent.luggage.d.l.a;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.e.c.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout.b;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends com.tencent.luggage.d.s
{
  private static final Pattern WGv;
  private static final Pattern WGw;
  protected String ItK;
  protected boolean IxR;
  public com.tencent.mm.plugin.webview.luggage.d.a WFO;
  protected m WFP;
  protected b WFQ;
  private WebViewKeyboardLinearLayout WFR;
  public WebViewInputFooter WFS;
  private WebViewSearchContentInputFooter WFT;
  private FrameLayout WFU;
  private MMFalseProgressBar WFV;
  protected MovingImageButton WFW;
  protected FrameLayout WFX;
  public FrameLayout WFY;
  protected t WFZ;
  protected n WFz;
  protected r WGa;
  protected u WGb;
  protected HandOffURL WGc;
  private WebChromeClient.CustomViewCallback WGd;
  private FrameLayout WGe;
  private ProgressBar WGf;
  protected com.tencent.mm.plugin.webview.e.c WGg;
  public x WGh;
  protected r.a WGi;
  protected Map<String, String> WGj;
  protected boolean WGk;
  protected boolean WGl;
  protected int WGm;
  protected boolean WGn;
  public boolean WGo;
  private boolean WGp;
  private boolean WGq;
  private boolean WGr;
  public z WGs;
  public AccessibilityManager.AccessibilityStateChangeListener WGt;
  private a WGu;
  private com.tencent.mm.plugin.webview.e.a<cdf> WGx;
  private s.a WGy;
  public AccessibilityManager bYO;
  public MMHandler mHandler;
  protected boolean mIsForeground;
  public FrameLayout mRootView;
  private boolean sLf;
  private com.tencent.mm.plugin.webview.ui.tools.d sMc;
  public int x_down;
  public int y_down;
  
  static
  {
    AppMethodBeat.i(78330);
    WGv = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    WGw = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public g(j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(78282);
    this.sLf = true;
    this.WGk = false;
    this.mIsForeground = false;
    this.IxR = false;
    this.WGo = false;
    this.WGp = false;
    this.WGq = false;
    this.WGr = false;
    this.x_down = 0;
    this.y_down = 0;
    this.WGs = new z();
    this.WGx = new com.tencent.mm.plugin.webview.e.a()
    {
      public final void J(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(295891);
        g.this.WGk = false;
        g.this.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(295897);
            g localg = g.this;
            String str = paramAnonymousString2;
            localg.ejR.ejJ.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(295897);
          }
        });
        AppMethodBeat.o(295891);
      }
      
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(295896);
        g.this.WGk = false;
        g.this.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(295892);
            g.this.c(paramAnonymousInt1, paramAnonymousString1, paramAnonymousInt2, paramAnonymousInt3);
            AppMethodBeat.o(295892);
          }
        });
        AppMethodBeat.o(295896);
      }
      
      public final void ca(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void cb(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(295887);
        g.this.aGo(paramAnonymousString);
        AppMethodBeat.o(295887);
      }
    };
    this.WGy = new s.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(295888);
        if (com.tencent.mm.xwebutil.c.nV(g.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            Log.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            g.this.bjW(paramAnonymousWebResourceRequest.getUrl().toString());
          }
        }
        catch (Exception paramAnonymousBundle)
        {
          for (;;)
          {
            Log.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", new Object[] { paramAnonymousBundle.getMessage() });
          }
        }
        finally
        {
          for (;;)
          {
            Log.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", new Object[] { paramAnonymousBundle.getMessage() });
            continue;
            paramAnonymousWebResourceRequest = "";
          }
        }
        if (paramAnonymousWebResourceRequest != null)
        {
          paramAnonymousWebResourceRequest = paramAnonymousWebResourceRequest.getUrl().toString();
          paramAnonymousWebResourceRequest = g.this.aGn(paramAnonymousWebResourceRequest);
          AppMethodBeat.o(295888);
          return paramAnonymousWebResourceRequest;
        }
      }
      
      public final void a(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(295883);
        g.this.eG(paramAnonymousString);
        AppMethodBeat.o(295883);
      }
      
      public final void b(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(295884);
        g.this.eH(paramAnonymousString);
        AppMethodBeat.o(295884);
      }
    };
    if (paramp != null)
    {
      this.WGn = true;
      this.WGg = com.tencent.mm.plugin.webview.e.e.atM(paramp.hashCode());
    }
    if (this.WGg == null) {}
    for (;;)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.WGg == null) {
        this.WGg = new com.tencent.mm.plugin.webview.e.c();
      }
      this.mHandler = new MMHandler();
      this.WGh = new x(this);
      this.WGi = new r.a(this, this.WGg);
      this.ejR.ejy = this.WGi;
      this.WFZ = new t(this);
      this.WGa = new r(new d(this), this);
      this.WGb = new u(this, new v(this));
      k.b(this);
      if (this.WFO != null)
      {
        this.WFO.setPage(this);
        this.WFO.setWebViewClient(new ag()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(295875);
            Log.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            g.this.K(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(295875);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.t paramAnonymoust, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(295881);
            if (g.e(g.this) == null) {
              g.a(g.this, new com.tencent.mm.plugin.webview.ui.tools.d(g.this.mContext, paramAnonymousWebView));
            }
            g.e(g.this).a(g.this.getUrl(), paramAnonymoust, paramAnonymousSslError);
            AppMethodBeat.o(295881);
          }
        });
        this.WFO.setWebChromeClient(new com.tencent.xweb.z()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            int i = 1;
            AppMethodBeat.i(295882);
            Log.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.c.agu(paramAnonymousString)) {
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equalsIgnoreCase("about:blank"))) {
                break label74;
              }
            }
            for (;;)
            {
              if (i == 0) {
                g.this.fq(paramAnonymousString, 0);
              }
              g.this.ejR.aoG();
              AppMethodBeat.o(295882);
              return;
              label74:
              i = 0;
            }
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(295895);
            Log.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (g.h(g.this) == null)
            {
              g.a(g.this, new ProgressBar(g.this.mContext));
              g.h(g.this).setIndeterminate(true);
            }
            ProgressBar localProgressBar = g.h(g.this);
            AppMethodBeat.o(295895);
            return localProgressBar;
          }
          
          public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            AppMethodBeat.i(295900);
            boolean bool = g.iui();
            AppMethodBeat.o(295900);
            return bool;
          }
          
          public final void onHideCustomView()
          {
            AppMethodBeat.i(295889);
            Log.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (g.f(g.this) == null)
            {
              AppMethodBeat.o(295889);
              return;
            }
            try
            {
              g.this.WFP.setVisibility(0);
              if (g.g(g.this) != null) {
                g.g(g.this).onCustomViewHidden();
              }
              g.this.WFz.setVisibility(0);
              if (g.f(g.this) != null) {
                g.this.mRootView.removeView(g.f(g.this));
              }
              g.f(g.this).removeAllViews();
              g.a(g.this, null);
              AppMethodBeat.o(295889);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(295889);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(295885);
            Log.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
            try
            {
              if (g.f(g.this) != null)
              {
                paramAnonymousCustomViewCallback.onCustomViewHidden();
                AppMethodBeat.o(295885);
                return;
              }
              g.a(g.this, new FrameLayout(g.this.mContext));
              g.f(g.this).setBackgroundResource(c.c.webview_logo_bg_color);
              g.f(g.this).addView(paramAnonymousView);
              g.a(g.this, paramAnonymousCustomViewCallback);
              g.this.WFP.setVisibility(8);
              g.this.WFz.setVisibility(8);
              g.this.mRootView.addView(g.f(g.this));
              AppMethodBeat.o(295885);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(295885);
            }
          }
        });
      }
      a(this.WGy);
      paramj = this.ejd;
      paramp = new l.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (g.this.iue())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.WGb != null) && (g.this.WGb.af(1, true)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.WGa != null) && (g.this.WGa.zX(2)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          AppMethodBeat.o(78236);
          return false;
        }
      };
      paramj.ejw.put(paramp, Boolean.FALSE);
      fER();
      this.bYO = ((AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility"));
      this.WGt = new AccessibilityManager.AccessibilityStateChangeListener()
      {
        public final void onAccessibilityStateChanged(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(295893);
          g.this.ejR.a(new com.tencent.luggage.d.d()
          {
            public final JSONObject aoe()
            {
              AppMethodBeat.i(295996);
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("isAccessibilityMode", paramAnonymousBoolean);
                label24:
                AppMethodBeat.o(295996);
                return localJSONObject;
              }
              catch (JSONException localJSONException)
              {
                break label24;
              }
            }
            
            public final String name()
            {
              return "onAccessibilityStateChange";
            }
          });
          AppMethodBeat.o(295893);
        }
      };
      this.bYO.addAccessibilityStateChangeListener(this.WGt);
      AppMethodBeat.o(78282);
      return;
      bool = false;
    }
  }
  
  private void atE(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.WFT.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.WFT.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.WFT.isShown()) {
      i = paramInt + this.WFT.getHeight();
    }
    this.WFP.setPadding(this.WFP.getPaddingLeft(), this.WFP.getPaddingTop(), this.WFP.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  protected static boolean iui()
  {
    return false;
  }
  
  public final void IF(boolean paramBoolean)
  {
    AppMethodBeat.i(296004);
    if (!paramBoolean)
    {
      this.WFT.hide();
      AppMethodBeat.o(296004);
      return;
    }
    if (!this.WFT.isShown())
    {
      this.WFT.reset();
      this.WFT.iCA();
      this.WFT.show();
    }
    AppMethodBeat.o(296004);
  }
  
  protected void K(int paramInt, String paramString1, String paramString2) {}
  
  public boolean Xp(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.WGg.ia(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  protected void aGf(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.WFO.getX5WebViewExtension() != null)
    {
      this.WFP.setPullDownEnabled(true);
      this.WFP.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean aGj(String paramString)
  {
    return false;
  }
  
  protected boolean aGl(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.WGg.ble(paramString))
    {
      this.WGk = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.WGg.a(paramString, this.WGx) == c.a.WPn) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.WGk = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected void aGm(String paramString)
  {
    AppMethodBeat.i(78314);
    Log.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.WFO.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  protected WebResourceResponse aGn(String paramString)
  {
    return null;
  }
  
  protected void aGo(String paramString) {}
  
  public final void aR(Runnable paramRunnable)
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
  
  public String aoH()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.af.d.ags("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public View aog()
  {
    AppMethodBeat.i(78283);
    Object localObject = dgY();
    this.WGu = new a((byte)0);
    localObject = Uri.parse((String)localObject);
    if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersiveUIStyle")).equals("1")) {
      this.WGu.WGL = true;
    }
    if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersivePageBgIsDark")).equals("1"))
    {
      this.WGu.WGM = true;
      if (Util.nullAsNil(((Uri)localObject).getQueryParameter("hide_share_option")).equals("1")) {
        this.WGu.WGN = true;
      }
      this.WFO = ((com.tencent.mm.plugin.webview.luggage.d.a)this.ejR.aoE());
      this.WFP = new m(getContext(), super.aog());
      this.WFO.setCompetitorView(this.WFP);
      this.WFO.setSource(this.ejT.getString("KPublisherId"));
      this.mRootView = new FrameLayout(getContext());
      this.WFQ = new b(getContext());
      this.WFQ.setBackgroundColor(androidx.core.content.a.w(getContext(), c.c.white));
      this.mRootView.addView(this.WFQ, new FrameLayout.LayoutParams(-1, -1));
      localObject = af.mU(getContext()).inflate(c.g.luggage_mm_page, this.WFQ, false);
      fEP();
      if (!fEB().booleanValue()) {
        break label671;
      }
      this.WFQ.addView((View)localObject);
    }
    for (;;)
    {
      if (this.WGu.WGN) {
        this.WFz.IG(true);
      }
      this.WFQ.setActionBar(this.WFz);
      this.WFQ.setWebView(this.WFO);
      this.WFX = ((FrameLayout)((View)localObject).findViewById(c.f.container));
      this.WFV = ((MMFalseProgressBar)((View)localObject).findViewById(c.f.web_falseprogress));
      this.WFW = ((MovingImageButton)((View)localObject).findViewById(c.f.full_screen_menu));
      this.WFW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78257);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          g.this.cxQ();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78257);
        }
      });
      this.WFR = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(c.f.game_webview_keyboard_ll));
      this.WFY = ((FrameLayout)((View)localObject).findViewById(c.f.web_container));
      this.WFY.addView(this.WFP, new ViewGroup.LayoutParams(-1, -1));
      this.WFS = ((WebViewInputFooter)((View)localObject).findViewById(c.f.webview_input_footer));
      this.WFS.hide();
      this.WFS.setOnTextSendListener(new WebViewInputFooter.c()
      {
        public final void iuy()
        {
          AppMethodBeat.i(295911);
          g.iuq();
          if (g.b(g.this) != null) {
            g.b(g.this).hide();
          }
          AppMethodBeat.o(295911);
        }
      });
      this.WFS.setOnSmileyChosenListener(new WebViewInputFooter.a()
      {
        public final boolean eZ(final String paramAnonymousString)
        {
          AppMethodBeat.i(295919);
          g.this.ejR.a(new com.tencent.luggage.d.d()
          {
            public final JSONObject aoe()
            {
              AppMethodBeat.i(295865);
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("smiley", paramAnonymousString);
                label24:
                AppMethodBeat.o(295865);
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
          AppMethodBeat.o(295919);
          return true;
        }
      });
      this.WFS.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
      {
        public final void iut()
        {
          AppMethodBeat.i(295922);
          g.this.atD(0);
          AppMethodBeat.o(295922);
        }
        
        public final void iuu()
        {
          AppMethodBeat.i(295928);
          if ((g.c(g.this) != null) && (g.c(g.this).getKeyBoardHeight() > 0)) {
            g.this.atD(g.c(g.this).getKeyBoardHeight());
          }
          AppMethodBeat.o(295928);
        }
      });
      this.WFT = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(c.f.search_content_input_footer));
      this.WFT.setActionDelegate(new WebViewSearchContentInputFooter.a()
      {
        public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(295920);
          if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
            b(paramAnonymousWebViewSearchContentInputFooter);
          }
          AppMethodBeat.o(295920);
        }
        
        public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(295929);
          g.this.WFO.clearMatches();
          paramAnonymousWebViewSearchContentInputFooter.reset();
          g.d(g.this).S(0, 0, true);
          g.this.WFO.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
          AppMethodBeat.o(295929);
        }
        
        public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return false;
        }
        
        public final void iuv()
        {
          AppMethodBeat.i(295917);
          g.a(g.this, 0);
          g.this.WFO.clearMatches();
          g.d(g.this).iCA();
          AppMethodBeat.o(295917);
        }
        
        public final void iuw()
        {
          AppMethodBeat.i(295925);
          g.this.WFO.findNext(false);
          AppMethodBeat.o(295925);
        }
        
        public final void iux()
        {
          AppMethodBeat.i(295927);
          g.this.WFO.findNext(true);
          AppMethodBeat.o(295927);
        }
      });
      this.WFO.setFindListener(new WebView.FindListener()
      {
        public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(295923);
          g.d(g.this).S(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          AppMethodBeat.o(295923);
        }
      });
      this.WFU = ((FrameLayout)((View)localObject).findViewById(c.f.refresh_mask));
      if (this.WFU != null) {
        this.WFU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(78274);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            g.this.ejR.loadUrl(g.this.getUrl());
            g.a(g.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(78274);
          }
        });
      }
      this.WFR.setOnkbdStateListener(new KeyboardLinearLayout.b()
      {
        public final void onKeyBoardStateChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(295914);
          Log.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
          if (!g.this.mIsForeground)
          {
            Log.i("MicroMsg.LuggageMMWebPage", "background ignored");
            AppMethodBeat.o(295914);
            return;
          }
          g.a(g.this, g.c(g.this), paramAnonymousInt);
          if (paramAnonymousInt == -3)
          {
            if ((g.b(g.this) != null) && (g.b(g.this).getVisibility() == 0))
            {
              WebViewInputFooter localWebViewInputFooter = g.b(g.this);
              if (localWebViewInputFooter.XrS) {
                localWebViewInputFooter.setVisibility(8);
              }
              localWebViewInputFooter.state = 0;
              localWebViewInputFooter.aWJ();
            }
            g.a(g.this, g.c(g.this).getKeyBoardHeight());
            AppMethodBeat.o(295914);
            return;
          }
          g.a(g.this, 0);
          AppMethodBeat.o(295914);
        }
      });
      this.WFO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78275);
          if (g.b(g.this).isShown()) {
            g.b(g.this).hide();
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            g.this.x_down = ((int)paramAnonymousMotionEvent.getRawX());
            g.this.y_down = ((int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(78275);
          return false;
        }
      });
      localObject = this.mRootView;
      AppMethodBeat.o(78283);
      return localObject;
      if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersivePageBgIsDark")).equals("2"))
      {
        if (aw.isDarkMode())
        {
          this.WGu.WGM = true;
          break;
        }
        this.WGu.WGM = false;
        break;
      }
      this.WGu.WGM = false;
      break;
      label671:
      b localb = this.WFQ;
      n localn = this.WFz;
      boolean bool = this.WGu.WGL;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(10);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
      if (bool)
      {
        localLayoutParams2.addRule(10);
        localb.addView((View)localObject, localLayoutParams2);
        localb.addView(localn, localLayoutParams1);
      }
      else
      {
        localb.addView(localn, localLayoutParams1);
        localLayoutParams2.addRule(3, localn.getId());
        localb.addView((View)localObject, localLayoutParams2);
      }
    }
  }
  
  public final void atD(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.WFS.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.WFS.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  public final void atq(int paramInt)
  {
    AppMethodBeat.i(296048);
    Log.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.WFO.getSettings().setTextZoom(100);
      AppMethodBeat.o(296048);
      return;
    case 1: 
      this.WFO.getSettings().setTextZoom(80);
      AppMethodBeat.o(296048);
      return;
    case 2: 
      this.WFO.getSettings().setTextZoom(100);
      AppMethodBeat.o(296048);
      return;
    case 3: 
      this.WFO.getSettings().setTextZoom(110);
      AppMethodBeat.o(296048);
      return;
    case 4: 
      this.WFO.getSettings().setTextZoom(112);
      AppMethodBeat.o(296048);
      return;
    case 5: 
      this.WFO.getSettings().setTextZoom(112);
      AppMethodBeat.o(296048);
      return;
    case 6: 
      this.WFO.getSettings().setTextZoom(140);
      AppMethodBeat.o(296048);
      return;
    case 7: 
      this.WFO.getSettings().setTextZoom(155);
      AppMethodBeat.o(296048);
      return;
    }
    this.WFO.getSettings().setTextZoom(165);
    AppMethodBeat.o(296048);
  }
  
  public final void b(String paramString, final float paramFloat, int paramInt)
  {
    AppMethodBeat.i(296000);
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      int i = Color.parseColor(paramString);
      this.WGl = true;
      this.WGm = (i | 0xFF000000);
      this.WFz.setActionBarColorValue(this.WGm);
      label45:
      this.WFz.setIconDark(paramInt);
      if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      {
        iuc();
        AppMethodBeat.o(296000);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78278);
          g.this.WFz.setAlpha(paramFloat);
          AppMethodBeat.o(78278);
        }
      });
      AppMethodBeat.o(296000);
      return;
    }
    catch (Exception paramString)
    {
      break label45;
    }
  }
  
  protected final void bjV(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.ejR.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject aoe()
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
  
  protected final boolean bjW(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.WGg.a(paramString, 5, this.WGx) == c.a.WPn)
    {
      AppMethodBeat.o(78320);
      return true;
    }
    AppMethodBeat.o(78320);
    return false;
  }
  
  protected final void c(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(78322);
    Log.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78322);
      return;
      if (!aGj(paramString))
      {
        this.WFU.setVisibility(0);
        fEC();
      }
    }
  }
  
  protected void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    Log.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(this.ItK)) {
      this.ItK = paramString2;
    }
    this.WGj = paramMap;
    if ((!aGj(paramString1)) && (!this.WGn) && (!this.WGr))
    {
      this.ejR.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        this.ejR.ejJ.loadUrl(paramString2, paramMap);
        AppMethodBeat.o(78321);
        return;
      }
      this.ejR.loadUrl(paramString2);
    }
    AppMethodBeat.o(78321);
  }
  
  public final void coZ()
  {
    AppMethodBeat.i(78297);
    this.WGm = androidx.core.content.a.w(getContext(), c.c.action_bar_color);
    this.WFz.WHj = -1;
    iuc();
    AppMethodBeat.o(78297);
  }
  
  protected void cxQ()
  {
    AppMethodBeat.i(78285);
    this.WFz.cxQ();
    AppMethodBeat.o(78285);
  }
  
  public final String dfU()
  {
    return this.ItK;
  }
  
  public final String dgY()
  {
    AppMethodBeat.i(78318);
    String str = this.ejT.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  protected boolean dhz()
  {
    AppMethodBeat.i(78325);
    if (!this.ejT.getBoolean("disable_minimize", false)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(78325);
      return bool;
    }
  }
  
  public final void eE(String paramString)
  {
    AppMethodBeat.i(296008);
    if (this.WFO != null) {
      this.WFO.evaluateJavascript(paramString, null);
    }
    AppMethodBeat.o(296008);
  }
  
  protected void eG(String paramString)
  {
    AppMethodBeat.i(78315);
    Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    fER();
    if (aGl(paramString))
    {
      int i = this.WGg.dJ(paramString, false);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.ejR.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.h(this.WFO);
    if (this.WGa != null)
    {
      this.WGa.fz("rawUrl", paramString);
      this.WGa.bjY(paramString);
    }
    if (this.WGc != null)
    {
      this.WGc.setUrl(Util.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WGc);
    }
    this.WFz.setOptionEnable(false);
    ehG();
    aGf(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void eH(String paramString)
  {
    AppMethodBeat.i(78316);
    Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.h(this.WFO);
    this.WFz.setOptionEnable(true);
    fEC();
    if (this.WGa != null)
    {
      this.WGa.fz("rawUrl", paramString);
      this.WGa.bjY(paramString);
    }
    if (this.WGc != null)
    {
      this.WGc.setUrl(Util.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WGc);
    }
    AppMethodBeat.o(78316);
  }
  
  protected void ehG()
  {
    AppMethodBeat.i(78310);
    this.WFV.setVisibility(0);
    this.WFV.start();
    AppMethodBeat.o(78310);
  }
  
  protected Boolean fEB()
  {
    return Boolean.FALSE;
  }
  
  protected void fEC()
  {
    AppMethodBeat.i(78311);
    this.WFV.finish();
    this.WFV.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  protected View fEP()
  {
    AppMethodBeat.i(78284);
    this.WFz = new n(this);
    n localn = this.WFz;
    AppMethodBeat.o(78284);
    return localn;
  }
  
  protected void fEQ()
  {
    AppMethodBeat.i(78294);
    if (!this.WGl)
    {
      this.WGm = this.ejT.getInt("customize_status_bar_color");
      if (this.WGm == 0) {
        this.WGm = androidx.core.content.a.w(getContext(), c.c.action_bar_color);
      }
    }
    iuc();
    AppMethodBeat.o(78294);
  }
  
  protected int fER()
  {
    AppMethodBeat.i(296045);
    int j = com.tencent.mm.plugin.webview.k.m.lg(getContext());
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= 8) {}
    }
    else
    {
      i = 2;
    }
    atq(i);
    AppMethodBeat.o(296045);
    return i;
  }
  
  public void fq(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.WGq) {
      this.WGa.ahU(paramString);
    }
    this.WGb.updateTitle(paramString);
    if (this.WGc != null)
    {
      this.WGc.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.WGc);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295902);
        if (g.this.WFz != null)
        {
          if (!Util.isNullOrNil(paramString)) {
            g.this.WFz.setTitleText(paramString);
          }
          if (paramInt != 0) {
            g.this.WFz.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(295902);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(369832);
    String str = this.WFz.getTitle();
    AppMethodBeat.o(369832);
    return str;
  }
  
  public final String getUrl()
  {
    if (this.ejR != null) {
      return this.ejR.mUrl;
    }
    return "";
  }
  
  public final void hideActionBar()
  {
    AppMethodBeat.i(78306);
    this.WFz.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  public final void iR(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if (this.WGa != null) {
      this.WGa.finish();
    }
    if ((this.WGa != null) && (this.WGa.zX(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if ((this.WGb != null) && (this.WGb.af(1, true)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.eje.aow().cH(paramBoolean))
      {
        this.eje.aoy().finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.s.D(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295906);
          g.this.iR(paramBoolean);
          AppMethodBeat.o(295906);
        }
      });
    }
    AppMethodBeat.o(78327);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(78303);
    boolean bool = this.ejT.getBoolean("show_full_screen", false);
    AppMethodBeat.o(78303);
    return bool;
  }
  
  public final void iua()
  {
    AppMethodBeat.i(78286);
    Log.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.ejT.getString("float_ball_key");
    if (!Util.isNullOrNil(str))
    {
      this.WGa.J(5, str);
      this.WGb.J(5, str);
    }
    for (;;)
    {
      this.WGa.fz("rawUrl", dgY());
      this.WGa.bjY(dgY());
      if (Util.isNullOrNil(this.WFz.getTitle())) {
        this.WGa.ahU(dgY());
      }
      this.WGq = true;
      if (this.WGp)
      {
        this.WGa.coi();
        this.WGb.coi();
      }
      this.WGc = new HandOffURL(Util.nullAsNil(dgY()), Util.nullAsNil(dgY()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).a(this.WGc);
      iub();
      AppMethodBeat.o(78286);
      return;
      this.WGa.J(5, com.tencent.mm.plugin.ball.f.b.ahX(dgY()));
      this.WGb.J(5, com.tencent.mm.plugin.multitask.g.aNM(((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiC(dgY())));
    }
  }
  
  public final void iub()
  {
    AppMethodBeat.i(295994);
    int i = this.ejT.getInt("screen_orientation", -1);
    if (this.eje.aov().peek() == this) {
      ((Activity)getContext()).setRequestedOrientation(i);
    }
    AppMethodBeat.o(295994);
  }
  
  protected final void iuc()
  {
    AppMethodBeat.i(78295);
    Log.d("MicroMsg.LuggageMMWebPage", "setActionBarColor");
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78277);
          g.this.iuc();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.WFz.s(this.WGm, this.WGu.WGL, this.WGu.WGM);
    AppMethodBeat.o(78295);
  }
  
  public final boolean iud()
  {
    AppMethodBeat.i(296003);
    boolean bool = this.WFT.isShown();
    AppMethodBeat.o(296003);
    return bool;
  }
  
  public final boolean iue()
  {
    AppMethodBeat.i(78304);
    if (this.WFz != null)
    {
      boolean bool = this.WFz.iue();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final n iuf()
  {
    return this.WFz;
  }
  
  public final void iug()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295880);
        g.this.WFP.setPullDownEnabled(false);
        AppMethodBeat.o(295880);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean iuh()
  {
    return this.WGk;
  }
  
  public final com.tencent.mm.plugin.webview.e.c iuj()
  {
    return this.WGg;
  }
  
  public final r.a iuk()
  {
    return this.WGi;
  }
  
  public final boolean iul()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.ejT.getBoolean("forceHideShare", false);
    boolean bool2 = this.ejT.getBoolean("showShare", true);
    Log.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(dhz()) });
    if ((!bool1) && (bool2) && (dhz()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final r ium()
  {
    return this.WGa;
  }
  
  public final u iun()
  {
    return this.WGb;
  }
  
  public final HandOffURL iuo()
  {
    return this.WGc;
  }
  
  public final void iup()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.eje.aov().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.eje.aow().remove(i))
      {
        this.eje.aoy().finish();
        AppMethodBeat.o(78326);
        return;
      }
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          com.tencent.luggage.d.h localh = (com.tencent.luggage.d.h)g.this.eje.aov().peek();
          if ((localh != null) && ((localh instanceof g))) {
            g.i((g)localh);
          }
          AppMethodBeat.o(78273);
        }
      }, 250L);
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.s.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295890);
        g.this.iup();
        AppMethodBeat.o(295890);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    Log.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.WGn) });
    this.ejR.mUrl = paramString;
    if (this.WGn)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.WFz.setOptionEnable(true);
      if (!Util.isNullOrNil(this.ejT.getString("title"))) {
        fq(this.ejT.getString("title"), 0);
      }
      this.sLf = false;
      if (this.WGg == null) {
        this.WGg = new com.tencent.mm.plugin.webview.e.c();
      }
      aGl(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    ehG();
    paramBundle = paramBundle.getString("game_open_html");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.WGr = true;
      this.WFO.loadDataWithBaseURL(paramString, paramBundle, "text/html", "utf-8", null);
    }
    do
    {
      for (;;)
      {
        aGl(paramString);
        this.sLf = false;
        AppMethodBeat.o(78313);
        return;
        if (!aGj(paramString)) {
          break;
        }
        aGm(paramString);
      }
    } while (this.sLf);
    l(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    Log.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.WGp = false;
    bjV("onPause");
    this.WFz.fEI();
    this.WFO.onPause();
    this.mIsForeground = false;
    if (this.WGa != null) {
      this.WGa.bhW();
    }
    if (this.WGb != null) {
      this.WGb.bhW();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.IxR)
    {
      this.IxR = true;
      Log.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.WFZ.WFG = null;
      k.c(this);
      this.mRootView.removeAllViews();
      this.ejR.setContext(MMApplicationContext.getContext());
      if (this.WGa != null) {
        this.WGa.onDestroy();
      }
      if (this.WGb != null)
      {
        if (!this.WGb.gjV()) {
          break label170;
        }
        s.a(this.WGb.bQs(), this.ejR, this.WGg);
      }
    }
    for (;;)
    {
      if (this.WGc != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).b(this.WGc);
      }
      this.WGg.WwD = true;
      this.WFz.onDestroy();
      if (this.WGt != null) {
        this.bYO.removeAccessibilityStateChangeListener(this.WGt);
      }
      AppMethodBeat.o(78289);
      return;
      label170:
      bjV("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.WGp)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.WGp = true;
    Log.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.WGo)
    {
      iR(false);
      AppMethodBeat.o(78287);
      return;
    }
    iub();
    wl(isFullScreen());
    fEQ();
    bjV("onResume");
    this.WFO.onResume();
    this.mIsForeground = true;
    atE(0);
    if (this.WGq)
    {
      this.WGa.coi();
      this.WGb.coi();
    }
    this.WFz.onForeground();
    AppMethodBeat.o(78287);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.WFO.reload();
    AppMethodBeat.o(78290);
  }
  
  protected void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.WFz.setVisibility(8);
      this.WFW.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.b.b(((Activity)getContext()).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.WFz.setVisibility(0);
    this.WFW.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.b.b(((Activity)getContext()).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  static final class a
  {
    boolean WGL;
    boolean WGM;
    boolean WGN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.g
 * JD-Core Version:    0.7.0.1
 */