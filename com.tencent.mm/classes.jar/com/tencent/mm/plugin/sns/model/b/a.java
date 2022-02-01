package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int Kdg = 6;
  private static int Kdh = 3;
  private static int Kdi = 1000;
  private static boolean Kdj = true;
  private static String Kdk = "";
  private static int Kdl = 0;
  private static int Kdm = 60;
  private static int Kdn = 1200;
  private static float Kdo = 4.0F;
  private static float Kdp = 8.0F;
  private static int Kdq = 1;
  private static int Kdr = 3;
  private static String Kds = "20:00-23:59";
  
  public static int a(cvt paramcvt, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (paramcvt.TDZ > 0.0F)
    {
      float f = paramcvt.TDZ * paramInt / 100.0F;
      if (f < Kdo)
      {
        paramInt = (int)(Math.min(Kdo, paramcvt.TDZ) * 100.0F / paramcvt.TDZ);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > Kdp)
      {
        paramInt = (int)(Kdp * 100.0F / paramcvt.TDZ);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static boolean agf(int paramInt)
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
    if (paramInt + i < Kdi)
    {
      localMultiProcessMMKV.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static void fPW()
  {
    AppMethodBeat.i(96078);
    Kdj = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGl, true);
    Kdk = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGm, "20:00-23:59");
    Kdl = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGn, 1);
    Kdg = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGo, 6);
    Kdh = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGp, 3);
    Kdi = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGq, 1000);
    Kdm = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGr, 60);
    Kdo = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGt, 4.0F);
    Kdp = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGu, 8.0F);
    Kdq = fQc();
    Kdr = fQd();
    Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(Kdj), Kdk, Integer.valueOf(Kdl), Integer.valueOf(Kdg), Integer.valueOf(Kdh), Integer.valueOf(Kdi), Integer.valueOf(Kdm), Integer.valueOf(Kdn), Integer.valueOf(Kdq), Integer.valueOf(Kdr), Kds });
    AppMethodBeat.o(96078);
  }
  
  public static boolean fPX()
  {
    AppMethodBeat.i(96079);
    if (!Kdj)
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    switch (Kdl)
    {
    }
    while ((!TextUtils.isEmpty(Kdk)) && (com.tencent.mm.modelcontrol.b.VC(Kdk)))
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { Kdk });
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
    if (!agf(0))
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int fPY()
  {
    return Kdg;
  }
  
  public static int fPZ()
  {
    return Kdh;
  }
  
  public static int fQa()
  {
    return Kdm;
  }
  
  public static int fQb()
  {
    AppMethodBeat.i(96081);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGs, 1200);
    Kdn = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int fQc()
  {
    AppMethodBeat.i(96083);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGv, 1);
    Kdq = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int fQd()
  {
    AppMethodBeat.i(96084);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGw, 3);
    Kdr = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */