package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aj;
import com.tencent.xweb.x5.sdk.f;
import org.xwalk.core.XWalkEnvironment;

public final class x$a
{
  private static boolean JVI;
  
  static
  {
    AppMethodBeat.i(133684);
    Log.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
    aj.a(MMApplicationContext.getContext(), new x.a.1());
    JVI = false;
    AppMethodBeat.o(133684);
  }
  
  public static void ahJ(int paramInt)
  {
    AppMethodBeat.i(133679);
    Intent localIntent = new Intent();
    localIntent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", paramInt);
    c.m(localIntent, "sandbox");
    Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
    AppMethodBeat.o(133679);
  }
  
  public static void gmH()
  {
    AppMethodBeat.i(133680);
    zK(false);
    AppMethodBeat.o(133680);
  }
  
  public static boolean gmI()
  {
    AppMethodBeat.i(133681);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = JVI;
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(133681);
      return true;
    }
    AppMethodBeat.o(133681);
    return false;
  }
  
  public static int gmJ()
  {
    AppMethodBeat.i(133682);
    if ((com.tencent.mm.compatible.util.d.oD(19)) || (com.tencent.mm.compatible.util.d.oE(16)))
    {
      AppMethodBeat.o(133682);
      return 1;
    }
    if (WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) > 0)
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
    boolean bool = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
    Log.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(133682);
      return 2;
    }
    Log.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
    AppMethodBeat.o(133682);
    return 0;
  }
  
  public static void gmK()
  {
    AppMethodBeat.i(133683);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    ((Intent)localObject).putExtra("intent_extra_download_type", 2);
    ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
    c.m((Intent)localObject, "sandbox");
    Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    localObject = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
    }
    AppMethodBeat.o(133683);
  }
  
  public static void iq(Context paramContext)
  {
    AppMethodBeat.i(133677);
    Looper.myQueue().addIdleHandler(new x.a.2(paramContext));
    AppMethodBeat.o(133677);
  }
  
  public static void ir(Context paramContext)
  {
    AppMethodBeat.i(133678);
    Log.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
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
        ahJ(4);
      }
    }
    boolean bool = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
    Log.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
      if (!"1".equals(localObject2))
      {
        Log.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { localObject2 });
        AppMethodBeat.o(133678);
        return;
        if (ChannelUtil.isGPVersion())
        {
          Log.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
          AppMethodBeat.o(133678);
        }
      }
      else
      {
        com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 130);
        bool = NetStatusUtil.isWifi(paramContext);
        Log.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
          com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 131);
          AppMethodBeat.o(133678);
          return;
        }
        if (localObject1 == null) {
          Log.e("MicroMsg.TBSDownloadChecker", "sp is null");
        }
        for (int j = 0;; j = 1)
        {
          if (j != 0) {
            break label391;
          }
          j = WebView.getInstalledTbsCoreVersion(paramContext);
          Log.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label391;
          }
          com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 132);
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
        paramContext.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        paramContext.putExtra("intent_extra_download_type", i);
        c.m(paramContext, "sandbox");
        Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        AppMethodBeat.o(133678);
        return;
      }
    }
  }
  
  public static void zK(boolean paramBoolean)
  {
    AppMethodBeat.i(182769);
    if (ChannelUtil.isGPVersion())
    {
      Log.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
      AppMethodBeat.o(182769);
      return;
    }
    if ((f.lE(MMApplicationContext.getContext())) && (WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", 1);
      localIntent.putExtra("intent_extra_download_ignore_network_type", paramBoolean);
      c.m(localIntent, "sandbox");
      Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    }
    AppMethodBeat.o(182769);
  }
  
  public static void zL(boolean paramBoolean)
  {
    JVI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.x.a
 * JD-Core Version:    0.7.0.1
 */