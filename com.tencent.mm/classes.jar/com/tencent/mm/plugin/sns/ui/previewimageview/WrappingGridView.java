package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WrappingGridView
  extends GridView
{
  public WrappingGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WrappingGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(100376);
    super.invalidate();
    AppMethodBeat.o(100376);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100375);
    if (getLayoutParams().height == -2) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100375);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(308588);
    super.requestLayout();
    AppMethodBeat.o(308588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.WrappingGridView
 * JD-Core Version:    0.7.0.1
 */