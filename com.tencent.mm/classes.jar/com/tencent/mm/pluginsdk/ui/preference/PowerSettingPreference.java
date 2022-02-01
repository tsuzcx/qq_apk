package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference;

public class PowerSettingPreference
  extends Preference
{
  private af oFt;
  private View ttN;
  private ImageView uDh;
  private ImageView uDi;
  private ImageView uDj;
  
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
    if (this.oFt == null)
    {
      AppMethodBeat.o(31903);
      return;
    }
    if (this.uDh == null) {
      this.uDh = ((ImageView)paramView.findViewById(2131298685));
    }
    if (this.uDi == null) {
      this.uDi = ((ImageView)paramView.findViewById(2131298683));
    }
    if (this.uDj == null) {
      this.uDj = ((ImageView)paramView.findViewById(2131298684));
    }
    paramView = this.uDh;
    if (this.oFt.ZO()) {}
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
    if (this.ttN == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      localViewGroup.addView(LayoutInflater.from(this.mContext).inflate(2131495144, null), new AbsListView.LayoutParams(-1, -2));
      this.ttN = paramViewGroup;
    }
    paramViewGroup = this.ttN;
    AppMethodBeat.o(31902);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PowerSettingPreference
 * JD-Core Version:    0.7.0.1
 */