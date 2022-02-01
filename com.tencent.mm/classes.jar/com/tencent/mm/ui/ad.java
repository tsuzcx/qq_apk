package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class ad
  implements MenuItem.OnMenuItemClickListener
{
  private long JqZ = -1L;
  
  public abstract void d(MenuItem paramMenuItem);
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Log.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.JqZ != -1L)
    {
      long l = (System.nanoTime() - this.JqZ) / 1000000L;
      if (l < 500L)
      {
        Log.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.JqZ = System.nanoTime();
    d(paramMenuItem);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ad
 * JD-Core Version:    0.7.0.1
 */