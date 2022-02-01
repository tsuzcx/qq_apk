package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aj;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.x5.sdk.f;
import org.xwalk.core.XWalkEnvironment;

public final class w$a
{
  private static boolean DhI;
  
  static
  {
    AppMethodBeat.i(133684);
    ac.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
    aj.a(ai.getContext(), new IXWebLogClient()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(133674);
        ac.d(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(133674);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(133672);
        ac.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(133672);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(133671);
        ac.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(133671);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(133675);
        ac.v(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(133675);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(133673);
        ac.w(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(133673);
      }
    });
    DhI = false;
    AppMethodBeat.o(133684);
  }
  
  public static void Ww(int paramInt)
  {
    AppMethodBeat.i(133679);
    Intent localIntent = new Intent();
    localIntent.setClassName(ai.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    localIntent.putExtra("intent_extra_download_type", paramInt);
    com.tencent.mm.br.d.l(localIntent, "sandbox");
    ac.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
    AppMethodBeat.o(133679);
  }
  
  public static void eKO()
  {
    AppMethodBeat.i(133680);
    uU(false);
    AppMethodBeat.o(133680);
  }
  
  public static boolean eKP()
  {
    AppMethodBeat.i(133681);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    boolean bool3 = DhI;
    if ((bool1) || (bool2) || (bool3))
    {
      AppMethodBeat.o(133681);
      return true;
    }
    AppMethodBeat.o(133681);
    return false;
  }
  
  public static int eKQ()
  {
    AppMethodBeat.i(133682);
    if ((com.tencent.mm.compatible.util.d.kZ(19)) || (com.tencent.mm.compatible.util.d.la(16)))
    {
      AppMethodBeat.o(133682);
      return 1;
    }
    if (WebView.getInstalledTbsCoreVersion(ai.getContext()) > 0)
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
    boolean bool = ai.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
    ac.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(133682);
      return 2;
    }
    ac.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
    AppMethodBeat.o(133682);
    return 0;
  }
  
  public static void eKR()
  {
    AppMethodBeat.i(133683);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(ai.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
    ((Intent)localObject).putExtra("intent_extra_download_type", 2);
    ((Intent)localObject).putExtra("intent_extra_download_ignore_network_type", true);
    com.tencent.mm.br.d.l((Intent)localObject, "sandbox");
    ac.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    localObject = ai.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putBoolean("tbs_download_oversea", true).apply();
    }
    AppMethodBeat.o(133683);
  }
  
  public static void hl(Context paramContext)
  {
    AppMethodBeat.i(133677);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(133676);
        Looper.myQueue().removeIdleHandler(this);
        w.a.hm(this.val$context);
        AppMethodBeat.o(133676);
        return false;
      }
    });
    AppMethodBeat.o(133677);
  }
  
  public static void hm(Context paramContext)
  {
    AppMethodBeat.i(133678);
    ac.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
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
        Ww(4);
      }
    }
    boolean bool = ((SharedPreferences)localObject1).getBoolean("tbs_download_oversea", false);
    ac.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 2;; i = 1)
    {
      localObject2 = ((SharedPreferences)localObject1).getString("tbs_download", null);
      if (!"1".equals(localObject2))
      {
        ac.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { localObject2 });
        AppMethodBeat.o(133678);
        return;
        if (i.eUv())
        {
          ac.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
          AppMethodBeat.o(133678);
        }
      }
      else
      {
        com.tencent.xweb.x5.sdk.d.setUploadCode(ai.getContext(), 130);
        bool = ax.isWifi(paramContext);
        ac.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { localObject2, Boolean.valueOf(bool) });
        if (!bool)
        {
          ac.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
          com.tencent.xweb.x5.sdk.d.setUploadCode(ai.getContext(), 131);
          AppMethodBeat.o(133678);
          return;
        }
        if (localObject1 == null) {
          ac.e("MicroMsg.TBSDownloadChecker", "sp is null");
        }
        for (int j = 0;; j = 1)
        {
          if (j != 0) {
            break label391;
          }
          j = WebView.getInstalledTbsCoreVersion(paramContext);
          ac.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
          if (j <= 0) {
            break label391;
          }
          com.tencent.xweb.x5.sdk.d.setUploadCode(ai.getContext(), 132);
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
        paramContext.setClassName(ai.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        paramContext.putExtra("intent_extra_download_type", i);
        com.tencent.mm.br.d.l(paramContext, "sandbox");
        ac.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        AppMethodBeat.o(133678);
        return;
      }
    }
  }
  
  public static void uU(boolean paramBoolean)
  {
    AppMethodBeat.i(182769);
    if (i.eUv())
    {
      ac.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
      AppMethodBeat.o(182769);
      return;
    }
    if ((f.ln(ai.getContext())) && (WebView.getInstalledTbsCoreVersion(ai.getContext()) <= 0))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(ai.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", 1);
      localIntent.putExtra("intent_extra_download_ignore_network_type", paramBoolean);
      com.tencent.mm.br.d.l(localIntent, "sandbox");
      ac.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
    }
    AppMethodBeat.o(182769);
  }
  
  public static void uV(boolean paramBoolean)
  {
    DhI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w.a
 * JD-Core Version:    0.7.0.1
 */