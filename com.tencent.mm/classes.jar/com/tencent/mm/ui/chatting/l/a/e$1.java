package com.tencent.mm.ui.chatting.l.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

final class e$1
  implements Runnable
{
  e$1(e parame, int paramInt, MMChattingListView paramMMChattingListView) {}
  
  public final void run()
  {
    AppMethodBeat.i(32734);
    int i = Math.max(0, this.lU - this.zQI.caz.getFirstVisiblePosition());
    this.zQI.Qp(this.lU);
    this.zQH.setHighLightChild(i);
    aw.aaz();
    c.Ru().set(ac.a.yBx, Boolean.FALSE);
    AppMethodBeat.o(32734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.e.1
 * JD-Core Version:    0.7.0.1
 */