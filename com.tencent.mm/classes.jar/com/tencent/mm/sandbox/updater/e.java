package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.f.a;

public final class e
  implements a
{
  private a NFf;
  private boolean NFg;
  private boolean NFh;
  private boolean NFi;
  Intent intent;
  private int kYM;
  private Notification kYy;
  
  static
  {
    AppMethodBeat.i(32707);
    com.tencent.mm.cr.d.kT(MMApplicationContext.getContext());
    WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
    AppMethodBeat.o(32707);
  }
  
  private e()
  {
    AppMethodBeat.i(32698);
    this.NFf = null;
    this.intent = new Intent();
    this.kYy = null;
    this.kYM = 999;
    this.NFg = false;
    this.NFh = false;
    this.NFi = false;
    AppMethodBeat.o(32698);
  }
  
  private void dZb()
  {
    AppMethodBeat.i(32699);
    if (this.NFi)
    {
      Log.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
      AppMethodBeat.o(32699);
      return;
    }
    this.NFi = true;
    if (this.NFf == null)
    {
      this.NFf = new a((byte)0);
      com.tencent.xweb.x5.sdk.d.a(this.NFf);
      r.pl(2);
    }
    gwi();
    r.pl(3);
    AppMethodBeat.o(32699);
  }
  
  public static e gwh()
  {
    return b.NFl;
  }
  
  private void gwi()
  {
    AppMethodBeat.i(32701);
    f.startDownload(MMApplicationContext.getContext());
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localSharedPreferences != null)
    {
      Log.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[] { Boolean.valueOf(this.NFh), Boolean.valueOf(this.NFg) });
      if ((this.NFh) || (this.NFg)) {
        localSharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
      }
    }
    AppMethodBeat.o(32701);
  }
  
  public final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(32700);
    if (this.NFf == null)
    {
      Log.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
      AppMethodBeat.o(32700);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    boolean bool1 = f.isDownloading();
    boolean bool2 = f.needDownload(localContext, this.NFg | this.NFh);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    boolean bool4 = f.isDownloadForeground();
    Log.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((paramBoolean) || (bool3)) && (!bool1) && (bool2))
    {
      gwi();
      r.pl(3);
      AppMethodBeat.o(32700);
      return;
    }
    if ((!paramBoolean) && (!bool3) && (bool1) && (!bool4))
    {
      f.stopDownload();
      r.pl(4);
    }
    AppMethodBeat.o(32700);
  }
  
  public final boolean bu(Intent paramIntent)
  {
    AppMethodBeat.i(32702);
    this.intent = paramIntent;
    if (this.intent.getIntExtra("intent_extra_download_type", 1) == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.NFg = bool1;
      paramIntent = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramIntent != null) {
        this.NFh = paramIntent.getBoolean("tbs_download_oversea", false);
      }
      Log.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(this.NFg), Boolean.valueOf(this.NFh) });
      bool1 = f.isDownloading();
      com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 133);
      if (this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)) {
        QbSdk.setDownloadWithoutWifi(true);
      }
      if (!bool1) {
        break;
      }
      Log.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
      com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 134);
      AppMethodBeat.o(32702);
      return true;
    }
    this.NFi = false;
    paramIntent = MMApplicationContext.getContext();
    int i = WebView.getInstalledTbsCoreVersion(paramIntent);
    bool1 = f.a(paramIntent, this.NFg | this.NFh, false, new f.a()
    {
      public final void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(32694);
        boolean bool1 = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        boolean bool2 = e.this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        Log.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (((bool1) || (bool2)) && (paramAnonymousBoolean))
        {
          e.a(e.this);
          AppMethodBeat.o(32694);
          return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32693);
            UpdaterService.fK();
            AppMethodBeat.o(32693);
          }
        }, 500L);
        AppMethodBeat.o(32694);
      }
    });
    boolean bool2 = NetStatusUtil.isWifi(paramIntent);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    Log.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((bool2) || (bool3)) && (bool1))
    {
      dZb();
      AppMethodBeat.o(32702);
      return true;
    }
    if ((bool2) || (bool3))
    {
      AppMethodBeat.o(32702);
      return true;
    }
    AppMethodBeat.o(32702);
    return false;
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(32703);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    Log.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(32703);
      return true;
    }
    AppMethodBeat.o(32703);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32704);
    Log.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    AppMethodBeat.o(32704);
  }
  
  final class a
    implements com.tencent.xweb.x5.sdk.h
  {
    private a() {}
    
    public final void onDownloadFinish(int paramInt)
    {
      AppMethodBeat.i(32695);
      Log.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      r.gH(5, paramInt);
      if (paramInt != 110)
      {
        if (paramInt != 100) {
          break label107;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(64, 64, 4, 3, 1, 1, false);
      }
      for (;;)
      {
        Object localObject = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (localObject != null)
        {
          Log.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
          ((SharedPreferences.Editor)localObject).apply();
        }
        AppMethodBeat.o(32695);
        return;
        label107:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(64L, 3L, 1L, false);
      }
    }
    
    public final void onDownloadProgress(int paramInt) {}
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(32696);
      Log.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      r.gH(6, paramInt);
      if ((paramInt == 200) || (paramInt == 220))
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(64, 64, 7, 6, 1, 1, false);
        e.b(e.this);
        AppMethodBeat.o(32696);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(64L, 6L, 1L, false);
      AppMethodBeat.o(32696);
    }
  }
  
  static final class b
  {
    public static final e NFl;
    
    static
    {
      AppMethodBeat.i(32697);
      NFl = new e((byte)0);
      AppMethodBeat.o(32697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.e
 * JD-Core Version:    0.7.0.1
 */