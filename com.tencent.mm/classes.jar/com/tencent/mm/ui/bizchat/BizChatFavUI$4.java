package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.w;
import com.tencent.mm.aj.z;

final class BizChatFavUI$4
  implements DialogInterface.OnCancelListener
{
  BizChatFavUI$4(BizChatFavUI paramBizChatFavUI, w paramw) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30110);
    z.afq();
    h.d(this.ztA);
    AppMethodBeat.o(30110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.4
 * JD-Core Version:    0.7.0.1
 */