package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;

public class MMBoundedRelativeLayout
  extends RelativeLayout
{
  private int afSw;
  private int afSx;
  
  public MMBoundedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251659);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(251659);
  }
  
  public MMBoundedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251664);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(251664);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(251667);
    this.afSw = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.BoundedView).getDimensionPixelSize(a.m.BoundedView_bounded_width, 0);
    AppMethodBeat.o(251667);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251672);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt1;
    if (this.afSw > 0)
    {
      i = paramInt1;
      if (this.afSw < j)
      {
        paramInt1 = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.makeMeasureSpec(this.afSw, paramInt1);
      }
    }
    j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = paramInt2;
    if (this.afSx > 0)
    {
      paramInt1 = paramInt2;
      if (this.afSx < j)
      {
        paramInt1 = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.afSx, paramInt1);
      }
    }
    super.onMeasure(i, paramInt1);
    AppMethodBeat.o(251672);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(251679);
    this.afSx = paramInt;
    requestLayout();
    AppMethodBeat.o(251679);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(251674);
    this.afSw = paramInt;
    requestLayout();
    AppMethodBeat.o(251674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMBoundedRelativeLayout
 * JD-Core Version:    0.7.0.1
 */