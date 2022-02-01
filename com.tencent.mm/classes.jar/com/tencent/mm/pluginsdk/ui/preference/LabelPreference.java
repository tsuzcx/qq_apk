package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  private View EQs;
  private TextView GYE;
  public co Hvc;
  private TextView Rdy;
  public as uNk;
  
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
    if (this.uNk == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(31857);
      return;
    }
    paramView.setVisibility(0);
    if (this.GYE == null) {
      this.GYE = ((TextView)paramView.findViewById(R.h.dBc));
    }
    if (this.Rdy == null) {
      this.Rdy = ((TextView)paramView.findViewById(R.h.dBd));
    }
    if (this.Rdy != null)
    {
      paramView = this.Rdy.getLayoutParams();
      paramView.width = com.tencent.mm.ci.a.aY(this.mContext, R.f.FixedTitleWidth);
      this.Rdy.setLayoutParams(paramView);
    }
    this.GYE.setVisibility(0);
    ArrayList localArrayList;
    if (d.rk(this.uNk.field_type))
    {
      paramView = this.uNk.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().aMQ(paramView);
      if ((!Util.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.GYE.setText(l.c(this.mContext, Util.listToString(localArrayList, this.mContext.getResources().getString(R.l.exJ))));
      }
      AppMethodBeat.o(31857);
      return;
    }
    if (this.Hvc != null)
    {
      paramView = this.Hvc.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().aMP(paramView);
      if ((!Util.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.GYE.setText(l.c(this.mContext, Util.listToString(localArrayList, this.mContext.getResources().getString(R.l.exJ))));
      }
    }
    AppMethodBeat.o(31857);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31856);
    if (this.EQs == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(R.i.ekc, localViewGroup);
      this.EQs = paramViewGroup;
    }
    paramViewGroup = this.EQs;
    AppMethodBeat.o(31856);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */