package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;

final class ShakeReportUI$4$1
  implements MessageQueue.IdleHandler
{
  ShakeReportUI$4$1(ShakeReportUI.4 param4) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(24778);
    t.a(this.qRu.qRs, 0, this.qRu.qRs.getString(2131303632));
    aw.aaz();
    c.Ru().set(4117, Boolean.TRUE);
    AppMethodBeat.o(24778);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.4.1
 * JD-Core Version:    0.7.0.1
 */