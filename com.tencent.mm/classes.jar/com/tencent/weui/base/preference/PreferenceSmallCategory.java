package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ci.a.g;

public class PreferenceSmallCategory
  extends PreferenceCategory
{
  public PreferenceSmallCategory(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PreferenceSmallCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceSmallCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.mm_preference_header_catalog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.weui.base.preference.PreferenceSmallCategory
 * JD-Core Version:    0.7.0.1
 */