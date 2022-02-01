package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class an$h
  extends an.b
{
  ImageView bwJ;
  ImageView sCR;
  MMNeat7extView sDe;
  ImageView sDf;
  View sDp;
  TextView timeTv;
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.sEi != null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.dZA);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    localViewStub.inflate();
    this.sEi = paramView.findViewById(R.h.dxQ);
    this.sCR = ((ImageView)this.sEi.findViewById(R.h.cover));
    this.sCT = ((ImageView)this.sEi.findViewById(R.h.dCV));
    this.sDf = ((ImageView)this.sEi.findViewById(R.h.dRn));
    this.bwJ = ((ImageView)this.sEi.findViewById(R.h.video_icon));
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(R.h.title_tv));
    this.timeTv = ((TextView)this.sEi.findViewById(R.h.time_tv));
    this.sDp = this.sEi.findViewById(R.h.dzy);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.h
 * JD-Core Version:    0.7.0.1
 */