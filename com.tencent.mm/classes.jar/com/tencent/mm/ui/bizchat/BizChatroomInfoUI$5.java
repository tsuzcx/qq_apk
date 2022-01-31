package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.n;
import com.tencent.mm.model.aw;

final class BizChatroomInfoUI$5
  implements DialogInterface.OnCancelListener
{
  BizChatroomInfoUI$5(BizChatroomInfoUI paramBizChatroomInfoUI, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30201);
    aw.Rc().a(this.zup);
    AppMethodBeat.o(30201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.5
 * JD-Core Version:    0.7.0.1
 */