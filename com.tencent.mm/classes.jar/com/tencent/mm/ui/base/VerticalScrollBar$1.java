package com.tencent.mm.ui.base;

import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.cb.a;

final class VerticalScrollBar$1
  implements Runnable
{
  VerticalScrollBar$1(VerticalScrollBar paramVerticalScrollBar, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.vbF.lvg.length <= 0) {}
    int i;
    do
    {
      return;
      i = (int)VerticalScrollBar.a(this.vbF).measureText(this.vbF.lvg[(this.vbF.lvg.length - 1)]) + a.fromDPToPix(this.vbF.getContext(), 8);
    } while (i <= this.lvn);
    ViewGroup.LayoutParams localLayoutParams = this.vbF.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = this.fa;
    this.vbF.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.VerticalScrollBar.1
 * JD-Core Version:    0.7.0.1
 */