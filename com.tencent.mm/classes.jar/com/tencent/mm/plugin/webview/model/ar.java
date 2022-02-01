package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ar
{
  private int DUn;
  private ArrayList<String> DUo;
  private ArrayList<String> DUp;
  public List<Integer> DUq;
  private final Map<String, Boolean> DUr;
  private final Set<String> DUs;
  private String DUt;
  private Context mContext;
  
  public ar(Context paramContext)
  {
    AppMethodBeat.i(79032);
    this.DUn = -1;
    this.DUt = null;
    this.mContext = paramContext;
    this.DUq = new ArrayList();
    this.DUr = new HashMap();
    this.DUs = new HashSet();
    this.DUo = new ArrayList();
    this.DUp = new ArrayList();
    AppMethodBeat.o(79032);
  }
  
  private boolean a(String paramString, com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(79035);
    Iterator localIterator;
    if (this.DUn == -1) {
      try
      {
        parame = parame.k(31, null);
        if (parame != null)
        {
          this.DUn = parame.getInt("webview_ad_intercept_control_flag");
          this.DUo = parame.getStringArrayList("webview_ad_intercept_whitelist_domins");
          this.DUp = parame.getStringArrayList("webview_ad_intercept_blacklist_domins");
          parame = new StringBuilder();
          parame.append("white domain list :\n");
          localIterator = this.DUo.iterator();
          while (localIterator.hasNext()) {
            parame.append((String)localIterator.next()).append("\n");
          }
        }
        if (this.DUn != 0) {
          break label213;
        }
      }
      catch (Exception parame)
      {
        ad.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[] { parame.getMessage() });
        this.DUn = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(79035);
      return false;
      parame.append("black list domain list : \n");
      localIterator = this.DUp.iterator();
      while (localIterator.hasNext()) {
        parame.append((String)localIterator.next()).append("\n");
      }
      ad.i("MicroMsg.WebViewResourceInterrupter", parame.toString());
    }
    label213:
    parame = Uri.parse(paramString).getHost();
    ad.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[] { parame, this.DUr.get(parame) });
    if (bt.isNullOrNil(parame))
    {
      AppMethodBeat.o(79035);
      return false;
    }
    if (this.DUr.containsKey(parame))
    {
      boolean bool = ((Boolean)this.DUr.get(parame)).booleanValue();
      AppMethodBeat.o(79035);
      return bool;
    }
    String str;
    if ((this.DUo != null) && (this.DUo.size() > 0))
    {
      localIterator = this.DUo.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bt.isNullOrNil(str)) && (parame.contains(str)))
        {
          this.DUr.put(parame, Boolean.FALSE);
          ad.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
          AppMethodBeat.o(79035);
          return false;
        }
      }
    }
    if ((this.DUp != null) && (this.DUp.size() > 0))
    {
      localIterator = this.DUp.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bt.isNullOrNil(str)) && (parame.contains(str)))
        {
          if (this.DUn == 1)
          {
            this.DUr.put(parame, Boolean.TRUE);
            ad.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[] { str, paramString });
            AppMethodBeat.o(79035);
            return true;
          }
          if (this.DUn == 2)
          {
            ad.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[] { str, paramString });
            this.DUs.add(parame);
            this.DUr.put(parame, Boolean.FALSE);
            AppMethodBeat.o(79035);
            return false;
          }
        }
      }
    }
    this.DUr.put(parame, Boolean.FALSE);
    AppMethodBeat.o(79035);
    return false;
  }
  
  private boolean aHw(String paramString)
  {
    AppMethodBeat.i(79034);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.webview.luggage.c.b.UV(paramString)))
    {
      AppMethodBeat.o(79034);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((!paramString.contains("localhost")) && (!paramString.contains("127.0.0.1")) && (!paramString.contains("::1")))
    {
      if (this.DUt == null) {
        this.DUt = com.tencent.luggage.h.g.Fs();
      }
      if (!paramString.contains(this.DUt)) {}
    }
    else
    {
      if ((this.DUq != null) && (this.DUq.size() > 0))
      {
        Iterator localIterator = this.DUq.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          if ((paramString.contains("localhost:".concat(String.valueOf(i)))) || (paramString.contains("127.0.0.1:".concat(String.valueOf(i)))))
          {
            ad.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { paramString, Integer.valueOf(i) });
            AppMethodBeat.o(79034);
            return false;
          }
        }
      }
      ad.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { paramString });
      AppMethodBeat.o(79034);
      return true;
    }
    AppMethodBeat.o(79034);
    return false;
  }
  
  public WebResourceResponse a(String paramString, WebResourceRequest paramWebResourceRequest, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(79033);
    if (paramWebResourceRequest != null) {}
    for (paramString = paramWebResourceRequest.getUrl().toString(); bt.isNullOrNil(paramString); paramString = null)
    {
      ad.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
      AppMethodBeat.o(79033);
      return null;
    }
    if (paramString.startsWith("weixin://resourceid/"))
    {
      ad.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
      try
      {
        paramString = com.tencent.mm.sdk.platformtools.g.decodeFile(parame.fM(paramString, 2));
        paramWebResourceRequest = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.JPEG, 90, paramWebResourceRequest);
        paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(paramWebResourceRequest.toByteArray()));
        AppMethodBeat.o(79033);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(79033);
        return null;
      }
    }
    if ((paramBoolean) && (aHw(paramString)))
    {
      ad.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
      paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
      AppMethodBeat.o(79033);
      return paramString;
    }
    if (a(paramString, parame))
    {
      ad.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[] { paramString });
      paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
      AppMethodBeat.o(79033);
      return paramString;
    }
    label613:
    for (;;)
    {
      try
      {
        long l1;
        long l2;
        if (d.isEnabled())
        {
          paramWebResourceRequest = d.eRP();
          parame = Uri.parse(paramString);
          String str = parame.getHost();
          if ((paramWebResourceRequest != null) && (str != null) && (paramWebResourceRequest.equals(ai.ee(str + com.tencent.mm.plugin.normsg.a.b.wtJ.atn("\003&+21")))))
          {
            paramWebResourceRequest = parame.getQueryParameterNames();
            if ((paramWebResourceRequest != null) && (paramWebResourceRequest.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))))
            {
              ad.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
              if (bt.isNullOrNil(paramString)) {
                ad.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              }
            }
            else
            {
              if (!d.isBlock()) {
                continue;
              }
              ad.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
              if (!bt.isNullOrNil(paramString)) {
                break label613;
              }
              ad.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              paramString = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
              AppMethodBeat.o(79033);
              return paramString;
            }
            try
            {
              paramWebResourceRequest = aj.getContext().getSharedPreferences("qar_cycle_rec", 0);
              parame = "qaj_tick_" + ai.ee(paramString);
              l1 = paramWebResourceRequest.getLong(parame, 0L);
              l2 = System.currentTimeMillis();
              if (l2 - l1 <= TimeUnit.HOURS.toMillis(24L)) {
                continue;
              }
              paramWebResourceRequest.edit().putLong(parame, l2).commit();
              com.tencent.mm.plugin.report.e.ygI.a(16195, paramString.replace(",", "%2C"), false, true);
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(943L, 0L, 1L, false);
            }
            catch (Throwable paramWebResourceRequest)
            {
              ad.printErrStackTrace("MicroMsg.WebViewReporter", paramWebResourceRequest, "", new Object[0]);
            }
            continue;
          }
        }
        try
        {
          paramWebResourceRequest = aj.getContext().getSharedPreferences("qar_cycle_rec", 0);
          paramString = "qab_tick_" + ai.ee(paramString);
          l1 = paramWebResourceRequest.getLong(paramString, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > TimeUnit.HOURS.toMillis(24L))
          {
            paramWebResourceRequest.edit().putLong(paramString, l2).commit();
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(943L, 1L, 1L, false);
          }
        }
        catch (Throwable paramString)
        {
          ad.printErrStackTrace("MicroMsg.WebViewReporter", paramString, "", new Object[0]);
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(79033);
        return null;
      }
    }
  }
  
  public final boolean aHx(String paramString)
  {
    AppMethodBeat.i(207963);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(207963);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(207963);
      return false;
    }
    boolean bool = this.DUs.remove(paramString);
    AppMethodBeat.o(207963);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ar
 * JD-Core Version:    0.7.0.1
 */