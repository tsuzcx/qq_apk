package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference;

public class PowerSettingPreference
  extends Preference
{
  private ai piT;
  private View uCg;
  private ImageView vLY;
  private ImageView vLZ;
  private ImageView vMa;
  
  public PowerSettingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PowerSettingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31903);
    super.onBindView(paramView);
    if (this.piT == null)
    {
      AppMethodBeat.o(31903);
      return;
    }
    if (this.vLY == null) {
      this.vLY = ((ImageView)paramView.findViewById(2131298685));
    }
    if (this.vLZ == null) {
      this.vLZ = ((ImageView)paramView.findViewById(2131298683));
    }
    if (this.vMa == null) {
      this.vMa = ((ImageView)paramView.findViewById(2131298684));
    }
    paramView = this.vLY;
    if (this.piT.aaJ()) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(31903);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31902);
    if (this.uCg == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      localViewGroup.addView(LayoutInflater.from(this.mContext).inflate(2131495144, null), new AbsListView.LayoutParams(-1, -2));
      this.uCg = paramViewGroup;
    }
    paramViewGroup = this.uCg;
    AppMethodBeat.o(31902);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PowerSettingPreference
 * JD-Core Version:    0.7.0.1
 */