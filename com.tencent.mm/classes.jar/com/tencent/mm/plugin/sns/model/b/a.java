package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int xYL = 6;
  private static int xYM = 3;
  private static int xYN = 1000;
  private static boolean xYO = true;
  private static String xYP = "";
  private static int xYQ = 0;
  private static int xYR = 60;
  private static int xYS = 1200;
  private static float xYT = 4.0F;
  private static float xYU = 8.0F;
  private static int xYV = 1;
  private static int xYW = 3;
  private static String xYX = "20:00-23:59";
  
  public static boolean OC(int paramInt)
  {
    AppMethodBeat.i(96080);
    String str1 = SimpleDateFormat.getDateInstance().format(new Date());
    aw localaw = aw.aKT("MicroMsg.SnsPreloadSwitch");
    String str2 = localaw.decodeString("SnsPreloadSwitch_KEY_DATE");
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1)))
    {
      ac.i("MicroMsg.SnsPreloadSwitch", "yesterday preload count:%d", new Object[] { Integer.valueOf(localaw.decodeInt("SnsPreloadSwitch_KEY_COUNT")) });
      localaw.encode("SnsPreloadSwitch_KEY_DATE", str1);
      localaw.encode("SnsPreloadSwitch_KEY_COUNT", paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    int i = localaw.decodeInt("SnsPreloadSwitch_KEY_COUNT", 0);
    if (paramInt + i < xYN)
    {
      localaw.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static int a(btz parambtz, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (parambtz.FjD > 0.0F)
    {
      float f = parambtz.FjD * paramInt / 100.0F;
      if (f < xYT)
      {
        paramInt = (int)(Math.min(xYT, parambtz.FjD) * 100.0F / parambtz.FjD);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > xYU)
      {
        paramInt = (int)(xYU * 100.0F / parambtz.FjD);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static void dJb()
  {
    AppMethodBeat.i(96078);
    xYO = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUo, true);
    xYP = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUp, "20:00-23:59");
    xYQ = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUq, 1);
    xYL = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUr, 6);
    xYM = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUs, 3);
    xYN = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUt, 1000);
    xYR = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUu, 60);
    xYT = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUw, 4.0F);
    xYU = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUx, 8.0F);
    xYV = dJh();
    xYW = dJi();
    ac.m("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(xYO), xYP, Integer.valueOf(xYQ), Integer.valueOf(xYL), Integer.valueOf(xYM), Integer.valueOf(xYN), Integer.valueOf(xYR), Integer.valueOf(xYS), Integer.valueOf(xYV), Integer.valueOf(xYW), xYX });
    AppMethodBeat.o(96078);
  }
  
  public static boolean dJc()
  {
    AppMethodBeat.i(96079);
    if (!xYO)
    {
      ac.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = ax.iI(ai.getContext());
    switch (xYQ)
    {
    }
    while ((!TextUtils.isEmpty(xYP)) && (com.tencent.mm.modelcontrol.b.BU(xYP)))
    {
      ac.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { xYP });
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
    if (!OC(0))
    {
      ac.m("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int dJd()
  {
    return xYL;
  }
  
  public static int dJe()
  {
    return xYM;
  }
  
  public static int dJf()
  {
    return xYR;
  }
  
  public static int dJg()
  {
    AppMethodBeat.i(96081);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUv, 1200);
    xYS = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int dJh()
  {
    AppMethodBeat.i(96083);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUy, 1);
    xYV = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int dJi()
  {
    AppMethodBeat.i(96084);
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUz, 3);
    xYW = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */