package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

final class TalkRoomUI$17
  implements DialogInterface.OnDismissListener
{
  TalkRoomUI$17(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    au.Hx();
    int i = bk.a((Integer)c.Dz().get(144641, null), 0);
    au.Hx();
    c.Dz().o(144641, Integer.valueOf(i + 1));
    this.pCk.onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.17
 * JD-Core Version:    0.7.0.1
 */