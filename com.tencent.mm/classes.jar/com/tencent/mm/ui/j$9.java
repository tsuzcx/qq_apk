package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

final class j$9
  implements DialogInterface.OnClickListener
{
  j$9(j paramj, int paramInt, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    j.a(this.uJI, this.val$id, this.uJP.actionType, this.uJP.id, this.uJP.srl);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.j.9
 * JD-Core Version:    0.7.0.1
 */