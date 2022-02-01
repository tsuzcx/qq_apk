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
import com.tencent.f.i;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.l.a;
import com.tencent.luggage.d.s.a;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.f.c.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
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
  private static final Pattern ITJ;
  private static final Pattern ITK;
  protected m ISN;
  protected boolean ITA;
  protected int ITB;
  protected boolean ITC;
  public boolean ITD;
  private boolean ITE;
  private boolean ITF;
  private boolean ITG;
  public y ITH;
  private a ITI;
  private com.tencent.mm.plugin.webview.f.a<bhj> ITL;
  private s.a ITM;
  public com.tencent.mm.plugin.webview.luggage.webview_impl.a ITd;
  protected l ITe;
  protected b ITf;
  private WebViewKeyboardLinearLayout ITg;
  public WebViewInputFooter ITh;
  public WebViewSearchContentInputFooter ITi;
  private FrameLayout ITj;
  private MMFalseProgressBar ITk;
  protected MovingImageButton ITl;
  protected FrameLayout ITm;
  public FrameLayout ITn;
  protected s ITo;
  protected q ITp;
  protected t ITq;
  protected HandOffURL ITr;
  private WebChromeClient.CustomViewCallback ITs;
  private FrameLayout ITt;
  private ProgressBar ITu;
  protected com.tencent.mm.plugin.webview.f.c ITv;
  public w ITw;
  protected q.a ITx;
  protected Map<String, String> ITy;
  protected boolean ITz;
  private boolean mGR;
  private com.tencent.mm.plugin.webview.ui.tools.c mHI;
  public MMHandler mHandler;
  protected boolean mIsForeground;
  public FrameLayout mRootView;
  public int ppd;
  public int ppe;
  protected String xwe;
  protected boolean xzH;
  
  static
  {
    AppMethodBeat.i(78330);
    ITJ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    ITK = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public g(com.tencent.luggage.d.j paramj, com.tencent.luggage.d.p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(78282);
    this.mGR = true;
    this.ITz = false;
    this.mIsForeground = false;
    this.xzH = false;
    this.ITD = false;
    this.ITE = false;
    this.ITF = false;
    this.ITG = false;
    this.ppd = 0;
    this.ppe = 0;
    this.ITH = new y();
    this.ITL = new com.tencent.mm.plugin.webview.f.a()
    {
      public final void C(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(210899);
        g.this.ITz = false;
        g.this.aC(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210896);
            g localg = g.this;
            String str = paramAnonymousString2;
            localg.ctS.ctK.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(210896);
          }
        });
        AppMethodBeat.o(210899);
      }
      
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(210900);
        g.this.ITz = false;
        g.this.aC(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210897);
            g.this.b(paramAnonymousInt1, paramAnonymousString1, paramAnonymousInt2, paramAnonymousInt3);
            AppMethodBeat.o(210897);
          }
        });
        AppMethodBeat.o(210900);
      }
      
      public final void bx(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void by(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(210898);
        g.this.azO(paramAnonymousString);
        AppMethodBeat.o(210898);
      }
    };
    this.ITM = new s.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(210904);
        if (com.tencent.mm.cr.d.kS(g.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            Log.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            g.this.aYr(paramAnonymousWebResourceRequest.getUrl().toString());
          }
        }
        catch (Exception paramAnonymousBundle)
        {
          for (;;)
          {
            Log.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", new Object[] { paramAnonymousBundle.getMessage() });
          }
        }
        catch (Throwable paramAnonymousBundle)
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
          paramAnonymousWebResourceRequest = g.this.azN(paramAnonymousWebResourceRequest);
          AppMethodBeat.o(210904);
          return paramAnonymousWebResourceRequest;
        }
      }
      
      public final void a(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(210902);
        g.this.cV(paramAnonymousString);
        AppMethodBeat.o(210902);
      }
      
      public final void b(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(210903);
        g.this.cW(paramAnonymousString);
        AppMethodBeat.o(210903);
      }
    };
    if (paramp != null)
    {
      this.ITC = true;
      this.ITv = com.tencent.mm.plugin.webview.f.e.agf(paramp.hashCode());
    }
    if (this.ITv == null) {}
    for (;;)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.ITv == null) {
        this.ITv = new com.tencent.mm.plugin.webview.f.c();
      }
      this.mHandler = new MMHandler();
      this.ITw = new w(this);
      this.ITx = new q.a(this, this.ITv);
      this.ctS.ctB = this.ITx;
      this.ITo = new s(this);
      this.ITp = new q(new d(this), this);
      this.ITq = new t(this, new u(this));
      j.b(this);
      if (this.ITd != null)
      {
        this.ITd.setPage(this);
        this.ITd.setWebViewClient(new ac()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(210887);
            Log.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            g.this.D(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(210887);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.r paramAnonymousr, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(210888);
            if (g.e(g.this) == null) {
              g.a(g.this, new com.tencent.mm.plugin.webview.ui.tools.c(g.this.mContext, paramAnonymousWebView));
            }
            g.e(g.this).a(g.this.getUrl(), paramAnonymousr, paramAnonymousSslError);
            AppMethodBeat.o(210888);
          }
        });
        this.ITd.setWebChromeClient(new x()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            int i = 1;
            AppMethodBeat.i(210889);
            Log.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.b.afC(paramAnonymousString)) {
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equalsIgnoreCase("about:blank"))) {
                break label74;
              }
            }
            for (;;)
            {
              if (i == 0) {
                g.this.ec(paramAnonymousString, 0);
              }
              g.this.ctS.LI();
              AppMethodBeat.o(210889);
              return;
              label74:
              i = 0;
            }
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(210892);
            Log.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (g.h(g.this) == null)
            {
              g.a(g.this, new ProgressBar(g.this.mContext));
              g.h(g.this).setIndeterminate(true);
            }
            ProgressBar localProgressBar = g.h(g.this);
            AppMethodBeat.o(210892);
            return localProgressBar;
          }
          
          public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            return false;
          }
          
          public final void onHideCustomView()
          {
            AppMethodBeat.i(210891);
            Log.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (g.f(g.this) == null)
            {
              AppMethodBeat.o(210891);
              return;
            }
            try
            {
              g.this.ITe.setVisibility(0);
              if (g.g(g.this) != null) {
                g.g(g.this).onCustomViewHidden();
              }
              g.this.ISN.setVisibility(0);
              if (g.f(g.this) != null) {
                g.this.mRootView.removeView(g.f(g.this));
              }
              g.f(g.this).removeAllViews();
              g.a(g.this, null);
              AppMethodBeat.o(210891);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(210891);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(210890);
            Log.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
            try
            {
              if (g.f(g.this) != null)
              {
                paramAnonymousCustomViewCallback.onCustomViewHidden();
                AppMethodBeat.o(210890);
                return;
              }
              g.a(g.this, new FrameLayout(g.this.mContext));
              g.f(g.this).setBackgroundResource(2131101408);
              g.f(g.this).addView(paramAnonymousView);
              g.a(g.this, paramAnonymousCustomViewCallback);
              g.this.ITe.setVisibility(8);
              g.this.ISN.setVisibility(8);
              g.this.mRootView.addView(g.f(g.this));
              AppMethodBeat.o(210890);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(210890);
            }
          }
        });
      }
      a(this.ITM);
      paramj = this.ctf;
      paramp = new l.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (g.this.gbB())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.ITq != null) && (g.this.ITq.O(1, true)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.ITp != null) && (g.this.ITp.wu(2)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          AppMethodBeat.o(78236);
          return false;
        }
      };
      paramj.ctz.put(paramp, Boolean.FALSE);
      AppMethodBeat.o(78282);
      return;
      bool = false;
    }
  }
  
  private void afX(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ITi.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.ITi.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.ITi.isShown()) {
      i = paramInt + this.ITi.getHeight();
    }
    this.ITe.setPadding(this.ITe.getPaddingLeft(), this.ITe.getPaddingTop(), this.ITe.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  protected void D(int paramInt, String paramString1, String paramString2) {}
  
  public String LJ()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.ac.d.afA("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public View Lf()
  {
    AppMethodBeat.i(78283);
    Object localObject = coX();
    this.ITI = new a((byte)0);
    localObject = Uri.parse((String)localObject);
    if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersiveUIStyle")).equals("1")) {
      this.ITI.ITX = true;
    }
    if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersivePageBgIsDark")).equals("1"))
    {
      this.ITI.ITY = true;
      if (Util.nullAsNil(((Uri)localObject).getQueryParameter("hide_share_option")).equals("1")) {
        this.ITI.ITZ = true;
      }
      this.ITd = ((com.tencent.mm.plugin.webview.luggage.webview_impl.a)this.ctS.LG());
      this.ITe = new l(this.mContext, super.Lf());
      this.ITd.setCompetitorView(this.ITe);
      this.ITd.setSource(this.mParams.getString("KPublisherId"));
      this.mRootView = new FrameLayout(this.mContext);
      this.ITf = new b(this.mContext);
      this.ITf.setBackgroundColor(android.support.v4.content.b.n(this.mContext, 2131101424));
      this.mRootView.addView(this.ITf, new FrameLayout.LayoutParams(-1, -1));
      localObject = aa.jQ(this.mContext).inflate(2131495398, this.ITf, false);
      dTM();
      if (!dTB().booleanValue()) {
        break label671;
      }
      this.ITf.addView((View)localObject);
    }
    for (;;)
    {
      if (this.ITI.ITZ) {
        this.ISN.zd(true);
      }
      this.ITf.setActionBar(this.ISN);
      this.ITf.setWebView(this.ITd);
      this.ITm = ((FrameLayout)((View)localObject).findViewById(2131299174));
      this.ITk = ((MMFalseProgressBar)((View)localObject).findViewById(2131310370));
      this.ITl = ((MovingImageButton)((View)localObject).findViewById(2131301834));
      this.ITl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78257);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          g.this.dTH();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78257);
        }
      });
      this.ITg = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(2131302102));
      this.ITn = ((FrameLayout)((View)localObject).findViewById(2131310369));
      this.ITn.addView(this.ITe, new ViewGroup.LayoutParams(-1, -1));
      this.ITh = ((WebViewInputFooter)((View)localObject).findViewById(2131310389));
      this.ITh.hide();
      this.ITh.setOnTextSendListener(new WebViewInputFooter.c()
      {
        public final void gbU()
        {
          AppMethodBeat.i(210908);
          g.gbM();
          if (g.b(g.this) != null) {
            g.b(g.this).hide();
          }
          AppMethodBeat.o(210908);
        }
      });
      this.ITh.setOnSmileyChosenListener(new WebViewInputFooter.a()
      {
        public final boolean afZ(final String paramAnonymousString)
        {
          AppMethodBeat.i(210874);
          g.this.ctS.a(new com.tencent.luggage.d.d()
          {
            public final JSONObject Ld()
            {
              AppMethodBeat.i(210873);
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("smiley", paramAnonymousString);
                label24:
                AppMethodBeat.o(210873);
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
          AppMethodBeat.o(210874);
          return true;
        }
      });
      this.ITh.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
      {
        public final void gbP()
        {
          AppMethodBeat.i(210875);
          g.this.afW(0);
          AppMethodBeat.o(210875);
        }
        
        public final void gbQ()
        {
          AppMethodBeat.i(210876);
          if ((g.c(g.this) != null) && (g.c(g.this).getKeyBoardHeight() > 0)) {
            g.this.afW(g.c(g.this).getKeyBoardHeight());
          }
          AppMethodBeat.o(210876);
        }
      });
      this.ITi = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(2131307373));
      this.ITi.setActionDelegate(new WebViewSearchContentInputFooter.a()
      {
        public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(210878);
          if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
            b(paramAnonymousWebViewSearchContentInputFooter);
          }
          AppMethodBeat.o(210878);
        }
        
        public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(210881);
          g.this.ITd.clearMatches();
          paramAnonymousWebViewSearchContentInputFooter.reset();
          g.d(g.this).H(0, 0, true);
          g.this.ITd.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
          AppMethodBeat.o(210881);
        }
        
        public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return false;
        }
        
        public final void gbR()
        {
          AppMethodBeat.i(210877);
          g.a(g.this, 0);
          g.this.ITd.clearMatches();
          g.d(g.this).giD();
          AppMethodBeat.o(210877);
        }
        
        public final void gbS()
        {
          AppMethodBeat.i(210879);
          g.this.ITd.findNext(false);
          AppMethodBeat.o(210879);
        }
        
        public final void gbT()
        {
          AppMethodBeat.i(210880);
          g.this.ITd.findNext(true);
          AppMethodBeat.o(210880);
        }
      });
      this.ITd.setFindListener(new WebView.FindListener()
      {
        public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(210882);
          g.d(g.this).H(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          AppMethodBeat.o(210882);
        }
      });
      this.ITj = ((FrameLayout)((View)localObject).findViewById(2131306778));
      if (this.ITj != null) {
        this.ITj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(78274);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            g.this.ctS.loadUrl(g.this.getUrl());
            g.a(g.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(78274);
          }
        });
      }
      this.ITg.setOnkbdStateListener(new KeyboardLinearLayout.a()
      {
        public final void Ns(int paramAnonymousInt)
        {
          AppMethodBeat.i(210883);
          Log.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
          if (!g.this.mIsForeground)
          {
            Log.i("MicroMsg.LuggageMMWebPage", "background ignored");
            AppMethodBeat.o(210883);
            return;
          }
          g.a(g.this, g.c(g.this), paramAnonymousInt);
          if (paramAnonymousInt == -3)
          {
            if ((g.b(g.this) != null) && (g.b(g.this).getVisibility() == 0))
            {
              WebViewInputFooter localWebViewInputFooter = g.b(g.this);
              if (localWebViewInputFooter.JAQ) {
                localWebViewInputFooter.setVisibility(8);
              }
              localWebViewInputFooter.state = 0;
              localWebViewInputFooter.cbM();
            }
            g.a(g.this, g.c(g.this).getKeyBoardHeight());
            AppMethodBeat.o(210883);
            return;
          }
          g.a(g.this, 0);
          AppMethodBeat.o(210883);
        }
      });
      this.ITd.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78275);
          if (g.b(g.this).isShown()) {
            g.b(g.this).hide();
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            g.this.ppd = ((int)paramAnonymousMotionEvent.getRawX());
            g.this.ppe = ((int)paramAnonymousMotionEvent.getRawY());
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
        if (ao.isDarkMode())
        {
          this.ITI.ITY = true;
          break;
        }
        this.ITI.ITY = false;
        break;
      }
      this.ITI.ITY = false;
      break;
      label671:
      b localb = this.ITf;
      m localm = this.ISN;
      boolean bool = this.ITI.ITX;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(10);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
      if (bool)
      {
        localLayoutParams2.addRule(10);
        localb.addView((View)localObject, localLayoutParams2);
        localb.addView(localm, localLayoutParams1);
      }
      else
      {
        localb.addView(localm, localLayoutParams1);
        localLayoutParams2.addRule(3, localm.getId());
        localb.addView((View)localObject, localLayoutParams2);
      }
    }
  }
  
  public boolean Oc(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.ITv.gs(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  public final void aC(Runnable paramRunnable)
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
  
  protected final void aYq(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.ctS.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject Ld()
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
  
  protected final boolean aYr(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.ITv.a(paramString, 5, this.ITL) == c.a.Jcb)
    {
      AppMethodBeat.o(78320);
      return true;
    }
    AppMethodBeat.o(78320);
    return false;
  }
  
  public final void afW(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.ITh.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.ITh.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  protected void azH(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.ITd.getX5WebViewExtension() != null)
    {
      this.ITe.setPullDownEnabled(true);
      this.ITe.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean azJ(String paramString)
  {
    return false;
  }
  
  protected boolean azL(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.ITv.aZI(paramString))
    {
      this.ITz = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.ITv.a(paramString, this.ITL) == c.a.Jcb) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.ITz = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected void azM(String paramString)
  {
    AppMethodBeat.i(78314);
    Log.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.ITd.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  protected WebResourceResponse azN(String paramString)
  {
    return null;
  }
  
  protected void azO(String paramString) {}
  
  protected final void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
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
      if (!azJ(paramString))
      {
        this.ITj.setVisibility(0);
        dTO();
      }
    }
  }
  
  public final void bDo()
  {
    AppMethodBeat.i(78297);
    this.ITB = android.support.v4.content.b.n(this.mContext, 2131099891);
    this.ISN.IUv = -1;
    gbA();
    AppMethodBeat.o(78297);
  }
  
  public final void c(String paramString, final float paramFloat, int paramInt)
  {
    AppMethodBeat.i(210910);
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      int i = Color.parseColor(paramString);
      this.ITA = true;
      this.ITB = (i | 0xFF000000);
      this.ISN.setActionBarColorValue(this.ITB);
      label45:
      this.ISN.setIconDark(paramInt);
      if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      {
        gbA();
        AppMethodBeat.o(210910);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78278);
          g.this.ISN.setAlpha(paramFloat);
          AppMethodBeat.o(78278);
        }
      });
      AppMethodBeat.o(210910);
      return;
    }
    catch (Exception paramString)
    {
      break label45;
    }
  }
  
  protected void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    Log.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(this.xwe)) {
      this.xwe = paramString2;
    }
    this.ITy = paramMap;
    if ((!azJ(paramString1)) && (!this.ITC) && (!this.ITG))
    {
      this.ctS.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        this.ctS.ctK.loadUrl(paramString2, paramMap);
        AppMethodBeat.o(78321);
        return;
      }
      this.ctS.loadUrl(paramString2);
    }
    AppMethodBeat.o(78321);
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(210912);
    if (this.ITd != null) {
      this.ITd.evaluateJavascript(paramString, null);
    }
    AppMethodBeat.o(210912);
  }
  
  protected void cV(String paramString)
  {
    AppMethodBeat.i(78315);
    Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    if (azL(paramString))
    {
      int i = this.ITv.cO(paramString, false);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.ctS.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.e(this.ITd);
    if (this.ITp != null)
    {
      this.ITp.eU("rawUrl", paramString);
      this.ITp.aYt(paramString);
    }
    if (this.ITr != null)
    {
      this.ITr.setUrl(Util.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ITr);
    }
    this.ISN.setOptionEnable(false);
    dTA();
    azH(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void cW(String paramString)
  {
    AppMethodBeat.i(78316);
    Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.e(this.ITd);
    this.ISN.setOptionEnable(true);
    dTO();
    if (this.ITp != null)
    {
      this.ITp.eU("rawUrl", paramString);
      this.ITp.aYt(paramString);
    }
    if (this.ITr != null)
    {
      this.ITr.setUrl(Util.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ITr);
    }
    AppMethodBeat.o(78316);
  }
  
  public final String coX()
  {
    AppMethodBeat.i(78318);
    String str = this.mParams.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  public final String coy()
  {
    return this.xwe;
  }
  
  protected boolean cpz()
  {
    AppMethodBeat.i(78325);
    if (!this.mParams.getBoolean("disable_minimize", false)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(78325);
      return bool;
    }
  }
  
  protected void dTA()
  {
    AppMethodBeat.i(78310);
    this.ITk.setVisibility(0);
    this.ITk.start();
    AppMethodBeat.o(78310);
  }
  
  protected Boolean dTB()
  {
    return Boolean.FALSE;
  }
  
  protected void dTH()
  {
    AppMethodBeat.i(78285);
    this.ISN.dTH();
    AppMethodBeat.o(78285);
  }
  
  protected View dTM()
  {
    AppMethodBeat.i(78284);
    this.ISN = new m(this);
    m localm = this.ISN;
    AppMethodBeat.o(78284);
    return localm;
  }
  
  protected void dTN()
  {
    AppMethodBeat.i(78294);
    if (!this.ITA)
    {
      this.ITB = this.mParams.getInt("customize_status_bar_color");
      if (this.ITB == 0) {
        this.ITB = android.support.v4.content.b.n(this.mContext, 2131099891);
      }
    }
    gbA();
    AppMethodBeat.o(78294);
  }
  
  protected void dTO()
  {
    AppMethodBeat.i(78311);
    this.ITk.finish();
    this.ITk.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  public void ec(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.ITF) {
      this.ITp.agT(paramString);
    }
    this.ITq.aCM(paramString);
    if (this.ITr != null)
    {
      this.ITr.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ITr);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210907);
        if (g.this.ISN != null)
        {
          if (!Util.isNullOrNil(paramString)) {
            g.this.ISN.setTitleText(paramString);
          }
          if (paramInt != 0) {
            g.this.ISN.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(210907);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  public final void ega()
  {
    AppMethodBeat.i(78306);
    this.ISN.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    Log.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.ITC) });
    this.ctS.mUrl = paramString;
    if (this.ITC)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.ISN.setOptionEnable(true);
      if (!Util.isNullOrNil(this.mParams.getString("title"))) {
        ec(this.mParams.getString("title"), 0);
      }
      this.mGR = false;
      if (this.ITv == null) {
        this.ITv = new com.tencent.mm.plugin.webview.f.c();
      }
      azL(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    dTA();
    paramBundle = paramBundle.getString("game_open_html");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.ITG = true;
      this.ITd.loadDataWithBaseURL(paramString, paramBundle, "text/html", "utf-8", null);
    }
    do
    {
      for (;;)
      {
        azL(paramString);
        this.mGR = false;
        AppMethodBeat.o(78313);
        return;
        if (!azJ(paramString)) {
          break;
        }
        azM(paramString);
      }
    } while (this.mGR);
    g(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  protected final void gbA()
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
          g.this.gbA();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.ISN.k(this.ITB, this.ITI.ITX, this.ITI.ITY);
    AppMethodBeat.o(78295);
  }
  
  public final boolean gbB()
  {
    AppMethodBeat.i(78304);
    if (this.ISN != null)
    {
      boolean bool = this.ISN.gbB();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final m gbC()
  {
    return this.ISN;
  }
  
  public final void gbD()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210894);
        g.this.ITe.setPullDownEnabled(false);
        AppMethodBeat.o(210894);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean gbE()
  {
    return this.ITz;
  }
  
  public final com.tencent.mm.plugin.webview.f.c gbF()
  {
    return this.ITv;
  }
  
  public final q.a gbG()
  {
    return this.ITx;
  }
  
  public final boolean gbH()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.mParams.getBoolean("forceHideShare", false);
    boolean bool2 = this.mParams.getBoolean("showShare", true);
    Log.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(cpz()) });
    if ((!bool1) && (bool2) && (cpz()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final q gbI()
  {
    return this.ITp;
  }
  
  public final t gbJ()
  {
    return this.ITq;
  }
  
  public final HandOffURL gbK()
  {
    return this.ITr;
  }
  
  public final void gbL()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.ctg.Lx().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.ctg.Ly().remove(i))
      {
        this.ctg.LA().finish();
        AppMethodBeat.o(78326);
        return;
      }
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          com.tencent.luggage.d.h localh = (com.tencent.luggage.d.h)g.this.ctg.Lx().peek();
          if ((localh != null) && ((localh instanceof g))) {
            g.i((g)localh);
          }
          AppMethodBeat.o(78273);
        }
      }, 250L);
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.p.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210905);
        g.this.gbL();
        AppMethodBeat.o(210905);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public final void gby()
  {
    AppMethodBeat.i(78286);
    Log.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.mParams.getString("float_ball_key");
    if (!Util.isNullOrNil(str))
    {
      this.ITp.G(5, str);
      this.ITq.G(5, str);
    }
    for (;;)
    {
      this.ITp.eU("rawUrl", coX());
      this.ITp.aYt(coX());
      if (Util.isNullOrNil(this.ISN.getTitle())) {
        this.ITp.agT(coX());
      }
      this.ITF = true;
      if (this.ITE)
      {
        this.ITp.bCA();
        this.ITq.bCA();
      }
      this.ITr = new HandOffURL(Util.nullAsNil(coX()), Util.nullAsNil(coX()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(this.ITr);
      gbz();
      AppMethodBeat.o(78286);
      return;
      this.ITp.G(5, com.tencent.mm.plugin.ball.f.b.bxa(coX()));
      this.ITq.G(5, com.tencent.mm.plugin.multitask.g.aGG(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(coX())));
    }
  }
  
  public final void gbz()
  {
    AppMethodBeat.i(210909);
    int i = this.mParams.getInt("screen_orientation", -1);
    if (this.ctg.Lx().peek() == this) {
      ((Activity)this.mContext).setRequestedOrientation(i);
    }
    AppMethodBeat.o(210909);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(258616);
    String str = this.ISN.getTitle();
    AppMethodBeat.o(258616);
    return str;
  }
  
  public final String getUrl()
  {
    if (this.ctS != null) {
      return this.ctS.mUrl;
    }
    return "";
  }
  
  public final void hb(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if ((this.ITp != null) && (this.ITp.wu(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if ((this.ITq != null) && (this.ITq.O(1, true)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.ctg.Ly().bR(paramBoolean))
      {
        this.ctg.LA().finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.p.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210906);
          g.this.hb(paramBoolean);
          AppMethodBeat.o(210906);
        }
      });
    }
    AppMethodBeat.o(78327);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(78303);
    boolean bool = this.mParams.getBoolean("show_full_screen", false);
    AppMethodBeat.o(78303);
    return bool;
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    Log.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.ITE = false;
    aYq("onPause");
    this.ISN.dTI();
    this.ITd.onPause();
    this.mIsForeground = false;
    if (this.ITp != null) {
      this.ITp.aGj();
    }
    if (this.ITq != null) {
      this.ITq.aGj();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.xzH)
    {
      this.xzH = true;
      Log.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.ITo.ISU = null;
      j.c(this);
      this.mRootView.removeAllViews();
      this.ctS.setContext(MMApplicationContext.getContext());
      if (this.ITp != null) {
        this.ITp.onDestroy();
      }
      if (this.ITq != null)
      {
        if (!this.ITq.eqW()) {
          break label151;
        }
        r.a(this.ITq.bjl(), this.ctS, this.ITv);
      }
    }
    for (;;)
    {
      if (this.ITr != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).b(this.ITr);
      }
      this.ITv.IJS = true;
      this.ISN.onDestroy();
      AppMethodBeat.o(78289);
      return;
      label151:
      aYq("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.ITE)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.ITE = true;
    Log.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.ITD)
    {
      hb(false);
      AppMethodBeat.o(78287);
      return;
    }
    gbz();
    pJ(isFullScreen());
    dTN();
    aYq("onResume");
    this.ITd.onResume();
    this.mIsForeground = true;
    afX(0);
    if (this.ITF)
    {
      this.ITp.bCA();
      this.ITq.bCA();
    }
    this.ISN.onForeground();
    AppMethodBeat.o(78287);
  }
  
  protected void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.ISN.setVisibility(8);
      this.ITl.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.a.c(((Activity)this.mContext).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.ISN.setVisibility(0);
    this.ITl.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.a.c(((Activity)this.mContext).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.ITd.reload();
    AppMethodBeat.o(78290);
  }
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(210911);
    if (!paramBoolean)
    {
      this.ITi.hide();
      AppMethodBeat.o(210911);
      return;
    }
    if (!this.ITi.isShown())
    {
      this.ITi.reset();
      this.ITi.giD();
      this.ITi.show();
    }
    AppMethodBeat.o(210911);
  }
  
  static final class a
  {
    boolean ITX;
    boolean ITY;
    boolean ITZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.g
 * JD-Core Version:    0.7.0.1
 */