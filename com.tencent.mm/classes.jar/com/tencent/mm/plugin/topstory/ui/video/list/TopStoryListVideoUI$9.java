package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class TopStoryListVideoUI$9
  implements View.OnTouchListener
{
  TopStoryListVideoUI$9(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126510);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (this.Byf.Byb.getVisibility() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (TopStoryListVideoUI.h(this.Byf.Byd, f1, f2))
      {
        ad.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
        a.a(false, this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(126510);
        return false;
      }
      this.Byf.Byb.setVisibility(8);
    }
    a.a(false, this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(126510);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.9
 * JD-Core Version:    0.7.0.1
 */