package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.tencent.luggage.k.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.InetUtil;
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
  private List<Integer> PVE;
  private final Map<String, Boolean> PVF;
  private final Set<String> PVG;
  private String PVH;
  
  public ar()
  {
    AppMethodBeat.i(251622);
    this.PVH = null;
    this.PVE = new ArrayList();
    this.PVF = new HashMap();
    this.PVG = new HashSet();
    AppMethodBeat.o(251622);
  }
  
  private boolean bkK(String paramString)
  {
    AppMethodBeat.i(251626);
    try
    {
      String str = Uri.parse(paramString).getHost();
      if ((InetUtil.isIPv4Address(str)) || (InetUtil.isIPv6Address(str)))
      {
        if (this.PVH == null) {
          this.PVH = h.SH();
        }
        boolean bool = paramString.contains(this.PVH);
        AppMethodBeat.o(251626);
        return bool;
      }
      AppMethodBeat.o(251626);
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(251626);
    }
    return false;
  }
  
  private boolean bkL(String paramString)
  {
    AppMethodBeat.i(79034);
    if ((Util.isNullOrNil(paramString)) || (!c.ane(paramString)))
    {
      AppMethodBeat.o(79034);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("localhost")) || (paramString.contains("127.0.0.1")) || (paramString.contains("::1")) || (bkK(paramString)))
    {
      if ((this.PVE != null) && (this.PVE.size() > 0))
      {
        Iterator localIterator = this.PVE.iterator();
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
  
  public WebResourceResponse a(String paramString, WebResourceRequest paramWebResourceRequest, boolean paramBoolean, e parame)
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
        paramString = BitmapUtil.decodeFile(parame.hc(paramString, 2));
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
    if ((paramBoolean) && (bkL(paramString)))
    {
      Log.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[] { paramString });
      paramString = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
      AppMethodBeat.o(79033);
      return paramString;
    }
    label539:
    for (;;)
    {
      try
      {
        long l1;
        long l2;
        if (com.tencent.mm.plugin.webview.ui.tools.d.isEnabled())
        {
          paramWebResourceRequest = com.tencent.mm.plugin.webview.ui.tools.d.gXv();
          parame = Uri.parse(paramString);
          String str = parame.getHost();
          if ((paramWebResourceRequest != null) && (str != null) && (paramWebResourceRequest.equals(MD5Util.getMD5String(str + com.tencent.mm.plugin.normsg.a.d.GxJ.aTf("\003&+21")))))
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
                break label539;
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
              f.Iyx.b(16195, paramString.replace(",", "%2C"), false, true);
              f.Iyx.idkeyStat(943L, 0L, 1L, false);
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
            f.Iyx.idkeyStat(943L, 1L, 1L, false);
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
  
  public final void anR(int paramInt)
  {
    AppMethodBeat.i(251623);
    if ((paramInt <= 0) || (paramInt > 65535)) {
      Log.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!this.PVE.contains(Integer.valueOf(paramInt))) {
      this.PVE.add(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(251623);
  }
  
  public final boolean bkM(String paramString)
  {
    AppMethodBeat.i(251630);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(251630);
      return false;
    }
    paramString = Uri.parse(paramString).getHost();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(251630);
      return false;
    }
    boolean bool = this.PVG.remove(paramString);
    AppMethodBeat.o(251630);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ar
 * JD-Core Version:    0.7.0.1
 */