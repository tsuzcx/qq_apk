package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.roomsdk.a.c.a;

final class MMCreateChatroomUI$3
  implements DialogInterface.OnCancelListener
{
  MMCreateChatroomUI$3(MMCreateChatroomUI paramMMCreateChatroomUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    MMCreateChatroomUI.a(this.wgf, false);
    this.vNF.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI.3
 * JD-Core Version:    0.7.0.1
 */