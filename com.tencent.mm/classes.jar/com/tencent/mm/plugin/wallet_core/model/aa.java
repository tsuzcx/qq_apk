package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Date;

public final class aa
  extends c<yo>
  implements f
{
  private yo DrV;
  private String DrW;
  
  public aa()
  {
    AppMethodBeat.i(160876);
    this.DrW = null;
    this.__eventId = yo.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void eJp()
  {
    AppMethodBeat.i(70419);
    com.tencent.mm.plugin.wallet_core.d.e locale = t.eJj();
    y localy = new y();
    localy.field_bulletin_scene = this.DrW;
    if (!locale.get(localy, new String[0])) {
      ae.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.DrV.callback.run();
      this.DrV = null;
      AppMethodBeat.o(70419);
      return;
      this.DrV.dNS.dNT = localy.field_bulletin_scene;
      this.DrV.dNS.content = localy.field_bulletin_content;
      this.DrV.dNS.url = localy.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70420);
    ae.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    g.ajS();
    g.ajQ().gDv.b(385, this);
    g.ajS();
    g.ajR().ajA().set(am.a.IOB, Long.valueOf(new Date().getTime()));
    eJp();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */