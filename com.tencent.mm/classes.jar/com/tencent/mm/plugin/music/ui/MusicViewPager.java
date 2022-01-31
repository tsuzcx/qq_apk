package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager
  extends CustomViewPager
{
  private GestureDetector jEK = new GestureDetector(getContext(), new MusicViewPager.b(this, (byte)0));
  
  public MusicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScroller(new MusicViewPager.a(this, getContext()));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (super.onInterceptTouchEvent(paramMotionEvent)) && (this.jEK.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicViewPager
 * JD-Core Version:    0.7.0.1
 */