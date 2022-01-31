package com.tencent.mm.plugin.sns.ui;

import android.util.Base64;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsSightPlayerUI$9
  implements e.a
{
  SnsSightPlayerUI$9(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void Es()
  {
    AppMethodBeat.i(39262);
    ab.d("MicroMsg.SnsSightPlayerUI", "on completion");
    if (!SnsSightPlayerUI.j(this.rVT)) {
      SnsSightPlayerUI.k(this.rVT).post(new SnsSightPlayerUI.9.2(this));
    }
    SnsSightPlayerUI.g(this.rVT).setLoop(true);
    com.tencent.mm.plugin.sns.a.b.a.a locala = SnsSightPlayerUI.l(this.rVT).qZJ;
    locala.raI += 1;
    SnsSightPlayerUI.a(this.rVT, false);
    AppMethodBeat.o(39262);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(39260);
    ab.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.Mk() + " onPrepared");
    SnsSightPlayerUI.a(this.rVT, true);
    AppMethodBeat.o(39260);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39261);
    ab.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    SnsSightPlayerUI.g(this.rVT).stop();
    if (SnsSightPlayerUI.h(this.rVT))
    {
      AppMethodBeat.o(39261);
      return;
    }
    SnsSightPlayerUI.i(this.rVT);
    b.G(Base64.encodeToString((d.cmw() + "[SnsSightPlayerUI] on play video error, what " + paramInt1 + " extra " + paramInt2 + ", path=" + bo.bf(SnsSightPlayerUI.e(this.rVT), "")).getBytes(), 2), "FullScreenPlaySight");
    String str = SnsSightPlayerUI.e(this.rVT);
    al.d(new SnsSightPlayerUI.9.1(this, o.ahC().a(str, com.tencent.mm.cb.a.getDensity(this.rVT.getContext()), this.rVT.getContext(), -1), str));
    AppMethodBeat.o(39261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9
 * JD-Core Version:    0.7.0.1
 */