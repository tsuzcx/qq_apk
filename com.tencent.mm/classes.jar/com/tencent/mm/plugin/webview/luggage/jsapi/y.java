package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.DeviceInfo;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

public class y
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78560);
    HashMap localHashMap = new HashMap();
    localHashMap.put("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
    localHashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
    localHashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(MMApplicationContext.getContext())));
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    paramb.e("", localHashMap);
    AppMethodBeat.o(78560);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getSystemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.y
 * JD-Core Version:    0.7.0.1
 */