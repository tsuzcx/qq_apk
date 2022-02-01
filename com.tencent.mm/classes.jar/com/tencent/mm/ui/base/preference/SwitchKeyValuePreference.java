package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.t;

public class SwitchKeyValuePreference
  extends Preference
{
  private boolean enable;
  private TextView xif;
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142675);
    this.enable = true;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142675);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(142678);
    if (this.xif == null)
    {
      AppMethodBeat.o(142678);
      return;
    }
    if (this.enable)
    {
      this.xif.setTextColor(t.kJ(this.mContext));
      AppMethodBeat.o(142678);
      return;
    }
    this.xif.setTextColor(t.kK(this.mContext));
    AppMethodBeat.o(142678);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142676);
    super.onBindView(paramView);
    this.xif = ((TextView)paramView.findViewById(16908304));
    updateView();
    AppMethodBeat.o(142676);
  }
  
  public final void xP(boolean paramBoolean)
  {
    AppMethodBeat.i(142677);
    this.enable = paramBoolean;
    updateView();
    AppMethodBeat.o(142677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */