package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;

final class f$1
  implements j.a
{
  f$1(f paramf) {}
  
  public final void a(String paramString, l paraml)
  {
    y.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramString });
    if ((paramString != null) && ((paramString.equals(this.vpj.byx.getTalkerUserName())) || (paramString.equals("*")))) {
      this.vpj.cdH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.f.1
 * JD-Core Version:    0.7.0.1
 */