package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

final class AppAttachNewDownloadUI$10
  implements Runnable
{
  AppAttachNewDownloadUI$10(c paramc1, c paramc2) {}
  
  public final void run()
  {
    AppMethodBeat.i(287891);
    long l1 = System.currentTimeMillis();
    long l2 = u.on(this.WwN.field_fileFullPath, this.WwO.field_fileFullPath);
    if (l2 > 0L)
    {
      this.WwO.field_offset = l2;
      if (AppAttachNewDownloadUI.d(this.WwO)) {
        this.WwO.field_status = 199L;
      }
    }
    for (boolean bool = ao.ctZ().a(this.WwO, new String[0]);; bool = false)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(this.WwN.field_msgInfoId), Long.valueOf(this.WwO.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(this.WwO.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(287891);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.10
 * JD-Core Version:    0.7.0.1
 */