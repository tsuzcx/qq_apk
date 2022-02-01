package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Date;

public final class aa
  extends c<yi>
  implements f
{
  private yi Daq;
  private String Dar;
  
  public aa()
  {
    AppMethodBeat.i(160876);
    this.Dar = null;
    this.__eventId = yi.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void eFI()
  {
    AppMethodBeat.i(70419);
    com.tencent.mm.plugin.wallet_core.d.e locale = t.eFC();
    y localy = new y();
    localy.field_bulletin_scene = this.Dar;
    if (!locale.get(localy, new String[0])) {
      ad.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.Daq.callback.run();
      this.Daq = null;
      AppMethodBeat.o(70419);
      return;
      this.Daq.dMC.dMD = localy.field_bulletin_scene;
      this.Daq.dMC.content = localy.field_bulletin_content;
      this.Daq.dMC.url = localy.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70420);
    ad.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    g.ajD();
    g.ajB().gAO.b(385, this);
    g.ajD();
    g.ajC().ajl().set(al.a.Iue, Long.valueOf(new Date().getTime()));
    eFI();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */