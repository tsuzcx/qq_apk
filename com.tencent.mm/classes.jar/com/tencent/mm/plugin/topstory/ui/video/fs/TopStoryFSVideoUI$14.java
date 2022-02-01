package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class TopStoryFSVideoUI$14
  implements View.OnTouchListener
{
  TopStoryFSVideoUI$14(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126349);
    if (this.TOI.TOC.getVisibility() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (TopStoryFSVideoUI.i(this.TOI.TOE, f1, f2))
      {
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
        AppMethodBeat.o(126349);
        return false;
      }
      this.TOI.TOC.setVisibility(8);
    }
    AppMethodBeat.o(126349);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.14
 * JD-Core Version:    0.7.0.1
 */