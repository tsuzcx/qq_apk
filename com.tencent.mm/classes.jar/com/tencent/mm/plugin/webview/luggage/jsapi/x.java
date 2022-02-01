package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.DeviceInfo;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Map;

public class x
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78560);
    HashMap localHashMap = new HashMap();
    localHashMap.put("osVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("cpuCores", Integer.valueOf(DeviceInfo.getNumberOfCPUCores()));
    localHashMap.put("cpuFreqHz", Integer.valueOf(DeviceInfo.getCPUMaxFreqKHz()));
    localHashMap.put("memory", Long.valueOf(DeviceInfo.getTotalMemory(ai.getContext())));
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    parama.c("", localHashMap);
    AppMethodBeat.o(78560);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getSystemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.x
 * JD-Core Version:    0.7.0.1
 */