package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$14$1
  implements Runnable
{
  h$14$1(h.14 param14, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(106417);
    ((Dialog)this.ziG.qHq.getTag()).dismiss();
    if (this.ziG.ziE != null) {
      this.ziG.ziE.Ch(this.ziF);
    }
    AppMethodBeat.o(106417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.14.1
 * JD-Core Version:    0.7.0.1
 */