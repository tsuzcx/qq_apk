package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae$d
  extends ae.b
{
  ImageView ocn;
  ImageView oeW;
  TextView ofN;
  ImageView ofO;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.odh != null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306450);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    localViewStub.inflate();
    this.odh = paramView.findViewById(2131298105);
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.gnM = ((TextView)this.odh.findViewById(2131305902));
    this.ofN = ((TextView)this.odh.findViewById(2131303307));
    this.oeW = ((ImageView)this.odh.findViewById(2131303284));
    this.ofO = ((ImageView)this.odh.findViewById(2131306868));
    this.ocp = ((ImageView)this.odh.findViewById(2131298826));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.d
 * JD-Core Version:    0.7.0.1
 */