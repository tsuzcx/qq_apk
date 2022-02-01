package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.f.a;
import com.tencent.xweb.x5.sdk.h;

public final class e
  implements a
{
  private a IrG;
  private boolean IrH;
  private boolean IrI;
  private boolean IrJ;
  Intent intent;
  private Notification jVC;
  private int jVQ;
  
  static
  {
    AppMethodBeat.i(32707);
    com.tencent.mm.cp.d.kX(ak.getContext());
    WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cas());
    AppMethodBeat.o(32707);
  }
  
  private e()
  {
    AppMethodBeat.i(32698);
    this.IrG = null;
    this.intent = new Intent();
    this.jVC = null;
    this.jVQ = 999;
    this.IrH = false;
    this.IrI = false;
    this.IrJ = false;
    AppMethodBeat.o(32698);
  }
  
  private void dfh()
  {
    AppMethodBeat.i(32699);
    if (this.IrJ)
    {
      ae.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
      AppMethodBeat.o(32699);
      return;
    }
    this.IrJ = true;
    if (this.IrG == null)
    {
      this.IrG = new a((byte)0);
      com.tencent.xweb.x5.sdk.d.a(this.IrG);
      p.md(2);
    }
    fmv();
    p.md(3);
    AppMethodBeat.o(32699);
  }
  
  public static e fmu()
  {
    return b.IrM;
  }
  
  private void fmv()
  {
    AppMethodBeat.i(32701);
    f.startDownload(ak.getContext());
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localSharedPreferences != null)
    {
      ae.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[] { Boolean.valueOf(this.IrI), Boolean.valueOf(this.IrH) });
      if ((this.IrI) || (this.IrH)) {
        localSharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
      }
    }
    AppMethodBeat.o(32701);
  }
  
  public final boolean bi(Intent paramIntent)
  {
    AppMethodBeat.i(32702);
    this.intent = paramIntent;
    if (this.intent.getIntExtra("intent_extra_download_type", 1) == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.IrH = bool1;
      paramIntent = ak.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramIntent != null) {
        this.IrI = paramIntent.getBoolean("tbs_download_oversea", false);
      }
      ae.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(this.IrH), Boolean.valueOf(this.IrI) });
      bool1 = f.isDownloading();
      com.tencent.xweb.x5.sdk.d.setUploadCode(ak.getContext(), 133);
      if (this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)) {
        QbSdk.setDownloadWithoutWifi(true);
      }
      if (!bool1) {
        break;
      }
      ae.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
      com.tencent.xweb.x5.sdk.d.setUploadCode(ak.getContext(), 134);
      AppMethodBeat.o(32702);
      return true;
    }
    this.IrJ = false;
    paramIntent = ak.getContext();
    int i = WebView.getInstalledTbsCoreVersion(paramIntent);
    bool1 = f.a(paramIntent, this.IrH | this.IrI, false, new f.a()
    {
      public final void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(32694);
        boolean bool1 = az.isWifi(ak.getContext());
        boolean bool2 = e.this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        ae.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (((bool1) || (bool2)) && (paramAnonymousBoolean))
        {
          e.a(e.this);
          AppMethodBeat.o(32694);
          return;
        }
        ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32693);
            UpdaterService.fD();
            AppMethodBeat.o(32693);
          }
        }, 500L);
        AppMethodBeat.o(32694);
      }
    });
    boolean bool2 = az.isWifi(paramIntent);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    ae.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((bool2) || (bool3)) && (bool1))
    {
      dfh();
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
    ae.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    ae.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    AppMethodBeat.o(32704);
  }
  
  public final void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(32700);
    if (this.IrG == null)
    {
      ae.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
      AppMethodBeat.o(32700);
      return;
    }
    Context localContext = ak.getContext();
    boolean bool1 = f.isDownloading();
    boolean bool2 = f.needDownload(localContext, this.IrH | this.IrI);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    boolean bool4 = f.isDownloadForeground();
    ae.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((paramBoolean) || (bool3)) && (!bool1) && (bool2))
    {
      fmv();
      p.md(3);
      AppMethodBeat.o(32700);
      return;
    }
    if ((!paramBoolean) && (!bool3) && (bool1) && (!bool4))
    {
      f.stopDownload();
      p.md(4);
    }
    AppMethodBeat.o(32700);
  }
  
  final class a
    implements h
  {
    private a() {}
    
    public final void onDownloadFinish(int paramInt)
    {
      AppMethodBeat.i(32695);
      ae.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      p.gi(5, paramInt);
      if (paramInt != 110)
      {
        if (paramInt != 100) {
          break label107;
        }
        g.yxI.a(64, 64, 4, 3, 1, 1, false);
      }
      for (;;)
      {
        Object localObject = ak.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (localObject != null)
        {
          ae.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
          ((SharedPreferences.Editor)localObject).apply();
        }
        AppMethodBeat.o(32695);
        return;
        label107:
        g.yxI.idkeyStat(64L, 3L, 1L, false);
      }
    }
    
    public final void onDownloadProgress(int paramInt) {}
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(32696);
      ae.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      p.gi(6, paramInt);
      if ((paramInt == 200) || (paramInt == 220))
      {
        g.yxI.a(64, 64, 7, 6, 1, 1, false);
        e.b(e.this);
        AppMethodBeat.o(32696);
        return;
      }
      g.yxI.idkeyStat(64L, 6L, 1L, false);
      AppMethodBeat.o(32696);
    }
  }
  
  static final class b
  {
    public static final e IrM;
    
    static
    {
      AppMethodBeat.i(32697);
      IrM = new e((byte)0);
      AppMethodBeat.o(32697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.e
 * JD-Core Version:    0.7.0.1
 */