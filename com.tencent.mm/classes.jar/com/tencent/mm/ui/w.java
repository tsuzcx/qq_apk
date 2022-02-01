package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class w
  implements MenuItem.OnMenuItemClickListener
{
  private long wvn = -1L;
  
  public abstract void VR();
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ad.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
    if (this.wvn != -1L)
    {
      long l = (System.nanoTime() - this.wvn) / 1000000L;
      if (l < 500L)
      {
        ad.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(500L) });
        return false;
      }
    }
    this.wvn = System.nanoTime();
    VR();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */