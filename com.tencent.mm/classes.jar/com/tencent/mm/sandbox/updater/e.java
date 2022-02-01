package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.f.a;

public final class e
  implements a
{
  private a GlM;
  private boolean GlN;
  private boolean GlO;
  private boolean GlP;
  Intent intent;
  private int jyC;
  private Notification jyo;
  
  static
  {
    AppMethodBeat.i(32707);
    com.tencent.mm.cq.d.kE(ai.getContext());
    WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.bUy());
    AppMethodBeat.o(32707);
  }
  
  private e()
  {
    AppMethodBeat.i(32698);
    this.GlM = null;
    this.intent = new Intent();
    this.jyo = null;
    this.jyC = 999;
    this.GlN = false;
    this.GlO = false;
    this.GlP = false;
    AppMethodBeat.o(32698);
  }
  
  private void cTi()
  {
    AppMethodBeat.i(32699);
    if (this.GlP)
    {
      ac.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
      AppMethodBeat.o(32699);
      return;
    }
    this.GlP = true;
    if (this.GlM == null)
    {
      this.GlM = new a((byte)0);
      com.tencent.xweb.x5.sdk.d.a(this.GlM);
      p.lA(2);
    }
    eTb();
    p.lA(3);
    AppMethodBeat.o(32699);
  }
  
  public static e eTa()
  {
    return b.GlS;
  }
  
  private void eTb()
  {
    AppMethodBeat.i(32701);
    f.startDownload(ai.getContext());
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localSharedPreferences != null)
    {
      ac.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[] { Boolean.valueOf(this.GlO), Boolean.valueOf(this.GlN) });
      if ((this.GlO) || (this.GlN)) {
        localSharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
      }
    }
    AppMethodBeat.o(32701);
  }
  
  public final boolean bc(Intent paramIntent)
  {
    AppMethodBeat.i(32702);
    this.intent = paramIntent;
    if (this.intent.getIntExtra("intent_extra_download_type", 1) == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.GlN = bool1;
      paramIntent = ai.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramIntent != null) {
        this.GlO = paramIntent.getBoolean("tbs_download_oversea", false);
      }
      ac.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(this.GlN), Boolean.valueOf(this.GlO) });
      bool1 = f.isDownloading();
      com.tencent.xweb.x5.sdk.d.setUploadCode(ai.getContext(), 133);
      if (this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)) {
        QbSdk.setDownloadWithoutWifi(true);
      }
      if (!bool1) {
        break;
      }
      ac.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
      com.tencent.xweb.x5.sdk.d.setUploadCode(ai.getContext(), 134);
      AppMethodBeat.o(32702);
      return true;
    }
    this.GlP = false;
    paramIntent = ai.getContext();
    int i = WebView.getInstalledTbsCoreVersion(paramIntent);
    bool1 = f.a(paramIntent, this.GlN | this.GlO, false, new f.a()
    {
      public final void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(32694);
        boolean bool1 = ax.isWifi(ai.getContext());
        boolean bool2 = e.this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        ac.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (((bool1) || (bool2)) && (paramAnonymousBoolean))
        {
          e.a(e.this);
          AppMethodBeat.o(32694);
          return;
        }
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32693);
            UpdaterService.fm();
            AppMethodBeat.o(32693);
          }
        }, 500L);
        AppMethodBeat.o(32694);
      }
    });
    boolean bool2 = ax.isWifi(paramIntent);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    ac.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((bool2) || (bool3)) && (bool1))
    {
      cTi();
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
    ac.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    ac.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    AppMethodBeat.o(32704);
  }
  
  public final void vE(boolean paramBoolean)
  {
    AppMethodBeat.i(32700);
    if (this.GlM == null)
    {
      ac.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
      AppMethodBeat.o(32700);
      return;
    }
    Context localContext = ai.getContext();
    boolean bool1 = f.isDownloading();
    boolean bool2 = f.needDownload(localContext, this.GlN | this.GlO);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    boolean bool4 = f.isDownloadForeground();
    ac.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((paramBoolean) || (bool3)) && (!bool1) && (bool2))
    {
      eTb();
      p.lA(3);
      AppMethodBeat.o(32700);
      return;
    }
    if ((!paramBoolean) && (!bool3) && (bool1) && (!bool4))
    {
      f.stopDownload();
      p.lA(4);
    }
    AppMethodBeat.o(32700);
  }
  
  final class a
    implements com.tencent.xweb.x5.sdk.h
  {
    private a() {}
    
    public final void onDownloadFinish(int paramInt)
    {
      AppMethodBeat.i(32695);
      ac.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      p.fS(5, paramInt);
      if (paramInt != 110)
      {
        if (paramInt != 100) {
          break label107;
        }
        com.tencent.mm.plugin.report.service.h.wUl.a(64, 64, 4, 3, 1, 1, false);
      }
      for (;;)
      {
        Object localObject = ai.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (localObject != null)
        {
          ac.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
          ((SharedPreferences.Editor)localObject).apply();
        }
        AppMethodBeat.o(32695);
        return;
        label107:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(64L, 3L, 1L, false);
      }
    }
    
    public final void onDownloadProgress(int paramInt) {}
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(32696);
      ac.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      p.fS(6, paramInt);
      if ((paramInt == 200) || (paramInt == 220))
      {
        com.tencent.mm.plugin.report.service.h.wUl.a(64, 64, 7, 6, 1, 1, false);
        e.b(e.this);
        AppMethodBeat.o(32696);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(64L, 6L, 1L, false);
      AppMethodBeat.o(32696);
    }
  }
  
  static final class b
  {
    public static final e GlS;
    
    static
    {
      AppMethodBeat.i(32697);
      GlS = new e((byte)0);
      AppMethodBeat.o(32697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.e
 * JD-Core Version:    0.7.0.1
 */