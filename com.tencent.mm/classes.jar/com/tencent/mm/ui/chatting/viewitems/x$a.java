package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.aj;

final class x$a
  extends c.a
{
  public int GJV = 0;
  public ImageView GMq;
  public TextView GMr;
  public TextView GMs;
  public ImageView GMt;
  public View nCB;
  
  public final a ga(View paramView)
  {
    AppMethodBeat.i(37043);
    super.fK(paramView);
    this.fwS = ((TextView)this.rLd.findViewById(2131298178));
    this.hIS = ((CheckBox)this.rLd.findViewById(2131298068));
    this.lRB = this.rLd.findViewById(2131298147);
    this.wet = ((TextView)this.rLd.findViewById(2131298185));
    this.nCB = this.rLd.findViewById(2131300196);
    this.GMt = ((ImageView)this.rLd.findViewById(2131299154));
    this.GMq = ((ImageView)this.rLd.findViewById(2131296930));
    this.GMr = ((TextView)this.rLd.findViewById(2131296931));
    this.GMs = ((TextView)this.rLd.findViewById(2131296929));
    this.GJV = c.jQ(aj.getContext());
    this.GMs.setTypeface(((b)g.ab(b.class)).fy(this.rLd.getContext()));
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a
 * JD-Core Version:    0.7.0.1
 */