package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
{
  public static int AUj = 0;
  public static int AUk = 1;
  public static int AUl = 2;
  public int AGA;
  public int AGB;
  public int AGe;
  public int AGu;
  public int AGz;
  public int AIe;
  public int AUA;
  public int AUB;
  public int AUC;
  public int AUD;
  public int AUE;
  public int AUF;
  public int AUG;
  public int AUH;
  public int AUI;
  public long AUJ;
  public int AUK;
  public long AUL;
  public long AUM;
  public long AUN;
  public int AUO;
  public int AUP;
  public int AUQ;
  public int AUR;
  public String AUS;
  public String AUT;
  public String AUU;
  public int AUV;
  public int AUW;
  public int AUX;
  public int AUY;
  public int AUZ;
  public int AUm;
  public int AUn;
  public int AUo;
  public int AUp;
  public int AUq;
  public int AUr;
  public int AUs;
  public int AUt;
  public int AUu;
  public int AUv;
  public int AUw;
  public String AUx;
  public int AUy;
  public int AUz;
  public int AVa;
  public int channelStrategy;
  public int cpuFlag0;
  public int dataType;
  public String deviceModel;
  public int goi;
  public int networkType;
  public long roomId;
  public long tIG;
  public long tJU;
  public String tKd;
  public String tKe;
  public int videoFps;
  
  public d()
  {
    AppMethodBeat.i(125349);
    this.dataType = 0;
    this.AUm = 0;
    this.AUn = 0;
    this.AUo = 0;
    this.videoFps = 0;
    this.AUp = 0;
    this.AUq = 0;
    this.AUr = 0;
    this.AUs = 0;
    this.AUt = 0;
    this.AUu = 0;
    this.networkType = 0;
    this.AUv = 0;
    this.goi = 0;
    this.AGu = 0;
    this.roomId = 0L;
    this.tIG = 0L;
    this.AUx = "";
    this.AGe = 0;
    this.AUz = 0;
    this.AUA = 0;
    this.AUB = 0;
    this.AUC = 0;
    this.AGA = 0;
    this.AGz = 0;
    this.AUD = 0;
    this.AUE = 1;
    this.AUF = 0;
    this.AUG = 0;
    this.AUH = 0;
    this.AUI = 0;
    this.AUJ = 0L;
    this.AUL = 0L;
    this.AUM = 0L;
    this.AUN = 0L;
    this.tJU = 0L;
    this.channelStrategy = 1;
    this.AIe = 0;
    this.AGB = 0;
    this.AUQ = -1;
    this.AUR = 0;
    this.AUS = "";
    this.deviceModel = "";
    this.AUT = "";
    this.AUU = "";
    this.AUV = 0;
    this.AUW = 0;
    this.AUX = 0;
    this.AUY = 0;
    this.AUZ = 0;
    this.AVa = 0;
    this.cpuFlag0 = m.XE();
    this.tKe = "";
    this.tKd = "";
    this.AUS = Build.MANUFACTURER;
    if (this.AUS.contains(",")) {
      this.AUS = this.AUS.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.AUT = Build.VERSION.SDK;
    if (this.AUT.contains(",")) {
      this.AUT = this.AUT.replace(',', ' ');
    }
    this.AUU = Build.VERSION.RELEASE;
    if (this.AUU.contains(",")) {
      this.AUU = this.AUU.replace(',', ' ');
    }
    AppMethodBeat.o(125349);
  }
  
  public static int enI()
  {
    AppMethodBeat.i(125354);
    int i;
    try
    {
      Object localObject = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
        if (localObject == null)
        {
          i = AUj;
          AppMethodBeat.o(125354);
          return i;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)
        {
          i = AUk;
          AppMethodBeat.o(125354);
          return i;
        }
        i = AUl;
        AppMethodBeat.o(125354);
        return i;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
      i = AUj;
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
      ac.printErrStackTrace("MicroMsg.VoipCSReportHelper", paramContext, "", new Object[0]);
      AppMethodBeat.o(125355);
    }
    return 0;
  }
  
  public final void Tj(int paramInt)
  {
    AppMethodBeat.i(125350);
    this.AGz = Math.abs(paramInt);
    AppMethodBeat.o(125350);
  }
  
  public final void enF()
  {
    AppMethodBeat.i(125351);
    ac.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.AUZ == 0) && (this.AUY != 0))
    {
      this.AUZ = ((int)(System.currentTimeMillis() / 1000L));
      this.tJU = (this.AUZ - this.AUY);
    }
    AppMethodBeat.o(125351);
  }
  
  public final void enG()
  {
    AppMethodBeat.i(125352);
    ac.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
    if (this.AUL == 0L)
    {
      this.AUX = ((int)(System.currentTimeMillis() / 1000L));
      this.AUL = (this.AUX - this.AUV);
    }
    AppMethodBeat.o(125352);
  }
  
  public final drn enH()
  {
    AppMethodBeat.i(125353);
    drn localdrn = new drn();
    localdrn.ndI = 2;
    localdrn.EVM = this.tKd;
    ac.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localdrn.EVM });
    String[] arrayOfString = this.tKd.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = bs.getInt(arrayOfString[8], 0);
      this.AUp = bs.getInt(arrayOfString[10], 0);
      AppMethodBeat.o(125353);
      return localdrn;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.d
 * JD-Core Version:    0.7.0.1
 */