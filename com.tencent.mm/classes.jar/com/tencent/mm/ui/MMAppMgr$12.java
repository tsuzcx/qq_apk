package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.sdk.platformtools.ag;

final class MMAppMgr$12
  implements DialogInterface.OnDismissListener
{
  MMAppMgr$12(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    ag.Zn("show_wap_adviser");
    if (this.rkq != null) {
      this.rkq.onClick(paramDialogInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.12
 * JD-Core Version:    0.7.0.1
 */