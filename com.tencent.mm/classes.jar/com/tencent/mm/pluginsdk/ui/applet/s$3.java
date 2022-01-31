package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.a.c;

final class s$3
  implements DialogInterface.OnClickListener
{
  s$3(s params) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.sds.few != null)
    {
      this.sds.few.dismiss();
      this.sds.few = null;
    }
    this.sds.onStop();
    if (this.sds.sdo != null) {
      this.sds.sdo.bl(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.3
 * JD-Core Version:    0.7.0.1
 */