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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private static final Pattern jMJ;
  private String CZA;
  public boolean CZB;
  public boolean CZo;
  private com.tencent.mm.plugin.wepkg.model.g CZp;
  private WepkgVersion CZq;
  private com.tencent.mm.plugin.wepkg.event.a CZr;
  private e CZs;
  private boolean CZt;
  private boolean CZu;
  public com.tencent.mm.plugin.wepkg.event.b CZv;
  private boolean CZw;
  private Set<String> CZx;
  private long CZy;
  public boolean CZz;
  private long aMB;
  private au cLS;
  public String sXV;
  private GameWebPerformanceInfo sYb;
  private String tfh;
  
  static
  {
    AppMethodBeat.i(110556);
    jMJ = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(110556);
  }
  
  public c()
  {
    AppMethodBeat.i(110539);
    this.aMB = 0L;
    this.CZo = false;
    this.CZt = false;
    this.CZu = false;
    this.CZw = false;
    this.CZx = new HashSet();
    this.CZz = true;
    this.cLS = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(110538);
        if ((c.b(c.this)) && (!c.c(c.this)))
        {
          ac.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
          ap.f(new Runnable()
          {
            public final void run()
            {
              int i = 0;
              AppMethodBeat.i(110537);
              try
              {
                ac.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                if (!bs.isNullOrNil(c.this.eIK())) {
                  i = 1;
                }
                c.d(c.this);
                int j = c.eIP();
                if (j > 1)
                {
                  if (c.e(c.this) != null)
                  {
                    if (i == 0) {
                      break label172;
                    }
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", c.f(c.this), c.e(c.this).fYR, c.e(c.this).version, 1L, 0L, null);
                  }
                  for (;;)
                  {
                    h.wUl.idkeyStat(859L, 13L, 1L, false);
                    String str = d.aFy(c.f(c.this));
                    b.Ql(str);
                    com.tencent.mm.plugin.wepkg.model.c.eJd().az(str, 1, 2);
                    c.eIQ();
                    c.g(c.this);
                    AppMethodBeat.o(110537);
                    return;
                    label172:
                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", c.f(c.this), c.e(c.this).fYR, c.e(c.this).version, -1L, 0L, null);
                  }
                }
                c.Wi(j + 1);
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
          c.Wi(0);
        }
      }
    }, false);
    b.eIE();
    this.CZs = new e();
    b.eIF();
    this.CZr = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void dI(Object paramAnonymousObject)
      {
        AppMethodBeat.i(110535);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.DaB != null) && (paramAnonymousObject.DaB.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.DaB;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.eIB())) || ((!bs.isNullOrNil(c.a(c.this))) && (str.equals(c.a(c.this)))))
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
          if ((paramAnonymousObject != null) && (paramAnonymousObject.fYR != null) && ((paramAnonymousObject.fYR.equals(a.eIB())) || (paramAnonymousObject.fYR.equals(c.a(c.this))))) {
            c.a(c.this, paramAnonymousObject.fYR, paramAnonymousObject.success, paramAnonymousObject.Daz);
          }
        }
        AppMethodBeat.o(110535);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.CZr);
    AppMethodBeat.o(110539);
  }
  
  public static boolean bP(String paramString)
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
  
  public static String eIN()
  {
    AppMethodBeat.i(210469);
    String str = a.eIC();
    AppMethodBeat.o(210469);
    return str;
  }
  
  private void eIO()
  {
    AppMethodBeat.i(199865);
    this.CZz = false;
    ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).agT(this.tfh);
    AppMethodBeat.o(199865);
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(110544);
    this.CZu = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!bs.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        ac.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.CZt = true;
      }
      AppMethodBeat.o(110544);
      return;
    }
  }
  
  public final WebResourceResponse aET(String paramString)
  {
    AppMethodBeat.i(110545);
    ac.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    Object localObject = b.aER(paramString);
    if (localObject != null)
    {
      ac.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(localObject)));
      localObject = a.aEN((String)localObject);
      if (localObject != null)
      {
        AppMethodBeat.o(110545);
        return localObject;
      }
    }
    localObject = d.aFy(paramString);
    if (!((String)localObject).equals(this.tfh))
    {
      ac.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", new Object[] { localObject });
      this.CZs.aFm(paramString);
    }
    if (this.CZo) {
      if (this.CZp == null) {
        break label207;
      }
    }
    label207:
    for (localObject = this.CZp.aFn(d.aFA(paramString));; localObject = null)
    {
      if (localObject != null)
      {
        if (this.CZq != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.CZq.fYR, this.CZq.version, 1L, 0L, null);
        }
        ac.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", new Object[] { paramString });
        AppMethodBeat.o(110545);
        return localObject;
      }
      paramString = this.CZs.aFn(d.aFA(paramString));
      AppMethodBeat.o(110545);
      return paramString;
    }
  }
  
  public final boolean aEU(String paramString)
  {
    AppMethodBeat.i(110549);
    if (jMJ.matcher(bs.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(110549);
      return false;
    }
    boolean bool = this.CZo;
    AppMethodBeat.o(110549);
    return bool;
  }
  
  public final void b(final WebView paramWebView, final boolean paramBoolean)
  {
    AppMethodBeat.i(110547);
    ac.i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:".concat(String.valueOf(paramBoolean)));
    ap.f(new Runnable()
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
        ac.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
        AppMethodBeat.o(110536);
      }
    });
    AppMethodBeat.o(110547);
  }
  
  public final boolean cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110540);
    this.sXV = paramString;
    this.tfh = d.aFy(paramString);
    Object localObject = b.cp(paramString, paramBoolean);
    if (localObject != null) {
      if (((com.tencent.mm.plugin.wepkg.model.g)localObject).eJc())
      {
        this.CZp = ((com.tencent.mm.plugin.wepkg.model.g)localObject);
        this.CZo = true;
        this.CZq = this.CZp.DaU;
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.sXV, this.tfh, this.CZq.version, 2L, 0L, null);
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.sXV, this.tfh, this.CZq.version, 1L, 0L, null);
        if (((com.tencent.mm.plugin.wepkg.model.b)localObject).DaG) {
          com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.sXV, this.tfh, ((com.tencent.mm.plugin.wepkg.model.b)localObject).xqK, 1L, 0L, null);
        }
        label141:
        String str1 = this.sXV;
        String str2 = this.tfh;
        if (this.CZq == null) {
          break label482;
        }
        localObject = this.CZq.version;
        label169:
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", str1, str2, (String)localObject, 0L, 0L, null);
        if ((this.CZo) && (!bs.isNullOrNil(this.tfh)))
        {
          if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pMD, 0) != 1) {
            break label490;
          }
          paramBoolean = true;
          label225:
          ac.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", new Object[] { Boolean.valueOf(paramBoolean) });
          if (paramBoolean)
          {
            this.CZA = ((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class)).agS(this.tfh);
            if ((this.CZA != null) && (this.CZA.length() < 8)) {
              this.CZA = null;
            }
          }
          ac.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", new Object[] { this.CZA });
        }
        ac.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.CZo), this.tfh });
        if (this.sYb == null)
        {
          this.sYb = GameWebPerformanceInfo.tq(paramString);
          this.sYb.fYR = d.aFy(paramString);
          paramString = this.sYb;
          if (!this.CZo) {
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
      paramString.fYK = i;
      this.sYb.fZm = a.eIC();
      this.sYb.fZn = eIM();
      paramBoolean = this.CZo;
      AppMethodBeat.o(110540);
      return paramBoolean;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.sXV, this.tfh, ((com.tencent.mm.plugin.wepkg.model.b)localObject).xqK, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Wj(((com.tencent.mm.plugin.wepkg.model.b)localObject).DaF));
      break;
      com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.sXV, this.tfh, null, 3L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Wj(8));
      break label141;
      localObject = "";
      break label169;
      paramBoolean = false;
      break label225;
    }
  }
  
  public final String eIK()
  {
    if (!this.CZo) {
      this.CZA = null;
    }
    return this.CZA;
  }
  
  public final boolean eIL()
  {
    return (this.CZq == null) || (!this.CZq.DbC);
  }
  
  public final String eIM()
  {
    if (this.CZq != null) {
      return this.CZq.version;
    }
    return "";
  }
  
  public final void o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(110542);
    ac.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aMB = System.currentTimeMillis();
    b(paramWebView, aEU(paramString));
    AppMethodBeat.o(110542);
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(110546);
    if (paramBundle == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.Wepkg.WePkgPlugin", "method = %s, bundler == null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((!bs.isNullOrNil(paramString)) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(110546);
      return null;
    }
    if ((this.CZo) && (this.CZp != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      ac.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!bs.isNullOrNil(paramString))
      {
        ac.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.CZp.YT(d.aFA(paramString));
        if (!bs.isNullOrNil(paramString))
        {
          ac.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          h.wUl.idkeyStat(859L, 14L, 1L, false);
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
    ac.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aMB != 0L)
    {
      l = System.currentTimeMillis() - this.aMB;
      str = d.aFy(paramString);
      if (!bs.isNullOrNil(str)) {
        break label148;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aMB = 0L;
      if ((this.CZo) && (this.CZp != null) && ((!bs.isNullOrNil(this.CZA)) || (this.CZp.aFo(paramString))))
      {
        ac.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        this.cLS.au(1000L, 1000L);
      }
      b(paramWebView, aEU(paramString));
      AppMethodBeat.o(110543);
      return;
      label148:
      if ((this.CZo) && (this.CZq != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.CZq.fYR, this.CZq.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final void uO(boolean paramBoolean)
  {
    AppMethodBeat.i(110541);
    this.cLS.stopTimer();
    if ((paramBoolean) && (!bs.isNullOrNil(this.tfh)))
    {
      b.Ql(this.tfh);
      com.tencent.mm.plugin.wepkg.model.c.eJd().az(this.tfh, 2, 1);
    }
    b.eIH();
    com.tencent.mm.plugin.wepkg.event.c.b(this.CZr);
    AppMethodBeat.o(110541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c
 * JD-Core Version:    0.7.0.1
 */