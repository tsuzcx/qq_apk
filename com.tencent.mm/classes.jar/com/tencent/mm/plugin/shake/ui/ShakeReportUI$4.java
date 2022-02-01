package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.u;

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
        u.q(ShakeReportUI.4.this.Dlj, ShakeReportUI.4.this.Dlj.getString(2131765802));
        bg.aVF();
        c.azQ().set(4117, Boolean.TRUE);
        AppMethodBeat.o(28449);
        return false;
      }
    });
    AppMethodBeat.o(28450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.4
 * JD-Core Version:    0.7.0.1
 */