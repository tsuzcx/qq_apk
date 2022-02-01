package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern lnT;
  public boolean JLC;
  com.tencent.mm.plugin.wepkg.model.h JLD;
  private WepkgVersion JLE;
  private f JLF;
  private boolean JLG;
  private boolean JLH;
  public com.tencent.mm.plugin.wepkg.event.b JLI;
  private boolean JLJ;
  private Set<String> JLK;
  private long JLL;
  public boolean JLM;
  private String JLN;
  public boolean JLO;
  private boolean JLP;
  public boolean JLQ;
  private long aWK;
  private MTimerHandler timer;
  private String xGt;
  private com.tencent.mm.plugin.wepkg.event.a xwU;
  private String xyo;
  private GameWebPerformanceInfo xyv;
  
  static
  {
    AppMethodBeat.i(110556);
    lnT = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public e()
  {
    AppMethodBeat.i(110539);
    this.aWK = 0L;
    this.JLC = false;
    this.JLG = false;
    this.JLH = false;
    this.JLJ = false;
    this.JLK = new HashSet();
    this.JLM = true;
    this.JLQ = false;
    d.gkp();
    this.JLF = new f();
    d.gkq();
    this.xwU = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void dt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.JMN != null) && (paramAnonymousObject.JMN.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.JMN;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.gkm())) || ((!Util.isNullOrNil(e.a(e.this))) && (str.equals(e.a(e.this)))))
              {
                e.a(e.this, str);
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
          if ((paramAnonymousObject != null) && (paramAnonymousObject.hhD != null) && ((paramAnonymousObject.hhD.equals(a.gkm())) || (paramAnonymousObject.hhD.equals(e.a(e.this))))) {
            e.a(e.this, paramAnonymousObject.hhD, paramAnonymousObject.success, paramAnonymousObject.JML);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.xwU);
    AppMethodBeat.o(110539);
  }
  
  private static boolean df(String paramString)
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
  
  private void gkA()
  {
    AppMethodBeat.i(200153);
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(110538);
        if ((e.d(e.this)) && (!e.e(e.this)))
        {
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              int i = 0;
              AppMethodBeat.i(110537);
              try
              {
                Log.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                if (!Util.isNullOrNil(e.this.gkv())) {
                  i = 1;
                }
                e.f(e.this);
                int j = e.gkB();
                if (j > 1)
                {
                  if (e.g(e.this) != null)
                  {
                    if (i == 0) {
                      break label172;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", e.b(e.this), e.g(e.this).hhD, e.g(e.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 13L, 1L, false);
                    String str = com.tencent.mm.plugin.wepkg.utils.d.bcO(e.b(e.this));
                    d.aer(str);
                    com.tencent.mm.plugin.wepkg.model.c.gkN().aH(str, 1, 2);
                    e.gkC();
                    e.h(e.this);
                    AppMethodBeat.o(110537);
                    return;
                    label172:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", e.b(e.this), e.g(e.this).hhD, e.g(e.this).version, -1L, 0L, null);
                  }
                }
                e.ahq(j + 1);
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
          e.ahq(0);
        }
      }
    }, false);
    AppMethodBeat.o(200153);
  }
  
  public static String gky()
  {
    AppMethodBeat.i(258615);
    String str = a.gkn();
    AppMethodBeat.o(258615);
    return str;
  }
  
  private void gkz()
  {
    AppMethodBeat.i(200152);
    this.JLM = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)g.af(com.tencent.mm.plugin.game.luggage.a.a.class)).azA(this.xGt);
    AppMethodBeat.o(200152);
  }
  
  private void q(final WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(200150);
    if ((!this.JLO) && (!df(paramString)))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110536);
          if (paramWebView != null)
          {
            Object localObject = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { String.valueOf(e.this.bci(e.b(e.this))) });
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "__usewepkg__: %s", new Object[] { localObject });
            paramWebView.evaluateJavascript((String)localObject, null);
            localObject = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
            if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {}
            for (boolean bool = ((PowerManager)localObject).isPowerSaveMode();; bool = false)
            {
              localObject = String.format("javascript:(function() {window.__lowPowerMode__=%s;})();", new Object[] { String.valueOf(bool) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPowerMode__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__lowPower__=%s;})();", new Object[] { String.valueOf(BatteryManager.xvy) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPower__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__game_center_preload__=%s;})();", new Object[] { String.valueOf(e.c(e.this)) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__game_center_preload__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__is_game_center_preload_page__=%s;})();", new Object[] { String.valueOf(e.c(e.this)) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__is_game_center_preload_page__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              AppMethodBeat.o(110536);
              return;
            }
          }
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "injectGameJs, webview == null");
          AppMethodBeat.o(110536);
        }
      });
      this.JLO = true;
    }
    AppMethodBeat.o(200150);
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.JLH = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!Util.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.JLG = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final void bcg(String paramString)
  {
    AppMethodBeat.i(200147);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aWK = System.currentTimeMillis();
    AppMethodBeat.o(200147);
  }
  
  public final void bch(String paramString)
  {
    AppMethodBeat.i(200148);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aWK != 0L)
    {
      l = System.currentTimeMillis() - this.aWK;
      str = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
      if (!Util.isNullOrNil(str)) {
        break label152;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aWK = 0L;
      if ((this.JLC) && (this.JLD != null) && (!this.JLP) && ((!Util.isNullOrNil(this.JLN)) || (this.JLD.bcE(paramString))))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        if (this.timer == null) {
          gkA();
        }
        this.timer.startTimer(1000L);
      }
      AppMethodBeat.o(200148);
      return;
      label152:
      if ((this.JLC) && (this.JLE != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.JLE.hhD, this.JLE.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final boolean bci(String paramString)
  {
    AppMethodBeat.i(110549);
    if (lnT.matcher(Util.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.JLC;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final String gkv()
  {
    if (!this.JLC) {
      this.JLN = null;
    }
    return this.JLN;
  }
  
  public final boolean gkw()
  {
    return (this.JLE == null) || (!this.JLE.JNP);
  }
  
  public final String gkx()
  {
    if (this.JLE != null) {
      return this.JLE.version;
    }
    return "";
  }
  
  public final boolean m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(200146);
    this.JLP = paramBoolean2;
    this.xyo = paramString;
    this.xGt = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
    Object localObject = d.cU(paramString, paramBoolean1);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.h)localObject).dTL())
      {
        this.JLD = ((com.tencent.mm.plugin.wepkg.model.h)localObject);
        this.JLC = true;
        this.JLE = this.JLD.JNh;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, this.JLE.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.xyo, this.xGt, this.JLE.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).JMS) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, ((com.tencent.mm.plugin.wepkg.model.b)localObject).Dak, 1L, 0L, null);
        }
        label146:
        String str1 = this.xyo;
        String str2 = this.xGt;
        if (this.JLE == null) {
          break label489;
        }
        localObject = this.JLE.version;
        label174:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.JLC) && (!Util.isNullOrNil(this.xGt)))
        {
          if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOO, 0) != 1) {
            break label496;
          }
          paramBoolean1 = true;
          label230:
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
          if (paramBoolean1)
          {
            this.JLN = ((com.tencent.mm.plugin.game.luggage.a.a)g.af(com.tencent.mm.plugin.game.luggage.a.a.class)).azz(this.xGt);
            if ((this.JLN != null) && (this.JLN.length() < 8)) {
              this.JLN = null;
            }
          }
          Log.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.JLN });
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.JLC), this.xGt });
        if (this.xyv == null)
        {
          this.xyv = GameWebPerformanceInfo.Fd(paramString);
          this.xyv.hhD = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
          paramString = this.xyv;
          if (!this.JLC) {
            break label501;
          }
        }
      }
    }
    label489:
    label496:
    label501:
    for (int i = 1;; i = 0)
    {
      paramString.hhw = i;
      this.xyv.hhY = a.gkn();
      this.xyv.hhZ = gkx();
      paramBoolean1 = this.JLC;
      AppMethodBeat.o(200146);
      return paramBoolean1;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, ((com.tencent.mm.plugin.wepkg.model.b)localObject).Dak, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(((com.tencent.mm.plugin.wepkg.model.b)localObject).JMR));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(8));
      break label146;
      localObject = "";
      break label174;
      paramBoolean1 = false;
      break label230;
    }
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(110546);
    if (paramBundle == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "method = %s, bundler == null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((!Util.isNullOrNil(paramString)) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(110546);
      return null;
    }
    if ((this.JLC) && (this.JLD != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.JLD.anz(com.tencent.mm.plugin.wepkg.utils.d.bcQ(paramString));
        if (!Util.isNullOrNil(paramString))
        {
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 14L, 1L, false);
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
    AppMethodBeat.i(200149);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    if (paramWebView != null) {
      q(paramWebView, paramString);
    }
    paramWebView = d.bce(paramString);
    if (paramWebView != null)
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(paramWebView)));
      paramWebView = a.bca(paramWebView);
      if (paramWebView != null)
      {
        AppMethodBeat.o(200149);
        return paramWebView;
      }
    }
    paramWebView = com.tencent.mm.plugin.wepkg.utils.d.bcO(paramString);
    if (!paramWebView.equals(this.xGt))
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { paramWebView });
      this.JLF.bcA(paramString);
    }
    if (this.JLC) {
      if (this.JLD == null) {
        break label217;
      }
    }
    label217:
    for (paramWebView = this.JLD.bcB(com.tencent.mm.plugin.wepkg.utils.d.bcQ(paramString));; paramWebView = null)
    {
      if (paramWebView != null)
      {
        if (this.JLE != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.JLE.hhD, this.JLE.version, 1L, 0L, null);
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(200149);
        return paramWebView;
      }
      paramWebView = this.JLF.bcB(com.tencent.mm.plugin.wepkg.utils.d.bcQ(paramString));
      AppMethodBeat.o(200149);
      return paramWebView;
    }
  }
  
  public final void zE(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    if (this.timer != null) {
      this.timer.stopTimer();
    }
    if ((paramBoolean) && (!Util.isNullOrNil(this.xGt)))
    {
      d.aer(this.xGt);
      com.tencent.mm.plugin.wepkg.model.c.gkN().aH(this.xGt, 2, 1);
    }
    d.gks();
    com.tencent.mm.plugin.wepkg.event.c.b(this.xwU);
    AppMethodBeat.o(110541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.e
 * JD-Core Version:    0.7.0.1
 */