package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ak$e
  extends ak.b
{
  TextView PMd;
  MMNeat7extView PMk;
  View PMl;
  ImageView kc;
  ImageView ptE;
  ImageView ptS;
  View puc;
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.puO != null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131309894);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    localViewStub.inflate();
    this.puO = paramView.findViewById(2131298457);
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.ptG = ((ImageView)this.puO.findViewById(2131299291));
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    this.kc = ((ImageView)this.puO.findViewById(2131305927));
    this.puc = this.puO.findViewById(2131298538);
    this.PMd = ((TextView)this.puO.findViewById(2131305934));
    this.PMk = ((MMNeat7extView)this.puO.findViewById(2131307913));
    this.PMl = this.puO.findViewById(2131307916);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.e
 * JD-Core Version:    0.7.0.1
 */