package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SingleChatInfoUI$4
  implements Runnable
{
  SingleChatInfoUI$4(SingleChatInfoUI paramSingleChatInfoUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(29869);
    View localView = ((com.tencent.mm.ui.base.preference.a)SingleChatInfoUI.b(this.zfe)).a(this.efX, this.zfe.getListView());
    if (localView != null) {
      com.tencent.mm.ui.h.a.b(this.zfe.getContext(), localView);
    }
    AppMethodBeat.o(29869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.4
 * JD-Core Version:    0.7.0.1
 */