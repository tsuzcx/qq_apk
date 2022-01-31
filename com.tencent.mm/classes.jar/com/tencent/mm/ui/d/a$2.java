package com.tencent.mm.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29990);
    ab.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
    this.zhh.Ox(2);
    aw.aaz().Za().c(b.b.fou);
    aw.aaz().Za().c(b.b.fow);
    this.zhh.setVisibility(8);
    AppMethodBeat.o(29990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.d.a.2
 * JD-Core Version:    0.7.0.1
 */