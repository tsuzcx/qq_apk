package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.c.a.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

public class z
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78560);
    HashMap localHashMap = new HashMap();
    localHashMap.put("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("cpuCores", Integer.valueOf(a.getNumberOfCPUCores()));
    localHashMap.put("cpuFreqHz", Integer.valueOf(a.Pb()));
    localHashMap.put("memory", Long.valueOf(a.aG(MMApplicationContext.getContext())));
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", q.aPo());
    paramb.d("", localHashMap);
    AppMethodBeat.o(78560);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getSystemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.z
 * JD-Core Version:    0.7.0.1
 */