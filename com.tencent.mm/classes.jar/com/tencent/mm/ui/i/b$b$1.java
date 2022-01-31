package com.tencent.mm.ui.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class b$b$1
  implements DialogInterface.OnDismissListener
{
  b$b$1(b.b paramb) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.wiw.vWf) && (this.wiw.wiv != null))
    {
      b.a(this.wiw.wiv).onCancel();
      this.wiw.wiv.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.i.b.b.1
 * JD-Core Version:    0.7.0.1
 */