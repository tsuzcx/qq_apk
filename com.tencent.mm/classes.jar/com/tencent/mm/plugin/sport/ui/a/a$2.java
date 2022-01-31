package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.sport.b.b;

final class a$2
  implements DialogInterface.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = f.kX(this.pul.dnp.field_username);
    ((com.tencent.mm.pluginsdk.g)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.g.class)).a(paramDialogInterface, (Activity)this.pul.context, this.pul.dnp);
    this.pul.awY();
    ((b)com.tencent.mm.kernel.g.r(b.class)).bLc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.a.a.2
 * JD-Core Version:    0.7.0.1
 */