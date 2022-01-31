package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.pluginsdk.model.app.y;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(c paramc, g.a parama, String paramString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new y(2, new ak(this.gBQ.appId, "1"));
    c.a(this.vhs, paramDialogInterface);
    paramDialogInterface = a.a.aYi();
    if (paramDialogInterface != null)
    {
      c.a(this.vhs).vtz.getContext();
      paramDialogInterface.a(this.vhu, this.gBQ.appId, this.gBQ.type, this.vhv, this.gBQ.mediaTagName, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.2
 * JD-Core Version:    0.7.0.1
 */