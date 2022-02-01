package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.ui.base.k;
import java.util.List;

final class MainSightForwardContainerView$6
  implements b.a
{
  MainSightForwardContainerView$6(MainSightForwardContainerView paramMainSightForwardContainerView, List paramList) {}
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(28711);
    if ((this.PIH.size() <= 1) || (-1 == paramInt)) {
      k.cZ(this.PIF.getContext(), this.PIF.getContext().getString(R.l.sendrequest_send_fail));
    }
    AppMethodBeat.o(28711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.6
 * JD-Core Version:    0.7.0.1
 */