package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class bw
  extends c.a
{
  TextView PRF;
  RelativeLayout PRG;
  TextView PRH;
  WeImageView PRI;
  ImageView gyr;
  TextView pIN;
  TextView titleTv;
  
  public final View getMainContainerView()
  {
    return this.PRG;
  }
  
  public final c.a hi(View paramView)
  {
    AppMethodBeat.i(233971);
    super.create(paramView);
    this.PRF = ((TextView)paramView.findViewById(2131298343));
    this.PRG = ((RelativeLayout)paramView.findViewById(2131298331));
    this.gyr = ((ImageView)paramView.findViewById(2131298325));
    this.pIN = ((TextView)paramView.findViewById(2131298340));
    this.PRH = ((TextView)paramView.findViewById(2131298341));
    this.PRI = ((WeImageView)paramView.findViewById(2131298326));
    this.titleTv = ((TextView)paramView.findViewById(2131298342));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(233971);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bw
 * JD-Core Version:    0.7.0.1
 */