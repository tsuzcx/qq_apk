package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class y$a
  extends c.a
{
  protected ImageView GHZ;
  protected TextView GIU;
  protected MMNeat7extView GLB;
  protected TextView qkL;
  protected ProgressBar uPp;
  
  public final a gb(View paramView)
  {
    AppMethodBeat.i(37056);
    super.fK(paramView);
    this.GLB = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
    this.GHZ = ((ImageView)paramView.findViewById(2131298174));
    this.qkL = ((TextView)paramView.findViewById(2131298044));
    this.GIU = ((TextView)paramView.findViewById(2131298023));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    AppMethodBeat.o(37056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */