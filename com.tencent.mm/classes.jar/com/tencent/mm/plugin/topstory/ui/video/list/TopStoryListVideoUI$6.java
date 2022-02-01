package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryListVideoUI$6
  implements DialogInterface.OnCancelListener
{
  TopStoryListVideoUI$6(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(126507);
    this.BPD.finish();
    AppMethodBeat.o(126507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.6
 * JD-Core Version:    0.7.0.1
 */