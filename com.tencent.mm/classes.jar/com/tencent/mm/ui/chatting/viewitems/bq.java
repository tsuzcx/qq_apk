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
  WeImageView KiA;
  TextView Kix;
  RelativeLayout Kiy;
  TextView Kiz;
  ImageView fRd;
  TextView opA;
  TextView titleTv;
  
  public final c.a gN(View paramView)
  {
    AppMethodBeat.i(194515);
    super.gn(paramView);
    this.Kix = ((TextView)paramView.findViewById(2131298003));
    this.Kiy = ((RelativeLayout)paramView.findViewById(2131297991));
    this.fRd = ((ImageView)paramView.findViewById(2131297985));
    this.opA = ((TextView)paramView.findViewById(2131298000));
    this.Kiz = ((TextView)paramView.findViewById(2131298001));
    this.KiA = ((WeImageView)paramView.findViewById(2131297986));
    this.titleTv = ((TextView)paramView.findViewById(2131298002));
    this.gZU = paramView.findViewById(2131298147);
    AppMethodBeat.o(194515);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bq
 * JD-Core Version:    0.7.0.1
 */