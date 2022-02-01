package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.j.b;
import com.tencent.mm.plugin.sns.ad.j.g;
import com.tencent.mm.plugin.webview.k.d;
import com.tencent.mm.plugin.webview.k.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import org.json.JSONObject;

public final class f
{
  public static void aWl(String paramString)
  {
    AppMethodBeat.i(310038);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(310038);
      return;
    }
    if (!gZL())
    {
      AppMethodBeat.o(310038);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309926);
        try
        {
          Log.i("AdPassThroughInfoHelper", "start send get http req to dest IPv4, url is " + f.this);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 40);
          d.a locala = d.af(f.this, null);
          if (locala != null)
          {
            if (locala.statusCode == 200)
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 41);
              Log.i("AdPassThroughInfoHelper", "get http response success, url is " + f.this);
              AppMethodBeat.o(309926);
              return;
            }
            f.access$200();
            Log.e("AdPassThroughInfoHelper", "get http response failed, url is " + f.this + ", statusCode is " + locala.statusCode);
            AppMethodBeat.o(309926);
            return;
          }
        }
        finally
        {
          Log.e("AdPassThroughInfoHelper", localObject.toString());
          AppMethodBeat.o(309926);
          return;
        }
        f.access$200();
        Log.e("AdPassThroughInfoHelper", "not receive http response, url is " + f.this);
        AppMethodBeat.o(309926);
      }
    });
    AppMethodBeat.o(310038);
  }
  
  public static byte[] gZJ()
  {
    AppMethodBeat.i(310024);
    long l1 = System.currentTimeMillis();
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("ua", g.hcn());
      boolean bool = g.hcp();
      if ((b.hck()) && (bool))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1724, 1);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("is_harmony_os", bool);
        localJSONObject.put("os_version", g.aWS("hw_sc.build.platform.version"));
        int i = g.hcq();
        if (i == 0) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1724, 2);
        }
        localJSONObject.put("harmony_pure_mode", i);
        ((JSONObject)localObject1).put("HarmonyInfo", localJSONObject);
      }
      long l2 = System.currentTimeMillis();
      localObject1 = ((JSONObject)localObject1).toString();
      Log.d("AdPassThroughInfoHelper", "getAdPassThroughInfo, timeCost = " + (l2 - l1) + ", ret = " + (String)localObject1);
      localObject1 = ((String)localObject1).getBytes();
      AppMethodBeat.o(310024);
      return localObject1;
    }
    finally
    {
      Log.e("AdPassThroughInfoHelper", localObject2.toString());
      AppMethodBeat.o(310024);
    }
    return new byte[0];
  }
  
  public static void gZK()
  {
    AppMethodBeat.i(310032);
    try
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1724, 5);
      if ((b.hck()) && (g.hcp()))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1724, 3);
        if (g.hcq() == 0) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1724, 4);
        }
      }
      AppMethodBeat.o(310032);
      return;
    }
    finally
    {
      Log.e("AdPassThroughInfoHelper", localObject.toString());
      AppMethodBeat.o(310032);
    }
  }
  
  private static boolean gZL()
  {
    AppMethodBeat.i(310043);
    try
    {
      int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yIu, 0);
      Log.i("AdPassThroughInfoHelper", "isReqIPv4 is ".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(310043);
        return true;
      }
      AppMethodBeat.o(310043);
      return false;
    }
    finally
    {
      Log.e("AdPassThroughInfoHelper", localObject.toString());
      AppMethodBeat.o(310043);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.f
 * JD-Core Version:    0.7.0.1
 */