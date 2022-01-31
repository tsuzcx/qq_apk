package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.HashSet;
import java.util.Iterator;

final class i$7
  implements DialogInterface.OnCancelListener
{
  i$7(i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.wBi.ftk != null) && (this.wBi.fti.isEmpty()))
    {
      this.wBi.ftk.dismiss();
      paramDialogInterface = this.wBi.ftj.iterator();
      while (paramDialogInterface.hasNext())
      {
        m localm = (m)paramDialogInterface.next();
        g.DQ();
        g.DO().dJT.c(localm);
      }
      this.wBi.ftj.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.i.7
 * JD-Core Version:    0.7.0.1
 */