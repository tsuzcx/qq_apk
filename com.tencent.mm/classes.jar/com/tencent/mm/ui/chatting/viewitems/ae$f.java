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
  TextView KzJ;
  View joL;
  View oiA;
  ImageView oic;
  MMNeat7extView oip;
  ImageView oiq;
  MMNeat7extView xCL;
  ImageView xCM;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131305992);
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305902));
    this.oic = ((ImageView)this.oiV.findViewById(2131298813));
    this.oiA = this.oiV.findViewById(2131298818);
    this.joL = this.oiV.findViewById(2131297444);
    this.xCL = ((MMNeat7extView)this.oiV.findViewById(2131305946));
    this.KzJ = ((TextView)this.oiV.findViewById(2131299135));
    this.oiq = ((ImageView)this.oiV.findViewById(2131303387));
    this.xCM = ((ImageView)this.oiV.findViewById(2131298831));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.f
 * JD-Core Version:    0.7.0.1
 */