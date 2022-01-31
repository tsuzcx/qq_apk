package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
{
  public static int MOBILE_NETWORK_DISCONNECT = 2;
  public static int tJO = 0;
  public static int tJP = 1;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public long nNa;
  public String nOA;
  public String nOB;
  public long nOr;
  public int networkType;
  public int tAo;
  public int tAt;
  public int tAu;
  public int tAv;
  public int tBM;
  public int tJQ;
  public int tJR;
  public int tJS;
  public int tJT;
  public int tJU;
  public int tJV;
  public int tJW;
  public int tJX;
  public int tJY;
  public int tJZ;
  public String tKA;
  public int tKB;
  public int tKC;
  public int tKD;
  public int tKE;
  public int tKF;
  public int tKG;
  public int tKa;
  public int tKb;
  public long tKc;
  public String tKd;
  public int tKe;
  public int tKf;
  public int tKg;
  public int tKh;
  public int tKi;
  public int tKj;
  public int tKk;
  public int tKl;
  public int tKm;
  public int tKn;
  public int tKo;
  public long tKp;
  public int tKq;
  public long tKr;
  public long tKs;
  public long tKt;
  public int tKu;
  public int tKv;
  public int tKw;
  public int tKx;
  public String tKy;
  public String tKz;
  public int tzZ;
  public int videoFps;
  
  public d()
  {
    AppMethodBeat.i(135297);
    this.dataType = 0;
    this.tJQ = 0;
    this.tJR = 0;
    this.tJS = 0;
    this.videoFps = 0;
    this.tJT = 0;
    this.tJU = 0;
    this.tJV = 0;
    this.tJW = 0;
    this.tJX = 0;
    this.tJY = 0;
    this.networkType = 0;
    this.tJZ = 0;
    this.tKb = 0;
    this.tAo = 0;
    this.tKc = 0L;
    this.nNa = 0L;
    this.tKd = "";
    this.tzZ = 0;
    this.tKf = 0;
    this.tKg = 0;
    this.tKh = 0;
    this.tKi = 0;
    this.tAu = 0;
    this.tAt = 0;
    this.tKj = 0;
    this.tKk = 1;
    this.tKl = 0;
    this.tKm = 0;
    this.tKn = 0;
    this.tKo = 0;
    this.tKp = 0L;
    this.tKr = 0L;
    this.tKs = 0L;
    this.tKt = 0L;
    this.nOr = 0L;
    this.channelStrategy = 1;
    this.tBM = 0;
    this.tAv = 0;
    this.tKw = -1;
    this.tKx = 0;
    this.tKy = "";
    this.deviceModel = "";
    this.tKz = "";
    this.tKA = "";
    this.tKB = 0;
    this.tKC = 0;
    this.tKD = 0;
    this.tKE = 0;
    this.tKF = 0;
    this.tKG = 0;
    this.cpuFlag0 = m.Lo();
    this.nOB = "";
    this.nOA = "";
    this.tKy = Build.MANUFACTURER;
    if (this.tKy.contains(",")) {
      this.tKy = this.tKy.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.tKz = Build.VERSION.SDK;
    if (this.tKz.contains(",")) {
      this.tKz = this.tKz.replace(',', ' ');
    }
    this.tKA = Build.VERSION.RELEASE;
    if (this.tKA.contains(",")) {
      this.tKA = this.tKA.replace(',', ' ');
    }
    AppMethodBeat.o(135297);
  }
  
  public static int cQs()
  {
    AppMethodBeat.i(135302);
    int i;
    try
    {
      Object localObject = (ConnectivityManager)ah.getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
        if (localObject == null)
        {
          i = tJO;
          AppMethodBeat.o(135302);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = tJP;
          AppMethodBeat.o(135302);
          return i;
        }
        i = MOBILE_NETWORK_DISCONNECT;
        AppMethodBeat.o(135302);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = tJO;
      AppMethodBeat.o(135302);
    }
    return i;
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(135303);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(135303);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(135303);
        return 1;
      }
      i = paramContext.getType();
      if (i != 0)
      {
        AppMethodBeat.o(135303);
        return 0;
      }
      i = paramContext.getSubtype();
      if (i == 1)
      {
        AppMethodBeat.o(135303);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i == 2)
      {
        AppMethodBeat.o(135303);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i == 13)
      {
        AppMethodBeat.o(135303);
        return 4;
      }
      if ((paramContext.getSubtype() < 3) || (paramContext.getSubtype() >= 13))
      {
        i = paramContext.getSubtype();
        if (i <= 13) {}
      }
      else
      {
        AppMethodBeat.o(135303);
        return 3;
      }
      AppMethodBeat.o(135303);
      return 2;
    }
    catch (NullPointerException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.VoipCSReportHelper", paramContext, "", new Object[0]);
      AppMethodBeat.o(135303);
    }
    return 0;
  }
  
  public final void Id(int paramInt)
  {
    AppMethodBeat.i(135298);
    this.tAt = Math.abs(paramInt);
    AppMethodBeat.o(135298);
  }
  
  public final void cQp()
  {
    AppMethodBeat.i(135299);
    ab.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.tKF == 0) && (this.tKE != 0))
    {
      this.tKF = ((int)(System.currentTimeMillis() / 1000L));
      this.nOr = (this.tKF - this.tKE);
    }
    AppMethodBeat.o(135299);
  }
  
  public final void cQq()
  {
    AppMethodBeat.i(135300);
    ab.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.tKr == 0L)
    {
      this.tKD = ((int)(System.currentTimeMillis() / 1000L));
      this.tKr = (this.tKD - this.tKB);
    }
    AppMethodBeat.o(135300);
  }
  
  public final csb cQr()
  {
    AppMethodBeat.i(135301);
    csb localcsb = new csb();
    localcsb.jKs = 2;
    localcsb.yaU = this.nOA;
    ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localcsb.yaU });
    String[] arrayOfString = this.nOA.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = bo.getInt(arrayOfString[8], 0);
      this.tJT = bo.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(135301);
      return localcsb;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.d
 * JD-Core Version:    0.7.0.1
 */