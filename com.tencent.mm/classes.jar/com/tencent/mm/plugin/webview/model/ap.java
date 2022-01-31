package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.s;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ap
{
  private Context mContext;
  private int uWm;
  public ArrayList<String> uWn;
  public ArrayList<String> uWo;
  public List<Integer> uWp;
  public final Map<String, Boolean> uWq;
  public final Set<String> uWr;
  private String uWs;
  
  public ap(Context paramContext)
  {
    AppMethodBeat.i(6739);
    this.uWm = -1;
    this.uWs = null;
    this.mContext = paramContext;
    this.uWp = new ArrayList();
    this.uWq = new HashMap();
    this.uWr = new HashSet();
    this.uWn = new ArrayList();
    this.uWo = new ArrayList();
    AppMethodBeat.o(6739);
  }
  
  private boolean b(String paramString, com.tencent.mm.plugin.webview.stub.d paramd)
  {
    AppMethodBeat.i(6741);
    Iterator localIterator;
    if (this.uWm == -1) {
      try
      {
        paramd = paramd.i(31, null);
        if (paramd != null)
        {
          this.uWm = paramd.getInt("webview_ad_intercept_control_flag");
          this.uWn = paramd.getStringArrayList("webview_ad_intercept_whitelist_domins");
          this.uWo = paramd.getStringArrayList("webview_ad_intercept_blacklist_domins");
          paramd = new StringBuilder();
          paramd.append("white domain list :\n");
          localIterator = this.uWn.iterator();
          while (localIterator.hasNext()) {
            paramd.append((String)localIterator.next()).append("\n");
          }
        }
        if (this.uWm != 0) {
          break label215;
        }
      }
      catch (Exception paramd)
      {
        ab.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[] { paramd.getMessage() });
        this.uWm = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(6741);
      return false;
      paramd.append("black list domain list : \n");
      localIterator = this.uWo.iterator();
      while (localIterator.hasNext()) {
        paramd.append((String)localIterator.next()).append("\n");
      }
      ab.i("MicroMsg.WebViewResourceInterrupter", paramd.toString());
    }
    label215:
    paramd = Uri.parse(paramString).getHost();
    ab.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[] { paramd, this.uWq.get(paramd) });
    if (bo.isNullOrNil(paramd))
    {
      AppMethodBeat.o(6741);
      return false;
    }
    if (this.uWq.containsKey(paramd))
    {
      boolean bool = ((Boolean)this.uWq.get(paramd)).booleanValue();
      AppMethodBeat.o(6741);
      return bool;
    }
    String str;
    if ((this.uWn != null) && (this.uWn.size() > 0))
    {
      localIterator = this.uWn.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bo.isNullOrNil(str)) && (paramd.contains(str)))
        {
          this.uWq.put(paramd, Boolean.FALSE);
          ab.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
          AppMethodBeat.o(6741);
          return false;
        }
      }
    }
    if ((this.uWo != null) && (this.uWo.size() > 0))
    {
      localIterator = this.uWo.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bo.isNullOrNil(str)) && (paramd.contains(str)))
        {
          if (this.uWm == 1)
          {
            this.uWq.put(paramd, Boolean.TRUE);
            ab.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[] { str, paramString });
            AppMethodBeat.o(6741);
            return true;
          }
          if (this.uWm == 2)
          {
            ab.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[] { str, paramString });
            this.uWr.add(paramd);
            this.uWq.put(paramd, Boolean.FALSE);
            AppMethodBeat.o(6741);
            return false;
          }
        }
      }
    }
    this.uWq.put(paramd, Boolean.FALSE);
    AppMethodBeat.o(6741);
    return false;
  }
  
  private s dcb()
  {
    AppMethodBeat.i(6743);
    int i = ((a)g.E(a.class)).a(a.a.lUs, 1);
    if (i == 0)
    {
      ab.i("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, canPreInjectJsBridge: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(6743);
      return null;
    }
    if ((this.mContext != null) && ((this.mContext instanceof WebViewUI))) {
      ((WebViewUI)this.mContext).veQ = false;
    }
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(this.uWs))
      {
        localObject = new ByteArrayInputStream(new String(org.apache.commons.a.c.toByteArray(ah.getContext().getAssets().open("jsapi/wxjs.js"))).replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.uWs).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true").getBytes("UTF-8"));
        ab.i("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, ranDomStr: %s, hashCode: %d", new Object[] { this.uWs, Integer.valueOf(hashCode()) });
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
        localHashMap.put("Pragma", "no-cache");
        localHashMap.put("Expires", "0");
        localObject = new s("application/javascript", "utf-8", 200, "OK", localHashMap, (InputStream)localObject);
        AppMethodBeat.o(6743);
        return localObject;
        localObject = ah.getContext().getAssets().open("jsapi/wxjs.js");
      }
      return null;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(6743);
    }
  }
  
  public final s a(String paramString, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.d paramd)
  {
    AppMethodBeat.i(6740);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
      AppMethodBeat.o(6740);
      return null;
    }
    if (paramString.startsWith("weixin://bridge.js"))
    {
      paramString = dcb();
      AppMethodBeat.o(6740);
      return paramString;
    }
    if (paramString.startsWith("weixin://game.js"))
    {
      if ((this.mContext == null) || (!(this.mContext instanceof GameWebViewUI)))
      {
        AppMethodBeat.o(6740);
        return null;
      }
      paramString = ((GameWebViewUI)this.mContext).vmq;
      if (paramString == null) {
        break label1086;
      }
    }
    label1086:
    for (paramBoolean = paramString.vEy;; paramBoolean = false)
    {
      paramString = com.tencent.mm.plugin.webview.ui.tools.game.d.oA(paramBoolean);
      if (paramString != null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramString = new s(paramString.getMimeType(), paramString.getEncoding(), paramString.getStatusCode(), paramString.getReasonPhrase(), paramString.getResponseHeaders(), paramString.getData());
          AppMethodBeat.o(6740);
          return paramString;
        }
        paramString = new s(paramString.getMimeType(), paramString.getEncoding(), paramString.getData());
        AppMethodBeat.o(6740);
        return paramString;
      }
      AppMethodBeat.o(6740);
      return null;
      Object localObject1;
      Object localObject2;
      if (paramString.startsWith("weixin://resourceid/"))
      {
        ab.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
        try
        {
          paramString = paramd.dP(paramString, 1);
          if (bo.isNullOrNil(paramString)) {
            ab.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
          }
          for (paramString = null;; paramString = ar.ahq(paramString))
          {
            paramString = new s("image/*", "utf-8", paramString);
            AppMethodBeat.o(6740);
            return paramString;
          }
          if (!paramBoolean) {
            break label575;
          }
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(6740);
          return null;
        }
      }
      else
      {
        int i;
        if ((bo.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.webview.luggage.c.b.Fl(paramString))) {
          i = 0;
        }
        while (i != 0)
        {
          ab.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
          paramString = new s("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
          AppMethodBeat.o(6740);
          return paramString;
          localObject1 = paramString.toLowerCase();
          if ((((String)localObject1).contains("localhost")) || (((String)localObject1).contains("127.0.0.1")) || (((String)localObject1).contains("::1")) || (((String)localObject1).contains(u.bQm())))
          {
            if ((this.uWp != null) && (this.uWp.size() > 0)) {
              localObject2 = this.uWp.iterator();
            }
          }
          else {
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                i = ((Integer)((Iterator)localObject2).next()).intValue();
                if ((((String)localObject1).contains("localhost:".concat(String.valueOf(i)))) || (((String)localObject1).contains("127.0.0.1:".concat(String.valueOf(i)))))
                {
                  ab.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { localObject1, Integer.valueOf(i) });
                  i = 0;
                  break;
                }
              }
            }
          }
          ab.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { localObject1 });
          i = 1;
        }
      }
      label575:
      if (b(paramString, paramd))
      {
        ab.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[] { paramString });
        paramString = new s("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        AppMethodBeat.o(6740);
        return paramString;
      }
      label968:
      for (;;)
      {
        try
        {
          long l1;
          long l2;
          if (f.isEnabled())
          {
            paramd = f.ddC();
            localObject1 = Uri.parse(paramString);
            localObject2 = ((Uri)localObject1).getHost();
            if ((paramd != null) && (localObject2 != null) && (paramd.equals(ag.cE((String)localObject2 + com.tencent.mm.plugin.normsg.a.b.pgQ.Wd("\003&+21")))))
            {
              paramd = ((Uri)localObject1).getQueryParameterNames();
              if ((paramd != null) && (paramd.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))))
              {
                ab.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
                if (bo.isNullOrNil(paramString)) {
                  ab.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                }
              }
              else
              {
                if (!f.isBlock()) {
                  continue;
                }
                ab.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
                if (!bo.isNullOrNil(paramString)) {
                  break label968;
                }
                ab.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                paramString = new s("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
                AppMethodBeat.o(6740);
                return paramString;
              }
              try
              {
                paramd = ah.getContext().getSharedPreferences("qar_cycle_rec", 0);
                localObject1 = "qaj_tick_" + ag.cE(paramString);
                l1 = paramd.getLong((String)localObject1, 0L);
                l2 = System.currentTimeMillis();
                if (l2 - l1 <= TimeUnit.HOURS.toMillis(24L)) {
                  continue;
                }
                paramd.edit().putLong((String)localObject1, l2).commit();
                e.qrI.a(16195, paramString.replace(",", "%2C"), false, true);
                e.qrI.idkeyStat(943L, 0L, 1L, false);
              }
              catch (Throwable paramd)
              {
                ab.printErrStackTrace("MicroMsg.WebViewReporter", paramd, "", new Object[0]);
              }
              continue;
            }
          }
          try
          {
            paramd = ah.getContext().getSharedPreferences("qar_cycle_rec", 0);
            paramString = "qab_tick_" + ag.cE(paramString);
            l1 = paramd.getLong(paramString, 0L);
            l2 = System.currentTimeMillis();
            if (l2 - l1 > TimeUnit.HOURS.toMillis(24L))
            {
              paramd.edit().putLong(paramString, l2).commit();
              e.qrI.idkeyStat(943L, 1L, 1L, false);
            }
          }
          catch (Throwable paramString)
          {
            ab.printErrStackTrace("MicroMsg.WebViewReporter", paramString, "", new Object[0]);
          }
        }
        catch (Throwable paramString)
        {
          AppMethodBeat.o(6740);
          return null;
        }
      }
    }
  }
  
  public final void ahj(String paramString)
  {
    AppMethodBeat.i(6742);
    this.uWs = paramString;
    ab.i("MicroMsg.WebViewResourceInterrupter", "setDgtVerifyRandomStr, ranDomStr: %s, hashCode: %d", new Object[] { this.uWs, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(6742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ap
 * JD-Core Version:    0.7.0.1
 */