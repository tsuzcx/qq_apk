package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ai;

final class x$a
  extends c.a
{
  public int IjS = 0;
  public ImageView Imn;
  public TextView Imo;
  public TextView Imp;
  public ImageView Imq;
  public View ofC;
  
  public final a gn(View paramView)
  {
    AppMethodBeat.i(37043);
    super.fX(paramView);
    this.fAz = ((TextView)this.sSS.findViewById(2131298178));
    this.ijt = ((CheckBox)this.sSS.findViewById(2131298068));
    this.gGk = this.sSS.findViewById(2131298147);
    this.xpH = ((TextView)this.sSS.findViewById(2131298185));
    this.ofC = this.sSS.findViewById(2131300196);
    this.Imq = ((ImageView)this.sSS.findViewById(2131299154));
    this.Imn = ((ImageView)this.sSS.findViewById(2131296930));
    this.Imo = ((TextView)this.sSS.findViewById(2131296931));
    this.Imp = ((TextView)this.sSS.findViewById(2131296929));
    this.IjS = c.kb(ai.getContext());
    this.Imp.setTypeface(((b)g.ab(b.class)).fK(this.sSS.getContext()));
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a
 * JD-Core Version:    0.7.0.1
 */