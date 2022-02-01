package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.tools.u;

public class SwitchKeyValuePreference
  extends Preference
{
  private TextView MXN;
  private boolean enable;
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142675);
    this.enable = true;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142675);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(142678);
    if (this.MXN == null)
    {
      AppMethodBeat.o(142678);
      return;
    }
    if (this.enable)
    {
      this.MXN.setTextColor(u.nF(this.mContext));
      AppMethodBeat.o(142678);
      return;
    }
    this.MXN.setTextColor(u.nG(this.mContext));
    AppMethodBeat.o(142678);
  }
  
  public final void LK(boolean paramBoolean)
  {
    AppMethodBeat.i(142677);
    this.enable = paramBoolean;
    updateView();
    AppMethodBeat.o(142677);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142676);
    super.onBindView(paramView);
    this.MXN = ((TextView)paramView.findViewById(16908304));
    updateView();
    AppMethodBeat.o(142676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */