package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WrapScollview
  extends ScrollView
{
  private View contentView;
  private boolean yZj = true;
  
  public WrapScollview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WrapScollview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    AppMethodBeat.i(99806);
    if (!this.yZj)
    {
      AppMethodBeat.o(99806);
      return 0;
    }
    int i = super.computeScrollDeltaToGetChildRectOnScreen(paramRect);
    AppMethodBeat.o(99806);
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(99805);
    if (this.contentView != null)
    {
      View localView = this.contentView;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int j = arrayOfInt[0];
      int k = localView.getWidth();
      int m = arrayOfInt[1];
      int n = localView.getHeight();
      if ((j < f1) && (f1 < k + j) && (m < f2) && (f2 < n + m)) {}
      while (i != 0)
      {
        AppMethodBeat.o(99805);
        return false;
        i = 0;
      }
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(99805);
    return bool;
  }
  
  public void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setDoComputeScrollDeltaToGetChildRectOnScreen(boolean paramBoolean)
  {
    this.yZj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.WrapScollview
 * JD-Core Version:    0.7.0.1
 */