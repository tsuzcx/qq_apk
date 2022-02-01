package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.t;

final class ShakeReportUI$4
  implements DialogInterface.OnCancelListener
{
  ShakeReportUI$4(ShakeReportUI paramShakeReportUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(28450);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(28449);
        t.m(ShakeReportUI.4.this.yQi, ShakeReportUI.4.this.yQi.getString(2131763614));
        ba.aBQ();
        c.ajl().set(4117, Boolean.TRUE);
        AppMethodBeat.o(28449);
        return false;
      }
    });
    AppMethodBeat.o(28450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.4
 * JD-Core Version:    0.7.0.1
 */