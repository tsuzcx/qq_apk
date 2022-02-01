package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;

public class OptionPicker
  extends NumberPicker
{
  private Context mContext;
  private int mMaxWidth;
  private int mMinWidth;
  private String[] ozA;
  private int ozB;
  
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
    this.mMinWidth = at.fromDPToPix(this.mContext, 120);
    this.ozB = at.fromDPToPix(this.mContext, 20);
    f.a(this, getResources().getDrawable(2131234426));
    setDescendantFocusability(393216);
    f.b(this, this.mContext.getResources().getColor(2131100904));
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
      this.mMaxWidth = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.mMinWidth) && ((this.mMaxWidth <= 0) || (this.mMinWidth <= this.mMaxWidth)))
    {
      setMeasuredDimension(this.mMinWidth, getMeasuredHeight());
      AppMethodBeat.o(159588);
      return;
    }
    paramInt2 = getMeasuredWidth() + this.ozB * 2;
    paramInt1 = paramInt2;
    if (this.mMaxWidth > 0) {
      if (this.mMaxWidth <= paramInt2) {
        break label134;
      }
    }
    label134:
    for (paramInt1 = paramInt2;; paramInt1 = this.mMaxWidth)
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
    this.ozB = Math.max(paramInt, 0);
    AppMethodBeat.o(159586);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.mMinWidth = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(159584);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(159584);
      return;
    }
    this.ozA = paramArrayOfString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.OptionPicker
 * JD-Core Version:    0.7.0.1
 */