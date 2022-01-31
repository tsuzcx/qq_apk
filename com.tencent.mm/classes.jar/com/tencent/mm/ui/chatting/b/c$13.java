package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;

final class c$13
  implements DialogInterface.OnClickListener
{
  c$13(c paramc, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c.c(this.voK).field_hadAlert = 1;
    paramDialogInterface = c.c(this.voK);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.field_brandFlag |= 0x4;
      f.g(paramDialogInterface);
    }
    if (this.voP)
    {
      paramDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
      this.voK.byx.vtz.startActivity(paramDialogInterface);
      return;
    }
    z.MJ().lj(this.voK.byx.getTalkerUserName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.13
 * JD-Core Version:    0.7.0.1
 */