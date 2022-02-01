package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{
  private static final Pattern kgU;
  private boolean EDA;
  public boolean EDB;
  public boolean EDm;
  com.tencent.mm.plugin.wepkg.model.g EDn;
  private WepkgVersion EDo;
  private com.tencent.mm.plugin.wepkg.event.a EDp;
  private e EDq;
  private boolean EDr;
  private boolean EDs;
  public com.tencent.mm.plugin.wepkg.event.b EDt;
  private boolean EDu;
  private Set<String> EDv;
  private long EDw;
  public boolean EDx;
  private String EDy;
  private boolean EDz;
  private long aWS;
  private av cXg;
  private String tVg;
  private GameWebPerformanceInfo tVm;
  private String ucX;
  
  static
  {
    AppMethodBeat.i(110556);
    kgU = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public d()
  {
    AppMethodBeat.i(110539);
    this.aWS = 0L;
    this.EDm = false;
    this.EDr = false;
    this.EDs = false;
    this.EDu = false;
    this.EDv = new HashSet();
    this.EDx = true;
    this.EDB = false;
    c.eXx();
    this.EDq = new e();
    c.eXy();
    this.EDp = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.EEA != null) && (paramAnonymousObject.EEA.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.EEA;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.eXu())) || ((!bt.isNullOrNil(d.a(d.this))) && (str.equals(d.a(d.this)))))
              {
                d.a(d.this, str);
                AppMethodBeat.o(110535);
                return;
              }
              i += 1;
            }
          }
          AppMethodBeat.o(110535);
          return;
        }
        if ((paramAnonymousObject instanceof DownloadBigPkgCompleteNotify))
        {
          paramAnonymousObject = (DownloadBigPkgCompleteNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.gsn != null) && ((paramAnonymousObject.gsn.equals(a.eXu())) || (paramAnonymousObject.gsn.equals(d.a(d.this))))) {
            d.a(d.this, paramAnonymousObject.gsn, paramAnonymousObject.success, paramAnonymousObject.EEy);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.EDp);
    AppMethodBeat.o(110539);
  }
  
  private static boolean cI(String paramString)
  {
    AppMethodBeat.i(177085);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(177085);
      return false;
    }
    paramString = Uri.parse(paramString).getPath();
    if ((paramString != null) && (paramString.trim().endsWith("html")))
    {
      AppMethodBeat.o(177085);
      return true;
    }
    AppMethodBeat.o(177085);
    return false;
  }
  
  public static String eXG()
  {
    AppMethodBeat.i(221752);
    String str = a.eXv();
    AppMethodBeat.o(221752);
    return str;
  }
  
  private void eXH()
  {
    AppMethodBeat.i(214451);
    this.EDx = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).alq(this.ucX);
    AppMethodBeat.o(214451);
  }
  
  private void eXI()
  {
    AppMethodBeat.i(214452);
    this.cXg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(110538);
        if ((d.d(d.this)) && (!d.e(d.this)))
        {
          ad.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
          aq.f(new Runnable()
          {
            public final void run()
            {
              int i = 0;
              AppMethodBeat.i(110537);
              try
              {
                ad.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                if (!bt.isNullOrNil(d.this.eXD())) {
                  i = 1;
                }
                d.f(d.this);
                int j = d.eXJ();
                if (j > 1)
                {
                  if (d.g(d.this) != null)
                  {
                    if (i == 0) {
                      break label172;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", d.b(d.this), d.g(d.this).gsn, d.g(d.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 13L, 1L, false);
                    String str = com.tencent.mm.plugin.wepkg.utils.d.aKY(d.b(d.this));
                    c.TT(str);
                    com.tencent.mm.plugin.wepkg.model.c.eXW().aD(str, 1, 2);
                    d.eXK();
                    d.h(d.this);
                    AppMethodBeat.o(110537);
                    return;
                    label172:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", d.b(d.this), d.g(d.this).gsn, d.g(d.this).version, -1L, 0L, null);
                  }
                }
                d.XZ(j + 1);
              }
              catch (Exception localException)
              {
                AppMethodBeat.o(110537);
                return;
              }
              AppMethodBeat.o(110537);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(110538);
          return false;
          d.XZ(0);
        }
      }
    }, false);
    AppMethodBeat.o(214452);
  }
  
  private void p(final WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(214449);
    if ((!this.EDz) && (!cI(paramString)))
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110536);
          if (paramWebView != null)
          {
            Object localObject = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { String.valueOf(d.this.aKu(d.b(d.this))) });
            ad.i("MicroMsg.Wepkg.WePkgPlugin", "__usewepkg__: %s", new Object[] { localObject });
            paramWebView.evaluateJavascript((String)localObject, null);
            localObject = (PowerManager)aj.getContext().getSystemService("power");
            if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {}
            for (boolean bool = ((PowerManager)localObject).isPowerSaveMode();; bool = false)
            {
              localObject = String.format("javascript:(function() {window.__lowPowerMode__=%s;})();", new Object[] { String.valueOf(bool) });
              ad.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPowerMode__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__lowPower__=%s;})();", new Object[] { String.valueOf(BatteryManager.tSV) });
              ad.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPower__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__game_center_preload__=%s;})();", new Object[] { String.valueOf(d.c(d.this)) });
              ad.i("MicroMsg.Wepkg.WePkgPlugin", "__game_center_preload__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              AppMethodBeat.o(110536);
              return;
            }
          }
          ad.i("MicroMsg.Wepkg.WePkgPlugin", "injectGameJs, webview == null");
          AppMethodBeat.o(110536);
        }
      });
      this.EDz = true;
    }
    AppMethodBeat.o(214449);
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.EDs = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!bt.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.EDr = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final void aKt(String paramString)
  {
    AppMethodBeat.i(214447);
    ad.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aWS = System.currentTimeMillis();
    AppMethodBeat.o(214447);
  }
  
  public final boolean aKu(String paramString)
  {
    AppMethodBeat.i(110549);
    if (kgU.matcher(bt.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.EDm;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final String eXD()
  {
    if (!this.EDm) {
      this.EDy = null;
    }
    return this.EDy;
  }
  
  public final boolean eXE()
  {
    return (this.EDo == null) || (!this.EDo.EFB);
  }
  
  public final String eXF()
  {
    if (this.EDo != null) {
      return this.EDo.version;
    }
    return "";
  }
  
  public final boolean k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(214446);
    this.EDA = paramBoolean2;
    this.tVg = paramString;
    this.ucX = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
    Object localObject = c.cv(paramString, paramBoolean1);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.g)localObject).eXV())
      {
        this.EDn = ((com.tencent.mm.plugin.wepkg.model.g)localObject);
        this.EDm = true;
        this.EDo = this.EDn.EET;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.tVg, this.ucX, this.EDo.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.tVg, this.ucX, this.EDo.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).EEF) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.tVg, this.ucX, ((com.tencent.mm.plugin.wepkg.model.b)localObject).yFq, 1L, 0L, null);
        }
        label146:
        String str1 = this.tVg;
        String str2 = this.ucX;
        if (this.EDo == null) {
          break label489;
        }
        localObject = this.EDo.version;
        label174:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.EDm) && (!bt.isNullOrNil(this.ucX)))
        {
          if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qqt, 0) != 1) {
            break label497;
          }
          paramBoolean1 = true;
          label230:
          ad.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
          if (paramBoolean1)
          {
            this.EDy = ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).alp(this.ucX);
            if ((this.EDy != null) && (this.EDy.length() < 8)) {
              this.EDy = null;
            }
          }
          ad.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.EDy });
        }
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.EDm), this.ucX });
        if (this.tVm == null)
        {
          this.tVm = GameWebPerformanceInfo.wg(paramString);
          this.tVm.gsn = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
          paramString = this.tVm;
          if (!this.EDm) {
            break label502;
          }
        }
      }
    }
    label489:
    label497:
    label502:
    for (int i = 1;; i = 0)
    {
      paramString.gsg = i;
      this.tVm.gsI = a.eXv();
      this.tVm.gsJ = eXF();
      paramBoolean1 = this.EDm;
      AppMethodBeat.o(214446);
      return paramBoolean1;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.tVg, this.ucX, ((com.tencent.mm.plugin.wepkg.model.b)localObject).yFq, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(((com.tencent.mm.plugin.wepkg.model.b)localObject).EEE));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.tVg, this.ucX, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(8));
      break label146;
      localObject = "";
      break label174;
      paramBoolean1 = false;
      break label230;
    }
  }
  
  public final void n(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(110543);
    ad.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aWS != 0L)
    {
      l = System.currentTimeMillis() - this.aWS;
      str = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
      if (!bt.isNullOrNil(str)) {
        break label167;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aWS = 0L;
      if ((this.EDm) && (this.EDn != null) && (!this.EDA) && ((!bt.isNullOrNil(this.EDy)) || (this.EDn.aKO(paramString))))
      {
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        if (this.cXg == null) {
          eXI();
        }
        this.cXg.az(1000L, 1000L);
      }
      this.EDz = false;
      p(paramWebView, paramString);
      AppMethodBeat.o(110543);
      return;
      label167:
      if ((this.EDm) && (this.EDo != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.EDo.gsn, this.EDo.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final WebResourceResponse o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(214448);
    ad.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    if (paramWebView != null) {
      p(paramWebView, paramString);
    }
    paramWebView = c.aKr(paramString);
    if (paramWebView != null)
    {
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(paramWebView)));
      paramWebView = a.aKn(paramWebView);
      if (paramWebView != null)
      {
        AppMethodBeat.o(214448);
        return paramWebView;
      }
    }
    paramWebView = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
    if (!paramWebView.equals(this.ucX))
    {
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { paramWebView });
      this.EDq.aKL(paramString);
    }
    if (this.EDm) {
      if (this.EDn == null) {
        break label217;
      }
    }
    label217:
    for (paramWebView = this.EDn.aKM(com.tencent.mm.plugin.wepkg.utils.d.aLa(paramString));; paramWebView = null)
    {
      if (paramWebView != null)
      {
        if (this.EDo != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.EDo.gsn, this.EDo.version, 1L, 0L, null);
        }
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(214448);
        return paramWebView;
      }
      paramWebView = this.EDq.aKM(com.tencent.mm.plugin.wepkg.utils.d.aLa(paramString));
      AppMethodBeat.o(214448);
      return paramWebView;
    }
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(110546);
    if (paramBundle == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "method = %s, bundler == null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((!bt.isNullOrNil(paramString)) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(110546);
      return null;
    }
    if ((this.EDm) && (this.EDn != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!bt.isNullOrNil(paramString))
      {
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.EDn.acz(com.tencent.mm.plugin.wepkg.utils.d.aLa(paramString));
        if (!bt.isNullOrNil(paramString))
        {
          ad.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 14L, 1L, false);
          AppMethodBeat.o(110546);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(110546);
    return null;
  }
  
  public final void vz(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    if (this.cXg != null) {
      this.cXg.stopTimer();
    }
    if ((paramBoolean) && (!bt.isNullOrNil(this.ucX)))
    {
      c.TT(this.ucX);
      com.tencent.mm.plugin.wepkg.model.c.eXW().aD(this.ucX, 2, 1);
    }
    c.eXA();
    com.tencent.mm.plugin.wepkg.event.c.b(this.EDp);
    AppMethodBeat.o(110541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d
 * JD-Core Version:    0.7.0.1
 */