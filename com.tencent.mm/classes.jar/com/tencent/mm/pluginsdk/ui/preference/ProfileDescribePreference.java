package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.Preference;

public class ProfileDescribePreference
  extends Preference
{
  public cn BzG;
  private ProfileDescribeView Kqf;
  public as rjX;
  private View zlc;
  
  public ProfileDescribePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileDescribePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31905);
    super.onBindView(paramView);
    if (this.rjX == null)
    {
      AppMethodBeat.o(31905);
      return;
    }
    this.Kqf.eEV();
    AppMethodBeat.o(31905);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31904);
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      ProfileDescribeView localProfileDescribeView = new ProfileDescribeView(paramViewGroup.getContext());
      this.Kqf = localProfileDescribeView;
      localViewGroup.addView(localProfileDescribeView, new AbsListView.LayoutParams(-1, -2));
      this.Kqf.aj(this.rjX);
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
    AppMethodBeat.o(31904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference
 * JD-Core Version:    0.7.0.1
 */