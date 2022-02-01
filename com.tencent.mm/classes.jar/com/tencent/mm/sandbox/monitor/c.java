package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.updater.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String URM = ;
  protected int URN;
  public int URO;
  public int URP;
  public String URQ;
  private boolean URR = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.URO = paramInt1;
    this.URQ = paramString;
    this.URN = paramInt2;
    this.URR = paramBoolean;
    this.URP = d.bua(brm());
    paramString = new File(URM);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    Log.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + brm() + " packOffset = " + this.URP);
  }
  
  public static String aPB(String paramString)
  {
    return dq(paramString, false);
  }
  
  public static boolean btY(String paramString)
  {
    return d.agG(URM + paramString + ".temp");
  }
  
  public static String btZ(String paramString)
  {
    paramString = URM + paramString + ".apk";
    if ((d.agG(paramString)) && (a.gz(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String dq(String paramString, boolean paramBoolean)
  {
    Object localObject1 = URM + paramString + ".temp";
    String str2 = URM + paramString + ".apk";
    Object localObject2;
    if ((d.agG((String)localObject1)) && (!paramBoolean) && ((a.gz((String)localObject1)) || (paramString.equalsIgnoreCase(d.buc((String)localObject1)))))
    {
      localObject1 = URM;
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
    if (d.agG(str2))
    {
      if (a.gz(str2))
      {
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str2;
      }
      localObject1 = null;
      try
      {
        String str1 = com.tencent.mm.d.c.u(new File(str2));
        localObject2 = str1;
        localObject1 = str1;
        if (Util.isNullOrNil(str1))
        {
          localObject1 = str1;
          h.IzE.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str1;
          h.IzE.a(11098, new Object[] { Integer.valueOf(4010) });
          localObject2 = str1;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        for (;;)
        {
          Log.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          h.IzE.idkeyStat(322L, 9L, 1L, false);
          h.IzE.a(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject3 = localObject1;
        }
        paramString = j.hsl();
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject3, paramString });
        if (!localObject3.equals(paramString)) {
          break label468;
        }
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str2;
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        h.IzE.idkeyStat(322L, 11L, 1L, false);
        h.IzE.a(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject3 }) });
        Log.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        d.deleteFile(str2);
      }
      Log.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { localObject2 });
      if (Util.isNullOrNil((String)localObject2))
      {
        if (!paramString.equalsIgnoreCase(d.buc(str2))) {
          break label531;
        }
        Log.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str2;
      }
    }
    label468:
    return null;
  }
  
  public String brm()
  {
    return URM + this.URQ + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      Log.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(brm());
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
  
  public String hrX()
  {
    return URM + this.URQ + ".apk";
  }
  
  public final boolean hrY()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.URR)
    {
      bool1 = bool2;
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
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