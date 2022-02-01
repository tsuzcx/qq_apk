package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class y
  implements MenuItem.OnMenuItemClickListener
{
  private long Dqp = -1L;
  
  public abstract void ane();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Log.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.Dqp != -1L)
    {
      long l = (System.nanoTime() - this.Dqp) / 1000000L;
      if (l < 500L)
      {
        Log.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.Dqp = System.nanoTime();
    ane();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.y
 * JD-Core Version:    0.7.0.1
 */