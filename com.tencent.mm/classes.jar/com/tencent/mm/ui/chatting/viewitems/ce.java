package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class ce
  extends c.a
{
  TextView XnT;
  RelativeLayout XnU;
  TextView XnV;
  WeImageView XnW;
  ImageView jiu;
  TextView titleTv;
  TextView xoK;
  
  public final View getMainContainerView()
  {
    return this.XnU;
  }
  
  public final c.a iu(View paramView)
  {
    AppMethodBeat.i(268231);
    super.create(paramView);
    this.XnT = ((TextView)paramView.findViewById(R.h.dvR));
    this.XnU = ((RelativeLayout)paramView.findViewById(R.h.dvG));
    this.jiu = ((ImageView)paramView.findViewById(R.h.dvA));
    this.xoK = ((TextView)paramView.findViewById(R.h.dvO));
    this.XnV = ((TextView)paramView.findViewById(R.h.dvP));
    this.XnW = ((WeImageView)paramView.findViewById(R.h.dvB));
    this.titleTv = ((TextView)paramView.findViewById(R.h.dvQ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(268231);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ce
 * JD-Core Version:    0.7.0.1
 */