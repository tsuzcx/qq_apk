package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class x
  implements View.OnClickListener
{
  private long Dqp = -1L;
  
  public abstract void czW();
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.MMCustomClickListener", "button onclick");
    if (this.Dqp != -1L)
    {
      long l = (System.nanoTime() - this.Dqp) / 1000000L;
      if (l < 3000L)
      {
        Log.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(3000L) });
        a.a(this, "com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        return;
      }
    }
    this.Dqp = System.nanoTime();
    czW();
    a.a(this, "com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */