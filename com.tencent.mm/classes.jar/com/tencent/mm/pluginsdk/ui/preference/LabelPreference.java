package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private TextView Doz;
  public ai piT;
  private View uCg;
  private TextView vJT;
  public bz wbZ;
  
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
    if (this.piT == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.vJT == null) {
      this.vJT = ((TextView)paramView.findViewById(2131298619));
    }
    if (this.Doz == null) {
      this.Doz = ((TextView)paramView.findViewById(2131298620));
    }
    if (this.Doz != null)
    {
      paramView = this.Doz.getLayoutParams();
      paramView.width = com.tencent.mm.cc.a.au(this.mContext, 2131165370);
      this.Doz.setLayoutParams(paramView);
    }
    this.vJT.setVisibility(0);
    ArrayList localArrayList;
    if (com.tencent.mm.n.b.ln(this.piT.field_type))
    {
      paramView = this.piT.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cWd().ajC(paramView);
      if ((!bs.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.vJT.setText(k.c(this.mContext, bs.n(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.wbZ != null)
    {
      paramView = this.wbZ.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cWd().ajB(paramView);
      if ((!bs.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.vJT.setText(k.c(this.mContext, bs.n(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.uCg == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(2131495138, localViewGroup);
      this.uCg = paramViewGroup;
    }
    paramViewGroup = this.uCg;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */