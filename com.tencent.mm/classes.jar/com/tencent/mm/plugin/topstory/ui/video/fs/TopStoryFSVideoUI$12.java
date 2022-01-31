package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class TopStoryFSVideoUI$12
  implements View.OnTouchListener
{
  TopStoryFSVideoUI$12(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(1966);
    if (this.tkZ.tkT.getVisibility() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (TopStoryFSVideoUI.f(this.tkZ.tkV, f1, f2))
      {
        ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
        AppMethodBeat.o(1966);
        return false;
      }
      this.tkZ.tkT.setVisibility(8);
    }
    AppMethodBeat.o(1966);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.12
 * JD-Core Version:    0.7.0.1
 */