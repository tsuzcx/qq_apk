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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{
  private static final Pattern kkk;
  public boolean EVI;
  com.tencent.mm.plugin.wepkg.model.g EVJ;
  private WepkgVersion EVK;
  private com.tencent.mm.plugin.wepkg.event.a EVL;
  private e EVM;
  private boolean EVN;
  private boolean EVO;
  public com.tencent.mm.plugin.wepkg.event.b EVP;
  private boolean EVQ;
  private Set<String> EVR;
  private long EVS;
  public boolean EVT;
  private String EVU;
  private boolean EVV;
  private boolean EVW;
  public boolean EVX;
  private long aWS;
  private aw cYd;
  private String ugc;
  private GameWebPerformanceInfo ugi;
  private String uoc;
  
  static
  {
    AppMethodBeat.i(110556);
    kkk = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public d()
  {
    AppMethodBeat.i(110539);
    this.aWS = 0L;
    this.EVI = false;
    this.EVN = false;
    this.EVO = false;
    this.EVQ = false;
    this.EVR = new HashSet();
    this.EVT = true;
    this.EVX = false;
    c.fbj();
    this.EVM = new e();
    c.fbk();
    this.EVL = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void dM(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.EWW != null) && (paramAnonymousObject.EWW.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.EWW;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.fbg())) || ((!bu.isNullOrNil(d.a(d.this))) && (str.equals(d.a(d.this)))))
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
          if ((paramAnonymousObject != null) && (paramAnonymousObject.guO != null) && ((paramAnonymousObject.guO.equals(a.fbg())) || (paramAnonymousObject.guO.equals(d.a(d.this))))) {
            d.a(d.this, paramAnonymousObject.guO, paramAnonymousObject.success, paramAnonymousObject.EWU);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.EVL);
    AppMethodBeat.o(110539);
  }
  
  private static boolean cJ(String paramString)
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
  
  public static String fbs()
  {
    AppMethodBeat.i(224459);
    String str = a.fbh();
    AppMethodBeat.o(224459);
    return str;
  }
  
  private void fbt()
  {
    AppMethodBeat.i(209379);
    this.EVT = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).amo(this.uoc);
    AppMethodBeat.o(209379);
  }
  
  private void fbu()
  {
    AppMethodBeat.i(209380);
    this.cYd = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(110538);
        if ((d.d(d.this)) && (!d.e(d.this)))
        {
          ae.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
          ar.f(new Runnable()
          {
            public final void run()
            {
              int i = 0;
              AppMethodBeat.i(110537);
              try
              {
                ae.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                if (!bu.isNullOrNil(d.this.fbp())) {
                  i = 1;
                }
                d.f(d.this);
                int j = d.fbv();
                if (j > 1)
                {
                  if (d.g(d.this) != null)
                  {
                    if (i == 0) {
                      break label172;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", d.b(d.this), d.g(d.this).guO, d.g(d.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 13L, 1L, false);
                    String str = com.tencent.mm.plugin.wepkg.utils.d.aMu(d.b(d.this));
                    c.UD(str);
                    com.tencent.mm.plugin.wepkg.model.c.fbI().aF(str, 1, 2);
                    d.fbw();
                    d.h(d.this);
                    AppMethodBeat.o(110537);
                    return;
                    label172:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", d.b(d.this), d.g(d.this).guO, d.g(d.this).version, -1L, 0L, null);
                  }
                }
                d.YF(j + 1);
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
          d.YF(0);
        }
      }
    }, false);
    AppMethodBeat.o(209380);
  }
  
  private void q(final WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(209377);
    if ((!this.EVV) && (!cJ(paramString)))
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110536);
          if (paramWebView != null)
          {
            Object localObject = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { String.valueOf(d.this.aLQ(d.b(d.this))) });
            ae.i("MicroMsg.Wepkg.WePkgPlugin", "__usewepkg__: %s", new Object[] { localObject });
            paramWebView.evaluateJavascript((String)localObject, null);
            localObject = (PowerManager)ak.getContext().getSystemService("power");
            if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {}
            for (boolean bool = ((PowerManager)localObject).isPowerSaveMode();; bool = false)
            {
              localObject = String.format("javascript:(function() {window.__lowPowerMode__=%s;})();", new Object[] { String.valueOf(bool) });
              ae.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPowerMode__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__lowPower__=%s;})();", new Object[] { String.valueOf(BatteryManager.udM) });
              ae.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPower__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__game_center_preload__=%s;})();", new Object[] { String.valueOf(d.c(d.this)) });
              ae.i("MicroMsg.Wepkg.WePkgPlugin", "__game_center_preload__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              AppMethodBeat.o(110536);
              return;
            }
          }
          ae.i("MicroMsg.Wepkg.WePkgPlugin", "injectGameJs, webview == null");
          AppMethodBeat.o(110536);
        }
      });
      this.EVV = true;
    }
    AppMethodBeat.o(209377);
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.EVO = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!bu.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        ae.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.EVN = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final void aLP(String paramString)
  {
    AppMethodBeat.i(209375);
    ae.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aWS = System.currentTimeMillis();
    AppMethodBeat.o(209375);
  }
  
  public final boolean aLQ(String paramString)
  {
    AppMethodBeat.i(110549);
    if (kkk.matcher(bu.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.EVI;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final String fbp()
  {
    if (!this.EVI) {
      this.EVU = null;
    }
    return this.EVU;
  }
  
  public final boolean fbq()
  {
    return (this.EVK == null) || (!this.EVK.EXX);
  }
  
  public final String fbr()
  {
    if (this.EVK != null) {
      return this.EVK.version;
    }
    return "";
  }
  
  public final boolean k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209374);
    this.EVW = paramBoolean2;
    this.ugc = paramString;
    this.uoc = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
    Object localObject = c.cz(paramString, paramBoolean1);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.g)localObject).fbH())
      {
        this.EVJ = ((com.tencent.mm.plugin.wepkg.model.g)localObject);
        this.EVI = true;
        this.EVK = this.EVJ.EXp;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.ugc, this.uoc, this.EVK.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.ugc, this.uoc, this.EVK.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).EXb) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.ugc, this.uoc, ((com.tencent.mm.plugin.wepkg.model.b)localObject).yVv, 1L, 0L, null);
        }
        label146:
        String str1 = this.ugc;
        String str2 = this.uoc;
        if (this.EVK == null) {
          break label489;
        }
        localObject = this.EVK.version;
        label174:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.EVI) && (!bu.isNullOrNil(this.uoc)))
        {
          if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qxb, 0) != 1) {
            break label497;
          }
          paramBoolean1 = true;
          label230:
          ae.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
          if (paramBoolean1)
          {
            this.EVU = ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).amn(this.uoc);
            if ((this.EVU != null) && (this.EVU.length() < 8)) {
              this.EVU = null;
            }
          }
          ae.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.EVU });
        }
        ae.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.EVI), this.uoc });
        if (this.ugi == null)
        {
          this.ugi = GameWebPerformanceInfo.wP(paramString);
          this.ugi.guO = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
          paramString = this.ugi;
          if (!this.EVI) {
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
      paramString.guH = i;
      this.ugi.gvj = a.fbh();
      this.ugi.gvk = fbr();
      paramBoolean1 = this.EVI;
      AppMethodBeat.o(209374);
      return paramBoolean1;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.ugc, this.uoc, ((com.tencent.mm.plugin.wepkg.model.b)localObject).yVv, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(((com.tencent.mm.plugin.wepkg.model.b)localObject).EXa));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.ugc, this.uoc, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(8));
      break label146;
      localObject = "";
      break label174;
      paramBoolean1 = false;
      break label230;
    }
  }
  
  public final void o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(110543);
    ae.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aWS != 0L)
    {
      l = System.currentTimeMillis() - this.aWS;
      str = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
      if (!bu.isNullOrNil(str)) {
        break label167;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aWS = 0L;
      if ((this.EVI) && (this.EVJ != null) && (!this.EVW) && ((!bu.isNullOrNil(this.EVU)) || (this.EVJ.aMk(paramString))))
      {
        ae.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        if (this.cYd == null) {
          fbu();
        }
        this.cYd.ay(1000L, 1000L);
      }
      this.EVV = false;
      q(paramWebView, paramString);
      AppMethodBeat.o(110543);
      return;
      label167:
      if ((this.EVI) && (this.EVK != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.EVK.guO, this.EVK.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(110546);
    if (paramBundle == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.Wepkg.WePkgPlugin", "method = %s, bundler == null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((!bu.isNullOrNil(paramString)) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(110546);
      return null;
    }
    if ((this.EVI) && (this.EVJ != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      ae.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!bu.isNullOrNil(paramString))
      {
        ae.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.EVJ.adq(com.tencent.mm.plugin.wepkg.utils.d.aMw(paramString));
        if (!bu.isNullOrNil(paramString))
        {
          ae.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 14L, 1L, false);
          AppMethodBeat.o(110546);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(110546);
    return null;
  }
  
  public final WebResourceResponse p(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(209376);
    ae.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    if (paramWebView != null) {
      q(paramWebView, paramString);
    }
    paramWebView = c.aLN(paramString);
    if (paramWebView != null)
    {
      ae.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(paramWebView)));
      paramWebView = a.aLJ(paramWebView);
      if (paramWebView != null)
      {
        AppMethodBeat.o(209376);
        return paramWebView;
      }
    }
    paramWebView = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
    if (!paramWebView.equals(this.uoc))
    {
      ae.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { paramWebView });
      this.EVM.aMh(paramString);
    }
    if (this.EVI) {
      if (this.EVJ == null) {
        break label217;
      }
    }
    label217:
    for (paramWebView = this.EVJ.aMi(com.tencent.mm.plugin.wepkg.utils.d.aMw(paramString));; paramWebView = null)
    {
      if (paramWebView != null)
      {
        if (this.EVK != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.EVK.guO, this.EVK.version, 1L, 0L, null);
        }
        ae.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(209376);
        return paramWebView;
      }
      paramWebView = this.EVM.aMi(com.tencent.mm.plugin.wepkg.utils.d.aMw(paramString));
      AppMethodBeat.o(209376);
      return paramWebView;
    }
  }
  
  public final void vI(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    if (this.cYd != null) {
      this.cYd.stopTimer();
    }
    if ((paramBoolean) && (!bu.isNullOrNil(this.uoc)))
    {
      c.UD(this.uoc);
      com.tencent.mm.plugin.wepkg.model.c.fbI().aF(this.uoc, 2, 1);
    }
    c.fbm();
    com.tencent.mm.plugin.wepkg.event.c.b(this.EVL);
    AppMethodBeat.o(110541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d
 * JD-Core Version:    0.7.0.1
 */