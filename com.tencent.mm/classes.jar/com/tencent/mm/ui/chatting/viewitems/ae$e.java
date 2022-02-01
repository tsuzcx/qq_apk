package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae$e
  extends ae.b
{
  ImageView ka;
  ImageView ocB;
  View ocL;
  ImageView ocn;
  ImageView xmP;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.odh != null)
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
    this.odh = paramView.findViewById(2131298107);
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.ocp = ((ImageView)this.odh.findViewById(2131298826));
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    this.xmP = ((ImageView)this.odh.findViewById(2131298831));
    this.ka = ((ImageView)this.odh.findViewById(2131303256));
    this.ocL = this.odh.findViewById(2131298160);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.e
 * JD-Core Version:    0.7.0.1
 */