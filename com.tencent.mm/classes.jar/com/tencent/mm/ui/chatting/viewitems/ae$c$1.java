package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class ae$c$1
  implements c.a
{
  ae$c$1(ae.c paramc, a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37050);
    if (paramInt1 == 221)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(37050);
        return;
      }
      paramIntent = paramIntent.getStringExtra("result_msg");
      if (!Util.isNullOrNil(paramIntent)) {
        h.c(this.PHb.Pwc.getContext(), paramIntent, "", false);
      }
      AppMethodBeat.o(37050);
      return;
    }
    AppMethodBeat.o(37050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.c.1
 * JD-Core Version:    0.7.0.1
 */