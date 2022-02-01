package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ad$f
  extends ad.b
{
  TextView ImT;
  View iSJ;
  ImageView nCl;
  ImageView nCx;
  MMNeat7extView nCy;
  View nDr;
  MMNeat7extView wff;
  ImageView wfg;
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.nBh != null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306453);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    localViewStub.inflate();
    this.nBh = paramView.findViewById(2131305992);
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305902));
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.nDr = this.nBh.findViewById(2131298818);
    this.iSJ = this.nBh.findViewById(2131297444);
    this.wff = ((MMNeat7extView)this.nBh.findViewById(2131305946));
    this.ImT = ((TextView)this.nBh.findViewById(2131299135));
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    this.wfg = ((ImageView)this.nBh.findViewById(2131298831));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.f
 * JD-Core Version:    0.7.0.1
 */