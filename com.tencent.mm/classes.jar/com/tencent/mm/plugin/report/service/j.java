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
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class j
  implements SmcLogic.ICallBack
{
  public static IKVReportNotify OAT = null;
  
  public static void aUp(String paramString)
  {
    AppMethodBeat.i(143926);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SmcCallBack", "msg content is null");
      AppMethodBeat.o(143926);
      return;
    }
    Log.i("MicroMsg.SmcCallBack", "receive msg: ".concat(String.valueOf(paramString)));
    Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    String str = (String)localMap.get(".sysmsg.$type");
    if ((Util.isNullOrNil(str)) || (!str.equalsIgnoreCase("getkvidkeystg")))
    {
      Log.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    long l1 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.generalversion"), -1L);
    long l2 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.specialversion"), -1L);
    long l3 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1L);
    long l4 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.timeinterval"), -1L);
    long l5 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1L);
    long l6 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1L);
    long l7 = Util.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1L);
    if ((l1 == -1L) || (l2 == -1L) || (l3 == -1L) || (l4 == -1L) || (-1L == l5) || (-1L == l6) || (-1L == l7))
    {
      Log.e("MicroMsg.SmcCallBack", "plugin msg parse fail:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143926);
      return;
    }
    Log.i("MicroMsg.SmcCallBack", "plugin msg version:" + l1 + ", " + l2 + ", " + l3);
    SmcLogic.OnPluginMsg(l5, l6, l7, l1, l2, l4);
    AppMethodBeat.o(143926);
  }
  
  public final boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(143923);
    com.tencent.mm.kernel.h.baC();
    if (!b.aZM())
    {
      Log.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
      AppMethodBeat.o(143923);
      return false;
    }
    try
    {
      k localk = new k();
      localk.parseFrom(paramArrayOfByte);
      paramArrayOfByte = SmcProtoBufUtil.toMMSelfMonitor(localk);
      if (paramArrayOfByte.aaGy <= 0)
      {
        Log.e("KVReportJni", "error selfmonitor count");
        AppMethodBeat.o(143923);
        return true;
      }
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(202, paramArrayOfByte));
      AppMethodBeat.o(143923);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("KVReportJni", paramArrayOfByte.getMessage());
      AppMethodBeat.o(143923);
    }
    return false;
  }
  
  public final String getKVCommPath()
  {
    AppMethodBeat.i(143925);
    String str = AppLogic.getAppFilePath() + "/kvcomm/";
    Log.i("MicroMsg.SmcCallBack", "[TEST-PATH (Smc)]path:" + AppLogic.getAppFilePath());
    AppMethodBeat.o(143925);
    return str;
  }
  
  public final SmcLogic.BaseInfo getKVCommReqBaseInfo()
  {
    AppMethodBeat.i(143924);
    SmcLogic.BaseInfo localBaseInfo = new SmcLogic.BaseInfo();
    localBaseInfo.deviceModel = (q.aPo() + Build.CPU_ABI);
    localBaseInfo.deviceBrand = Build.BRAND;
    localBaseInfo.osName = ("android-" + Build.MANUFACTURER);
    localBaseInfo.osVersion = Build.VERSION.SDK_INT;
    localBaseInfo.languageVer = LocaleUtil.getApplicationLanguage();
    AppMethodBeat.o(143924);
    return localBaseInfo;
  }
  
  public final int getSingleReportBufSizeB()
  {
    return 20480;
  }
  
  public final void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    AppMethodBeat.i(261720);
    try
    {
      if ((OAT != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        OAT.onReportKVDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt);
      }
      AppMethodBeat.o(261720);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("KVReportJni", paramArrayOfByte1.getMessage());
      AppMethodBeat.o(261720);
    }
  }
  
  public final boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(143922);
    try
    {
      if ((ChannelUtil.shouldShowGprsAlert) && (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)))
      {
        Log.i("MicroMsg.SmcCallBack", "onRequestGetStrategy gprs alert return false");
        AppMethodBeat.o(143922);
        return false;
      }
      try
      {
        if (com.tencent.mm.plugin.report.b.h.isRunning())
        {
          Log.i("KVReportJni", "already running");
          return false;
        }
        paramArrayOfByte = new com.tencent.mm.plugin.report.b.h();
        com.tencent.mm.kernel.h.baD().mCm.a(paramArrayOfByte, 0);
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
      Log.e("KVReportJni", "onRequestGetStrategy error: " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(143922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.j
 * JD-Core Version:    0.7.0.1
 */