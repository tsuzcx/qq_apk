package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
{
  public static int CLW = 0;
  public static int CLX = 1;
  public static int CLY = 2;
  public int CLZ;
  public long CMA;
  public int CMB;
  public int CMC;
  public int CMD;
  public int CME;
  public String CMF;
  public String CMG;
  public String CMH;
  public int CMI;
  public int CMJ;
  public int CMK;
  public int CML;
  public int CMM;
  public int CMN;
  public int CMa;
  public int CMb;
  public int CMc;
  public int CMd;
  public int CMe;
  public int CMf;
  public int CMg;
  public int CMh;
  public int CMi;
  public int CMj;
  public String CMk;
  public int CMl;
  public int CMm;
  public int CMn;
  public int CMo;
  public int CMp;
  public int CMq;
  public int CMr;
  public int CMs;
  public int CMt;
  public int CMu;
  public int CMv;
  public long CMw;
  public int CMx;
  public long CMy;
  public long CMz;
  public int CwF;
  public int CwV;
  public int Cxa;
  public int Cxb;
  public int Cxc;
  public int CyG;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int gKA;
  public int networkType;
  public long roomId;
  public long uXg;
  public String uYD;
  public String uYE;
  public long uYu;
  public int videoFps;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.CLZ = 0;
    this.CMa = 0;
    this.CMb = 0;
    this.videoFps = 0;
    this.CMc = 0;
    this.CMd = 0;
    this.CMe = 0;
    this.CMf = 0;
    this.CMg = 0;
    this.CMh = 0;
    this.networkType = 0;
    this.CMi = 0;
    this.gKA = 0;
    this.CwV = 0;
    this.roomId = 0L;
    this.uXg = 0L;
    this.CMk = "";
    this.CwF = 0;
    this.CMm = 0;
    this.CMn = 0;
    this.CMo = 0;
    this.CMp = 0;
    this.Cxb = 0;
    this.Cxa = 0;
    this.CMq = 0;
    this.CMr = 1;
    this.CMs = 0;
    this.CMt = 0;
    this.CMu = 0;
    this.CMv = 0;
    this.CMw = 0L;
    this.CMy = 0L;
    this.CMz = 0L;
    this.CMA = 0L;
    this.uYu = 0L;
    this.channelStrategy = 1;
    this.CyG = 0;
    this.Cxc = 0;
    this.CMD = -1;
    this.CME = 0;
    this.CMF = "";
    this.deviceModel = "";
    this.CMG = "";
    this.CMH = "";
    this.CMI = 0;
    this.CMJ = 0;
    this.CMK = 0;
    this.CML = 0;
    this.CMM = 0;
    this.CMN = 0;
    this.cpuFlag0 = m.aao();
    this.uYE = "";
    this.uYD = "";
    this.CMF = Build.MANUFACTURER;
    if (this.CMF.contains(",")) {
      this.CMF = this.CMF.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.CMG = Build.VERSION.SDK;
    if (this.CMG.contains(",")) {
      this.CMG = this.CMG.replace(',', ' ');
    }
    this.CMH = Build.VERSION.RELEASE;
    if (this.CMH.contains(",")) {
      this.CMH = this.CMH.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int eFp()
  {
    AppMethodBeat.i(125354);
    int i;
    try
    {
      Object localObject = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
        if (localObject == null)
        {
          i = CLW;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = CLX;
          AppMethodBeat.o(125354);
          return i;
        }
        i = CLY;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = CLW;
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
      ae.printErrStackTrace("MicroMsg.VoipCSReportHelper", paramContext, "", new Object[0]);
      AppMethodBeat.o(125355);
    }
    return 0;
  }
  
  public final void VJ(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.Cxa = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void eFm()
  {
    AppMethodBeat.i(125351);
    ae.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.CMM == 0) && (this.CML != 0))
    {
      this.CMM = ((int)(System.currentTimeMillis() / 1000L));
      this.uYu = (this.CMM - this.CML);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void eFn()
  {
    AppMethodBeat.i(125352);
    ae.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.CMy == 0L)
    {
      this.CMK = ((int)(System.currentTimeMillis() / 1000L));
      this.CMy = (this.CMK - this.CMI);
    }
    AppMethodBeat.o(125352);
  }
  
  public final dyy eFo()
  {
    AppMethodBeat.i(125353);
    dyy localdyy = new dyy();
    localdyy.nJA = 2;
    localdyy.GcA = this.uYD;
    ae.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localdyy.GcA });
    String[] arrayOfString = this.uYD.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = bu.getInt(arrayOfString[8], 0);
      this.CMc = bu.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localdyy;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.d
 * JD-Core Version:    0.7.0.1
 */