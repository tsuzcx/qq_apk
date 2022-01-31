package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

final class h$10
  implements DialogInterface.OnCancelListener
{
  h$10(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.rkq != null) {
      this.rkq.onClick(paramDialogInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.10
 * JD-Core Version:    0.7.0.1
 */