package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ak$h
  extends ak.b
{
  ImageView kc;
  ImageView ptE;
  MMNeat7extView ptR;
  ImageView ptS;
  View puc;
  TextView timeTv;
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.puO != null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131309898);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    localViewStub.inflate();
    this.puO = paramView.findViewById(2131298461);
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.ptG = ((ImageView)this.puO.findViewById(2131299291));
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    this.kc = ((ImageView)this.puO.findViewById(2131309770));
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309249));
    this.timeTv = ((TextView)this.puO.findViewById(2131309101));
    this.puc = this.puO.findViewById(2131298568);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.h
 * JD-Core Version:    0.7.0.1
 */