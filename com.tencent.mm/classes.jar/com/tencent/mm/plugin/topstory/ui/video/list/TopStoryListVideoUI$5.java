package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryListVideoUI$5
  implements DialogInterface.OnCancelListener
{
  TopStoryListVideoUI$5(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(2105);
    this.tlQ.finish();
    AppMethodBeat.o(2105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.5
 * JD-Core Version:    0.7.0.1
 */