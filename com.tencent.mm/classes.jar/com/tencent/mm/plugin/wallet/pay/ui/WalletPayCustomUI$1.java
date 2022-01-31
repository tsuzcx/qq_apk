package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.ui.p.b;
import com.tencent.mm.protocal.protobuf.ckm;

final class WalletPayCustomUI$1
  implements p.b
{
  WalletPayCustomUI$1(WalletPayCustomUI paramWalletPayCustomUI) {}
  
  public final void f(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(46009);
    int j = WalletPayCustomUI.a(this.tWl).xUs;
    String str1 = WalletPayCustomUI.a(this.tWl).xUr;
    String str2 = WalletPayCustomUI.a(this.tWl).sign;
    String str3 = WalletPayCustomUI.a(this.tWl).kwH;
    String str4 = WalletPayCustomUI.a(this.tWl).wYQ;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1 = new z(paramString1, j, str1, str2, str3, str4, i, paramString2, "");
      this.tWl.doSceneProgress(paramString1, true);
      AppMethodBeat.o(46009);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI.1
 * JD-Core Version:    0.7.0.1
 */