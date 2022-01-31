package com.tencent.mm.ui.chatting.b;

import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.c.a;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1) {}
  
  public final void run()
  {
    if ((c.a(this.voL.voK) != null) && (c.a(this.voL.voK).getVisibility() != 8)) {
      c.a(this.voL.voK).setVisibility(8);
    }
    if (this.voL.voK.byx == null)
    {
      y.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
      return;
    }
    ((q)this.voL.voK.byx.ac(q.class)).cEE();
    this.voL.voK.byx.axW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.1.1
 * JD-Core Version:    0.7.0.1
 */