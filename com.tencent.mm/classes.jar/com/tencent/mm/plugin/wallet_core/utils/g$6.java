package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.rg;

public final class g$6
  implements View.OnClickListener
{
  public g$6(Context paramContext, rg paramrg, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(71656);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/utils/WcPayViewEngineRender$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    g.a(this.val$context, this.DFO.FLp, null);
    if (this.DFP != null) {
      this.DFP.onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/wallet_core/utils/WcPayViewEngineRender$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(71656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g.6
 * JD-Core Version:    0.7.0.1
 */