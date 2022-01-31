package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.bf.a;

final class BizChatroomInfoUI$2
  implements bf.a
{
  BizChatroomInfoUI$2(BizChatroomInfoUI paramBizChatroomInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(30197);
    boolean bool = BizChatroomInfoUI.f(this.zuv);
    AppMethodBeat.o(30197);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(30198);
    if (this.efE != null)
    {
      z.afl().gG(BizChatroomInfoUI.g(this.zuv));
      z.afk().gG(BizChatroomInfoUI.g(this.zuv));
      this.efE.dismiss();
    }
    AppMethodBeat.o(30198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.2
 * JD-Core Version:    0.7.0.1
 */