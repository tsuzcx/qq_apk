package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.b.h;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class i
  implements SmcLogic.ICallBack
{
  public static IKVReportNotify yiw = null;
  
  public static void awD(String paramString)
  {
    AppMethodBeat.i(143926);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.SmcCallBack", "msg content is null");
      AppMethodBeat.o(143926);
      return;
    }
    ad.i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(paramString)));
    Map localMap = bw.M(paramString, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ad.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    String str = (String)localMap.get(".sysmsg.$type");
    if ((bt.isNullOrNil(str)) || (!str.equalsIgnoreCase("getkvidkeystg")))
    {
      ad.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    long l1 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.generalversion"), -1L);
    long l2 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.specialversion"), -1L);
    long l3 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1L);
    long l4 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.timeinterval"), -1L);
    long l5 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1L);
    long l6 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1L);
    long l7 = bt.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1L);
    if ((l1 == -1L) || (l2 == -1L) || (l3 == -1L) || (l4 == -1L) || (-1L == l5) || (-1L == l6) || (-1L == l7))
    {
      ad.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    ad.i("MicroMsg.SmcCallBack", "plugin msg version:" + l1 + ", " + l2 + ", " + l3);
    SmcLogic.OnPluginMsg(l5, l6, l7, l1, l2, l4);
    AppMethodBeat.o(143926);
  }
  
  public final boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143923);
    g.ajA();
    if (!a.aiJ())
    {
      ad.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
      AppMethodBeat.o(143923);
      return false;
    }
    try
    {
      k localk = new k();
      localk.parseFrom(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toMMSelfMonitor(localk);
      if (paramArrayOfByte.GJV <= 0)
      {
        ad.e("KVReportJni", "error selfmonitor count");
        AppMethodBeat.o(143923);
        return true;
      }
      ((l)g.ab(l.class)).azo().c(new k.a(202, paramArrayOfByte));
      AppMethodBeat.o(143923);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("KVReportJni", paramArrayOfByte.getMessage());
      AppMethodBeat.o(143923);
    }
    return false;
  }
  
  public final String getKVCommPath()
  {
    AppMethodBeat.i(143925);
    String str = AppLogic.getAppFilePath() + "/kvcomm/";
    ad.i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
    AppMethodBeat.o(143925);
    return str;
  }
  
  public final SmcLogic.BaseInfo getKVCommReqBaseInfo()
  {
    AppMethodBeat.i(143924);
    SmcLogic.BaseInfo localBaseInfo = new SmcLogic.BaseInfo();
    localBaseInfo.deviceModel = (Build.MODEL + Build.CPU_ABI);
    localBaseInfo.deviceBrand = Build.BRAND;
    localBaseInfo.osName = ("android-" + Build.MANUFACTURER);
    localBaseInfo.osVersion = Build.VERSION.SDK_INT;
    localBaseInfo.languageVer = ac.fks();
    AppMethodBeat.o(143924);
    return localBaseInfo;
  }
  
  public final int getSingleReportBufSizeB()
  {
    return 20480;
  }
  
  public final void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    AppMethodBeat.i(197143);
    try
    {
      if ((yiw != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        yiw.onReportKVDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt);
      }
      AppMethodBeat.o(197143);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ad.e("KVReportJni", paramArrayOfByte1.getMessage());
      AppMethodBeat.o(197143);
    }
  }
  
  public final boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143922);
    try
    {
      if ((com.tencent.mm.sdk.platformtools.j.Icz) && (aj.getContext().getSharedPreferences(aj.fkC(), 0).getBoolean("gprs_alert", true)))
      {
        ad.i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
        AppMethodBeat.o(143922);
        return false;
      }
      try
      {
        if (h.isRunning())
        {
          ad.i("KVReportJni", "already running");
          return false;
        }
        paramArrayOfByte = new h();
        g.ajB().gAO.a(paramArrayOfByte, 0);
        return true;
      }
      finally
      {
        AppMethodBeat.o(143922);
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("KVReportJni", "onRequestGetStrategy error: " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(143922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */