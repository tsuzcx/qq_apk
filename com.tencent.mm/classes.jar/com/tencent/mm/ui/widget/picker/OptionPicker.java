package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ui.ap;

public class OptionPicker
  extends NumberPicker
{
  private int Un;
  private int eg;
  private String[] hAc;
  private int hAd;
  private Context mContext;
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    this.Un = ap.fromDPToPix(this.mContext, 120);
    this.hAd = ap.fromDPToPix(this.mContext, 20);
    e.a(this, getResources().getDrawable(a.e.picker_divider));
    setDescendantFocusability(393216);
  }
  
  public final String asP()
  {
    if ((this.hAc == null) || (this.hAc.length <= 0)) {
      return "";
    }
    return this.hAc[getValue()];
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.eg = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.Un) && ((this.eg <= 0) || (this.Un <= this.eg)))
    {
      setMeasuredDimension(this.Un, getMeasuredHeight());
      return;
    }
    paramInt2 = getMeasuredWidth() + this.hAd * 2;
    paramInt1 = paramInt2;
    if (this.eg > 0) {
      if (this.eg <= paramInt2) {
        break label119;
      }
    }
    label119:
    for (paramInt1 = paramInt2;; paramInt1 = this.eg)
    {
      setMeasuredDimension(paramInt1, getMeasuredHeight());
      return;
    }
  }
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    super.setDisplayedValues(paramArrayOfString);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    this.hAd = Math.max(paramInt, 0);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.eg = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.Un = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    this.hAc = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    setWrapSelectorWheel(false);
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.OptionPicker
 * JD-Core Version:    0.7.0.1
 */