package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.h;

final class c$36$1
  implements DialogInterface.OnClickListener
{
  c$36$1(c.36 param36) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(139564);
    if (!this.BJa.mFinished)
    {
      paramDialogInterface = this.BJa.BIY;
      if (paramDialogInterface.BKu != null) {
        paramDialogInterface.BKu.a(4, -1, null);
      }
    }
    AppMethodBeat.o(139564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.36.1
 * JD-Core Version:    0.7.0.1
 */