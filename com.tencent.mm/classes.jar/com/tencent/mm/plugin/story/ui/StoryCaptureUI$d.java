package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class StoryCaptureUI$d
  implements DialogInterface.OnClickListener
{
  StoryCaptureUI$d(StoryCaptureUI paramStoryCaptureUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110003);
    this.sHv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    paramDialogInterface.dismiss();
    AppMethodBeat.o(110003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCaptureUI.d
 * JD-Core Version:    0.7.0.1
 */