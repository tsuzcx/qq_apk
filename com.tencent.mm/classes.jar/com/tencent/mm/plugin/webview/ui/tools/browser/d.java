package com.tencent.mm.plugin.webview.ui.tools.browser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserConfigManager;", "", "()V", "TAG", "", "allowBrowserList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "blockBrowserList", "enableBlockBrowser", "", "addAllowBrowserList", "", "configString", "addBlockBrowserList", "enableFilterBlockBrowser", "getAllowBrowserList", "", "getBlockBrowserList", "isAllowBrowser", "packageName", "isBlockBrowser", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d XaV;
  private static final HashSet<String> XaW;
  private static boolean XaX;
  private static final HashSet<String> XaY;
  
  static
  {
    AppMethodBeat.i(296586);
    XaV = new d();
    XaW = ar.an(new String[] { "com.tencent.mtt", "com.tencent.mtt.x86", "com.tencent.mtt.qbx", "com.tencent.qbx5", "com.ucmobile", "com.ucmobile.lite", "com.android.chrome", "com.baidu.browser.apps", "com.baidu.searchbox", "com.baidu.searchbox.lite", "com.ijinshan.browser_fast", "com.qihoo.browser", "com.qihoo.contents", "org.mozilla.firefox", "sogou.mobile.explorer" });
    XaY = new HashSet();
    String str = ((c)h.ax(c.class)).a(c.a.zfQ, "");
    s.s(str, "allowConfig1");
    blX(str);
    str = ((c)h.ax(c.class)).a(c.a.zfR, "");
    s.s(str, "allowConfig2");
    blX(str);
    if (((c)h.ax(c.class)).a(c.a.zfU, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      XaX = bool;
      str = ((c)h.ax(c.class)).a(c.a.zfS, "");
      s.s(str, "blockConfig1");
      blY(str);
      str = ((c)h.ax(c.class)).a(c.a.zfT, "");
      s.s(str, "blockConfig2");
      blY(str);
      Log.i("MicroMsg.BrowserConfigManager", "alvinluo initBrowserConfig allowBrowserList size: " + XaW.size() + ", " + XaW + ", enableBlockBrowser: " + XaX + ", blockBrowserList size: " + XaY.size() + ", " + XaY);
      AppMethodBeat.o(296586);
      return;
    }
  }
  
  private static void blX(String paramString)
  {
    AppMethodBeat.i(296547);
    paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
    label123:
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(296547);
        throw paramString;
      }
      str = str.toLowerCase();
      s.s(str, "(this as java.lang.String).toLowerCase()");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (XaW.contains(str))) {
          break label123;
        }
        XaW.add(str);
        break;
      }
    }
    AppMethodBeat.o(296547);
  }
  
  private static void blY(String paramString)
  {
    AppMethodBeat.i(296554);
    paramString = ((Iterable)n.a((CharSequence)paramString, new String[] { ";" })).iterator();
    label123:
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(296554);
        throw paramString;
      }
      str = str.toLowerCase();
      s.s(str, "(this as java.lang.String).toLowerCase()");
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (XaY.contains(str))) {
          break label123;
        }
        XaY.add(str);
        break;
      }
    }
    AppMethodBeat.o(296554);
  }
  
  public static boolean blZ(String paramString)
  {
    AppMethodBeat.i(296561);
    Iterable localIterable = (Iterable)XaW;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      boolean bool = p.a(localIterable, paramString);
      AppMethodBeat.o(296561);
      return bool;
      paramString = paramString.toLowerCase();
      s.s(paramString, "(this as java.lang.String).toLowerCase()");
    }
  }
  
  public static boolean bma(String paramString)
  {
    AppMethodBeat.i(296569);
    Iterable localIterable = (Iterable)XaY;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      boolean bool = p.a(localIterable, paramString);
      AppMethodBeat.o(296569);
      return bool;
      paramString = paramString.toLowerCase();
      s.s(paramString, "(this as java.lang.String).toLowerCase()");
    }
  }
  
  public static boolean izL()
  {
    return XaX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.d
 * JD-Core Version:    0.7.0.1
 */