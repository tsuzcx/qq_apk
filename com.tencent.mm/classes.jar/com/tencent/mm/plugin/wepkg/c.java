package com.tencent.mm.plugin.wepkg;

import android.os.Bundle;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class c
{
  private static final Pattern fsW = Pattern.compile(".*#.*wechat_redirect");
  private long aoF = 0L;
  private am byQ = new am(new c.3(this), false);
  private String kMs;
  private GameWebPerformanceInfo kMv;
  private String kQf;
  private boolean rNU = false;
  private com.tencent.mm.plugin.wepkg.model.d rNV;
  public WepkgVersion rNW;
  public boolean rNX;
  private com.tencent.mm.plugin.wepkg.event.a rNY;
  
  public c()
  {
    b.cjE();
    this.rNY = new c.1(this);
    com.tencent.mm.plugin.wepkg.event.b.a(this.rNY);
  }
  
  private void a(WebView paramWebView, boolean paramBoolean)
  {
    y.i("MicroMsg.WePkgPlugin", "useWepkg:" + paramBoolean);
    ai.d(new c.2(this, paramWebView, paramBoolean));
  }
  
  public static String cjJ()
  {
    return a.cjC();
  }
  
  public final m UP(String paramString)
  {
    Object localObject2 = null;
    y.i("MicroMsg.WePkgPlugin", "onRequestIntercept, url: " + paramString);
    Object localObject1 = b.UN(paramString);
    if (localObject1 != null)
    {
      y.i("MicroMsg.WePkgPlugin", "onRequestIntercept, rid: " + (String)localObject1);
      localObject1 = a.fJ(paramString, (String)localObject1);
      if (localObject1 == null) {}
    }
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (!this.rNU);
    if (this.rNV != null) {}
    for (m localm = this.rNV.Vd(com.tencent.mm.plugin.wepkg.utils.d.Vs(paramString));; localm = null)
    {
      localObject1 = localObject2;
      if (localm == null) {
        break;
      }
      if (this.rNW != null) {
        com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", paramString, this.rNW.dCD, this.rNW.version, 1L, 0L, null);
      }
      return localm;
    }
  }
  
  public final boolean UQ(String paramString)
  {
    if (fsW.matcher(bk.pm(paramString)).find()) {
      return false;
    }
    return this.rNU;
  }
  
  public abstract void aYy();
  
  public final boolean bu(String paramString, boolean paramBoolean)
  {
    this.kMs = paramString;
    this.rNV = b.bt(paramString, paramBoolean);
    if ((this.rNV != null) && (this.rNV.rPj != null))
    {
      this.rNU = true;
      this.kQf = com.tencent.mm.plugin.wepkg.utils.d.Vq(paramString);
      this.rNW = this.rNV.rPj;
      com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.kMs, this.rNW.dCD, this.rNW.version, 1L, 0L, null);
    }
    y.i("MicroMsg.WePkgPlugin", "wepkgAvailable:%s", new Object[] { Boolean.valueOf(this.rNU) });
    if (this.kMv == null)
    {
      this.kMv = GameWebPerformanceInfo.fv(paramString);
      this.kMv.dCD = this.kQf;
      paramString = this.kMv;
      if (!this.rNU) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      paramString.dCB = i;
      return this.rNU;
    }
  }
  
  public final boolean cjI()
  {
    return (this.rNW == null) || (!this.rNW.rPS);
  }
  
  public final void g(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.WePkgPlugin", "onPageStarted, url = %s", new Object[] { paramString });
    this.aoF = System.currentTimeMillis();
    a(paramWebView, UQ(paramString));
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.WePkgPlugin", "onPageFinished, url = %s", new Object[] { paramString });
    long l;
    String str;
    if (this.aoF != 0L)
    {
      l = System.currentTimeMillis() - this.aoF;
      str = com.tencent.mm.plugin.wepkg.utils.d.Vq(paramString);
      if (bk.bl(str))
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, "", null, 2L, l, null);
        this.aoF = 0L;
      }
    }
    else if ((this.rNU) && (this.rNV != null))
    {
      if (this.rNV.Vd(com.tencent.mm.plugin.wepkg.utils.d.Vs(paramString)) == null) {
        break label196;
      }
    }
    label196:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        y.i("MicroMsg.WePkgPlugin", "startTimer");
        this.byQ.S(1000L, 1000L);
      }
      a(paramWebView, UQ(paramString));
      return;
      if ((this.rNU) && (this.rNW != null))
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, this.rNW.dCD, this.rNW.version, 1L, l, null);
        break;
      }
      com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", paramString, str, null, 0L, l, null);
      break;
    }
  }
  
  public final void lL(boolean paramBoolean)
  {
    this.byQ.stopTimer();
    if ((paramBoolean) && (!bk.bl(this.kQf)))
    {
      b.vW(this.kQf);
      e.Vf(this.kQf);
    }
    b.cjG();
    com.tencent.mm.plugin.wepkg.event.b.b(this.rNY);
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle == null)
    {
      bool = true;
      y.i("MicroMsg.WePkgPlugin", "method = %s, bundler == null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
      if ((!bk.bl(paramString)) && (paramBundle != null)) {
        break label47;
      }
    }
    for (;;)
    {
      return null;
      bool = false;
      break;
      label47:
      if ((this.rNU) && (this.rNV != null) && (paramString.equalsIgnoreCase("shouldInterceptMediaUrl")))
      {
        paramBundle = paramBundle.getString("url");
        y.i("MicroMsg.WePkgPlugin", "onMiscCallBack origin mediaUrl:" + paramBundle);
        if (!bk.bl(paramBundle))
        {
          y.i("MicroMsg.WePkgPlugin", "onMiscCallBack replace localPath");
          paramString = this.rNV;
          paramBundle = com.tencent.mm.plugin.wepkg.utils.d.Vs(paramBundle);
          if ((!bk.bl(paramBundle)) && (paramString.rPu != null) && (paramString.rPu.get(paramBundle) != null))
          {
            paramString = (WepkgPreloadFile)paramString.rPu.get(paramBundle);
            if (!bk.bl(paramString.filePath))
            {
              paramBundle = new File(paramString.filePath);
              if ((!paramBundle.exists()) || (!paramBundle.isFile()) || (paramBundle.length() != paramString.size)) {}
            }
          }
          for (paramString = paramString.filePath; !bk.bl(paramString); paramString = null)
          {
            y.i("MicroMsg.WePkgPlugin", "localFile:" + paramString);
            h.nFQ.a(859L, 14L, 1L, false);
            return paramString;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.c
 * JD-Core Version:    0.7.0.1
 */