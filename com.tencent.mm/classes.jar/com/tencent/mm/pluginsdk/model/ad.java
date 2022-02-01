package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.xweb.ao;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.x5.a.e;
import com.tencent.xweb.x5.a.g;
import java.util.HashMap;
import java.util.Map;

public final class ad
{
  private static final Map<String, Object> XRR;
  
  static
  {
    AppMethodBeat.i(133686);
    XRR = new HashMap();
    AppMethodBeat.o(133686);
  }
  
  public static void P(String paramString, Object paramObject)
  {
    AppMethodBeat.i(133685);
    XRR.put(paramString, paramObject);
    e.initTbsSettings(XRR);
    AppMethodBeat.o(133685);
  }
  
  public static boolean iIf()
  {
    AppMethodBeat.i(244765);
    int i = e.getTbsVersion(MMApplicationContext.getContext());
    Log.d("MicroMsg.XWeb.MM.TBSHelper", "isCompliantTbsVersion tbsCoreVersion=%d", new Object[] { Integer.valueOf(i) });
    if (i >= 45912)
    {
      AppMethodBeat.o(244765);
      return true;
    }
    AppMethodBeat.o(244765);
    return false;
  }
  
  public static void iIg()
  {
    AppMethodBeat.i(244767);
    int i = b.aZP();
    Log.i("MicroMsg.XWeb.MM.TBSHelper", "checkDisableSensitiveApi uin = %d", new Object[] { Integer.valueOf(i) });
    if (i == 0) {
      e.disableSensitiveApi();
    }
    AppMethodBeat.o(244767);
  }
  
  public static final class a
  {
    private static boolean XRS;
    
    static
    {
      AppMethodBeat.i(133684);
      Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
      ao.a(MMApplicationContext.getContext(), new IXWebLogClient()
      {
        public final void d(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(133674);
          Log.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(133674);
        }
        
        public final void e(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(133672);
          Log.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(133672);
        }
        
        public final void i(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(133671);
          Log.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(133671);
        }
        
        public final void v(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(133675);
          Log.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(133675);
        }
        
        public final void w(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(133673);
          Log.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(133673);
        }
      });
      XRS = false;
      AppMethodBeat.o(133684);
    }
    
    public static void Jw(boolean paramBoolean)
    {
      AppMethodBeat.i(182769);
      if (ChannelUtil.isGPVersion())
      {
        Log.d("MicroMsg.XWeb.MM.TBSDownloadChecker", "preCheck, isGPVersion, ignore this request");
        AppMethodBeat.o(182769);
        return;
      }
      if (b.aZP() != 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        Log.w("MicroMsg.XWeb.MM.TBSDownloadChecker", "preCheck, not check tbs when user not login!");
        AppMethodBeat.o(182769);
        return;
      }
      if ((g.oZ(MMApplicationContext.getContext())) && (ao.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) <= 0))
      {
        Intent localIntent = new Intent();
        localIntent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        localIntent.putExtra("intent_extra_download_type", 1);
        localIntent.putExtra("intent_extra_download_ignore_network_type", paramBoolean);
        com.tencent.mm.br.c.n(localIntent, "support");
        Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "start UpdaterService to download tbs");
      }
      AppMethodBeat.o(182769);
    }
    
    public static void avN(int paramInt)
    {
      AppMethodBeat.i(133679);
      Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "checkXWalkNow, start UpdaterService to download xwalk now, type:".concat(String.valueOf(paramInt)));
      Intent localIntent = new Intent();
      localIntent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", paramInt);
      com.tencent.mm.br.c.n(localIntent, "support");
      AppMethodBeat.o(133679);
    }
    
    private static boolean iIh()
    {
      AppMethodBeat.i(244659);
      if (h.ax(com.tencent.mm.plugin.expt.b.c.class) == null)
      {
        Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "forceCheck, IExptService is null");
        AppMethodBeat.o(244659);
        return false;
      }
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zuS, 0) == 1)
      {
        Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "forceCheck, ignoreNeedCheckUpdate is true");
        AppMethodBeat.o(244659);
        return true;
      }
      AppMethodBeat.o(244659);
      return false;
    }
    
    public static void iIi()
    {
      AppMethodBeat.i(133680);
      Jw(false);
      AppMethodBeat.o(133680);
    }
    
    public static boolean iIj()
    {
      AppMethodBeat.i(133681);
      boolean bool1 = g.isDownloading();
      boolean bool2 = e.getTBSInstalling();
      boolean bool3 = XRS;
      if ((bool1) || (bool2) || (bool3))
      {
        AppMethodBeat.o(133681);
        return true;
      }
      AppMethodBeat.o(133681);
      return false;
    }
    
    public static int iIk()
    {
      AppMethodBeat.i(133682);
      if ((d.rb(19)) || (d.rc(16)))
      {
        AppMethodBeat.o(133682);
        return 1;
      }
      if (ao.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) > 0)
      {
        AppMethodBeat.o(133682);
        return 4;
      }
      if (g.isDownloading())
      {
        AppMethodBeat.o(133682);
        return 2;
      }
      if (e.getTBSInstalling())
      {
        AppMethodBeat.o(133682);
        return 3;
      }
      boolean bool = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
      Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(133682);
        return 2;
      }
      Log.e("MicroMsg.XWeb.MM.TBSDownloadChecker", "WTF, how could it be?");
      AppMethodBeat.o(133682);
      return 0;
    }
    
    public static void iIl()
    {
      AppMethodBeat.i(133683);
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      ((Intent)localObject).putExtra("intent_extra_download_type", 2);
      ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
      com.tencent.mm.br.c.n((Intent)localObject, "support");
      Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "start UpdaterService to download tbs");
      localObject = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
      }
      AppMethodBeat.o(133683);
    }
    
    public static void lq(Context paramContext)
    {
      AppMethodBeat.i(133677);
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(133676);
          Looper.myQueue().removeIdleHandler(this);
          ad.a.lr(ad.a.this);
          AppMethodBeat.o(133676);
          return false;
        }
      });
      AppMethodBeat.o(133677);
    }
    
    public static void lr(Context paramContext)
    {
      int k = 1;
      AppMethodBeat.i(133678);
      Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "webview start check tbs and xweb");
      Object localObject1;
      if (b.aZP() != 0)
      {
        bool1 = true;
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if ((bool1) || ((paramContext instanceof Activity)))
        {
          Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, checkXWalk userHasLogin: %b, context is Activity: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramContext instanceof Activity) });
          if (localObject1 != null) {
            break label110;
          }
          Log.w("MicroMsg.XWeb.MM.TBSDownloadChecker", "checkXWalk, invalid SharedPreferences");
        }
      }
      label110:
      long l1;
      long l2;
      Object localObject2;
      for (;;)
      {
        if (bool1) {
          break label220;
        }
        Log.w("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, not check tbs when user not login!");
        AppMethodBeat.o(133678);
        return;
        bool1 = false;
        break;
        l1 = ((SharedPreferences)localObject1).getLong("last_check_xwalk", 0L);
        l2 = System.currentTimeMillis();
        if ((Math.abs(l2 - l1) < 1800000L) && (ao.getInstalledNewstVersion(paramContext) > 0))
        {
          Log.w("MicroMsg.XWeb.MM.TBSDownloadChecker", "checkXWalk, check too fast");
        }
        else
        {
          localObject2 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject2).putLong("last_check_xwalk", l2);
          ((SharedPreferences.Editor)localObject2).apply();
          if ((iIh()) || (ao.kfA())) {
            avN(4);
          } else {
            Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "checkXWalk, no need check update");
          }
        }
      }
      label220:
      boolean bool1 = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
      Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1) {}
      for (int i = 2;; i = 1)
      {
        localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
        if (!"1".equals(localObject2))
        {
          Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, tbsDownload switch is off, value = %s", new Object[] { localObject2 });
          AppMethodBeat.o(133678);
          return;
          if (ChannelUtil.isGPVersion())
          {
            Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, isGPVersion, ignore this request");
            AppMethodBeat.o(133678);
          }
        }
        else
        {
          e.setUploadCode(MMApplicationContext.getContext(), 130);
          bool1 = NetStatusUtil.isWifi(paramContext);
          Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool1) });
          if (!bool1)
          {
            Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, net type is not wifi");
            e.setUploadCode(MMApplicationContext.getContext(), 131);
            AppMethodBeat.o(133678);
            return;
          }
          if (localObject1 == null) {
            Log.e("MicroMsg.XWeb.MM.TBSDownloadChecker", "sp is null");
          }
          for (int j = 0;; j = 1)
          {
            if (j != 0) {
              break label523;
            }
            j = ao.getInstalledTbsCoreVersion(paramContext);
            Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "doCheck, expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
            if (j <= 0) {
              break label523;
            }
            e.setUploadCode(MMApplicationContext.getContext(), 132);
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
          label523:
          boolean bool2;
          if (!iIh())
          {
            paramContext = MMApplicationContext.getContext();
            bool2 = g.isDownloading();
            if (!bool2)
            {
              localObject1 = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
              if (localObject1 == null) {
                break label716;
              }
            }
          }
          label716:
          for (bool1 = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);; bool1 = false)
          {
            bool1 = g.needDownload(paramContext, bool1);
            boolean bool3 = NetStatusUtil.isWifi(paramContext);
            g.isDownloadForeground();
            Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.FALSE });
            if ((bool3) && (!bool2) && (bool1)) {}
            for (j = k; j == 0; j = 0)
            {
              Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "no need check tbs");
              AppMethodBeat.o(133678);
              return;
            }
            paramContext = new Intent();
            paramContext.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            paramContext.putExtra("intent_extra_download_type", i);
            com.tencent.mm.br.c.n(paramContext, "support");
            Log.i("MicroMsg.XWeb.MM.TBSDownloadChecker", "start UpdaterService to download tbs");
            AppMethodBeat.o(133678);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.ad
 * JD-Core Version:    0.7.0.1
 */