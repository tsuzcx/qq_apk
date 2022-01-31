package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryFSVideoUI$11
  implements DialogInterface.OnCancelListener
{
  TopStoryFSVideoUI$11(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(1965);
    this.tkZ.finish();
    AppMethodBeat.o(1965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.11
 * JD-Core Version:    0.7.0.1
 */