package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class i$4
  implements DialogInterface.OnClickListener
{
  i$4(i parami, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.JumpRemind", "onClick2");
    if ((this.wAo.wAl != null) && (this.wAo.wAl.tDM.equals("left_button_wording")))
    {
      this.wAo.hl(this.eRW);
      return;
    }
    this.wAo.wAm.onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.i.4
 * JD-Core Version:    0.7.0.1
 */