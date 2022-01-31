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
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.b.h;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class i
  implements SmcLogic.ICallBack
{
  public static IKVReportNotify qtk = null;
  
  public static void Yt(String paramString)
  {
    AppMethodBeat.i(72799);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.SmcCallBack", "msg content is null");
      AppMethodBeat.o(72799);
      return;
    }
    ab.i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(paramString)));
    Map localMap = br.F(paramString, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ab.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(72799);
      return;
    }
    String str = (String)localMap.get(".sysmsg.$type");
    if ((bo.isNullOrNil(str)) || (!str.equalsIgnoreCase("getkvidkeystg")))
    {
      ab.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(72799);
      return;
    }
    long l1 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.generalversion"), -1L);
    long l2 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.specialversion"), -1L);
    long l3 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1L);
    long l4 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.timeinterval"), -1L);
    long l5 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1L);
    long l6 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1L);
    long l7 = bo.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1L);
    if ((l1 == -1L) || (l2 == -1L) || (l3 == -1L) || (l4 == -1L) || (-1L == l5) || (-1L == l6) || (-1L == l7))
    {
      ab.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(72799);
      return;
    }
    ab.i("MicroMsg.SmcCallBack", "plugin msg version:" + l1 + ", " + l2 + ", " + l3);
    SmcLogic.OnPluginMsg(l5, l6, l7, l1, l2, l4);
    AppMethodBeat.o(72799);
  }
  
  public final boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72796);
    com.tencent.mm.kernel.g.RJ();
    if (!a.QT())
    {
      ab.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
      AppMethodBeat.o(72796);
      return false;
    }
    try
    {
      k localk = new k();
      localk.parseFrom(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toMMSelfMonitor(localk);
      if (paramArrayOfByte.xlp <= 0)
      {
        ab.e("KVReportJni", "error selfmonitor count");
        AppMethodBeat.o(72796);
        return true;
      }
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(202, paramArrayOfByte));
      AppMethodBeat.o(72796);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("KVReportJni", paramArrayOfByte.getMessage());
      AppMethodBeat.o(72796);
    }
    return false;
  }
  
  public final String getKVCommPath()
  {
    AppMethodBeat.i(72798);
    String str = AppLogic.getAppFilePath() + "/kvcomm/";
    ab.i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
    AppMethodBeat.o(72798);
    return str;
  }
  
  public final SmcLogic.BaseInfo getKVCommReqBaseInfo()
  {
    AppMethodBeat.i(72797);
    SmcLogic.BaseInfo localBaseInfo = new SmcLogic.BaseInfo();
    localBaseInfo.deviceModel = (Build.MODEL + Build.CPU_ABI);
    localBaseInfo.deviceBrand = Build.BRAND;
    localBaseInfo.osName = ("android-" + Build.MANUFACTURER);
    localBaseInfo.osVersion = Build.VERSION.SDK_INT;
    localBaseInfo.languageVer = aa.dsG();
    AppMethodBeat.o(72797);
    return localBaseInfo;
  }
  
  public final int getSingleReportBufSizeB()
  {
    return 20480;
  }
  
  public final void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    AppMethodBeat.i(72794);
    try
    {
      if ((qtk != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        qtk.onReportKVDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt);
      }
      AppMethodBeat.o(72794);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ab.e("KVReportJni", paramArrayOfByte1.getMessage());
      AppMethodBeat.o(72794);
    }
  }
  
  public final boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(72795);
    try
    {
      if ((com.tencent.mm.sdk.platformtools.g.ymN) && (ah.getContext().getSharedPreferences(ah.dsP(), 0).getBoolean("gprs_alert", true)))
      {
        ab.i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
        AppMethodBeat.o(72795);
        return false;
      }
      try
      {
        if (h.isRunning())
        {
          ab.i("KVReportJni", "already running");
          return false;
        }
        paramArrayOfByte = new h();
        com.tencent.mm.kernel.g.RK().eHt.a(paramArrayOfByte, 0);
        return true;
      }
      finally
      {
        AppMethodBeat.o(72795);
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("KVReportJni", "onRequestGetStrategy error: " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(72795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */