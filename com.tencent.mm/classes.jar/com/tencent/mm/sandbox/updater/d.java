package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.f;

public final class d
  implements a
{
  Intent intent;
  private Notification oUV;
  private d.a ykV;
  private int ykW;
  private boolean ykX;
  private boolean ykY;
  private boolean ykZ;
  
  static
  {
    AppMethodBeat.i(28893);
    com.tencent.mm.cn.d.iO(ah.getContext());
    com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.bgb());
    AppMethodBeat.o(28893);
  }
  
  private d()
  {
    AppMethodBeat.i(28884);
    this.ykV = null;
    this.intent = new Intent();
    this.oUV = null;
    this.ykW = 999;
    this.ykX = false;
    this.ykY = false;
    this.ykZ = false;
    AppMethodBeat.o(28884);
  }
  
  private void bIh()
  {
    AppMethodBeat.i(28885);
    if (this.ykZ)
    {
      ab.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
      AppMethodBeat.o(28885);
      return;
    }
    this.ykZ = true;
    if (this.ykV == null)
    {
      this.ykV = new d.a(this, (byte)0);
      com.tencent.xweb.x5.sdk.d.a(this.ykV);
      m.kS(2);
    }
    drE();
    m.kS(3);
    AppMethodBeat.o(28885);
  }
  
  public static d drD()
  {
    return d.b.ylc;
  }
  
  private void drE()
  {
    AppMethodBeat.i(28887);
    f.startDownload(ah.getContext());
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localSharedPreferences != null)
    {
      ab.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[] { Boolean.valueOf(this.ykY), Boolean.valueOf(this.ykX) });
      if ((this.ykY) || (this.ykX)) {
        localSharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
      }
    }
    AppMethodBeat.o(28887);
  }
  
  public final boolean aI(Intent paramIntent)
  {
    AppMethodBeat.i(28888);
    this.intent = paramIntent;
    if (this.intent.getIntExtra("intent_extra_download_type", 1) == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.ykX = bool1;
      paramIntent = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramIntent != null) {
        this.ykY = paramIntent.getBoolean("tbs_download_oversea", false);
      }
      ab.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(this.ykX), Boolean.valueOf(this.ykY) });
      bool1 = f.isDownloading();
      com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), 133);
      if (!bool1) {
        break;
      }
      ab.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
      com.tencent.xweb.x5.sdk.d.setUploadCode(ah.getContext(), 134);
      AppMethodBeat.o(28888);
      return true;
    }
    this.ykZ = false;
    paramIntent = ah.getContext();
    int i = WebView.getInstalledTbsCoreVersion(paramIntent);
    bool1 = f.a(paramIntent, this.ykX | this.ykY, false, new d.1(this));
    boolean bool2 = at.isWifi(paramIntent);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    ab.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((bool2) || (bool3)) && (bool1))
    {
      bIh();
      AppMethodBeat.o(28888);
      return true;
    }
    if ((bool2) || (bool3))
    {
      AppMethodBeat.o(28888);
      return true;
    }
    AppMethodBeat.o(28888);
    return false;
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(28889);
    boolean bool1 = f.isDownloading();
    boolean bool2 = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
    ab.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(28889);
      return true;
    }
    AppMethodBeat.o(28889);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(28890);
    ab.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    AppMethodBeat.o(28890);
  }
  
  public final void pD(boolean paramBoolean)
  {
    AppMethodBeat.i(28886);
    if (this.ykV == null)
    {
      ab.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
      AppMethodBeat.o(28886);
      return;
    }
    Context localContext = ah.getContext();
    boolean bool1 = f.isDownloading();
    boolean bool2 = f.needDownload(localContext, this.ykX | this.ykY);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    boolean bool4 = f.isDownloadForeground();
    ab.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((paramBoolean) || (bool3)) && (!bool1) && (bool2))
    {
      drE();
      m.kS(3);
      AppMethodBeat.o(28886);
      return;
    }
    if ((!paramBoolean) && (!bool3) && (bool1) && (!bool4))
    {
      f.stopDownload();
      m.kS(4);
    }
    AppMethodBeat.o(28886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d
 * JD-Core Version:    0.7.0.1
 */