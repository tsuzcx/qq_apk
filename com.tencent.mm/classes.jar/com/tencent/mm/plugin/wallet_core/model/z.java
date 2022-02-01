package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Date;

public final class z
  extends c<xo>
  implements com.tencent.mm.ak.g
{
  private xo BzX;
  private String BzY;
  
  public z()
  {
    AppMethodBeat.i(160876);
    this.BzY = null;
    this.__eventId = xo.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void erI()
  {
    AppMethodBeat.i(70419);
    com.tencent.mm.plugin.wallet_core.d.e locale = s.erC();
    x localx = new x();
    localx.field_bulletin_scene = this.BzY;
    if (!locale.get(localx, new String[0])) {
      ac.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.BzX.callback.run();
      this.BzX = null;
      AppMethodBeat.o(70419);
      return;
      this.BzX.dAp.dAq = localx.field_bulletin_scene;
      this.BzX.dAp.content = localx.field_bulletin_content;
      this.BzX.dAp.url = localx.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70420);
    ac.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHM, Long.valueOf(new Date().getTime()));
    erI();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.z
 * JD-Core Version:    0.7.0.1
 */