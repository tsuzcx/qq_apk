package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class t
  implements View.OnClickListener
{
  private long qWP = -1L;
  
  public abstract void bhX();
  
  public void onClick(View paramView)
  {
    ab.i("MicroMsg.MMCustomClickListener", "button onclick");
    if (this.qWP != -1L)
    {
      long l = (System.nanoTime() - this.qWP) / 1000000L;
      if (l < 3000L)
      {
        ab.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(3000L) });
        return;
      }
    }
    this.qWP = System.nanoTime();
    bhX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */