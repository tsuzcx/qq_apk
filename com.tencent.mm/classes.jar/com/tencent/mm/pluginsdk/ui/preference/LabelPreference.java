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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private TextView Fma;
  public an pSY;
  private View vQX;
  private TextView xgT;
  public cg xzF;
  
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
    if (this.pSY == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.xgT == null) {
      this.xgT = ((TextView)paramView.findViewById(2131298619));
    }
    if (this.Fma == null) {
      this.Fma = ((TextView)paramView.findViewById(2131298620));
    }
    if (this.Fma != null)
    {
      paramView = this.Fma.getLayoutParams();
      paramView.width = com.tencent.mm.cb.a.ax(this.mContext, 2131165370);
      this.Fma.setLayoutParams(paramView);
    }
    this.xgT.setVisibility(0);
    ArrayList localArrayList;
    if (c.lO(this.pSY.field_type))
    {
      paramView = this.pSY.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dig().apq(paramView);
      if ((!bu.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.xgT.setText(k.c(this.mContext, bu.m(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.xzF != null)
    {
      paramView = this.xzF.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dig().app(paramView);
      if ((!bu.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.xgT.setText(k.c(this.mContext, bu.m(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.vQX == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(2131495138, localViewGroup);
      this.vQX = paramViewGroup;
    }
    paramViewGroup = this.vQX;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */