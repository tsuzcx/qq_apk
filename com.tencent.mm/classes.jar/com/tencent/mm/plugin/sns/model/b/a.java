package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int zoK = 6;
  private static int zoL = 3;
  private static int zoM = 1000;
  private static boolean zoN = true;
  private static String zoO = "";
  private static int zoP = 0;
  private static int zoQ = 60;
  private static int zoR = 1200;
  private static float zoS = 4.0F;
  private static float zoT = 8.0F;
  private static int zoU = 1;
  private static int zoV = 3;
  private static String zoW = "20:00-23:59";
  
  public static boolean Qk(int paramInt)
  {
    AppMethodBeat.i(96080);
    String str1 = SimpleDateFormat.getDateInstance().format(new Date());
    ax localax = ax.aQz("MicroMsg.SnsPreloadSwitch");
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
    if (paramInt + i < zoM)
    {
      localax.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static int a(byn parambyn, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (parambyn.GTe > 0.0F)
    {
      float f = parambyn.GTe * paramInt / 100.0F;
      if (f < zoS)
      {
        paramInt = (int)(Math.min(zoS, parambyn.GTe) * 100.0F / parambyn.GTe);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > zoT)
      {
        paramInt = (int)(zoT * 100.0F / parambyn.GTe);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static void dVo()
  {
    AppMethodBeat.i(96078);
    zoN = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyU, true);
    zoO = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyV, "20:00-23:59");
    zoP = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyW, 1);
    zoK = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyX, 6);
    zoL = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyY, 3);
    zoM = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyZ, 1000);
    zoQ = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qza, 60);
    zoS = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzc, 4.0F);
    zoT = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzd, 8.0F);
    zoU = dVu();
    zoV = dVv();
    ad.m("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(zoN), zoO, Integer.valueOf(zoP), Integer.valueOf(zoK), Integer.valueOf(zoL), Integer.valueOf(zoM), Integer.valueOf(zoQ), Integer.valueOf(zoR), Integer.valueOf(zoU), Integer.valueOf(zoV), zoW });
    AppMethodBeat.o(96078);
  }
  
  public static boolean dVp()
  {
    AppMethodBeat.i(96079);
    if (!zoN)
    {
      ad.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = ay.iS(aj.getContext());
    switch (zoP)
    {
    }
    while ((!TextUtils.isEmpty(zoO)) && (com.tencent.mm.modelcontrol.b.ET(zoO)))
    {
      ad.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { zoO });
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
    if (!Qk(0))
    {
      ad.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int dVq()
  {
    return zoK;
  }
  
  public static int dVr()
  {
    return zoL;
  }
  
  public static int dVs()
  {
    return zoQ;
  }
  
  public static int dVt()
  {
    AppMethodBeat.i(96081);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzb, 1200);
    zoR = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int dVu()
  {
    AppMethodBeat.i(96083);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qze, 1);
    zoU = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int dVv()
  {
    AppMethodBeat.i(96084);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzf, 3);
    zoV = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */