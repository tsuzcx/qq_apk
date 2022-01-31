package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.b.a;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.vfs.e;

final class WePkgDownloader$1
  implements WePkgDownloader.IWepkgUpdateCallback
{
  WePkgDownloader$1(WePkgDownloader paramWePkgDownloader, WepkgVersion paramWepkgVersion, a parama, WePkgDownloader.IWepkgUpdateCallback paramIWepkgUpdateCallback) {}
  
  public final void a(String paramString1, String paramString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramRetCode)
  {
    AppMethodBeat.i(63431);
    String str = WePkgDownloader.hM(paramString1, this.vFf.version);
    if (paramRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj)
    {
      h.qsU.cT(859, 24);
      boolean bool = WePkgDownloader.g(paramString1, str, this.vFg.field_oldPath, paramString2, this.vFf.cqq);
      e.deleteFile(paramString2);
      b.dko().qD(paramString1);
      if (bool)
      {
        this.vFh.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj);
        AppMethodBeat.o(63431);
        return;
      }
      this.vFi.a(paramString1, this.vFh);
      AppMethodBeat.o(63431);
      return;
    }
    if (paramRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFo)
    {
      this.vFh.a(paramString1, str, paramRetCode);
      AppMethodBeat.o(63431);
      return;
    }
    if (paramRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFn) {
      h.qsU.cT(859, 23);
    }
    for (;;)
    {
      e.deleteFile(paramString2);
      b.dko().qD(paramString1);
      this.vFi.a(paramString1, this.vFh);
      AppMethodBeat.o(63431);
      return;
      if (paramRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFl) {
        h.qsU.cT(859, 25);
      } else if (paramRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFk) {
        h.qsU.cT(859, 26);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.1
 * JD-Core Version:    0.7.0.1
 */