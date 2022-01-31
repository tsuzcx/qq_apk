package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;

public class PowerSettingPreference
  extends Preference
{
  private ad lpe;
  private View ozm;
  private ImageView pBA;
  private ImageView pBB;
  private ImageView pBz;
  
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
    int j = 0;
    AppMethodBeat.i(28114);
    super.onBindView(paramView);
    if (this.lpe == null)
    {
      AppMethodBeat.o(28114);
      return;
    }
    if (this.pBz == null) {
      this.pBz = ((ImageView)paramView.findViewById(2131823193));
    }
    if (this.pBA == null) {
      this.pBA = ((ImageView)paramView.findViewById(2131823192));
    }
    if (this.pBB == null) {
      this.pBB = ((ImageView)paramView.findViewById(2131823191));
    }
    boolean bool1 = this.lpe.NZ();
    boolean bool2 = n.raT.Xh(this.lpe.field_username);
    paramView = this.pBA;
    if (bool1)
    {
      i = 0;
      paramView.setVisibility(i);
      paramView = this.pBB;
      if (!bool2) {
        break label182;
      }
      i = 0;
      label142:
      paramView.setVisibility(i);
      paramView = this.pBz;
      if (!this.lpe.NY()) {
        break label188;
      }
    }
    label182:
    label188:
    for (int i = j;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(28114);
      return;
      i = 8;
      break;
      i = 8;
      break label142;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28113);
    if (this.ozm == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      localViewGroup.addView(LayoutInflater.from(this.mContext).inflate(2130970471, null), new AbsListView.LayoutParams(-1, -2));
      this.ozm = paramViewGroup;
    }
    paramViewGroup = this.ozm;
    AppMethodBeat.o(28113);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PowerSettingPreference
 * JD-Core Version:    0.7.0.1
 */