package com.tencent.mm.view.popview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

public abstract class AbstractPopView
  extends FrameLayout
{
  public AbstractPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbstractPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void fD(View paramView);
  
  public abstract WindowManager.LayoutParams getWindowLayoutParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.popview.AbstractPopView
 * JD-Core Version:    0.7.0.1
 */