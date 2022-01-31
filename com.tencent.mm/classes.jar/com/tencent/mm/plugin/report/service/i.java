package com.tencent.mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class i
  implements SmcLogic.ICallBack
{
  public static IKVReportNotify nGg = null;
  
  public static void LW(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.SmcCallBack", "msg content is null");
      return;
    }
    y.i("MicroMsg.SmcCallBack", "receive msg: " + paramString);
    Map localMap = bn.s(paramString, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      y.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + paramString);
      return;
    }
    String str = (String)localMap.get(".sysmsg.$type");
    if ((bk.bl(str)) || (!str.equalsIgnoreCase("getkvidkeystg")))
    {
      y.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + paramString);
      return;
    }
    long l1 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.generalversion"), -1L);
    long l2 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.specialversion"), -1L);
    long l3 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1L);
    long l4 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.timeinterval"), -1L);
    long l5 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1L);
    long l6 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1L);
    long l7 = bk.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1L);
    if ((l1 == -1L) || (l2 == -1L) || (l3 == -1L) || (l4 == -1L) || (-1L == l5) || (-1L == l6) || (-1L == l7))
    {
      y.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + paramString);
      return;
    }
    y.i("MicroMsg.SmcCallBack", "plugin msg version:" + l1 + ", " + l2 + ", " + l3);
    SmcLogic.OnPluginMsg(l5, l6, l7, l1, l2, l4);
  }
  
  public final boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte)
  {
    g.DN();
    if (!a.Db())
    {
      y.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
      return false;
    }
    try
    {
      k localk = new k();
      localk.aH(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toMMSelfMonitor(localk);
      if (paramArrayOfByte.tlW <= 0)
      {
        y.e("KVReportJni", "error selfmonitor count");
        return true;
      }
      ((j)g.r(j.class)).Fv().b(new i.a(202, paramArrayOfByte));
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("KVReportJni", paramArrayOfByte.getMessage());
    }
    return false;
  }
  
  public final String getKVCommPath()
  {
    return AppLogic.getAppFilePath() + "/kvcomm/";
  }
  
  public final SmcLogic.BaseInfo getKVCommReqBaseInfo()
  {
    SmcLogic.BaseInfo localBaseInfo = new SmcLogic.BaseInfo();
    localBaseInfo.deviceModel = (Build.MODEL + Build.CPU_ABI);
    localBaseInfo.deviceBrand = Build.BRAND;
    localBaseInfo.osName = ("android-" + Build.MANUFACTURER);
    localBaseInfo.osVersion = Build.VERSION.SDK_INT;
    localBaseInfo.languageVer = x.cqJ();
    return localBaseInfo;
  }
  
  public final int getSingleReportBufSizeB()
  {
    return 20480;
  }
  
  public final void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    try
    {
      if ((nGg != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        nGg.onReportKVDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt);
      }
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      y.e("KVReportJni", paramArrayOfByte1.getMessage());
    }
  }
  
  public final boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      try
      {
        if (com.tencent.mm.plugin.report.b.h.isRunning())
        {
          y.i("KVReportJni", "already running");
          return false;
        }
        paramArrayOfByte = new com.tencent.mm.plugin.report.b.h();
        g.DO().dJT.a(paramArrayOfByte, 0);
        return true;
      }
      finally {}
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("KVReportJni", "onRequestGetStrategy error: " + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.i
 * JD-Core Version:    0.7.0.1
 */