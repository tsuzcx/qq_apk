package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class d
  implements View.OnClickListener
{
  private View.OnClickListener dpY;
  private long tQb = 0L;
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72961);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    long l = System.currentTimeMillis();
    if (l - this.tQb >= 500L)
    {
      this.dpY.onClick(paramView);
      this.tQb = l;
    }
    a.a(this, "com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */