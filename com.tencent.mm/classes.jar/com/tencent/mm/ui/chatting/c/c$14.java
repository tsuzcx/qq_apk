package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.ui.chatting.d.a;

final class c$14
  implements DialogInterface.OnClickListener
{
  c$14(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31206);
    c.c(this.zEm).field_hadAlert = 1;
    paramDialogInterface = c.c(this.zEm);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.field_brandFlag &= 0xFFFFFFFB;
      f.g(paramDialogInterface);
    }
    z.aft().se(this.zEm.caz.getTalkerUserName());
    AppMethodBeat.o(31206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.14
 * JD-Core Version:    0.7.0.1
 */