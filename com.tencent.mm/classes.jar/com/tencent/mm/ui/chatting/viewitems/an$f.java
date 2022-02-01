package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class an$f
  extends an.b
{
  MMNeat7extView HyN;
  ImageView HyO;
  TextView Xig;
  View neN;
  ImageView sCR;
  MMNeat7extView sDe;
  ImageView sDf;
  View sDp;
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.sEi != null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.dZy);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    localViewStub.inflate();
    this.sEi = paramView.findViewById(R.h.dXU);
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(R.h.title));
    this.sCR = ((ImageView)this.sEi.findViewById(R.h.cover));
    this.sDp = this.sEi.findViewById(R.h.dCU);
    this.neN = this.sEi.findViewById(R.h.duA);
    this.HyN = ((MMNeat7extView)this.sEi.findViewById(R.h.dXy));
    this.Xig = ((TextView)this.sEi.findViewById(R.h.dEM));
    this.sDf = ((ImageView)this.sEi.findViewById(R.h.dRn));
    this.HyO = ((ImageView)this.sEi.findViewById(R.h.dCW));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.f
 * JD-Core Version:    0.7.0.1
 */