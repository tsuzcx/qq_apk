package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class cf
  extends c.a
{
  TextView aeZc;
  RelativeLayout aeZd;
  TextView aeZe;
  WeImageView aeZf;
  ImageView lKK;
  TextView nicknameTv;
  TextView titleTv;
  
  public final View getMainContainerView()
  {
    return this.aeZd;
  }
  
  public final c.a lR(View paramView)
  {
    AppMethodBeat.i(255232);
    super.create(paramView);
    this.aeZc = ((TextView)paramView.findViewById(R.h.fwi));
    this.aeZd = ((RelativeLayout)paramView.findViewById(R.h.fvX));
    this.lKK = ((ImageView)paramView.findViewById(R.h.fvR));
    this.nicknameTv = ((TextView)paramView.findViewById(R.h.fwf));
    this.aeZe = ((TextView)paramView.findViewById(R.h.fwg));
    this.aeZf = ((WeImageView)paramView.findViewById(R.h.fvS));
    this.titleTv = ((TextView)paramView.findViewById(R.h.fwh));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(255232);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.cf
 * JD-Core Version:    0.7.0.1
 */