package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.d.a.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.y;

final class BizChatFavUI$6
  implements d.a
{
  BizChatFavUI$6(BizChatFavUI paramBizChatFavUI) {}
  
  public final void a(d.a.b paramb)
  {
    if ((paramb != null) && (paramb.ehx != null))
    {
      y.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
      y.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(z.MA().aj(paramb.ehm).field_needToUpdate) });
      if (BizChatFavUI.b(this.vfa)) {
        BizChatFavUI.c(this.vfa).yc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.6
 * JD-Core Version:    0.7.0.1
 */