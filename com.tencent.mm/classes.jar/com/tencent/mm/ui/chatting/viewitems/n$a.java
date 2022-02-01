package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.j;

final class n$a
  extends c.a
{
  public ImageView GLo;
  public ImageView GLp;
  public TextView GLq;
  public ImageView GLr;
  public TextView GLs;
  public TextView GLt;
  public ImageView GLu;
  public ImageView GLv;
  public View GLw;
  
  public final a C(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163338);
    super.fK(paramView);
    this.GLp = ((ImageView)paramView.findViewById(2131298122));
    this.GLq = ((TextView)paramView.findViewById(2131298126));
    this.GLr = ((ImageView)paramView.findViewById(2131298128));
    this.GLs = ((TextView)paramView.findViewById(2131298123));
    this.GLt = ((TextView)paramView.findViewById(2131298127));
    this.GLu = ((ImageView)paramView.findViewById(2131298124));
    this.GLv = ((ImageView)paramView.findViewById(2131298125));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    if (!((j)g.ad(j.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.hIS = ((CheckBox)paramView.findViewById(2131298068));
        this.lRB = paramView.findViewById(2131298147);
      }
      if (paramBoolean)
      {
        this.GLw = paramView.findViewById(2131306220);
        this.GLo = ((ImageView)paramView.findViewById(2131298176));
      }
      AppMethodBeat.o(163338);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.a
 * JD-Core Version:    0.7.0.1
 */