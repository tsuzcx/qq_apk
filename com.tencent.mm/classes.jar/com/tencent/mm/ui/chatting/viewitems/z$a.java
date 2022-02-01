package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class z$a
  extends c.a
{
  protected ImageView IhW;
  protected TextView IiR;
  protected MMNeat7extView Ily;
  protected TextView qTn;
  
  public final a go(View paramView)
  {
    AppMethodBeat.i(37056);
    super.fX(paramView);
    this.Ily = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
    this.IhW = ((ImageView)paramView.findViewById(2131298174));
    this.qTn = ((TextView)paramView.findViewById(2131298044));
    this.IiR = ((TextView)paramView.findViewById(2131298023));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    AppMethodBeat.o(37056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */