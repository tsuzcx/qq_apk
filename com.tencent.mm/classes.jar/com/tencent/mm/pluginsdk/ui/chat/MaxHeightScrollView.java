package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;

public class MaxHeightScrollView
  extends ScrollView
{
  private int mMaxHeight;
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31746);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(31746);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31747);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(31747);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    AppMethodBeat.i(31748);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.MaxHeightScrollView, 0, 0);
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
      AppMethodBeat.o(31748);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31749);
    if (this.mMaxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(31749);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */