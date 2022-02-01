package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private TextView ETF;
  public am pMt;
  private View vET;
  private TextView wRc;
  public cf xjI;
  
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
    if (this.pMt == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.wRc == null) {
      this.wRc = ((TextView)paramView.findViewById(2131298619));
    }
    if (this.ETF == null) {
      this.ETF = ((TextView)paramView.findViewById(2131298620));
    }
    if (this.ETF != null)
    {
      paramView = this.ETF.getLayoutParams();
      paramView.width = com.tencent.mm.cc.a.ax(this.mContext, 2131165370);
      this.ETF.setLayoutParams(paramView);
    }
    this.wRc.setVisibility(0);
    ArrayList localArrayList;
    if (com.tencent.mm.o.b.lM(this.pMt.field_type))
    {
      paramView = this.pMt.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aoo(paramView);
      if ((!bt.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.wRc.setText(k.c(this.mContext, bt.m(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.xjI != null)
    {
      paramView = this.xjI.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aon(paramView);
      if ((!bt.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.wRc.setText(k.c(this.mContext, bt.m(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.vET == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(2131495138, localViewGroup);
      this.vET = paramViewGroup;
    }
    paramViewGroup = this.vET;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */