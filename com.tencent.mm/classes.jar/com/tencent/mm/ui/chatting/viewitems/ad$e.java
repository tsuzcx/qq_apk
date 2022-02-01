package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$e
  extends ad.b
{
  ImageView ig;
  ImageView nCl;
  ImageView nCx;
  View nDr;
  ImageView wfg;
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.nBh != null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306451);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    localViewStub.inflate();
    this.nBh = paramView.findViewById(2131298107);
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.nCw = ((ImageView)this.nBh.findViewById(2131298826));
    this.nCx = ((ImageView)this.nBh.findViewById(2131303387));
    this.wfg = ((ImageView)this.nBh.findViewById(2131298831));
    this.ig = ((ImageView)this.nBh.findViewById(2131303256));
    this.nDr = this.nBh.findViewById(2131298160);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.e
 * JD-Core Version:    0.7.0.1
 */