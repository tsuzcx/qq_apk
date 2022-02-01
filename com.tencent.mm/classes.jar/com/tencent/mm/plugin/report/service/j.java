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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.report.c.h;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class j
  implements SmcLogic.ICallBack
{
  public static IKVReportNotify wUQ = null;
  
  public static void arD(String paramString)
  {
    AppMethodBeat.i(143926);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.SmcCallBack", "msg content is null");
      AppMethodBeat.o(143926);
      return;
    }
    ac.i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(paramString)));
    Map localMap = bv.L(paramString, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ac.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    String str = (String)localMap.get(".sysmsg.$type");
    if ((bs.isNullOrNil(str)) || (!str.equalsIgnoreCase("getkvidkeystg")))
    {
      ac.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    long l1 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.generalversion"), -1L);
    long l2 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.specialversion"), -1L);
    long l3 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1L);
    long l4 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.timeinterval"), -1L);
    long l5 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1L);
    long l6 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1L);
    long l7 = bs.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1L);
    if ((l1 == -1L) || (l2 == -1L) || (l3 == -1L) || (l4 == -1L) || (-1L == l5) || (-1L == l6) || (-1L == l7))
    {
      ac.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    ac.i("MicroMsg.SmcCallBack", "plugin msg version:" + l1 + ", " + l2 + ", " + l3);
    SmcLogic.OnPluginMsg(l5, l6, l7, l1, l2, l4);
    AppMethodBeat.o(143926);
  }
  
  public final boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143923);
    g.agP();
    if (!a.afX())
    {
      ac.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
      AppMethodBeat.o(143923);
      return false;
    }
    try
    {
      com.tencent.mm.protocal.a.a.k localk = new com.tencent.mm.protocal.a.a.k();
      localk.parseFrom(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toMMSelfMonitor(localk);
      if (paramArrayOfByte.Faw <= 0)
      {
        ac.e("KVReportJni", "error selfmonitor count");
        AppMethodBeat.o(143923);
        return true;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(202, paramArrayOfByte));
      AppMethodBeat.o(143923);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("KVReportJni", paramArrayOfByte.getMessage());
      AppMethodBeat.o(143923);
    }
    return false;
  }
  
  public final String getKVCommPath()
  {
    AppMethodBeat.i(143925);
    String str = AppLogic.getAppFilePath() + "/kvcomm/";
    ac.i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
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
    localBaseInfo.languageVer = ab.eUO();
    AppMethodBeat.o(143924);
    return localBaseInfo;
  }
  
  public final int getSingleReportBufSizeB()
  {
    return 20480;
  }
  
  public final void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    AppMethodBeat.i(206469);
    try
    {
      if ((wUQ != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        wUQ.onReportKVDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt);
      }
      AppMethodBeat.o(206469);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ac.e("KVReportJni", paramArrayOfByte1.getMessage());
      AppMethodBeat.o(206469);
    }
  }
  
  public final boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143922);
    try
    {
      if ((com.tencent.mm.sdk.platformtools.i.GqL) && (ai.getContext().getSharedPreferences(ai.eUX(), 0).getBoolean("gprs_alert", true)))
      {
        ac.i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
        AppMethodBeat.o(143922);
        return false;
      }
      try
      {
        if (h.isRunning())
        {
          ac.i("KVReportJni", "already running");
          return false;
        }
        paramArrayOfByte = new h();
        g.agQ().ghe.a(paramArrayOfByte, 0);
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
      ac.e("KVReportJni", "onRequestGetStrategy error: " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(143922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.j
 * JD-Core Version:    0.7.0.1
 */