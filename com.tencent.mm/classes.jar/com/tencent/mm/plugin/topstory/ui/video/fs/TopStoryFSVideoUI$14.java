package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class TopStoryFSVideoUI$14
  implements View.OnTouchListener
{
  TopStoryFSVideoUI$14(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126349);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if (this.BOG.BOA.getVisibility() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (TopStoryFSVideoUI.g(this.BOG.BOC, f1, f2))
      {
        ae.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
        a.a(false, this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126349);
        return false;
      }
      this.BOG.BOA.setVisibility(8);
    }
    a.a(false, this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(126349);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.14
 * JD-Core Version:    0.7.0.1
 */