package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ah;
import com.tencent.xweb.x5.sdk.f;
import org.xwalk.core.XWalkEnvironment;

public final class w$a
{
  private static boolean BPu;
  
  static
  {
    AppMethodBeat.i(133684);
    ad.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
    ah.a(aj.getContext(), new w.a.1());
    BPu = false;
    AppMethodBeat.o(133684);
  }
  
  public static void Um(int paramInt)
  {
    AppMethodBeat.i(133679);
    Intent localIntent = new Intent();
    localIntent.setClassName(aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", paramInt);
    com.tencent.mm.bs.d.l(localIntent, "sandbox");
    ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
    AppMethodBeat.o(133679);
  }
  
  public static void evu()
  {
    AppMethodBeat.i(133680);
    tT(false);
    AppMethodBeat.o(133680);
  }
  
  public static boolean evv()
  {
    AppMethodBeat.i(133681);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = BPu;
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(133681);
      return true;
    }
    AppMethodBeat.o(133681);
    return false;
  }
  
  public static int evw()
  {
    AppMethodBeat.i(133682);
    if ((com.tencent.mm.compatible.util.d.lf(19)) || (com.tencent.mm.compatible.util.d.lg(16)))
    {
      AppMethodBeat.o(133682);
      return 1;
    }
    if (WebView.getInstalledTbsCoreVersion(aj.getContext()) > 0)
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
    boolean bool = aj.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
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
  
  public static void evx()
  {
    AppMethodBeat.i(133683);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    ((Intent)localObject).putExtra("intent_extra_download_type", 2);
    ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
    com.tencent.mm.bs.d.l((Intent)localObject, "sandbox");
    ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    localObject = aj.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
    }
    AppMethodBeat.o(133683);
  }
  
  public static void ha(Context paramContext)
  {
    AppMethodBeat.i(133677);
    Looper.myQueue().addIdleHandler(new w.a.2(paramContext));
    AppMethodBeat.o(133677);
  }
  
  public static void hb(Context paramContext)
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
      if ((l2 - l1 >= 1800000L) || (XWalkEnvironment.getInstalledNewstVersion(paramContext) <= 0))
      {
        localObject2 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject2).putLong("last_check_xwalk", l2);
        ((SharedPreferences.Editor)localObject2).apply();
        Um(4);
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
        if (i.eFb())
        {
          ad.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
          AppMethodBeat.o(133678);
        }
      }
      else
      {
        com.tencent.xweb.x5.sdk.d.setUploadCode(aj.getContext(), 130);
        bool = ay.isWifi(paramContext);
        ad.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
        if (!bool)
        {
          ad.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
          com.tencent.xweb.x5.sdk.d.setUploadCode(aj.getContext(), 131);
          AppMethodBeat.o(133678);
          return;
        }
        if (localObject1 == null) {
          ad.e("MicroMsg.TBSDownloadChecker", "sp is null");
        }
        for (int j = 0;; j = 1)
        {
          if (j != 0) {
            break label385;
          }
          j = WebView.getInstalledTbsCoreVersion(paramContext);
          ad.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label385;
          }
          com.tencent.xweb.x5.sdk.d.setUploadCode(aj.getContext(), 132);
          AppMethodBeat.o(133678);
          return;
          l1 = ((SharedPreferences)localObject1).getLong("last_check_ts", 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 <= 7200000L) {
            break;
          }
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putLong("last_check_ts", l2);
          ((SharedPreferences.Editor)localObject1).apply();
        }
        label385:
        paramContext = new Intent();
        paramContext.setClassName(aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        paramContext.putExtra("intent_extra_download_type", i);
        com.tencent.mm.bs.d.l(paramContext, "sandbox");
        ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        AppMethodBeat.o(133678);
        return;
      }
    }
  }
  
  public static void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(182769);
    if (i.eFb())
    {
      ad.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
      AppMethodBeat.o(182769);
      return;
    }
    if ((f.kZ(aj.getContext())) && (WebView.getInstalledTbsCoreVersion(aj.getContext()) <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(aj.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", 1);
      localIntent.putExtra("intent_extra_download_ignore_network_type", paramBoolean);
      com.tencent.mm.bs.d.l(localIntent, "sandbox");
      ad.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    }
    AppMethodBeat.o(182769);
  }
  
  public static void tU(boolean paramBoolean)
  {
    BPu = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w.a
 * JD-Core Version:    0.7.0.1
 */