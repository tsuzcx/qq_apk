package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.brandservice.api.h.b;
import com.tencent.mm.plugin.brandservice.api.h.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
{
  private static final Pattern rmg;
  private String IEG;
  private com.tencent.mm.plugin.wepkg.event.a IuP;
  private GameWebPerformanceInfo IwE;
  private String Iwy;
  public com.tencent.mm.plugin.wepkg.event.b XEA;
  private boolean XEB;
  private Set<String> XEC;
  private long XED;
  public boolean XEE;
  private String XEF;
  public boolean XEG;
  private boolean XEH;
  public boolean XEI;
  public boolean XEu;
  com.tencent.mm.plugin.wepkg.model.h XEv;
  private WepkgVersion XEw;
  private com.tencent.mm.plugin.wepkg.model.f XEx;
  private boolean XEy;
  private boolean XEz;
  private long mStartLoadTime;
  private MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(110556);
    rmg = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public f()
  {
    AppMethodBeat.i(110539);
    this.mStartLoadTime = 0L;
    this.XEu = false;
    this.XEy = false;
    this.XEz = false;
    this.XEB = false;
    this.XEC = new HashSet();
    this.XEE = true;
    this.XEI = false;
    e.iEO();
    this.XEx = new com.tencent.mm.plugin.wepkg.model.f();
    e.iEP();
    this.IuP = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void notify(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.XFE != null) && (paramAnonymousObject.XFE.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.XFE;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.iEL())) || ((!Util.isNullOrNil(f.a(f.this))) && (str.equals(f.a(f.this)))))
              {
                f.a(f.this, str);
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
          if ((paramAnonymousObject != null) && (paramAnonymousObject.mtT != null) && ((paramAnonymousObject.mtT.equals(a.iEL())) || (paramAnonymousObject.mtT.equals(f.a(f.this))))) {
            f.a(f.this, paramAnonymousObject.mtT, paramAnonymousObject.success, paramAnonymousObject.XFC);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.IuP);
    AppMethodBeat.o(110539);
  }
  
  private static boolean eL(String paramString)
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
  
  public static String iEX()
  {
    AppMethodBeat.i(369757);
    String str = a.iEM();
    AppMethodBeat.o(369757);
    return str;
  }
  
  private void iEY()
  {
    AppMethodBeat.i(278642);
    this.XEE = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.luggage.a.a.class)).aFW(this.IEG);
    AppMethodBeat.o(278642);
  }
  
  private void iEZ()
  {
    AppMethodBeat.i(278645);
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(110538);
        if ((f.d(f.this)) && (!f.e(f.this)))
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
                if (!Util.isNullOrNil(f.this.iEU())) {
                  i = 1;
                }
                f.f(f.this);
                int j = f.iFa();
                if (j > 1)
                {
                  if (f.g(f.this) != null)
                  {
                    if (i == 0) {
                      break label172;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", f.b(f.this), f.g(f.this).mtT, f.g(f.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 13L, 1L, false);
                    String str = d.boB(f.b(f.this));
                    e.aft(str);
                    com.tencent.mm.plugin.wepkg.model.c.iFn().aR(str, 1, 2);
                    f.iFb();
                    f.h(f.this);
                    AppMethodBeat.o(110537);
                    return;
                    label172:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", f.b(f.this), f.g(f.this).mtT, f.g(f.this).version, -1L, 0L, null);
                  }
                }
                f.avg(j + 1);
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
          f.avg(0);
        }
      }
    }, false);
    AppMethodBeat.o(278645);
  }
  
  private void o(final WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(278635);
    if ((!this.XEG) && (!eL(paramString)))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110536);
          if (paramWebView != null)
          {
            Object localObject = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { String.valueOf(f.this.bnW(f.b(f.this))) });
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "__usewepkg__: %s", new Object[] { localObject });
            paramWebView.evaluateJavascript((String)localObject, null);
            localObject = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
            if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {}
            for (boolean bool = ((PowerManager)localObject).isPowerSaveMode();; bool = false)
            {
              localObject = String.format("javascript:(function() {window.__lowPowerMode__=%s;})();", new Object[] { String.valueOf(bool) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPowerMode__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__lowPower__=%s;})();", new Object[] { String.valueOf(com.tencent.mm.plugin.game.commlib.e.a.Itd) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPower__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__game_center_preload__=%s;})();", new Object[] { String.valueOf(f.c(f.this)) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__game_center_preload__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__is_game_center_preload_page__=%s;})();", new Object[] { String.valueOf(f.c(f.this)) });
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
      this.XEG = true;
    }
    AppMethodBeat.o(278635);
  }
  
  public final void Jk(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    if (this.timer != null) {
      this.timer.stopTimer();
    }
    if ((paramBoolean) && (!Util.isNullOrNil(this.IEG)))
    {
      e.aft(this.IEG);
      com.tencent.mm.plugin.wepkg.model.c.iFn().aR(this.IEG, 2, 1);
    }
    e.iER();
    com.tencent.mm.plugin.wepkg.event.c.b(this.IuP);
    AppMethodBeat.o(110541);
  }
  
  public final WebResourceResponse a(WebView paramWebView, String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(278673);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.isForMainFrame()))
    {
      paramWebResourceRequest = ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).fK(this.Iwy, null);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.vBd != null) && (paramWebResourceRequest.vBd.vBi != null))
      {
        Log.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept hit prefetch response");
        com.tencent.mm.plugin.report.service.h.OAn.b(21075, new Object[] { Integer.valueOf(500), paramString, "", Integer.valueOf(4), Integer.valueOf(0) });
        paramWebView = paramWebResourceRequest.vBd.vBi;
        AppMethodBeat.o(278673);
        return paramWebView;
      }
    }
    if (paramWebView != null) {
      o(paramWebView, paramString);
    }
    paramWebView = e.bnS(paramString);
    if (paramWebView != null)
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(paramWebView)));
      paramWebView = a.bnO(paramWebView);
      if (paramWebView != null)
      {
        AppMethodBeat.o(278673);
        return paramWebView;
      }
    }
    paramWebView = d.boB(paramString);
    if (!paramWebView.equals(this.IEG))
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { paramWebView });
      this.XEx.boo(paramString);
    }
    if (this.XEu)
    {
      paramWebView = null;
      if (this.XEv != null) {
        paramWebView = this.XEv.bop(d.boD(paramString));
      }
      if (paramWebView != null)
      {
        if (this.XEw != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.XEw.mtT, this.XEw.version, 1L, 0L, null);
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(278673);
        return paramWebView;
      }
    }
    paramWebView = this.XEx.bop(d.boD(paramString));
    AppMethodBeat.o(278673);
    return paramWebView;
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.XEz = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!Util.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.XEy = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final void bnU(String paramString)
  {
    AppMethodBeat.i(278668);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.mStartLoadTime = System.currentTimeMillis();
    AppMethodBeat.o(278668);
  }
  
  public final void bnV(String paramString)
  {
    AppMethodBeat.i(278671);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.mStartLoadTime != 0L)
    {
      l = System.currentTimeMillis() - this.mStartLoadTime;
      str = d.boB(paramString);
      if (!Util.isNullOrNil(str)) {
        break label152;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.mStartLoadTime = 0L;
      if ((this.XEu) && (this.XEv != null) && (!this.XEH) && ((!Util.isNullOrNil(this.XEF)) || (this.XEv.bor(paramString))))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        if (this.timer == null) {
          iEZ();
        }
        this.timer.startTimer(1000L);
      }
      AppMethodBeat.o(278671);
      return;
      label152:
      if ((this.XEu) && (this.XEw != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.XEw.mtT, this.XEw.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final boolean bnW(String paramString)
  {
    AppMethodBeat.i(110549);
    if (rmg.matcher(Util.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.XEu;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final String iEU()
  {
    if (!this.XEu) {
      this.XEF = null;
    }
    return this.XEF;
  }
  
  public final boolean iEV()
  {
    return (this.XEw == null) || (!this.XEw.XGG);
  }
  
  public final String iEW()
  {
    if (this.XEw != null) {
      return this.XEw.version;
    }
    return "";
  }
  
  public final boolean isAvailable()
  {
    return this.XEu;
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
    if ((this.XEu) && (this.XEv != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.XEv.apy(d.boD(paramString));
        if (!Util.isNullOrNil(paramString))
        {
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 14L, 1L, false);
          AppMethodBeat.o(110546);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(110546);
    return null;
  }
  
  public final boolean q(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(278665);
    this.XEH = paramBoolean2;
    this.Iwy = paramString;
    this.IEG = d.boB(paramString);
    Object localObject = e.dS(paramString, paramBoolean1);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.h)localObject).fEO())
      {
        this.XEv = ((com.tencent.mm.plugin.wepkg.model.h)localObject);
        this.XEu = true;
        this.XEw = this.XEv.XFY;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.Iwy, this.IEG, this.XEw.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.Iwy, this.IEG, this.XEw.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).XFJ) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.Iwy, this.IEG, ((com.tencent.mm.plugin.wepkg.model.b)localObject).Pqy, 1L, 0L, null);
        }
        label146:
        String str1 = this.Iwy;
        String str2 = this.IEG;
        if (this.XEw == null) {
          break label489;
        }
        localObject = this.XEw.version;
        label174:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.XEu) && (!Util.isNullOrNil(this.IEG)))
        {
          if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yHK, 0) != 1) {
            break label496;
          }
          paramBoolean1 = true;
          label230:
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
          if (paramBoolean1)
          {
            this.XEF = ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.luggage.a.a.class)).aFV(this.IEG);
            if ((this.XEF != null) && (this.XEF.length() < 8)) {
              this.XEF = null;
            }
          }
          Log.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.XEF });
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.XEu), this.IEG });
        if (this.IwE == null)
        {
          this.IwE = GameWebPerformanceInfo.EI(paramString);
          this.IwE.mtT = d.boB(paramString);
          paramString = this.IwE;
          if (!this.XEu) {
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
      paramString.mtM = i;
      this.IwE.muo = a.iEM();
      this.IwE.mup = iEW();
      paramBoolean1 = this.XEu;
      AppMethodBeat.o(278665);
      return paramBoolean1;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.Iwy, this.IEG, ((com.tencent.mm.plugin.wepkg.model.b)localObject).Pqy, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(((com.tencent.mm.plugin.wepkg.model.b)localObject).XFI));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.Iwy, this.IEG, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(8));
      break label146;
      localObject = "";
      break label174;
      paramBoolean1 = false;
      break label230;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.f
 * JD-Core Version:    0.7.0.1
 */