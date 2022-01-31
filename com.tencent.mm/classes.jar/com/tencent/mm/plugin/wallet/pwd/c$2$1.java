package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

final class c$2$1
  implements DialogInterface.OnClickListener
{
  c$2$1(c.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c.c(this.qoi.qoh).putInt("RESET_PWD_USER_ACTION", 2);
    this.qoi.qoh.a(this.qoi.gfb, 0, c.d(this.qoi.qoh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.c.2.1
 * JD-Core Version:    0.7.0.1
 */