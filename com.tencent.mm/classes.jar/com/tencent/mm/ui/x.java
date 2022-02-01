package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class x
  implements MenuItem.OnMenuItemClickListener
{
  private long yVn = -1L;
  
  public abstract void Zi();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ad.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.yVn != -1L)
    {
      long l = (System.nanoTime() - this.yVn) / 1000000L;
      if (l < 500L)
      {
        ad.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.yVn = System.nanoTime();
    Zi();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */