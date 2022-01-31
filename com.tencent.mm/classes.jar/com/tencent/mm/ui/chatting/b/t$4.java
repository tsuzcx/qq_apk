package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;

final class t$4
  implements j.a
{
  t$4(t paramt) {}
  
  public final void a(String paramString, l paraml)
  {
    y.v("MicroMsg.ChattingUI.HeaderComponent", "roommember watcher notify " + paramString);
    if ((this.vqY.byx.cFE()) && (!bk.bl(paramString)))
    {
      this.vqY.cEE();
      this.vqY.cEG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t.4
 * JD-Core Version:    0.7.0.1
 */