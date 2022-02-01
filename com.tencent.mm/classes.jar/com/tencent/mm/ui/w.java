package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class w
  implements View.OnClickListener
{
  private long xGD = -1L;
  
  public abstract void bWk();
  
  public void onClick(View paramView)
  {
    ac.i("MicroMsg.MMCustomClickListener", "button onclick");
    if (this.xGD != -1L)
    {
      long l = (System.nanoTime() - this.xGD) / 1000000L;
      if (l < 3000L)
      {
        ac.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(3000L) });
        return;
      }
    }
    this.xGD = System.nanoTime();
    bWk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */