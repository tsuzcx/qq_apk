package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.t;

final class ShakeReportUI$6
  implements MessageQueue.IdleHandler
{
  ShakeReportUI$6(ShakeReportUI paramShakeReportUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(28452);
    t.m(this.yQi, this.yQi.getString(2131763614));
    ba.aBQ();
    c.ajl().set(4117, Boolean.TRUE);
    AppMethodBeat.o(28452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.6
 * JD-Core Version:    0.7.0.1
 */