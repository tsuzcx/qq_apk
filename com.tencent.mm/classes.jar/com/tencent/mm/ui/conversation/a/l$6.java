package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class l$6
  implements View.OnClickListener
{
  l$6(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34681);
    be.aaG().cs(this.bHS, this.yWR);
    d.H((Context)this.AmR.vUD.get(), "game", ".ui.GameCenterUI");
    h.qsU.e(11002, new Object[] { Integer.valueOf(9), Integer.valueOf(1) });
    AppMethodBeat.o(34681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.6
 * JD-Core Version:    0.7.0.1
 */