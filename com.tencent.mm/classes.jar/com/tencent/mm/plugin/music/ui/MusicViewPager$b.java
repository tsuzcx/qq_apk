package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class MusicViewPager$b
  extends GestureDetector.SimpleOnGestureListener
{
  private MusicViewPager$b(MusicViewPager paramMusicViewPager) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) < Math.abs(paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicViewPager.b
 * JD-Core Version:    0.7.0.1
 */