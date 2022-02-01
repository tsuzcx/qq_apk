package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.xweb.WebView;
import com.tencent.xweb.al;
import com.tencent.xweb.w;
import com.tencent.xweb.x5.sdk.f;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class ab
{
  private static final Map<String, Object> QVU;
  
  static
  {
    AppMethodBeat.i(133686);
    QVU = new HashMap();
    AppMethodBeat.o(133686);
  }
  
  public static void D(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133685);
    QVU.put(paramString, paramObject);
    com.tencent.xweb.x5.sdk.d.initTbsSettings(QVU);
    AppMethodBeat.o(133685);
  }
  
  public static void hhg()
  {
    AppMethodBeat.i(244040);
    int i = com.tencent.mm.kernel.b.aGP();
    Log.i("MicroMsg.TBSHelper", "checkDisableSensitiveApi uin = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0) {
      com.tencent.xweb.x5.sdk.d.disableSensitiveApi();
    }
    AppMethodBeat.o(244040);
  }
  
  public static final class a
  {
    private static boolean QVV;
    
    static
    {
      AppMethodBeat.i(133684);
      Log.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
      al.a(MMApplicationContext.getContext(), new ab.a.1());
      QVV = false;
      AppMethodBeat.o(133684);
    }
    
    public static void DP(boolean paramBoolean)
    {
      AppMethodBeat.i(182769);
      if (ChannelUtil.isGPVersion())
      {
        Log.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
        AppMethodBeat.o(182769);
        return;
      }
      if ((f.mB(MMApplicationContext.getContext())) && (WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) <= 0))
      {
        Intent localIntent = new Intent();
        localIntent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        localIntent.putExtra("intent_extra_download_type", 1);
        localIntent.putExtra("intent_extra_download_ignore_network_type", paramBoolean);
        c.l(localIntent, "support");
        Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
      }
      AppMethodBeat.o(182769);
    }
    
    public static void DQ(boolean paramBoolean)
    {
      QVV = paramBoolean;
    }
    
    public static void apI(int paramInt)
    {
      AppMethodBeat.i(133679);
      Intent localIntent = new Intent();
      localIntent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", paramInt);
      c.l(localIntent, "support");
      Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
      AppMethodBeat.o(133679);
    }
    
    private static boolean hhh()
    {
      AppMethodBeat.i(244056);
      if (h.ae(com.tencent.mm.plugin.expt.b.b.class) == null)
      {
        Log.i("MicroMsg.TBSDownloadChecker", "gMMKernel.service(IExptService.class) == null ");
        AppMethodBeat.o(244056);
        return false;
      }
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbx, 0) == 1)
      {
        Log.i("MicroMsg.TBSDownloadChecker", "ignoreNeedCheckUpdate is true ");
        AppMethodBeat.o(244056);
        return true;
      }
      AppMethodBeat.o(244056);
      return false;
    }
    
    public static void hhi()
    {
      AppMethodBeat.i(133680);
      DP(false);
      AppMethodBeat.o(133680);
    }
    
    public static boolean hhj()
    {
      AppMethodBeat.i(133681);
      boolean bool1 = f.isDownloading();
      boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
      boolean bool3 = QVV;
      if ((bool1) || (bool2) || (bool3))
      {
        AppMethodBeat.o(133681);
        return true;
      }
      AppMethodBeat.o(133681);
      return false;
    }
    
    public static int hhk()
    {
      AppMethodBeat.i(133682);
      if ((com.tencent.mm.compatible.util.d.qV(19)) || (com.tencent.mm.compatible.util.d.qW(16)))
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
    
    public static void hhl()
    {
      AppMethodBeat.i(133683);
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      ((Intent)localObject).putExtra("intent_extra_download_type", 2);
      ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
      c.l((Intent)localObject, "support");
      Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
      localObject = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
      }
      AppMethodBeat.o(133683);
    }
    
    public static void jt(Context paramContext)
    {
      AppMethodBeat.i(133677);
      Looper.myQueue().addIdleHandler(new ab.a.2(paramContext));
      AppMethodBeat.o(133677);
    }
    
    public static void ju(Context paramContext)
    {
      int k = 1;
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
          if ((!hhh()) && (!w.iwm())) {
            break label197;
          }
          apI(4);
        }
      }
      boolean bool1 = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
      Log.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {}
      for (int i = 2;; i = 1)
      {
        localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
        if (!"1".equals(localObject2))
        {
          Log.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { localObject2 });
          AppMethodBeat.o(133678);
          return;
          label197:
          Log.i("MicroMsg.TBSDownloadChecker", "start checkXWalk no need check update");
          break;
          if (!ChannelUtil.isGPVersion()) {
            continue;
          }
          Log.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
          AppMethodBeat.o(133678);
          return;
        }
        com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 130);
        bool1 = NetStatusUtil.isWifi(paramContext);
        Log.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool1) });
        if (!bool1)
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
            break label425;
          }
          j = WebView.getInstalledTbsCoreVersion(paramContext);
          Log.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label425;
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
        label425:
        boolean bool2;
        if (!hhh())
        {
          paramContext = MMApplicationContext.getContext();
          bool2 = f.isDownloading();
          if (!bool2)
          {
            localObject1 = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (localObject1 == null) {
              break label618;
            }
          }
        }
        label618:
        for (bool1 = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);; bool1 = false)
        {
          bool1 = f.needDownload(paramContext, bool1);
          boolean bool3 = NetStatusUtil.isWifi(paramContext);
          f.isDownloadForeground();
          Log.i("MicroMsg.TBSDownloadChecker", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.FALSE });
          if ((bool3) && (!bool2) && (bool1)) {}
          for (j = k; j == 0; j = 0)
          {
            Log.i("MicroMsg.TBSDownloadChecker", "no need check tbs");
            AppMethodBeat.o(133678);
            return;
          }
          paramContext = new Intent();
          paramContext.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
          paramContext.putExtra("intent_extra_download_type", i);
          c.l(paramContext, "support");
          Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
          AppMethodBeat.o(133678);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.ab
 * JD-Core Version:    0.7.0.1
 */