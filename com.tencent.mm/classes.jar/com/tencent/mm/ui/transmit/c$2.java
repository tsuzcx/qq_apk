package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.whG;
    if (paramDialogInterface.few != null)
    {
      paramDialogInterface.few.dismiss();
      paramDialogInterface.few = null;
    }
    paramDialogInterface.whF.cJv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.c.2
 * JD-Core Version:    0.7.0.1
 */