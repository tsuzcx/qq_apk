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
  View oiA;
  ImageView oic;
  MMNeat7extView oip;
  ImageView oiq;
  TextView timeTv;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131298111);
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.oie = ((ImageView)this.oiV.findViewById(2131298826));
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    this.ka = ((ImageView)this.oiV.findViewById(2131306344));
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305948));
    this.timeTv = ((TextView)this.oiV.findViewById(2131305822));
    this.oiA = this.oiV.findViewById(2131298187);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.h
 * JD-Core Version:    0.7.0.1
 */