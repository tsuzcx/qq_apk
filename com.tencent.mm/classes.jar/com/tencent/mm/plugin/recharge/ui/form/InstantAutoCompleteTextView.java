package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class InstantAutoCompleteTextView
  extends AutoCompleteTextView
{
  private boolean pXc;
  
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
    AppMethodBeat.i(44364);
    super.dismissDropDown();
    ab.d("TestAutoCompleteTextView", "dismiss");
    AppMethodBeat.o(44364);
  }
  
  public boolean enoughToFilter()
  {
    AppMethodBeat.i(44365);
    if ((this.pXc) || (super.enoughToFilter()))
    {
      AppMethodBeat.o(44365);
      return true;
    }
    AppMethodBeat.o(44365);
    return false;
  }
  
  public void setShowAlways(boolean paramBoolean)
  {
    this.pXc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */