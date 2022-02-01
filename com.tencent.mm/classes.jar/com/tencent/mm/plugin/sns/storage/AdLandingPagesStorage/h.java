package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class h
{
  public static void a(String paramString, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97322);
    a("adId", paramString, false, paramInt, parama);
    AppMethodBeat.o(97322);
  }
  
  private static void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(97326);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.eWO();
      AppMethodBeat.o(97326);
      return;
    }
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, few(), kB(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97325);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.eWO();
      AppMethodBeat.o(97325);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isUseSnsDownloadImage())
    {
      a(paramString1, paramString2, parama);
      AppMethodBeat.o(97325);
      return;
    }
    b(paramString1, paramString2, paramBoolean, paramInt, 0, parama);
    AppMethodBeat.o(97325);
  }
  
  public static void a(String paramString, boolean paramBoolean, f.a parama)
  {
    AppMethodBeat.i(203156);
    b("adId", paramString, paramBoolean, 41, 0, parama);
    AppMethodBeat.o(203156);
  }
  
  public static void b(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(203158);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      parama.eWO();
      AppMethodBeat.o(203158);
      return;
    }
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, few(), kC(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(203158);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, f.a parama)
  {
    AppMethodBeat.i(203157);
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, kz(paramString1, paramString2), paramBoolean, paramInt1, 0, parama);
    AppMethodBeat.o(203157);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97327);
    Log.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, kA(paramString1, paramString2), paramBoolean, paramInt, 0, parama);
    AppMethodBeat.o(97327);
  }
  
  public static String few()
  {
    AppMethodBeat.i(97328);
    String str = b.aKJ() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String kA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    s.boN(few());
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = few() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  private static String kB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203155);
    paramString2 = MD5Util.getMD5String(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(203155);
    return paramString1;
  }
  
  public static Bitmap kD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = kz(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (s.YS(paramString1)))
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
  
  public static String kz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = few() + kB(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */