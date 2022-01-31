package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeReportUI$4
  implements DialogInterface.OnCancelListener
{
  ShakeReportUI$4(ShakeReportUI paramShakeReportUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24779);
    Looper.myQueue().addIdleHandler(new ShakeReportUI.4.1(this));
    AppMethodBeat.o(24779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.4
 * JD-Core Version:    0.7.0.1
 */