package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad$i
  extends ad.b
{
  ImageView nCo;
  TextView toC;
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(37140);
    if (this.nBh != null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306456);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    localViewStub.inflate();
    this.nBh = paramView.findViewById(2131298113);
    this.fUk = ((TextView)this.nBh.findViewById(2131305902));
    this.toC = ((TextView)this.nBh.findViewById(2131305822));
    this.nCo = ((ImageView)this.nBh.findViewById(2131303284));
    AppMethodBeat.o(37140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.i
 * JD-Core Version:    0.7.0.1
 */