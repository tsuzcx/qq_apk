package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bk;

final class g$2
  extends a
{
  g$2(g paramg, a parama, boolean paramBoolean, String paramString) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    if ((paramBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
    {
      paramBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramBaseWepkgProcessTask;
      if ((paramBaseWepkgProcessTask.rPr == WePkgDownloader.IWepkgUpdateCallback.RetCode.rOv) && (!bk.bl(paramBaseWepkgProcessTask.cfi)) && (!bk.bl(paramBaseWepkgProcessTask.fCl)))
      {
        f.a(paramBaseWepkgProcessTask.cfi, paramBaseWepkgProcessTask.fCl, true, this.rPQ);
        return;
      }
      g.q(this.rPO, this.rOZ);
      return;
    }
    g.q(this.rPO, this.rOZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g.2
 * JD-Core Version:    0.7.0.1
 */