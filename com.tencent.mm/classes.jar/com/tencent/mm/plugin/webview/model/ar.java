package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
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
  private int Emm;
  private ArrayList<String> Emn;
  private ArrayList<String> Emo;
  public List<Integer> Emp;
  private final Map<String, Boolean> Emq;
  private final Set<String> Emr;
  private String Ems;
  private Context mContext;
  
  public ar(Context paramContext)
  {
    AppMethodBeat.i(79032);
    this.Emm = -1;
    this.Ems = null;
    this.mContext = paramContext;
    this.Emp = new ArrayList();
    this.Emq = new HashMap();
    this.Emr = new HashSet();
    this.Emn = new ArrayList();
    this.Emo = new ArrayList();
    AppMethodBeat.o(79032);
  }
  
  private boolean a(String paramString, com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(79035);
    Iterator localIterator;
    if (this.Emm == -1) {
      try
      {
        parame = parame.k(31, null);
        if (parame != null)
        {
          this.Emm = parame.getInt("webview_ad_intercept_control_flag");
          this.Emn = parame.getStringArrayList("webview_ad_intercept_whitelist_domins");
          this.Emo = parame.getStringArrayList("webview_ad_intercept_blacklist_domins");
          parame = new StringBuilder();
          parame.append("white domain list :\n");
          localIterator = this.Emn.iterator();
          while (localIterator.hasNext()) {
            parame.append((String)localIterator.next()).append("\n");
          }
        }
        if (this.Emm != 0) {
          break label213;
        }
      }
      catch (Exception parame)
      {
        ae.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[] { parame.getMessage() });
        this.Emm = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(79035);
      return false;
      parame.append("black list domain list : \n");
      localIterator = this.Emo.iterator();
      while (localIterator.hasNext()) {
        parame.append((String)localIterator.next()).append("\n");
      }
      ae.i("MicroMsg.WebViewResourceInterrupter", parame.toString());
    }
    label213:
    parame = Uri.parse(paramString).getHost();
    ae.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[] { parame, this.Emq.get(parame) });
    if (bu.isNullOrNil(parame))
    {
      AppMethodBeat.o(79035);
      return false;
    }
    if (this.Emq.containsKey(parame))
    {
      boolean bool = ((Boolean)this.Emq.get(parame)).booleanValue();
      AppMethodBeat.o(79035);
      return bool;
    }
    String str;
    if ((this.Emn != null) && (this.Emn.size() > 0))
    {
      localIterator = this.Emn.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bu.isNullOrNil(str)) && (parame.contains(str)))
        {
          this.Emq.put(parame, Boolean.FALSE);
          ae.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
          AppMethodBeat.o(79035);
          return false;
        }
      }
    }
    if ((this.Emo != null) && (this.Emo.size() > 0))
    {
      localIterator = this.Emo.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!bu.isNullOrNil(str)) && (parame.contains(str)))
        {
          if (this.Emm == 1)
          {
            this.Emq.put(parame, Boolean.TRUE);
            ae.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[] { str, paramString });
            AppMethodBeat.o(79035);
            return true;
          }
          if (this.Emm == 2)
          {
            ae.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[] { str, paramString });
            this.Emr.add(parame);
            this.Emq.put(parame, Boolean.FALSE);
            AppMethodBeat.o(79035);
            return false;
          }
        }
      }
    }
    this.Emq.put(parame, Boolean.FALSE);
    AppMethodBeat.o(79035);
    return false;
  }
  
  private boolean aIP(String paramString)
  {
    AppMethodBeat.i(79034);
    if ((bu.isNullOrNil(paramString)) || (!com.tencent.mm.plugin.webview.luggage.c.b.VG(paramString)))
    {
      AppMethodBeat.o(79034);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((!paramString.contains("localhost")) && (!paramString.contains("127.0.0.1")) && (!paramString.contains("::1")))
    {
      if (this.Ems == null) {
        this.Ems = g.Fy();
      }
      if (!paramString.contains(this.Ems)) {}
    }
    else
    {
      if ((this.Emp != null) && (this.Emp.size() > 0))
      {
        Iterator localIterator = this.Emp.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          if ((paramString.contains("localhost:".concat(String.valueOf(i)))) || (paramString.contains("127.0.0.1:".concat(String.valueOf(i)))))
          {
            ae.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { paramString, Integer.valueOf(i) });
            AppMethodBeat.o(79034);
            return false;
          }
        }
      }
      ae.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { paramString });
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
    for (paramString = paramWebResourceRequest.getUrl().toString(); bu.isNullOrNil(paramString); paramString = null)
    {
      ae.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
      AppMethodBeat.o(79033);
      return null;
    }
    if (paramString.startsWith("weixin://resourceid/"))
    {
      ae.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
      try
      {
        paramString = h.decodeFile(parame.fX(paramString, 2));
        paramWebResourceRequest = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.JPEG, 90, paramWebResourceRequest);
        paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(paramWebResourceRequest.toByteArray()));
        AppMethodBeat.o(79033);
        return paramString;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(79033);
        return null;
      }
    }
    if ((paramBoolean) && (aIP(paramString)))
    {
      ae.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
      paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
      AppMethodBeat.o(79033);
      return paramString;
    }
    if (a(paramString, parame))
    {
      ae.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[] { paramString });
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
          paramWebResourceRequest = d.eVB();
          parame = Uri.parse(paramString);
          String str = parame.getHost();
          if ((paramWebResourceRequest != null) && (str != null) && (paramWebResourceRequest.equals(aj.ej(str + com.tencent.mm.plugin.normsg.a.b.wJt.auA("\003&+21")))))
          {
            paramWebResourceRequest = parame.getQueryParameterNames();
            if ((paramWebResourceRequest != null) && (paramWebResourceRequest.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))))
            {
              ae.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
              if (bu.isNullOrNil(paramString)) {
                ae.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              }
            }
            else
            {
              if (!d.isBlock()) {
                continue;
              }
              ae.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
              if (!bu.isNullOrNil(paramString)) {
                break label613;
              }
              ae.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              paramString = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
              AppMethodBeat.o(79033);
              return paramString;
            }
            try
            {
              paramWebResourceRequest = ak.getContext().getSharedPreferences("qar_cycle_rec", 0);
              parame = "qaj_tick_" + aj.ej(paramString);
              l1 = paramWebResourceRequest.getLong(parame, 0L);
              l2 = System.currentTimeMillis();
              if (l2 - l1 <= TimeUnit.HOURS.toMillis(24L)) {
                continue;
              }
              paramWebResourceRequest.edit().putLong(parame, l2).commit();
              com.tencent.mm.plugin.report.e.ywz.a(16195, paramString.replace(",", "%2C"), false, true);
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(943L, 0L, 1L, false);
            }
            catch (Throwable paramWebResourceRequest)
            {
              ae.printErrStackTrace("MicroMsg.WebViewReporter", paramWebResourceRequest, "", new Object[0]);
            }
            continue;
          }
        }
        try
        {
          paramWebResourceRequest = ak.getContext().getSharedPreferences("qar_cycle_rec", 0);
          paramString = "qab_tick_" + aj.ej(paramString);
          l1 = paramWebResourceRequest.getLong(paramString, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > TimeUnit.HOURS.toMillis(24L))
          {
            paramWebResourceRequest.edit().putLong(paramString, l2).commit();
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(943L, 1L, 1L, false);
          }
        }
        catch (Throwable paramString)
        {
          ae.printErrStackTrace("MicroMsg.WebViewReporter", paramString, "", new Object[0]);
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(79033);
        return null;
      }
    }
  }
  
  public final boolean aIQ(String paramString)
  {
    AppMethodBeat.i(198140);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198140);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(198140);
      return false;
    }
    boolean bool = this.Emr.remove(paramString);
    AppMethodBeat.o(198140);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ar
 * JD-Core Version:    0.7.0.1
 */