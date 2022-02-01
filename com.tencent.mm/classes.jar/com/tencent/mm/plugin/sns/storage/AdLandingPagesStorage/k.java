package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class k
{
  public static void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, g.a parama)
  {
    AppMethodBeat.i(97327);
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + paramString2 + ", adId=" + paramString1);
    f.a(paramString2, mD(paramString1, paramString2), paramBoolean, paramInt, 0, parama);
    AppMethodBeat.o(97327);
  }
  
  private static void a(String paramString1, String paramString2, boolean paramBoolean, g.a parama)
  {
    AppMethodBeat.i(306757);
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    f.a(paramString2, mC(paramString1, paramString2), paramBoolean, 41, 0, parama);
    AppMethodBeat.o(306757);
  }
  
  public static void a(String paramString, boolean paramBoolean, g.a parama)
  {
    AppMethodBeat.i(306753);
    a("adId", paramString, paramBoolean, parama);
    AppMethodBeat.o(306753);
  }
  
  public static String aZH(String paramString)
  {
    AppMethodBeat.i(306737);
    paramString = hkC() + mF("adId", paramString);
    AppMethodBeat.o(306737);
    return paramString;
  }
  
  public static void b(String paramString1, String paramString2, g.a parama)
  {
    AppMethodBeat.i(306758);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.gZN();
      AppMethodBeat.o(306758);
      return;
    }
    c(paramString1, paramString2, parama);
    AppMethodBeat.o(306758);
  }
  
  public static void c(String paramString1, String paramString2, g.a parama)
  {
    AppMethodBeat.i(97326);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.gZN();
      AppMethodBeat.o(97326);
      return;
    }
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    f.a(paramString2, hkC(), mF(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void d(String paramString1, String paramString2, g.a parama)
  {
    AppMethodBeat.i(306763);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.gZN();
      AppMethodBeat.o(306763);
      return;
    }
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    f.a(paramString2, hkC(), mG(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(306763);
  }
  
  public static String hkC()
  {
    AppMethodBeat.i(97328);
    String str = b.bmz() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String mC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = hkC() + mF(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
  
  public static String mD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    y.bDX(hkC());
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = hkC() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  public static String mE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306741);
    String str = hkC();
    y.bDX(str);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = str + paramString1 + "_pag_" + paramString2;
    AppMethodBeat.o(306741);
    return paramString1;
  }
  
  public static String mF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String mG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306749);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(306749);
    return paramString1;
  }
  
  public static Bitmap mH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = mC(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (y.ZC(paramString1)))
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
  
  public static String mI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306752);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(306752);
      return "";
    }
    try
    {
      paramString1 = mC(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        boolean bool = y.ZC(paramString1);
        if (bool)
        {
          AppMethodBeat.o(306752);
          return paramString1;
        }
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(306752);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k
 * JD-Core Version:    0.7.0.1
 */