package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

final class SetTextSizeUI$a
  extends Preference
{
  private float nSL;
  
  public SetTextSizeUI$a(SetTextSizeUI paramSetTextSizeUI, Context paramContext, float paramFloat)
  {
    super(paramContext);
    this.nSL = paramFloat;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView != null) {
      paramView.setTextSize(1, SetTextSizeUI.ax(this.nSL));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI.a
 * JD-Core Version:    0.7.0.1
 */