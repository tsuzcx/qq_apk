package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class be
  extends c.a
{
  protected TextView GQB;
  protected TextView GQC;
  protected Button GQD;
  protected Button GQE;
  protected ImageView GQF;
  protected TextView hJe;
  
  public final be gi(View paramView)
  {
    AppMethodBeat.i(37551);
    super.fK(paramView);
    this.hJe = ((TextView)paramView.findViewById(2131298026));
    this.GQB = ((TextView)paramView.findViewById(2131298025));
    this.GQC = ((TextView)paramView.findViewById(2131298048));
    this.GQD = ((Button)paramView.findViewById(2131298137));
    this.GQE = ((Button)paramView.findViewById(2131298136));
    this.GQF = ((ImageView)paramView.findViewById(2131298179));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be
 * JD-Core Version:    0.7.0.1
 */