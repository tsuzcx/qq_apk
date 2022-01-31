package com.tencent.mm.ui.chatting.h;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.j;
import java.util.List;
import java.util.Set;

final class e$5
  implements DialogInterface.OnClickListener
{
  e$5(e parame, Set paramSet, List paramList) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
    j.a(e.b(this.vyV), this.vuY, new e.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.5
 * JD-Core Version:    0.7.0.1
 */