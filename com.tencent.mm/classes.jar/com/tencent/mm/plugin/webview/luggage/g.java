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
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s.a;
import com.tencent.luggage.k.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.f.c.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.ar;
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

public class g
  extends com.tencent.luggage.d.s
{
  private static final Pattern PQb;
  private static final Pattern PQc;
  protected boolean CDM;
  protected String CzZ;
  private WebViewSearchContentInputFooter PPA;
  private FrameLayout PPB;
  private MMFalseProgressBar PPC;
  protected MovingImageButton PPD;
  protected FrameLayout PPE;
  public FrameLayout PPF;
  protected s PPG;
  protected q PPH;
  protected t PPI;
  protected HandOffURL PPJ;
  private WebChromeClient.CustomViewCallback PPK;
  private FrameLayout PPL;
  private ProgressBar PPM;
  protected com.tencent.mm.plugin.webview.f.c PPN;
  public w PPO;
  protected q.a PPP;
  protected Map<String, String> PPQ;
  protected boolean PPR;
  protected boolean PPS;
  protected int PPT;
  protected boolean PPU;
  public boolean PPV;
  private boolean PPW;
  private boolean PPX;
  private boolean PPY;
  public y PPZ;
  protected m PPg;
  public com.tencent.mm.plugin.webview.luggage.d.a PPv;
  protected l PPw;
  protected b PPx;
  private WebViewKeyboardLinearLayout PPy;
  public WebViewInputFooter PPz;
  private a PQa;
  private com.tencent.mm.plugin.webview.f.a<bot> PQd;
  private s.a PQe;
  public MMHandler mHandler;
  protected boolean mIsForeground;
  public FrameLayout mRootView;
  private boolean pFW;
  private com.tencent.mm.plugin.webview.ui.tools.c pHc;
  public int syc;
  public int syd;
  
  static
  {
    AppMethodBeat.i(78330);
    PQb = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    PQc = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    AppMethodBeat.o(78330);
  }
  
  public g(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(78282);
    this.pFW = true;
    this.PPR = false;
    this.mIsForeground = false;
    this.CDM = false;
    this.PPV = false;
    this.PPW = false;
    this.PPX = false;
    this.PPY = false;
    this.syc = 0;
    this.syd = 0;
    this.PPZ = new y();
    this.PQd = new com.tencent.mm.plugin.webview.f.a()
    {
      public final void F(int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(249869);
        g.this.PPR = false;
        g.this.aI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(228779);
            g localg = g.this;
            String str = paramAnonymousString2;
            localg.crX.crP.loadData(str, "text/html", "utf-8");
            AppMethodBeat.o(228779);
          }
        });
        AppMethodBeat.o(249869);
      }
      
      public final void a(final int paramAnonymousInt1, final String paramAnonymousString1, final int paramAnonymousInt2, final int paramAnonymousInt3, final String paramAnonymousString2)
      {
        AppMethodBeat.i(249871);
        g.this.PPR = false;
        g.this.aI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243961);
            g.this.c(paramAnonymousInt1, paramAnonymousString1, paramAnonymousInt2, paramAnonymousInt3);
            AppMethodBeat.o(243961);
          }
        });
        AppMethodBeat.o(249871);
      }
      
      public final void bu(int paramAnonymousInt, String paramAnonymousString) {}
      
      public final void bv(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(249867);
        g.this.aJA(paramAnonymousString);
        AppMethodBeat.o(249867);
      }
    };
    this.PQe = new s.a()
    {
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(218649);
        if (com.tencent.mm.xwebutil.c.lP(g.this.mContext)) {}
        try
        {
          int i = paramAnonymousBundle.getInt("resourceType");
          if ((i == 1) || (i == 7))
          {
            Log.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
            g.this.bkm(paramAnonymousWebResourceRequest.getUrl().toString());
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
          paramAnonymousWebResourceRequest = g.this.aJz(paramAnonymousWebResourceRequest);
          AppMethodBeat.o(218649);
          return paramAnonymousWebResourceRequest;
        }
      }
      
      public final void a(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(218642);
        g.this.dv(paramAnonymousString);
        AppMethodBeat.o(218642);
      }
      
      public final void b(com.tencent.luggage.d.s paramAnonymouss, String paramAnonymousString)
      {
        AppMethodBeat.i(218644);
        g.this.dw(paramAnonymousString);
        AppMethodBeat.o(218644);
      }
    };
    if (paramp != null)
    {
      this.PPU = true;
      this.PPN = com.tencent.mm.plugin.webview.f.e.anU(paramp.hashCode());
    }
    if (this.PPN == null) {}
    for (;;)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (this.PPN == null) {
        this.PPN = new com.tencent.mm.plugin.webview.f.c();
      }
      this.mHandler = new MMHandler();
      this.PPO = new w(this);
      this.PPP = new q.a(this, this.PPN);
      this.crX.crG = this.PPP;
      this.PPG = new s(this);
      this.PPH = new q(new d(this), this);
      this.PPI = new t(this, new u(this));
      j.b(this);
      if (this.PPv != null)
      {
        this.PPv.setPage(this);
        this.PPv.setWebViewClient(new com.tencent.xweb.ad()
        {
          public final void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(230538);
            Log.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
            g.this.G(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(230538);
          }
          
          public final void a(WebView paramAnonymousWebView, com.tencent.xweb.r paramAnonymousr, SslError paramAnonymousSslError)
          {
            AppMethodBeat.i(230540);
            if (g.e(g.this) == null) {
              g.a(g.this, new com.tencent.mm.plugin.webview.ui.tools.c(g.this.mContext, paramAnonymousWebView));
            }
            g.e(g.this).a(g.this.getUrl(), paramAnonymousr, paramAnonymousSslError);
            AppMethodBeat.o(230540);
          }
        });
        this.PPv.setWebChromeClient(new x()
        {
          public final void d(WebView paramAnonymousWebView, String paramAnonymousString)
          {
            int i = 1;
            AppMethodBeat.i(227301);
            Log.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", new Object[] { paramAnonymousString });
            if (!com.tencent.mm.plugin.webview.luggage.c.c.ane(paramAnonymousString)) {
              if ((Util.isNullOrNil(paramAnonymousString)) || (!paramAnonymousString.equalsIgnoreCase("about:blank"))) {
                break label74;
              }
            }
            for (;;)
            {
              if (i == 0) {
                g.this.eA(paramAnonymousString, 0);
              }
              g.this.crX.Oy();
              AppMethodBeat.o(227301);
              return;
              label74:
              i = 0;
            }
          }
          
          public final View getVideoLoadingProgressView()
          {
            AppMethodBeat.i(227316);
            Log.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
            if (g.h(g.this) == null)
            {
              g.a(g.this, new ProgressBar(g.this.mContext));
              g.h(g.this).setIndeterminate(true);
            }
            ProgressBar localProgressBar = g.h(g.this);
            AppMethodBeat.o(227316);
            return localProgressBar;
          }
          
          public final boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
          {
            return false;
          }
          
          public final void onHideCustomView()
          {
            AppMethodBeat.i(227313);
            Log.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
            if (g.f(g.this) == null)
            {
              AppMethodBeat.o(227313);
              return;
            }
            try
            {
              g.this.PPw.setVisibility(0);
              if (g.g(g.this) != null) {
                g.g(g.this).onCustomViewHidden();
              }
              g.this.PPg.setVisibility(0);
              if (g.f(g.this) != null) {
                g.this.mRootView.removeView(g.f(g.this));
              }
              g.f(g.this).removeAllViews();
              g.a(g.this, null);
              AppMethodBeat.o(227313);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + localException.getMessage());
              AppMethodBeat.o(227313);
            }
          }
          
          public final void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
          {
            AppMethodBeat.i(227310);
            Log.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
            try
            {
              if (g.f(g.this) != null)
              {
                paramAnonymousCustomViewCallback.onCustomViewHidden();
                AppMethodBeat.o(227310);
                return;
              }
              g.a(g.this, new FrameLayout(g.this.mContext));
              g.f(g.this).setBackgroundResource(c.c.webview_logo_bg_color);
              g.f(g.this).addView(paramAnonymousView);
              g.a(g.this, paramAnonymousCustomViewCallback);
              g.this.PPw.setVisibility(8);
              g.this.PPg.setVisibility(8);
              g.this.mRootView.addView(g.f(g.this));
              AppMethodBeat.o(227310);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + paramAnonymousView.getMessage());
              AppMethodBeat.o(227310);
            }
          }
        });
      }
      a(this.PQe);
      paramj = this.crl;
      paramp = new l.a()
      {
        public final boolean onBackPressed()
        {
          AppMethodBeat.i(78236);
          if (g.this.gUw())
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.PPI != null) && (g.this.PPI.Q(1, true)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          if ((g.this.PPH != null) && (g.this.PPH.zH(2)))
          {
            AppMethodBeat.o(78236);
            return true;
          }
          AppMethodBeat.o(78236);
          return false;
        }
      };
      paramj.crE.put(paramp, Boolean.FALSE);
      AppMethodBeat.o(78282);
      return;
      bool = false;
    }
  }
  
  private void anL(int paramInt)
  {
    AppMethodBeat.i(78300);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.PPA.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.PPA.setLayoutParams(localMarginLayoutParams);
    }
    int i = paramInt;
    if (this.PPA.isShown()) {
      i = paramInt + this.PPA.getHeight();
    }
    this.PPw.setPadding(this.PPw.getPaddingLeft(), this.PPw.getPaddingTop(), this.PPw.getPaddingRight(), i);
    AppMethodBeat.o(78300);
  }
  
  public final void CX(boolean paramBoolean)
  {
    AppMethodBeat.i(245779);
    if (!paramBoolean)
    {
      this.PPA.hide();
      AppMethodBeat.o(245779);
      return;
    }
    if (!this.PPA.isShown())
    {
      this.PPA.reset();
      this.PPA.hcd();
      this.PPA.show();
    }
    AppMethodBeat.o(245779);
  }
  
  protected void G(int paramInt, String paramString1, String paramString2) {}
  
  public View NW()
  {
    AppMethodBeat.i(78283);
    Object localObject = cDu();
    this.PQa = new a((byte)0);
    localObject = Uri.parse((String)localObject);
    if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersiveUIStyle")).equals("1")) {
      this.PQa.PQp = true;
    }
    if (Util.nullAsNil(((Uri)localObject).getQueryParameter("immersivePageBgIsDark")).equals("1"))
    {
      this.PQa.PQq = true;
      if (Util.nullAsNil(((Uri)localObject).getQueryParameter("hide_share_option")).equals("1")) {
        this.PQa.PQr = true;
      }
      this.PPv = ((com.tencent.mm.plugin.webview.luggage.d.a)this.crX.Ow());
      this.PPw = new l(getContext(), super.NW());
      this.PPv.setCompetitorView(this.PPw);
      this.PPv.setSource(this.mParams.getString("KPublisherId"));
      this.mRootView = new FrameLayout(getContext());
      this.PPx = new b(getContext());
      this.PPx.setBackgroundColor(androidx.core.content.a.w(getContext(), c.c.white));
      this.mRootView.addView(this.PPx, new FrameLayout.LayoutParams(-1, -1));
      localObject = com.tencent.mm.ui.ad.kS(getContext()).inflate(c.g.luggage_mm_page, this.PPx, false);
      ewU();
      if (!ewJ().booleanValue()) {
        break label671;
      }
      this.PPx.addView((View)localObject);
    }
    for (;;)
    {
      if (this.PQa.PQr) {
        this.PPg.CY(true);
      }
      this.PPx.setActionBar(this.PPg);
      this.PPx.setWebView(this.PPv);
      this.PPE = ((FrameLayout)((View)localObject).findViewById(c.f.container));
      this.PPC = ((MMFalseProgressBar)((View)localObject).findViewById(c.f.web_falseprogress));
      this.PPD = ((MovingImageButton)((View)localObject).findViewById(c.f.full_screen_menu));
      this.PPD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(78257);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          g.this.bXF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(78257);
        }
      });
      this.PPy = ((WebViewKeyboardLinearLayout)((View)localObject).findViewById(c.f.game_webview_keyboard_ll));
      this.PPF = ((FrameLayout)((View)localObject).findViewById(c.f.web_container));
      this.PPF.addView(this.PPw, new ViewGroup.LayoutParams(-1, -1));
      this.PPz = ((WebViewInputFooter)((View)localObject).findViewById(c.f.webview_input_footer));
      this.PPz.hide();
      this.PPz.setOnTextSendListener(new WebViewInputFooter.c()
      {
        public final void gUP()
        {
          AppMethodBeat.i(257556);
          g.gUH();
          if (g.b(g.this) != null) {
            g.b(g.this).hide();
          }
          AppMethodBeat.o(257556);
        }
      });
      this.PPz.setOnSmileyChosenListener(new WebViewInputFooter.a()
      {
        public final boolean dO(final String paramAnonymousString)
        {
          AppMethodBeat.i(246226);
          g.this.crX.a(new com.tencent.luggage.d.d()
          {
            public final JSONObject NU()
            {
              AppMethodBeat.i(222800);
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("smiley", paramAnonymousString);
                label24:
                AppMethodBeat.o(222800);
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
          AppMethodBeat.o(246226);
          return true;
        }
      });
      this.PPz.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b()
      {
        public final void gUK()
        {
          AppMethodBeat.i(215877);
          g.this.anK(0);
          AppMethodBeat.o(215877);
        }
        
        public final void gUL()
        {
          AppMethodBeat.i(215879);
          if ((g.c(g.this) != null) && (g.c(g.this).getKeyBoardHeight() > 0)) {
            g.this.anK(g.c(g.this).getKeyBoardHeight());
          }
          AppMethodBeat.o(215879);
        }
      });
      this.PPA = ((WebViewSearchContentInputFooter)((View)localObject).findViewById(c.f.search_content_input_footer));
      this.PPA.setActionDelegate(new WebViewSearchContentInputFooter.a()
      {
        public final void a(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(257887);
          if (paramAnonymousWebViewSearchContentInputFooter.getVisibility() == 0) {
            b(paramAnonymousWebViewSearchContentInputFooter);
          }
          AppMethodBeat.o(257887);
        }
        
        public final void b(WebViewSearchContentInputFooter paramAnonymousWebViewSearchContentInputFooter)
        {
          AppMethodBeat.i(257890);
          g.this.PPv.clearMatches();
          paramAnonymousWebViewSearchContentInputFooter.reset();
          g.d(g.this).O(0, 0, true);
          g.this.PPv.findAllAsync(paramAnonymousWebViewSearchContentInputFooter.getSearchContent());
          AppMethodBeat.o(257890);
        }
        
        public final boolean c(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return false;
        }
        
        public final void gUM()
        {
          AppMethodBeat.i(257886);
          g.a(g.this, 0);
          g.this.PPv.clearMatches();
          g.d(g.this).hcd();
          AppMethodBeat.o(257886);
        }
        
        public final void gUN()
        {
          AppMethodBeat.i(257888);
          g.this.PPv.findNext(false);
          AppMethodBeat.o(257888);
        }
        
        public final void gUO()
        {
          AppMethodBeat.i(257889);
          g.this.PPv.findNext(true);
          AppMethodBeat.o(257889);
        }
      });
      this.PPv.setFindListener(new WebView.FindListener()
      {
        public final void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(223469);
          g.d(g.this).O(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          AppMethodBeat.o(223469);
        }
      });
      this.PPB = ((FrameLayout)((View)localObject).findViewById(c.f.refresh_mask));
      if (this.PPB != null) {
        this.PPB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(78274);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            g.this.crX.loadUrl(g.this.getUrl());
            g.a(g.this).setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(78274);
          }
        });
      }
      this.PPy.setOnkbdStateListener(new KeyboardLinearLayout.a()
      {
        public final void SG(int paramAnonymousInt)
        {
          AppMethodBeat.i(217401);
          Log.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(paramAnonymousInt)));
          if (!g.this.mIsForeground)
          {
            Log.i("MicroMsg.LuggageMMWebPage", "background ignored");
            AppMethodBeat.o(217401);
            return;
          }
          g.a(g.this, g.c(g.this), paramAnonymousInt);
          if (paramAnonymousInt == -3)
          {
            if ((g.b(g.this) != null) && (g.b(g.this).getVisibility() == 0))
            {
              WebViewInputFooter localWebViewInputFooter = g.b(g.this);
              if (localWebViewInputFooter.Qza) {
                localWebViewInputFooter.setVisibility(8);
              }
              localWebViewInputFooter.state = 0;
              localWebViewInputFooter.aDL();
            }
            g.a(g.this, g.c(g.this).getKeyBoardHeight());
            AppMethodBeat.o(217401);
            return;
          }
          g.a(g.this, 0);
          AppMethodBeat.o(217401);
        }
      });
      this.PPv.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78275);
          if (g.b(g.this).isShown()) {
            g.b(g.this).hide();
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            g.this.syc = ((int)paramAnonymousMotionEvent.getRawX());
            g.this.syd = ((int)paramAnonymousMotionEvent.getRawY());
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
        if (ar.isDarkMode())
        {
          this.PQa.PQq = true;
          break;
        }
        this.PQa.PQq = false;
        break;
      }
      this.PQa.PQq = false;
      break;
      label671:
      b localb = this.PPx;
      m localm = this.PPg;
      boolean bool = this.PQa.PQp;
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
  
  public String Oz()
  {
    AppMethodBeat.i(78317);
    String str = com.tencent.mm.plugin.appbrand.ac.d.anc("luggage_mm_adapter.js");
    AppMethodBeat.o(78317);
    return str;
  }
  
  public final boolean QT()
  {
    AppMethodBeat.i(78303);
    boolean bool = this.mParams.getBoolean("show_full_screen", false);
    AppMethodBeat.o(78303);
    return bool;
  }
  
  public boolean Tv(int paramInt)
  {
    AppMethodBeat.i(78302);
    boolean bool = this.PPN.ha(getUrl(), paramInt);
    AppMethodBeat.o(78302);
    return bool;
  }
  
  public final void aI(Runnable paramRunnable)
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
  
  protected void aJA(String paramString) {}
  
  protected void aJt(String paramString)
  {
    AppMethodBeat.i(78312);
    if (this.PPv.getX5WebViewExtension() != null)
    {
      this.PPw.setPullDownEnabled(true);
      this.PPw.setCurrentUrl(paramString);
    }
    AppMethodBeat.o(78312);
  }
  
  protected boolean aJv(String paramString)
  {
    return false;
  }
  
  protected boolean aJx(String paramString)
  {
    AppMethodBeat.i(78319);
    if (this.PPN.blD(paramString))
    {
      this.PPR = true;
      AppMethodBeat.o(78319);
      return false;
    }
    if (this.PPN.a(paramString, this.PQd) == c.a.PYJ) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", new Object[] { paramString, Boolean.valueOf(bool) });
      this.PPR = bool;
      AppMethodBeat.o(78319);
      return bool;
    }
  }
  
  protected void aJy(String paramString)
  {
    AppMethodBeat.i(78314);
    Log.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.PPv.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(78314);
  }
  
  protected WebResourceResponse aJz(String paramString)
  {
    return null;
  }
  
  public final void anK(int paramInt)
  {
    AppMethodBeat.i(78299);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.PPz.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt)
    {
      localMarginLayoutParams.bottomMargin = paramInt;
      this.PPz.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(78299);
  }
  
  public final void b(String paramString, final float paramFloat, int paramInt)
  {
    AppMethodBeat.i(245773);
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      int i = Color.parseColor(paramString);
      this.PPS = true;
      this.PPT = (i | 0xFF000000);
      this.PPg.setActionBarColorValue(this.PPT);
      label45:
      this.PPg.setIconDark(paramInt);
      if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      {
        gUu();
        AppMethodBeat.o(245773);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78278);
          g.this.PPg.setAlpha(paramFloat);
          AppMethodBeat.o(78278);
        }
      });
      AppMethodBeat.o(245773);
      return;
    }
    catch (Exception paramString)
    {
      break label45;
    }
  }
  
  public final void bOL()
  {
    AppMethodBeat.i(78297);
    this.PPT = androidx.core.content.a.w(getContext(), c.c.action_bar_color);
    this.PPg.PQM = -1;
    gUu();
    AppMethodBeat.o(78297);
  }
  
  protected void bXF()
  {
    AppMethodBeat.i(78285);
    this.PPg.bXF();
    AppMethodBeat.o(78285);
  }
  
  protected final void bkl(final String paramString)
  {
    AppMethodBeat.i(78293);
    this.crX.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject NU()
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
  
  protected final boolean bkm(String paramString)
  {
    AppMethodBeat.i(78320);
    if (this.PPN.a(paramString, 5, this.PQd) == c.a.PYJ)
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
      if (!aJv(paramString))
      {
        this.PPB.setVisibility(0);
        ewK();
      }
    }
  }
  
  protected void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(78321);
    Log.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(this.CzZ)) {
      this.CzZ = paramString2;
    }
    this.PPQ = paramMap;
    if ((!aJv(paramString1)) && (!this.PPU) && (!this.PPY))
    {
      this.crX.stopLoading();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        this.crX.crP.loadUrl(paramString2, paramMap);
        AppMethodBeat.o(78321);
        return;
      }
      this.crX.loadUrl(paramString2);
    }
    AppMethodBeat.o(78321);
  }
  
  public final String cCL()
  {
    return this.CzZ;
  }
  
  protected boolean cDX()
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
  
  public final String cDu()
  {
    AppMethodBeat.i(78318);
    String str = this.mParams.getString("rawUrl");
    AppMethodBeat.o(78318);
    return str;
  }
  
  public final void dt(String paramString)
  {
    AppMethodBeat.i(245782);
    if (this.PPv != null) {
      this.PPv.evaluateJavascript(paramString, null);
    }
    AppMethodBeat.o(245782);
  }
  
  protected void dv(String paramString)
  {
    AppMethodBeat.i(78315);
    Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(paramString)));
    if (aJx(paramString))
    {
      int i = this.PPN.dc(paramString, false);
      if ((i == 0) || (i == 2) || (i == 8))
      {
        this.crX.stopLoading();
        AppMethodBeat.o(78315);
        return;
      }
    }
    com.tencent.mm.plugin.webview.model.a.f(this.PPv);
    if (this.PPH != null)
    {
      this.PPH.fi("rawUrl", paramString);
      this.PPH.bko(paramString);
    }
    if (this.PPJ != null)
    {
      this.PPJ.setUrl(Util.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.PPJ);
    }
    this.PPg.setOptionEnable(false);
    dwZ();
    aJt(paramString);
    AppMethodBeat.o(78315);
  }
  
  protected void dw(String paramString)
  {
    AppMethodBeat.i(78316);
    Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.webview.model.a.f(this.PPv);
    this.PPg.setOptionEnable(true);
    ewK();
    if (this.PPH != null)
    {
      this.PPH.fi("rawUrl", paramString);
      this.PPH.bko(paramString);
    }
    if (this.PPJ != null)
    {
      this.PPJ.setUrl(Util.nullAsNil(paramString));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.PPJ);
    }
    AppMethodBeat.o(78316);
  }
  
  protected void dwZ()
  {
    AppMethodBeat.i(78310);
    this.PPC.setVisibility(0);
    this.PPC.start();
    AppMethodBeat.o(78310);
  }
  
  public void eA(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(78298);
    if (this.PPX) {
      this.PPH.aoy(paramString);
    }
    this.PPI.aMT(paramString);
    if (this.PPJ != null)
    {
      this.PPJ.setTitle(paramString);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.PPJ);
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219330);
        if (g.this.PPg != null)
        {
          if (!Util.isNullOrNil(paramString)) {
            g.this.PPg.setTitleText(paramString);
          }
          if (paramInt != 0) {
            g.this.PPg.setTitleColor(paramInt);
          }
        }
        AppMethodBeat.o(219330);
      }
    });
    AppMethodBeat.o(78298);
  }
  
  public final void ePB()
  {
    AppMethodBeat.i(78306);
    this.PPg.setVisibility(8);
    AppMethodBeat.o(78306);
  }
  
  protected Boolean ewJ()
  {
    return Boolean.FALSE;
  }
  
  protected void ewK()
  {
    AppMethodBeat.i(78311);
    this.PPC.finish();
    this.PPC.setVisibility(8);
    AppMethodBeat.o(78311);
  }
  
  protected View ewU()
  {
    AppMethodBeat.i(78284);
    this.PPg = new m(this);
    m localm = this.PPg;
    AppMethodBeat.o(78284);
    return localm;
  }
  
  protected void ewV()
  {
    AppMethodBeat.i(78294);
    if (!this.PPS)
    {
      this.PPT = this.mParams.getInt("customize_status_bar_color");
      if (this.PPT == 0) {
        this.PPT = androidx.core.content.a.w(getContext(), c.c.action_bar_color);
      }
    }
    gUu();
    AppMethodBeat.o(78294);
  }
  
  public final com.tencent.mm.plugin.webview.f.c gUA()
  {
    return this.PPN;
  }
  
  public final q.a gUB()
  {
    return this.PPP;
  }
  
  public final boolean gUC()
  {
    AppMethodBeat.i(78324);
    boolean bool1 = this.mParams.getBoolean("forceHideShare", false);
    boolean bool2 = this.mParams.getBoolean("showShare", true);
    Log.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(cDX()) });
    if ((!bool1) && (bool2) && (cDX()))
    {
      AppMethodBeat.o(78324);
      return true;
    }
    AppMethodBeat.o(78324);
    return false;
  }
  
  public final q gUD()
  {
    return this.PPH;
  }
  
  public final t gUE()
  {
    return this.PPI;
  }
  
  public final HandOffURL gUF()
  {
    return this.PPJ;
  }
  
  public final void gUG()
  {
    AppMethodBeat.i(78326);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      int i = this.crm.On().indexOf(this);
      if (i < 0)
      {
        AppMethodBeat.o(78326);
        return;
      }
      if (!this.crm.Oo().remove(i))
      {
        this.crm.Oq().finish();
        AppMethodBeat.o(78326);
        return;
      }
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78273);
          com.tencent.luggage.d.h localh = (com.tencent.luggage.d.h)g.this.crm.On().peek();
          if ((localh != null) && ((localh instanceof g))) {
            g.i((g)localh);
          }
          AppMethodBeat.o(78273);
        }
      }, 250L);
      AppMethodBeat.o(78326);
      return;
    }
    com.tencent.mm.ipcinvoker.s.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258311);
        g.this.gUG();
        AppMethodBeat.o(258311);
      }
    });
    AppMethodBeat.o(78326);
  }
  
  public final void gUs()
  {
    AppMethodBeat.i(78286);
    Log.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
    String str = this.mParams.getString("float_ball_key");
    if (!Util.isNullOrNil(str))
    {
      this.PPH.I(5, str);
      this.PPI.I(5, str);
    }
    for (;;)
    {
      this.PPH.fi("rawUrl", cDu());
      this.PPH.bko(cDu());
      if (Util.isNullOrNil(this.PPg.getTitle())) {
        this.PPH.aoy(cDu());
      }
      this.PPX = true;
      if (this.PPW)
      {
        this.PPH.bNV();
        this.PPI.bNV();
      }
      this.PPJ = new HandOffURL(Util.nullAsNil(cDu()), Util.nullAsNil(cDu()), "");
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).a(this.PPJ);
      gUt();
      AppMethodBeat.o(78286);
      return;
      this.PPH.I(5, com.tencent.mm.plugin.ball.f.b.aoB(cDu()));
      this.PPI.I(5, com.tencent.mm.plugin.multitask.g.aQU(((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apf(cDu())));
    }
  }
  
  public final void gUt()
  {
    AppMethodBeat.i(245772);
    int i = this.mParams.getInt("screen_orientation", -1);
    if (this.crm.On().peek() == this) {
      ((Activity)getContext()).setRequestedOrientation(i);
    }
    AppMethodBeat.o(245772);
  }
  
  protected final void gUu()
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
          g.this.gUu();
          AppMethodBeat.o(78277);
        }
      });
      AppMethodBeat.o(78295);
      return;
    }
    this.PPg.n(this.PPT, this.PQa.PQp, this.PQa.PQq);
    AppMethodBeat.o(78295);
  }
  
  public final boolean gUv()
  {
    AppMethodBeat.i(245778);
    boolean bool = this.PPA.isShown();
    AppMethodBeat.o(245778);
    return bool;
  }
  
  public final boolean gUw()
  {
    AppMethodBeat.i(78304);
    if (this.PPg != null)
    {
      boolean bool = this.PPg.gUw();
      AppMethodBeat.o(78304);
      return bool;
    }
    AppMethodBeat.o(78304);
    return false;
  }
  
  public final m gUx()
  {
    return this.PPg;
  }
  
  public final void gUy()
  {
    AppMethodBeat.i(78309);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215959);
        g.this.PPw.setPullDownEnabled(false);
        AppMethodBeat.o(215959);
      }
    });
    AppMethodBeat.o(78309);
  }
  
  public final boolean gUz()
  {
    return this.PPR;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(293194);
    String str = this.PPg.getTitle();
    AppMethodBeat.o(293194);
    return str;
  }
  
  public final String getUrl()
  {
    if (this.crX != null) {
      return this.crX.mUrl;
    }
    return "";
  }
  
  public final void hS(final boolean paramBoolean)
  {
    AppMethodBeat.i(78327);
    if ((this.PPH != null) && (this.PPH.zH(1)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if ((this.PPI != null) && (this.PPI.Q(1, true)))
    {
      AppMethodBeat.o(78327);
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (!this.crm.Oo().cb(paramBoolean))
      {
        this.crm.Oq().finish();
        AppMethodBeat.o(78327);
      }
    }
    else {
      com.tencent.mm.ipcinvoker.s.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215346);
          g.this.hS(paramBoolean);
          AppMethodBeat.o(215346);
        }
      });
    }
    AppMethodBeat.o(78327);
  }
  
  public void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78313);
    Log.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", new Object[] { paramString, Boolean.valueOf(this.PPU) });
    this.crX.mUrl = paramString;
    if (this.PPU)
    {
      Log.i("MicroMsg.LuggageMMWebPage", "stash url");
      this.PPg.setOptionEnable(true);
      if (!Util.isNullOrNil(this.mParams.getString("title"))) {
        eA(this.mParams.getString("title"), 0);
      }
      this.pFW = false;
      if (this.PPN == null) {
        this.PPN = new com.tencent.mm.plugin.webview.f.c();
      }
      aJx(paramString);
      AppMethodBeat.o(78313);
      return;
    }
    dwZ();
    paramBundle = paramBundle.getString("game_open_html");
    if (!Util.isNullOrNil(paramBundle))
    {
      this.PPY = true;
      this.PPv.loadDataWithBaseURL(paramString, paramBundle, "text/html", "utf-8", null);
    }
    do
    {
      for (;;)
      {
        aJx(paramString);
        this.pFW = false;
        AppMethodBeat.o(78313);
        return;
        if (!aJv(paramString)) {
          break;
        }
        aJy(paramString);
      }
    } while (this.pFW);
    l(paramString, null);
    AppMethodBeat.o(78313);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(78288);
    Log.i("MicroMsg.LuggageMMWebPage", "onBackground");
    this.PPW = false;
    bkl("onPause");
    this.PPg.ewQ();
    this.PPv.onPause();
    this.mIsForeground = false;
    if (this.PPH != null) {
      this.PPH.aOj();
    }
    if (this.PPI != null) {
      this.PPI.aOj();
    }
    AppMethodBeat.o(78288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(78289);
    if (!this.CDM)
    {
      this.CDM = true;
      Log.i("MicroMsg.LuggageMMWebPage", "onDestroy");
      this.PPG.PPn = null;
      j.c(this);
      this.mRootView.removeAllViews();
      this.crX.setContext(MMApplicationContext.getContext());
      if (this.PPH != null) {
        this.PPH.onDestroy();
      }
      if (this.PPI != null)
      {
        if (!this.PPI.faQ()) {
          break label151;
        }
        r.a(this.PPI.bsL(), this.crX, this.PPN);
      }
    }
    for (;;)
    {
      if (this.PPJ != null) {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).b(this.PPJ);
      }
      this.PPN.PFQ = true;
      this.PPg.onDestroy();
      AppMethodBeat.o(78289);
      return;
      label151:
      bkl("onDestroy");
    }
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(78287);
    if (this.PPW)
    {
      AppMethodBeat.o(78287);
      return;
    }
    this.PPW = true;
    Log.i("MicroMsg.LuggageMMWebPage", "onForeground");
    if (this.PPV)
    {
      hS(false);
      AppMethodBeat.o(78287);
      return;
    }
    gUt();
    sg(QT());
    ewV();
    bkl("onResume");
    this.PPv.onResume();
    this.mIsForeground = true;
    anL(0);
    if (this.PPX)
    {
      this.PPH.bNV();
      this.PPI.bNV();
    }
    this.PPg.onForeground();
    AppMethodBeat.o(78287);
  }
  
  public void reload()
  {
    AppMethodBeat.i(78290);
    this.PPv.reload();
    AppMethodBeat.o(78290);
  }
  
  protected void sg(boolean paramBoolean)
  {
    AppMethodBeat.i(78292);
    if (paramBoolean)
    {
      this.PPg.setVisibility(8);
      this.PPD.setVisibility(0);
      com.tencent.mm.plugin.webview.luggage.c.b.c(((Activity)getContext()).getWindow(), true);
      AppMethodBeat.o(78292);
      return;
    }
    this.PPg.setVisibility(0);
    this.PPD.setVisibility(8);
    com.tencent.mm.plugin.webview.luggage.c.b.c(((Activity)getContext()).getWindow(), false);
    AppMethodBeat.o(78292);
  }
  
  static final class a
  {
    boolean PQp;
    boolean PQq;
    boolean PQr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.g
 * JD-Core Version:    0.7.0.1
 */