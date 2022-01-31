package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class MusicItemLayout$a
  extends GestureDetector.SimpleOnGestureListener
{
  private MusicItemLayout$a(MusicItemLayout paramMusicItemLayout) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = (b.a)this.mBs.getTag();
      if (paramFloat2 <= 0.0F) {
        break label37;
      }
      paramMotionEvent1.bnT();
    }
    for (;;)
    {
      return false;
      label37:
      paramMotionEvent1.bnS();
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    b.a locala = (b.a)this.mBs.getTag();
    if (locala.bnR()) {
      if ((paramMotionEvent.getY() <= locala.mBE.getMeasuredHeight()) && (paramMotionEvent.getY() > 100.0F)) {
        locala.bnU();
      }
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getY() >= locala.mBH.getY() - 100.0F) && (paramMotionEvent.getY() < locala.mBH.getMeasuredHeight() + locala.mBH.getY())) {
        locala.bnU();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout.a
 * JD-Core Version:    0.7.0.1
 */