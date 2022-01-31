package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

final class e$a$8
  implements DialogInterface.OnClickListener
{
  e$a$8(e.a parama, e.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.wnI != null) {
      if (paramDialogInterface != null) {
        break label25;
      }
    }
    label25:
    for (boolean bool = false;; bool = ((c)paramDialogInterface).Ve.isChecked())
    {
      this.wnI.r(false, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.a.8
 * JD-Core Version:    0.7.0.1
 */