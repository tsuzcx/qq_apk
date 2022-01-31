package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x5.sdk.f;

public final class u$a
{
  private static boolean vKQ;
  
  static
  {
    AppMethodBeat.i(114673);
    ab.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
    ac.a(ah.getContext(), new u.a.1());
    vKQ = false;
    AppMethodBeat.o(114673);
  }
  
  public static void LA(int paramInt)
  {
    AppMethodBeat.i(114668);
    Intent localIntent = new Intent();
    localIntent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", paramInt);
    com.tencent.mm.bq.d.j(localIntent, "sandbox");
    ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
    AppMethodBeat.o(114668);
  }
  
  public static void dln()
  {
    AppMethodBeat.i(114669);
    if (g.dsn())
    {
      ab.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
      AppMethodBeat.o(114669);
      return;
    }
    if ((f.jU(ah.getContext())) && (WebView.getInstalledTbsCoreVersion(ah.getContext()) <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", 1);
      com.tencent.mm.bq.d.j(localIntent, "sandbox");
      ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    }
    AppMethodBeat.o(114669);
  }
  
  public static boolean dlo()
  {
    AppMethodBeat.i(114670);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = vKQ;
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(114670);
      return true;
    }
    AppMethodBeat.o(114670);
    return false;
  }
  
  public static int dlp()
  {
    AppMethodBeat.i(114671);
    if ((com.tencent.mm.compatible.util.d.fv(19)) || (com.tencent.mm.compatible.util.d.fw(16)))
    {
      AppMethodBeat.o(114671);
      return 1;
    }
    if (WebView.getInstalledTbsCoreVersion(ah.getContext()) > 0)
    {
      AppMethodBeat.o(114671);
      return 4;
    }
    if (f.isDownloading())
    {
      AppMethodBeat.o(114671);
      return 2;
    }
    if (com.tencent.xweb.x5.sdk.d.getTBSInstalling())
    {
      AppMethodBeat.o(114671);
      return 3;
    }
    boolean bool = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
    ab.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(114671);
      return 2;
    }
    ab.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
    AppMethodBeat.o(114671);
    return 0;
  }
  
  public static void dlq()
  {
    AppMethodBeat.i(114672);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    ((Intent)localObject).putExtra("intent_extra_download_type", 2);
    ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
    com.tencent.mm.bq.d.j((Intent)localObject, "sandbox");
    ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    localObject = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
    }
    AppMethodBeat.o(114672);
  }
  
  public static void fO(Context paramContext)
  {
    AppMethodBeat.i(114666);
    Looper.myQueue().addIdleHandler(new u.a.2(paramContext));
    AppMethodBeat.o(114666);
  }
  
  public static void fP(Context paramContext)
  {
    AppMethodBeat.i(114667);
    ab.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
    Object localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    long l1;
    long l2;
    Object localObject2;
    if (localObject1 != null)
    {
      l1 = ((SharedPreferences)localObject1).getLong("last_check_xwalk", 0L);
      l2 = System.currentTimeMillis();
      if (l2 - l1 >= 1800000L)
      {
        localObject2 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject2).putLong("last_check_xwalk", l2);
        ((SharedPreferences.Editor)localObject2).apply();
        LA(4);
      }
    }
    boolean bool = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
    ab.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
      if (!"1".equals(localObject2))
      {
        ab.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { localObject2 });
        AppMethodBeat.o(114667);
        return;
        if (g.dsn())
        {
          ab.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
          AppMethodBeat.o(114667);
        }
      }
      else
      {
        com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), 130);
        bool = at.isWifi(paramContext);
        ab.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
        if (!bool)
        {
          ab.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
          com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), 131);
          AppMethodBeat.o(114667);
          return;
        }
        if (localObject1 == null) {
          ab.e("MicroMsg.TBSDownloadChecker", "sp is null");
        }
        for (int j = 0;; j = 1)
        {
          if (j != 0) {
            break label378;
          }
          j = WebView.getInstalledTbsCoreVersion(paramContext);
          ab.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label378;
          }
          com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), 132);
          AppMethodBeat.o(114667);
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
        label378:
        paramContext = new Intent();
        paramContext.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        paramContext.putExtra("intent_extra_download_type", i);
        com.tencent.mm.bq.d.j(paramContext, "sandbox");
        ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        AppMethodBeat.o(114667);
        return;
      }
    }
  }
  
  public static void oZ(boolean paramBoolean)
  {
    vKQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u.a
 * JD-Core Version:    0.7.0.1
 */