package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class m$a
  extends c.a
{
  public int GJV;
  ImageView GLl;
  TextView GLm;
  TextView GLn;
  public ImageView GLo;
  TextView frs;
  
  public final a B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.fK(paramView);
    this.GLl = ((ImageView)this.rLd.findViewById(2131298057));
    this.fwS = ((TextView)this.rLd.findViewById(2131298178));
    this.GLm = ((TextView)this.rLd.findViewById(2131298182));
    this.GLn = ((TextView)this.rLd.findViewById(2131298186));
    this.frs = ((TextView)this.rLd.findViewById(2131298152));
    this.wet = ((TextView)this.rLd.findViewById(2131298185));
    this.naN = this.rLd.findViewById(2131298069);
    this.lRB = this.rLd.findViewById(2131298147);
    if (paramBoolean)
    {
      this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
      this.GLo = ((ImageView)paramView.findViewById(2131298176));
    }
    this.GJV = c.jQ(aj.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */