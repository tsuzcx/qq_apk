package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.pluginsdk.model.app.y;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c paramc, g.a parama, String paramString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new y(2, new ak(this.gBQ.appId, "0"));
    c.a(this.vhs, paramDialogInterface);
    paramDialogInterface = a.a.aYi();
    if (paramDialogInterface != null)
    {
      c.a(this.vhs).vtz.getContext();
      paramDialogInterface.a(this.vhu, this.gBQ.appId, this.gBQ.type, this.vhv, this.gBQ.mediaTagName, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.3
 * JD-Core Version:    0.7.0.1
 */