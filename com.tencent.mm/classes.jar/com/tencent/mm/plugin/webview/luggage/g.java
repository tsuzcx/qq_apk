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
import com.tencent.e.i;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.l.a;
import com.tencent.luggage.d.s.a;
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
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
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
  private static final Pattern EgZ;
  private static final Pattern Eha;
  private MMFalseProgressBar EgA;
  protected MovingImageButton EgB;
  protected FrameLayout EgC;
  public FrameLayout EgD;
  protected s EgE;
  protected q EgF;
  protected HandOffURL EgG;
  private WebChromeClient.CustomViewCallback EgH;
  private FrameLayout EgI;
  private ProgressBar EgJ;
  protected com.tencent.mm.plugin.webview.e.c EgK;
  public u EgL;
  protected q.a EgM;
  protected Map<String, String> EgN;
  protected boolean EgO;
  protected boolean EgP;
  protected int EgQ;
  protected boolean EgR;
  private boolean EgS;
  public boolean EgT;
  private boolean EgU;
  private boolean EgV;
  private boolean EgW;
  public w EgX;
  private a EgY;
  protected m Ege;
  protected com.tencent.mm.plugin.webview.luggage.d.a Egt;
  protected l Egu;
  protected b Egv;
  private WebViewKeyboardLinearLayout Egw;
  public WebViewInputFooter Egx;
  public WebViewSearchContentInputFooter Egy;
  private FrameLayout Egz;
  private com.tencent.mm.plugin.webview.e.a<avz> Ehb;
  private com.tencent.mm.plugin.webview.ui.tools.c lAu;
  private boolean lzD;
  public aq mHandler;
  public FrameLayout mRootView;
  public int oef;
  public int oeg;
  private s.a puL;
  protected String uee;
  protected boolean uhn;
  
  static
  {
    AppMethodBeat.i(78330);
    EgZ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    Eha = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public g(com.tencent.luggage.d.j paramj, com.tencent.luggage.d.p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(78282);
    this.lzD = true;
    this.EgO = false;
    this.uhn = false;
    this.EgT = false;
    this.EgU = false;
    this.EgV = false;
    this.EgW = false;
    this.oef = 0;
    this.oeg = 0;
    this.EgX = new w();
    this.Ehb = new com.tencent.mm.plugin.webview.e.a()
    {
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(198044);
        g.this.EgO = false;
        g.this.as(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198041);
            g.this.b(paramAnonymousInt1, paramAnonymousString1, paramAnonymousInt2, paramAnonymousInt3);
            AppMethodBeat.o(198041);
          }
        });
        AppMethodBeat.o(198044);
      }
      
      public final void bl(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void bm(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(198042);
        g.this.amz(paramAnonymousString);
        AppMethodBeat.o(198042);
      }
      
      public final void z(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(198043);
        g.this.EgO = false;
        g.this.as(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198040);
            g localg = g.this;
            String str = paramAnonymousString2;
            localg.chX.chP.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(198040);
          }
        });
        AppMethodBeat.o(198043);
      }
    };
    this.puL = new s.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(198048);
        if (com.tencent.mm.cp.d.kW(g.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            ae.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            g.this.aIo(paramAnonymousWebResourceRequest.getUrl().toString());
          }
        }
        catch (Exception paramAnonymousBundle)
        {
          for (;;)
          {
            ae.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", new Object[] { paramAnonymousBundle.getMessage() });
          }
        }
        catch (Throwable paramAnonymousBundle)
        {
          for (;;)
          {
            ae.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", new Object[] { paramAnonymousBundle.getMessage() });
            continue;
            paramAnonymousWebResourceRequest = "";
          }
        }
        if (paramAnonymousWebResourceRequest != null)
        {
          paramAnonymousWebResourceRequest = paramAnonymousWebResourceRequest.getUrl().toString();
          paramAnonymousWebResourceRequest = g.this.amy(paramAnonymousWebResourceRequest);
          AppMethodBeat.o(198048);
          return paramAnonymousWebResourceRequest;
        }
      }
      
      public final void a(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(198046);
        g.this.cE(paramAnonymousString);
        AppMethodBeat.o(198046);
      }
      
      public final void b(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(198047);
        g.this.cF(paramAnonymousString);
        AppMethodBeat.o(198047);
      }
    };
    if (paramp != null)
    {
      this.EgR = true;
      this.EgK = com.tencent.mm.plugin.webview.e.e.Xx(paramp.hashCode());
    }
    if (this.EgK == null) {}
    for (;;)
    {
      ae.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.EgK == null) {
        this.EgK = new com.tencent.mm.plugin.webview.e.c();
      }
      this.mHandler = new aq();
      this.EgL = new u(this);
      this.EgM = new q.a(this, this.EgK);
      this.chX.chG = this.EgM;
      this.EgE = new s(this);
      this.EgF = new q(new d(this), this);
      j.b(this);
      if (this.Egt != null)
      {
        this.Egt.setPage(this);
        this.Egt.setWebViewClient(new ac()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(198031);
            ae.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            g.this.A(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(198031);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.r paramAnonymousr, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(198032);
            if (g.f(g.this) == null) {
              g.a(g.this, new com.tencent.mm.plugin.webview.ui.tools.c(g.this.mContext, paramAnonymousWebView));
            }
            g.f(g.this).a(g.this.getUrl(), paramAnonymousr, paramAnonymousSslError);
            AppMethodBeat.o(198032);
          }
        });
        this.Egt.setWebChromeClient(new x()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            int i = 1;
            AppMethodBeat.i(198033);
            ae.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.b.VG(paramAnonymousString)) {
              if ((bu.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equalsIgnoreCase("about:blank"))) {
                break label74;
              }
            }
            for (;;)
            {
              if (i == 0) {
                g.this.dN(paramAnonymousString, 0);
              }
              g.this.chX.Cr();
              AppMethodBeat.o(198033);
              return;
              label74:
              i = 0;
            }
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(198036);
            ae.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (g.i(g.this) == null)
            {
              g.a(g.this, new ProgressBar(g.this.mContext));
              g.i(g.this).setIndeterminate(true);
            }
            ProgressBar localProgressBar = g.i(g.this);
            AppMethodBeat.o(198036);
            return localProgressBar;
          }
          
          public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            return false;
          }
          
          public final void onHideCustomView()
          {
            AppMethodBeat.i(198035);
            ae.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (g.g(g.this) == null)
            {
              AppMethodBeat.o(198035);
              return;
            }
            try
            {
              g.this.Egu.setVisibility(0);
              if (g.h(g.this) != null) {
                g.h(g.this).onCustomViewHidden();
              }
              g.this.Ege.setVisibility(0);
              if (g.g(g.this) != null) {
                g.this.mRootView.removeView(g.g(g.this));
              }
              g.g(g.this).removeAllViews();
              g.a(g.this, null);
              AppMethodBeat.o(198035);
              return;
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(198035);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(198034);
            ae.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
            try
            {
              if (g.g(g.this) != null)
              {
                paramAnonymousCustomViewCallback.onCustomViewHidden();
                AppMethodBeat.o(198034);
                return;
              }
              g.a(g.this, new FrameLayout(g.this.mContext));
              g.g(g.this).setBackgroundResource(2131101165);
              g.g(g.this).addView(paramAnonymousView);
              g.a(g.this, paramAnonymousCustomViewCallback);
              g.this.Egu.setVisibility(8);
              g.this.Ege.setVisibility(8);
              g.this.mRootView.addView(g.g(g.this));
              AppMethodBeat.o(198034);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ae.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(198034);
            }
          }
        });
      }
      a(this.puL);
      paramj = this.chl;
      paramp = new l.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (g.this.eSP())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.EgF != null) && (g.this.EgF.sy(2)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          AppMethodBeat.o(78236);
          return false;
        }
      };
      paramj.chE.put(paramp, Boolean.FALSE);
      AppMethodBeat.o(78282);
      return;
      bool = false;
    }
  }
  
  private void Xo(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Egy.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.Egy.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.Egy.isShown()) {
      i = paramInt + this.Egy.getHeight();
    }
    this.Egu.setPadding(this.Egu.getPaddingLeft(), this.Egu.getPaddingTop(), this.Egu.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  protected void A(int paramInt, String paramString1, String paramString2) {}
  
  public View BR()
  {
    AppMethodBeat.i(78283);
    Object localObject = bRn();
    this.EgY = new a((byte)0);
    localObject = Uri.parse((String)localObject);
    if (bu.nullAsNil(((Uri)localObject).getQueryParameter("immersiveUIStyle")).equals("1")) {
      this.EgY.Ehm = true;
    }
    if (bu.nullAsNil(((Uri)localObject).getQueryParameter("immersivePageBgIsDark")).equals("1")) {
      this.EgY.Ehn = true;
    }
    this.Egt = ((com.tencent.mm.plugin.webview.luggage.d.a)this.chX.Cp());
    this.Egu = new l(this.mContext, super.BR());
    this.Egt.setCompetitorView(this.Egu);
    this.Egt.setSource(this.mParams.getString("KPublisherId"));
    this.mRootView = new FrameLayout(this.mContext);
    this.Egv = new b(this.mContext);
    this.Egv.setBackgroundColor(android.support.v4.content.b.n(this.mContext, 2131101179));
    this.mRootView.addView(this.Egv, new FrameLayout.LayoutParams(-1, -1));
    localObject = com.tencent.mm.ui.z.jV(this.mContext).inflate(2131494673, this.Egv, false);
    b localb = this.Egv;
    View localView = dad();
    boolean bool = this.EgY.Ehm;
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.addRule(10);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    if (bool)
    {
      localLayoutParams2.addRule(10);
      localb.addView((View)localObject, localLayoutParams2);
      localb.addView(localView, localLayoutParams1);
    }
    for (;;)
    {
      this.Egv.setActionBar(this.Ege);
      this.Egv.setWebView(this.Egt);
      this.EgC = ((FrameLayout)((View)localObject).findViewById(2131298736));
      this.EgA = ((MMFalseProgressBar)((View)localObject).findViewById(2131306899));
      this.EgB = ((MovingImageButton)((View)localObject).findViewById(2131300327));
      this.EgB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78257);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          g.this.cZZ();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78257);
        }
      });
      this.Egw = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(2131300570));
      this.EgD = ((FrameLayout)((View)localObject).findViewById(2131306898));
      this.EgD.addView(this.Egu, new ViewGroup.LayoutParams(-1, -1));
      this.Egx = ((WebViewInputFooter)((View)localObject).findViewById(2131306916));
      this.Egx.hide();
      this.Egx.setOnTextSendListener(new WebViewInputFooter.c()
      {
        public final void aIp(String paramAnonymousString)
        {
          AppMethodBeat.i(198052);
          g.eTa();
          if (g.b(g.this) != null) {
            g.b(g.this).hide();
          }
          AppMethodBeat.o(198052);
        }
      });
      this.Egx.setOnSmileyChosenListener(new WebViewInputFooter.a()
      {
        public final boolean Wd(final String paramAnonymousString)
        {
          AppMethodBeat.i(198018);
          g.this.chX.a(new com.tencent.luggage.d.d()
          {
            public final JSONObject BP()
            {
              AppMethodBeat.i(198017);
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("smiley", paramAnonymousString);
                label24:
                AppMethodBeat.o(198017);
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
          AppMethodBeat.o(198018);
          return true;
        }
      });
      this.Egx.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
      {
        public final void eTd()
        {
          AppMethodBeat.i(198019);
          g.this.Xn(0);
          AppMethodBeat.o(198019);
        }
        
        public final void eTe()
        {
          AppMethodBeat.i(198020);
          if ((g.c(g.this) != null) && (g.c(g.this).getKeyBoardHeight() > 0)) {
            g.this.Xn(g.c(g.this).getKeyBoardHeight());
          }
          AppMethodBeat.o(198020);
        }
      });
      this.Egy = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(2131304407));
      this.Egy.setActionDelegate(new WebViewSearchContentInputFooter.a()
      {
        public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(198022);
          if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
            b(paramAnonymousWebViewSearchContentInputFooter);
          }
          AppMethodBeat.o(198022);
        }
        
        public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(198025);
          g.this.Egt.clearMatches();
          paramAnonymousWebViewSearchContentInputFooter.reset();
          g.d(g.this).C(0, 0, true);
          g.this.Egt.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
          AppMethodBeat.o(198025);
        }
        
        public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return false;
        }
        
        public final void eTf()
        {
          AppMethodBeat.i(198021);
          g.a(g.this, 0);
          g.this.Egt.clearMatches();
          g.d(g.this).eZx();
          AppMethodBeat.o(198021);
        }
        
        public final void eTg()
        {
          AppMethodBeat.i(198023);
          g.this.Egt.findNext(false);
          AppMethodBeat.o(198023);
        }
        
        public final void eTh()
        {
          AppMethodBeat.i(198024);
          g.this.Egt.findNext(true);
          AppMethodBeat.o(198024);
        }
      });
      this.Egt.setFindListener(new WebView.FindListener()
      {
        public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198026);
          g.d(g.this).C(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          AppMethodBeat.o(198026);
        }
      });
      this.Egz = ((FrameLayout)((View)localObject).findViewById(2131303929));
      if (this.Egz != null) {
        this.Egz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(78274);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            g.this.chX.loadUrl(g.this.getUrl());
            g.a(g.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(78274);
          }
        });
      }
      this.Egw.setOnkbdStateListener(new KeyboardLinearLayout.a()
      {
        public final void Hs(int paramAnonymousInt)
        {
          AppMethodBeat.i(198027);
          ae.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
          if (!g.e(g.this))
          {
            ae.i("MicroMsg.LuggageMMWebPage", "background ignored");
            AppMethodBeat.o(198027);
            return;
          }
          g.a(g.this, g.c(g.this), paramAnonymousInt);
          if (paramAnonymousInt == -3)
          {
            if ((g.b(g.this) != null) && (g.b(g.this).getVisibility() == 0))
            {
              WebViewInputFooter localWebViewInputFooter = g.b(g.this);
              if (localWebViewInputFooter.ELb) {
                localWebViewInputFooter.setVisibility(8);
              }
              localWebViewInputFooter.state = 0;
              localWebViewInputFooter.bFx();
            }
            g.a(g.this, g.c(g.this).getKeyBoardHeight());
            AppMethodBeat.o(198027);
            return;
          }
          g.a(g.this, 0);
          AppMethodBeat.o(198027);
        }
      });
      this.Egt.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78275);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (g.b(g.this).isShown()) {
            g.b(g.this).hide();
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            g.this.oef = ((int)paramAnonymousMotionEvent.getRawX());
            g.this.oeg = ((int)paramAnonymousMotionEvent.getRawY());
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(78275);
          return false;
        }
      });
      localObject = this.mRootView;
      AppMethodBeat.o(78283);
      return localObject;
      localb.addView(localView, localLayoutParams1);
      localLayoutParams2.addRule(3, localView.getId());
      localb.addView((View)localObject, localLayoutParams2);
    }
  }
  
  public String Cs()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.y.d.VE("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public boolean HZ(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.EgK.fV(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  public final void Xn(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Egx.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.Egx.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  public final void Xp(int paramInt)
  {
    AppMethodBeat.i(198057);
    ae.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.Egt.getSettings().setTextZoom(100);
      AppMethodBeat.o(198057);
      return;
    case 1: 
      this.Egt.getSettings().setTextZoom(80);
      AppMethodBeat.o(198057);
      return;
    case 2: 
      this.Egt.getSettings().setTextZoom(100);
      AppMethodBeat.o(198057);
      return;
    case 3: 
      this.Egt.getSettings().setTextZoom(110);
      AppMethodBeat.o(198057);
      return;
    case 4: 
      this.Egt.getSettings().setTextZoom(112);
      AppMethodBeat.o(198057);
      return;
    case 5: 
      this.Egt.getSettings().setTextZoom(112);
      AppMethodBeat.o(198057);
      return;
    case 6: 
      this.Egt.getSettings().setTextZoom(140);
      AppMethodBeat.o(198057);
      return;
    case 7: 
      this.Egt.getSettings().setTextZoom(155);
      AppMethodBeat.o(198057);
      return;
    }
    this.Egt.getSettings().setTextZoom(165);
    AppMethodBeat.o(198057);
  }
  
  protected final boolean aIo(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.EgK.a(paramString, 5, this.Ehb) == c.a.EoV)
    {
      AppMethodBeat.o(78320);
      return true;
    }
    AppMethodBeat.o(78320);
    return false;
  }
  
  protected final void abj(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.chX.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject BP()
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
  
  protected void ams(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.Egt.getX5WebViewExtension() != null)
    {
      this.Egu.setPullDownEnabled(true);
      this.Egu.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean amu(String paramString)
  {
    return false;
  }
  
  protected boolean amw(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.EgK.aJB(paramString))
    {
      this.EgO = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.EgK.a(paramString, this.Ehb) == c.a.EoV) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.EgO = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected void amx(String paramString)
  {
    AppMethodBeat.i(78314);
    ae.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.Egt.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  protected WebResourceResponse amy(String paramString)
  {
    return null;
  }
  
  protected void amz(String paramString) {}
  
  public final void as(Runnable paramRunnable)
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
    ae.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78322);
      return;
      if (!amu(paramString)) {
        this.Egz.setVisibility(0);
      }
    }
  }
  
  protected boolean bRP()
  {
    AppMethodBeat.i(78325);
    if (!this.mParams.getBoolean("disable_minimize", false)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", new Object[] { getClass(), Boolean.valueOf(bool) });
      AppMethodBeat.o(78325);
      return bool;
    }
  }
  
  public final String bRn()
  {
    AppMethodBeat.i(78318);
    String str = this.mParams.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  public final void bhZ()
  {
    AppMethodBeat.i(78297);
    this.EgQ = android.support.v4.content.b.n(this.mContext, 2131099873);
    eSO();
    AppMethodBeat.o(78297);
  }
  
  public final void cC(String paramString)
  {
    AppMethodBeat.i(198055);
    if (this.Egt != null) {
      this.Egt.evaluateJavascript(paramString, null);
    }
    AppMethodBeat.o(198055);
  }
  
  protected void cE(String paramString)
  {
    AppMethodBeat.i(78315);
    ae.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    if (amw(paramString))
    {
      int i = this.EgK.aJA(paramString);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.chX.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.e(this.Egt);
    if (this.EgF != null)
    {
      this.EgF.eD("rawUrl", paramString);
      this.EgF.aIr(paramString);
    }
    if (this.EgG != null)
    {
      this.EgG.setUrl(bu.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EgG);
    }
    this.Ege.setOptionEnable(false);
    cZT();
    ams(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void cF(String paramString)
  {
    AppMethodBeat.i(78316);
    ae.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.e(this.Egt);
    this.Ege.setOptionEnable(true);
    daf();
    if (this.EgF != null)
    {
      this.EgF.eD("rawUrl", paramString);
      this.EgF.aIr(paramString);
    }
    if (this.EgG != null)
    {
      this.EgG.setUrl(bu.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EgG);
    }
    AppMethodBeat.o(78316);
  }
  
  protected void cZT()
  {
    AppMethodBeat.i(78310);
    this.EgA.setVisibility(0);
    this.EgA.start();
    AppMethodBeat.o(78310);
  }
  
  protected void cZZ()
  {
    AppMethodBeat.i(78285);
    this.Ege.cZZ();
    AppMethodBeat.o(78285);
  }
  
  public void dN(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.EgV) {
      this.EgF.WY(paramString);
    }
    if (this.EgG != null)
    {
      this.EgG.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.EgG);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198051);
        if (g.this.Ege != null)
        {
          if (!bu.isNullOrNil(paramString)) {
            g.this.Ege.setTitleText(paramString);
          }
          if (paramInt != 0) {
            g.this.Ege.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(198051);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  protected View dad()
  {
    AppMethodBeat.i(78284);
    this.Ege = new m(this);
    m localm = this.Ege;
    AppMethodBeat.o(78284);
    return localm;
  }
  
  protected void dae()
  {
    AppMethodBeat.i(78294);
    if (!this.EgP)
    {
      this.EgQ = this.mParams.getInt("customize_status_bar_color");
      if (this.EgQ == 0) {
        this.EgQ = android.support.v4.content.b.n(this.mContext, 2131099873);
      }
    }
    eSO();
    AppMethodBeat.o(78294);
  }
  
  protected void daf()
  {
    AppMethodBeat.i(78311);
    this.EgA.finish();
    this.EgA.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  public final void dme()
  {
    AppMethodBeat.i(78306);
    this.Ege.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  protected void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    ae.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (bu.isNullOrNil(this.uee)) {
      this.uee = paramString2;
    }
    this.EgN = paramMap;
    if ((!amu(paramString1)) && (!this.EgR) && (!this.EgW))
    {
      this.chX.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        this.chX.chP.loadUrl(paramString2, paramMap);
        AppMethodBeat.o(78321);
        return;
      }
      this.chX.loadUrl(paramString2);
    }
    AppMethodBeat.o(78321);
  }
  
  public final void eSM()
  {
    AppMethodBeat.i(78286);
    ae.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.mParams.getString("float_ball_key");
    if (!bu.isNullOrNil(str)) {
      this.EgF.ac(5, str);
    }
    for (;;)
    {
      this.EgF.eD("rawUrl", bRn());
      this.EgF.aIr(bRn());
      if (bu.isNullOrNil(this.Ege.getTitle())) {
        this.EgF.WY(bRn());
      }
      this.EgV = true;
      if (this.EgU) {
        this.EgF.bhj();
      }
      this.EgG = new HandOffURL(bu.nullAsNil(bRn()), bu.nullAsNil(bRn()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.EgG);
      eSN();
      AppMethodBeat.o(78286);
      return;
      this.EgF.ac(5, com.tencent.mm.plugin.ball.f.b.Xb(bRn()));
    }
  }
  
  public final void eSN()
  {
    AppMethodBeat.i(198053);
    int i = this.mParams.getInt("screen_orientation", -1);
    if (this.chm.Cg().peek() == this) {
      ((Activity)this.mContext).setRequestedOrientation(i);
    }
    AppMethodBeat.o(198053);
  }
  
  protected final void eSO()
  {
    AppMethodBeat.i(78295);
    ae.d("MicroMsg.LuggageMMWebPage", "setActionBarColor");
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78277);
          g.this.eSO();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.Ege.i(this.EgQ, this.EgY.Ehm, this.EgY.Ehn);
    AppMethodBeat.o(78295);
  }
  
  public final boolean eSP()
  {
    AppMethodBeat.i(78304);
    if (this.Ege != null)
    {
      boolean bool = this.Ege.eSP();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final m eSQ()
  {
    return this.Ege;
  }
  
  public final void eSR()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198038);
        g.this.Egu.setPullDownEnabled(false);
        AppMethodBeat.o(198038);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean eSS()
  {
    return this.EgO;
  }
  
  public final String eST()
  {
    return this.uee;
  }
  
  public final com.tencent.mm.plugin.webview.e.c eSU()
  {
    return this.EgK;
  }
  
  public final q.a eSV()
  {
    return this.EgM;
  }
  
  public final boolean eSW()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.mParams.getBoolean("forceHideShare", false);
    boolean bool2 = this.mParams.getBoolean("showShare", true);
    ae.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bRP()) });
    if ((!bool1) && (bool2) && (bRP()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final q eSX()
  {
    return this.EgF;
  }
  
  public final HandOffURL eSY()
  {
    return this.EgG;
  }
  
  public final void eSZ()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.chm.Cg().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.chm.Ch().remove(i))
      {
        this.chm.Cj().finish();
        AppMethodBeat.o(78326);
        return;
      }
      com.tencent.e.h.MqF.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          com.tencent.luggage.d.h localh = (com.tencent.luggage.d.h)g.this.chm.Cg().peek();
          if ((localh != null) && ((localh instanceof g))) {
            g.j((g)localh);
          }
          AppMethodBeat.o(78273);
        }
      }, 250L);
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.p.x(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198049);
        g.this.eSZ();
        AppMethodBeat.o(198049);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    ae.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.EgR) });
    this.chX.mUrl = paramString;
    if (this.EgR)
    {
      ae.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.Ege.setOptionEnable(true);
      if (!bu.isNullOrNil(this.mParams.getString("title"))) {
        dN(this.mParams.getString("title"), 0);
      }
      this.lzD = false;
      if (this.EgK == null) {
        this.EgK = new com.tencent.mm.plugin.webview.e.c();
      }
      amw(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    cZT();
    paramBundle = paramBundle.getString("game_open_html");
    if (!bu.isNullOrNil(paramBundle))
    {
      this.EgW = true;
      this.Egt.loadDataWithBaseURL(paramString, paramBundle, "text/html", "utf-8", null);
    }
    do
    {
      for (;;)
      {
        amw(paramString);
        this.lzD = false;
        AppMethodBeat.o(78313);
        return;
        if (!amu(paramString)) {
          break;
        }
        amx(paramString);
      }
    } while (this.lzD);
    g(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  public final void ge(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if ((this.EgF != null) && (this.EgF.sy(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.chm.Ch().bp(paramBoolean))
      {
        this.chm.Cj().finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.p.x(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198050);
          g.this.ge(paramBoolean);
          AppMethodBeat.o(198050);
        }
      });
    }
    AppMethodBeat.o(78327);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(224324);
    String str = this.Ege.getTitle();
    AppMethodBeat.o(224324);
    return str;
  }
  
  public final String getUrl()
  {
    if (this.chX != null) {
      return this.chX.mUrl;
    }
    return "";
  }
  
  public final MMWebView getWebView()
  {
    return this.Egt;
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(78303);
    boolean bool = this.mParams.getBoolean("show_full_screen", false);
    AppMethodBeat.o(78303);
    return bool;
  }
  
  public final void n(String paramString, final float paramFloat)
  {
    AppMethodBeat.i(198054);
    if (!bu.isNullOrNil(paramString)) {}
    try
    {
      int i = Color.parseColor(paramString);
      this.EgP = true;
      this.EgQ = (i | 0xFF000000);
      this.Ege.setActionBarColorValue(this.EgQ);
      label43:
      if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      {
        eSO();
        AppMethodBeat.o(198054);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78278);
          g.this.Ege.setAlpha(paramFloat);
          AppMethodBeat.o(78278);
        }
      });
      AppMethodBeat.o(198054);
      return;
    }
    catch (Exception paramString)
    {
      break label43;
    }
  }
  
  protected void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.Ege.setVisibility(8);
      this.EgB.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.Ege.setVisibility(0);
    this.EgB.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    ae.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.EgU = false;
    abj("onPause");
    this.Ege.daa();
    this.Egt.onPause();
    this.EgS = false;
    if (this.EgF != null) {
      this.EgF.bhk();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.uhn)
    {
      this.uhn = true;
      ae.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.EgE.Egl = null;
      j.c(this);
      this.mRootView.removeAllViews();
      this.chX.setContext(ak.getContext());
      if (this.EgF != null)
      {
        this.EgF.onDestroy();
        if (!this.EgF.bLw()) {
          break label144;
        }
        r.a(this.EgF.EhV, this.chX, this.EgK);
      }
    }
    for (;;)
    {
      if (this.EgG != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.EgG);
      }
      this.EgK.DYb = true;
      this.Ege.onDestroy();
      AppMethodBeat.o(78289);
      return;
      label144:
      abj("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.EgU)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.EgU = true;
    ae.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.EgT)
    {
      ge(false);
      AppMethodBeat.o(78287);
      return;
    }
    eSN();
    ne(isFullScreen());
    dae();
    abj("onResume");
    this.Egt.onResume();
    this.EgS = true;
    Xo(0);
    if (this.EgV) {
      this.EgF.bhj();
    }
    this.Ege.onForeground();
    AppMethodBeat.o(78287);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.Egt.reload();
    AppMethodBeat.o(78290);
  }
  
  static final class a
  {
    boolean Ehm;
    boolean Ehn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.g
 * JD-Core Version:    0.7.0.1
 */