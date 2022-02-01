package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.mogic.WxViewPager;

public class CustomViewPager
  extends WxViewPager
{
  private static final String TAG = "MicroMsg.CustomViewPager";
  private boolean mCanSlide = true;
  private boolean mCanSlideBySide = true;
  
  public CustomViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(141620);
    if (this.mCanSlideBySide)
    {
      boolean bool = super.isGutterDrag(paramFloat1, paramFloat2);
      AppMethodBeat.o(141620);
      return bool;
    }
    AppMethodBeat.o(141620);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141621);
    if (!this.mCanSlide)
    {
      AppMethodBeat.o(141621);
      return false;
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141621);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      ac.printErrStackTrace("MicroMsg.CustomViewPager", paramMotionEvent, "get a Exception", new Object[0]);
      AppMethodBeat.o(141621);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141622);
    if (!this.mCanSlide)
    {
      AppMethodBeat.o(141622);
      return false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141622);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      ac.printErrStackTrace("MicroMsg.CustomViewPager", paramMotionEvent, "get a Exception", new Object[0]);
      AppMethodBeat.o(141622);
    }
    return false;
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.mCanSlide = paramBoolean;
  }
  
  public void setCanSlideBySide(boolean paramBoolean)
  {
    this.mCanSlideBySide = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */