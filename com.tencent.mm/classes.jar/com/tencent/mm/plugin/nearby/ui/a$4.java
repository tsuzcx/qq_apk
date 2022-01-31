package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.ui.base.h;

final class a$4
  implements DialogInterface.OnClickListener
{
  a$4(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.a(this.mCU, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
    g.Dk().a(a.c(this.mCU), 0);
    paramDialogInterface = this.mCU;
    Context localContext = a.a(this.mCU);
    a.a(this.mCU).getString(b.h.app_tip);
    a.a(paramDialogInterface, h.b(localContext, a.a(this.mCU).getString(b.h.nearby_friend_clearing_location), true, new a.4.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a.4
 * JD-Core Version:    0.7.0.1
 */