package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.s;

public class IconSwitchKeyValuePreference
  extends IconPreference
{
  private TextView pAD;
  private int status = 0;
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(107191);
    if (this.pAD == null)
    {
      AppMethodBeat.o(107191);
      return;
    }
    int i = BackwardSupportUtil.b.b(this.mContext, 2.0F);
    this.pAD.setTextColor(s.iE(this.mContext));
    if (this.status == 0)
    {
      this.pAD.setCompoundDrawablesWithIntrinsicBounds(2131232063, 0, 0, 0);
      this.pAD.setCompoundDrawablePadding(i);
      AppMethodBeat.o(107191);
      return;
    }
    if (this.status == 1)
    {
      this.pAD.setCompoundDrawablesWithIntrinsicBounds(2131232061, 0, 0, 0);
      this.pAD.setCompoundDrawablePadding(i);
      AppMethodBeat.o(107191);
      return;
    }
    if (this.status == 2)
    {
      this.pAD.setCompoundDrawablesWithIntrinsicBounds(2131232062, 0, 0, 0);
      this.pAD.setCompoundDrawablePadding(i);
      AppMethodBeat.o(107191);
      return;
    }
    this.pAD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(107191);
  }
  
  public final void OS(int paramInt)
  {
    AppMethodBeat.i(107190);
    this.status = paramInt;
    bJ();
    AppMethodBeat.o(107190);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(107189);
    super.onBindView(paramView);
    this.pAD = ((TextView)paramView.findViewById(16908304));
    bJ();
    AppMethodBeat.o(107189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */