package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public abstract class c
  implements b
{
  public static final String ubQ = com.tencent.mm.compatible.util.e.bkH;
  public int ubR;
  public int ubS;
  public int ubT;
  public String ubU;
  private boolean ubV = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.ubS = paramInt1;
    this.ubU = paramString;
    this.ubR = paramInt2;
    this.ubV = paramBoolean;
    this.ubT = com.tencent.mm.a.e.bJ(SV());
    paramString = new File(ubQ);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    y.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + SV() + " packOffset = " + this.ubT);
  }
  
  public static String Iq(String paramString)
  {
    return bD(paramString, false);
  }
  
  public static boolean YL(String paramString)
  {
    return com.tencent.mm.a.e.bK(ubQ + paramString + ".temp");
  }
  
  public static String YM(String paramString)
  {
    paramString = ubQ + paramString + ".apk";
    if ((com.tencent.mm.a.e.bK(paramString)) && (a.cd(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String bD(String paramString, boolean paramBoolean)
  {
    Object localObject1 = ubQ + paramString + ".temp";
    String str3 = ubQ + paramString + ".apk";
    if ((com.tencent.mm.a.e.bK((String)localObject1)) && (!paramBoolean) && ((a.cd((String)localObject1)) || (paramString.equalsIgnoreCase(g.bQ((String)localObject1)))))
    {
      com.tencent.mm.a.e.f(ubQ, paramString + ".temp", paramString + ".apk");
      return str3;
    }
    if (com.tencent.mm.a.e.bK(str3))
    {
      if (a.cd(str3))
      {
        y.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str3;
      }
      localObject1 = null;
      try
      {
        String str2 = com.tencent.mm.c.c.p(new File(str3));
        str1 = str2;
        localObject1 = str2;
        if (bk.bl(str2))
        {
          localObject1 = str2;
          h.nFQ.a(322L, 10L, 1L, false);
          localObject1 = str2;
          h.nFQ.f(11098, new Object[] { Integer.valueOf(4010) });
          str1 = str2;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        for (;;)
        {
          String str1;
          y.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          h.nFQ.a(322L, 9L, 1L, false);
          h.nFQ.f(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject2 = localObject1;
        }
        paramString = i.cpS();
        y.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject2, paramString });
        if (!localObject2.equals(paramString)) {
          break label389;
        }
        y.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str3;
        y.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        h.nFQ.a(322L, 11L, 1L, false);
        h.nFQ.f(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject2 }) });
        y.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        com.tencent.mm.a.e.deleteFile(str3);
      }
      y.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { str1 });
      if (bk.bl(str1))
      {
        if (!paramString.equalsIgnoreCase(g.bQ(str3))) {
          break label452;
        }
        y.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str3;
      }
    }
    label389:
    label452:
    return null;
  }
  
  public String SV()
  {
    return ubQ + this.ubU + ".temp";
  }
  
  public String cpF()
  {
    return ubQ + this.ubU + ".apk";
  }
  
  public final boolean cpG()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ubV)
    {
      bool1 = bool2;
      if (!aq.isWifi(ae.getContext())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void deleteTempFile()
  {
    try
    {
      y.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(SV());
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MM.GetUpdatePack", "error in deleteTempFile");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.c
 * JD-Core Version:    0.7.0.1
 */