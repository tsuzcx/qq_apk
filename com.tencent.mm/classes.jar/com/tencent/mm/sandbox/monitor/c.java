package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.updater.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String ENJ = ;
  protected int ENK;
  public int ENL;
  public int ENM;
  public String ENN;
  private boolean ENO = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.ENL = paramInt1;
    this.ENN = paramString;
    this.ENK = paramInt2;
    this.ENO = paramBoolean;
    this.ENM = d.aEL(aDl());
    paramString = new File(ENJ);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    ad.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aDl() + " packOffset = " + this.ENM);
  }
  
  public static boolean aEJ(String paramString)
  {
    return d.eK(ENJ + paramString + ".temp");
  }
  
  public static String aEK(String paramString)
  {
    paramString = ENJ + paramString + ".apk";
    if ((d.eK(paramString)) && (a.em(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String ahi(String paramString)
  {
    return cv(paramString, false);
  }
  
  public static String cv(String paramString, boolean paramBoolean)
  {
    Object localObject1 = ENJ + paramString + ".temp";
    String str2 = ENJ + paramString + ".apk";
    Object localObject2;
    if ((d.eK((String)localObject1)) && (!paramBoolean) && ((a.em((String)localObject1)) || (paramString.equalsIgnoreCase(d.aEN((String)localObject1)))))
    {
      localObject1 = ENJ;
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
    if (d.eK(str2))
    {
      if (a.em(str2))
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
          h.vKh.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str1;
          h.vKh.f(11098, new Object[] { Integer.valueOf(4010) });
          localObject2 = str1;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        for (;;)
        {
          ad.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          h.vKh.idkeyStat(322L, 9L, 1L, false);
          h.vKh.f(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject3 = localObject1;
        }
        paramString = j.eDL();
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject3, paramString });
        if (!localObject3.equals(paramString)) {
          break label468;
        }
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str2;
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        h.vKh.idkeyStat(322L, 11L, 1L, false);
        h.vKh.f(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject3 }) });
        ad.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        d.deleteFile(str2);
      }
      ad.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { localObject2 });
      if (bt.isNullOrNil((String)localObject2))
      {
        if (!paramString.equalsIgnoreCase(d.aEN(str2))) {
          break label531;
        }
        ad.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str2;
      }
    }
    label468:
    return null;
  }
  
  public String aDl()
  {
    return ENJ + this.ENN + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      ad.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(aDl());
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
  
  public String eDx()
  {
    return ENJ + this.ENN + ".apk";
  }
  
  public final boolean eDy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ENO)
    {
      bool1 = bool2;
      if (!ay.isWifi(aj.getContext())) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.c
 * JD-Core Version:    0.7.0.1
 */