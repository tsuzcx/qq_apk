package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ai.e.a.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;

final class c$10$1
  implements Runnable
{
  c$10$1(c.10 param10, e.a.b paramb, ad paramad) {}
  
  public final void run()
  {
    if ((c.d(this.voO.voK)) && (this.voN.eeM.equals(this.voO.voK.byx.getTalkerUserName())))
    {
      y.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
      c.a(this.voO.voK, f.kX(this.voN.eeM));
      if (this.voO.voK.byx != null) {
        ((n)this.voO.voK.byx.ac(n.class)).aa(this.drE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.10.1
 * JD-Core Version:    0.7.0.1
 */