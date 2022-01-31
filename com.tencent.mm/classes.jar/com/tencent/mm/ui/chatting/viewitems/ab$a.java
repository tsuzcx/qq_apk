package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab$a
  extends c.a
{
  protected TextView zVY;
  protected TextView zVZ;
  protected TextView zWa;
  protected TextView zWb;
  protected TextView zWc;
  protected TextView zWd;
  protected ImageView zWe;
  
  ab$a(ab paramab) {}
  
  public final a fm(View paramView)
  {
    AppMethodBeat.i(33212);
    super.eV(paramView);
    this.zVY = ((TextView)paramView.findViewById(2131822710));
    this.zWa = ((TextView)paramView.findViewById(2131822708));
    this.zVZ = ((TextView)paramView.findViewById(2131822711));
    this.zWb = ((TextView)paramView.findViewById(2131822709));
    this.zWc = ((TextView)paramView.findViewById(2131822714));
    this.zWd = ((TextView)paramView.findViewById(2131822712));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.zWe = ((ImageView)paramView.findViewById(2131822713));
    AppMethodBeat.o(33212);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.a
 * JD-Core Version:    0.7.0.1
 */