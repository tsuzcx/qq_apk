package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bf
  extends c.a
{
  protected TextView IqC;
  protected TextView IqD;
  protected Button IqE;
  protected Button IqF;
  protected ImageView IqG;
  protected TextView ijE;
  
  public final bf gv(View paramView)
  {
    AppMethodBeat.i(37551);
    super.fX(paramView);
    this.ijE = ((TextView)paramView.findViewById(2131298026));
    this.IqC = ((TextView)paramView.findViewById(2131298025));
    this.IqD = ((TextView)paramView.findViewById(2131298048));
    this.IqE = ((Button)paramView.findViewById(2131298137));
    this.IqF = ((Button)paramView.findViewById(2131298136));
    this.IqG = ((ImageView)paramView.findViewById(2131298179));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */