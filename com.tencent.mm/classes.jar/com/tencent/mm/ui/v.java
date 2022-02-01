package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class v
  implements View.OnClickListener
{
  private long wvn = -1L;
  
  public abstract void bOU();
  
  public void onClick(View paramView)
  {
    ad.i("MicroMsg.MMCustomClickListener", "button onclick");
    if (this.wvn != -1L)
    {
      long l = (System.nanoTime() - this.wvn) / 1000000L;
      if (l < 3000L)
      {
        ad.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(3000L) });
        return;
      }
    }
    this.wvn = System.nanoTime();
    bOU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.v
 * JD-Core Version:    0.7.0.1
 */