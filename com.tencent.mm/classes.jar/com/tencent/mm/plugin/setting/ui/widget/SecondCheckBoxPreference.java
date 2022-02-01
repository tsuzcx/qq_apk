package com.tencent.mm.plugin.setting.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/setting/ui/widget/SecondCheckBoxPreference;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getLayoutId", "plugin-setting_release"})
public final class SecondCheckBoxPreference
  extends CheckBoxPreference
{
  public SecondCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SecondCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final int getLayoutId()
  {
    return b.g.second_checkbox_preference_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SecondCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */