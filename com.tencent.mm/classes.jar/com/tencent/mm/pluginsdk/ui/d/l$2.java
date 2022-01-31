package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.base.h.c;

final class l$2
  implements h.c
{
  l$2(DialogInterface.OnDismissListener paramOnDismissListener, String paramString, Context paramContext) {}
  
  public final void gl(int paramInt)
  {
    if (this.sjL != null) {
      this.sjL.onDismiss(null);
    }
    String str = this.sjM.replace(" ", "").replace("#", "@");
    switch (paramInt)
    {
    default: 
      return;
    }
    l.bo(this.val$context, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.2
 * JD-Core Version:    0.7.0.1
 */