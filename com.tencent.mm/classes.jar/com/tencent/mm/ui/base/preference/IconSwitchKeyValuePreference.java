package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.ui.tools.u;

public class IconSwitchKeyValuePreference
  extends IconPreference
{
  private TextView BfZ;
  private int status = 0;
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconSwitchKeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(142568);
    if (this.BfZ == null)
    {
      AppMethodBeat.o(142568);
      return;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0F);
    this.BfZ.setTextColor(u.kG(this.mContext));
    if (this.status == 0)
    {
      this.BfZ.setCompoundDrawablesWithIntrinsicBounds(2131691586, 0, 0, 0);
      this.BfZ.setCompoundDrawablePadding(i);
      AppMethodBeat.o(142568);
      return;
    }
    if (this.status == 1)
    {
      this.BfZ.setCompoundDrawablesWithIntrinsicBounds(2131691584, 0, 0, 0);
      this.BfZ.setCompoundDrawablePadding(i);
      AppMethodBeat.o(142568);
      return;
    }
    if (this.status == 2)
    {
      this.BfZ.setCompoundDrawablesWithIntrinsicBounds(2131691585, 0, 0, 0);
      this.BfZ.setCompoundDrawablePadding(i);
      AppMethodBeat.o(142568);
      return;
    }
    this.BfZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142568);
  }
  
  public final void alK(int paramInt)
  {
    AppMethodBeat.i(142567);
    this.status = paramInt;
    updateView();
    AppMethodBeat.o(142567);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142566);
    super.onBindView(paramView);
    this.BfZ = ((TextView)paramView.findViewById(16908304));
    updateView();
    AppMethodBeat.o(142566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference
 * JD-Core Version:    0.7.0.1
 */