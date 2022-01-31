package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.R.n;

public class MaxHeightScrollView
  extends ScrollView
{
  private int sfR;
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.MaxHeightScrollView, 0, 0);
    try
    {
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.n.MaxHeightScrollView_android_maxHeight) {
          setMaxHeight(paramContext.getDimensionPixelSize(k, -1));
        }
        i += 1;
      }
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.sfR > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.sfR, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.sfR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */