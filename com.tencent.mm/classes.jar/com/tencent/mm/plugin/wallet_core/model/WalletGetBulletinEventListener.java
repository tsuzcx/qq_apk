package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.a;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Date;

public class WalletGetBulletinEventListener
  extends IListener<acx>
  implements com.tencent.mm.am.h
{
  private acx VJz;
  private String mScene;
  
  public WalletGetBulletinEventListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(160876);
    this.mScene = null;
    this.__eventId = acx.class.getName().hashCode();
    AppMethodBeat.o(160876);
  }
  
  private void iiM()
  {
    AppMethodBeat.i(70419);
    e locale = u.iiG();
    z localz = new z();
    localz.field_bulletin_scene = this.mScene;
    if (!locale.get(localz, new String[0])) {
      Log.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
    }
    for (;;)
    {
      if (this.VJz.callback != null) {
        this.VJz.callback.run();
      }
      if (this.VJz.igk.callback != null) {
        this.VJz.igk.callback.run();
      }
      this.VJz = null;
      AppMethodBeat.o(70419);
      return;
      this.VJz.igl.igm = localz.field_bulletin_scene;
      this.VJz.igl.content = localz.field_bulletin_content;
      this.VJz.igl.url = localz.field_bulletin_url;
      this.VJz.igl.type = localz.field_type;
      if (localz.field_type == 2)
      {
        this.VJz.igl.ign = new dus();
        this.VJz.igl.ign.abaE = localz.field_is_show_notice;
        this.VJz.igl.ign.left_icon = localz.field_left_icon;
        this.VJz.igl.ign.jump_url = localz.field_jump_url;
        this.VJz.igl.ign.wording = localz.field_wording;
        this.VJz.igl.ign.YSS = localz.field_notice_id;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70420);
    Log.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + paramInt1 + ";errCode=" + paramInt2);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acLX, Long.valueOf(new Date().getTime()));
    iiM();
    AppMethodBeat.o(70420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.WalletGetBulletinEventListener
 * JD-Core Version:    0.7.0.1
 */