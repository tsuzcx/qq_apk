package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class ShakeReportUI$3
  implements DialogInterface.OnCancelListener
{
  ShakeReportUI$3(ShakeReportUI paramShakeReportUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(24777);
    aw.aaz();
    c.Ru().setInt(4118, 1);
    ShakeReportUI.t(this.qRs).setVisibility(8);
    AppMethodBeat.o(24777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.3
 * JD-Core Version:    0.7.0.1
 */