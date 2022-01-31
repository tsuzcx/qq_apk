package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class h
{
  public static void a(String paramString, int paramInt, f.a parama)
  {
    c("adId", paramString, false, paramInt, parama);
  }
  
  public static void a(String paramString, f.a parama)
  {
    b("adId", paramString, false, 41, parama);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, c.a parama)
  {
    if ((bk.bl(paramString2)) || (bk.bl(paramString1)))
    {
      parama.uv("the res or adId is null");
      return;
    }
    y.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download video for " + paramString2 + " for adid:" + paramString1);
    String str1 = bFT();
    String str2 = ad.bB(paramString2);
    paramString1 = paramString1 + "_stream_" + str2;
    str2 = str1 + paramString1;
    if (!bk.bl(str2))
    {
      if (com.tencent.mm.vfs.e.bK(str2))
      {
        y.i("MicroMsg.AdLandingPageDownloadFileHelper", "big file %s is already exists", new Object[] { str2 });
        ai.d(new e.4(parama, str2));
        return;
      }
      new c(str1, paramString1, paramBoolean, paramInt, new e.5(parama, paramString2)).execute(new Void[0]);
      return;
    }
    ai.d(new e.6(parama));
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    y.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, eS(paramString1, paramString2), paramBoolean, paramInt, parama);
  }
  
  private static String bFT()
  {
    return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/";
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    if ((bk.bl(paramString2)) || (bk.bl(paramString1))) {
      parama.bCF();
    }
    String str1;
    String str2;
    do
    {
      return;
      if (!AdLandingPagesProxy.getInstance().isUseSnsDownloadImage()) {
        break;
      }
      if ((bk.bl(paramString2)) || (bk.bl(paramString1)))
      {
        parama.bCF();
        return;
      }
      y.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
      str1 = bFT();
      paramString1 = eU(paramString1, paramString2);
      str2 = str1 + paramString1;
    } while (bk.bl(str2));
    if (com.tencent.mm.vfs.e.bK(str2))
    {
      y.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", new Object[] { str2 });
      ai.d(new e.7(parama, str2));
      return;
    }
    new d(paramString2, str1, paramString1, new e.8(parama, paramString2, str2)).execute(new Void[0]);
    return;
    b(paramString1, paramString2, paramBoolean, paramInt, parama);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    y.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download sight for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, eT(paramString1, paramString2), paramBoolean, paramInt, parama);
  }
  
  public static String eS(String paramString1, String paramString2)
  {
    return bFT() + eU(paramString1, paramString2);
  }
  
  public static String eT(String paramString1, String paramString2)
  {
    com.tencent.mm.vfs.e.nb(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
    paramString2 = ad.bB(paramString2);
    return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + paramString1 + "_sight_" + paramString2;
  }
  
  private static String eU(String paramString1, String paramString2)
  {
    paramString2 = ad.bB(paramString2);
    return paramString1 + "_img_" + paramString2;
  }
  
  public static Bitmap eV(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString2)) || (bk.bl(paramString1))) {}
    for (;;)
    {
      return null;
      try
      {
        paramString1 = eS(paramString1, paramString2);
        if ((!TextUtils.isEmpty(paramString1)) && (com.tencent.mm.vfs.e.bK(paramString1)))
        {
          paramString1 = MMBitmapFactory.decodeFile(paramString1);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { bk.j(paramString1) });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */