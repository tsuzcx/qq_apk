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
  public RelativeLayout aePs;
  public TextView aePt;
  public ImageView aePu;
  public ImageView aePv;
  
  public final View getMainContainerView()
  {
    return this.aePs;
  }
  
  public final a lw(View paramView)
  {
    AppMethodBeat.i(36875);
    super.create(paramView);
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.fxt));
    this.maskView = this.convertView.findViewById(R.h.fzn);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
    this.clickArea = this.convertView.findViewById(R.h.frX);
    this.aePs = ((RelativeLayout)this.convertView.findViewById(R.h.frW));
    this.aePt = ((TextView)this.convertView.findViewById(R.h.frT));
    this.aePu = ((ImageView)this.convertView.findViewById(R.h.frU));
    this.aePv = ((ImageView)this.convertView.findViewById(R.h.frV));
    AppMethodBeat.o(36875);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */