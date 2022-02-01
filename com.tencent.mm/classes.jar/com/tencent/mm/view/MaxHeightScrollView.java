package com.tencent.mm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;

public class MaxHeightScrollView
  extends ScrollView
{
  private int EK;
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(210000);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(210000);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210001);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(210001);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    AppMethodBeat.i(210002);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MaxHeightScrollView, 0, 0);
    try
    {
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == a.m.MaxHeightScrollView_android_maxHeight) {
          setMaxHeight(paramContext.getDimensionPixelSize(k, -1));
        }
        i += 1;
      }
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(210002);
    }
  }
  
  public int getMaxHeight()
  {
    return this.EK;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210005);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.EK > 0) && (getMeasuredHeight() > this.EK)) {
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(this.EK, -2147483648));
    }
    AppMethodBeat.o(210005);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(210003);
    this.EK = paramInt;
    requestLayout();
    AppMethodBeat.o(210003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */