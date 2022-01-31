package com.tencent.mm.plugin.wallet.balance;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$1
  extends g
{
  b$1(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    this.qfj.a(this.gfb, 0, this.qfj.kke);
    return true;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    paramVarArgs = null;
    Object localObject = b.a(this.qfj);
    p.bTK();
    ((Bundle)localObject).putParcelable("key_history_bankcard", p.bTL().qze);
    PayInfo localPayInfo = (PayInfo)this.qfj.kke.get("key_pay_info");
    if (a.bUG())
    {
      localObject = this.wBd;
      if (localPayInfo == null) {}
      for (paramVarArgs = null;; paramVarArgs = localPayInfo.bMX)
      {
        ((i)localObject).a(new v(paramVarArgs), true);
        return false;
      }
    }
    localObject = this.wBd;
    if (localPayInfo == null) {}
    for (;;)
    {
      ((i)localObject).a(new y(paramVarArgs, 4), true);
      break;
      paramVarArgs = localPayInfo.bMX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.b.1
 * JD-Core Version:    0.7.0.1
 */