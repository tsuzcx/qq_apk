package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class s$8
  implements DialogInterface.OnCancelListener
{
  s$8(s params, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.oPE.hQN != 0)
    {
      g.DQ();
      g.DO().dJT.c(this.oPI);
      this.oPE.hQN = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.8
 * JD-Core Version:    0.7.0.1
 */