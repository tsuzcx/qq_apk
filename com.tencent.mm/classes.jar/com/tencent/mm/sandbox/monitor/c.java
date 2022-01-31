package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public abstract class c
  implements b
{
  public static final String ykf = com.tencent.mm.compatible.util.e.eQz;
  protected int ykg;
  public int ykh;
  public int yki;
  public String ykj;
  private boolean ykk = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.ykh = paramInt1;
    this.ykj = paramString;
    this.ykg = paramInt2;
    this.ykk = paramBoolean;
    this.yki = com.tencent.mm.a.e.cM(amg());
    paramString = new File(ykf);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    ab.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + amg() + " packOffset = " + this.yki);
  }
  
  public static String Uc(String paramString)
  {
    return cf(paramString, false);
  }
  
  public static boolean aoJ(String paramString)
  {
    return com.tencent.mm.a.e.cN(ykf + paramString + ".temp");
  }
  
  public static String aoK(String paramString)
  {
    paramString = ykf + paramString + ".apk";
    if ((com.tencent.mm.a.e.cN(paramString)) && (a.jdMethod_do(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String cf(String paramString, boolean paramBoolean)
  {
    Object localObject1 = ykf + paramString + ".temp";
    String str3 = ykf + paramString + ".apk";
    if ((com.tencent.mm.a.e.cN((String)localObject1)) && (!paramBoolean) && ((a.jdMethod_do((String)localObject1)) || (paramString.equalsIgnoreCase(g.getMD5((String)localObject1)))))
    {
      com.tencent.mm.a.e.h(ykf, paramString + ".temp", paramString + ".apk");
      return str3;
    }
    if (com.tencent.mm.a.e.cN(str3))
    {
      if (a.jdMethod_do(str3))
      {
        ab.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str3;
      }
      localObject1 = null;
      try
      {
        String str2 = com.tencent.mm.c.c.u(new File(str3));
        str1 = str2;
        localObject1 = str2;
        if (bo.isNullOrNil(str2))
        {
          localObject1 = str2;
          h.qsU.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str2;
          h.qsU.e(11098, new Object[] { Integer.valueOf(4010) });
          str1 = str2;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        for (;;)
        {
          String str1;
          ab.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          h.qsU.idkeyStat(322L, 9L, 1L, false);
          h.qsU.e(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject2 = localObject1;
        }
        paramString = i.drI();
        ab.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject2, paramString });
        if (!localObject2.equals(paramString)) {
          break label389;
        }
        ab.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str3;
        ab.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        h.qsU.idkeyStat(322L, 11L, 1L, false);
        h.qsU.e(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject2 }) });
        ab.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        com.tencent.mm.a.e.deleteFile(str3);
      }
      ab.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { str1 });
      if (bo.isNullOrNil(str1))
      {
        if (!paramString.equalsIgnoreCase(g.getMD5(str3))) {
          break label452;
        }
        ab.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str3;
      }
    }
    label389:
    label452:
    return null;
  }
  
  public String amg()
  {
    return ykf + this.ykj + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      ab.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(amg());
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MM.GetUpdatePack", "error in deleteTempFile");
    }
  }
  
  public String dru()
  {
    return ykf + this.ykj + ".apk";
  }
  
  public final boolean drv()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ykk)
    {
      bool1 = bool2;
      if (!at.isWifi(ah.getContext())) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.c
 * JD-Core Version:    0.7.0.1
 */