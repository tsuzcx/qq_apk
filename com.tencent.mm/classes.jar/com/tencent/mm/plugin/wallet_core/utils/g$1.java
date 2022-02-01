package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.cxk;

final class g$1
  implements q.a
{
  g$1(g.a parama, cxk paramcxk, Context paramContext) {}
  
  public final void dN(View paramView)
  {
    AppMethodBeat.i(71651);
    if (this.DFM != null)
    {
      g.a(this.val$context, this.Dty, null);
      this.DFM.a(this.Dty);
      AppMethodBeat.o(71651);
      return;
    }
    g.a(this.val$context, this.Dty, null);
    AppMethodBeat.o(71651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g.1
 * JD-Core Version:    0.7.0.1
 */