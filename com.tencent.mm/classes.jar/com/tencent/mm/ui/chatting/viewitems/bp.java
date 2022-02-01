package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class bp
  extends c.a
{
  TextView IrS;
  RelativeLayout IrT;
  TextView IrU;
  WeImageView IrV;
  ImageView fxQ;
  TextView nMU;
  TextView titleTv;
  
  public final c.a gw(View paramView)
  {
    AppMethodBeat.i(196726);
    super.fX(paramView);
    this.IrS = ((TextView)paramView.findViewById(2131298003));
    this.IrT = ((RelativeLayout)paramView.findViewById(2131297991));
    this.fxQ = ((ImageView)paramView.findViewById(2131297985));
    this.nMU = ((TextView)paramView.findViewById(2131298000));
    this.IrU = ((TextView)paramView.findViewById(2131298001));
    this.IrV = ((WeImageView)paramView.findViewById(2131297986));
    this.titleTv = ((TextView)paramView.findViewById(2131298002));
    this.gGk = paramView.findViewById(2131298147);
    AppMethodBeat.o(196726);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp
 * JD-Core Version:    0.7.0.1
 */