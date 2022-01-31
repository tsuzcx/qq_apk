package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class h
{
  public static void a(String paramString, int paramInt, f.a parama)
  {
    AppMethodBeat.i(37725);
    c("adId", paramString, false, paramInt, parama);
    AppMethodBeat.o(37725);
  }
  
  public static void a(String paramString, f.a parama)
  {
    AppMethodBeat.i(37726);
    b("adId", paramString, false, 41, parama);
    AppMethodBeat.o(37726);
  }
  
  private static void a(String paramString1, String paramString2, f.a parama)
  {
    AppMethodBeat.i(37729);
    if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString1)))
    {
      parama.coe();
      AppMethodBeat.o(37729);
      return;
    }
    ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download new img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, crV(), gA(paramString1, paramString2), parama);
    AppMethodBeat.o(37729);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(37727);
    ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download img for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, gy(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(37727);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(37728);
    if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString1)))
    {
      parama.coe();
      AppMethodBeat.o(37728);
      return;
    }
    if (AdLandingPagesProxy.getInstance().isUseSnsDownloadImage())
    {
      a(paramString1, paramString2, parama);
      AppMethodBeat.o(37728);
      return;
    }
    b(paramString1, paramString2, paramBoolean, paramInt, parama);
    AppMethodBeat.o(37728);
  }
  
  public static String crV()
  {
    AppMethodBeat.i(37731);
    String str = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/";
    AppMethodBeat.o(37731);
    return str;
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    AppMethodBeat.i(37730);
    ab.i("MicroMsg.AdLandingPagesDownloadResourceHelper", "start download sight for " + paramString2 + " for adid:" + paramString1);
    e.a(paramString2, gz(paramString1, paramString2), paramBoolean, paramInt, parama);
    AppMethodBeat.o(37730);
  }
  
  private static String gA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37723);
    paramString2 = ag.cE(paramString2);
    paramString1 = paramString1 + "_img_" + paramString2;
    AppMethodBeat.o(37723);
    return paramString1;
  }
  
  public static Bitmap gB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37724);
    if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(37724);
      return null;
    }
    try
    {
      paramString1 = gy(paramString1, paramString2);
      if ((!TextUtils.isEmpty(paramString1)) && (com.tencent.mm.vfs.e.cN(paramString1)))
      {
        paramString1 = MMBitmapFactory.decodeFile(paramString1);
        AppMethodBeat.o(37724);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.AdLandingPagesDownloadResourceHelper", "%s", new Object[] { bo.l(paramString1) });
      AppMethodBeat.o(37724);
    }
    return null;
  }
  
  public static String gy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37721);
    paramString1 = crV() + gA(paramString1, paramString2);
    AppMethodBeat.o(37721);
    return paramString1;
  }
  
  public static String gz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37722);
    com.tencent.mm.vfs.e.um(crV());
    paramString2 = ag.cE(paramString2);
    paramString1 = crV() + paramString1 + "_sight_" + paramString2;
    AppMethodBeat.o(37722);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h
 * JD-Core Version:    0.7.0.1
 */