package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

public abstract class v
  implements MenuItem.OnMenuItemClickListener
{
  private long oiC = -1L;
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.oiC != -1L)
    {
      long l = (System.nanoTime() - this.oiC) / 1000000L;
      if (l < 500L)
      {
        y.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.oiC = System.nanoTime();
    xQ();
    return false;
  }
  
  public abstract void xQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.v
 * JD-Core Version:    0.7.0.1
 */