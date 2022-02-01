package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static int Oix = 0;
  public static int Oiy = 1;
  public static int Oiz = 2;
  public long DPJ;
  public long DQW;
  public String DRf;
  public String DRg;
  public int NQG;
  public int NQW;
  public int NRa;
  public int NRb;
  public int NRc;
  public int NSH;
  public int OiA;
  public int OiB;
  public int OiC;
  public int OiD;
  public int OiE;
  public int OiF;
  public int OiG;
  public int OiH;
  public int OiI;
  public int OiJ;
  public int OiK;
  public String OiL;
  public int OiM;
  public int OiN;
  public int OiO;
  public int OiP;
  public int OiQ;
  public int OiR;
  public int OiS;
  public int OiT;
  public int OiU;
  public int OiV;
  public int OiW;
  public long OiX;
  public int OiY;
  public long OiZ;
  public long Oja;
  public long Ojb;
  public int Ojc;
  public int Ojd;
  public int Oje;
  public int Ojf;
  public String Ojg;
  public String Ojh;
  public String Oji;
  public int Ojj;
  public int Ojk;
  public int Ojl;
  public int Ojm;
  public int Ojn;
  public int Ojo;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int kmJ;
  public int networkType;
  public long roomId;
  public int videoFps;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.OiA = 0;
    this.OiB = 0;
    this.OiC = 0;
    this.videoFps = 0;
    this.OiD = 0;
    this.OiE = 0;
    this.OiF = 0;
    this.OiG = 0;
    this.OiH = 0;
    this.OiI = 0;
    this.networkType = 0;
    this.OiJ = 0;
    this.kmJ = 0;
    this.NQW = 0;
    this.roomId = 0L;
    this.DPJ = 0L;
    this.OiL = "";
    this.NQG = 0;
    this.OiN = 0;
    this.OiO = 0;
    this.OiP = 0;
    this.OiQ = 0;
    this.NRb = 0;
    this.NRa = 0;
    this.OiR = 0;
    this.OiS = 1;
    this.OiT = 0;
    this.OiU = 0;
    this.OiV = 0;
    this.OiW = 0;
    this.OiX = 0L;
    this.OiZ = 0L;
    this.Oja = 0L;
    this.Ojb = 0L;
    this.DQW = 0L;
    this.channelStrategy = 1;
    this.NSH = 0;
    this.NRc = 0;
    this.Oje = -1;
    this.Ojf = 0;
    this.Ojg = "";
    this.deviceModel = "";
    this.Ojh = "";
    this.Oji = "";
    this.Ojj = 0;
    this.Ojk = 0;
    this.Ojl = 0;
    this.Ojm = 0;
    this.Ojn = 0;
    this.Ojo = 0;
    this.cpuFlag0 = m.aus();
    this.DRg = "";
    this.DRf = "";
    this.Ojg = Build.MANUFACTURER;
    if (this.Ojg.contains(",")) {
      this.Ojg = this.Ojg.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.Ojh = Build.VERSION.SDK;
    if (this.Ojh.contains(",")) {
      this.Ojh = this.Ojh.replace(',', ' ');
    }
    this.Oji = Build.VERSION.RELEASE;
    if (this.Oji.contains(",")) {
      this.Oji = this.Oji.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int gFb()
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
          i = Oix;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = Oiy;
          AppMethodBeat.o(125354);
          return i;
        }
        i = Oiz;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = Oix;
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
  
  public final void alV(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.NRa = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void gEY()
  {
    AppMethodBeat.i(125351);
    Log.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.Ojn == 0) && (this.Ojm != 0))
    {
      this.Ojn = ((int)(System.currentTimeMillis() / 1000L));
      this.DQW = (this.Ojn - this.Ojm);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void gEZ()
  {
    AppMethodBeat.i(125352);
    Log.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.OiZ == 0L)
    {
      this.Ojl = ((int)(System.currentTimeMillis() / 1000L));
      this.OiZ = (this.Ojl - this.Ojj);
    }
    AppMethodBeat.o(125352);
  }
  
  public final fdq gFa()
  {
    AppMethodBeat.i(125353);
    fdq localfdq = new fdq();
    localfdq.rWu = 2;
    localfdq.RXT = this.DRf;
    Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localfdq.RXT });
    String[] arrayOfString = this.DRf.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = Util.getInt(arrayOfString[8], 0);
      this.OiD = Util.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localfdq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.d
 * JD-Core Version:    0.7.0.1
 */