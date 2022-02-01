package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e
{
  public static byte[] fJS()
  {
    AppMethodBeat.i(226360);
    long l1 = System.currentTimeMillis();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ua", g.fLT());
      boolean bool = g.fLV();
      if ((b.fLQ()) && (bool))
      {
        h.IzE.el(1724, 1);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("is_harmony_os", bool);
        localJSONObject.put("os_version", g.fLW());
        int i = g.fLX();
        if (i == 0) {
          h.IzE.el(1724, 2);
        }
        localJSONObject.put("harmony_pure_mode", i);
        ((JSONObject)localObject).put("HarmonyInfo", localJSONObject);
      }
      long l2 = System.currentTimeMillis();
      localObject = ((JSONObject)localObject).toString();
      Log.d("AdPassThroughInfoHelper", "getAdPassThroughInfo, timeCost = " + (l2 - l1) + ", ret = " + (String)localObject);
      localObject = ((String)localObject).getBytes();
      AppMethodBeat.o(226360);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdPassThroughInfoHelper", localThrowable.toString());
      AppMethodBeat.o(226360);
    }
    return new byte[0];
  }
  
  public static void fJT()
  {
    AppMethodBeat.i(226363);
    try
    {
      if ((b.fLQ()) && (g.fLV()))
      {
        h.IzE.el(1724, 3);
        if (g.fLX() == 0) {
          h.IzE.el(1724, 4);
        }
      }
      AppMethodBeat.o(226363);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdPassThroughInfoHelper", localThrowable.toString());
      AppMethodBeat.o(226363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.e
 * JD-Core Version:    0.7.0.1
 */