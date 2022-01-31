package com.tencent.mm.ui.chatting.c;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(31194);
    if ((c.a(this.zEn.zEm) != null) && (c.a(this.zEn.zEm).getVisibility() != 8)) {
      c.a(this.zEn.zEm).setVisibility(8);
    }
    if (this.zEn.zEm.caz == null)
    {
      ab.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
      AppMethodBeat.o(31194);
      return;
    }
    ((r)this.zEn.zEm.caz.ay(r.class)).dIv();
    this.zEn.zEm.caz.aWN();
    AppMethodBeat.o(31194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.1.1
 * JD-Core Version:    0.7.0.1
 */