package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ad$h
  extends ad.b
{
  ImageView ig;
  ImageView nCl;
  ImageView nCx;
  MMNeat7extView nCy;
  View nDr;
  TextView timeTv;
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.nBh != null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306455);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    localViewStub.inflate();
    this.nBh = paramView.findViewById(2131298111);
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.nCw = ((ImageView)this.nBh.findViewById(2131298826));
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    this.ig = ((ImageView)this.nBh.findViewById(2131306344));
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305948));
    this.timeTv = ((TextView)this.nBh.findViewById(2131305822));
    this.nDr = this.nBh.findViewById(2131298187);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.h
 * JD-Core Version:    0.7.0.1
 */