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
  private final String TAG;
  private int bkR;
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(234845);
    this.TAG = ("MicroMsg.MaxHeightScrollView@" + hashCode());
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(234845);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234855);
    this.TAG = ("MicroMsg.MaxHeightScrollView@" + hashCode());
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(234855);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    AppMethodBeat.i(234865);
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
      AppMethodBeat.o(234865);
    }
  }
  
  public int getMaxHeight()
  {
    return this.bkR;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234880);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.bkR > 0) && (getMeasuredHeight() > this.bkR)) {
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(this.bkR, -2147483648));
    }
    AppMethodBeat.o(234880);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(234872);
    this.bkR = paramInt;
    requestLayout();
    AppMethodBeat.o(234872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */