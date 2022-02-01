package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$d
  extends ad.b
{
  ImageView nCl;
  ImageView nCo;
  TextView nDo;
  ImageView nDp;
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.nBh != null)
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
    this.nBh = paramView.findViewById(2131298105);
    this.nCl = ((ImageView)this.nBh.findViewById(2131298813));
    this.fUk = ((TextView)this.nBh.findViewById(2131305902));
    this.nDo = ((TextView)this.nBh.findViewById(2131303307));
    this.nCo = ((ImageView)this.nBh.findViewById(2131303284));
    this.nDp = ((ImageView)this.nBh.findViewById(2131306868));
    this.nCw = ((ImageView)this.nBh.findViewById(2131298826));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.d
 * JD-Core Version:    0.7.0.1
 */