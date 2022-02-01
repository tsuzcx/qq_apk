package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.brandservice.a.f.b;
import com.tencent.mm.plugin.expt.b.b.a;
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
  private static final Pattern oiE;
  private com.tencent.mm.plugin.wepkg.event.a CBc;
  private GameWebPerformanceInfo CCD;
  private String CCx;
  private String CKw;
  public boolean QKV;
  com.tencent.mm.plugin.wepkg.model.h QKW;
  private WepkgVersion QKX;
  private com.tencent.mm.plugin.wepkg.model.f QKY;
  private boolean QKZ;
  private boolean QLa;
  public com.tencent.mm.plugin.wepkg.event.b QLb;
  private boolean QLc;
  private Set<String> QLd;
  private long QLe;
  public boolean QLf;
  private String QLg;
  public boolean QLh;
  private boolean QLi;
  public boolean QLj;
  private long aGc;
  private MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(110556);
    oiE = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public f()
  {
    AppMethodBeat.i(110539);
    this.aGc = 0L;
    this.QKV = false;
    this.QKZ = false;
    this.QLa = false;
    this.QLc = false;
    this.QLd = new HashSet();
    this.QLf = true;
    this.QLj = false;
    e.heg();
    this.QKY = new com.tencent.mm.plugin.wepkg.model.f();
    e.heh();
    this.CBc = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void notify(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.QMg != null) && (paramAnonymousObject.QMg.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.QMg;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.hed())) || ((!Util.isNullOrNil(f.a(f.this))) && (str.equals(f.a(f.this)))))
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
          if ((paramAnonymousObject != null) && (paramAnonymousObject.jTB != null) && ((paramAnonymousObject.jTB.equals(a.hed())) || (paramAnonymousObject.jTB.equals(f.a(f.this))))) {
            f.a(f.this, paramAnonymousObject.jTB, paramAnonymousObject.success, paramAnonymousObject.QMe);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.CBc);
    AppMethodBeat.o(110539);
  }
  
  private static boolean dA(String paramString)
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
  
  public static String hep()
  {
    AppMethodBeat.i(292972);
    String str = a.hee();
    AppMethodBeat.o(292972);
    return str;
  }
  
  private void heq()
  {
    AppMethodBeat.i(194877);
    this.QLf = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.luggage.a.a.class)).aJk(this.CKw);
    AppMethodBeat.o(194877);
  }
  
  private void her()
  {
    AppMethodBeat.i(194879);
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
                if (!Util.isNullOrNil(f.this.hem())) {
                  i = 1;
                }
                f.f(f.this);
                int j = f.hes();
                if (j > 1)
                {
                  if (f.g(f.this) != null)
                  {
                    if (i == 0) {
                      break label172;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", f.b(f.this), f.g(f.this).jTB, f.g(f.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 13L, 1L, false);
                    String str = d.boN(f.b(f.this));
                    e.aml(str);
                    com.tencent.mm.plugin.wepkg.model.c.heF().aJ(str, 1, 2);
                    f.het();
                    f.h(f.this);
                    AppMethodBeat.o(110537);
                    return;
                    label172:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", f.b(f.this), f.g(f.this).jTB, f.g(f.this).version, -1L, 0L, null);
                  }
                }
                f.api(j + 1);
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
          f.api(0);
        }
      }
    }, false);
    AppMethodBeat.o(194879);
  }
  
  private void p(final WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(194864);
    if ((!this.QLh) && (!dA(paramString)))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110536);
          if (paramWebView != null)
          {
            Object localObject = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { String.valueOf(f.this.boi(f.b(f.this))) });
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "__usewepkg__: %s", new Object[] { localObject });
            paramWebView.evaluateJavascript((String)localObject, null);
            localObject = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
            if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {}
            for (boolean bool = ((PowerManager)localObject).isPowerSaveMode();; bool = false)
            {
              localObject = String.format("javascript:(function() {window.__lowPowerMode__=%s;})();", new Object[] { String.valueOf(bool) });
              Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPowerMode__: %s", new Object[] { localObject });
              paramWebView.evaluateJavascript((String)localObject, null);
              localObject = String.format("javascript:(function() {window.__lowPower__=%s;})();", new Object[] { String.valueOf(com.tencent.mm.plugin.game.commlib.e.a.Czo) });
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
      this.QLh = true;
    }
    AppMethodBeat.o(194864);
  }
  
  public final void DD(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    if (this.timer != null) {
      this.timer.stopTimer();
    }
    if ((paramBoolean) && (!Util.isNullOrNil(this.CKw)))
    {
      e.aml(this.CKw);
      com.tencent.mm.plugin.wepkg.model.c.heF().aJ(this.CKw, 2, 1);
    }
    e.hej();
    com.tencent.mm.plugin.wepkg.event.c.b(this.CBc);
    AppMethodBeat.o(110541);
  }
  
  public final WebResourceResponse a(WebView paramWebView, String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(194862);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.isForMainFrame()))
    {
      paramWebResourceRequest = ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).apq(this.CCx);
      if ((paramWebResourceRequest != null) && (paramWebResourceRequest.svz != null))
      {
        Log.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept hit prefetch response");
        com.tencent.mm.plugin.report.service.h.IzE.a(21075, new Object[] { Integer.valueOf(500), paramString, "", Integer.valueOf(4), Integer.valueOf(0) });
        paramWebView = paramWebResourceRequest.svz;
        AppMethodBeat.o(194862);
        return paramWebView;
      }
    }
    if (paramWebView != null) {
      p(paramWebView, paramString);
    }
    paramWebView = e.boe(paramString);
    if (paramWebView != null)
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(paramWebView)));
      paramWebView = a.boa(paramWebView);
      if (paramWebView != null)
      {
        AppMethodBeat.o(194862);
        return paramWebView;
      }
    }
    paramWebView = d.boN(paramString);
    if (!paramWebView.equals(this.CKw))
    {
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { paramWebView });
      this.QKY.boA(paramString);
    }
    if (this.QKV)
    {
      paramWebView = null;
      if (this.QKW != null) {
        paramWebView = this.QKW.boB(d.boP(paramString));
      }
      if (paramWebView != null)
      {
        if (this.QKX != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.QKX.jTB, this.QKX.version, 1L, 0L, null);
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(194862);
        return paramWebView;
      }
    }
    paramWebView = this.QKY.boB(d.boP(paramString));
    AppMethodBeat.o(194862);
    return paramWebView;
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.QLa = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!Util.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.QKZ = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final void bog(String paramString)
  {
    AppMethodBeat.i(194850);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aGc = System.currentTimeMillis();
    AppMethodBeat.o(194850);
  }
  
  public final void boh(String paramString)
  {
    AppMethodBeat.i(194855);
    Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aGc != 0L)
    {
      l = System.currentTimeMillis() - this.aGc;
      str = d.boN(paramString);
      if (!Util.isNullOrNil(str)) {
        break label152;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aGc = 0L;
      if ((this.QKV) && (this.QKW != null) && (!this.QLi) && ((!Util.isNullOrNil(this.QLg)) || (this.QKW.boD(paramString))))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        if (this.timer == null) {
          her();
        }
        this.timer.startTimer(1000L);
      }
      AppMethodBeat.o(194855);
      return;
      label152:
      if ((this.QKV) && (this.QKX != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.QKX.jTB, this.QKX.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final boolean boi(String paramString)
  {
    AppMethodBeat.i(110549);
    if (oiE.matcher(Util.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.QKV;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final String hem()
  {
    if (!this.QKV) {
      this.QLg = null;
    }
    return this.QLg;
  }
  
  public final boolean hen()
  {
    return (this.QKX == null) || (!this.QKX.QNi);
  }
  
  public final String heo()
  {
    if (this.QKX != null) {
      return this.QKX.version;
    }
    return "";
  }
  
  public final boolean isAvailable()
  {
    return this.QKV;
  }
  
  public final boolean m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194848);
    this.QLi = paramBoolean2;
    this.CCx = paramString;
    this.CKw = d.boN(paramString);
    Object localObject = e.di(paramString, paramBoolean1);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.h)localObject).ewT())
      {
        this.QKW = ((com.tencent.mm.plugin.wepkg.model.h)localObject);
        this.QKV = true;
        this.QKX = this.QKW.QMA;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.CCx, this.CKw, this.QKX.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.CCx, this.CKw, this.QKX.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).QMl) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.CCx, this.CKw, ((com.tencent.mm.plugin.wepkg.model.b)localObject).JfL, 1L, 0L, null);
        }
        label146:
        String str1 = this.CCx;
        String str2 = this.CKw;
        if (this.QKX == null) {
          break label489;
        }
        localObject = this.QKX.version;
        label174:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.QKV) && (!Util.isNullOrNil(this.CKw)))
        {
          if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuQ, 0) != 1) {
            break label496;
          }
          paramBoolean1 = true;
          label230:
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
          if (paramBoolean1)
          {
            this.QLg = ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.luggage.a.a.class)).aJj(this.CKw);
            if ((this.QLg != null) && (this.QLg.length() < 8)) {
              this.QLg = null;
            }
          }
          Log.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.QLg });
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.QKV), this.CKw });
        if (this.CCD == null)
        {
          this.CCD = GameWebPerformanceInfo.LZ(paramString);
          this.CCD.jTB = d.boN(paramString);
          paramString = this.CCD;
          if (!this.QKV) {
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
      paramString.jTu = i;
      this.CCD.jTW = a.hee();
      this.CCD.jTX = heo();
      paramBoolean1 = this.QKV;
      AppMethodBeat.o(194848);
      return paramBoolean1;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.CCx, this.CKw, ((com.tencent.mm.plugin.wepkg.model.b)localObject).JfL, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(((com.tencent.mm.plugin.wepkg.model.b)localObject).QMk));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.CCx, this.CKw, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(8));
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
    if ((this.QKV) && (this.QKW != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.QKW.avy(d.boP(paramString));
        if (!Util.isNullOrNil(paramString))
        {
          Log.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 14L, 1L, false);
          AppMethodBeat.o(110546);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(110546);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.f
 * JD-Core Version:    0.7.0.1
 */