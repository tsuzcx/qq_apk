package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class d
  implements View.OnClickListener
{
  private View.OnClickListener ko;
  private long nJh = 0L;
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72961);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    long l = System.currentTimeMillis();
    if (l - this.nJh >= 500L)
    {
      this.ko.onClick(paramView);
      this.nJh = l;
    }
    a.a(this, "com/tencent/mm/wallet_core/ui/SafeOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(72961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */