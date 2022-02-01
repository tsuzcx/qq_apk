package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "hasAuthorized", "", "hasAuthorization", "bizType", "", "bizKey", "", "isHostAllow", "host", "isHostBlock", "onTeenModeStatusChange", "overrideStartLoadBefore", "url", "intent", "Landroid/content/Intent;", "overrideUrlRedirect", "reason", "forceRedirect", "reqUrl", "fullUrl", "restoreController", "setTeenModeStatus", "", "authorized", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends m
{
  public static final a WMu;
  private static final ArrayList<String> WMw;
  private static final ArrayList<String> WMx;
  private boolean WMv;
  
  static
  {
    AppMethodBeat.i(298248);
    WMu = new a((byte)0);
    WMw = p.al(new String[] { "weixin.qq.com", "tenpay.com", "pay.weixin.qq.com", "payapp.weixin.qq.com", "wx.tenpay.com", "support.weixin.qq.com", "action.weixin.qq.com", "log.weixin.qq.com", "api.mch.weixin.qq.com", "act.weixin.qq.com", "res.wx.qq.com", "res2.wx.qq.com", "pingjs.qq.com", "badjs.weixinbridge.com", "mmbiz.qpic.cn", "wx.qlogo.cn", "wx.gtimg.com", "weixin110.qq.com", "security.wechat.com", "shminorshort.weixin.qq.com", "kf.qq.com" });
    WMx = p.al(new String[] { "game.weixin.qq.com" });
    String str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfM, "");
    s.s(str, "allowConfig1");
    a.bky(str);
    str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfN, "");
    s.s(str, "allowConfig2");
    a.bky(str);
    str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfO, "");
    s.s(str, "blockConfig1");
    a.bkz(str);
    str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfP, "");
    s.s(str, "blockConfig2");
    a.bkz(str);
    Log.i("MicroMsg.WebViewTeenModeInterceptor", "alvinluo initWebViewTeenModeInterceptor blockList size: %d, %s, allowList size: %d, %s", new Object[] { Integer.valueOf(WMx.size()), WMx, Integer.valueOf(WMw.size()), WMw });
    AppMethodBeat.o(298248);
  }
  
  private final void aL(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(298220);
    this.WMv = paramBoolean;
    BaseWebViewController localBaseWebViewController = getController();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localBaseWebViewController.Wwn = paramBoolean;
      getController().Wwo = paramString;
      AppMethodBeat.o(298220);
      return;
    }
  }
  
  private static boolean bkw(String paramString)
  {
    AppMethodBeat.i(298229);
    Iterator localIterator = ((Iterable)WMx).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((s.p(paramString, str)) || (n.rs(paramString, s.X(".", str))))
      {
        AppMethodBeat.o(298229);
        return true;
      }
    }
    AppMethodBeat.o(298229);
    return false;
  }
  
  private static boolean bkx(String paramString)
  {
    AppMethodBeat.i(298235);
    Iterator localIterator = ((Iterable)WMw).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((s.p(paramString, str)) || (n.rs(paramString, s.X(".", str))))
      {
        AppMethodBeat.o(298235);
        return true;
      }
    }
    AppMethodBeat.o(298235);
    return false;
  }
  
  private boolean jdMethod_do(int paramInt, String paramString)
  {
    AppMethodBeat.i(298225);
    s.u(paramString, "bizKey");
    Object localObject;
    try
    {
      localObject = getController().irJ();
      Bundle localBundle = new Bundle();
      localBundle.putInt("bizType", paramInt);
      localBundle.putString("bizKey", paramString);
      ah localah = ah.aiuX;
      localObject = ((e)localObject).m(257, localBundle);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        AppMethodBeat.o(298225);
        throw paramString;
      }
    }
    finally
    {
      Log.w("MicroMsg.WebViewTeenModeInterceptor", s.X("get hasAuthorization error ", paramString.getMessage()));
      AppMethodBeat.o(298225);
      return false;
    }
    boolean bool = ((Bundle)localObject).getBoolean("authorized", false);
    Log.i("MicroMsg.WebViewTeenModeInterceptor", "hasAuthorization:bizType=" + paramInt + ", bizKey = " + paramString + ", authorized = " + bool);
    AppMethodBeat.o(298225);
    return bool;
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(298252);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "fullUrl");
    paramString1 = (r)h.ax(r.class);
    if (paramString1 == null)
    {
      paramBoolean = false;
      if (paramBoolean)
      {
        paramString1 = (com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
        if ((paramString1 == null) || (paramString1.aiy(paramString2) != true)) {
          break label176;
        }
        paramInt = 1;
        label69:
        if (paramInt != 0)
        {
          this.WMv = jdMethod_do(2, com.tencent.mm.plugin.webview.k.c.XsF.bmV(paramString2));
          aL(this.WMv, paramString2);
          paramString2 = getController().WwI;
          if (!this.WMv) {
            break label181;
          }
        }
      }
    }
    label176:
    label181:
    for (paramString1 = "true";; paramString1 = "false")
    {
      paramString2.put("teenModeTemporaryAuthorized", paramString1);
      Log.d("MicroMsg.WebViewTeenModeInterceptor", s.X("overrideUrlRedirect teenModeTemporaryAuthorized=", getController().WwI.get("teenModeTemporaryAuthorized")));
      AppMethodBeat.o(298252);
      return false;
      paramBoolean = paramString1.aBu();
      break;
      paramInt = 0;
      break label69;
    }
  }
  
  public final boolean f(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(298259);
    s.u(paramString, "url");
    if (paramIntent == null) {
      bool = false;
    }
    while (!bool)
    {
      Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore not enableTeenModeCheck");
      aL(true, null);
      AppMethodBeat.o(298259);
      return false;
      try
      {
        bool = paramIntent.getBooleanExtra("key_enable_teen_mode_check", false);
      }
      catch (Exception paramIntent)
      {
        Log.printErrStackTrace("MicroMsg.WebViewTeenModeInterceptor", (Throwable)paramIntent, "overrideStartLoadBefore get enableTeenModeCheck exception", new Object[0]);
        aL(true, null);
        bool = false;
      }
    }
    boolean bool = ((r)h.ax(r.class)).aBu();
    Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore url: %s, isTeenMode: %s", new Object[] { paramString, Boolean.valueOf(bool) });
    if (!bool)
    {
      aL(true, null);
      AppMethodBeat.o(298259);
      return false;
    }
    paramIntent = Uri.parse(paramString).getHost();
    CharSequence localCharSequence = (CharSequence)paramIntent;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      aL(true, null);
      AppMethodBeat.o(298259);
      return false;
    }
    Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore host: %s, allow: %b, block: %b", new Object[] { paramIntent, Boolean.valueOf(bkx(paramIntent)), Boolean.valueOf(bkw(paramIntent)) });
    if ((bkx(paramIntent)) && (!bkw(paramIntent)))
    {
      aL(true, null);
      AppMethodBeat.o(298259);
      return false;
    }
    this.WMv = jdMethod_do(3, com.tencent.mm.plugin.webview.k.c.XsF.bmV(paramString));
    if (this.WMv)
    {
      Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore hasAuthorized");
      AppMethodBeat.o(298259);
      return false;
    }
    aL(this.WMv, paramString);
    BaseWebViewController.a(getController(), "https://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode", true, 0, 4);
    AppMethodBeat.o(298259);
    return true;
  }
  
  public final boolean isJ()
  {
    AppMethodBeat.i(298284);
    Object localObject1 = (r)h.ax(r.class);
    if (localObject1 == null) {}
    for (boolean bool = false; !bool; bool = ((r)localObject1).aBu())
    {
      AppMethodBeat.o(298284);
      return true;
    }
    localObject1 = getController().Wwo;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (n.bp((CharSequence)localObject2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(298284);
      return true;
    }
    localObject2 = (com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.brandservice.api.c)localObject2).aiy((String)localObject1) == true))
    {
      i = 1;
      if (i == 0) {
        break label271;
      }
    }
    label271:
    for (i = 2;; i = 3)
    {
      localObject2 = com.tencent.mm.plugin.webview.k.c.XsF.bmV((String)localObject1);
      bool = jdMethod_do(i, (String)localObject2);
      Log.i("MicroMsg.WebViewTeenModeInterceptor", "onTeenModeStatusChange bizType=" + i + ", bizKey = " + (String)localObject2 + " hasAuthorized=" + this.WMv + ", newHasAuthorized=" + bool + ", url=" + localObject1);
      if ((bool) && (!this.WMv))
      {
        this.WMv = bool;
        getController().sMP.loadUrl("about:blank");
        getController().WwQ = true;
        getController().m((String)localObject1, true, 8);
      }
      AppMethodBeat.o(298284);
      return true;
      i = 0;
      break;
    }
  }
  
  public final boolean isK()
  {
    AppMethodBeat.i(298263);
    isJ();
    AppMethodBeat.o(298263);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor$Companion;", "", "()V", "BIZ_TEEN_MODE_ENABLE_CHECK", "", "TAG", "", "allowDomainList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "blockDomainList", "addAllowList", "", "configString", "addBlockList", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void bky(String paramString)
    {
      AppMethodBeat.i(298285);
      paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
      label91:
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (aw.ivw().contains(str))) {
            break label91;
          }
          aw.ivw().add(str);
          break;
        }
      }
      AppMethodBeat.o(298285);
    }
    
    static void bkz(String paramString)
    {
      AppMethodBeat.i(298290);
      paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
      label91:
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (aw.ivx().contains(str))) {
            break label91;
          }
          aw.ivx().add(str);
          break;
        }
      }
      AppMethodBeat.o(298290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aw
 * JD-Core Version:    0.7.0.1
 */