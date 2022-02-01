package com.tencent.mm.plugin.webview.ui.tools.browser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserConfigManager;", "", "()V", "TAG", "", "allowBrowserList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "blockBrowserList", "enableBlockBrowser", "", "addAllowBrowserList", "", "configString", "addBlockBrowserList", "enableFilterBlockBrowser", "getAllowBrowserList", "", "getBlockBrowserList", "isAllowBrowser", "packageName", "isBlockBrowser", "plugin-webview_release"})
public final class d
{
  private static final HashSet<String> JlH;
  private static boolean JlI;
  private static final HashSet<String> JlJ;
  public static final d JlK;
  
  static
  {
    AppMethodBeat.i(210434);
    JlK = new d();
    JlH = ak.ae(new String[] { "com.tencent.mtt", "com.tencent.mtt.x86", "com.tencent.mtt.qbx", "com.tencent.qbx5", "com.ucmobile", "com.ucmobile.lite", "com.android.chrome", "com.baidu.browser.apps", "com.baidu.searchbox", "com.baidu.searchbox.lite", "com.ijinshan.browser_fast", "com.qihoo.browser", "com.qihoo.contents", "org.mozilla.firefox", "sogou.mobile.explorer" });
    JlJ = new HashSet();
    String str = ((b)g.af(b.class)).a(b.a.see, "");
    p.g(str, "allowConfig1");
    bay(str);
    str = ((b)g.af(b.class)).a(b.a.sef, "");
    p.g(str, "allowConfig2");
    bay(str);
    if (((b)g.af(b.class)).a(b.a.sei, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      JlI = bool;
      str = ((b)g.af(b.class)).a(b.a.seg, "");
      p.g(str, "blockConfig1");
      baz(str);
      str = ((b)g.af(b.class)).a(b.a.seh, "");
      p.g(str, "blockConfig2");
      baz(str);
      Log.i("MicroMsg.BrowserConfigManager", "alvinluo initBrowserConfig allowBrowserList size: " + JlH.size() + ", " + JlH + ", enableBlockBrowser: " + JlI + ", blockBrowserList size: " + JlJ.size() + ", " + JlJ);
      AppMethodBeat.o(210434);
      return;
    }
  }
  
  public static boolean baA(String paramString)
  {
    AppMethodBeat.i(210432);
    Iterable localIterable = (Iterable)JlH;
    if (paramString != null)
    {
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(210432);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
    }
    for (;;)
    {
      boolean bool = j.a(localIterable, paramString);
      AppMethodBeat.o(210432);
      return bool;
      paramString = null;
    }
  }
  
  public static boolean baB(String paramString)
  {
    AppMethodBeat.i(210433);
    Iterable localIterable = (Iterable)JlJ;
    if (paramString != null)
    {
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(210433);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
    }
    for (;;)
    {
      boolean bool = j.a(localIterable, paramString);
      AppMethodBeat.o(210433);
      return bool;
      paramString = null;
    }
  }
  
  private static void bay(String paramString)
  {
    AppMethodBeat.i(210430);
    paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
    label123:
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (str == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(210430);
        throw paramString;
      }
      str = str.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (JlH.contains(str))) {
          break label123;
        }
        JlH.add(str);
        break;
      }
    }
    AppMethodBeat.o(210430);
  }
  
  private static void baz(String paramString)
  {
    AppMethodBeat.i(210431);
    paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
    label123:
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (str == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(210431);
        throw paramString;
      }
      str = str.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (JlJ.contains(str))) {
          break label123;
        }
        JlJ.add(str);
        break;
      }
    }
    AppMethodBeat.o(210431);
  }
  
  public static boolean ggu()
  {
    return JlI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.d
 * JD-Core Version:    0.7.0.1
 */