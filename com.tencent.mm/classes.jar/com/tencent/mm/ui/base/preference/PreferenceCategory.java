package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceCategory
  extends Preference
{
  public PreferenceCategory(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107278);
    setLayoutResource(2130970184);
    AppMethodBeat.o(107278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceCategory
 * JD-Core Version:    0.7.0.1
 */