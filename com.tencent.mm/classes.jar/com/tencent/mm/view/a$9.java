package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.bs.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$9
  implements t.a
{
  a$9(a parama) {}
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(116380);
    ab.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    this.AQD.getPresenter().d(paramk);
    onHide();
    AppMethodBeat.o(116380);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(116381);
    this.AQD.setActionBarVisible(true);
    this.AQD.rN(true);
    this.AQD.setFooterVisible(true);
    AppMethodBeat.o(116381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a.9
 * JD-Core Version:    0.7.0.1
 */