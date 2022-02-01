package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
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
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      parama.dRX();
      AppMethodBeat.o(97326);
      return;
    }
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, dYb(), jH(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void a(String paramString, boolean paramBoolean, f.a parama)
  {
    AppMethodBeat.i(198110);
    b("adId", paramString, paramBoolean, 41, parama);
    AppMethodBeat.o(198110);
  }
  
  public static void b(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(198111);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      parama.dRX();
      AppMethodBeat.o(198111);
      return;
    }
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, dYb(), jI(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(198111);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97324);
    ad.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, jF(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97324);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97325);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      parama.dRX();
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
    e.a(paramString2, jG(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97327);
  }
  
  public static String dYb()
  {
    AppMethodBeat.i(97328);
    String str = b.arU() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String jF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = dYb() + jH(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
  
  public static String jG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    i.aYg(dYb());
    paramString2 = ai.ee(paramString2);
    paramString1 = dYb() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  private static String jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = ai.ee(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String jI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198109);
    paramString2 = ai.ee(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(198109);
    return paramString1;
  }
  
  public static Bitmap jJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = jF(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (i.fv(paramString1)))
      {
        paramString1 = g.decodeFile(paramString1);
        AppMethodBeat.o(97321);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { bt.n(paramString1) });
      AppMethodBeat.o(97321);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */