package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.u;

final class ShakeReportUI$6
  implements MessageQueue.IdleHandler
{
  ShakeReportUI$6(ShakeReportUI paramShakeReportUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(28452);
    u.q(this.Dlj, this.Dlj.getString(2131765802));
    bg.aVF();
    c.azQ().set(4117, Boolean.TRUE);
    AppMethodBeat.o(28452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.6
 * JD-Core Version:    0.7.0.1
 */