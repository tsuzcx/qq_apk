package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.l;

final class n$a
  extends c.a
{
  public ImageView Ill;
  public ImageView Ilm;
  public TextView Iln;
  public ImageView Ilo;
  public TextView Ilp;
  public TextView Ilq;
  public ImageView Ilr;
  public ImageView Ils;
  
  public final a C(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163338);
    super.fX(paramView);
    this.Ilm = ((ImageView)paramView.findViewById(2131298122));
    this.Iln = ((TextView)paramView.findViewById(2131298126));
    this.Ilo = ((ImageView)paramView.findViewById(2131298128));
    this.Ilp = ((TextView)paramView.findViewById(2131298123));
    this.Ilq = ((TextView)paramView.findViewById(2131298127));
    this.Ilr = ((ImageView)paramView.findViewById(2131298124));
    this.Ils = ((ImageView)paramView.findViewById(2131298125));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    if (!((l)g.ad(l.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.ijt = ((CheckBox)paramView.findViewById(2131298068));
        this.gGk = paramView.findViewById(2131298147);
      }
      if (paramBoolean)
      {
        this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
        this.Ill = ((ImageView)paramView.findViewById(2131298176));
      }
      AppMethodBeat.o(163338);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.a
 * JD-Core Version:    0.7.0.1
 */