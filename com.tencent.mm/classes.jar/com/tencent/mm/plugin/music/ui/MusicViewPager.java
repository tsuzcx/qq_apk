package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager
  extends CustomViewPager
{
  private GestureDetector lOj;
  
  public MusicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105142);
    this.lOj = new GestureDetector(getContext(), new MusicViewPager.b(this, (byte)0));
    setScroller(new MusicViewPager.a(this, getContext()));
    AppMethodBeat.o(105142);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105143);
    if ((super.onInterceptTouchEvent(paramMotionEvent)) && (this.lOj.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(105143);
      return true;
    }
    AppMethodBeat.o(105143);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicViewPager
 * JD-Core Version:    0.7.0.1
 */