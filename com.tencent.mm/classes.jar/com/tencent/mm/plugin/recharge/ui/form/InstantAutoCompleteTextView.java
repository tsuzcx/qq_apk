package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.sdk.platformtools.y;

public class InstantAutoCompleteTextView
  extends AutoCompleteTextView
{
  private boolean nrO;
  
  public InstantAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InstantAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void dismissDropDown()
  {
    super.dismissDropDown();
    y.d("TestAutoCompleteTextView", "dismiss");
  }
  
  public boolean enoughToFilter()
  {
    return (this.nrO) || (super.enoughToFilter());
  }
  
  public void setShowAlways(boolean paramBoolean)
  {
    this.nrO = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */