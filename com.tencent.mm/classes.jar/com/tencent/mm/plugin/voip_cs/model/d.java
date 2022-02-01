package com.tencent.mm.plugin.voip_cs.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.protocal.protobuf.gac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static int UWS = 0;
  public static int UWT = 1;
  public static int UWU = 2;
  public long Hnt;
  public long JIg;
  public String JIp;
  public String JIq;
  public int UDI;
  public int UDM;
  public int UDN;
  public int UDO;
  public int UDs;
  public int UFM;
  public int UWV;
  public int UWW;
  public int UWX;
  public int UWY;
  public int UWZ;
  public int UXA;
  public String UXB;
  public String UXC;
  public String UXD;
  public int UXE;
  public int UXF;
  public int UXG;
  public int UXH;
  public int UXI;
  public int UXJ;
  public int UXa;
  public int UXb;
  public int UXc;
  public int UXd;
  public int UXe;
  public int UXf;
  public String UXg;
  public int UXh;
  public int UXi;
  public int UXj;
  public int UXk;
  public int UXl;
  public int UXm;
  public int UXn;
  public int UXo;
  public int UXp;
  public int UXq;
  public int UXr;
  public long UXs;
  public int UXt;
  public long UXu;
  public long UXv;
  public long UXw;
  public int UXx;
  public int UXy;
  public int UXz;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int mNT;
  public int networkType;
  public long roomId;
  public int videoFps;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.UWV = 0;
    this.UWW = 0;
    this.UWX = 0;
    this.videoFps = 0;
    this.UWY = 0;
    this.UWZ = 0;
    this.UXa = 0;
    this.UXb = 0;
    this.UXc = 0;
    this.UXd = 0;
    this.networkType = 0;
    this.UXe = 0;
    this.mNT = 0;
    this.UDI = 0;
    this.roomId = 0L;
    this.Hnt = 0L;
    this.UXg = "";
    this.UDs = 0;
    this.UXi = 0;
    this.UXj = 0;
    this.UXk = 0;
    this.UXl = 0;
    this.UDN = 0;
    this.UDM = 0;
    this.UXm = 0;
    this.UXn = 1;
    this.UXo = 0;
    this.UXp = 0;
    this.UXq = 0;
    this.UXr = 0;
    this.UXs = 0L;
    this.UXu = 0L;
    this.UXv = 0L;
    this.UXw = 0L;
    this.JIg = 0L;
    this.channelStrategy = 1;
    this.UFM = 0;
    this.UDO = 0;
    this.UXz = -1;
    this.UXA = 0;
    this.UXB = "";
    this.deviceModel = "";
    this.UXC = "";
    this.UXD = "";
    this.UXE = 0;
    this.UXF = 0;
    this.UXG = 0;
    this.UXH = 0;
    this.UXI = 0;
    this.UXJ = 0;
    this.cpuFlag0 = m.aOK();
    this.JIq = "";
    this.JIp = "";
    this.UXB = Build.MANUFACTURER;
    if (this.UXB.contains(",")) {
      this.UXB = this.UXB.replace(',', ' ');
    }
    this.deviceModel = q.aPo();
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.UXC = Build.VERSION.SDK;
    if (this.UXC.contains(",")) {
      this.UXC = this.UXC.replace(',', ' ');
    }
    this.UXD = Build.VERSION.RELEASE;
    if (this.UXD.contains(",")) {
      this.UXD = this.UXD.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int iec()
  {
    AppMethodBeat.i(125354);
    int i;
    try
    {
      Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
        if (localObject == null)
        {
          i = UWS;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = UWT;
          AppMethodBeat.o(125354);
          return i;
        }
        i = UWU;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = UWS;
      AppMethodBeat.o(125354);
    }
    return i;
  }
  
  public final void arD(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.UDM = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void idZ()
  {
    AppMethodBeat.i(125351);
    Log.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.UXI == 0) && (this.UXH != 0))
    {
      this.UXI = ((int)(System.currentTimeMillis() / 1000L));
      this.JIg = (this.UXI - this.UXH);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void iea()
  {
    AppMethodBeat.i(125352);
    Log.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.UXu == 0L)
    {
      this.UXG = ((int)(System.currentTimeMillis() / 1000L));
      this.UXu = (this.UXG - this.UXE);
    }
    AppMethodBeat.o(125352);
  }
  
  public final gac ieb()
  {
    AppMethodBeat.i(125353);
    gac localgac = new gac();
    localgac.vhJ = 2;
    localgac.YVP = this.JIp;
    Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localgac.YVP });
    String[] arrayOfString = this.JIp.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = Util.getInt(arrayOfString[8], 0);
      this.UWY = Util.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localgac;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.d
 * JD-Core Version:    0.7.0.1
 */