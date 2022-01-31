package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class c$13
  implements o.c
{
  c$13(c paramc, s.g paramg) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    if ((this.mMg.mActivity instanceof MMActivity)) {
      ((MMActivity)this.mMg.mActivity).XM();
    }
    if (this.mMg.mMb != null) {
      this.mMg.mMb.d(1, this.mMh.id, paramString, this.mMh.bOT);
    }
    y.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.13
 * JD-Core Version:    0.7.0.1
 */