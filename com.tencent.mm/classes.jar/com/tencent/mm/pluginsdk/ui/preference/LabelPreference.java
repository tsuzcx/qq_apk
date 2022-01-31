package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference
  extends Preference
{
  public ad lpe;
  private View ozm;
  public bv pRo;
  private TextView pzr;
  private TextView vRB;
  
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
    AppMethodBeat.i(28070);
    super.onBindView(paramView);
    if (this.lpe == null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(28070);
      return;
    }
    paramView.setVisibility(0);
    if (this.pzr == null) {
      this.pzr = ((TextView)paramView.findViewById(2131826851));
    }
    if (this.vRB == null) {
      this.vRB = ((TextView)paramView.findViewById(2131826850));
    }
    if (this.vRB != null)
    {
      paramView = this.vRB.getLayoutParams();
      paramView.width = com.tencent.mm.cb.a.ao(this.mContext, 2131427664);
      this.vRB.setLayoutParams(paramView);
    }
    this.pzr.setVisibility(0);
    ArrayList localArrayList;
    if (com.tencent.mm.n.a.je(this.lpe.field_type))
    {
      paramView = this.lpe.field_contactLabelIds;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.bKV().RQ(paramView);
      if ((!bo.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.pzr.setText(j.b(this.mContext, bo.d(localArrayList, this.mContext.getResources().getString(2131298491))));
      }
      AppMethodBeat.o(28070);
      return;
    }
    if (this.pRo != null)
    {
      paramView = this.pRo.field_contactLabels;
      localArrayList = (ArrayList)com.tencent.mm.plugin.label.a.a.bKV().RP(paramView);
      if ((!bo.isNullOrNil(paramView)) && (localArrayList != null) && (localArrayList.size() > 0)) {
        this.pzr.setText(j.b(this.mContext, bo.d(localArrayList, this.mContext.getResources().getString(2131298491))));
      }
    }
    AppMethodBeat.o(28070);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28069);
    if (this.ozm == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(2130970465, localViewGroup);
      this.ozm = paramViewGroup;
    }
    paramViewGroup = this.ozm;
    AppMethodBeat.o(28069);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.LabelPreference
 * JD-Core Version:    0.7.0.1
 */