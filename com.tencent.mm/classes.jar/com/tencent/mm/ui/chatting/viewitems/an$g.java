package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class an$g
  extends an.b
{
  TextView Xih;
  LinearLayout Xii;
  MMNeat7extView sDe;
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.sEi != null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.dZz);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    localViewStub.inflate();
    this.sEi = paramView.findViewById(R.h.dxP);
    this.sDe = ((MMNeat7extView)this.sEi.findViewById(R.h.title));
    this.Xih = ((TextView)this.sEi.findViewById(R.h.dWu));
    this.Xii = ((LinearLayout)this.sEi.findViewById(R.h.dWx));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.g
 * JD-Core Version:    0.7.0.1
 */