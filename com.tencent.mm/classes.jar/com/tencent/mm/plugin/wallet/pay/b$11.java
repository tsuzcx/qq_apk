package com.tencent.mm.plugin.wallet.pay;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$11
  extends b.a
{
  b$11(b paramb, WalletBaseUI paramWalletBaseUI, i parami)
  {
    super(paramb, paramWalletBaseUI, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return super.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    if (b.a(this.qlV).getInt("key_pay_scene", 0) == 11)
    {
      Bundle localBundle = b.b(this.qlV);
      p.bTK();
      localBundle.putParcelable("key_history_bankcard", p.bTL().qze);
    }
    return super.s(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.11
 * JD-Core Version:    0.7.0.1
 */