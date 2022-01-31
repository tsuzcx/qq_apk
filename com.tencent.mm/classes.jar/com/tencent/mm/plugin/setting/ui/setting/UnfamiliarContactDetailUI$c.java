package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.ui.base.MaskLayout;

final class UnfamiliarContactDetailUI$c
  extends RecyclerView.v
{
  View aie;
  MaskLayout dsk;
  CheckBox khV;
  TextView nXe;
  TextView nXf;
  ImageView nXg;
  ImageView nXh;
  LinearLayout nXi;
  LinearLayout nXj;
  
  public UnfamiliarContactDetailUI$c(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI, View paramView)
  {
    super(paramView);
    this.aie = paramView;
    this.dsk = ((MaskLayout)paramView.findViewById(a.f.contact_avatar));
    this.nXe = ((TextView)paramView.findViewById(a.f.contact_nick));
    this.nXf = ((TextView)paramView.findViewById(a.f.contact_alphabet));
    this.nXg = ((ImageView)paramView.findViewById(a.f.contact_sns_notreceive_iv));
    this.nXh = ((ImageView)paramView.findViewById(a.f.contact_sns_notvisible_iv));
    this.nXi = ((LinearLayout)paramView.findViewById(a.f.checkbox_area));
    this.khV = ((CheckBox)paramView.findViewById(a.f.checkbox));
    this.nXj = ((LinearLayout)paramView.findViewById(a.f.item_content));
    this.nXi.setOnClickListener(new UnfamiliarContactDetailUI.c.1(this, paramUnfamiliarContactDetailUI));
    paramView.setOnClickListener(new UnfamiliarContactDetailUI.c.2(this, paramUnfamiliarContactDetailUI));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c
 * JD-Core Version:    0.7.0.1
 */