package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.y;

final class f$14$1
  implements WePkgDownloader.IWepkgUpdateCallback
{
  f$14$1(f.14 param14) {}
  
  public final void a(String paramString1, String paramString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramRetCode)
  {
    y.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[] { paramRetCode });
    this.rPM.rPF.cfi = paramString1;
    this.rPM.rPF.fCl = paramString2;
    this.rPM.rPF.rPr = paramRetCode;
    if (this.rPM.rPE != null) {
      this.rPM.rPE.a(this.rPM.rPF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.f.14.1
 * JD-Core Version:    0.7.0.1
 */