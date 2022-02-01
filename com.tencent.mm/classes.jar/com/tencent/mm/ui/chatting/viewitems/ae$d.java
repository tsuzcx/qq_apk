package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae$d
  extends ae.b
{
  ImageView oic;
  ImageView okW;
  TextView olL;
  ImageView olM;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131298105);
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.gqi = ((TextView)this.oiV.findViewById(2131305902));
    this.olL = ((TextView)this.oiV.findViewById(2131303307));
    this.okW = ((ImageView)this.oiV.findViewById(2131303284));
    this.olM = ((ImageView)this.oiV.findViewById(2131306868));
    this.oie = ((ImageView)this.oiV.findViewById(2131298826));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.d
 * JD-Core Version:    0.7.0.1
 */