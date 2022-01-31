package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.av.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$17
  implements View.OnClickListener
{
  b$17(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40265);
    if ((paramView.getTag() instanceof String))
    {
      paramView = (String)paramView.getTag();
      ab.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramView)));
      ak.DP(v.abP(paramView));
      ak.DN(v.abP(paramView));
      ag.cpb().cnP();
      this.skd.cts();
      if (this.skd.sjY != null) {
        this.skd.sjY.cvZ();
      }
    }
    AppMethodBeat.o(40265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.17
 * JD-Core Version:    0.7.0.1
 */