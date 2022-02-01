package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.textstatus.b.a;

public class MaxHeightLinearLayout
  extends LinearLayout
{
  private int GcG;
  private int GcH;
  
  public MaxHeightLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216014);
    this.GcH = -1;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.a.MaxHeightLinearLayout, 0, 0);
    try
    {
      this.GcG = paramContext.getInteger(0, -1);
      fwj();
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(216014);
    }
  }
  
  public MaxHeightLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.GcH = -1;
  }
  
  private void fwj()
  {
    AppMethodBeat.i(216015);
    if (this.GcG != -1)
    {
      this.GcH = a.fromDPToPix(getContext(), this.GcG);
      AppMethodBeat.o(216015);
      return;
    }
    this.GcH = -1;
    AppMethodBeat.o(216015);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216016);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.GcH, -2147483648));
    AppMethodBeat.o(216016);
  }
  
  public void setMaxHeightDp(int paramInt)
  {
    AppMethodBeat.i(216017);
    this.GcG = paramInt;
    fwj();
    invalidate();
    AppMethodBeat.o(216017);
  }
  
  public void setMaxHeightPx(int paramInt)
  {
    AppMethodBeat.i(216018);
    this.GcH = paramInt;
    invalidate();
    AppMethodBeat.o(216018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.MaxHeightLinearLayout
 * JD-Core Version:    0.7.0.1
 */