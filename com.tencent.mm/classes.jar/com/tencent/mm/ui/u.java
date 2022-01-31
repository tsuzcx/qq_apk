package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

public abstract class u
  implements View.OnClickListener
{
  private long oiC = -1L;
  
  public abstract void aEI();
  
  public void onClick(View paramView)
  {
    y.i("MicroMsg.MMCustomClickListener", "button onclick");
    if (this.oiC != -1L)
    {
      long l = (System.nanoTime() - this.oiC) / 1000000L;
      if (l < 3000L)
      {
        y.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(3000L) });
        return;
      }
    }
    this.oiC = System.nanoTime();
    aEI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */