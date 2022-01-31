package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

final class j$7
  implements DialogInterface.OnClickListener
{
  j$7(j paramj, int paramInt, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    j.a(this.uJI, this.val$id, this.uJN.actionType, this.uJN.id, this.uJN.srl);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.j.7
 * JD-Core Version:    0.7.0.1
 */