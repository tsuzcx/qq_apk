package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.DeviceInfo;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

public class u
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6314);
    HashMap localHashMap = new HashMap();
    localHashMap.put("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
    localHashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
    localHashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(ah.getContext())));
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    parama.c("", localHashMap);
    AppMethodBeat.o(6314);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getSystemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.u
 * JD-Core Version:    0.7.0.1
 */