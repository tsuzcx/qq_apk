package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Date;

public final class aa
  extends IListener<zt>
  implements i
{
  private zt Ibh;
  private String mScene;
  
  public aa()
  {
    AppMethodBeat.i(160876);
    this.mScene = null;
    this.__eventId = zt.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void fQS()
  {
    AppMethodBeat.i(70419);
    com.tencent.mm.plugin.wallet_core.d.e locale = t.fQM();
    y localy = new y();
    localy.field_bulletin_scene = this.mScene;
    if (!locale.get(localy, new String[0])) {
      Log.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.Ibh.callback.run();
      this.Ibh = null;
      AppMethodBeat.o(70419);
      return;
      this.Ibh.efN.efO = localy.field_bulletin_scene;
      this.Ibh.efN.content = localy.field_bulletin_content;
      this.Ibh.efN.url = localy.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70420);
    Log.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    g.aAi();
    g.aAg().hqi.b(385, this);
    g.aAi();
    g.aAh().azQ().set(ar.a.NWD, Long.valueOf(new Date().getTime()));
    fQS();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */