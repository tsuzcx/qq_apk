package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae$e
  extends ae.b
{
  ImageView ka;
  View oiA;
  ImageView oic;
  ImageView oiq;
  ImageView xCM;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131298107);
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.oie = ((ImageView)this.oiV.findViewById(2131298826));
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    this.xCM = ((ImageView)this.oiV.findViewById(2131298831));
    this.ka = ((ImageView)this.oiV.findViewById(2131303256));
    this.oiA = this.oiV.findViewById(2131298160);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.e
 * JD-Core Version:    0.7.0.1
 */