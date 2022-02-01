package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebResourceRequest;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class aq
{
  private int CqK;
  private ArrayList<String> CqL;
  private ArrayList<String> CqM;
  public List<Integer> CqN;
  private final Map<String, Boolean> CqO;
  private final Set<String> CqP;
  private Context mContext;
  
  public aq(Context paramContext)
  {
    AppMethodBeat.i(79032);
    this.CqK = -1;
    this.mContext = paramContext;
    this.CqN = new ArrayList();
    this.CqO = new HashMap();
    this.CqP = new HashSet();
    this.CqL = new ArrayList();
    this.CqM = new ArrayList();
    AppMethodBeat.o(79032);
  }
  
  private boolean a(String paramString, com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(79035);
    Iterator localIterator;
    if (this.CqK == -1) {
      try
      {
        parame = parame.k(31, null);
        if (parame != null)
        {
          this.CqK = parame.getInt("webview_ad_intercept_control_flag");
          this.CqL = parame.getStringArrayList("webview_ad_intercept_whitelist_domins");
          this.CqM = parame.getStringArrayList("webview_ad_intercept_blacklist_domins");
          parame = new StringBuilder();
          parame.append("white domain list :\n");
          localIterator = this.CqL.iterator();
          while (localIterator.hasNext()) {
            parame.append((String)localIterator.next()).append("\n");
          }
        }
        if (this.CqK != 0) {
          break label213;
        }
      }
      catch (Exception parame)
      {
        ac.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[] { parame.getMessage() });
        this.CqK = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(79035);
      return false;
      parame.append("black list domain list : \n");
      localIterator = this.CqM.iterator();
      while (localIterator.hasNext()) {
        parame.append((String)localIterator.next()).append("\n");
      }
      ac.i("MicroMsg.WebViewResourceInterrupter", parame.toString());
    }
    label213:
    parame = Uri.parse(paramString).getHost();
    ac.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[] { parame, this.CqO.get(parame) });
    if (bs.isNullOrNil(parame))
    {
      AppMethodBeat.o(79035);
      return false;
    }
    if (this.CqO.containsKey(parame))
    {
      boolean bool = ((Boolean)this.CqO.get(parame)).booleanValue();
      AppMethodBeat.o(79035);
      return bool;
    }
    String str;
    if ((this.CqL != null) && (this.CqL.size() > 0))
    {
      localIterator = this.CqL.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bs.isNullOrNil(str)) && (parame.contains(str)))
        {
          this.CqO.put(parame, Boolean.FALSE);
          ac.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
          AppMethodBeat.o(79035);
          return false;
        }
      }
    }
    if ((this.CqM != null) && (this.CqM.size() > 0))
    {
      localIterator = this.CqM.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bs.isNullOrNil(str)) && (parame.contains(str)))
        {
          if (this.CqK == 1)
          {
            this.CqO.put(parame, Boolean.TRUE);
            ac.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[] { str, paramString });
            AppMethodBeat.o(79035);
            return true;
          }
          if (this.CqK == 2)
          {
            ac.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[] { str, paramString });
            this.CqP.add(parame);
            this.CqO.put(parame, Boolean.FALSE);
            AppMethodBeat.o(79035);
            return false;
          }
        }
      }
    }
    this.CqO.put(parame, Boolean.FALSE);
    AppMethodBeat.o(79035);
    return false;
  }
  
  public com.tencent.xweb.WebResourceResponse a(String paramString, WebResourceRequest paramWebResourceRequest, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(79033);
    if (paramWebResourceRequest != null) {}
    for (paramString = paramWebResourceRequest.getUrl().toString(); bs.isNullOrNil(paramString); paramString = null)
    {
      ac.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
      AppMethodBeat.o(79033);
      return null;
    }
    if (paramString.startsWith("weixin://game.js"))
    {
      if ((this.mContext == null) || (!(this.mContext instanceof GameWebViewUI)))
      {
        AppMethodBeat.o(79033);
        return null;
      }
      paramString = ((GameWebViewUI)this.mContext).CEM;
      if (paramString == null) {
        break label1061;
      }
    }
    label1061:
    for (paramBoolean = paramString.CZo;; paramBoolean = false)
    {
      paramString = com.tencent.mm.plugin.webview.ui.tools.game.d.uy(paramBoolean);
      if (paramString != null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramString = new com.tencent.xweb.WebResourceResponse(paramString.getMimeType(), paramString.getEncoding(), paramString.getStatusCode(), paramString.getReasonPhrase(), paramString.getResponseHeaders(), paramString.getData());
          AppMethodBeat.o(79033);
          return paramString;
        }
        paramString = new com.tencent.xweb.WebResourceResponse(paramString.getMimeType(), paramString.getEncoding(), paramString.getData());
        AppMethodBeat.o(79033);
        return paramString;
      }
      AppMethodBeat.o(79033);
      return null;
      Object localObject;
      if (paramString.startsWith("weixin://resourceid/"))
      {
        ac.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
        try
        {
          paramString = parame.fp(paramString, 1);
          if (bs.isNullOrNil(paramString)) {
            ac.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
          }
          for (paramString = null;; paramString = aw.aCc(paramString))
          {
            paramString = new com.tencent.xweb.WebResourceResponse("image/*", "utf-8", paramString);
            AppMethodBeat.o(79033);
            return paramString;
          }
          if (!paramBoolean) {
            break label552;
          }
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(79033);
          return null;
        }
      }
      else
      {
        int i;
        if ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.webview.luggage.c.b.Rp(paramString))) {
          i = 0;
        }
        while (i != 0)
        {
          ac.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
          paramString = new com.tencent.xweb.WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
          AppMethodBeat.o(79033);
          return paramString;
          paramWebResourceRequest = paramString.toLowerCase();
          if ((paramWebResourceRequest.contains("localhost")) || (paramWebResourceRequest.contains("127.0.0.1")) || (paramWebResourceRequest.contains("::1")) || (paramWebResourceRequest.contains(g.DS())))
          {
            if ((this.CqN != null) && (this.CqN.size() > 0)) {
              localObject = this.CqN.iterator();
            }
          }
          else {
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                i = ((Integer)((Iterator)localObject).next()).intValue();
                if ((paramWebResourceRequest.contains("localhost:".concat(String.valueOf(i)))) || (paramWebResourceRequest.contains("127.0.0.1:".concat(String.valueOf(i)))))
                {
                  ac.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { paramWebResourceRequest, Integer.valueOf(i) });
                  i = 0;
                  break;
                }
              }
            }
          }
          ac.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { paramWebResourceRequest });
          i = 1;
        }
      }
      label552:
      if (a(paramString, parame))
      {
        ac.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[] { paramString });
        paramString = new com.tencent.xweb.WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        AppMethodBeat.o(79033);
        return paramString;
      }
      label943:
      for (;;)
      {
        try
        {
          long l1;
          long l2;
          if (com.tencent.mm.plugin.webview.ui.tools.d.isEnabled())
          {
            paramWebResourceRequest = com.tencent.mm.plugin.webview.ui.tools.d.eCX();
            parame = Uri.parse(paramString);
            localObject = parame.getHost();
            if ((paramWebResourceRequest != null) && (localObject != null) && (paramWebResourceRequest.equals(ah.dg((String)localObject + com.tencent.mm.plugin.normsg.a.b.vor.aon("\003&+21")))))
            {
              paramWebResourceRequest = parame.getQueryParameterNames();
              if ((paramWebResourceRequest != null) && (paramWebResourceRequest.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))))
              {
                ac.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
                if (bs.isNullOrNil(paramString)) {
                  ac.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                }
              }
              else
              {
                if (!com.tencent.mm.plugin.webview.ui.tools.d.isBlock()) {
                  continue;
                }
                ac.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
                if (!bs.isNullOrNil(paramString)) {
                  break label943;
                }
                ac.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                paramString = new com.tencent.xweb.WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
                AppMethodBeat.o(79033);
                return paramString;
              }
              try
              {
                paramWebResourceRequest = ai.getContext().getSharedPreferences("qar_cycle_rec", 0);
                parame = "qaj_tick_" + ah.dg(paramString);
                l1 = paramWebResourceRequest.getLong(parame, 0L);
                l2 = System.currentTimeMillis();
                if (l2 - l1 <= TimeUnit.HOURS.toMillis(24L)) {
                  continue;
                }
                paramWebResourceRequest.edit().putLong(parame, l2).commit();
                com.tencent.mm.plugin.report.e.wTc.a(16195, paramString.replace(",", "%2C"), false, true);
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(943L, 0L, 1L, false);
              }
              catch (Throwable paramWebResourceRequest)
              {
                ac.printErrStackTrace("MicroMsg.WebViewReporter", paramWebResourceRequest, "", new Object[0]);
              }
              continue;
            }
          }
          try
          {
            paramWebResourceRequest = ai.getContext().getSharedPreferences("qar_cycle_rec", 0);
            paramString = "qab_tick_" + ah.dg(paramString);
            l1 = paramWebResourceRequest.getLong(paramString, 0L);
            l2 = System.currentTimeMillis();
            if (l2 - l1 > TimeUnit.HOURS.toMillis(24L))
            {
              paramWebResourceRequest.edit().putLong(paramString, l2).commit();
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(943L, 1L, 1L, false);
            }
          }
          catch (Throwable paramString)
          {
            ac.printErrStackTrace("MicroMsg.WebViewReporter", paramString, "", new Object[0]);
          }
        }
        catch (Throwable paramString)
        {
          AppMethodBeat.o(79033);
          return null;
        }
      }
    }
  }
  
  public final boolean aBW(String paramString)
  {
    AppMethodBeat.i(188340);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188340);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(188340);
      return false;
    }
    boolean bool = this.CqP.remove(paramString);
    AppMethodBeat.o(188340);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aq
 * JD-Core Version:    0.7.0.1
 */