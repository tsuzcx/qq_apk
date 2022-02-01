package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

final class TalkRoomUI$17
  implements DialogInterface.OnDismissListener
{
  TalkRoomUI$17(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29607);
    az.ayM();
    int i = bs.a((Integer)c.agA().get(144641, null), 0);
    az.ayM();
    c.agA().set(144641, Integer.valueOf(i + 1));
    this.zXB.onBackPressed();
    AppMethodBeat.o(29607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.17
 * JD-Core Version:    0.7.0.1
 */