package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.l;

final class p$a
  extends c.a
{
  public ImageView Ill;
  public TextView Ilp;
  public ImageView Ilr;
  public TextView Ilu;
  
  public final a E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163364);
    super.fX(paramView);
    this.Ilu = ((TextView)paramView.findViewById(2131298129));
    this.Ilr = ((ImageView)paramView.findViewById(2131298131));
    this.Ilp = ((TextView)paramView.findViewById(2131298130));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    ((l)g.ad(l.class)).showFinderEntry();
    if (paramBoolean)
    {
      this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
      this.Ill = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(163364);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.a
 * JD-Core Version:    0.7.0.1
 */