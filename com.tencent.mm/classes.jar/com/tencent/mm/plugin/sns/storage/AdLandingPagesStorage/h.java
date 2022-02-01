package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class h
{
  public static void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(195415);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.fJV();
      AppMethodBeat.o(195415);
      return;
    }
    b(paramString1, paramString2, parama);
    AppMethodBeat.o(195415);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97327);
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, kV(paramString1, paramString2), paramBoolean, paramInt, 0, parama);
    AppMethodBeat.o(97327);
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean, f.a parama)
  {
    AppMethodBeat.i(195412);
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, kU(paramString1, paramString2), paramBoolean, 41, 0, parama);
    AppMethodBeat.o(195412);
  }
  
  public static void a(String paramString, boolean paramBoolean, f.a parama)
  {
    AppMethodBeat.i(195409);
    a("adId", paramString, paramBoolean, parama);
    AppMethodBeat.o(195409);
  }
  
  public static void b(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(97326);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.fJV();
      AppMethodBeat.o(97326);
      return;
    }
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, fSq(), kX(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void c(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(195425);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.fJV();
      AppMethodBeat.o(195425);
      return;
    }
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, fSq(), kY(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(195425);
  }
  
  public static String fSq()
  {
    AppMethodBeat.i(97328);
    String str = b.aSL() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String kU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = fSq() + kX(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
  
  public static String kV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    u.bBD(fSq());
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = fSq() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  public static String kW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195402);
    String str = fSq();
    u.bBD(str);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = str + paramString1 + "_pag_" + paramString2;
    AppMethodBeat.o(195402);
    return paramString1;
  }
  
  public static String kX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String kY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195406);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(195406);
    return paramString1;
  }
  
  public static Bitmap kZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = kU(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (u.agG(paramString1)))
      {
        paramString1 = BitmapUtil.decodeFile(paramString1);
        AppMethodBeat.o(97321);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(97321);
    }
    return null;
  }
  
  public static String mA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292722);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(292722);
      return "";
    }
    try
    {
      paramString1 = kU(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        boolean bool = u.agG(paramString1);
        if (bool)
        {
          AppMethodBeat.o(292722);
          return paramString1;
        }
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(292722);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */