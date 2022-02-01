package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int QAA = 3;
  private static int QAB = 1000;
  private static boolean QAC = true;
  private static String QAD = "";
  private static int QAE = 0;
  private static int QAF = 60;
  private static int QAG = 1200;
  private static float QAH = 4.0F;
  private static float QAI = 8.0F;
  private static int QAJ = 1;
  private static int QAK = 3;
  private static String QAL = "20:00-23:59";
  private static int QAz = 6;
  
  public static int a(dmz paramdmz, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (paramdmz.aaTF > 0.0F)
    {
      float f = paramdmz.aaTF * paramInt / 100.0F;
      if (f < QAH)
      {
        paramInt = (int)(Math.min(QAH, paramdmz.aaTF) * 100.0F / paramdmz.aaTF);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > QAI)
      {
        paramInt = (int)(QAI * 100.0F / paramdmz.aaTF);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static boolean akU(int paramInt)
  {
    AppMethodBeat.i(96080);
    String str1 = SimpleDateFormat.getDateInstance().format(new Date());
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MicroMsg.SnsPreloadSwitch");
    String str2 = localMultiProcessMMKV.decodeString("SnsPreloadSwitch_KEY_DATE");
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1)))
    {
      Log.i("MicroMsg.SnsPreloadSwitch", "yesterday preload count:%d", new Object[] { Integer.valueOf(localMultiProcessMMKV.decodeInt("SnsPreloadSwitch_KEY_COUNT")) });
      localMultiProcessMMKV.encode("SnsPreloadSwitch_KEY_DATE", str1);
      localMultiProcessMMKV.encode("SnsPreloadSwitch_KEY_COUNT", paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    int i = localMultiProcessMMKV.decodeInt("SnsPreloadSwitch_KEY_COUNT", 0);
    if (paramInt + i < QAB)
    {
      localMultiProcessMMKV.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static void hhO()
  {
    AppMethodBeat.i(96078);
    QAC = ((c)h.ax(c.class)).a(c.a.yVT, true);
    QAD = ((c)h.ax(c.class)).a(c.a.yVU, "20:00-23:59");
    QAE = ((c)h.ax(c.class)).a(c.a.yVV, 1);
    QAz = ((c)h.ax(c.class)).a(c.a.yVW, 6);
    QAA = ((c)h.ax(c.class)).a(c.a.yVX, 3);
    QAB = ((c)h.ax(c.class)).a(c.a.yVY, 1000);
    QAF = ((c)h.ax(c.class)).a(c.a.yVZ, 60);
    QAH = ((c)h.ax(c.class)).a(c.a.yWb, 4.0F);
    QAI = ((c)h.ax(c.class)).a(c.a.yWc, 8.0F);
    QAJ = hhU();
    QAK = hhV();
    Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(QAC), QAD, Integer.valueOf(QAE), Integer.valueOf(QAz), Integer.valueOf(QAA), Integer.valueOf(QAB), Integer.valueOf(QAF), Integer.valueOf(QAG), Integer.valueOf(QAJ), Integer.valueOf(QAK), QAL });
    AppMethodBeat.o(96078);
  }
  
  public static boolean hhP()
  {
    AppMethodBeat.i(96079);
    if (!QAC)
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = NetworkCache.INSTANCE.getIOSNetTypeFromCache(MMApplicationContext.getContext());
    switch (QAE)
    {
    }
    while ((!TextUtils.isEmpty(QAD)) && (b.NB(QAD)))
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { QAD });
      AppMethodBeat.o(96079);
      return false;
      if (i != 1)
      {
        AppMethodBeat.o(96079);
        return false;
        if (i != 4)
        {
          AppMethodBeat.o(96079);
          return false;
          if (i != 3)
          {
            AppMethodBeat.o(96079);
            return false;
            if ((i != 1) && (i != 4))
            {
              AppMethodBeat.o(96079);
              return false;
            }
          }
        }
      }
    }
    if (!akU(0))
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int hhQ()
  {
    return QAz;
  }
  
  public static int hhR()
  {
    return QAA;
  }
  
  public static int hhS()
  {
    return QAF;
  }
  
  public static int hhT()
  {
    AppMethodBeat.i(96081);
    int i = ((c)h.ax(c.class)).a(c.a.yWa, 1200);
    QAG = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int hhU()
  {
    AppMethodBeat.i(96083);
    int i = ((c)h.ax(c.class)).a(c.a.yWd, 1);
    QAJ = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int hhV()
  {
    AppMethodBeat.i(96084);
    int i = ((c)h.ax(c.class)).a(c.a.yWe, 3);
    QAK = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */