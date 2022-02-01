package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClickableFrameLayout
  extends FrameLayout
{
  private View.OnClickListener mOnClickListener;
  private GestureDetector mQj;
  
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mOnClickListener != null;
  }
  
  public void setGestureDetector(GestureDetector paramGestureDetector)
  {
    this.mQj = paramGestureDetector;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(153552);
    super.setOnClickListener(paramOnClickListener);
    this.mOnClickListener = paramOnClickListener;
    AppMethodBeat.o(153552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.extension.video.ClickableFrameLayout
 * JD-Core Version:    0.7.0.1
 */