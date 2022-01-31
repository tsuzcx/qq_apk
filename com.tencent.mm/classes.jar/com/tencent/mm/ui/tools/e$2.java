package com.tencent.mm.ui.tools;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements Runnable
{
  e$2(e parame, View paramView) {}
  
  public final void run()
  {
    if (this.wcP.wcN == this.wcP.wcI)
    {
      y.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
      this.wcQ.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.2
 * JD-Core Version:    0.7.0.1
 */