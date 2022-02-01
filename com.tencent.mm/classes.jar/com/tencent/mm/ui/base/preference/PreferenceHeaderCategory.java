package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.h;

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
    setLayoutResource(a.h.mm_preference_header_catalog);
    AppMethodBeat.o(142659);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142660);
    paramViewGroup = super.onCreateView(paramViewGroup);
    paramViewGroup.findViewById(16908310).setBackgroundResource(a.f.list_thicklinecell_bg);
    AppMethodBeat.o(142660);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceHeaderCategory
 * JD-Core Version:    0.7.0.1
 */