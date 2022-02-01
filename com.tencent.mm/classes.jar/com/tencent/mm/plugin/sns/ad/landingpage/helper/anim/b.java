package com.tencent.mm.plugin.sns.ad.landingpage.helper.anim;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.e;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import java.net.URL;
import java.util.ArrayList;

public final class b
{
  private static boolean a(String paramString1, String paramString2, e parame, Boolean paramBoolean)
  {
    AppMethodBeat.i(310914);
    try
    {
      String str1 = MD5Util.getMD5String(paramString1);
      Log.i("AdLandingPagePagFileHelper", "attachTaskInfo, mediaId=" + str1 + ", fileUrl=" + paramString1);
      String str2 = new URL(paramString1).getHost();
      int i = d.a(str2, false, new ArrayList());
      int j = d.a(str2, true, new ArrayList());
      parame.field_mediaId = str1;
      parame.url = paramString1;
      parame.host = str2;
      parame.lwD = paramString2;
      parame.lwG = i;
      parame.lwH = j;
      parame.isColdSnsData = paramBoolean.booleanValue();
      parame.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength();
      parame.snsScene = "";
      parame.appType = 150;
      parame.fileType = 20201;
      AppMethodBeat.o(310914);
      return true;
    }
    catch (Exception paramString1)
    {
      Log.e("AdLandingPagePagFileHelper", "attachTaskInfo, exp=" + paramString1.toString());
      AppMethodBeat.o(310914);
    }
    return false;
  }
  
  public static void downloadPagFile(String paramString)
  {
    AppMethodBeat.i(310904);
    Log.i("AdLandingPagePagFileHelper", "downloadPagFile, url=".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(310904);
      return;
    }
    e locale = new e();
    locale.taskName = "task_SnsAdFileDownloader";
    String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mE("adId", paramString);
    y.deleteFile(str);
    if (a(paramString, str, locale, Boolean.FALSE))
    {
      locale.lwL = new b.1();
      if (com.tencent.mm.modelcdntran.k.bHW().b(locale, -1))
      {
        Log.i("AdLandingPagePagFileHelper", "downloadPagFile, addRecvTask suc");
        AppMethodBeat.o(310904);
        return;
      }
      Log.w("AdLandingPagePagFileHelper", "downloadPagFile, addRecvTask failed");
      AppMethodBeat.o(310904);
      return;
    }
    Log.w("AdLandingPagePagFileHelper", "downloadPagFile, attachTaskInfo failed");
    AppMethodBeat.o(310904);
  }
  
  public static String lN(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(310896);
    label214:
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          Log.w("AdLandingPagePagFileHelper", "findLocalPagFile, url empty");
          AppMethodBeat.o(310896);
          return "";
        }
        String str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mE("adId", paramString1);
        if (y.ZC(str))
        {
          if (y.ZC(str))
          {
            if (TextUtils.isEmpty(paramString2))
            {
              if (i != 0)
              {
                Log.i("AdLandingPagePagFileHelper", "findLocalPagFile, succ, url=" + paramString1 + ", path=" + str + ", md5=" + paramString2);
                AppMethodBeat.o(310896);
                return str;
              }
            }
            else
            {
              if (paramString2.equals(y.bub(str))) {
                continue;
              }
              break label214;
            }
            y.deleteFile(str);
            Log.w("AdLandingPagePagFileHelper", "findLocalPagFile, check md5 failed, url=" + paramString1 + ", path=" + str);
            AppMethodBeat.o(310896);
            return "";
          }
        }
        else
        {
          Log.w("AdLandingPagePagFileHelper", "findLocalPagFile, not exists, url=".concat(String.valueOf(paramString1)));
          continue;
        }
        i = 0;
      }
      finally
      {
        Log.e("AdLandingPagePagFileHelper", "findLocalPagFile, exp=" + paramString1.toString());
        AppMethodBeat.o(310896);
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.b
 * JD-Core Version:    0.7.0.1
 */