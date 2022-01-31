package com.tencent.mm.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class MultiTalkRoomPopupNav$1
  implements View.OnClickListener
{
  MultiTalkRoomPopupNav$1(MultiTalkRoomPopupNav paramMultiTalkRoomPopupNav) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29769);
    if ((d.fUO != null) && (((com.tencent.mm.plugin.multitalk.model.a)g.E(com.tencent.mm.plugin.multitalk.model.a.class)).bO(this.zdP.getContext())))
    {
      ab.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
      AppMethodBeat.o(29769);
      return;
    }
    if ((d.fUO != null) && (d.fUO.ale()))
    {
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131300731), 0).show();
      ab.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
      AppMethodBeat.o(29769);
      return;
    }
    MultiTalkRoomPopupNav.a(this.zdP);
    AppMethodBeat.o(29769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav.1
 * JD-Core Version:    0.7.0.1
 */