package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.updater.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String HWI = ;
  protected int HWJ;
  public int HWK;
  public int HWL;
  public String HWM;
  private boolean HWN = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.HWK = paramInt1;
    this.HWM = paramString;
    this.HWJ = paramInt2;
    this.HWN = paramBoolean;
    this.HWL = d.aPI(aNl());
    paramString = new File(HWI);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    ad.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aNl() + " packOffset = " + this.HWL);
  }
  
  public static boolean aPG(String paramString)
  {
    return d.fv(HWI + paramString + ".temp");
  }
  
  public static String aPH(String paramString)
  {
    paramString = HWI + paramString + ".apk";
    if ((d.fv(paramString)) && (a.eW(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String aqS(String paramString)
  {
    return cG(paramString, false);
  }
  
  public static String cG(String paramString, boolean paramBoolean)
  {
    Object localObject1 = HWI + paramString + ".temp";
    String str2 = HWI + paramString + ".apk";
    Object localObject2;
    if ((d.fv((String)localObject1)) && (!paramBoolean) && ((a.eW((String)localObject1)) || (paramString.equalsIgnoreCase(d.aPK((String)localObject1)))))
    {
      localObject1 = HWI;
      localObject2 = paramString + ".temp";
      paramString = paramString + ".apk";
      if ((localObject1 == null) || (localObject2 == null) || (paramString == null)) {}
      for (;;)
      {
        return str2;
        localObject2 = new File((String)localObject1 + (String)localObject2);
        paramString = new File((String)localObject1 + paramString);
        if (((File)localObject2).exists()) {
          ((File)localObject2).renameTo(paramString);
        }
      }
    }
    if (d.fv(str2))
    {
      if (a.eW(str2))
      {
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str2;
      }
      localObject1 = null;
      try
      {
        String str1 = com.tencent.mm.d.c.B(new File(str2));
        localObject2 = str1;
        localObject1 = str1;
        if (bt.isNullOrNil(str1))
        {
          localObject1 = str1;
          g.yhR.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str1;
          g.yhR.f(11098, new Object[] { Integer.valueOf(4010) });
          localObject2 = str1;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        for (;;)
        {
          ad.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          g.yhR.idkeyStat(322L, 9L, 1L, false);
          g.yhR.f(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject3 = localObject1;
        }
        paramString = j.fiH();
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject3, paramString });
        if (!localObject3.equals(paramString)) {
          break label468;
        }
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str2;
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        g.yhR.idkeyStat(322L, 11L, 1L, false);
        g.yhR.f(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject3 }) });
        ad.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        d.deleteFile(str2);
      }
      ad.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { localObject2 });
      if (bt.isNullOrNil((String)localObject2))
      {
        if (!paramString.equalsIgnoreCase(d.aPK(str2))) {
          break label531;
        }
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str2;
      }
    }
    label468:
    return null;
  }
  
  public String aNl()
  {
    return HWI + this.HWM + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      ad.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(aNl());
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MM.GetUpdatePack", "error in deleteTempFile");
    }
  }
  
  public String fit()
  {
    return HWI + this.HWM + ".apk";
  }
  
  public final boolean fiu()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.HWN)
    {
      bool1 = bool2;
      if (!ay.isWifi(aj.getContext())) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.c
 * JD-Core Version:    0.7.0.1
 */