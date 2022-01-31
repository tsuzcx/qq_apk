package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ah.p;
import com.tencent.mm.ai.a.l;
import com.tencent.mm.model.au;

final class BizChatSearchUI$a$1
  implements Runnable
{
  BizChatSearchUI$a$1(BizChatSearchUI.a parama, String paramString) {}
  
  public final void run()
  {
    if (!this.vfD.equals(BizChatSearchUI.a.c(this.vfE))) {
      return;
    }
    l locall = new l(BizChatSearchUI.a.e(this.vfE), this.vfD, 0);
    au.Dk().a(locall, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.a.1
 * JD-Core Version:    0.7.0.1
 */