package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.j;

final class p$a
  extends c.a
{
  public ImageView GLo;
  public TextView GLs;
  public ImageView GLu;
  public View GLw;
  public TextView GLx;
  
  public final a E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163364);
    super.fK(paramView);
    this.GLx = ((TextView)paramView.findViewById(2131298129));
    this.GLu = ((ImageView)paramView.findViewById(2131298131));
    this.GLs = ((TextView)paramView.findViewById(2131298130));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    ((j)g.ad(j.class)).showFinderEntry();
    if (paramBoolean)
    {
      this.GLw = paramView.findViewById(2131306220);
      this.GLo = ((ImageView)paramView.findViewById(2131298176));
    }
    AppMethodBeat.o(163364);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.a
 * JD-Core Version:    0.7.0.1
 */