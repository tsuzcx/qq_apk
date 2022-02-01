package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Date;

public final class ab
  extends IListener<aba>
  implements i
{
  private aba OTs;
  private String mScene;
  
  public ab()
  {
    AppMethodBeat.i(160876);
    this.mScene = null;
    this.__eventId = aba.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void gJy()
  {
    AppMethodBeat.i(70419);
    e locale = u.gJs();
    z localz = new z();
    localz.field_bulletin_scene = this.mScene;
    if (!locale.get(localz, new String[0])) {
      Log.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      this.OTs.callback.run();
      this.OTs = null;
      AppMethodBeat.o(70419);
      return;
      this.OTs.gad.gae = localz.field_bulletin_scene;
      this.OTs.gad.content = localz.field_bulletin_content;
      this.OTs.gad.url = localz.field_bulletin_url;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70420);
    Log.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    h.aHH();
    h.aHF().kcd.b(385, this);
    h.aHH();
    h.aHG().aHp().set(ar.a.VkD, Long.valueOf(new Date().getTime()));
    gJy();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */