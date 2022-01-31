package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.xweb.xwalk.plugin.c;
import com.tencent.xweb.xwalk.plugin.d;

final class a$26$1
  implements DialogInterface.OnClickListener
{
  a$26$1(a.26 param26) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.xlp.mFinished)
    {
      paramDialogInterface = this.xlp.xlo;
      if (paramDialogInterface.xmv != null) {
        paramDialogInterface.xmv.a(4, -1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.26.1
 * JD-Core Version:    0.7.0.1
 */