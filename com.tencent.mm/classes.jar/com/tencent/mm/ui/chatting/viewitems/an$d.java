package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class an$d
  extends an.b
{
  ImageView sCR;
  ImageView sGV;
  TextView sHM;
  ImageView sHN;
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.sEi != null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.dZw);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    localViewStub.inflate();
    this.sEi = paramView.findViewById(R.h.dxN);
    this.sCR = ((ImageView)this.sEi.findViewById(R.h.cover));
    this.jMg = ((TextView)this.sEi.findViewById(R.h.title));
    this.sHM = ((TextView)this.sEi.findViewById(R.h.dRi));
    this.sGV = ((ImageView)this.sEi.findViewById(R.h.play_icon));
    this.sHN = ((ImageView)this.sEi.findViewById(R.h.eaw));
    this.sCT = ((ImageView)this.sEi.findViewById(R.h.dCV));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.d
 * JD-Core Version:    0.7.0.1
 */