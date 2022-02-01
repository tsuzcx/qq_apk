package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class bo
  extends c.a
{
  TextView GRR;
  RelativeLayout GRS;
  TextView GRT;
  WeImageView GRU;
  ImageView fuj;
  TextView nkb;
  TextView titleTv;
  
  public final c.a gj(View paramView)
  {
    AppMethodBeat.i(191648);
    super.fK(paramView);
    this.GRR = ((TextView)paramView.findViewById(2131298003));
    this.GRS = ((RelativeLayout)paramView.findViewById(2131297991));
    this.fuj = ((ImageView)paramView.findViewById(2131297985));
    this.nkb = ((TextView)paramView.findViewById(2131298000));
    this.GRT = ((TextView)paramView.findViewById(2131298001));
    this.GRU = ((WeImageView)paramView.findViewById(2131297986));
    this.titleTv = ((TextView)paramView.findViewById(2131298002));
    this.lRB = paramView.findViewById(2131298147);
    AppMethodBeat.o(191648);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bo
 * JD-Core Version:    0.7.0.1
 */