package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class u
  implements MenuItem.OnMenuItemClickListener
{
  private long qWP = -1L;
  
  public abstract void Ki();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ab.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.qWP != -1L)
    {
      long l = (System.nanoTime() - this.qWP) / 1000000L;
      if (l < 500L)
      {
        ab.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.qWP = System.nanoTime();
    Ki();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.u
 * JD-Core Version:    0.7.0.1
 */