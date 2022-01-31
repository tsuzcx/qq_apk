package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class AppAttachDownloadUI$3
  implements Runnable
{
  AppAttachDownloadUI$3(AppAttachDownloadUI paramAppAttachDownloadUI, b paramb1, b paramb2) {}
  
  public final void run()
  {
    AppMethodBeat.i(30266);
    long l1 = System.currentTimeMillis();
    long l2 = e.C(this.zvN.field_fileFullPath, this.zvO.field_fileFullPath);
    if (l2 > 0L)
    {
      this.zvO.field_offset = l2;
      if (AppAttachDownloadUI.c(this.zvO)) {
        this.zvO.field_status = 199L;
      }
    }
    for (boolean bool = al.aUJ().a(this.zvO, new String[0]);; bool = false)
    {
      ab.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(this.zvN.field_msgInfoId), Long.valueOf(this.zvO.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(this.zvO.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(30266);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.3
 * JD-Core Version:    0.7.0.1
 */