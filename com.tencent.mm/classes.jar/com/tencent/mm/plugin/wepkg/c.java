package com.tencent.mm.plugin.wepkg;

import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private static final Pattern hpo;
  private long aqZ;
  private ap caS;
  private String nkp;
  private GameWebPerformanceInfo nkv;
  private String nog;
  private WepkgVersion vEA;
  private com.tencent.mm.plugin.wepkg.event.a vEB;
  private com.tencent.mm.plugin.wepkg.model.d vEC;
  private boolean vED;
  private boolean vEE;
  public com.tencent.mm.plugin.wepkg.event.b vEF;
  private boolean vEG;
  private Set<String> vEH;
  private long vEI;
  public boolean vEy;
  private f vEz;
  
  static
  {
    AppMethodBeat.i(63385);
    hpo = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(63385);
  }
  
  public c()
  {
    AppMethodBeat.i(63368);
    this.aqZ = 0L;
    this.vEy = false;
    this.vED = false;
    this.vEE = false;
    this.vEG = false;
    this.vEH = new HashSet();
    this.caS = new ap(new c.3(this), false);
    b.dke();
    this.vEC = new com.tencent.mm.plugin.wepkg.model.d();
    b.dkf();
    this.vEB = new com.tencent.mm.plugin.wepkg.event.a()
    {
      public final void cm(Object paramAnonymousObject)
      {
        AppMethodBeat.i(63364);
        if ((paramAnonymousObject instanceof ForceUpdateNotify))
        {
          paramAnonymousObject = (ForceUpdateNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.vFF != null) && (paramAnonymousObject.vFF.length > 0))
          {
            paramAnonymousObject = paramAnonymousObject.vFF;
            int j = paramAnonymousObject.length;
            int i = 0;
            while (i < j)
            {
              String str = paramAnonymousObject[i];
              if ((str.equals(a.dkb())) || ((!bo.isNullOrNil(c.a(c.this))) && (str.equals(c.a(c.this)))))
              {
                c.a(c.this, str);
                AppMethodBeat.o(63364);
                return;
              }
              i += 1;
            }
          }
          AppMethodBeat.o(63364);
          return;
        }
        if ((paramAnonymousObject instanceof DownloadBigPkgCompleteNotify))
        {
          paramAnonymousObject = (DownloadBigPkgCompleteNotify)paramAnonymousObject;
          if ((paramAnonymousObject != null) && (paramAnonymousObject.ezY != null) && ((paramAnonymousObject.ezY.equals(a.dkb())) || (paramAnonymousObject.ezY.equals(c.a(c.this))))) {
            c.a(c.this, paramAnonymousObject.ezY, paramAnonymousObject.success);
          }
        }
        AppMethodBeat.o(63364);
      }
    };
    com.tencent.mm.plugin.wepkg.event.c.a(this.vEB);
    AppMethodBeat.o(63368);
  }
  
  private void b(WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(63376);
    ab.i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:".concat(String.valueOf(paramBoolean)));
    al.d(new c.2(this, paramWebView, paramBoolean));
    AppMethodBeat.o(63376);
  }
  
  public static String dkl()
  {
    AppMethodBeat.i(156915);
    String str = a.dkc();
    AppMethodBeat.o(156915);
    return str;
  }
  
  public final void a(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(63373);
    this.vEE = true;
    if (paramConsoleMessage != null) {}
    for (paramConsoleMessage = paramConsoleMessage.message();; paramConsoleMessage = null)
    {
      if ((!bo.isNullOrNil(paramConsoleMessage)) && (paramConsoleMessage.equalsIgnoreCase("weixin://whiteScreenEnd")))
      {
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
        this.vED = true;
      }
      AppMethodBeat.o(63373);
      return;
    }
  }
  
  public final s akj(String paramString)
  {
    AppMethodBeat.i(63374);
    ab.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(paramString)));
    Object localObject = b.akh(paramString);
    if (localObject != null)
    {
      ab.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(localObject)));
      s locals = a.akd((String)localObject);
      if (locals != null)
      {
        AppMethodBeat.o(63374);
        return locals;
      }
      if (!((String)localObject).equals(this.nog)) {
        this.vEC.akA(paramString);
      }
    }
    if (this.vEy) {
      if (this.vEz == null) {
        break label170;
      }
    }
    label170:
    for (localObject = this.vEz.akB(com.tencent.mm.plugin.wepkg.utils.d.akO(paramString));; localObject = null)
    {
      if (localObject != null)
      {
        if (this.vEA != null) {
          com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.vEA.ezY, this.vEA.version, 1L, 0L, null);
        }
        AppMethodBeat.o(63374);
        return localObject;
      }
      paramString = this.vEC.akB(com.tencent.mm.plugin.wepkg.utils.d.akO(paramString));
      AppMethodBeat.o(63374);
      return paramString;
    }
  }
  
  public final boolean akk(String paramString)
  {
    AppMethodBeat.i(63378);
    if (hpo.matcher(bo.nullAsNil(paramString)).find())
    {
      AppMethodBeat.o(63378);
      return false;
    }
    boolean bool = this.vEy;
    AppMethodBeat.o(63378);
    return bool;
  }
  
  public final boolean bV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63369);
    this.nkp = paramString;
    this.nog = com.tencent.mm.plugin.wepkg.utils.d.akM(paramString);
    this.vEz = b.bU(paramString, paramBoolean);
    if ((this.vEz != null) && (this.vEz.vGb != null))
    {
      this.vEy = true;
      this.vEA = this.vEz.vGb;
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.nkp, this.vEA.ezY, this.vEA.version, 1L, 0L, null);
    }
    ab.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", new Object[] { Boolean.valueOf(this.vEy), this.nog });
    if (this.nkv == null)
    {
      this.nkv = GameWebPerformanceInfo.lN(paramString);
      this.nkv.ezY = com.tencent.mm.plugin.wepkg.utils.d.akM(paramString);
      paramString = this.nkv;
      if (!this.vEy) {
        break label196;
      }
    }
    label196:
    for (int i = 1;; i = 0)
    {
      paramString.ezR = i;
      this.nkv.eAt = a.dkc();
      this.nkv.eAu = dkk();
      paramBoolean = this.vEy;
      AppMethodBeat.o(63369);
      return paramBoolean;
    }
  }
  
  public final boolean dkj()
  {
    return (this.vEA == null) || (!this.vEA.vGJ);
  }
  
  public final String dkk()
  {
    if (this.vEA != null) {
      return this.vEA.version;
    }
    return "";
  }
  
  public final void k(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(63371);
    ab.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aqZ = System.currentTimeMillis();
    b(paramWebView, akk(paramString));
    AppMethodBeat.o(63371);
  }
  
  public final void l(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(63372);
    ab.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aqZ != 0L)
    {
      l = System.currentTimeMillis() - this.aqZ;
      str = com.tencent.mm.plugin.wepkg.utils.d.akM(paramString);
      if (!bo.isNullOrNil(str)) {
        break label137;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
    }
    for (;;)
    {
      this.aqZ = 0L;
      if ((this.vEy) && (this.vEz != null) && (this.vEz.akC(paramString)))
      {
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
        this.caS.ag(1000L, 1000L);
      }
      b(paramWebView, akk(paramString));
      AppMethodBeat.o(63372);
      return;
      label137:
      if ((this.vEy) && (this.vEA != null)) {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.vEA.ezY, this.vEA.version, 1L, l, null);
      } else {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      }
    }
  }
  
  public final void oW(boolean paramBoolean)
  {
    AppMethodBeat.i(63370);
    this.caS.stopTimer();
    if ((paramBoolean) && (!bo.isNullOrNil(this.nog)))
    {
      b.Ey(this.nog);
      com.tencent.mm.plugin.wepkg.model.b.dkA().ee(this.nog, 2);
    }
    b.dkh();
    com.tencent.mm.plugin.wepkg.event.c.b(this.vEB);
    AppMethodBeat.o(63370);
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(63375);
    if (paramBundle == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Wepkg.WePkgPlugin", "method = %s, bundler == null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((!bo.isNullOrNil(paramString)) && (paramBundle != null)) {
        break;
      }
      AppMethodBeat.o(63375);
      return null;
    }
    if ((this.vEy) && (this.vEz != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
    {
      paramString = paramBundle.getString("url");
      ab.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(paramString)));
      if (!bo.isNullOrNil(paramString))
      {
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
        paramString = this.vEz.Ly(com.tencent.mm.plugin.wepkg.utils.d.akO(paramString));
        if (!bo.isNullOrNil(paramString))
        {
          ab.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(paramString)));
          h.qsU.idkeyStat(859L, 14L, 1L, false);
          AppMethodBeat.o(63375);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(63375);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c
 * JD-Core Version:    0.7.0.1
 */