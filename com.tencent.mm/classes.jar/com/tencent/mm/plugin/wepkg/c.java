package com.tencent.mm.plugin.wepkg;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;
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

public final class c
{
  private static final Pattern jmw;
  public boolean BHg;
  private com.tencent.mm.plugin.wepkg.model.g BHh;
  private WepkgVersion BHi;
  private com.tencent.mm.plugin.wepkg.event.a BHj;
  private e BHk;
  private boolean BHl;
  private boolean BHm;
  public com.tencent.mm.plugin.wepkg.event.b BHn;
  private boolean BHo;
  private Set<String> BHp;
  private long BHq;
  public boolean BHr;
  private String BHs;
  public boolean BHt;
  private long aLL;
  private av cOx;
  public String rQe;
  private GameWebPerformanceInfo rQk;
  private String rXp;
  
  static
  {
    AppMethodBeat.i(110556);
    jmw = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public c()
  {
    AppMethodBeat.i(110539);
    this.aLL = 0L;
    this.BHg = false;
    this.BHl = false;
    this.BHm = false;
    this.BHo = false;
    this.BHp = new HashSet();
    this.BHr = true;
    this.cOx = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(110538);
        if ((c.b(c.this)) && (!c.c(c.this)))
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
                if (!bt.isNullOrNil(c.this.etr())) {
                  i = 1;
                }
                c.d(c.this);
                int j = c.etw();
                if (j > 1)
                {
                  if (c.e(c.this) != null)
                  {
                    if (i == 0) {
                      break label171;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", c.f(c.this), c.e(c.this).fUW, c.e(c.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    h.vKh.idkeyStat(859L, 13L, 1L, false);
                    String str = d.aAg(c.f(c.this));
                    b.Mf(str);
                    com.tencent.mm.plugin.wepkg.model.c.etK().fn(str, 1);
                    c.etx();
                    c.g(c.this);
                    AppMethodBeat.o(110537);
                    return;
                    label171:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", c.f(c.this), c.e(c.this).fUW, c.e(c.this).version, -1L, 0L, null);
                  }
                }
                c.Ua(j + 1);
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
          c.Ua(0);
        }
      }
    }, false);
    b.etl();
    this.BHk = new e();
    b.etm();
    this.BHj = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void dH(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.BIs != null) && (paramAnonymousObject.BIs.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.BIs;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.eti())) || ((!bt.isNullOrNil(c.a(c.this))) && (str.equals(c.a(c.this)))))
              {
                c.a(c.this, str);
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
          if ((paramAnonymousObject != null) && (paramAnonymousObject.fUW != null) && ((paramAnonymousObject.fUW.equals(a.eti())) || (paramAnonymousObject.fUW.equals(c.a(c.this))))) {
            c.a(c.this, paramAnonymousObject.fUW, paramAnonymousObject.success, paramAnonymousObject.BIq);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.BHj);
    AppMethodBeat.o(110539);
  }
  
  public static boolean bZ(String paramString)
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
  
  public static String etu()
  {
    AppMethodBeat.i(204418);
    String str = a.etj();
    AppMethodBeat.o(204418);
    return str;
  }
  
  private void etv()
  {
    AppMethodBeat.i(192617);
    this.BHr = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).acb(this.rXp);
    AppMethodBeat.o(192617);
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.BHm = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!bt.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.BHl = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final WebResourceResponse azC(String paramString)
  {
    AppMethodBeat.i(110545);
    ad.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    Object localObject = b.azA(paramString);
    if (localObject != null)
    {
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(localObject)));
      localObject = a.azw((String)localObject);
      if (localObject != null)
      {
        AppMethodBeat.o(110545);
        return localObject;
      }
    }
    localObject = d.aAg(paramString);
    if (!((String)localObject).equals(this.rXp))
    {
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { localObject });
      this.BHk.azU(paramString);
    }
    if (this.BHg) {
      if (this.BHh == null) {
        break label207;
      }
    }
    label207:
    for (localObject = this.BHh.azV(d.aAi(paramString));; localObject = null)
    {
      if (localObject != null)
      {
        if (this.BHi != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.BHi.fUW, this.BHi.version, 1L, 0L, null);
        }
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(110545);
        return localObject;
      }
      paramString = this.BHk.azV(d.aAi(paramString));
      AppMethodBeat.o(110545);
      return paramString;
    }
  }
  
  public final boolean azD(String paramString)
  {
    AppMethodBeat.i(110549);
    if (jmw.matcher(bt.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.BHg;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final void b(final WebView paramWebView, final boolean paramBoolean)
  {
    AppMethodBeat.i(110547);
    ad.i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:".concat(String.valueOf(paramBoolean)));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110536);
        if (paramWebView != null)
        {
          String str = String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[] { Boolean.valueOf(paramBoolean) });
          paramWebView.evaluateJavascript(str, null);
          AppMethodBeat.o(110536);
          return;
        }
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
        AppMethodBeat.o(110536);
      }
    });
    AppMethodBeat.o(110547);
  }
  
  public final boolean ck(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110540);
    this.rQe = paramString;
    this.rXp = d.aAg(paramString);
    Object localObject = b.cj(paramString, paramBoolean);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.g)localObject).etJ())
      {
        this.BHh = ((com.tencent.mm.plugin.wepkg.model.g)localObject);
        this.BHg = true;
        this.BHi = this.BHh.BIL;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.rQe, this.rXp, this.BHi.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.rQe, this.rXp, this.BHi.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).BIx) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.rQe, this.rXp, ((com.tencent.mm.plugin.wepkg.model.b)localObject).wfu, 1L, 0L, null);
        }
        label141:
        String str1 = this.rQe;
        String str2 = this.rXp;
        if (this.BHi == null) {
          break label482;
        }
        localObject = this.BHi.version;
        label169:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.BHg) && (!bt.isNullOrNil(this.rXp)))
        {
          if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pjm, 0) != 1) {
            break label490;
          }
          paramBoolean = true;
          label225:
          ad.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          if (paramBoolean)
          {
            this.BHs = ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).aca(this.rXp);
            if ((this.BHs != null) && (this.BHs.length() < 8)) {
              this.BHs = null;
            }
          }
          ad.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.BHs });
        }
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.BHg), this.rXp });
        if (this.rQk == null)
        {
          this.rQk = GameWebPerformanceInfo.qd(paramString);
          this.rQk.fUW = d.aAg(paramString);
          paramString = this.rQk;
          if (!this.BHg) {
            break label495;
          }
        }
      }
    }
    label482:
    label490:
    label495:
    for (int i = 1;; i = 0)
    {
      paramString.fUP = i;
      this.rQk.fVr = a.etj();
      this.rQk.fVs = ett();
      paramBoolean = this.BHg;
      AppMethodBeat.o(110540);
      return paramBoolean;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.rQe, this.rXp, ((com.tencent.mm.plugin.wepkg.model.b)localObject).wfu, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(((com.tencent.mm.plugin.wepkg.model.b)localObject).BIw));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.rQe, this.rXp, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(8));
      break label141;
      localObject = "";
      break label169;
      paramBoolean = false;
      break label225;
    }
  }
  
  public final String etr()
  {
    if (!this.BHg) {
      this.BHs = null;
    }
    return this.BHs;
  }
  
  public final boolean ets()
  {
    return (this.BHi == null) || (!this.BHi.BJt);
  }
  
  public final String ett()
  {
    if (this.BHi != null) {
      return this.BHi.version;
    }
    return "";
  }
  
  public final void o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(110542);
    ad.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aLL = System.currentTimeMillis();
    b(paramWebView, azD(paramString));
    AppMethodBeat.o(110542);
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
    if ((this.BHg) && (this.BHh != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      ad.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!bt.isNullOrNil(paramString))
      {
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.BHh.UH(d.aAi(paramString));
        if (!bt.isNullOrNil(paramString))
        {
          ad.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          h.vKh.idkeyStat(859L, 14L, 1L, false);
          AppMethodBeat.o(110546);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(110546);
    return null;
  }
  
  public final void p(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(110543);
    ad.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aLL != 0L)
    {
      l = System.currentTimeMillis() - this.aLL;
      str = d.aAg(paramString);
      if (!bt.isNullOrNil(str)) {
        break label148;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aLL = 0L;
      if ((this.BHg) && (this.BHh != null) && ((!bt.isNullOrNil(this.BHs)) || (this.BHh.azW(paramString))))
      {
        ad.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        this.cOx.av(1000L, 1000L);
      }
      b(paramWebView, azD(paramString));
      AppMethodBeat.o(110543);
      return;
      label148:
      if ((this.BHg) && (this.BHi != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.BHi.fUW, this.BHi.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final void tM(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    this.cOx.stopTimer();
    if ((paramBoolean) && (!bt.isNullOrNil(this.rXp)))
    {
      b.Mf(this.rXp);
      com.tencent.mm.plugin.wepkg.model.c.etK().fn(this.rXp, 2);
    }
    b.eto();
    com.tencent.mm.plugin.wepkg.event.c.b(this.BHj);
    AppMethodBeat.o(110541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c
 * JD-Core Version:    0.7.0.1
 */