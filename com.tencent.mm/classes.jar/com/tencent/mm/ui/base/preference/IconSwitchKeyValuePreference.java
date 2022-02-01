package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.t;

public class IconSwitchKeyValuePreference
  extends IconPreference
{
  private int status = 0;
  private TextView uCm;
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cE()
  {
    AppMethodBeat.i(142568);
    if (this.uCm == null)
    {
      AppMethodBeat.o(142568);
      return;
    }
    int i = BackwardSupportUtil.b.g(this.mContext, 2.0F);
    this.uCm.setTextColor(t.kg(this.mContext));
    if (this.status == 0)
    {
      this.uCm.setCompoundDrawablesWithIntrinsicBounds(2131691256, 0, 0, 0);
      this.uCm.setCompoundDrawablePadding(i);
      AppMethodBeat.o(142568);
      return;
    }
    if (this.status == 1)
    {
      this.uCm.setCompoundDrawablesWithIntrinsicBounds(2131691254, 0, 0, 0);
      this.uCm.setCompoundDrawablePadding(i);
      AppMethodBeat.o(142568);
      return;
    }
    if (this.status == 2)
    {
      this.uCm.setCompoundDrawablesWithIntrinsicBounds(2131691255, 0, 0, 0);
      this.uCm.setCompoundDrawablePadding(i);
      AppMethodBeat.o(142568);
      return;
    }
    this.uCm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142568);
  }
  
  public final void XX(int paramInt)
  {
    AppMethodBeat.i(142567);
    this.status = paramInt;
    cE();
    AppMethodBeat.o(142567);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142566);
    super.onBindView(paramView);
    this.uCm = ((TextView)paramView.findViewById(16908304));
    cE();
    AppMethodBeat.o(142566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */