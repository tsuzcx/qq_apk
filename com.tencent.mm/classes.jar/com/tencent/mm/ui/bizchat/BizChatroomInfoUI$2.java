package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.bd.a;

final class BizChatroomInfoUI$2
  implements bd.a
{
  BizChatroomInfoUI$2(BizChatroomInfoUI paramBizChatroomInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final void xA()
  {
    if (this.doh != null)
    {
      z.MB().bL(BizChatroomInfoUI.g(this.vfX));
      z.MA().bL(BizChatroomInfoUI.g(this.vfX));
      this.doh.dismiss();
    }
  }
  
  public final boolean xz()
  {
    return BizChatroomInfoUI.f(this.vfX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.2
 * JD-Core Version:    0.7.0.1
 */