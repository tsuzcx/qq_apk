package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
  private int IZm;
  private ArrayList<String> IZn;
  private ArrayList<String> IZo;
  public List<Integer> IZp;
  private final Map<String, Boolean> IZq;
  private final Set<String> IZr;
  private String IZs;
  private Context mContext;
  
  public ar(Context paramContext)
  {
    AppMethodBeat.i(79032);
    this.IZm = -1;
    this.IZs = null;
    this.mContext = paramContext;
    this.IZp = new ArrayList();
    this.IZq = new HashMap();
    this.IZr = new HashSet();
    this.IZn = new ArrayList();
    this.IZo = new ArrayList();
    AppMethodBeat.o(79032);
  }
  
  private boolean a(String paramString, com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(79035);
    Iterator localIterator;
    if (this.IZm == -1) {
      try
      {
        parame = parame.j(31, null);
        if (parame != null)
        {
          this.IZm = parame.getInt("webview_ad_intercept_control_flag");
          this.IZn = parame.getStringArrayList("webview_ad_intercept_whitelist_domins");
          this.IZo = parame.getStringArrayList("webview_ad_intercept_blacklist_domins");
          parame = new StringBuilder();
          parame.append("white domain list :\n");
          localIterator = this.IZn.iterator();
          while (localIterator.hasNext()) {
            parame.append((String)localIterator.next()).append("\n");
          }
        }
        if (this.IZm != 0) {
          break label213;
        }
      }
      catch (Exception parame)
      {
        Log.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[] { parame.getMessage() });
        this.IZm = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(79035);
      return false;
      parame.append("black list domain list : \n");
      localIterator = this.IZo.iterator();
      while (localIterator.hasNext()) {
        parame.append((String)localIterator.next()).append("\n");
      }
      Log.i("MicroMsg.WebViewResourceInterrupter", parame.toString());
    }
    label213:
    parame = Uri.parse(paramString).getHost();
    Log.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[] { parame, this.IZq.get(parame) });
    if (Util.isNullOrNil(parame))
    {
      AppMethodBeat.o(79035);
      return false;
    }
    if (this.IZq.containsKey(parame))
    {
      boolean bool = ((Boolean)this.IZq.get(parame)).booleanValue();
      AppMethodBeat.o(79035);
      return bool;
    }
    String str;
    if ((this.IZn != null) && (this.IZn.size() > 0))
    {
      localIterator = this.IZn.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!Util.isNullOrNil(str)) && (parame.contains(str)))
        {
          this.IZq.put(parame, Boolean.FALSE);
          Log.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
          AppMethodBeat.o(79035);
          return false;
        }
      }
    }
    if ((this.IZo != null) && (this.IZo.size() > 0))
    {
      localIterator = this.IZo.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if ((!Util.isNullOrNil(str)) && (parame.contains(str)))
        {
          if (this.IZm == 1)
          {
            this.IZq.put(parame, Boolean.TRUE);
            Log.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[] { str, paramString });
            AppMethodBeat.o(79035);
            return true;
          }
          if (this.IZm == 2)
          {
            Log.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[] { str, paramString });
            this.IZr.add(parame);
            this.IZq.put(parame, Boolean.FALSE);
            AppMethodBeat.o(79035);
            return false;
          }
        }
      }
    }
    this.IZq.put(parame, Boolean.FALSE);
    AppMethodBeat.o(79035);
    return false;
  }
  
  private boolean aYQ(String paramString)
  {
    AppMethodBeat.i(79034);
    if ((Util.isNullOrNil(paramString)) || (!b.afC(paramString)))
    {
      AppMethodBeat.o(79034);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((!paramString.contains("localhost")) && (!paramString.contains("127.0.0.1")) && (!paramString.contains("::1")))
    {
      if (this.IZs == null) {
        this.IZs = h.Ph();
      }
      if (!paramString.contains(this.IZs)) {}
    }
    else
    {
      if ((this.IZp != null) && (this.IZp.size() > 0))
      {
        Iterator localIterator = this.IZp.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          if ((paramString.contains("localhost:".concat(String.valueOf(i)))) || (paramString.contains("127.0.0.1:".concat(String.valueOf(i)))))
          {
            Log.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { paramString, Integer.valueOf(i) });
            AppMethodBeat.o(79034);
            return false;
          }
        }
      }
      Log.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { paramString });
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
    for (paramString = paramWebResourceRequest.getUrl().toString(); Util.isNullOrNil(paramString); paramString = null)
    {
      Log.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
      AppMethodBeat.o(79033);
      return null;
    }
    if (paramString.startsWith("weixin://resourceid/"))
    {
      Log.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
      try
      {
        paramString = BitmapUtil.decodeFile(parame.gu(paramString, 2));
        paramWebResourceRequest = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.JPEG, 90, paramWebResourceRequest);
        paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(paramWebResourceRequest.toByteArray()));
        AppMethodBeat.o(79033);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(79033);
        return null;
      }
    }
    if ((paramBoolean) && (aYQ(paramString)))
    {
      Log.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
      paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
      AppMethodBeat.o(79033);
      return paramString;
    }
    if (a(paramString, parame))
    {
      Log.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[] { paramString });
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
        if (com.tencent.mm.plugin.webview.ui.tools.d.isEnabled())
        {
          paramWebResourceRequest = com.tencent.mm.plugin.webview.ui.tools.d.geu();
          parame = Uri.parse(paramString);
          String str = parame.getHost();
          if ((paramWebResourceRequest != null) && (str != null) && (paramWebResourceRequest.equals(MD5Util.getMD5String(str + com.tencent.mm.plugin.normsg.a.d.AEF.aIJ("\003&+21")))))
          {
            paramWebResourceRequest = parame.getQueryParameterNames();
            if ((paramWebResourceRequest != null) && (paramWebResourceRequest.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))))
            {
              Log.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
              if (Util.isNullOrNil(paramString)) {
                Log.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              }
            }
            else
            {
              if (!com.tencent.mm.plugin.webview.ui.tools.d.isBlock()) {
                continue;
              }
              Log.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
              if (!Util.isNullOrNil(paramString)) {
                break label613;
              }
              Log.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
              paramString = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
              AppMethodBeat.o(79033);
              return paramString;
            }
            try
            {
              paramWebResourceRequest = MMApplicationContext.getContext().getSharedPreferences("qar_cycle_rec", 0);
              parame = "qaj_tick_" + MD5Util.getMD5String(paramString);
              l1 = paramWebResourceRequest.getLong(parame, 0L);
              l2 = System.currentTimeMillis();
              if (l2 - l1 <= TimeUnit.HOURS.toMillis(24L)) {
                continue;
              }
              paramWebResourceRequest.edit().putLong(parame, l2).commit();
              com.tencent.mm.plugin.report.e.Cxv.a(16195, paramString.replace(",", "%2C"), false, true);
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(943L, 0L, 1L, false);
            }
            catch (Throwable paramWebResourceRequest)
            {
              Log.printErrStackTrace("MicroMsg.WebViewReporter", paramWebResourceRequest, "", new Object[0]);
            }
            continue;
          }
        }
        try
        {
          paramWebResourceRequest = MMApplicationContext.getContext().getSharedPreferences("qar_cycle_rec", 0);
          paramString = "qab_tick_" + MD5Util.getMD5String(paramString);
          l1 = paramWebResourceRequest.getLong(paramString, 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > TimeUnit.HOURS.toMillis(24L))
          {
            paramWebResourceRequest.edit().putLong(paramString, l2).commit();
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(943L, 1L, 1L, false);
          }
        }
        catch (Throwable paramString)
        {
          Log.printErrStackTrace("MicroMsg.WebViewReporter", paramString, "", new Object[0]);
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(79033);
        return null;
      }
    }
  }
  
  public final boolean aYR(String paramString)
  {
    AppMethodBeat.i(211002);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211002);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(211002);
      return false;
    }
    boolean bool = this.IZr.remove(paramString);
    AppMethodBeat.o(211002);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ar
 * JD-Core Version:    0.7.0.1
 */