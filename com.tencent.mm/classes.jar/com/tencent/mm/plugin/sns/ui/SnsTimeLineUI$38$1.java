package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class SnsTimeLineUI$38$1
  implements Runnable
{
  SnsTimeLineUI$38$1(SnsTimeLineUI.38 param38) {}
  
  public final void run()
  {
    AppMethodBeat.i(155749);
    if ((SnsTimeLineUI.a(this.rYK.rYv) == null) || (SnsTimeLineUI.G(this.rYK.rYv) == null))
    {
      ab.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
      AppMethodBeat.o(155749);
      return;
    }
    SnsTimeLineUI.G(this.rYK.rYv).setListener(null);
    SnsTimeLineUI.a(this.rYK.rYv, SnsTimeLineUI.L(this.rYK.rYv));
    if (SnsTimeLineUI.M(this.rYK.rYv))
    {
      ab.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
      AppMethodBeat.o(155749);
      return;
    }
    if (SnsTimeLineUI.C(this.rYK.rYv)) {
      ag.coV().E(ag.cpm().rig, -1);
    }
    if (!SnsTimeLineUI.C(this.rYK.rYv))
    {
      ab.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
      c localc = SnsTimeLineUI.q(this.rYK.rYv);
      SnsTimeLineUI.m(this.rYK.rYv);
      localc.d(SnsTimeLineUI.n(this.rYK.rYv), SnsTimeLineUI.o(this.rYK.rYv), SnsTimeLineUI.p(this.rYK.rYv), SnsTimeLineUI.z(this.rYK.rYv));
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLj, Integer.valueOf(1));
    }
    SnsTimeLineUI.a(this.rYK.rYv, false);
    if (this.rYK.rYv.rOU != null) {
      this.rYK.rYv.rOU.kZ(false);
    }
    AppMethodBeat.o(155749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.38.1
 * JD-Core Version:    0.7.0.1
 */