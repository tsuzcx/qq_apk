package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.ui.widget.a.c;

final class s$2
  implements DialogInterface.OnClickListener
{
  s$2(s params) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.sds.few != null)
    {
      this.sds.few.dismiss();
      this.sds.few = null;
    }
    new am(new s.2.1(this), false).S(500L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.2
 * JD-Core Version:    0.7.0.1
 */