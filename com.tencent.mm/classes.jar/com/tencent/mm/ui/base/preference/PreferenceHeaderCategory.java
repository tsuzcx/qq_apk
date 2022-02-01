package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceHeaderCategory
  extends Preference
{
  public PreferenceHeaderCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceHeaderCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142659);
    setLayoutResource(2131495593);
    AppMethodBeat.o(142659);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142660);
    paramViewGroup = super.onCreateView(paramViewGroup);
    paramViewGroup.findViewById(16908310).setBackgroundResource(2131233338);
    AppMethodBeat.o(142660);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceHeaderCategory
 * JD-Core Version:    0.7.0.1
 */