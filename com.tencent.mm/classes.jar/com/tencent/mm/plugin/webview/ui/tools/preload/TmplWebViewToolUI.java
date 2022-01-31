package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.n;
import com.tencent.xweb.p;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TmplWebViewToolUI
  extends WebViewUI
{
  private String kpt;
  private c rBA;
  private a rBB;
  private boolean rBC = false;
  private Map<String, String> rBD;
  protected WebViewUI.i rBE = new TmplWebViewToolUI.2(this);
  private TmplParams riT;
  
  protected final void Ti(String paramString)
  {
    this.rBB.Ti(paramString);
  }
  
  protected final boolean U(Bundle paramBundle)
  {
    this.rBB.ag(paramBundle);
    return super.U(paramBundle);
  }
  
  protected final boolean aYK()
  {
    return true;
  }
  
  protected final MMWebView bZI()
  {
    if (!this.rBB.cgF()) {
      return super.bZI();
    }
    return this.rBA;
  }
  
  protected final WebViewUI.x bo(String paramString, boolean paramBoolean)
  {
    this.rBB.TZ(paramString);
    return super.bo(paramString, paramBoolean);
  }
  
  protected final p cdX()
  {
    if (!this.rBB.cgH()) {
      return super.cdX();
    }
    return this.rBE;
  }
  
  protected final boolean cea()
  {
    if (this.rBB.cea()) {
      return false;
    }
    return super.cea();
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.jsapi.d cec()
  {
    if (!this.rBB.cgG()) {
      return super.cec();
    }
    this.rBA.getJsApiHandler().gGn = this.gGn;
    this.rBA.getJsApiHandler().rjN = hashCode();
    this.rBA.getJsApiHandler().rxH = this.gGo;
    this.gGo.a(this.rBA.rfY, JsapiPermissionWrapper.spm, GeneralControlWrapper.spk);
    return this.rBA.getJsApiHandler();
  }
  
  protected final boolean cee()
  {
    return false;
  }
  
  protected final boolean cef()
  {
    return true;
  }
  
  protected final void ceq()
  {
    this.rBB.ceq();
  }
  
  protected final boolean cey()
  {
    return false;
  }
  
  protected final void g(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.rBB.g(paramString1, paramString2, paramMap);
  }
  
  protected final void h(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (this.rBB.i(paramString1, paramString2, paramMap))
    {
      this.rBC = true;
      this.kpt = paramString2;
      this.rBD = paramMap;
      return;
    }
    super.h(paramString1, paramString2, paramMap);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.riT = ((TmplParams)getIntent().getParcelableExtra(e.j.uHX));
    if ((this.riT == null) || (bk.bl(this.riT.rjA)))
    {
      y.i("MicroMsg.WebviewUIForTmpl", "initTmpl() tmplParams is null");
      this.rBB = new a.a();
      com.tencent.mm.plugin.webview.preload.a.jdMethod_if(109);
    }
    for (;;)
    {
      this.rBB.cgD();
      super.onCreate(paramBundle);
      this.rBB.cgE();
      return;
      y.i("MicroMsg.WebviewUIForTmpl", "initTmpl() TmplController");
      this.rBB = new b((byte)0);
    }
  }
  
  private final class b
    implements a
  {
    private long rBH;
    private boolean rBI = false;
    com.tencent.mm.plugin.webview.preload.c rBJ = new com.tencent.mm.plugin.webview.preload.c();
    Runnable rBK = new TmplWebViewToolUI.b.1(this);
    Runnable rBL = new TmplWebViewToolUI.b.2(this);
    long rBh;
    long rBi;
    private boolean rje = true;
    
    private b() {}
    
    private static String Ub(String paramString)
    {
      return paramString.replaceFirst("http://", "https://");
    }
    
    public final void TZ(String paramString)
    {
      if (paramString.equals(TmplWebViewToolUI.q(TmplWebViewToolUI.this)))
      {
        com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 116, 1);
        this.rBJ.rjc = System.currentTimeMillis();
      }
    }
    
    public final void Ti(String paramString)
    {
      y.i("MicroMsg.WebviewUIForTmpl", "[notifyPageInfo]pageInfo:%s", new Object[] { paramString });
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject(paramString.optString("performance"));
        long l1 = localJSONObject.getLong("compileTime");
        long l2 = localJSONObject.getLong("receivePageDataTimestamp");
        long l3 = localJSONObject.getLong("firstScreenTimestamp");
        long l4 = localJSONObject.getLong("firstScreenTime");
        this.rBJ.rjb = l1;
        this.rBJ.rja = l2;
        this.rBJ.rjf = l3;
        this.rBJ.rjg = l4;
        if (paramString.optString("injectPageDataResult", "fail").equals("ok"))
        {
          this.rBJ.rji = true;
          this.rBJ.wn();
          com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 131, 1);
          return;
        }
        this.rBJ.rjs = true;
        TmplWebViewToolUI.k(TmplWebViewToolUI.this);
        return;
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("MicroMsg.WebviewUIForTmpl", paramString, "", new Object[0]);
        this.rBJ.rjs = true;
        TmplWebViewToolUI.k(TmplWebViewToolUI.this);
      }
    }
    
    public final void ag(Bundle paramBundle)
    {
      String str = paramBundle.getString("geta8key_result_full_url");
      if (str.startsWith("http://"))
      {
        JsapiPermissionWrapper localJsapiPermissionWrapper = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
        paramBundle = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
        TmplWebViewToolUI.r(TmplWebViewToolUI.this).a(Ub(str), localJsapiPermissionWrapper, paramBundle);
      }
    }
    
    public final boolean cea()
    {
      return true;
    }
    
    public final void ceq()
    {
      com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 118, 1);
      this.rBJ.rjd = System.currentTimeMillis();
      TmplWebViewToolUI.h(TmplWebViewToolUI.this).o(false, "");
    }
    
    public final void cgD()
    {
      TmplWebViewToolUI.this.getIntent().putExtra("show_native_web_view", true);
      ai.l(this.rBL, 500L);
      TmplWebViewToolUI.a(TmplWebViewToolUI.this, (c)e.a(TmplWebViewToolUI.this, TmplWebViewToolUI.c(TmplWebViewToolUI.this)));
      String str1;
      Object localObject;
      int i;
      String str2;
      int j;
      int k;
      if (TmplWebViewToolUI.h(TmplWebViewToolUI.this) == null)
      {
        TmplWebViewToolUI.a(TmplWebViewToolUI.this, (c)e.b(TmplWebViewToolUI.this, TmplWebViewToolUI.c(TmplWebViewToolUI.this)));
        this.rje = false;
        com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 111, 1);
        this.rBH = System.currentTimeMillis();
        this.rBh = TmplWebViewToolUI.this.getIntent().getLongExtra(e.j.uHZ, 0L);
        str1 = TmplWebViewToolUI.this.getIntent().getStringExtra(e.j.uIb);
        localObject = TmplWebViewToolUI.this.getIntent().getStringExtra(e.j.uHW);
        this.rBJ.riV = this.rBh;
        this.rBJ.riY = this.rBH;
        i = TmplWebViewToolUI.this.getIntent().getIntExtra("geta8key_scene", 0);
        str2 = TmplWebViewToolUI.this.getIntent().getIntExtra(e.j.uIc, -1);
        j = TmplWebViewToolUI.this.getIntent().getIntExtra(e.j.uId, -1);
        k = TmplWebViewToolUI.this.getIntent().getIntExtra(e.j.uIe, -1);
        if (bk.bl((String)localObject)) {
          break label473;
        }
        y.i("MicroMsg.WebviewUIForTmpl", "[processData] data:%d", new Object[] { Integer.valueOf(((String)localObject).length()) });
        y.v("MicroMsg.WebviewUIForTmpl", "[processData] data:%s", new Object[] { localObject });
        this.rBI = true;
        this.rBJ.riU = ((String)localObject).length();
        this.rBi = System.currentTimeMillis();
        this.rBJ.riZ = this.rBi;
        ai.l(this.rBK, 5000L);
        ai.S(this.rBL);
        ((com.tencent.mm.plugin.brandservice.a.b)g.r(com.tencent.mm.plugin.brandservice.a.b.class)).a(TmplWebViewToolUI.m(TmplWebViewToolUI.this), i, str2, j, k);
        TmplWebViewToolUI.h(TmplWebViewToolUI.this).w((String)localObject, this.rBh, this.rBi);
        com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 121, 1);
      }
      for (;;)
      {
        if ((com.tencent.mm.sdk.platformtools.d.DEBUG) || (com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED) || (1 >= y.getLogLevel())) {
          TmplWebViewToolUI.a(TmplWebViewToolUI.this, new TmplWebViewToolUI.b.4(this));
        }
        return;
        com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 110, 1);
        break;
        label473:
        this.rBI = false;
        com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 122, 1);
        localObject = new Bundle();
        ((Bundle)localObject).putString("url", str1);
        ((Bundle)localObject).putInt("tmplVersion", TmplWebViewToolUI.c(TmplWebViewToolUI.this).version);
        y.i("MicroMsg.WebviewUIForTmpl", "[processData] data is null, request key:%s tmplVersion:%d", new Object[] { str1, Integer.valueOf(TmplWebViewToolUI.c(TmplWebViewToolUI.this).version) });
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", (Parcelable)localObject, TmplWebViewToolUI.a.class, new TmplWebViewToolUI.b.3(this, i, str2, j, k));
      }
    }
    
    public final void cgE()
    {
      y.i("MicroMsg.WebviewUIForTmpl", "afterCreate isUsePreloadWebView:%b state:%d", new Object[] { Boolean.valueOf(this.rje), Integer.valueOf(TmplWebViewToolUI.h(TmplWebViewToolUI.this).getState()) });
      TmplWebViewToolUI.h(TmplWebViewToolUI.this).setOnStateChange(new c.a()
      {
        public final void Dd(int paramAnonymousInt)
        {
          y.i("MicroMsg.WebviewUIForTmpl", "onStateChange state:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 5)
          {
            y.e("MicroMsg.WebviewUIForTmpl", "onReady fail, forceUseOriWebViewUI");
            TmplWebViewToolUI.b.this.rBJ.rjs = true;
            TmplWebViewToolUI.k(TmplWebViewToolUI.this);
          }
          do
          {
            return;
            if (paramAnonymousInt == 4)
            {
              TmplWebViewToolUI.b.this.rBJ.riW = TmplWebViewToolUI.h(TmplWebViewToolUI.this).riW;
              TmplWebViewToolUI.b localb = TmplWebViewToolUI.b.this;
              y.i("MicroMsg.WebviewUIForTmpl", "[supplyPageFinishInvoke]");
              ai.d(new TmplWebViewToolUI.b.6(localb));
              return;
            }
          } while (paramAnonymousInt != 2);
          y.w("MicroMsg.WebviewUIForTmpl", "onReady success");
        }
      });
      if (!this.rje)
      {
        TmplWebViewToolUI.h(TmplWebViewToolUI.this).cgI();
        TmplWebViewToolUI.h(TmplWebViewToolUI.this).cgJ();
      }
      for (;;)
      {
        this.rBJ.riT = TmplWebViewToolUI.c(TmplWebViewToolUI.this);
        this.rBJ.url = TmplWebViewToolUI.o(TmplWebViewToolUI.this);
        this.rBJ.rje = this.rje;
        this.rBJ.riX = this.rBI;
        this.rBJ.rjq = TmplWebViewToolUI.h(TmplWebViewToolUI.this).getWebCoreType().name();
        if (1 >= y.getLogLevel()) {
          Toast.makeText(TmplWebViewToolUI.this, "use preloaded webview:true", 0).show();
        }
        return;
        boolean bool = TmplWebViewToolUI.this.getIntent().getBooleanExtra(e.j.uHY, true);
        y.i("MicroMsg.WebviewUIForTmpl", "[preloadNextWebView] %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          ((com.tencent.mm.plugin.webview.preload.b)g.r(com.tencent.mm.plugin.webview.preload.b.class)).a(TmplWebViewToolUI.c(TmplWebViewToolUI.this));
        }
      }
    }
    
    public final boolean cgF()
    {
      return true;
    }
    
    public final boolean cgG()
    {
      return true;
    }
    
    public final boolean cgH()
    {
      return true;
    }
    
    public final void g(String paramString1, String paramString2, Map<String, String> paramMap)
    {
      y.i("MicroMsg.WebviewUIForTmpl", "[updatePageAuth]reqUrl:%s fullUrl:%s httpHeader:%s", new Object[] { paramString1, paramString2, paramMap });
      paramString1 = String.format("history.replaceState({},\"\",\"%s\");", new Object[] { Ub(paramString2) });
      TmplWebViewToolUI.h(TmplWebViewToolUI.this).evaluateJavascript(paramString1, null);
      paramMap.put("User-agent", TmplWebViewToolUI.h(TmplWebViewToolUI.this).getSettings().getUserAgentString());
      TmplWebViewToolUI.s(TmplWebViewToolUI.this).rxM = new JSONObject(paramMap).toString();
      paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
      TmplWebViewToolUI.t(TmplWebViewToolUI.this).rxL = paramString1;
    }
    
    public final boolean i(String paramString1, String paramString2, Map<String, String> paramMap)
    {
      com.tencent.mm.plugin.webview.preload.a.aa(TmplWebViewToolUI.c(TmplWebViewToolUI.this).rjC, 117, 1);
      this.rBJ.rjd = System.currentTimeMillis();
      this.rBJ.rjh = true;
      this.rBJ.wn();
      g(paramString1, paramString2, paramMap);
      TmplWebViewToolUI.h(TmplWebViewToolUI.this).o(true, Ub(paramString2));
      TmplWebViewToolUI.a(TmplWebViewToolUI.this, Ub(paramString2));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.TmplWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */