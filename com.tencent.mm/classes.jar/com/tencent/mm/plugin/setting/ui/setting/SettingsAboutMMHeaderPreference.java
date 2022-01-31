package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutMMHeaderPreference
  extends Preference
{
  public String qGW = "";
  
  public SettingsAboutMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SettingsAboutMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(127086);
    super.onBindView(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131827598);
    TextView localTextView = (TextView)paramView.findViewById(2131827599);
    if (localTextView != null) {
      localTextView.getPaint().setFakeBoldText(true);
    }
    ((TextView)paramView.findViewById(2131827600)).setText(String.format("%s %s", new Object[] { "Version", this.qGW }));
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(new SettingsAboutMMHeaderPreference.1(this));
    }
    AppMethodBeat.o(127086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */