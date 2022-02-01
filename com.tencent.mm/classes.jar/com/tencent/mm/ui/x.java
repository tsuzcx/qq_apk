package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class x
  implements MenuItem.OnMenuItemClickListener
{
  private long xGD = -1L;
  
  public abstract void WP();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ac.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.xGD != -1L)
    {
      long l = (System.nanoTime() - this.xGD) / 1000000L;
      if (l < 500L)
      {
        ac.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.xGD = System.nanoTime();
    WP();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */