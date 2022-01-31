package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;

final class ap$3
  implements DialogInterface.OnClickListener
{
  ap$3(ap paramap, bi parambi, MenuItem paramMenuItem, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153844);
    ap localap = this.zJa;
    bi localbi = this.fkH;
    this.VK.getGroupId();
    if (this.zJc == 125) {}
    for (boolean bool = true;; bool = false)
    {
      ap.a(localap, localbi, bool);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(153844);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ap.3
 * JD-Core Version:    0.7.0.1
 */