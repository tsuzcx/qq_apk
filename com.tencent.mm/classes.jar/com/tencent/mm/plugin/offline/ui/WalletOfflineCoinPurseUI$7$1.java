package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletOfflineCoinPurseUI$7$1
  implements a.a
{
  WalletOfflineCoinPurseUI$7$1(WalletOfflineCoinPurseUI.7 param7) {}
  
  public final boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(43510);
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString + ";hadAgree = " + paramBoolean);
    if (paramInt1 == 2)
    {
      paramString = new f("collect");
      this.pnH.pny.doSceneProgress(paramString, false);
    }
    for (;;)
    {
      AppMethodBeat.o(43510);
      return true;
      if ((paramInt1 == 0) && (paramBoolean))
      {
        paramString = new f("collect");
        this.pnH.pny.doSceneProgress(paramString, false);
      }
      else if (WalletOfflineCoinPurseUI.o(this.pnH.pny) != null)
      {
        WalletOfflineCoinPurseUI.o(this.pnH.pny).dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.7.1
 * JD-Core Version:    0.7.0.1
 */