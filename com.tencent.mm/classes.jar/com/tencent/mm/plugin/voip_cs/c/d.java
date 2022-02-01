package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
{
  public static int zBV = 0;
  public static int zBW = 1;
  public static int zBX = 2;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int networkType;
  public long roomId;
  public long sAY;
  public long sCm;
  public String sCv;
  public String sCw;
  public int videoFps;
  public int zBY;
  public int zBZ;
  public long zCA;
  public int zCB;
  public int zCC;
  public int zCD;
  public int zCE;
  public String zCF;
  public String zCG;
  public String zCH;
  public int zCI;
  public int zCJ;
  public int zCK;
  public int zCL;
  public int zCM;
  public int zCN;
  public int zCa;
  public int zCb;
  public int zCc;
  public int zCd;
  public int zCe;
  public int zCf;
  public int zCg;
  public int zCh;
  public int zCi;
  public int zCj;
  public String zCk;
  public int zCl;
  public int zCm;
  public int zCn;
  public int zCo;
  public int zCp;
  public int zCq;
  public int zCr;
  public int zCs;
  public int zCt;
  public int zCu;
  public int zCv;
  public long zCw;
  public int zCx;
  public long zCy;
  public long zCz;
  public int znG;
  public int znL;
  public int znM;
  public int znN;
  public int znq;
  public int zpp;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.zBY = 0;
    this.zBZ = 0;
    this.zCa = 0;
    this.videoFps = 0;
    this.zCb = 0;
    this.zCc = 0;
    this.zCd = 0;
    this.zCe = 0;
    this.zCf = 0;
    this.zCg = 0;
    this.networkType = 0;
    this.zCh = 0;
    this.zCj = 0;
    this.znG = 0;
    this.roomId = 0L;
    this.sAY = 0L;
    this.zCk = "";
    this.znq = 0;
    this.zCm = 0;
    this.zCn = 0;
    this.zCo = 0;
    this.zCp = 0;
    this.znM = 0;
    this.znL = 0;
    this.zCq = 0;
    this.zCr = 1;
    this.zCs = 0;
    this.zCt = 0;
    this.zCu = 0;
    this.zCv = 0;
    this.zCw = 0L;
    this.zCy = 0L;
    this.zCz = 0L;
    this.zCA = 0L;
    this.sCm = 0L;
    this.channelStrategy = 1;
    this.zpp = 0;
    this.znN = 0;
    this.zCD = -1;
    this.zCE = 0;
    this.zCF = "";
    this.deviceModel = "";
    this.zCG = "";
    this.zCH = "";
    this.zCI = 0;
    this.zCJ = 0;
    this.zCK = 0;
    this.zCL = 0;
    this.zCM = 0;
    this.zCN = 0;
    this.cpuFlag0 = m.WG();
    this.sCw = "";
    this.sCv = "";
    this.zCF = Build.MANUFACTURER;
    if (this.zCF.contains(",")) {
      this.zCF = this.zCF.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.zCG = Build.VERSION.SDK;
    if (this.zCG.contains(",")) {
      this.zCG = this.zCG.replace(',', ' ');
    }
    this.zCH = Build.VERSION.RELEASE;
    if (this.zCH.contains(",")) {
      this.zCH = this.zCH.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int dYm()
  {
    AppMethodBeat.i(125354);
    int i;
    try
    {
      Object localObject = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
        if (localObject == null)
        {
          i = zBV;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = zBW;
          AppMethodBeat.o(125354);
          return i;
        }
        i = zBX;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = zBV;
      AppMethodBeat.o(125354);
    }
    return i;
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(125355);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(125355);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(125355);
        return 1;
      }
      i = paramContext.getType();
      if (i != 0)
      {
        AppMethodBeat.o(125355);
        return 0;
      }
      i = paramContext.getSubtype();
      if (i == 1)
      {
        AppMethodBeat.o(125355);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i == 2)
      {
        AppMethodBeat.o(125355);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i == 13)
      {
        AppMethodBeat.o(125355);
        return 4;
      }
      if ((paramContext.getSubtype() < 3) || (paramContext.getSubtype() >= 13))
      {
        i = paramContext.getSubtype();
        if (i <= 13) {}
      }
      else
      {
        AppMethodBeat.o(125355);
        return 3;
      }
      AppMethodBeat.o(125355);
      return 2;
    }
    catch (NullPointerException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.VoipCSReportHelper", paramContext, "", new Object[0]);
      AppMethodBeat.o(125355);
    }
    return 0;
  }
  
  public final void Ra(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.znL = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void dYj()
  {
    AppMethodBeat.i(125351);
    ad.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.zCM == 0) && (this.zCL != 0))
    {
      this.zCM = ((int)(System.currentTimeMillis() / 1000L));
      this.sCm = (this.zCM - this.zCL);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void dYk()
  {
    AppMethodBeat.i(125352);
    ad.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.zCy == 0L)
    {
      this.zCK = ((int)(System.currentTimeMillis() / 1000L));
      this.zCy = (this.zCK - this.zCI);
    }
    AppMethodBeat.o(125352);
  }
  
  public final dlw dYl()
  {
    AppMethodBeat.i(125353);
    dlw localdlw = new dlw();
    localdlw.mBH = 2;
    localdlw.DAq = this.sCv;
    ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localdlw.DAq });
    String[] arrayOfString = this.sCv.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = bt.getInt(arrayOfString[8], 0);
      this.zCb = bt.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localdlw;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.d
 * JD-Core Version:    0.7.0.1
 */