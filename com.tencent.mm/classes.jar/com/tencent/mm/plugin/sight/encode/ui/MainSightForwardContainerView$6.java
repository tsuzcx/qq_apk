package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class MainSightForwardContainerView$6
  implements b.a
{
  MainSightForwardContainerView$6(MainSightForwardContainerView paramMainSightForwardContainerView, List paramList) {}
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(28711);
    if ((this.yUD.size() <= 1) || (-1 == paramInt)) {
      h.cl(this.yUB.getContext(), this.yUB.getContext().getString(2131763075));
    }
    AppMethodBeat.o(28711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.6
 * JD-Core Version:    0.7.0.1
 */