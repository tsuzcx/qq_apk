package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
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
  
  public static void a(String paramString, f.a parama)
  {
    AppMethodBeat.i(97323);
    b("adId", paramString, false, 41, parama);
    AppMethodBeat.o(97323);
  }
  
  private static void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(97326);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      parama.dsA();
      AppMethodBeat.o(97326);
      return;
    }
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, dxm(), iW(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void b(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(187511);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      parama.dsA();
      AppMethodBeat.o(187511);
      return;
    }
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, dxm(), iX(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(187511);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97324);
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, iU(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97324);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97325);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      parama.dsA();
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
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, iV(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97327);
  }
  
  public static String dxm()
  {
    AppMethodBeat.i(97328);
    String str = b.aih() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = dxm() + iW(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
  
  public static String iV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    i.aMF(dxm());
    paramString2 = ai.du(paramString2);
    paramString1 = dxm() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  private static String iW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = ai.du(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String iX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187510);
    paramString2 = ai.du(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(187510);
    return paramString1;
  }
  
  public static Bitmap iY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = iU(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (i.eK(paramString1)))
      {
        paramString1 = f.decodeFile(paramString1);
        AppMethodBeat.o(97321);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { bt.m(paramString1) });
      AppMethodBeat.o(97321);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */