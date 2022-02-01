package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class RecordPluginLayout$e
  implements DialogInterface.OnClickListener
{
  RecordPluginLayout$e(RecordPluginLayout paramRecordPluginLayout) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(237408);
    paramDialogInterface.dismiss();
    RecordPluginLayout.c(this.BXg);
    AppMethodBeat.o(237408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.e
 * JD-Core Version:    0.7.0.1
 */