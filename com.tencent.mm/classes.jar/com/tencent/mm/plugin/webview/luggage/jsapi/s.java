package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public class s
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(com.tencent.luggage.e.a<e>.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("cpuCores", Integer.valueOf(com.b.a.a.a.kk()));
    localHashMap.put("cpuFreqHz", Integer.valueOf(com.b.a.a.a.kl()));
    localHashMap.put("memory", Long.valueOf(com.b.a.a.a.W(ae.getContext())));
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    parama.c("", localHashMap);
  }
  
  public final String name()
  {
    return "getSystemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.s
 * JD-Core Version:    0.7.0.1
 */