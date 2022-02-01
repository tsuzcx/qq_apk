package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.textstatus.b.j;

public class MaxHeightLinearLayout
  extends LinearLayout
{
  private int MJE;
  private int MJF;
  
  public MaxHeightLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237141);
    this.MJF = -1;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.j.Mzo, 0, 0);
    try
    {
      this.MJE = paramContext.getInteger(b.j.Mzp, -1);
      gmv();
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(237141);
    }
  }
  
  public MaxHeightLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.MJF = -1;
  }
  
  private void gmv()
  {
    AppMethodBeat.i(237142);
    if (this.MJE != -1)
    {
      this.MJF = a.fromDPToPix(getContext(), this.MJE);
      AppMethodBeat.o(237142);
      return;
    }
    this.MJF = -1;
    AppMethodBeat.o(237142);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237144);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.MJF, -2147483648));
    AppMethodBeat.o(237144);
  }
  
  public void setMaxHeightDp(int paramInt)
  {
    AppMethodBeat.i(237146);
    this.MJE = paramInt;
    gmv();
    invalidate();
    AppMethodBeat.o(237146);
  }
  
  public void setMaxHeightPx(int paramInt)
  {
    AppMethodBeat.i(237148);
    this.MJF = paramInt;
    invalidate();
    AppMethodBeat.o(237148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.MaxHeightLinearLayout
 * JD-Core Version:    0.7.0.1
 */