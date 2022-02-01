package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
{
  public static int Cur = 0;
  public static int Cus = 1;
  public static int Cut = 2;
  public int CfA;
  public int CfB;
  public int Cfe;
  public int Cfu;
  public int Cfz;
  public int Chf;
  public int CuA;
  public int CuB;
  public int CuC;
  public int CuD;
  public int CuE;
  public String CuF;
  public int CuG;
  public int CuH;
  public int CuI;
  public int CuJ;
  public int CuK;
  public int CuL;
  public int CuM;
  public int CuN;
  public int CuO;
  public int CuP;
  public int CuQ;
  public long CuR;
  public int CuS;
  public long CuT;
  public long CuU;
  public long CuV;
  public int CuW;
  public int CuX;
  public int CuY;
  public int CuZ;
  public int Cuu;
  public int Cuv;
  public int Cuw;
  public int Cux;
  public int Cuy;
  public int Cuz;
  public String Cva;
  public String Cvb;
  public String Cvc;
  public int Cvd;
  public int Cve;
  public int Cvf;
  public int Cvg;
  public int Cvh;
  public int Cvi;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int gHR;
  public int networkType;
  public long roomId;
  public long uLt;
  public long uMH;
  public String uMQ;
  public String uMR;
  public int videoFps;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.Cuu = 0;
    this.Cuv = 0;
    this.Cuw = 0;
    this.videoFps = 0;
    this.Cux = 0;
    this.Cuy = 0;
    this.Cuz = 0;
    this.CuA = 0;
    this.CuB = 0;
    this.CuC = 0;
    this.networkType = 0;
    this.CuD = 0;
    this.gHR = 0;
    this.Cfu = 0;
    this.roomId = 0L;
    this.uLt = 0L;
    this.CuF = "";
    this.Cfe = 0;
    this.CuH = 0;
    this.CuI = 0;
    this.CuJ = 0;
    this.CuK = 0;
    this.CfA = 0;
    this.Cfz = 0;
    this.CuL = 0;
    this.CuM = 1;
    this.CuN = 0;
    this.CuO = 0;
    this.CuP = 0;
    this.CuQ = 0;
    this.CuR = 0L;
    this.CuT = 0L;
    this.CuU = 0L;
    this.CuV = 0L;
    this.uMH = 0L;
    this.channelStrategy = 1;
    this.Chf = 0;
    this.CfB = 0;
    this.CuY = -1;
    this.CuZ = 0;
    this.Cva = "";
    this.deviceModel = "";
    this.Cvb = "";
    this.Cvc = "";
    this.Cvd = 0;
    this.Cve = 0;
    this.Cvf = 0;
    this.Cvg = 0;
    this.Cvh = 0;
    this.Cvi = 0;
    this.cpuFlag0 = m.aaf();
    this.uMR = "";
    this.uMQ = "";
    this.Cva = Build.MANUFACTURER;
    if (this.Cva.contains(",")) {
      this.Cva = this.Cva.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.Cvb = Build.VERSION.SDK;
    if (this.Cvb.contains(",")) {
      this.Cvb = this.Cvb.replace(',', ' ');
    }
    this.Cvc = Build.VERSION.RELEASE;
    if (this.Cvc.contains(",")) {
      this.Cvc = this.Cvc.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int eBH()
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
          i = Cur;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = Cus;
          AppMethodBeat.o(125354);
          return i;
        }
        i = Cut;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = Cur;
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
  
  public final void Vc(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.Cfz = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void eBE()
  {
    AppMethodBeat.i(125351);
    ad.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.Cvh == 0) && (this.Cvg != 0))
    {
      this.Cvh = ((int)(System.currentTimeMillis() / 1000L));
      this.uMH = (this.Cvh - this.Cvg);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void eBF()
  {
    AppMethodBeat.i(125352);
    ad.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.CuT == 0L)
    {
      this.Cvf = ((int)(System.currentTimeMillis() / 1000L));
      this.CuT = (this.Cvf - this.Cvd);
    }
    AppMethodBeat.o(125352);
  }
  
  public final dxh eBG()
  {
    AppMethodBeat.i(125353);
    dxh localdxh = new dxh();
    localdxh.nEf = 2;
    localdxh.FKb = this.uMQ;
    ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localdxh.FKb });
    String[] arrayOfString = this.uMQ.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = bt.getInt(arrayOfString[8], 0);
      this.Cux = bt.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localdxh;
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