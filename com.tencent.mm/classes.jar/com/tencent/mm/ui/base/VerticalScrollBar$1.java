package com.tencent.mm.ui.base;

import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

final class VerticalScrollBar$1
  implements Runnable
{
  VerticalScrollBar$1(VerticalScrollBar paramVerticalScrollBar, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(107087);
    if (this.zqb.nSx.length <= 0)
    {
      AppMethodBeat.o(107087);
      return;
    }
    int i = (int)VerticalScrollBar.a(this.zqb).measureText(this.zqb.nSx[(this.zqb.nSx.length - 1)]);
    int k = a.fromDPToPix(this.zqb.getContext(), 16) + i;
    int j = (int)(this.zqb.nSx.length * VerticalScrollBar.b(this.zqb) * this.zqb.nSv);
    ab.i("MicroMsg.VerticalScrollBar", "onDraw newHeight:%s, viewHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.fZ) });
    i = j;
    if (j == 0) {
      i = this.fZ;
    }
    j = k;
    if (k > this.nSD) {
      j = this.nSD;
    }
    ViewGroup.LayoutParams localLayoutParams = this.zqb.getLayoutParams();
    localLayoutParams.width = j;
    localLayoutParams.height = i;
    this.zqb.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(107087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar.1
 * JD-Core Version:    0.7.0.1
 */