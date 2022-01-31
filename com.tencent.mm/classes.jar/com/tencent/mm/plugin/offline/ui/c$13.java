package com.tencent.mm.plugin.offline.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.q.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class c$13
  implements q.c
{
  c$13(c paramc, s.g paramg) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(43483);
    if ((this.pmw.mActivity instanceof MMActivity)) {
      ((MMActivity)this.pmw.mActivity).hideVKB();
    }
    if (this.pmw.pmr != null) {
      this.pmw.pmr.e(1, this.pmx.id, paramString, this.pmx.cwk);
    }
    ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
    AppMethodBeat.o(43483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.13
 * JD-Core Version:    0.7.0.1
 */