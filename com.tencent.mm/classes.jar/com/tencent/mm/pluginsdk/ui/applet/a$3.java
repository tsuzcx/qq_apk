package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.cdd;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(a parama, com.tencent.mm.ah.m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AddContact", "dealwith verify relation out of date");
    paramDialogInterface = (com.tencent.mm.pluginsdk.model.m)this.bEe;
    if ((paramDialogInterface.dmK != null) && (paramDialogInterface.dmK.Kv() != null)) {}
    for (paramDialogInterface = ((cdd)paramDialogInterface.dmK.ecE.ecN).tSb;; paramDialogInterface = null)
    {
      List localList = ((com.tencent.mm.pluginsdk.model.m)this.bEe).rTv;
      if ((localList != null) && (localList.size() > 0)) {
        this.sbP.e((String)localList.get(0), paramDialogInterface);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a.3
 * JD-Core Version:    0.7.0.1
 */