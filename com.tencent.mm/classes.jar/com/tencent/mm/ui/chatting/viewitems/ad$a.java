package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$a
  extends c.a
{
  protected ImageView gxs;
  protected TextView zWi;
  
  ad$a(ad paramad) {}
  
  public final a fo(View paramView)
  {
    AppMethodBeat.i(33224);
    super.eV(paramView);
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.gxs = ((ImageView)paramView.findViewById(2131822715));
    this.zWi = ((TextView)paramView.findViewById(2131822707));
    AppMethodBeat.o(33224);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.a
 * JD-Core Version:    0.7.0.1
 */