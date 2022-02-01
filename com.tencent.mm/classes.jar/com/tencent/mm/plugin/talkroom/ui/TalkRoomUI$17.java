package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

final class TalkRoomUI$17
  implements DialogInterface.OnDismissListener
{
  TalkRoomUI$17(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29607);
    bh.bCz();
    int i = Util.nullAs((Integer)c.ban().d(144641, null), 0);
    bh.bCz();
    c.ban().B(144641, Integer.valueOf(i + 1));
    this.SOQ.onBackPressed();
    AppMethodBeat.o(29607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.17
 * JD-Core Version:    0.7.0.1
 */