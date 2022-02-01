package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ae$h
  extends ae.b
{
  ImageView ka;
  MMNeat7extView ocA;
  ImageView ocB;
  View ocL;
  ImageView ocn;
  TextView timeTv;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.odh != null)
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
    this.odh = paramView.findViewById(2131298111);
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.ocp = ((ImageView)this.odh.findViewById(2131298826));
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    this.ka = ((ImageView)this.odh.findViewById(2131306344));
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305948));
    this.timeTv = ((TextView)this.odh.findViewById(2131305822));
    this.ocL = this.odh.findViewById(2131298187);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.h
 * JD-Core Version:    0.7.0.1
 */