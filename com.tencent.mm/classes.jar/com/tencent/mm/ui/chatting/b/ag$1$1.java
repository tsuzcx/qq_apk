package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;

final class ag$1$1
  implements Runnable
{
  ag$1$1(ag.1 param1) {}
  
  public final void run()
  {
    au.DS().sQ();
    ag.a(this.vsj.vsi, this.vsj.hSF, this.vsj.vsg);
    ((ah)this.vsj.vsi.byx.ac(ah.class)).as(this.vsj.hSF);
    if (this.vsj.vsh.cEr() != null) {
      this.vsj.vsh.cEr().l(this.vsj.val$requestCode, this.vsj.hSF);
    }
    au.DS().cre();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ag.1.1
 * JD-Core Version:    0.7.0.1
 */