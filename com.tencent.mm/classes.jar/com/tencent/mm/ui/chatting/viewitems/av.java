package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class av
  extends c.a
{
  protected TextView gpM;
  protected TextView zYq;
  protected TextView zYr;
  protected Button zYs;
  protected Button zYt;
  protected ImageView zYu;
  
  public final av fq(View paramView)
  {
    AppMethodBeat.i(33441);
    super.eV(paramView);
    this.gpM = ((TextView)paramView.findViewById(2131822598));
    this.zYq = ((TextView)paramView.findViewById(2131822749));
    this.zYr = ((TextView)paramView.findViewById(2131822750));
    this.zYs = ((Button)paramView.findViewById(2131822751));
    this.zYt = ((Button)paramView.findViewById(2131822752));
    this.zYu = ((ImageView)paramView.findViewById(2131822753));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    AppMethodBeat.o(33441);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */