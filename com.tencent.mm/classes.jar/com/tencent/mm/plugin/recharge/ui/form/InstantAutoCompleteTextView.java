package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class InstantAutoCompleteTextView
  extends AutoCompleteTextView
{
  private boolean xFq;
  
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
    ae.d("TestAutoCompleteTextView", "dismiss");
    AppMethodBeat.o(67272);
  }
  
  public boolean enoughToFilter()
  {
    AppMethodBeat.i(67273);
    if ((this.xFq) || (super.enoughToFilter()))
    {
      AppMethodBeat.o(67273);
      return true;
    }
    AppMethodBeat.o(67273);
    return false;
  }
  
  public void setShowAlways(boolean paramBoolean)
  {
    this.xFq = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */