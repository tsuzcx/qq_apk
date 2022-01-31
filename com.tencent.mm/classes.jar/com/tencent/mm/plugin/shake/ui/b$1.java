package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24700);
    ab.v("MicroMsg.SayHiAdapter", "on delView clicked");
    this.qPt.jSe.bKl();
    if (this.qPt.pdU != null) {
      this.qPt.pdU.bC(paramView.getTag());
    }
    AppMethodBeat.o(24700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b.1
 * JD-Core Version:    0.7.0.1
 */