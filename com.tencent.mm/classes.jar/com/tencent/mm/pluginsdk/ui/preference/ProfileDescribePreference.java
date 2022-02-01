package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.base.preference.Preference;

public class ProfileDescribePreference
  extends Preference
{
  private View KKQ;
  public cr NsP;
  private ProfileDescribeView Ynm;
  public au xVS;
  
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
    if (this.xVS == null)
    {
      AppMethodBeat.o(31905);
      return;
    }
    this.Ynm.gCe();
    AppMethodBeat.o(31905);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31904);
    if (this.KKQ == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      ProfileDescribeView localProfileDescribeView = new ProfileDescribeView(paramViewGroup.getContext());
      this.Ynm = localProfileDescribeView;
      localViewGroup.addView(localProfileDescribeView, new AbsListView.LayoutParams(-1, -2));
      this.Ynm.av(this.xVS);
      this.KKQ = paramViewGroup;
    }
    paramViewGroup = this.KKQ;
    AppMethodBeat.o(31904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference
 * JD-Core Version:    0.7.0.1
 */