package com.tencent.mm.plugin.story.ui;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class StorySettingsUI$i$a
  implements DialogInterface.OnCancelListener
{
  StorySettingsUI$i$a(StorySettingsUI.i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155322);
    this.sHW.sHQ.finish();
    AppMethodBeat.o(155322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.i.a
 * JD-Core Version:    0.7.0.1
 */