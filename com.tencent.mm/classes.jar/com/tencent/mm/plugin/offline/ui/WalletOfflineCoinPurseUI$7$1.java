package com.tencent.mm.plugin.offline.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletOfflineCoinPurseUI$7$1
  implements a.a
{
  WalletOfflineCoinPurseUI$7$1(WalletOfflineCoinPurseUI.7 param7) {}
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString + ";hadAgree = " + paramBoolean);
    if (paramInt1 == 2)
    {
      paramString = new f("collect");
      this.mNs.mNj.a(paramString, false, false);
    }
    for (;;)
    {
      return true;
      if ((paramInt1 == 0) && (paramBoolean))
      {
        paramString = new f("collect");
        this.mNs.mNj.a(paramString, false, false);
      }
      else if (WalletOfflineCoinPurseUI.o(this.mNs.mNj) != null)
      {
        WalletOfflineCoinPurseUI.o(this.mNs.mNj).dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.7.1
 * JD-Core Version:    0.7.0.1
 */