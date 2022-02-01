package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class ab
  implements MenuItem.OnMenuItemClickListener
{
  private long DxT = -1L;
  
  public abstract void atf();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Log.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.DxT != -1L)
    {
      long l = (System.nanoTime() - this.DxT) / 1000000L;
      if (l < 500L)
      {
        Log.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.DxT = System.nanoTime();
    atf();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */