package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.preference.Preference;

public class ProfileDescribePreference
  extends Preference
{
  private ProfileDescribeView FgI;
  public am pMt;
  private View vET;
  public cf xjI;
  
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
    if (this.pMt == null)
    {
      AppMethodBeat.o(31905);
      return;
    }
    this.FgI.dBj();
    AppMethodBeat.o(31905);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31904);
    if (this.vET == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      ProfileDescribeView localProfileDescribeView = new ProfileDescribeView(paramViewGroup.getContext());
      this.FgI = localProfileDescribeView;
      localViewGroup.addView(localProfileDescribeView, new AbsListView.LayoutParams(-1, -2));
      this.FgI.aa(this.pMt);
      this.vET = paramViewGroup;
    }
    paramViewGroup = this.vET;
    AppMethodBeat.o(31904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference
 * JD-Core Version:    0.7.0.1
 */