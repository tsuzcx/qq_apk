package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class br
  extends c.a
{
  protected TextView Xmr;
  protected TextView Xms;
  protected Button Xmt;
  protected Button Xmu;
  protected ImageView Xmv;
  protected TextView mrM;
  
  public final br it(View paramView)
  {
    AppMethodBeat.i(37551);
    super.create(paramView);
    this.mrM = ((TextView)paramView.findViewById(R.h.dwq));
    this.Xmr = ((TextView)paramView.findViewById(R.h.dwo));
    this.Xms = ((TextView)paramView.findViewById(R.h.dwM));
    this.Xmt = ((Button)paramView.findViewById(R.h.dyt));
    this.Xmu = ((Button)paramView.findViewById(R.h.dys));
    this.Xmv = ((ImageView)paramView.findViewById(R.h.dzt));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.br
 * JD-Core Version:    0.7.0.1
 */