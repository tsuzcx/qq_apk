package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

final class AppAttachNewDownloadUI$10
  implements Runnable
{
  AppAttachNewDownloadUI$10(c paramc1, c paramc2) {}
  
  public final void run()
  {
    AppMethodBeat.i(253801);
    long l1 = System.currentTimeMillis();
    long l2 = y.O(this.aeee.field_fileFullPath, this.aeef.field_fileFullPath, false);
    if (l2 > 0L)
    {
      this.aeef.field_offset = l2;
      if (AppAttachNewDownloadUI.d(this.aeef)) {
        this.aeef.field_status = 199L;
      }
    }
    for (boolean bool = as.cWJ().a(this.aeef, new String[0]);; bool = false)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[] { Long.valueOf(l2), Long.valueOf(this.aeee.field_msgInfoId), Long.valueOf(this.aeef.field_msgInfoId), Boolean.valueOf(bool), Long.valueOf(this.aeef.field_status), Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(253801);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.10
 * JD-Core Version:    0.7.0.1
 */