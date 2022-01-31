package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TopStoryViewPager
  extends ViewPager
{
  private boolean canScroll = true;
  
  public TopStoryViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public TopStoryViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(2269);
    if (!this.canScroll)
    {
      AppMethodBeat.o(2269);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(2269);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(2268);
    if (!this.canScroll)
    {
      AppMethodBeat.o(2268);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(2268);
    return bool;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.canScroll = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager
 * JD-Core Version:    0.7.0.1
 */