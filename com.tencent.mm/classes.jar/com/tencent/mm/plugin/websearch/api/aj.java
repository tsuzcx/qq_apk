package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Pair;
import com.jg.JgClassChecked;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class aj
{
  private static av eRK = null;
  private static final Map<String, String> hly;
  private static final Map<String, String> hlz;
  private static final Pattern qUy = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
  
  static
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("silk", "audio/silk"));
    ((ArrayList)localObject).add(new Pair("jpg", "image/jpg"));
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      localHashMap1.put(localPair.first, localPair.second);
      localHashMap2.put(localPair.second, localPair.first);
    }
    hly = Collections.unmodifiableMap(localHashMap1);
    hlz = Collections.unmodifiableMap(localHashMap2);
  }
  
  public static void a(WebView paramWebView)
  {
    y.d("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "initIFrame");
    paramWebView.evaluateJavascript("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe); console.log('init frame')}", new aj.1());
  }
  
  public static String aX(Context paramContext, String paramString)
  {
    Object localObject = "MicroMsg.WebSearch.WebSearchPreloadApiLogic, appendUserAgent fail, context is null, stack = " + bk.csb();
    boolean bool;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue((String)localObject, bool);
      if (paramString != null) {
        break label191;
      }
    }
    label191:
    for (paramString = " MicroMessenger/";; paramString = paramString + " MicroMessenger/")
    {
      localObject = getPackageInfo(paramContext, ae.getPackageName());
      paramContext = paramString;
      if (localObject != null)
      {
        paramContext = paramString + e.ag(null, d.spa);
        paramContext = paramContext + "." + ((PackageInfo)localObject).versionCode;
      }
      paramString = aq.fH(ae.getContext());
      paramContext = paramContext + " NetType/" + paramString;
      paramContext = paramContext + " Language/" + x.fB(ae.getContext());
      y.i("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "appendUserAgent, uaStr = " + paramContext);
      return paramContext;
      bool = false;
      break;
    }
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if (paramString == null)
    {
      y.e("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "getPackageInfo fail, packageName is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.WebSearch.WebSearchPreloadApiLogic", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static boolean n(String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "url %s,prefix %s", new Object[] { paramString1, paramString2 });
    if ((paramString1 == null) || (paramString1.length() < 0) || (paramString2.length() < 0)) {}
    while (paramString2.length() > paramString1.length()) {
      return false;
    }
    if (paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length())))
    {
      y.i("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "true url %s,prefix %s", new Object[] { paramString1, paramString2 });
      return true;
    }
    y.i("MicroMsg.WebSearch.WebSearchPreloadApiLogic", "false %s,prefix %s", new Object[] { paramString1, paramString2 });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */