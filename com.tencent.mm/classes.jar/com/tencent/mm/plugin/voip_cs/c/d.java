package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.protocal.protobuf.etf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static int HqM = 0;
  public static int HqN = 1;
  public static int HqO = 2;
  public int HaK;
  public int HaO;
  public int HaP;
  public int HaQ;
  public int Hau;
  public int Hcv;
  public int HqP;
  public int HqQ;
  public int HqR;
  public int HqS;
  public int HqT;
  public int HqU;
  public int HqV;
  public int HqW;
  public int HqX;
  public int HqY;
  public int HqZ;
  public int HrA;
  public int HrB;
  public int HrC;
  public int HrD;
  public String Hra;
  public int Hrb;
  public int Hrc;
  public int Hrd;
  public int Hre;
  public int Hrf;
  public int Hrg;
  public int Hrh;
  public int Hri;
  public int Hrj;
  public int Hrk;
  public int Hrl;
  public long Hrm;
  public int Hrn;
  public long Hro;
  public long Hrp;
  public long Hrq;
  public int Hrr;
  public int Hrs;
  public int Hrt;
  public int Hru;
  public String Hrv;
  public String Hrw;
  public String Hrx;
  public int Hry;
  public int Hrz;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int hzL;
  public int networkType;
  public long roomId;
  public int videoFps;
  public long ypH;
  public long yqU;
  public String yrd;
  public String yre;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.HqP = 0;
    this.HqQ = 0;
    this.HqR = 0;
    this.videoFps = 0;
    this.HqS = 0;
    this.HqT = 0;
    this.HqU = 0;
    this.HqV = 0;
    this.HqW = 0;
    this.HqX = 0;
    this.networkType = 0;
    this.HqY = 0;
    this.hzL = 0;
    this.HaK = 0;
    this.roomId = 0L;
    this.ypH = 0L;
    this.Hra = "";
    this.Hau = 0;
    this.Hrc = 0;
    this.Hrd = 0;
    this.Hre = 0;
    this.Hrf = 0;
    this.HaP = 0;
    this.HaO = 0;
    this.Hrg = 0;
    this.Hrh = 1;
    this.Hri = 0;
    this.Hrj = 0;
    this.Hrk = 0;
    this.Hrl = 0;
    this.Hrm = 0L;
    this.Hro = 0L;
    this.Hrp = 0L;
    this.Hrq = 0L;
    this.yqU = 0L;
    this.channelStrategy = 1;
    this.Hcv = 0;
    this.HaQ = 0;
    this.Hrt = -1;
    this.Hru = 0;
    this.Hrv = "";
    this.deviceModel = "";
    this.Hrw = "";
    this.Hrx = "";
    this.Hry = 0;
    this.Hrz = 0;
    this.HrA = 0;
    this.HrB = 0;
    this.HrC = 0;
    this.HrD = 0;
    this.cpuFlag0 = m.aon();
    this.yre = "";
    this.yrd = "";
    this.Hrv = Build.MANUFACTURER;
    if (this.Hrv.contains(",")) {
      this.Hrv = this.Hrv.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.Hrw = Build.VERSION.SDK;
    if (this.Hrw.contains(",")) {
      this.Hrw = this.Hrw.replace(',', ' ');
    }
    this.Hrx = Build.VERSION.RELEASE;
    if (this.Hrx.contains(",")) {
      this.Hrx = this.Hrx.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int fMx()
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
          i = HqM;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = HqN;
          AppMethodBeat.o(125354);
          return i;
        }
        i = HqO;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = HqM;
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
      Log.printErrStackTrace("MicroMsg.VoipCSReportHelper", paramContext, "", new Object[0]);
      AppMethodBeat.o(125355);
    }
    return 0;
  }
  
  public final void aei(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.HaO = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void fMu()
  {
    AppMethodBeat.i(125351);
    Log.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.HrC == 0) && (this.HrB != 0))
    {
      this.HrC = ((int)(System.currentTimeMillis() / 1000L));
      this.yqU = (this.HrC - this.HrB);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void fMv()
  {
    AppMethodBeat.i(125352);
    Log.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.Hro == 0L)
    {
      this.HrA = ((int)(System.currentTimeMillis() / 1000L));
      this.Hro = (this.HrA - this.Hry);
    }
    AppMethodBeat.o(125352);
  }
  
  public final etf fMw()
  {
    AppMethodBeat.i(125353);
    etf localetf = new etf();
    localetf.oUv = 2;
    localetf.KWF = this.yrd;
    Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localetf.KWF });
    String[] arrayOfString = this.yrd.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = Util.getInt(arrayOfString[8], 0);
      this.HqS = Util.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localetf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.d
 * JD-Core Version:    0.7.0.1
 */