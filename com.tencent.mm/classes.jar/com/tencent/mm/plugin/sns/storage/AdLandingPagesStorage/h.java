package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

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
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString1)))
    {
      parama.dVv();
      AppMethodBeat.o(97326);
      return;
    }
    ae.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, ebF(), jN(paramString1, paramString2), 0, parama);
    AppMethodBeat.o(97326);
  }
  
  public static void a(String paramString, boolean paramBoolean, f.a parama)
  {
    AppMethodBeat.i(219624);
    b("adId", paramString, paramBoolean, 41, parama);
    AppMethodBeat.o(219624);
  }
  
  public static void b(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(219625);
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString1)))
    {
      parama.dVv();
      AppMethodBeat.o(219625);
      return;
    }
    ae.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPagesByCdn, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, ebF(), jO(paramString1, paramString2), 1, parama);
    AppMethodBeat.o(219625);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97324);
    ae.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, jL(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97324);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(97325);
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString1)))
    {
      parama.dVv();
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
    ae.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "downloadSightForAdLandingPages, url=" + paramString2 + ", adId=" + paramString1);
    e.a(paramString2, jM(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(97327);
  }
  
  public static String ebF()
  {
    AppMethodBeat.i(97328);
    String str = b.asj() + "sns_ad_landingpages/";
    AppMethodBeat.o(97328);
    return str;
  }
  
  public static String jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97318);
    paramString1 = ebF() + jN(paramString1, paramString2);
    AppMethodBeat.o(97318);
    return paramString1;
  }
  
  public static String jM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97319);
    o.aZI(ebF());
    paramString2 = aj.ej(paramString2);
    paramString1 = ebF() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(97319);
    return paramString1;
  }
  
  private static String jN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97320);
    paramString2 = aj.ej(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(97320);
    return paramString1;
  }
  
  private static String jO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219623);
    paramString2 = aj.ej(paramString2);
    paramString1 = paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(219623);
    return paramString1;
  }
  
  public static Bitmap jP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97321);
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(97321);
      return null;
    }
    try
    {
      paramString1 = jL(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (o.fB(paramString1)))
      {
        paramString1 = com.tencent.mm.sdk.platformtools.h.decodeFile(paramString1);
        AppMethodBeat.o(97321);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { bu.o(paramString1) });
      AppMethodBeat.o(97321);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */