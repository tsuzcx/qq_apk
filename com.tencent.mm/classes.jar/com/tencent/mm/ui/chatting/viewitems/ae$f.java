package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ae$f
  extends ae.b
{
  TextView Kdr;
  View jlR;
  MMNeat7extView ocA;
  ImageView ocB;
  View ocL;
  ImageView ocn;
  MMNeat7extView xmO;
  ImageView xmP;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.odh != null)
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
    this.odh = paramView.findViewById(2131305992);
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305902));
    this.ocn = ((ImageView)this.odh.findViewById(2131298813));
    this.ocL = this.odh.findViewById(2131298818);
    this.jlR = this.odh.findViewById(2131297444);
    this.xmO = ((MMNeat7extView)this.odh.findViewById(2131305946));
    this.Kdr = ((TextView)this.odh.findViewById(2131299135));
    this.ocB = ((ImageView)this.odh.findViewById(2131303387));
    this.xmP = ((ImageView)this.odh.findViewById(2131298831));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.f
 * JD-Core Version:    0.7.0.1
 */