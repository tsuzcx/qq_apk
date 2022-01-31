package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$1
  implements Runnable
{
  h$1(WepkgDownloadProcessTask paramWepkgDownloadProcessTask, a parama, int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(63567);
    WePkgDownloader.IWepkgUpdateCallback local1 = new WePkgDownloader.IWepkgUpdateCallback()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
      {
        AppMethodBeat.i(63566);
        ab.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[] { paramAnonymousRetCode });
        h.1.this.vGv.cNP = paramAnonymousString1;
        h.1.this.vGv.gUy = paramAnonymousString2;
        h.1.this.vGv.vGj = paramAnonymousRetCode;
        if (h.1.this.vGw != null) {
          h.1.this.vGw.a(h.1.this.vGv);
        }
        AppMethodBeat.o(63566);
      }
    };
    if (this.vrg == 1)
    {
      WePkgDownloader.dky().a(this.nom, local1);
      AppMethodBeat.o(63567);
      return;
    }
    WePkgDownloader.dky().a(this.vrg, bo.nullAsNil(this.nom), "", bo.nullAsNil(this.vGx), bo.nullAsNil(this.val$downloadUrl), this.vGy, bo.nullAsNil(this.vpm), "", bo.nullAsNil(this.iiy), this.vGz, local1);
    AppMethodBeat.o(63567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h.1
 * JD-Core Version:    0.7.0.1
 */