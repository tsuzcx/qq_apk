package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String acmY = ;
  protected int acmZ;
  public int acna;
  public int acnb;
  public String acnc;
  private boolean acnd = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.acna = paramInt1;
    this.acnc = paramString;
    this.acmZ = paramInt2;
    this.acnd = paramBoolean;
    this.acnb = d.btZ(bOS());
    paramString = new File(acmY);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    Log.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + bOS() + " packOffset = " + this.acnb);
  }
  
  public static String aMz(String paramString)
  {
    return ea(paramString, false);
  }
  
  public static boolean btX(String paramString)
  {
    return d.ZC(acmY + paramString + ".temp");
  }
  
  public static String btY(String paramString)
  {
    paramString = acmY + paramString + ".apk";
    if ((d.ZC(paramString)) && (a.hZ(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String ea(String paramString, boolean paramBoolean)
  {
    String str1 = acmY + paramString + ".temp";
    String str2 = acmY + paramString + ".apk";
    Object localObject1;
    if ((d.ZC(str1)) && (!paramBoolean) && ((a.hZ(str1)) || (paramString.equalsIgnoreCase(d.bub(str1)))))
    {
      str1 = acmY;
      localObject1 = paramString + ".temp";
      paramString = paramString + ".apk";
      if ((str1 == null) || (localObject1 == null) || (paramString == null)) {}
      for (;;)
      {
        return str2;
        localObject1 = new File(str1 + (String)localObject1);
        paramString = new File(str1 + paramString);
        if (((File)localObject1).exists()) {
          ((File)localObject1).renameTo(paramString);
        }
      }
    }
    Object localObject2;
    if (d.ZC(str2))
    {
      if (a.hZ(str2))
      {
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str2;
      }
      localObject2 = null;
      str1 = null;
      localObject1 = localObject2;
      try
      {
        if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion <= 29)
        {
          localObject1 = localObject2;
          str1 = com.tencent.mm.d.c.z(new File(str2));
        }
        localObject2 = str1;
        localObject1 = str1;
        if (Util.isNullOrNil(str1))
        {
          localObject1 = str1;
          h.OAn.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str1;
          h.OAn.b(11098, new Object[] { Integer.valueOf(4010) });
          localObject2 = str1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          h.OAn.idkeyStat(322L, 9L, 1L, false);
          h.OAn.b(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject2 = localObject1;
        }
        paramString = i.iSq();
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject2, paramString });
        if (!((String)localObject2).equals(paramString)) {
          break label491;
        }
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str2;
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        h.OAn.idkeyStat(322L, 11L, 1L, false);
        h.OAn.b(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject2 }) });
        Log.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        d.deleteFile(str2);
      }
      Log.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { localObject2 });
      if (Util.isNullOrNil((String)localObject2))
      {
        if (!paramString.equalsIgnoreCase(d.bub(str2))) {
          break label555;
        }
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str2;
      }
    }
    label491:
    return null;
  }
  
  public String bOS()
  {
    return acmY + this.acnc + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      Log.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(bOS());
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MM.GetUpdatePack", "error in deleteTempFile");
    }
  }
  
  public String iSd()
  {
    return acmY + this.acnc + ".apk";
  }
  
  public final boolean iSe()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.acnd)
    {
      bool1 = bool2;
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.c
 * JD-Core Version:    0.7.0.1
 */