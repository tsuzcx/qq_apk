package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryFSVideoUI$13
  implements DialogInterface.OnCancelListener
{
  TopStoryFSVideoUI$13(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(126348);
    this.BOG.finish();
    AppMethodBeat.o(126348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.13
 * JD-Core Version:    0.7.0.1
 */