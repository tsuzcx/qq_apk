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
  private TextView fxS;
  private String text;
  
  public PluginEmptyTextPreference(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(73906);
    this.text = paramContext.getString(2131763355);
    AppMethodBeat.o(73906);
  }
  
  public PluginEmptyTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73907);
    this.fxS = null;
    this.context = paramContext;
    setLayoutResource(2131495094);
    AppMethodBeat.o(73907);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73909);
    super.onBindView(paramView);
    this.fxS = ((TextView)paramView.findViewById(2131299477));
    this.fxS.setText(this.text);
    AppMethodBeat.o(73909);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73908);
    paramViewGroup = super.onCreateView(paramViewGroup);
    View.inflate(this.context, 2131495094, null);
    AppMethodBeat.o(73908);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginEmptyTextPreference
 * JD-Core Version:    0.7.0.1
 */