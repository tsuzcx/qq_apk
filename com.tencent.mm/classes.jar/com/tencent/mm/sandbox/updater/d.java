package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.t;
import com.tencent.xweb.x5.sdk.f;

public final class d
  implements a
{
  Intent intent = new Intent();
  private Notification pAt = null;
  private d.a ucG = null;
  private int ucH = 999;
  private boolean ucI = false;
  private boolean ucJ = false;
  private boolean ucK = false;
  
  static
  {
    t.a(ae.getContext(), new d.1());
    com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.aDE());
  }
  
  public static d cpO()
  {
    return d.b.ucN;
  }
  
  private void cpP()
  {
    if (this.ucK)
    {
      y.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
      return;
    }
    this.ucK = true;
    if (this.ucG == null)
    {
      this.ucG = new d.a(this, (byte)0);
      com.tencent.xweb.x5.sdk.d.a(this.ucG);
      k.jdMethod_if(2);
    }
    cpQ();
    k.jdMethod_if(3);
  }
  
  private void cpQ()
  {
    f.startDownload(ae.getContext());
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localSharedPreferences != null)
    {
      y.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[] { Boolean.valueOf(this.ucJ), Boolean.valueOf(this.ucI) });
      if ((this.ucJ) || (this.ucI)) {
        localSharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
      }
    }
  }
  
  public final boolean aj(Intent paramIntent)
  {
    this.intent = paramIntent;
    boolean bool1;
    if (this.intent.getIntExtra("intent_extra_download_type", 1) == 2)
    {
      bool1 = true;
      this.ucI = bool1;
      paramIntent = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramIntent != null) {
        this.ucJ = paramIntent.getBoolean("tbs_download_oversea", false);
      }
      y.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(this.ucI), Boolean.valueOf(this.ucJ) });
      bool1 = f.isDownloading();
      com.tencent.xweb.x5.sdk.d.setUploadCode(ae.getContext(), 133);
      if (!bool1) {
        break label126;
      }
      y.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
      com.tencent.xweb.x5.sdk.d.setUploadCode(ae.getContext(), 134);
    }
    label126:
    boolean bool2;
    boolean bool3;
    do
    {
      return true;
      bool1 = false;
      break;
      this.ucK = false;
      paramIntent = ae.getContext();
      int i = WebView.getInstalledTbsCoreVersion(paramIntent);
      bool1 = f.a(paramIntent, this.ucI | this.ucJ, false, new d.2(this));
      bool2 = aq.isWifi(paramIntent);
      bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
      y.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (((bool2) || (bool3)) && (bool1))
      {
        cpP();
        return true;
      }
    } while ((bool2) || (bool3));
    return false;
  }
  
  public final boolean isBusy()
  {
    boolean bool1 = false;
    boolean bool3 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    y.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final void mo(boolean paramBoolean)
  {
    if (this.ucG == null) {
      y.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
    }
    boolean bool1;
    boolean bool3;
    boolean bool4;
    do
    {
      return;
      Context localContext = ae.getContext();
      bool1 = f.isDownloading();
      boolean bool2 = f.needDownload(localContext, this.ucI | this.ucJ);
      bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
      bool4 = f.isDownloadForeground();
      y.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (((paramBoolean) || (bool3)) && (!bool1) && (bool2))
      {
        cpQ();
        k.jdMethod_if(3);
        return;
      }
    } while ((paramBoolean) || (bool3) || (!bool1) || (bool4));
    f.stopDownload();
    k.jdMethod_if(4);
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.TBSDownloadMgr", "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d
 * JD-Core Version:    0.7.0.1
 */