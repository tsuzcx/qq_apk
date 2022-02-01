package com.tencent.mm.plugin.profile.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.report.service.h;

final class b$9
  implements DialogInterface.OnClickListener
{
  b$9(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(219244);
    h.IzE.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(4), b.c(this.GWM).field_username });
    b.a(this.GWM, true);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Chat_User", b.c(this.GWM).field_username);
    paramDialogInterface.addFlags(67108864);
    c.f(b.d(this.GWM), ".ui.chatting.ChattingUI", paramDialogInterface);
    AppMethodBeat.o(219244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b.9
 * JD-Core Version:    0.7.0.1
 */