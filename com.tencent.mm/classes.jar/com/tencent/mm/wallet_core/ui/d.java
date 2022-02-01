package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class d
  implements View.OnClickListener
{
  private View.OnClickListener km;
  private long mtj = 0L;
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72961);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    long l = System.currentTimeMillis();
    if (l - this.mtj >= 500L)
    {
      this.km.onClick(paramView);
      this.mtj = l;
    }
    a.a(this, "com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */