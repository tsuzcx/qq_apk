package com.tencent.mm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;

public class MaxHeightScrollView
  extends ScrollView
{
  private int mMaxHeight;
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206171);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(206171);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206172);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(206172);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    AppMethodBeat.i(206173);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MaxHeightScrollView, 0, 0);
    try
    {
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == 0) {
          setMaxHeight(paramContext.getDimensionPixelSize(k, -1));
        }
        i += 1;
      }
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(206173);
    }
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206175);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mMaxHeight > 0) && (getMeasuredHeight() > this.mMaxHeight)) {
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, -2147483648));
    }
    AppMethodBeat.o(206175);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(206174);
    this.mMaxHeight = paramInt;
    requestLayout();
    AppMethodBeat.o(206174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */