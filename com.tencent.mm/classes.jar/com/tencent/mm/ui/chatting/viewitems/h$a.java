package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$a
  extends c.a
{
  public RelativeLayout PJP;
  public TextView PJQ;
  public ImageView PJR;
  public ImageView PJS;
  
  public final a gO(View paramView)
  {
    AppMethodBeat.i(36875);
    super.create(paramView);
    this.timeTV = ((TextView)this.convertView.findViewById(2131298558));
    this.checkBox = ((CheckBox)this.convertView.findViewById(2131298410));
    this.maskView = this.convertView.findViewById(2131298508);
    this.userTV = ((TextView)this.convertView.findViewById(2131298566));
    this.clickArea = this.convertView.findViewById(2131297022);
    this.PJP = ((RelativeLayout)this.convertView.findViewById(2131297021));
    this.PJQ = ((TextView)this.convertView.findViewById(2131297018));
    this.PJR = ((ImageView)this.convertView.findViewById(2131297019));
    this.PJS = ((ImageView)this.convertView.findViewById(2131297020));
    AppMethodBeat.o(36875);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.PJP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.a
 * JD-Core Version:    0.7.0.1
 */