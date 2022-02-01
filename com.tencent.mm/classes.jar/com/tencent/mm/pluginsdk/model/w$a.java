package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.f;
import org.xwalk.core.XWalkEnvironment;

public final class w$a
{
  private static boolean EMt;
  
  static
  {
    AppMethodBeat.i(133684);
    ad.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
    com.tencent.xweb.aj.a(com.tencent.mm.sdk.platformtools.aj.getContext(), new w.a.1());
    EMt = false;
    AppMethodBeat.o(133684);
  }
  
  public static void Yr(int paramInt)
  {
    AppMethodBeat.i(133679);
    Intent localIntent = new Intent();
    localIntent.setClassName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", paramInt);
    com.tencent.mm.bs.d.l(localIntent, "sandbox");
    ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
    AppMethodBeat.o(133679);
  }
  
  public static void eZI()
  {
    AppMethodBeat.i(133680);
    vF(false);
    AppMethodBeat.o(133680);
  }
  
  public static boolean eZJ()
  {
    AppMethodBeat.i(133681);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = EMt;
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(133681);
      return true;
    }
    AppMethodBeat.o(133681);
    return false;
  }
  
  public static int eZK()
  {
    AppMethodBeat.i(133682);
    if ((com.tencent.mm.compatible.util.d.ly(19)) || (com.tencent.mm.compatible.util.d.lz(16)))
    {
      AppMethodBeat.o(133682);
      return 1;
    }
    if (WebView.getInstalledTbsCoreVersion(com.tencent.mm.sdk.platformtools.aj.getContext()) > 0)
    {
      AppMethodBeat.o(133682);
      return 4;
    }
    if (f.isDownloading())
    {
      AppMethodBeat.o(133682);
      return 2;
    }
    if (com.tencent.xweb.x5.sdk.d.getTBSInstalling())
    {
      AppMethodBeat.o(133682);
      return 3;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
    ad.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(133682);
      return 2;
    }
    ad.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
    AppMethodBeat.o(133682);
    return 0;
  }
  
  public static void eZL()
  {
    AppMethodBeat.i(133683);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    ((Intent)localObject).putExtra("intent_extra_download_type", 2);
    ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
    com.tencent.mm.bs.d.l((Intent)localObject, "sandbox");
    ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    localObject = com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
    }
    AppMethodBeat.o(133683);
  }
  
  public static void hq(Context paramContext)
  {
    AppMethodBeat.i(133677);
    Looper.myQueue().addIdleHandler(new w.a.2(paramContext));
    AppMethodBeat.o(133677);
  }
  
  public static void hr(Context paramContext)
  {
    AppMethodBeat.i(133678);
    ad.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
    Object localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    long l1;
    long l2;
    Object localObject2;
    if (localObject1 != null)
    {
      l1 = ((SharedPreferences)localObject1).getLong("last_check_xwalk", 0L);
      l2 = System.currentTimeMillis();
      if ((Math.abs(l2 - l1) >= 1800000L) || (XWalkEnvironment.getInstalledNewstVersion(paramContext) <= 0))
      {
        localObject2 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject2).putLong("last_check_xwalk", l2);
        ((SharedPreferences.Editor)localObject2).apply();
        Yr(4);
      }
    }
    boolean bool = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
    ad.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
      if (!"1".equals(localObject2))
      {
        ad.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { localObject2 });
        AppMethodBeat.o(133678);
        return;
        if (j.fjZ())
        {
          ad.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
          AppMethodBeat.o(133678);
        }
      }
      else
      {
        com.tencent.xweb.x5.sdk.d.setUploadCode(com.tencent.mm.sdk.platformtools.aj.getContext(), 130);
        bool = ay.isWifi(paramContext);
        ad.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
        if (!bool)
        {
          ad.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
          com.tencent.xweb.x5.sdk.d.setUploadCode(com.tencent.mm.sdk.platformtools.aj.getContext(), 131);
          AppMethodBeat.o(133678);
          return;
        }
        if (localObject1 == null) {
          ad.e("MicroMsg.TBSDownloadChecker", "sp is null");
        }
        for (int j = 0;; j = 1)
        {
          if (j != 0) {
            break label391;
          }
          j = WebView.getInstalledTbsCoreVersion(paramContext);
          ad.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label391;
          }
          com.tencent.xweb.x5.sdk.d.setUploadCode(com.tencent.mm.sdk.platformtools.aj.getContext(), 132);
          AppMethodBeat.o(133678);
          return;
          l1 = ((SharedPreferences)localObject1).getLong("last_check_ts", 0L);
          l2 = System.currentTimeMillis();
          if (Math.abs(l2 - l1) <= 7200000L) {
            break;
          }
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putLong("last_check_ts", l2);
          ((SharedPreferences.Editor)localObject1).apply();
        }
        label391:
        paramContext = new Intent();
        paramContext.setClassName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        paramContext.putExtra("intent_extra_download_type", i);
        com.tencent.mm.bs.d.l(paramContext, "sandbox");
        ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        AppMethodBeat.o(133678);
        return;
      }
    }
  }
  
  public static void vF(boolean paramBoolean)
  {
    AppMethodBeat.i(182769);
    if (j.fjZ())
    {
      ad.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
      AppMethodBeat.o(182769);
      return;
    }
    if ((f.lz(com.tencent.mm.sdk.platformtools.aj.getContext())) && (WebView.getInstalledTbsCoreVersion(com.tencent.mm.sdk.platformtools.aj.getContext()) <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(com.tencent.mm.sdk.platformtools.aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", 1);
      localIntent.putExtra("intent_extra_download_ignore_network_type", paramBoolean);
      com.tencent.mm.bs.d.l(localIntent, "sandbox");
      ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    }
    AppMethodBeat.o(182769);
  }
  
  public static void vG(boolean paramBoolean)
  {
    EMt = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w.a
 * JD-Core Version:    0.7.0.1
 */