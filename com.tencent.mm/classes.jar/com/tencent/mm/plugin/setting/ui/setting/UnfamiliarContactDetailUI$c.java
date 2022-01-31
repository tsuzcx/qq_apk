package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MaskLayout;

final class UnfamiliarContactDetailUI$c
  extends RecyclerView.v
{
  View aku;
  MaskLayout ejS;
  TextView kgG;
  CheckBox mCC;
  TextView qLp;
  ImageView qLq;
  ImageView qLr;
  LinearLayout qLs;
  LinearLayout qLt;
  
  public UnfamiliarContactDetailUI$c(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(127660);
    this.aku = paramView;
    this.ejS = ((MaskLayout)paramView.findViewById(2131828663));
    this.kgG = ((TextView)paramView.findViewById(2131828664));
    this.qLp = ((TextView)paramView.findViewById(2131828662));
    this.qLq = ((ImageView)paramView.findViewById(2131828665));
    this.qLr = ((ImageView)paramView.findViewById(2131828666));
    this.qLs = ((LinearLayout)paramView.findViewById(2131828667));
    this.mCC = ((CheckBox)paramView.findViewById(2131820950));
    this.qLt = ((LinearLayout)paramView.findViewById(2131823590));
    this.qLs.setOnClickListener(new UnfamiliarContactDetailUI.c.1(this, paramUnfamiliarContactDetailUI));
    paramView.setOnClickListener(new UnfamiliarContactDetailUI.c.2(this, paramUnfamiliarContactDetailUI));
    AppMethodBeat.o(127660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c
 * JD-Core Version:    0.7.0.1
 */