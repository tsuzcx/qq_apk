package com.tencent.tbs.one.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.f.b;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.e.a.b;
import com.tencent.tbs.one.impl.e.h;
import com.tencent.tbs.one.impl.e.i;
import java.io.File;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static final String[] a;
  private static final Object b;
  private static boolean c;
  
  static
  {
    AppMethodBeat.i(174175);
    a = new String[] { "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.tbs" };
    b = new Object();
    AppMethodBeat.o(174175);
  }
  
  public static com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<d>> a(i parami, int paramInt, File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(190684);
    parami = new b(parami.a, parami.b, parami.f(), parami.e(), paramInt, paramFile, paramBundle);
    AppMethodBeat.o(190684);
    return parami;
  }
  
  public static com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<File>> a(i parami, d.a parama, File paramFile, Bundle paramBundle)
  {
    AppMethodBeat.i(190685);
    parami = new com.tencent.tbs.one.impl.e.a.a(parami.a, parami.b, parami.f(), parami.e(), parama, paramFile, paramBundle);
    AppMethodBeat.o(190685);
    return parami;
  }
  
  public static h a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174172);
    Object localObject2 = new File(new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "tencent"), "tbs"), paramContext.getPackageName()), paramString), "debug.conf");
    Object localObject1;
    if (((File)localObject2).exists()) {
      localObject1 = "https://tbsone.sparta.html5.qq.com";
    }
    for (;;)
    {
      StatisticReport.shiftRepService(((File)localObject2).exists());
      paramContext = new i(paramContext, paramString, "/android_asset/", (String)localObject1, a);
      if ("default".equals(paramString))
      {
        localObject2 = paramContext.m;
        if (((SharedPreferences)localObject2).contains("in_use_component_names")) {}
      }
      try
      {
        localObject1 = com.tencent.tbs.b.a.LSV.keySet();
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putStringSet("in_use_component_names", (Set)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
        AppMethodBeat.o(174172);
        return paramContext;
        localObject1 = "https://tbsone.imtt.qq.com";
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          f.c("[%s] Failed to preset in-use component names", new Object[] { paramString, localThrowable });
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(174171);
    synchronized (b)
    {
      if (!c)
      {
        com.tencent.tbs.a.e.cA(paramContext.getApplicationContext(), "onelog");
        f.a(new f.b()
        {
          public final void a(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(173887);
            com.tencent.tbs.a.e.a(paramAnonymousInt, "TBSOne", paramAnonymousString);
            AppMethodBeat.o(173887);
          }
        });
        StatisticReport.initialize(paramContext.getApplicationContext());
        com.tencent.tbs.one.impl.common.h.a = new h.a()
        {
          public final void a(String paramAnonymousString, int paramAnonymousInt, Map paramAnonymousMap)
          {
            AppMethodBeat.i(173886);
            if ("TBSOneAction".equals(paramAnonymousString))
            {
              StatisticReport.create(paramAnonymousString, paramAnonymousInt).report();
              AppMethodBeat.o(173886);
              return;
            }
            if ((paramAnonymousInt == 201) || (paramAnonymousInt == 209) || (paramAnonymousInt == 214) || (paramAnonymousInt == 506))
            {
              AppMethodBeat.o(173886);
              return;
            }
            StatisticReport localStatisticReport = StatisticReport.create(paramAnonymousString, paramAnonymousInt);
            if (paramAnonymousMap != null)
            {
              if (paramAnonymousMap.containsKey("DEPS_VERSION_CODE")) {
                localStatisticReport.setDEPSCode(((Integer)paramAnonymousMap.get("DEPS_VERSION_CODE")).intValue());
              }
              if (!paramAnonymousMap.containsKey("COMPONENT_NAME")) {
                break label239;
              }
            }
            label239:
            for (paramAnonymousString = (String)paramAnonymousMap.get("COMPONENT_NAME");; paramAnonymousString = "")
            {
              paramAnonymousInt = -1;
              if (paramAnonymousMap.containsKey("COMPONENT_VERSION_CODE")) {
                paramAnonymousInt = ((Integer)paramAnonymousMap.get("COMPONENT_VERSION_CODE")).intValue();
              }
              localStatisticReport.setComponent(paramAnonymousString, paramAnonymousInt);
              if (paramAnonymousMap.containsKey("DESCRIPTION")) {}
              for (paramAnonymousString = (String)paramAnonymousMap.get("DESCRIPTION");; paramAnonymousString = "")
              {
                Throwable localThrowable = null;
                if (paramAnonymousMap.containsKey("THROWABLE")) {
                  localThrowable = (Throwable)paramAnonymousMap.get("THROWABLE");
                }
                localStatisticReport.setDescription(paramAnonymousString, localThrowable);
                localStatisticReport.report();
                AppMethodBeat.o(173886);
                return;
              }
            }
          }
        };
        Runtime.getRuntime().addShutdownHook(new com.tencent.tbs.one.impl.e.a(paramContext.getDir("tbs", 0)));
        c = true;
      }
      AppMethodBeat.o(174171);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a
 * JD-Core Version:    0.7.0.1
 */