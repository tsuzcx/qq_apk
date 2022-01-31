package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.ag;

final class ao$b$2
  implements DialogInterface.OnClickListener
{
  ao$b$2(ao.b paramb, ag paramag, bi parambi, MenuItem paramMenuItem) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33366);
    this.zXL.dJs();
    this.zXL.a(this.fkH, true, this.VK.getGroupId(), 0);
    AppMethodBeat.o(33366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.b.2
 * JD-Core Version:    0.7.0.1
 */