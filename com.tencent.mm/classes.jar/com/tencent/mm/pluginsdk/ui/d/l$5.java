package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.base.k;

final class l$5
  implements l.a.a
{
  l$5(k paramk, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void hb(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sjO.dismiss();
      if (this.sjL != null) {
        this.sjL.onDismiss(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.5
 * JD-Core Version:    0.7.0.1
 */