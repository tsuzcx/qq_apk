package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.ag;

final class ao$a$2
  implements DialogInterface.OnClickListener
{
  ao$a$2(ao.a parama, bi parambi, ag paramag, MenuItem paramMenuItem) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33357);
    s.M(this.fkH);
    this.zXL.dJs();
    this.zXL.a(this.fkH, true, this.VK.getGroupId(), 0);
    AppMethodBeat.o(33357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.a.2
 * JD-Core Version:    0.7.0.1
 */