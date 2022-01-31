package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.protocal.protobuf.bvz;

final class e$1
  implements o.a
{
  e$1(e.a parama, bvz parambvz, Context paramContext) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(48016);
    if (this.uyo != null)
    {
      e.a(this.val$context, this.uyp);
      this.uyo.a(this.uyp);
      AppMethodBeat.o(48016);
      return;
    }
    e.a(this.val$context, this.uyp);
    AppMethodBeat.o(48016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e.1
 * JD-Core Version:    0.7.0.1
 */