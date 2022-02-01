package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class i$a
  extends c.a
{
  public RelativeLayout Xfp;
  public TextView Xfq;
  public ImageView Xfr;
  public ImageView Xfs;
  
  public final View getMainContainerView()
  {
    return this.Xfp;
  }
  
  public final a ia(View paramView)
  {
    AppMethodBeat.i(36875);
    super.create(paramView);
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.dzs));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.dwZ));
    this.maskView = this.convertView.findViewById(R.h.dyD);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.chatting_user_tv));
    this.clickArea = this.convertView.findViewById(R.h.drF);
    this.Xfp = ((RelativeLayout)this.convertView.findViewById(R.h.drE));
    this.Xfq = ((TextView)this.convertView.findViewById(R.h.drB));
    this.Xfr = ((ImageView)this.convertView.findViewById(R.h.drC));
    this.Xfs = ((ImageView)this.convertView.findViewById(R.h.drD));
    AppMethodBeat.o(36875);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */