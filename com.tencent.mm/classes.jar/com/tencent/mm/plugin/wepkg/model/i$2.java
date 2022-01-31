package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bo;

final class i$2
  extends a
{
  i$2(i parami, a parama, boolean paramBoolean, String paramString) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    AppMethodBeat.i(63591);
    if ((paramBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
    {
      paramBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramBaseWepkgProcessTask;
      if ((paramBaseWepkgProcessTask.vGj == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj) && (!bo.isNullOrNil(paramBaseWepkgProcessTask.cNP)) && (!bo.isNullOrNil(paramBaseWepkgProcessTask.gUy)))
      {
        h.a(paramBaseWepkgProcessTask.cNP, paramBaseWepkgProcessTask.gUy, true, this.vGH);
        AppMethodBeat.o(63591);
        return;
      }
      if (this.vGH != null)
      {
        paramBaseWepkgProcessTask = new WepkgCrossProcessTask();
        paramBaseWepkgProcessTask.cmX = false;
        this.vGH.a(paramBaseWepkgProcessTask);
      }
      i.y(this.vGF, this.nom);
      AppMethodBeat.o(63591);
      return;
    }
    i.y(this.vGF, this.nom);
    AppMethodBeat.o(63591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i.2
 * JD-Core Version:    0.7.0.1
 */