package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class bq
  extends c.a
{
  TextView KER;
  RelativeLayout KES;
  TextView KET;
  WeImageView KEU;
  ImageView fTj;
  TextView ovs;
  TextView titleTv;
  
  public final c.a gS(View paramView)
  {
    AppMethodBeat.i(187916);
    super.gs(paramView);
    this.KER = ((TextView)paramView.findViewById(2131298003));
    this.KES = ((RelativeLayout)paramView.findViewById(2131297991));
    this.fTj = ((ImageView)paramView.findViewById(2131297985));
    this.ovs = ((TextView)paramView.findViewById(2131298000));
    this.KET = ((TextView)paramView.findViewById(2131298001));
    this.KEU = ((WeImageView)paramView.findViewById(2131297986));
    this.titleTv = ((TextView)paramView.findViewById(2131298002));
    this.hcH = paramView.findViewById(2131298147);
    AppMethodBeat.o(187916);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bq
 * JD-Core Version:    0.7.0.1
 */