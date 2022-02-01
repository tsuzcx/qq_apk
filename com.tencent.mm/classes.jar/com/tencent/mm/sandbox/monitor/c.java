package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sandbox.updater.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.File;

public abstract class c
  implements com.tencent.mm.sandbox.b
{
  public static final String GkW = ;
  protected int GkX;
  public int GkY;
  public int GkZ;
  public String Gla;
  private boolean Glb = false;
  
  public c(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.GkY = paramInt1;
    this.Gla = paramString;
    this.GkX = paramInt2;
    this.Glb = paramBoolean;
    this.GkZ = d.aKc(aKc());
    paramString = new File(GkW);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    ac.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aKc() + " packOffset = " + this.GkZ);
  }
  
  public static boolean aKa(String paramString)
  {
    return d.eA(GkW + paramString + ".temp");
  }
  
  public static String aKb(String paramString)
  {
    paramString = GkW + paramString + ".apk";
    if ((d.eA(paramString)) && (a.eb(paramString))) {
      return paramString;
    }
    return null;
  }
  
  public static String amd(String paramString)
  {
    return cB(paramString, false);
  }
  
  public static String cB(String paramString, boolean paramBoolean)
  {
    Object localObject1 = GkW + paramString + ".temp";
    String str2 = GkW + paramString + ".apk";
    Object localObject2;
    if ((d.eA((String)localObject1)) && (!paramBoolean) && ((a.eb((String)localObject1)) || (paramString.equalsIgnoreCase(d.aKe((String)localObject1)))))
    {
      localObject1 = GkW;
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
    if (d.eA(str2))
    {
      if (a.eb(str2))
      {
        ac.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
        return str2;
      }
      localObject1 = null;
      try
      {
        String str1 = com.tencent.mm.d.c.B(new File(str2));
        localObject2 = str1;
        localObject1 = str1;
        if (bs.isNullOrNil(str1))
        {
          localObject1 = str1;
          h.wUl.idkeyStat(322L, 10L, 1L, false);
          localObject1 = str1;
          h.wUl.f(11098, new Object[] { Integer.valueOf(4010) });
          localObject2 = str1;
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        for (;;)
        {
          ac.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + localException.getMessage());
          h.wUl.idkeyStat(322L, 9L, 1L, false);
          h.wUl.f(11098, new Object[] { Integer.valueOf(4009), localException.getMessage() });
          localObject3 = localObject1;
        }
        paramString = j.eTf();
        ac.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[] { localObject3, paramString });
        if (!localObject3.equals(paramString)) {
          break label468;
        }
        ac.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
        return str2;
        ac.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
        h.wUl.idkeyStat(322L, 11L, 1L, false);
        h.wUl.f(11098, new Object[] { Integer.valueOf(4011), String.format("%s,%s", new Object[] { paramString, localObject3 }) });
        ac.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
        d.deleteFile(str2);
      }
      ac.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[] { localObject2 });
      if (bs.isNullOrNil((String)localObject2))
      {
        if (!paramString.equalsIgnoreCase(d.aKe(str2))) {
          break label531;
        }
        ac.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
        return str2;
      }
    }
    label468:
    return null;
  }
  
  public String aKc()
  {
    return GkW + this.Gla + ".temp";
  }
  
  public final void deleteTempFile()
  {
    try
    {
      ac.d("MM.GetUpdatePack", "deleteTempFile");
      File localFile = new File(aKc());
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MM.GetUpdatePack", "error in deleteTempFile");
    }
  }
  
  public String eSR()
  {
    return GkW + this.Gla + ".apk";
  }
  
  public final boolean eSS()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Glb)
    {
      bool1 = bool2;
      if (!ax.isWifi(ai.getContext())) {
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