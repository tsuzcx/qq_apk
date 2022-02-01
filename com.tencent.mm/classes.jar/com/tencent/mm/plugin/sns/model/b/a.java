package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int zFZ = 6;
  private static int zGa = 3;
  private static int zGb = 1000;
  private static boolean zGc = true;
  private static String zGd = "";
  private static int zGe = 0;
  private static int zGf = 60;
  private static int zGg = 1200;
  private static float zGh = 4.0F;
  private static float zGi = 8.0F;
  private static int zGj = 1;
  private static int zGk = 3;
  private static String zGl = "20:00-23:59";
  
  public static boolean QR(int paramInt)
  {
    AppMethodBeat.i(96080);
    String str1 = SimpleDateFormat.getDateInstance().format(new Date());
    ay localay = ay.aRW("MicroMsg.SnsPreloadSwitch");
    String str2 = localay.decodeString("SnsPreloadSwitch_KEY_DATE");
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1)))
    {
      ae.i("MicroMsg.SnsPreloadSwitch", "yesterday preload count:%d", new Object[] { Integer.valueOf(localay.decodeInt("SnsPreloadSwitch_KEY_COUNT")) });
      localay.encode("SnsPreloadSwitch_KEY_DATE", str1);
      localay.encode("SnsPreloadSwitch_KEY_COUNT", paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    int i = localay.decodeInt("SnsPreloadSwitch_KEY_COUNT", 0);
    if (paramInt + i < zGb)
    {
      localay.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static int a(bzh parambzh, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (parambzh.HmF > 0.0F)
    {
      float f = parambzh.HmF * paramInt / 100.0F;
      if (f < zGh)
      {
        paramInt = (int)(Math.min(zGh, parambzh.HmF) * 100.0F / parambzh.HmF);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > zGi)
      {
        paramInt = (int)(zGi * 100.0F / parambzh.HmF);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static void dYP()
  {
    AppMethodBeat.i(96078);
    zGc = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGa, true);
    zGd = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGb, "20:00-23:59");
    zGe = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGc, 1);
    zFZ = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGd, 6);
    zGa = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGe, 3);
    zGb = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGf, 1000);
    zGf = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGg, 60);
    zGh = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGi, 4.0F);
    zGi = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGj, 8.0F);
    zGj = dYV();
    zGk = dYW();
    ae.m("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(zGc), zGd, Integer.valueOf(zGe), Integer.valueOf(zFZ), Integer.valueOf(zGa), Integer.valueOf(zGb), Integer.valueOf(zGf), Integer.valueOf(zGg), Integer.valueOf(zGj), Integer.valueOf(zGk), zGl });
    AppMethodBeat.o(96078);
  }
  
  public static boolean dYQ()
  {
    AppMethodBeat.i(96079);
    if (!zGc)
    {
      ae.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = az.iX(ak.getContext());
    switch (zGe)
    {
    }
    while ((!TextUtils.isEmpty(zGd)) && (com.tencent.mm.modelcontrol.b.Fv(zGd)))
    {
      ae.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { zGd });
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
    if (!QR(0))
    {
      ae.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int dYR()
  {
    return zFZ;
  }
  
  public static int dYS()
  {
    return zGa;
  }
  
  public static int dYT()
  {
    return zGf;
  }
  
  public static int dYU()
  {
    AppMethodBeat.i(96081);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGh, 1200);
    zGg = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int dYV()
  {
    AppMethodBeat.i(96083);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGk, 1);
    zGj = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int dYW()
  {
    AppMethodBeat.i(96084);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGl, 3);
    zGk = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */