package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class StoryCaptureUI$e
  implements DialogInterface.OnClickListener
{
  public static final e sHw;
  
  static
  {
    AppMethodBeat.i(110005);
    sHw = new e();
    AppMethodBeat.o(110005);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110004);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(110004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCaptureUI.e
 * JD-Core Version:    0.7.0.1
 */