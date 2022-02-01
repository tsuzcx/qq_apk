package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class InstantAutoCompleteTextView
  extends AutoCompleteTextView
{
  private boolean uYV;
  
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
    AppMethodBeat.i(67272);
    super.dismissDropDown();
    ad.d("TestAutoCompleteTextView", "dismiss");
    AppMethodBeat.o(67272);
  }
  
  public boolean enoughToFilter()
  {
    AppMethodBeat.i(67273);
    if ((this.uYV) || (super.enoughToFilter()))
    {
      AppMethodBeat.o(67273);
      return true;
    }
    AppMethodBeat.o(67273);
    return false;
  }
  
  public void setShowAlways(boolean paramBoolean)
  {
    this.uYV = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */