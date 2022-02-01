package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Date;

public final class z
  extends c<xd>
  implements com.tencent.mm.al.g
{
  private xd AhD;
  private String AhE;
  
  public z()
  {
    AppMethodBeat.i(160876);
    this.AhE = null;
    this.__eventId = xd.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void ecm()
  {
    AppMethodBeat.i(70419);
    com.tencent.mm.plugin.wallet_core.d.e locale = s.ecg();
    x localx = new x();
    localx.field_bulletin_scene = this.AhE;
    if (!locale.get(localx, new String[0])) {
      ad.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.AhD.callback.run();
      this.AhD = null;
      AppMethodBeat.o(70419);
      return;
      this.AhD.dCD.dCE = localx.field_bulletin_scene;
      this.AhD.dCD.content = localx.field_bulletin_content;
      this.AhD.dCD.url = localx.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70420);
    ad.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjX, Long.valueOf(new Date().getTime()));
    ecm();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.z
 * JD-Core Version:    0.7.0.1
 */