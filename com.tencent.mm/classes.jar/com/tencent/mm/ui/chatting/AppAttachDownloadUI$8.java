package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class AppAttachDownloadUI$8
  implements Runnable
{
  AppAttachDownloadUI$8(AppAttachDownloadUI paramAppAttachDownloadUI, b paramb1, b paramb2) {}
  
  public final void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = e.r(this.vgL.field_fileFullPath, this.vgM.field_fileFullPath);
    if (l2 > 0L)
    {
      this.vgM.field_offset = l2;
      if (AppAttachDownloadUI.b(this.vgM)) {
        this.vgM.field_status = 199L;
      }
    }
    for (boolean bool = ap.avh().c(this.vgM, new String[0]);; bool = false)
    {
      y.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(this.vgL.field_msgInfoId), Long.valueOf(this.vgM.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(this.vgM.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.8
 * JD-Core Version:    0.7.0.1
 */