package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class p$c$1
  implements d.a
{
  p$c$1(p.c paramc, a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(32993);
    if (paramInt1 == 221)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(32993);
        return;
      }
      paramIntent = paramIntent.getStringExtra("result_msg");
      if (!bo.isNullOrNil(paramIntent)) {
        h.b(this.zRK.zJz.getContext(), paramIntent, "", false);
      }
      AppMethodBeat.o(32993);
      return;
    }
    AppMethodBeat.o(32993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.c.1
 * JD-Core Version:    0.7.0.1
 */