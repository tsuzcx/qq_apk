package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;
import java.util.Map;

final class e$7
  implements j.a
{
  e$7(e parame) {}
  
  public final void a(String paramString, l paraml)
  {
    y.v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify " + paramString);
    if (((c)this.vpa.byx.ac(c.class)).cDH())
    {
      e.a(this.vpa, com.tencent.mm.ai.a.e.c(((c)this.vpa.byx.ac(c.class)).cDE()));
      if (!this.vpa.voT) {
        break label148;
      }
      m.e(this.vpa.byx.getTalkerUserName(), this.vpa.voU);
    }
    for (;;)
    {
      if (!bk.bl(paramString)) {
        this.vpa.byx.axW();
      }
      return;
      e.a(this.vpa, m.gE(this.vpa.byx.getTalkerUserName()));
      break;
      label148:
      this.vpa.voU.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.e.7
 * JD-Core Version:    0.7.0.1
 */