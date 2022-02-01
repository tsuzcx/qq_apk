package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.ui.aw;

public class OptionPicker
  extends NumberPicker
{
  private int lj;
  private Context mContext;
  private String[] rCh;
  private int rCi;
  private int uJ;
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159581);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(159581);
  }
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159582);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(159582);
  }
  
  private void init()
  {
    AppMethodBeat.i(159583);
    this.lj = aw.fromDPToPix(this.mContext, 120);
    this.rCi = aw.fromDPToPix(this.mContext, 20);
    e.a(this, getResources().getDrawable(a.e.picker_divider));
    setDescendantFocusability(393216);
    e.b(this, this.mContext.getResources().getColor(a.c.normal_text_color));
    AppMethodBeat.o(159583);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(159589);
    super.onAttachedToWindow();
    AppMethodBeat.o(159589);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159588);
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.uJ = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.lj) && ((this.uJ <= 0) || (this.lj <= this.uJ)))
    {
      setMeasuredDimension(this.lj, getMeasuredHeight());
      AppMethodBeat.o(159588);
      return;
    }
    paramInt2 = getMeasuredWidth() + this.rCi * 2;
    paramInt1 = paramInt2;
    if (this.uJ > 0) {
      if (this.uJ <= paramInt2) {
        break label134;
      }
    }
    label134:
    for (paramInt1 = paramInt2;; paramInt1 = this.uJ)
    {
      setMeasuredDimension(paramInt1, getMeasuredHeight());
      AppMethodBeat.o(159588);
      return;
    }
  }
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    AppMethodBeat.i(159587);
    super.setDisplayedValues(paramArrayOfString);
    AppMethodBeat.o(159587);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    AppMethodBeat.i(159586);
    this.rCi = Math.max(paramInt, 0);
    AppMethodBeat.o(159586);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.uJ = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.lj = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(159584);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(159584);
      return;
    }
    this.rCh = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    setWrapSelectorWheel(false);
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
    AppMethodBeat.o(159584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.OptionPicker
 * JD-Core Version:    0.7.0.1
 */