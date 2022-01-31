package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

public class OptionPicker
  extends NumberPicker
{
  private String[] jsr;
  private int jss;
  private Context mContext;
  private int mMaxWidth;
  private int mMinWidth;
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112857);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(112857);
  }
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112858);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(112858);
  }
  
  private void init()
  {
    AppMethodBeat.i(112859);
    this.mMinWidth = al.fromDPToPix(this.mContext, 120);
    this.jss = al.fromDPToPix(this.mContext, 20);
    e.a(this, getResources().getDrawable(2130839945));
    setDescendantFocusability(393216);
    AppMethodBeat.o(112859);
  }
  
  public final String aRR()
  {
    AppMethodBeat.i(112861);
    if ((this.jsr == null) || (this.jsr.length <= 0))
    {
      AppMethodBeat.o(112861);
      return "";
    }
    String str = this.jsr[getValue()];
    AppMethodBeat.o(112861);
    return str;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(112865);
    super.onAttachedToWindow();
    AppMethodBeat.o(112865);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112864);
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.mMaxWidth = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.mMinWidth) && ((this.mMaxWidth <= 0) || (this.mMinWidth <= this.mMaxWidth)))
    {
      setMeasuredDimension(this.mMinWidth, getMeasuredHeight());
      AppMethodBeat.o(112864);
      return;
    }
    paramInt2 = getMeasuredWidth() + this.jss * 2;
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
      AppMethodBeat.o(112864);
      return;
    }
  }
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    AppMethodBeat.i(112863);
    super.setDisplayedValues(paramArrayOfString);
    AppMethodBeat.o(112863);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    AppMethodBeat.i(112862);
    this.jss = Math.max(paramInt, 0);
    AppMethodBeat.o(112862);
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
    AppMethodBeat.i(112860);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(112860);
      return;
    }
    this.jsr = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    setWrapSelectorWheel(false);
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
    AppMethodBeat.o(112860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.OptionPicker
 * JD-Core Version:    0.7.0.1
 */