package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.kernel.h;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "isHostAllow", "", "host", "", "isHostBlock", "overrideStartLoadBefore", "url", "intent", "Landroid/content/Intent;", "Companion", "plugin-webview_release"})
public final class aw
  extends k
{
  private static final ArrayList<String> PVO;
  private static final ArrayList<String> PVP;
  public static final a PVQ;
  
  static
  {
    AppMethodBeat.i(264842);
    PVQ = new a((byte)0);
    PVO = j.ag(new String[] { "weixin.qq.com", "inews.qq.com", "tenpay.com", "pay.weixin.qq.com", "payapp.weixin.qq.com", "wx.tenpay.com", "support.weixin.qq.com", "action.weixin.qq.com", "log.weixin.qq.com", "api.mch.weixin.qq.com", "act.weixin.qq.com", "res.wx.qq.com", "res2.wx.qq.com", "pingjs.qq.com", "badjs.weixinbridge.com", "mmbiz.qpic.cn", "wx.qlogo.cn", "wx.gtimg.com" });
    PVP = j.ag(new String[] { "game.weixin.qq.com" });
    String str = ((b)h.ae(b.class)).a(b.a.vNF, "");
    p.j(str, "allowConfig1");
    a.bkP(str);
    str = ((b)h.ae(b.class)).a(b.a.vNG, "");
    p.j(str, "allowConfig2");
    a.bkP(str);
    str = ((b)h.ae(b.class)).a(b.a.vNH, "");
    p.j(str, "blockConfig1");
    a.bkQ(str);
    str = ((b)h.ae(b.class)).a(b.a.vNI, "");
    p.j(str, "blockConfig2");
    a.bkQ(str);
    Log.i("MicroMsg.WebViewTeenModeInterceptor", "alvinluo initWebViewTeenModeInterceptor blockList size: %d, %s, allowList size: %d, %s", new Object[] { Integer.valueOf(PVP.size()), PVP, Integer.valueOf(PVO.size()), PVO });
    AppMethodBeat.o(264842);
  }
  
  private static boolean bkN(String paramString)
  {
    AppMethodBeat.i(264839);
    Iterator localIterator = ((Iterable)PVP).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((p.h(paramString, str)) || (n.pu(paramString, ".".concat(String.valueOf(str)))))
      {
        AppMethodBeat.o(264839);
        return true;
      }
    }
    AppMethodBeat.o(264839);
    return false;
  }
  
  private static boolean bkO(String paramString)
  {
    AppMethodBeat.i(264840);
    Iterator localIterator = ((Iterable)PVO).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((p.h(paramString, str)) || (n.pu(paramString, ".".concat(String.valueOf(str)))))
      {
        AppMethodBeat.o(264840);
        return true;
      }
    }
    AppMethodBeat.o(264840);
    return false;
  }
  
  public final boolean e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(264838);
    p.k(paramString, "url");
    if (paramIntent != null) {}
    try
    {
      for (bool = paramIntent.getBooleanExtra("key_enable_teen_mode_check", false); !bool; bool = false)
      {
        Log.d("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore not enableTeenModeCheck");
        AppMethodBeat.o(264838);
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
      paramIntent = h.ae(q.class);
      p.j(paramIntent, "MMKernel.service(IBizTeenModeService::class.java)");
      boolean bool = ((q)paramIntent).ZM();
      Log.d("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore url: %s, isTeenMode: %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(264838);
        return false;
      }
      paramString = Uri.parse(paramString);
      p.j(paramString, "uri");
      paramString = paramString.getHost();
      paramIntent = (CharSequence)paramString;
      if ((paramIntent == null) || (paramIntent.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(264838);
        return false;
      }
      Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore host: %s, allow: %b, block: %b", new Object[] { paramString, Boolean.valueOf(bkO(paramString)), Boolean.valueOf(bkN(paramString)) });
      if ((bkO(paramString)) && (!bkN(paramString)))
      {
        AppMethodBeat.o(264838);
        return false;
      }
      BaseWebViewController.a(getController(), "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode", true, 0, 4);
      AppMethodBeat.o(264838);
    }
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor$Companion;", "", "()V", "BIZ_TEEN_MODE_ENABLE_CHECK", "", "TAG", "", "allowDomainList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "blockDomainList", "addAllowList", "", "configString", "addBlockList", "plugin-webview_release"})
  public static final class a
  {
    static void bkP(String paramString)
    {
      AppMethodBeat.i(224394);
      paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
      label91:
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (aw.gVP().contains(str))) {
            break label91;
          }
          aw.gVP().add(str);
          break;
        }
      }
      AppMethodBeat.o(224394);
    }
    
    static void bkQ(String paramString)
    {
      AppMethodBeat.i(224395);
      paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
      label91:
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (aw.gVQ().contains(str))) {
            break label91;
          }
          aw.gVQ().add(str);
          break;
        }
      }
      AppMethodBeat.o(224395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aw
 * JD-Core Version:    0.7.0.1
 */