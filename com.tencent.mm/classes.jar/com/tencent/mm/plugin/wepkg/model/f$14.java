package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.sdk.platformtools.bk;

final class f$14
  implements Runnable
{
  f$14(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, int paramInt2, WepkgDownloadProcessTask paramWepkgDownloadProcessTask, a parama) {}
  
  public final void run()
  {
    WePkgDownloader.cjU().a(this.rAd, bk.pm(this.rOZ), bk.pm(this.rPI), bk.pm(this.val$downloadUrl), this.rPJ, bk.pm(this.rPK), bk.pm(this.grU), this.rPL, new f.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f.14
 * JD-Core Version:    0.7.0.1
 */