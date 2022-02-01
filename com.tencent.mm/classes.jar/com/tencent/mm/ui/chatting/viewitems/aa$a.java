package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class aa$a
  extends c.a
{
  protected ImageView JYs;
  protected TextView JZp;
  protected MMNeat7extView KbY;
  protected TextView rDq;
  
  public final a gF(View paramView)
  {
    AppMethodBeat.i(37056);
    super.gn(paramView);
    this.KbY = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
    this.JYs = ((ImageView)paramView.findViewById(2131298174));
    this.rDq = ((TextView)paramView.findViewById(2131298044));
    this.JZp = ((TextView)paramView.findViewById(2131298023));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    AppMethodBeat.o(37056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */