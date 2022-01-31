package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;

final class ap$2$1
  implements Runnable
{
  ap$2$1(ap.2 param2, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(153841);
    if (this.qac == 0)
    {
      this.zJb.zJa.a(bo.apW(this.val$id), ChattingItemTranslate.b.zXx);
      ap.a(this.zJb.zJa, bo.apW(this.val$id));
      AppMethodBeat.o(153841);
      return;
    }
    if (this.qac == 3) {
      h.bO(this.zJb.zJa.caz.zJz.getContext(), this.zJb.zJa.caz.zJz.getMMResources().getString(2131298339));
    }
    for (;;)
    {
      this.zJb.zJa.a(bo.apW(this.val$id), ChattingItemTranslate.b.zXu);
      this.zJb.zJa.caz.aWN();
      AppMethodBeat.o(153841);
      return;
      if (this.qac != 5) {
        h.bO(this.zJb.zJa.caz.zJz.getContext(), this.zJb.zJa.caz.zJz.getMMResources().getString(2131298334));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ap.2.1
 * JD-Core Version:    0.7.0.1
 */