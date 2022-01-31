package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class e$a$4
  implements DialogInterface.OnClickListener
{
  e$a$4(e.a parama, e.d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.wnH != null) {
      if (paramDialogInterface != null) {
        break label25;
      }
    }
    label25:
    for (paramDialogInterface = null;; paramDialogInterface = ((c)paramDialogInterface).cKe())
    {
      this.wnH.b(true, paramDialogInterface);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.a.4
 * JD-Core Version:    0.7.0.1
 */