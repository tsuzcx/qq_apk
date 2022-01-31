package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference
  extends Preference
{
  private Context context;
  private TextView dqa = null;
  private String text;
  
  public PluginEmptyTextPreference(Context paramContext, int paramInt)
  {
    this(paramContext, null, 0);
    this.text = paramContext.getString(paramInt);
  }
  
  public PluginEmptyTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    setLayoutResource(a.g.plugin_text2_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.dqa = ((TextView)paramView.findViewById(a.f.empty_tv));
    this.dqa.setText(this.text);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    View.inflate(this.context, a.g.plugin_text2_preference, null);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginEmptyTextPreference
 * JD-Core Version:    0.7.0.1
 */