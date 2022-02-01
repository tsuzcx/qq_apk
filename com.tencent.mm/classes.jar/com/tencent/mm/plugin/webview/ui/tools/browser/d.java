package com.tencent.mm.plugin.webview.ui.tools.browser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserConfigManager;", "", "()V", "TAG", "", "allowBrowserList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "blockBrowserList", "enableBlockBrowser", "", "addAllowBrowserList", "", "configString", "addBlockBrowserList", "enableFilterBlockBrowser", "getAllowBrowserList", "", "getBlockBrowserList", "isAllowBrowser", "packageName", "isBlockBrowser", "plugin-webview_release"})
public final class d
{
  private static final HashSet<String> QiZ;
  private static boolean Qja;
  private static final HashSet<String> Qjb;
  public static final d Qjc;
  
  static
  {
    AppMethodBeat.i(268394);
    Qjc = new d();
    QiZ = ak.ai(new String[] { "com.tencent.mtt", "com.tencent.mtt.x86", "com.tencent.mtt.qbx", "com.tencent.qbx5", "com.ucmobile", "com.ucmobile.lite", "com.android.chrome", "com.baidu.browser.apps", "com.baidu.searchbox", "com.baidu.searchbox.lite", "com.ijinshan.browser_fast", "com.qihoo.browser", "com.qihoo.contents", "org.mozilla.firefox", "sogou.mobile.explorer" });
    Qjb = new HashSet();
    String str = ((b)h.ae(b.class)).a(b.a.vNJ, "");
    p.j(str, "allowConfig1");
    bmw(str);
    str = ((b)h.ae(b.class)).a(b.a.vNK, "");
    p.j(str, "allowConfig2");
    bmw(str);
    if (((b)h.ae(b.class)).a(b.a.vNN, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Qja = bool;
      str = ((b)h.ae(b.class)).a(b.a.vNL, "");
      p.j(str, "blockConfig1");
      bmx(str);
      str = ((b)h.ae(b.class)).a(b.a.vNM, "");
      p.j(str, "blockConfig2");
      bmx(str);
      Log.i("MicroMsg.BrowserConfigManager", "alvinluo initBrowserConfig allowBrowserList size: " + QiZ.size() + ", " + QiZ + ", enableBlockBrowser: " + Qja + ", blockBrowserList size: " + Qjb.size() + ", " + Qjb);
      AppMethodBeat.o(268394);
      return;
    }
  }
  
  private static void bmw(String paramString)
  {
    AppMethodBeat.i(268387);
    paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
    label123:
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (str == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(268387);
        throw paramString;
      }
      str = str.toLowerCase();
      p.j(str, "(this as java.lang.String).toLowerCase()");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (QiZ.contains(str))) {
          break label123;
        }
        QiZ.add(str);
        break;
      }
    }
    AppMethodBeat.o(268387);
  }
  
  private static void bmx(String paramString)
  {
    AppMethodBeat.i(268389);
    paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
    label123:
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (str == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(268389);
        throw paramString;
      }
      str = str.toLowerCase();
      p.j(str, "(this as java.lang.String).toLowerCase()");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (Qjb.contains(str))) {
          break label123;
        }
        Qjb.add(str);
        break;
      }
    }
    AppMethodBeat.o(268389);
  }
  
  public static boolean bmy(String paramString)
  {
    AppMethodBeat.i(268391);
    Iterable localIterable = (Iterable)QiZ;
    if (paramString != null)
    {
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(268391);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.j(paramString, "(this as java.lang.String).toLowerCase()");
    }
    for (;;)
    {
      boolean bool = j.a(localIterable, paramString);
      AppMethodBeat.o(268391);
      return bool;
      paramString = null;
    }
  }
  
  public static boolean bmz(String paramString)
  {
    AppMethodBeat.i(268392);
    Iterable localIterable = (Iterable)Qjb;
    if (paramString != null)
    {
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(268392);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.j(paramString, "(this as java.lang.String).toLowerCase()");
    }
    for (;;)
    {
      boolean bool = j.a(localIterable, paramString);
      AppMethodBeat.o(268392);
      return bool;
      paramString = null;
    }
  }
  
  public static boolean gZI()
  {
    return Qja;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.d
 * JD-Core Version:    0.7.0.1
 */