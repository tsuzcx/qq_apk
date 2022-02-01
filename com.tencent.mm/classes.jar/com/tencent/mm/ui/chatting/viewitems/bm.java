package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bm
  extends c.a
{
  protected TextView PQp;
  protected TextView PQq;
  protected Button PQr;
  protected Button PQs;
  protected ImageView PQt;
  protected TextView jBR;
  
  public final bm hh(View paramView)
  {
    AppMethodBeat.i(37551);
    super.create(paramView);
    this.jBR = ((TextView)paramView.findViewById(2131298367));
    this.PQp = ((TextView)paramView.findViewById(2131298366));
    this.PQq = ((TextView)paramView.findViewById(2131298389));
    this.PQr = ((Button)paramView.findViewById(2131298498));
    this.PQs = ((Button)paramView.findViewById(2131298497));
    this.PQt = ((ImageView)paramView.findViewById(2131298559));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bm
 * JD-Core Version:    0.7.0.1
 */