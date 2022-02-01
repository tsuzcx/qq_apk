package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$a
  extends c.a
{
  public ImageView Ill;
  TextView fuZ;
  ImageView fxQ;
  TextView rFt;
  ImageView rqZ;
  
  public final a D(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163352);
    super.fX(paramView);
    this.fxQ = ((ImageView)paramView.findViewById(2131299973));
    this.fuZ = ((TextView)paramView.findViewById(2131300019));
    this.rqZ = ((ImageView)paramView.findViewById(2131300003));
    this.rFt = ((TextView)paramView.findViewById(2131300004));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    if (paramBoolean)
    {
      this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
      this.Ill = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(163352);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.a
 * JD-Core Version:    0.7.0.1
 */