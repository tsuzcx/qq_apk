package com.tencent.mm.plugin.wallet_core.utils;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class g$2
  implements View.OnClickListener
{
  public g$2(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71652);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/utils/WcPayViewEngineRender$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.xZb.isShowing()) {
      this.xZb.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/utils/WcPayViewEngineRender$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g.2
 * JD-Core Version:    0.7.0.1
 */