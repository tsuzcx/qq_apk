package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference
  extends Preference
{
  private Context context;
  private TextView ehx;
  private String text;
  
  public PluginEmptyTextPreference(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(126975);
    this.text = paramContext.getString(2131303373);
    AppMethodBeat.o(126975);
  }
  
  public PluginEmptyTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126976);
    this.ehx = null;
    this.context = paramContext;
    setLayoutResource(2130970421);
    AppMethodBeat.o(126976);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(126978);
    super.onBindView(paramView);
    this.ehx = ((TextView)paramView.findViewById(2131821495));
    this.ehx.setText(this.text);
    AppMethodBeat.o(126978);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(126977);
    paramViewGroup = super.onCreateView(paramViewGroup);
    View.inflate(this.context, 2130970421, null);
    AppMethodBeat.o(126977);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginEmptyTextPreference
 * JD-Core Version:    0.7.0.1
 */