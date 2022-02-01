package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class ShakeReportUI$3
  implements DialogInterface.OnCancelListener
{
  ShakeReportUI$3(ShakeReportUI paramShakeReportUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(28448);
    bg.aVF();
    c.azQ().setInt(4118, 1);
    ShakeReportUI.t(this.Dlj).setVisibility(8);
    AppMethodBeat.o(28448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.3
 * JD-Core Version:    0.7.0.1
 */