package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private TextView BWi;
  public af oFt;
  private View ttN;
  private TextView uBa;
  public bw uTk;
  
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
    if (this.oFt == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.uBa == null) {
      this.uBa = ((TextView)paramView.findViewById(2131298619));
    }
    if (this.BWi == null) {
      this.BWi = ((TextView)paramView.findViewById(2131298620));
    }
    if (this.BWi != null)
    {
      paramView = this.BWi.getLayoutParams();
      paramView.width = com.tencent.mm.cd.a.ao(this.mContext, 2131165370);
      this.BWi.setLayoutParams(paramView);
    }
    this.uBa.setVisibility(0);
    ArrayList localArrayList;
    if (com.tencent.mm.n.b.ls(this.oFt.field_type))
    {
      paramView = this.oFt.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cIS().aeK(paramView);
      if ((!bt.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.uBa.setText(k.c(this.mContext, bt.n(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.uTk != null)
    {
      paramView = this.uTk.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.cIS().aeJ(paramView);
      if ((!bt.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.uBa.setText(k.c(this.mContext, bt.n(localArrayList, this.mContext.getResources().getString(2131757526))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.ttN == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(2131495138, localViewGroup);
      this.ttN = paramViewGroup;
    }
    paramViewGroup = this.ttN;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */