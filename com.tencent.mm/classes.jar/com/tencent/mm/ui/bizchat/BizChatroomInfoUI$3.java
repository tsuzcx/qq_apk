package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.d.a.a;
import com.tencent.mm.ai.a.d.a.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.y;

final class BizChatroomInfoUI$3
  implements d.a
{
  BizChatroomInfoUI$3(BizChatroomInfoUI paramBizChatroomInfoUI) {}
  
  public final void a(d.a.b paramb)
  {
    if ((paramb != null) && (paramb.ehx != null) && (paramb.ehm == BizChatroomInfoUI.g(this.vfX)) && (paramb.ehw != d.a.a.eht))
    {
      y.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
      paramb = z.MA().aj(BizChatroomInfoUI.g(this.vfX));
      BizChatroomInfoUI.a(this.vfX, paramb);
      BizChatroomInfoUI.h(this.vfX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.3
 * JD-Core Version:    0.7.0.1
 */