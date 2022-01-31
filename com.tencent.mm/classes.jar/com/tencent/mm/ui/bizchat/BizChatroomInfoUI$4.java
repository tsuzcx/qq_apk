package com.tencent.mm.ui.bizchat;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatroomInfoUI$4
  implements Runnable
{
  BizChatroomInfoUI$4(BizChatroomInfoUI paramBizChatroomInfoUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(30200);
    View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(this.zuv)).a(this.efX, this.zuv.getListView());
    if (localView != null) {
      com.tencent.mm.ui.h.a.b(this.zuv.getContext(), localView);
    }
    AppMethodBeat.o(30200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.4
 * JD-Core Version:    0.7.0.1
 */