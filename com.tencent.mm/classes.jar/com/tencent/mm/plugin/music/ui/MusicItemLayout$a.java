package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class MusicItemLayout$a
  extends GestureDetector.SimpleOnGestureListener
{
  private MusicItemLayout$a(MusicItemLayout paramMusicItemLayout) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(105065);
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = (b.a)this.pbx.getTag();
      if (paramFloat2 <= 0.0F) {
        break label47;
      }
      paramMotionEvent1.bWq();
    }
    for (;;)
    {
      AppMethodBeat.o(105065);
      return false;
      label47:
      paramMotionEvent1.bWp();
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105066);
    b.a locala = (b.a)this.pbx.getTag();
    if (locala.bWo()) {
      if ((paramMotionEvent.getY() <= locala.pbJ.getMeasuredHeight()) && (paramMotionEvent.getY() > 100.0F)) {
        locala.bWr();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105066);
      return false;
      if ((paramMotionEvent.getY() >= locala.pbM.getY() - 100.0F) && (paramMotionEvent.getY() < locala.pbM.getMeasuredHeight() + locala.pbM.getY())) {
        locala.bWr();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout.a
 * JD-Core Version:    0.7.0.1
 */