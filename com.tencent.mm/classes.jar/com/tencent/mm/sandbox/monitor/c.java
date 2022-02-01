package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.updater.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String IqQ = ;
  protected int IqR;
  public int IqS;
  public int IqT;
  public String IqU;
  private boolean IqV = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.IqS = paramInt1;
    this.IqU = paramString;
    this.IqR = paramInt2;
    this.IqV = paramBoolean;
    this.IqT = d.aRf(aNJ());
    paramString = new File(IqQ);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    ae.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aNJ() + " packOffset = " + this.IqT);
  }
  
  public static boolean aRd(String paramString)
  {
    return d.fB(IqQ + paramString + ".temp");
  }
  
  public static String aRe(String paramString)
  {
    paramString = IqQ + paramString + ".apk";
    if ((d.fB(paramString)) && (a.fb(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String arX(String paramString)
  {
    return cK(paramString, false);
  }
  
  public static String cK(String paramString, boolean paramBoolean)
  {
    Object localObject1 = IqQ + paramString + ".temp";
    String str2 = IqQ + paramString + ".apk";
    Object localObject2;
    if ((d.fB((String)localObject1)) && (!paramBoolean) && ((a.fb((String)localObject1)) || (paramString.equalsIgnoreCase(d.aRh((String)localObject1)))))
    {
      localObject1 = IqQ;
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
    if (d.fB(str2))
    {
      if (a.fb(str2))
      {
        ae.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str2;
      }
      localObject1 = null;
      try
      {
        String str1 = com.tencent.mm.d.c.B(new File(str2));
        localObject2 = str1;
        localObject1 = str1;
        if (bu.isNullOrNil(str1))
        {
          localObject1 = str1;
          g.yxI.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str1;
          g.yxI.f(11098, new Object[] { Integer.valueOf(4010) });
          localObject2 = str1;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        for (;;)
        {
          ae.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          g.yxI.idkeyStat(322L, 9L, 1L, false);
          g.yxI.f(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject3 = localObject1;
        }
        paramString = j.fmz();
        ae.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject3, paramString });
        if (!localObject3.equals(paramString)) {
          break label468;
        }
        ae.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str2;
        ae.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        g.yxI.idkeyStat(322L, 11L, 1L, false);
        g.yxI.f(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject3 }) });
        ae.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        d.deleteFile(str2);
      }
      ae.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { localObject2 });
      if (bu.isNullOrNil((String)localObject2))
      {
        if (!paramString.equalsIgnoreCase(d.aRh(str2))) {
          break label531;
        }
        ae.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str2;
      }
    }
    label468:
    return null;
  }
  
  public String aNJ()
  {
    return IqQ + this.IqU + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      ae.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(aNJ());
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MM.GetUpdatePack", "error in deleteTempFile");
    }
  }
  
  public String fml()
  {
    return IqQ + this.IqU + ".apk";
  }
  
  public final boolean fmm()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.IqV)
    {
      bool1 = bool2;
      if (!az.isWifi(ak.getContext())) {
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