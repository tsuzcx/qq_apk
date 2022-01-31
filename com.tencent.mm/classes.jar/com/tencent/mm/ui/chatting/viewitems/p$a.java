package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;

final class p$a
  extends c.a
{
  public int zSN = 0;
  public ImageView zUn;
  public TextView zUo;
  public TextView zUp;
  
  public final a fg(View paramView)
  {
    AppMethodBeat.i(32986);
    super.eV(paramView);
    this.ekh = ((TextView)this.ngZ.findViewById(2131820587));
    this.mCC = ((CheckBox)this.ngZ.findViewById(2131820579));
    this.jbK = this.ngZ.findViewById(2131820586);
    this.qFY = ((TextView)this.ngZ.findViewById(2131821122));
    this.zUn = ((ImageView)this.ngZ.findViewById(2131822650));
    this.zUo = ((TextView)this.ngZ.findViewById(2131822652));
    this.zUp = ((TextView)this.ngZ.findViewById(2131822651));
    this.zSN = c.io(ah.getContext());
    this.zUp.setTypeface(((com.tencent.mm.pluginsdk.wallet.c)g.E(com.tencent.mm.pluginsdk.wallet.c.class)).eA(this.ngZ.getContext()));
    AppMethodBeat.o(32986);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.a
 * JD-Core Version:    0.7.0.1
 */