package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.textstatus.a.j;

public class MaxHeightLinearLayout
  extends LinearLayout
{
  private int TvL;
  private int TvM;
  
  public MaxHeightLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291662);
    this.TvM = -1;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.j.Thn, 0, 0);
    try
    {
      this.TvL = paramContext.getInteger(a.j.Tho, -1);
      hIp();
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(291662);
    }
  }
  
  public MaxHeightLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.TvM = -1;
  }
  
  private void hIp()
  {
    AppMethodBeat.i(291668);
    if (this.TvL != -1)
    {
      this.TvM = a.fromDPToPix(getContext(), this.TvL);
      AppMethodBeat.o(291668);
      return;
    }
    this.TvM = -1;
    AppMethodBeat.o(291668);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291682);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.TvM, -2147483648));
    AppMethodBeat.o(291682);
  }
  
  public void setMaxHeightDp(int paramInt)
  {
    AppMethodBeat.i(291689);
    this.TvL = paramInt;
    hIp();
    invalidate();
    AppMethodBeat.o(291689);
  }
  
  public void setMaxHeightPx(int paramInt)
  {
    AppMethodBeat.i(291693);
    this.TvM = paramInt;
    invalidate();
    AppMethodBeat.o(291693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.MaxHeightLinearLayout
 * JD-Core Version:    0.7.0.1
 */