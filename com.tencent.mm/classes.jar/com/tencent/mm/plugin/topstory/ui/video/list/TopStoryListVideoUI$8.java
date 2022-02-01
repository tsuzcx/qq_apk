package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class TopStoryListVideoUI$8
  implements View.OnTouchListener
{
  TopStoryListVideoUI$8(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126509);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if (this.BPD.BOA.getVisibility() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (TopStoryListVideoUI.h(this.BPD.BOC, f1, f2))
      {
        ae.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
        a.a(false, this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126509);
        return false;
      }
      this.BPD.BOA.setVisibility(8);
    }
    a.a(false, this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(126509);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.8
 * JD-Core Version:    0.7.0.1
 */