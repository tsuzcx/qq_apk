package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ex;

final class al$5
  implements DialogInterface.OnClickListener
{
  al$5(al paramal, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.vsU.run();
    paramDialogInterface = new ex();
    paramDialogInterface.bLp.username = this.vsS.byx.getTalkerUserName();
    com.tencent.mm.sdk.b.a.udP.m(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.al.5
 * JD-Core Version:    0.7.0.1
 */