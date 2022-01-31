package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.ui.chatting.c.a;

final class c$14
  implements DialogInterface.OnClickListener
{
  c$14(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c.c(this.voK).field_hadAlert = 1;
    paramDialogInterface = c.c(this.voK);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.field_brandFlag &= 0xFFFFFFFB;
      f.g(paramDialogInterface);
    }
    z.MJ().lj(this.voK.byx.getTalkerUserName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.14
 * JD-Core Version:    0.7.0.1
 */