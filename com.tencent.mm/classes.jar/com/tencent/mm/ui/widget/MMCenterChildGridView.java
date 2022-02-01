package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMCenterChildGridView
  extends GridView
{
  public MMCenterChildGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMCenterChildGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164208);
    int i = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    super.onMeasure(paramInt1, i);
    i = Math.min(getNumColumns(), getAdapter().getCount());
    paramInt1 = 0;
    if (i > 0) {
      paramInt1 = getColumnWidth() * i + (i - 1) * getHorizontalSpacing() + getListPaddingLeft() + getListPaddingRight();
    }
    setPadding((paramInt2 - paramInt1) / 2, getPaddingTop(), (paramInt2 - paramInt1) / 2, getPaddingBottom());
    postInvalidate();
    AppMethodBeat.o(164208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMCenterChildGridView
 * JD-Core Version:    0.7.0.1
 */