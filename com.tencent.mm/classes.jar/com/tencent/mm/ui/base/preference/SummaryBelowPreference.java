package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ac.a.h;

public class SummaryBelowPreference
  extends Preference
{
  public SummaryBelowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SummaryBelowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference_summary_below);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SummaryBelowPreference
 * JD-Core Version:    0.7.0.1
 */