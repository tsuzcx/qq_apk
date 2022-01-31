package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class q$2
  implements View.OnClickListener
{
  q$2(q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34734);
    ab.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
    this.AnC.setVisibility(8);
    a.ymk.l(new ty());
    ab.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
    AppMethodBeat.o(34734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.q.2
 * JD-Core Version:    0.7.0.1
 */