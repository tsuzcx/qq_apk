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
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final Pattern DOZ;
  private static final Pattern DPa;
  private MMFalseProgressBar DOA;
  protected MovingImageButton DOB;
  protected FrameLayout DOC;
  public FrameLayout DOD;
  protected s DOE;
  protected q DOF;
  protected HandOffURL DOG;
  private WebChromeClient.CustomViewCallback DOH;
  private FrameLayout DOI;
  private ProgressBar DOJ;
  protected com.tencent.mm.plugin.webview.e.c DOK;
  public u DOL;
  protected q.a DOM;
  protected Map<String, String> DON;
  protected boolean DOO;
  protected boolean DOP;
  protected int DOQ;
  protected boolean DOR;
  private boolean DOS;
  public boolean DOT;
  private boolean DOU;
  private boolean DOV;
  private boolean DOW;
  public w DOX;
  private a DOY;
  protected m DOe;
  protected com.tencent.mm.plugin.webview.luggage.d.a DOt;
  protected l DOu;
  protected b DOv;
  private WebViewKeyboardLinearLayout DOw;
  public WebViewInputFooter DOx;
  public WebViewSearchContentInputFooter DOy;
  private FrameLayout DOz;
  private com.tencent.mm.plugin.webview.e.a<avj> DPb;
  private com.tencent.mm.plugin.webview.ui.tools.c lvW;
  private boolean lvf;
  public ap mHandler;
  public FrameLayout mRootView;
  public int nYw;
  public int nYx;
  private s.a poe;
  protected String tTn;
  protected boolean tWp;
  
  static
  {
    AppMethodBeat.i(78330);
    DOZ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    DPa = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public g(com.tencent.luggage.d.j paramj, com.tencent.luggage.d.p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(78282);
    this.lvf = true;
    this.DOO = false;
    this.tWp = false;
    this.DOT = false;
    this.DOU = false;
    this.DOV = false;
    this.DOW = false;
    this.nYw = 0;
    this.nYx = 0;
    this.DOX = new w();
    this.DPb = new com.tencent.mm.plugin.webview.e.a()
    {
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(207864);
        g.this.DOO = false;
        g.this.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(207861);
            g.this.b(paramAnonymousInt1, paramAnonymousString1, paramAnonymousInt2, paramAnonymousInt3);
            AppMethodBeat.o(207861);
          }
        });
        AppMethodBeat.o(207864);
      }
      
      public final void bm(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void bn(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(207862);
        g.this.alB(paramAnonymousString);
        AppMethodBeat.o(207862);
      }
      
      public final void z(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(207863);
        g.this.DOO = false;
        g.this.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(207860);
            g localg = g.this;
            String str = paramAnonymousString2;
            localg.chX.chP.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(207860);
          }
        });
        AppMethodBeat.o(207863);
      }
    };
    this.poe = new s.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(207868);
        if (com.tencent.mm.cq.d.kP(g.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            ad.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            g.this.aGU(paramAnonymousWebResourceRequest.getUrl().toString());
          }
        }
        catch (Exception paramAnonymousBundle)
        {
          for (;;)
          {
            ad.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", new Object[] { paramAnonymousBundle.getMessage() });
          }
        }
        catch (Throwable paramAnonymousBundle)
        {
          for (;;)
          {
            ad.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", new Object[] { paramAnonymousBundle.getMessage() });
            continue;
            paramAnonymousWebResourceRequest = "";
          }
        }
        if (paramAnonymousWebResourceRequest != null)
        {
          paramAnonymousWebResourceRequest = paramAnonymousWebResourceRequest.getUrl().toString();
          paramAnonymousWebResourceRequest = g.this.alA(paramAnonymousWebResourceRequest);
          AppMethodBeat.o(207868);
          return paramAnonymousWebResourceRequest;
        }
      }
      
      public final void a(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(207866);
        g.this.cD(paramAnonymousString);
        AppMethodBeat.o(207866);
      }
      
      public final void b(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(207867);
        g.this.cE(paramAnonymousString);
        AppMethodBeat.o(207867);
      }
    };
    if (paramp != null)
    {
      this.DOR = true;
      this.DOK = com.tencent.mm.plugin.webview.e.e.WR(paramp.hashCode());
    }
    if (this.DOK == null) {}
    for (;;)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.DOK == null) {
        this.DOK = new com.tencent.mm.plugin.webview.e.c();
      }
      this.mHandler = new ap();
      this.DOL = new u(this);
      this.DOM = new q.a(this, this.DOK);
      this.chX.chG = this.DOM;
      this.DOE = new s(this);
      this.DOF = new q(new d(this), this);
      j.b(this);
      if (this.DOt != null)
      {
        this.DOt.setPage(this);
        this.DOt.setWebViewClient(new ac()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(207851);
            ad.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            g.this.A(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(207851);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.r paramAnonymousr, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(207852);
            if (g.f(g.this) == null) {
              g.a(g.this, new com.tencent.mm.plugin.webview.ui.tools.c(g.this.mContext, paramAnonymousWebView));
            }
            g.f(g.this).a(g.this.getUrl(), paramAnonymousr, paramAnonymousSslError);
            AppMethodBeat.o(207852);
          }
        });
        this.DOt.setWebChromeClient(new x()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            int i = 1;
            AppMethodBeat.i(207853);
            ad.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.b.UV(paramAnonymousString)) {
              if ((bt.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equalsIgnoreCase("about:blank"))) {
                break label74;
              }
            }
            for (;;)
            {
              if (i == 0) {
                g.this.dJ(paramAnonymousString, 0);
              }
              g.this.chX.Co();
              AppMethodBeat.o(207853);
              return;
              label74:
              i = 0;
            }
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(207856);
            ad.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (g.i(g.this) == null)
            {
              g.a(g.this, new ProgressBar(g.this.mContext));
              g.i(g.this).setIndeterminate(true);
            }
            ProgressBar localProgressBar = g.i(g.this);
            AppMethodBeat.o(207856);
            return localProgressBar;
          }
          
          public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            return false;
          }
          
          public final void onHideCustomView()
          {
            AppMethodBeat.i(207855);
            ad.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (g.g(g.this) == null)
            {
              AppMethodBeat.o(207855);
              return;
            }
            try
            {
              g.this.DOu.setVisibility(0);
              if (g.h(g.this) != null) {
                g.h(g.this).onCustomViewHidden();
              }
              g.this.DOe.setVisibility(0);
              if (g.g(g.this) != null) {
                g.this.mRootView.removeView(g.g(g.this));
              }
              g.g(g.this).removeAllViews();
              g.a(g.this, null);
              AppMethodBeat.o(207855);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(207855);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(207854);
            ad.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
            try
            {
              if (g.g(g.this) != null)
              {
                paramAnonymousCustomViewCallback.onCustomViewHidden();
                AppMethodBeat.o(207854);
                return;
              }
              g.a(g.this, new FrameLayout(g.this.mContext));
              g.g(g.this).setBackgroundResource(2131101165);
              g.g(g.this).addView(paramAnonymousView);
              g.a(g.this, paramAnonymousCustomViewCallback);
              g.this.DOu.setVisibility(8);
              g.this.DOe.setVisibility(8);
              g.this.mRootView.addView(g.g(g.this));
              AppMethodBeat.o(207854);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(207854);
            }
          }
        });
      }
      a(this.poe);
      paramj = this.chl;
      paramp = new l.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (g.this.ePd())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.DOF != null) && (g.this.DOF.sv(2)))
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
  
  private void WH(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.DOy.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.DOy.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.DOy.isShown()) {
      i = paramInt + this.DOy.getHeight();
    }
    this.DOu.setPadding(this.DOu.getPaddingLeft(), this.DOu.getPaddingTop(), this.DOu.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  protected void A(int paramInt, String paramString1, String paramString2) {}
  
  public View BQ()
  {
    AppMethodBeat.i(78283);
    Object localObject = bQm();
    this.DOY = new a((byte)0);
    localObject = Uri.parse((String)localObject);
    if (bt.nullAsNil(((Uri)localObject).getQueryParameter("immersiveUIStyle")).equals("1")) {
      this.DOY.DPm = true;
    }
    if (bt.nullAsNil(((Uri)localObject).getQueryParameter("immersivePageBgIsDark")).equals("1")) {
      this.DOY.DPn = true;
    }
    this.DOt = ((com.tencent.mm.plugin.webview.luggage.d.a)this.chX.Cm());
    this.DOu = new l(this.mContext, super.BQ());
    this.DOt.setCompetitorView(this.DOu);
    this.DOt.setSource(this.mParams.getString("KPublisherId"));
    this.mRootView = new FrameLayout(this.mContext);
    this.DOv = new b(this.mContext);
    this.DOv.setBackgroundColor(android.support.v4.content.b.n(this.mContext, 2131101179));
    this.mRootView.addView(this.DOv, new FrameLayout.LayoutParams(-1, -1));
    localObject = com.tencent.mm.ui.z.jO(this.mContext).inflate(2131494673, this.DOv, false);
    b localb = this.DOv;
    View localView = cXt();
    boolean bool = this.DOY.DPm;
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
      this.DOv.setActionBar(this.DOe);
      this.DOv.setWebView(this.DOt);
      this.DOC = ((FrameLayout)((View)localObject).findViewById(2131298736));
      this.DOA = ((MMFalseProgressBar)((View)localObject).findViewById(2131306899));
      this.DOB = ((MovingImageButton)((View)localObject).findViewById(2131300327));
      this.DOB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78257);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          g.this.cXp();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78257);
        }
      });
      this.DOw = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(2131300570));
      this.DOD = ((FrameLayout)((View)localObject).findViewById(2131306898));
      this.DOD.addView(this.DOu, new ViewGroup.LayoutParams(-1, -1));
      this.DOx = ((WebViewInputFooter)((View)localObject).findViewById(2131306916));
      this.DOx.hide();
      this.DOx.setOnTextSendListener(new WebViewInputFooter.c()
      {
        public final void aGV(String paramAnonymousString)
        {
          AppMethodBeat.i(207872);
          g.ePo();
          if (g.b(g.this) != null) {
            g.b(g.this).hide();
          }
          AppMethodBeat.o(207872);
        }
      });
      this.DOx.setOnSmileyChosenListener(new WebViewInputFooter.a()
      {
        public final boolean Vr(final String paramAnonymousString)
        {
          AppMethodBeat.i(207838);
          g.this.chX.a(new com.tencent.luggage.d.d()
          {
            public final JSONObject BO()
            {
              AppMethodBeat.i(207837);
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("smiley", paramAnonymousString);
                label24:
                AppMethodBeat.o(207837);
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
          AppMethodBeat.o(207838);
          return true;
        }
      });
      this.DOx.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
      {
        public final void ePr()
        {
          AppMethodBeat.i(207839);
          g.this.WG(0);
          AppMethodBeat.o(207839);
        }
        
        public final void ePs()
        {
          AppMethodBeat.i(207840);
          if ((g.c(g.this) != null) && (g.c(g.this).getKeyBoardHeight() > 0)) {
            g.this.WG(g.c(g.this).getKeyBoardHeight());
          }
          AppMethodBeat.o(207840);
        }
      });
      this.DOy = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(2131304407));
      this.DOy.setActionDelegate(new WebViewSearchContentInputFooter.a()
      {
        public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(207842);
          if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
            b(paramAnonymousWebViewSearchContentInputFooter);
          }
          AppMethodBeat.o(207842);
        }
        
        public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(207845);
          g.this.DOt.clearMatches();
          paramAnonymousWebViewSearchContentInputFooter.reset();
          g.d(g.this).C(0, 0, true);
          g.this.DOt.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
          AppMethodBeat.o(207845);
        }
        
        public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return false;
        }
        
        public final void ePt()
        {
          AppMethodBeat.i(207841);
          g.a(g.this, 0);
          g.this.DOt.clearMatches();
          g.d(g.this).eVK();
          AppMethodBeat.o(207841);
        }
        
        public final void ePu()
        {
          AppMethodBeat.i(207843);
          g.this.DOt.findNext(false);
          AppMethodBeat.o(207843);
        }
        
        public final void ePv()
        {
          AppMethodBeat.i(207844);
          g.this.DOt.findNext(true);
          AppMethodBeat.o(207844);
        }
      });
      this.DOt.setFindListener(new WebView.FindListener()
      {
        public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(207846);
          g.d(g.this).C(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          AppMethodBeat.o(207846);
        }
      });
      this.DOz = ((FrameLayout)((View)localObject).findViewById(2131303929));
      if (this.DOz != null) {
        this.DOz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(78274);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            g.this.chX.loadUrl(g.this.getUrl());
            g.a(g.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(78274);
          }
        });
      }
      this.DOw.setOnkbdStateListener(new KeyboardLinearLayout.a()
      {
        public final void GV(int paramAnonymousInt)
        {
          AppMethodBeat.i(207847);
          ad.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
          if (!g.e(g.this))
          {
            ad.i("MicroMsg.LuggageMMWebPage", "background ignored");
            AppMethodBeat.o(207847);
            return;
          }
          g.a(g.this, g.c(g.this), paramAnonymousInt);
          if (paramAnonymousInt == -3)
          {
            if ((g.b(g.this) != null) && (g.b(g.this).getVisibility() == 0)) {
              g.b(g.this).eVN();
            }
            g.a(g.this, g.c(g.this).getKeyBoardHeight());
            AppMethodBeat.o(207847);
            return;
          }
          g.a(g.this, 0);
          AppMethodBeat.o(207847);
        }
      });
      this.DOt.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78275);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (g.b(g.this).isShown()) {
            g.b(g.this).hide();
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            g.this.nYw = ((int)paramAnonymousMotionEvent.getRawX());
            g.this.nYx = ((int)paramAnonymousMotionEvent.getRawY());
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
  
  public String Cp()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.z.d.UT("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public boolean HC(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.DOK.fK(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  public final void WG(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.DOx.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.DOx.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  public final void WI(int paramInt)
  {
    AppMethodBeat.i(207877);
    ad.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      this.DOt.getSettings().setTextZoom(100);
      AppMethodBeat.o(207877);
      return;
    case 1: 
      this.DOt.getSettings().setTextZoom(80);
      AppMethodBeat.o(207877);
      return;
    case 2: 
      this.DOt.getSettings().setTextZoom(100);
      AppMethodBeat.o(207877);
      return;
    case 3: 
      this.DOt.getSettings().setTextZoom(110);
      AppMethodBeat.o(207877);
      return;
    case 4: 
      this.DOt.getSettings().setTextZoom(112);
      AppMethodBeat.o(207877);
      return;
    case 5: 
      this.DOt.getSettings().setTextZoom(112);
      AppMethodBeat.o(207877);
      return;
    case 6: 
      this.DOt.getSettings().setTextZoom(140);
      AppMethodBeat.o(207877);
      return;
    case 7: 
      this.DOt.getSettings().setTextZoom(155);
      AppMethodBeat.o(207877);
      return;
    }
    this.DOt.getSettings().setTextZoom(165);
    AppMethodBeat.o(207877);
  }
  
  protected final boolean aGU(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.DOK.a(paramString, 5, this.DPb) == c.a.DWT)
    {
      AppMethodBeat.o(78320);
      return true;
    }
    AppMethodBeat.o(78320);
    return false;
  }
  
  protected final void aas(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.chX.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject BO()
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
  
  protected WebResourceResponse alA(String paramString)
  {
    return null;
  }
  
  protected void alB(String paramString) {}
  
  protected void alu(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.DOt.getX5WebViewExtension() != null)
    {
      this.DOu.setPullDownEnabled(true);
      this.DOu.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean alw(String paramString)
  {
    return false;
  }
  
  protected boolean aly(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.DOK.aIi(paramString))
    {
      this.DOO = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.DOK.a(paramString, this.DPb) == c.a.DWT) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.DOO = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected void alz(String paramString)
  {
    AppMethodBeat.i(78314);
    ad.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.DOt.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  public final void au(Runnable paramRunnable)
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
    ad.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(78322);
      return;
      if (!alw(paramString)) {
        this.DOz.setVisibility(0);
      }
    }
  }
  
  protected boolean bQO()
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
  
  public final String bQm()
  {
    AppMethodBeat.i(78318);
    String str = this.mParams.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  public final void bhr()
  {
    AppMethodBeat.i(78297);
    this.DOQ = android.support.v4.content.b.n(this.mContext, 2131099873);
    ePc();
    AppMethodBeat.o(78297);
  }
  
  public final void cB(String paramString)
  {
    AppMethodBeat.i(207875);
    if (this.DOt != null) {
      this.DOt.evaluateJavascript(paramString, null);
    }
    AppMethodBeat.o(207875);
  }
  
  protected void cD(String paramString)
  {
    AppMethodBeat.i(78315);
    ad.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    if (aly(paramString))
    {
      int i = this.DOK.aIh(paramString);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.chX.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.e(this.DOt);
    if (this.DOF != null)
    {
      this.DOF.eA("rawUrl", paramString);
      this.DOF.aGX(paramString);
    }
    if (this.DOG != null)
    {
      this.DOG.setUrl(bt.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.DOG);
    }
    this.DOe.setOptionEnable(false);
    cXk();
    alu(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void cE(String paramString)
  {
    AppMethodBeat.i(78316);
    ad.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.e(this.DOt);
    this.DOe.setOptionEnable(true);
    cXv();
    if (this.DOF != null)
    {
      this.DOF.eA("rawUrl", paramString);
      this.DOF.aGX(paramString);
    }
    if (this.DOG != null)
    {
      this.DOG.setUrl(bt.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.DOG);
    }
    AppMethodBeat.o(78316);
  }
  
  protected void cXk()
  {
    AppMethodBeat.i(78310);
    this.DOA.setVisibility(0);
    this.DOA.start();
    AppMethodBeat.o(78310);
  }
  
  protected void cXp()
  {
    AppMethodBeat.i(78285);
    this.DOe.cXp();
    AppMethodBeat.o(78285);
  }
  
  protected View cXt()
  {
    AppMethodBeat.i(78284);
    this.DOe = new m(this);
    m localm = this.DOe;
    AppMethodBeat.o(78284);
    return localm;
  }
  
  protected void cXu()
  {
    AppMethodBeat.i(78294);
    if (!this.DOP)
    {
      this.DOQ = this.mParams.getInt("customize_status_bar_color");
      if (this.DOQ == 0) {
        this.DOQ = android.support.v4.content.b.n(this.mContext, 2131099873);
      }
    }
    ePc();
    AppMethodBeat.o(78294);
  }
  
  protected void cXv()
  {
    AppMethodBeat.i(78311);
    this.DOA.finish();
    this.DOA.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  public void dJ(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.DOV) {
      this.DOF.Wm(paramString);
    }
    if (this.DOG != null)
    {
      this.DOG.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.DOG);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207871);
        if (g.this.DOe != null)
        {
          if (!bt.isNullOrNil(paramString)) {
            g.this.DOe.setTitleText(paramString);
          }
          if (paramInt != 0) {
            g.this.DOe.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(207871);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  public final void djf()
  {
    AppMethodBeat.i(78306);
    this.DOe.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  protected void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    ad.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (bt.isNullOrNil(this.tTn)) {
      this.tTn = paramString2;
    }
    this.DON = paramMap;
    if ((!alw(paramString1)) && (!this.DOR) && (!this.DOW))
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
  
  public final void ePa()
  {
    AppMethodBeat.i(78286);
    ad.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.mParams.getString("float_ball_key");
    if (!bt.isNullOrNil(str)) {
      this.DOF.ac(5, str);
    }
    for (;;)
    {
      this.DOF.eA("rawUrl", bQm());
      this.DOF.aGX(bQm());
      if (bt.isNullOrNil(this.DOe.getTitle())) {
        this.DOF.Wm(bQm());
      }
      this.DOV = true;
      if (this.DOU) {
        this.DOF.bgB();
      }
      this.DOG = new HandOffURL(bt.nullAsNil(bQm()), bt.nullAsNil(bQm()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).a(this.DOG);
      ePb();
      AppMethodBeat.o(78286);
      return;
      this.DOF.ac(5, com.tencent.mm.plugin.ball.f.b.Wp(bQm()));
    }
  }
  
  public final void ePb()
  {
    AppMethodBeat.i(207873);
    int i = this.mParams.getInt("screen_orientation", -1);
    if (this.chm.Cd().peek() == this) {
      ((Activity)this.mContext).setRequestedOrientation(i);
    }
    AppMethodBeat.o(207873);
  }
  
  protected final void ePc()
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
          g.this.ePc();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.DOe.i(this.DOQ, this.DOY.DPm, this.DOY.DPn);
    AppMethodBeat.o(78295);
  }
  
  public final boolean ePd()
  {
    AppMethodBeat.i(78304);
    if (this.DOe != null)
    {
      boolean bool = this.DOe.ePd();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final m ePe()
  {
    return this.DOe;
  }
  
  public final void ePf()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207858);
        g.this.DOu.setPullDownEnabled(false);
        AppMethodBeat.o(207858);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean ePg()
  {
    return this.DOO;
  }
  
  public final String ePh()
  {
    return this.tTn;
  }
  
  public final com.tencent.mm.plugin.webview.e.c ePi()
  {
    return this.DOK;
  }
  
  public final q.a ePj()
  {
    return this.DOM;
  }
  
  public final boolean ePk()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.mParams.getBoolean("forceHideShare", false);
    boolean bool2 = this.mParams.getBoolean("showShare", true);
    ad.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bQO()) });
    if ((!bool1) && (bool2) && (bQO()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final q ePl()
  {
    return this.DOF;
  }
  
  public final HandOffURL ePm()
  {
    return this.DOG;
  }
  
  public final void ePn()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.chm.Cd().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.chm.Ce().remove(i))
      {
        this.chm.Cg().finish();
        AppMethodBeat.o(78326);
        return;
      }
      com.tencent.e.h.LTJ.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          com.tencent.luggage.d.h localh = (com.tencent.luggage.d.h)g.this.chm.Cd().peek();
          if ((localh != null) && ((localh instanceof g))) {
            g.j((g)localh);
          }
          AppMethodBeat.o(78273);
        }
      }, 250L);
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.p.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207869);
        g.this.ePn();
        AppMethodBeat.o(207869);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    ad.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.DOR) });
    this.chX.mUrl = paramString;
    if (this.DOR)
    {
      ad.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.DOe.setOptionEnable(true);
      if (!bt.isNullOrNil(this.mParams.getString("title"))) {
        dJ(this.mParams.getString("title"), 0);
      }
      this.lvf = false;
      if (this.DOK == null) {
        this.DOK = new com.tencent.mm.plugin.webview.e.c();
      }
      aly(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    cXk();
    paramBundle = paramBundle.getString("game_open_html");
    if (!bt.isNullOrNil(paramBundle))
    {
      this.DOW = true;
      this.DOt.loadDataWithBaseURL(paramString, paramBundle, "text/html", "utf-8", null);
    }
    do
    {
      for (;;)
      {
        aly(paramString);
        this.lvf = false;
        AppMethodBeat.o(78313);
        return;
        if (!alw(paramString)) {
          break;
        }
        alz(paramString);
      }
    } while (this.lvf);
    g(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(221641);
    String str = this.DOe.getTitle();
    AppMethodBeat.o(221641);
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
    return this.DOt;
  }
  
  public final void gg(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if ((this.DOF != null) && (this.DOF.sv(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.chm.Ce().bp(paramBoolean))
      {
        this.chm.Cg().finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.p.z(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207870);
          g.this.gg(paramBoolean);
          AppMethodBeat.o(207870);
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
  
  protected void na(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.DOe.setVisibility(8);
      this.DOB.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.DOe.setVisibility(0);
    this.DOB.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.a.b(((Activity)this.mContext).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    ad.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.DOU = false;
    aas("onPause");
    this.DOe.cXq();
    this.DOt.onPause();
    this.DOS = false;
    if (this.DOF != null) {
      this.DOF.bgC();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.tWp)
    {
      this.tWp = true;
      ad.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.DOE.DOl = null;
      j.c(this);
      this.mRootView.removeAllViews();
      this.chX.setContext(aj.getContext());
      if (this.DOF != null)
      {
        this.DOF.onDestroy();
        if (!this.DOF.bKz()) {
          break label144;
        }
        r.a(this.DOF.DPV, this.chX, this.DOK);
      }
    }
    for (;;)
    {
      if (this.DOG != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).b(this.DOG);
      }
      this.DOK.DGd = true;
      this.DOe.onDestroy();
      AppMethodBeat.o(78289);
      return;
      label144:
      aas("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.DOU)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.DOU = true;
    ad.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.DOT)
    {
      gg(false);
      AppMethodBeat.o(78287);
      return;
    }
    ePb();
    na(isFullScreen());
    cXu();
    aas("onResume");
    this.DOt.onResume();
    this.DOS = true;
    WH(0);
    if (this.DOV) {
      this.DOF.bgB();
    }
    this.DOe.onForeground();
    AppMethodBeat.o(78287);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.DOt.reload();
    AppMethodBeat.o(78290);
  }
  
  public final void u(int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(207874);
    if (paramInt != -1)
    {
      this.DOP = true;
      this.DOQ = paramInt;
    }
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      ePc();
      AppMethodBeat.o(207874);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78278);
        g.this.DOe.setAlpha(paramFloat);
        AppMethodBeat.o(78278);
      }
    });
    AppMethodBeat.o(207874);
  }
  
  static final class a
  {
    boolean DPm;
    boolean DPn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.g
 * JD-Core Version:    0.7.0.1
 */