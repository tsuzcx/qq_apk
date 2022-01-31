package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;

final class ah$1$1
  implements Runnable
{
  ah$1$1(ah.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(31662);
    aw.RO().Bk();
    ah.a(this.zHP.zHO, this.zHP.val$data, this.zHP.zHM);
    ((ai)this.zHP.zHO.caz.ay(ai.class)).aU(this.zHP.val$data);
    if (this.zHP.zHN.dIh() != null) {
      this.zHP.zHN.dIh().s(this.zHP.val$requestCode, this.zHP.val$data);
    }
    aw.RO().dtd();
    AppMethodBeat.o(31662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ah.1.1
 * JD-Core Version:    0.7.0.1
 */