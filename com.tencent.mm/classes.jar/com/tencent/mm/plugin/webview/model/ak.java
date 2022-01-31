package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ak
{
  private int rfZ = -1;
  public ArrayList<String> rga = new ArrayList();
  public ArrayList<String> rgb = new ArrayList();
  public List<Integer> rgc = new ArrayList();
  public final Map<String, Boolean> rgd = new HashMap();
  public final Set<String> rge = new HashSet();
  public String rgf = null;
  
  private m b(com.tencent.mm.plugin.webview.stub.d paramd)
  {
    try
    {
      paramd = paramd.f(98, null);
      if (paramd == null) {
        return null;
      }
      try
      {
        Object localObject = bk.convertStreamToString(ae.getContext().getAssets().open("jsapi/wxjs.js"));
        paramd = (com.tencent.mm.plugin.webview.stub.d)localObject;
        if (!TextUtils.isEmpty(this.rgf)) {
          paramd = ((String)localObject).replace("__wx._getDgtVerifyRandomStr()", this.rgf).replace("__wx._isDgtVerifyEnabled()", "true");
        }
        paramd = new ByteArrayInputStream(paramd.getBytes("UTF-8"));
        localObject = new HashMap();
        ((HashMap)localObject).put("Cache-Control", "no-cache, no-store, must-revalidate");
        ((HashMap)localObject).put("Pragma", "no-cache");
        ((HashMap)localObject).put("Expires", "0");
        return new m("application/javascript", "utf-8", 200, "OK", (Map)localObject, paramd);
      }
      catch (Exception paramd)
      {
        y.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { paramd });
        return null;
      }
      return null;
    }
    catch (Exception paramd) {}
  }
  
  private boolean c(String paramString, com.tencent.mm.plugin.webview.stub.d paramd)
  {
    Iterator localIterator;
    if (this.rfZ == -1) {
      try
      {
        paramd = paramd.f(31, null);
        if (paramd != null)
        {
          this.rfZ = paramd.getInt("webview_ad_intercept_control_flag");
          this.rga = paramd.getStringArrayList("webview_ad_intercept_whitelist_domins");
          this.rgb = paramd.getStringArrayList("webview_ad_intercept_blacklist_domins");
          paramd = new StringBuilder();
          paramd.append("white domain list :\n");
          localIterator = this.rga.iterator();
          while (localIterator.hasNext()) {
            paramd.append((String)localIterator.next()).append("\n");
          }
        }
        if (this.rfZ != 0) {
          break label197;
        }
      }
      catch (Exception paramd)
      {
        y.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[] { paramd.getMessage() });
        this.rfZ = 0;
      }
    }
    for (;;)
    {
      return false;
      paramd.append("black list domain list : \n");
      localIterator = this.rgb.iterator();
      while (localIterator.hasNext()) {
        paramd.append((String)localIterator.next()).append("\n");
      }
      y.i("MicroMsg.WebViewResourceInterrupter", paramd.toString());
    }
    label197:
    paramd = Uri.parse(paramString).getHost();
    y.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[] { paramd, this.rgd.get(paramd) });
    if (bk.bl(paramd)) {
      return false;
    }
    if (this.rgd.containsKey(paramd)) {
      return ((Boolean)this.rgd.get(paramd)).booleanValue();
    }
    String str;
    if ((this.rga != null) && (this.rga.size() > 0))
    {
      localIterator = this.rga.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bk.bl(str)) && (paramd.contains(str)))
        {
          this.rgd.put(paramd, Boolean.valueOf(false));
          y.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
          return false;
        }
      }
    }
    if ((this.rgb != null) && (this.rgb.size() > 0))
    {
      localIterator = this.rgb.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bk.bl(str)) && (paramd.contains(str)))
        {
          if (this.rfZ == 1)
          {
            this.rgd.put(paramd, Boolean.valueOf(true));
            y.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[] { str, paramString });
            return true;
          }
          if (this.rfZ == 2)
          {
            y.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[] { str, paramString });
            this.rge.add(paramd);
            this.rgd.put(paramd, Boolean.valueOf(false));
            return false;
          }
        }
      }
    }
    this.rgd.put(paramd, Boolean.valueOf(false));
    return false;
  }
  
  public final m a(String paramString, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.d paramd)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
      return null;
    }
    if (paramString.startsWith("weixin://bridge.js")) {
      return b(paramd);
    }
    if (paramString.startsWith("weixin://resourceid/"))
    {
      y.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
      for (;;)
      {
        try
        {
          paramString = paramd.cQ(paramString, 1);
          if (bk.bl(paramString))
          {
            y.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
            paramString = null;
            paramString = new m("image/*", "utf-8", paramString);
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[] { paramString.getMessage() });
          return null;
        }
        paramString = am.Sr(paramString);
      }
    }
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      int i;
      if ((bk.bl(paramString)) || (!p.wD(paramString))) {
        i = 0;
      }
      while (i != 0)
      {
        y.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
        return new m("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        localObject1 = paramString.toLowerCase();
        if ((((String)localObject1).contains("localhost")) || (((String)localObject1).contains("127.0.0.1")) || (((String)localObject1).contains("::1")) || (((String)localObject1).contains(s.bil())))
        {
          if ((this.rgc != null) && (this.rgc.size() > 0)) {
            localObject2 = this.rgc.iterator();
          }
        }
        else {
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              i = ((Integer)((Iterator)localObject2).next()).intValue();
              if ((((String)localObject1).contains("localhost:" + i)) || (((String)localObject1).contains("127.0.0.1:" + i)))
              {
                y.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { localObject1, Integer.valueOf(i) });
                i = 0;
                break;
              }
            }
          }
        }
        y.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { localObject1 });
        i = 1;
      }
    }
    if (c(paramString, paramd))
    {
      y.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[] { paramString });
      return new m("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
    }
    for (;;)
    {
      try
      {
        if (com.tencent.mm.plugin.webview.ui.tools.d.isEnabled())
        {
          paramd = com.tencent.mm.plugin.webview.ui.tools.d.cdC();
          localObject1 = Uri.parse(paramString);
          localObject2 = ((Uri)localObject1).getHost();
          if ((paramd != null) && (localObject2 != null) && (paramd.equals(ad.bB((String)localObject2 + b.mGK.Kd("\003&+21")))))
          {
            paramd = ((Uri)localObject1).getQueryParameterNames();
            if ((paramd != null) && (paramd.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))))
            {
              y.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
              if (!bk.bl(paramString)) {
                break label629;
              }
              y.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
            }
            if (com.tencent.mm.plugin.webview.ui.tools.d.bqd())
            {
              y.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
              if (!bk.bl(paramString)) {
                break label771;
              }
              y.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              paramString = new m("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
              return paramString;
            }
          }
        }
      }
      catch (Throwable paramString) {}
      return null;
      label629:
      long l1;
      long l2;
      try
      {
        paramd = ae.getContext().getSharedPreferences("qar_cycle_rec", 0);
        localObject1 = "qaj_tick_" + ad.bB(paramString);
        l1 = paramd.getLong((String)localObject1, 0L);
        l2 = System.currentTimeMillis();
        if (l2 - l1 <= TimeUnit.HOURS.toMillis(24L)) {
          continue;
        }
        paramd.edit().putLong((String)localObject1, l2).commit();
        f.nEG.a(16195, paramString.replace(",", "%2C"), false, true);
        f.nEG.a(943L, 0L, 1L, false);
      }
      catch (Throwable paramd)
      {
        y.printErrStackTrace("MicroMsg.WebViewReporter", paramd, "", new Object[0]);
      }
      continue;
      try
      {
        label771:
        paramd = ae.getContext().getSharedPreferences("qar_cycle_rec", 0);
        paramString = "qab_tick_" + ad.bB(paramString);
        l1 = paramd.getLong(paramString, 0L);
        l2 = System.currentTimeMillis();
        if (l2 - l1 > TimeUnit.HOURS.toMillis(24L))
        {
          paramd.edit().putLong(paramString, l2).commit();
          f.nEG.a(943L, 1L, 1L, false);
        }
      }
      catch (Throwable paramString)
      {
        y.printErrStackTrace("MicroMsg.WebViewReporter", paramString, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */