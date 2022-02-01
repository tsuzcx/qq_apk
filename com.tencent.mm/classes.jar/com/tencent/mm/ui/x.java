package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class x
  implements MenuItem.OnMenuItemClickListener
{
  private long zlx = -1L;
  
  public abstract void Zr();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ae.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.zlx != -1L)
    {
      long l = (System.nanoTime() - this.zlx) / 1000000L;
      if (l < 500L)
      {
        ae.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.zlx = System.nanoTime();
    Zr();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */