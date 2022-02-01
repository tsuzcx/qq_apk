package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private TextView BeG;
  public cn BzG;
  private TextView KcS;
  public as rjX;
  private View zlc;
  
  public LabelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LabelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31857);
    super.onBindView(paramView);
    if (this.rjX == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.BeG == null) {
      this.BeG = ((TextView)paramView.findViewById(2131299056));
    }
    if (this.KcS == null) {
      this.KcS = ((TextView)paramView.findViewById(2131299057));
    }
    if (this.KcS != null)
    {
      paramView = this.KcS.getLayoutParams();
      paramView.width = com.tencent.mm.cb.a.aG(this.mContext, 2131165381);
      this.KcS.setLayoutParams(paramView);
    }
    this.BeG.setVisibility(0);
    ArrayList localArrayList;
    if (c.oR(this.rjX.field_type))
    {
      paramView = this.rjX.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCJ(paramView);
      if ((!Util.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.BeG.setText(l.c(this.mContext, Util.listToString(localArrayList, this.mContext.getResources().getString(2131757746))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.BzG != null)
    {
      paramView = this.BzG.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCI(paramView);
      if ((!Util.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.BeG.setText(l.c(this.mContext, Util.listToString(localArrayList, this.mContext.getResources().getString(2131757746))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(2131495981, localViewGroup);
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */