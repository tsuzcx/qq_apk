package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ad$g
  extends ad.b
{
  TextView ImU;
  LinearLayout ImV;
  MMNeat7extView nCy;
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.nBh != null)
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
    this.nBh = paramView.findViewById(2131298109);
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305902));
    this.ImU = ((TextView)this.nBh.findViewById(2131305729));
    this.ImV = ((LinearLayout)this.nBh.findViewById(2131305743));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.g
 * JD-Core Version:    0.7.0.1
 */