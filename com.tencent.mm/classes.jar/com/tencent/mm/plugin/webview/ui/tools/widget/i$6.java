package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.xweb.f;

final class i$6
  implements DialogInterface.OnClickListener
{
  i$6(i parami, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.rqL.cancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.rCb.onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i.6
 * JD-Core Version:    0.7.0.1
 */