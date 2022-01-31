package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.n;

final class j$9$1
  implements DialogInterface.OnCancelListener
{
  j$9$1(j.9 param9) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(j.g(this.vTs.vTn));
    if (n.omD != null) {
      n.omD.bCl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.9.1
 * JD-Core Version:    0.7.0.1
 */