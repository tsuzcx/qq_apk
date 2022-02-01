package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;

public class PowerSettingPreference
  extends Preference
{
  private ImageView BgV;
  private ImageView BgW;
  private ImageView BgX;
  private as rjX;
  private View zlc;
  
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
    if (this.rjX == null)
    {
      AppMethodBeat.o(31903);
      return;
    }
    if (this.BgV == null) {
      this.BgV = ((ImageView)paramView.findViewById(2131299123));
    }
    if (this.BgW == null) {
      this.BgW = ((ImageView)paramView.findViewById(2131299121));
    }
    if (this.BgX == null) {
      this.BgX = ((ImageView)paramView.findViewById(2131299122));
    }
    paramView = this.BgV;
    if (this.rjX.arA()) {}
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
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      localViewGroup.addView(LayoutInflater.from(this.mContext).inflate(2131495987, null), new AbsListView.LayoutParams(-1, -2));
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
    AppMethodBeat.o(31902);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PowerSettingPreference
 * JD-Core Version:    0.7.0.1
 */