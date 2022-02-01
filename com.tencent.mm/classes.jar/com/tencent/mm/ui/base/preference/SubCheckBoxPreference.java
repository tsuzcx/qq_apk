package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ah.a.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/preference/SubCheckBoxPreference;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SubCheckBoxPreference
  extends CheckBoxPreference
{
  public SubCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final int getLayoutId()
  {
    return a.h.mm_preference_summary_checkbox_sub;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SubCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */