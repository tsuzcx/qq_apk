package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;

final class d$e$6
  implements DialogInterface.OnClickListener
{
  d$e$6(d.e parame, bi parambi) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.dUy.aVK())
    {
      String str = "";
      g.a locala = g.a.gp(this.dUy.field_content);
      paramDialogInterface = str;
      if (locala != null)
      {
        paramDialogInterface = str;
        if (!bk.bl(locala.title)) {
          paramDialogInterface = locala.title;
        }
      }
      l.z(this.dUy.field_msgId, paramDialogInterface);
      this.dUy.setStatus(1);
      au.Hx();
      c.Fy().fd(this.dUy.field_msgId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.6
 * JD-Core Version:    0.7.0.1
 */