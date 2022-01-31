package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.support.v4.view.c;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;

public class FoldableChatTextItemView
  extends LinearLayout
{
  private c anW;
  private int maxHeight;
  private FoldableChatTextItemView.a vAr;
  
  public FoldableChatTextItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FoldableChatTextItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setTagObject(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    setTag(R.h.touch_loc, new int[] { i, j });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setTagObject(paramMotionEvent);
    if (this.anW != null) {
      this.anW.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setFoldTextListener(FoldableChatTextItemView.a parama)
  {
    this.vAr = parama;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setOnGestureListener(GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.anW = new c(getContext(), paramOnGestureListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableChatTextItemView
 * JD-Core Version:    0.7.0.1
 */