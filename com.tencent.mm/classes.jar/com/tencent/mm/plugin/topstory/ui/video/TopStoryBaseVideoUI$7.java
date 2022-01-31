package com.tencent.mm.plugin.topstory.ui.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class TopStoryBaseVideoUI$7
  implements DialogInterface.OnDismissListener
{
  TopStoryBaseVideoUI$7(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (TopStoryBaseVideoUI.a(this.pFv))
    {
      this.pFv.pFp.bMs();
      TopStoryBaseVideoUI.b(this.pFv);
    }
    this.pFv.bOa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.7
 * JD-Core Version:    0.7.0.1
 */