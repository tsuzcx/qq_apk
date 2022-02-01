package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class an$i
  extends an.b
{
  ImageView sGV;
  TextView sGk;
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(37140);
    if (this.sEi != null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.dZB);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    localViewStub.inflate();
    this.sEi = paramView.findViewById(R.h.dxR);
    this.jMg = ((TextView)this.sEi.findViewById(R.h.title));
    this.sGk = ((TextView)this.sEi.findViewById(R.h.time_tv));
    this.sGV = ((ImageView)this.sEi.findViewById(R.h.play_icon));
    AppMethodBeat.o(37140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.i
 * JD-Core Version:    0.7.0.1
 */