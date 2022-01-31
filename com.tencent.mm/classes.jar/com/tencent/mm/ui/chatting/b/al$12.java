package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ru;

final class al$12
  implements DialogInterface.OnClickListener
{
  al$12(al paramal) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new ru();
    paramDialogInterface.cbq.cbt = true;
    com.tencent.mm.sdk.b.a.udP.m(paramDialogInterface);
    al.a(this.vsS, this.vsS.byx.getTalkerUserName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.al.12
 * JD-Core Version:    0.7.0.1
 */