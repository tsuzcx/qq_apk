package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.s;

public class SwitchKeyValuePreference
  extends Preference
{
  private boolean enable;
  private TextView pAD;
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107292);
    this.enable = true;
    setLayoutResource(2130970179);
    AppMethodBeat.o(107292);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(107295);
    if (this.pAD == null)
    {
      AppMethodBeat.o(107295);
      return;
    }
    if (this.enable)
    {
      this.pAD.setTextColor(s.iD(this.mContext));
      AppMethodBeat.o(107295);
      return;
    }
    this.pAD.setTextColor(s.iE(this.mContext));
    AppMethodBeat.o(107295);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(107293);
    super.onBindView(paramView);
    this.pAD = ((TextView)paramView.findViewById(16908304));
    bJ();
    AppMethodBeat.o(107293);
  }
  
  public final void qL(boolean paramBoolean)
  {
    AppMethodBeat.i(107294);
    this.enable = paramBoolean;
    bJ();
    AppMethodBeat.o(107294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */