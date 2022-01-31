package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.ai;

final class ac$6$1
  implements DialogInterface.OnCancelListener
{
  ac$6$1(ac.6 param6) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.oRg.oRe.oRa = null;
    this.oRg.oRe.oQL = false;
    ai.S(this.oRg.oRe.oRc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.6.1
 * JD-Core Version:    0.7.0.1
 */