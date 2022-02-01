package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bp
  extends c.a
{
  protected ImageView GRV;
  protected TextView hJe;
  
  public final bp gk(View paramView)
  {
    AppMethodBeat.i(37564);
    super.fK(paramView);
    this.hJe = ((TextView)paramView.findViewById(2131298026));
    this.GRV = ((ImageView)paramView.findViewById(2131298047));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    AppMethodBeat.o(37564);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp
 * JD-Core Version:    0.7.0.1
 */