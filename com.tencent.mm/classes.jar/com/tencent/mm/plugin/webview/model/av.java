package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "isHostAllow", "", "host", "", "isHostBlock", "overrideStartLoadBefore", "url", "intent", "Landroid/content/Intent;", "Companion", "plugin-webview_release"})
public final class av
  extends k
{
  private static final ArrayList<String> IZx;
  private static final ArrayList<String> IZy;
  public static final a IZz;
  
  static
  {
    AppMethodBeat.i(210364);
    IZz = new a((byte)0);
    IZx = j.ac(new String[] { "weixin.qq.com", "inews.qq.com", "tenpay.com", "pay.weixin.qq.com", "payapp.weixin.qq.com", "wx.tenpay.com", "support.weixin.qq.com", "action.weixin.qq.com", "log.weixin.qq.com", "api.mch.weixin.qq.com", "act.weixin.qq.com", "res.wx.qq.com", "res2.wx.qq.com", "pingjs.qq.com", "badjs.weixinbridge.com", "mmbiz.qpic.cn", "wx.qlogo.cn", "wx.gtimg.com" });
    IZy = j.ac(new String[] { "game.weixin.qq.com" });
    String str = ((b)g.af(b.class)).a(b.a.sea, "");
    p.g(str, "allowConfig1");
    a.aYU(str);
    str = ((b)g.af(b.class)).a(b.a.seb, "");
    p.g(str, "allowConfig2");
    a.aYU(str);
    str = ((b)g.af(b.class)).a(b.a.sec, "");
    p.g(str, "blockConfig1");
    a.aYV(str);
    str = ((b)g.af(b.class)).a(b.a.sed, "");
    p.g(str, "blockConfig2");
    a.aYV(str);
    Log.i("MicroMsg.WebViewTeenModeInterceptor", "alvinluo initWebViewTeenModeInterceptor blockList size: %d, %s, allowList size: %d, %s", new Object[] { Integer.valueOf(IZy.size()), IZy, Integer.valueOf(IZx.size()), IZx });
    AppMethodBeat.o(210364);
  }
  
  private static boolean aYS(String paramString)
  {
    AppMethodBeat.i(210362);
    Iterator localIterator = ((Iterable)IZy).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((p.j(paramString, str)) || (n.K(paramString, ".".concat(String.valueOf(str)), false)))
      {
        AppMethodBeat.o(210362);
        return true;
      }
    }
    AppMethodBeat.o(210362);
    return false;
  }
  
  private static boolean aYT(String paramString)
  {
    AppMethodBeat.i(210363);
    Iterator localIterator = ((Iterable)IZx).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((p.j(paramString, str)) || (n.K(paramString, ".".concat(String.valueOf(str)), false)))
      {
        AppMethodBeat.o(210363);
        return true;
      }
    }
    AppMethodBeat.o(210363);
    return false;
  }
  
  public final boolean e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(210361);
    p.h(paramString, "url");
    if (paramIntent != null) {}
    try
    {
      for (bool = paramIntent.getBooleanExtra("key_enable_teen_mode_check", false); !bool; bool = false)
      {
        Log.d("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore not enableTeenModeCheck");
        AppMethodBeat.o(210361);
        return false;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebViewTeenModeInterceptor", (Throwable)paramIntent, "overrideStartLoadBefore get enableTeenModeCheck exception", new Object[0]);
        bool = false;
      }
      paramIntent = g.af(q.class);
      p.g(paramIntent, "MMKernel.service(IBizTeenModeService::class.java)");
      boolean bool = ((q)paramIntent).Vt();
      Log.d("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore url: %s, isTeenMode: %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(210361);
        return false;
      }
      paramString = Uri.parse(paramString);
      p.g(paramString, "uri");
      paramString = paramString.getHost();
      paramIntent = (CharSequence)paramString;
      if ((paramIntent == null) || (paramIntent.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(210361);
        return false;
      }
      Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore host: %s, allow: %b, block: %b", new Object[] { paramString, Boolean.valueOf(aYT(paramString)), Boolean.valueOf(aYS(paramString)) });
      if ((aYT(paramString)) && (!aYS(paramString)))
      {
        AppMethodBeat.o(210361);
        return false;
      }
      BaseWebViewController.a(getController(), "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode", true, 0, 4);
      AppMethodBeat.o(210361);
    }
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor$Companion;", "", "()V", "BIZ_TEEN_MODE_ENABLE_CHECK", "", "TAG", "", "allowDomainList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "blockDomainList", "addAllowList", "", "configString", "addBlockList", "plugin-webview_release"})
  public static final class a
  {
    static void aYU(String paramString)
    {
      AppMethodBeat.i(210359);
      paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
      label91:
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (av.gcS().contains(str))) {
            break label91;
          }
          av.gcS().add(str);
          break;
        }
      }
      AppMethodBeat.o(210359);
    }
    
    static void aYV(String paramString)
    {
      AppMethodBeat.i(210360);
      paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
      label91:
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (av.gcT().contains(str))) {
            break label91;
          }
          av.gcT().add(str);
          break;
        }
      }
      AppMethodBeat.o(210360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.av
 * JD-Core Version:    0.7.0.1
 */