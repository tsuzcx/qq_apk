package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.storage.bi;

final class an$3
  implements DialogInterface.OnClickListener
{
  an$3(an paraman, bi parambi, MenuItem paramMenuItem, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    an localan = this.vth;
    bi localbi = this.dUy;
    this.UX.getGroupId();
    if (this.vtj == 125) {}
    for (boolean bool = true;; bool = false)
    {
      an.a(localan, localbi, bool);
      paramDialogInterface.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.an.3
 * JD-Core Version:    0.7.0.1
 */