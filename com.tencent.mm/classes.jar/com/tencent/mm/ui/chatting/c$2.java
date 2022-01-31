package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.ag;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.ui.chatting.d.a;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc, j.b paramb, String paramString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30380);
    paramDialogInterface = new y(2, new ag(this.iaj.appId, "1"));
    c.a(this.zwm, paramDialogInterface);
    paramDialogInterface = b.a.bEX();
    if (paramDialogInterface != null)
    {
      c.a(this.zwm).zJz.getContext();
      paramDialogInterface.a(this.zwo, this.iaj.appId, this.iaj.type, this.zwp, this.iaj.mediaTagName, 1);
    }
    AppMethodBeat.o(30380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.2
 * JD-Core Version:    0.7.0.1
 */