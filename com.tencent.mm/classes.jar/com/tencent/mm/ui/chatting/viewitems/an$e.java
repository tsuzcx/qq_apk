package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class an$e
  extends an.b
{
  TextView XhX;
  MMNeat7extView Xie;
  View Xif;
  ImageView bwJ;
  ImageView sCR;
  ImageView sDf;
  View sDp;
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.sEi != null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.dZx);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    localViewStub.inflate();
    this.sEi = paramView.findViewById(R.h.dxO);
    this.sCR = ((ImageView)this.sEi.findViewById(R.h.cover));
    this.sCT = ((ImageView)this.sEi.findViewById(R.h.dCV));
    this.sDf = ((ImageView)this.sEi.findViewById(R.h.dRn));
    this.bwJ = ((ImageView)this.sEi.findViewById(R.h.dRf));
    this.sDp = this.sEi.findViewById(R.h.dza);
    this.XhX = ((TextView)this.sEi.findViewById(R.h.dRg));
    this.Xie = ((MMNeat7extView)this.sEi.findViewById(R.h.dVp));
    this.Xif = this.sEi.findViewById(R.h.dVq);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.e
 * JD-Core Version:    0.7.0.1
 */