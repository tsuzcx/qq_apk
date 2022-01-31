package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bf
  extends c.a
{
  protected TextView gpM;
  protected ImageView zZI;
  
  public final bf fr(View paramView)
  {
    AppMethodBeat.i(33454);
    super.eV(paramView);
    this.gpM = ((TextView)paramView.findViewById(2131822598));
    this.zZI = ((ImageView)paramView.findViewById(2131822600));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    AppMethodBeat.o(33454);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */