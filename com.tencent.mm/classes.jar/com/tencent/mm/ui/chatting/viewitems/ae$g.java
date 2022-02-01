package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ae$g
  extends ae.b
{
  TextView Kds;
  LinearLayout Kdt;
  MMNeat7extView ocA;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.odh != null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306454);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    localViewStub.inflate();
    this.odh = paramView.findViewById(2131298109);
    this.ocA = ((MMNeat7extView)this.odh.findViewById(2131305902));
    this.Kds = ((TextView)this.odh.findViewById(2131305729));
    this.Kdt = ((LinearLayout)this.odh.findViewById(2131305743));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.g
 * JD-Core Version:    0.7.0.1
 */