package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.contact.VoipAddressUI;

final class af$1
  implements DialogInterface.OnClickListener
{
  af$1(af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ru localru = new ru();
    localru.cbq.cbt = true;
    a.udP.m(localru);
    VoipAddressUI.gV(af.c(this.uQr));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.af.1
 * JD-Core Version:    0.7.0.1
 */