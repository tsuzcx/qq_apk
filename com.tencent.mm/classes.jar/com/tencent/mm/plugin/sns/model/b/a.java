package com.tencent.mm.plugin.sns.model.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int DPZ = 6;
  private static int DQa = 3;
  private static int DQb = 1000;
  private static boolean DQc = true;
  private static String DQd = "";
  private static int DQe = 0;
  private static int DQf = 60;
  private static int DQg = 1200;
  private static float DQh = 4.0F;
  private static float DQi = 8.0F;
  private static int DQj = 1;
  private static int DQk = 3;
  private static String DQl = "20:00-23:59";
  
  public static boolean YO(int paramInt)
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
    if (paramInt + i < DQb)
    {
      localMultiProcessMMKV.encode("SnsPreloadSwitch_KEY_COUNT", i + paramInt);
      AppMethodBeat.o(96080);
      return true;
    }
    AppMethodBeat.o(96080);
    return false;
  }
  
  public static int a(cnb paramcnb, int paramInt)
  {
    AppMethodBeat.i(96082);
    if (paramcnb.MsT > 0.0F)
    {
      float f = paramcnb.MsT * paramInt / 100.0F;
      if (f < DQh)
      {
        paramInt = (int)(Math.min(DQh, paramcnb.MsT) * 100.0F / paramcnb.MsT);
        AppMethodBeat.o(96082);
        return paramInt;
      }
      if (f > DQi)
      {
        paramInt = (int)(DQi * 100.0F / paramcnb.MsT);
        AppMethodBeat.o(96082);
        return paramInt;
      }
    }
    AppMethodBeat.o(96082);
    return paramInt;
  }
  
  public static void fcd()
  {
    AppMethodBeat.i(96078);
    DQc = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZn, true);
    DQd = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZo, "20:00-23:59");
    DQe = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZp, 1);
    DPZ = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZq, 6);
    DQa = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZr, 3);
    DQb = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZs, 1000);
    DQf = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZt, 60);
    DQh = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZv, 4.0F);
    DQi = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZw, 8.0F);
    DQj = fcj();
    DQk = fck();
    Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "TIMELINE_MAIN_SWITCH:%b\nTIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL:%s\nTIMELINE_PRELOAD_NET_TYPE:%d\nTIMELINE_MAX_PRELOAD_IN_QUEUE:%d\nTIMELINE_MAX_PARALLEL_IN_QUEUE:%d\n TIMELINE_MAX_PRELOAD_COUNT:%d\nTIMELINE_PRELOAD_PERCENT:%d\nTIMELINE_OUT_PRELOAD_INTERVAL:%d\nSNS_RED_DOT_PRELOAD:%d\n SNS_PRELOAD_VIDEO_EXPIRED_TIME:%d\nSNS_RED_DOT_PRELOAD_BUSY_TIME:%s", new Object[] { Boolean.valueOf(DQc), DQd, Integer.valueOf(DQe), Integer.valueOf(DPZ), Integer.valueOf(DQa), Integer.valueOf(DQb), Integer.valueOf(DQf), Integer.valueOf(DQg), Integer.valueOf(DQj), Integer.valueOf(DQk), DQl });
    AppMethodBeat.o(96078);
  }
  
  public static boolean fce()
  {
    AppMethodBeat.i(96079);
    if (!DQc)
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAIN_SWITCH", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    int i = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    switch (DQe)
    {
    }
    while ((!TextUtils.isEmpty(DQd)) && (com.tencent.mm.modelcontrol.b.Of(DQd)))
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_DAY_UNABLE_PRELOAD_TIME_INTERVAL %s", new Object[] { DQd });
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
    if (!YO(0))
    {
      Log.printInfoStack("MicroMsg.SnsPreloadSwitch", "disable by TIMELINE_MAX_PRELOAD_COUNT", new Object[0]);
      AppMethodBeat.o(96079);
      return false;
    }
    AppMethodBeat.o(96079);
    return true;
  }
  
  public static int fcf()
  {
    return DPZ;
  }
  
  public static int fcg()
  {
    return DQa;
  }
  
  public static int fch()
  {
    return DQf;
  }
  
  public static int fci()
  {
    AppMethodBeat.i(96081);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZu, 1200);
    DQg = i;
    AppMethodBeat.o(96081);
    return i;
  }
  
  public static int fcj()
  {
    AppMethodBeat.i(96083);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZx, 1);
    DQj = i;
    AppMethodBeat.o(96083);
    return i;
  }
  
  public static int fck()
  {
    AppMethodBeat.i(96084);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZy, 3);
    DQk = i;
    AppMethodBeat.o(96084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.a
 * JD-Core Version:    0.7.0.1
 */