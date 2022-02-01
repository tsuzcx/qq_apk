package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;

public final class h
{
  public static void a(String paramString, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97322);
    c("adId", paramString, false, paramInt, parama);
    AppMethodBeat.o(97322);
  }
  
  private static void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(97326);
    if ((bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString1)))
    {
      parama.dFD();
      AppMethodBeat.o(97326);
      return;
    }
    ac.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, dLL(), ju(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void a(String paramString, boolean paramBoolean, f.a parama)
  {
    AppMethodBeat.i(200316);
    b("adId", paramString, paramBoolean, 41, parama);
    AppMethodBeat.o(200316);
  }
  
  public static void b(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(200317);
    if ((bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString1)))
    {
      parama.dFD();
      AppMethodBeat.o(200317);
      return;
    }
    ac.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, dLL(), jv(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(200317);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97324);
    ac.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, js(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97324);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97325);
    if ((bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString1)))
    {
      parama.dFD();
      AppMethodBeat.o(97325);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isUseSnsDownloadImage())
    {
      a(paramString1, paramString2, parama);
      AppMethodBeat.o(97325);
      return;
    }
    b(paramString1, paramString2, paramBoolean, paramInt, parama);
    AppMethodBeat.o(97325);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97327);
    ac.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, jt(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97327);
  }
  
  public static String dLL()
  {
    AppMethodBeat.i(97328);
    String str = b.aph() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String js(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = dLL() + ju(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
  
  public static String jt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    i.aSh(dLL());
    paramString2 = ah.dg(paramString2);
    paramString1 = dLL() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  private static String ju(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = ah.dg(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200315);
    paramString2 = ah.dg(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(200315);
    return paramString1;
  }
  
  public static Bitmap jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = js(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (i.eA(paramString1)))
      {
        paramString1 = f.decodeFile(paramString1);
        AppMethodBeat.o(97321);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { bs.m(paramString1) });
      AppMethodBeat.o(97321);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */