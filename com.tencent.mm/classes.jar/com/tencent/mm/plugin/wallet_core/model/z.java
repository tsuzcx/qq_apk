package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.util.Date;

public final class z
  extends c<vd>
  implements f
{
  private vd ulm;
  private String uln;
  
  public z()
  {
    AppMethodBeat.i(46900);
    this.uln = null;
    this.__eventId = vd.class.getName().hashCode();
    AppMethodBeat.o(46900);
  }
  
  private void cTW()
  {
    AppMethodBeat.i(46901);
    d locald = t.cTR();
    w localw = new w();
    localw.field_bulletin_scene = this.uln;
    if (!locald.get(localw, new String[0])) {
      ab.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.ulm.callback.run();
      this.ulm = null;
      AppMethodBeat.o(46901);
      return;
      this.ulm.cLF.cLG = localw.field_bulletin_scene;
      this.ulm.cLF.content = localw.field_bulletin_content;
      this.ulm.cLF.url = localw.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46902);
    ab.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    g.RM();
    g.RK().eHt.b(385, this);
    g.RM();
    g.RL().Ru().set(ac.a.yBB, Long.valueOf(new Date().getTime()));
    cTW();
    AppMethodBeat.o(46902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.z
 * JD-Core Version:    0.7.0.1
 */