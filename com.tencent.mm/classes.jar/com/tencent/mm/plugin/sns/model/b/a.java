package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int wMf = 6;
  private static int wMg = 3;
  private static int wMh = 1000;
  private static boolean wMi = true;
  private static String wMj = "";
  private static int wMk = 0;
  private static int wMl = 60;
  private static int wMm = 1200;
  private static float wMn = 4.0F;
  private static float wMo = 8.0F;
  private static int wMp = 1;
  private static int wMq = 3;
  private static String wMr = "20:00-23:59";
  
  public static boolean MA(int paramInt)
  {
    AppMethodBeat.i(96080);
    String str1 = SimpleDateFormat.getDateInstance().format(new Date());
    ax localax = ax.aFC("MicroMsg.SnsPreloadSwitch");
    String str2 = localax.decodeString("SnsPreloadSwitch_KEY_DATE");
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1)))
    {
      ad.i("MicroMsg.SnsPreloadSwitch", "yesterday preload count:%d", new Object[] { Integer.valueOf(localax.decodeInt("SnsPreloadSwitch_KEY_COUNT")) });
      localax.encode("SnsPreloadSwitch_KEY_DATE", str1);
      localax.encode("SnsPreloadSwitch_KEY_COUNT", paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    int i = localax.decodeInt("SnsPreloadSwitch_KEY_COUNT", 0);
    if (paramInt + i < wMh)
    {
      localax.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static int a(bpi parambpi, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (parambpi.DNm > 0.0F)
    {
      float f = parambpi.DNm * paramInt / 100.0F;
      if (f < wMn)
      {
        paramInt = (int)(Math.min(wMn, parambpi.DNm) * 100.0F / parambpi.DNm);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > wMo)
      {
        paramInt = (int)(wMo * 100.0F / parambpi.DNm);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static void duB()
  {
    AppMethodBeat.i(96078);
    wMi = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqB, true);
    wMj = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqC, "20:00-23:59");
    wMk = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqD, 1);
    wMf = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqE, 6);
    wMg = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqF, 3);
    wMh = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqG, 1000);
    wMl = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqH, 60);
    wMn = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqJ, 4.0F);
    wMo = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqK, 8.0F);
    wMp = duH();
    wMq = duI();
    ad.m("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(wMi), wMj, Integer.valueOf(wMk), Integer.valueOf(wMf), Integer.valueOf(wMg), Integer.valueOf(wMh), Integer.valueOf(wMl), Integer.valueOf(wMm), Integer.valueOf(wMp), Integer.valueOf(wMq), wMr });
    AppMethodBeat.o(96078);
  }
  
  public static boolean duC()
  {
    AppMethodBeat.i(96079);
    if (!wMi)
    {
      ad.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = ay.ix(aj.getContext());
    switch (wMk)
    {
    }
    while ((!TextUtils.isEmpty(wMj)) && (com.tencent.mm.modelcontrol.b.xO(wMj)))
    {
      ad.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { wMj });
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
    if (!MA(0))
    {
      ad.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int duD()
  {
    return wMf;
  }
  
  public static int duE()
  {
    return wMg;
  }
  
  public static int duF()
  {
    return wMl;
  }
  
  public static int duG()
  {
    AppMethodBeat.i(96081);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqI, 1200);
    wMm = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int duH()
  {
    AppMethodBeat.i(96083);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqL, 1);
    wMp = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int duI()
  {
    AppMethodBeat.i(96084);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqM, 3);
    wMq = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */