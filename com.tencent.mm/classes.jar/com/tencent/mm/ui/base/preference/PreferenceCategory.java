package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ac.a.h;

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
    setLayoutResource(a.h.mm_preference_catalog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.PreferenceCategory
 * JD-Core Version:    0.7.0.1
 */