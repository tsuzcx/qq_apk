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
  TextView KzK;
  LinearLayout KzL;
  MMNeat7extView oip;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.oiV != null)
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
    this.oiV = paramView.findViewById(2131298109);
    this.oip = ((MMNeat7extView)this.oiV.findViewById(2131305902));
    this.KzK = ((TextView)this.oiV.findViewById(2131305729));
    this.KzL = ((LinearLayout)this.oiV.findViewById(2131305743));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.g
 * JD-Core Version:    0.7.0.1
 */