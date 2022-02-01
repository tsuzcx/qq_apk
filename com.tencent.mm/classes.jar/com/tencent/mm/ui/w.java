package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class w
  implements View.OnClickListener
{
  private long zlx = -1L;
  
  public abstract void ccc();
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.MMCustomClickListener", "button onclick");
    if (this.zlx != -1L)
    {
      long l = (System.nanoTime() - this.zlx) / 1000000L;
      if (l < 3000L)
      {
        ae.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[] { Long.valueOf(l), Long.valueOf(3000L) });
        a.a(this, "com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        return;
      }
    }
    this.zlx = System.nanoTime();
    ccc();
    a.a(this, "com/tencent/mm/ui/MMCustomClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.w
 * JD-Core Version:    0.7.0.1
 */