package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.sdk.platformtools.aq;

final class e$18$1
  implements DialogInterface.OnClickListener
{
  e$18$1(e.18 param18) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aq.is2G(this.pYS.pYP.getActivity())) {
      q.bQX();
    }
    e.e(this.pYS.pYP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.18.1
 * JD-Core Version:    0.7.0.1
 */