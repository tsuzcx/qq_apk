package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.protocal.c.ceq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public static int MOBILE_NETWORK_DISCONNECT = 2;
  public static int qdb = 0;
  public static int qdc = 1;
  public int aYU = 0;
  public int channelStrategy = 1;
  public int cpuFlag0 = m.yR();
  public String deviceModel = "";
  public long lpE = 0L;
  public long lqV = 0L;
  public String lre = "";
  public String lrf = "";
  public int networkType = 0;
  public int pUM = 0;
  public int pUR = 0;
  public int pUS = 0;
  public int pUT = 0;
  public int pUy = 0;
  public int pWh = 0;
  public int qdA = 0;
  public int qdB = 0;
  public long qdC = 0L;
  public int qdD;
  public long qdE = 0L;
  public long qdF = 0L;
  public long qdG = 0L;
  public int qdH;
  public int qdI;
  public int qdJ = -1;
  public int qdK = 0;
  public String qdL = "";
  public String qdM = "";
  public String qdN = "";
  public int qdO = 0;
  public int qdP = 0;
  public int qdQ = 0;
  public int qdR = 0;
  public int qdS = 0;
  public int qdT = 0;
  public int qdd = 0;
  public int qde = 0;
  public int qdf = 0;
  public int qdg = 0;
  public int qdh = 0;
  public int qdi = 0;
  public int qdj = 0;
  public int qdk = 0;
  public int qdl = 0;
  public int qdm = 0;
  public int qdn;
  public int qdo = 0;
  public long qdp = 0L;
  public String qdq = "";
  public int qdr;
  public int qds = 0;
  public int qdt = 0;
  public int qdu = 0;
  public int qdv = 0;
  public int qdw = 0;
  public int qdx = 1;
  public int qdy = 0;
  public int qdz = 0;
  public int videoFps = 0;
  
  public d()
  {
    if (this.qdL.contains(",")) {
      this.qdL = this.qdL.replace(',', ' ');
    }
    this.deviceModel = Build.MODEL;
    if (this.deviceModel.contains(",")) {
      this.deviceModel = this.deviceModel.replace(',', ' ');
    }
    this.qdM = Build.VERSION.SDK;
    if (this.qdM.contains(",")) {
      this.qdM = this.qdM.replace(',', ' ');
    }
    this.qdN = Build.VERSION.RELEASE;
    if (this.qdN.contains(",")) {
      this.qdN = this.qdN.replace(',', ' ');
    }
  }
  
  public static int bST()
  {
    try
    {
      Object localObject = (ConnectivityManager)ae.getContext().getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
        if (localObject == null) {
          return qdb;
        }
        if (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED) {
          return qdc;
        }
        int i = MOBILE_NETWORK_DISCONNECT;
        return i;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
    }
    return qdb;
  }
  
  public static int getNetType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      if (paramContext.getType() != 0) {
        return 0;
      }
      if (paramContext.getSubtype() == 1) {
        return 2;
      }
      if (paramContext.getSubtype() == 2) {
        return 2;
      }
      if (paramContext.getSubtype() == 13) {
        return 4;
      }
      if ((paramContext.getSubtype() < 3) || (paramContext.getSubtype() >= 13))
      {
        int i = paramContext.getSubtype();
        if (i <= 13) {}
      }
      else
      {
        return 3;
      }
      return 2;
    }
    catch (NullPointerException paramContext)
    {
      y.printErrStackTrace("MicroMsg.VoipCSReportHelper", paramContext, "", new Object[0]);
    }
    return 0;
  }
  
  public final void AC(int paramInt)
  {
    this.pUR = Math.abs(paramInt);
  }
  
  public final void bSR()
  {
    y.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
    if ((this.qdS == 0) && (this.qdR != 0))
    {
      this.qdS = ((int)(System.currentTimeMillis() / 1000L));
      this.lqV = (this.qdS - this.qdR);
    }
  }
  
  public final ceq bSS()
  {
    ceq localceq = new ceq();
    localceq.hQR = 2;
    localceq.tTD = this.lre;
    y.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[] { localceq.tTD });
    String[] arrayOfString = this.lre.split(",");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      this.videoFps = bk.getInt(arrayOfString[8], 0);
      this.qdg = bk.getInt(arrayOfString[10], 0);
      return localceq;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
    }
    return localceq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.d
 * JD-Core Version:    0.7.0.1
 */